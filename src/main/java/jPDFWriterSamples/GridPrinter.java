package jPDFWriterSamples;

import java.awt.*;
import java.awt.print.*;
import java.util.*;
import javax.swing.*;

import com.qoppa.pdfWriter.*;

/**
 * Insert the type's description here.
 * Creation date: (3/19/2002 3:51:40 PM)
 * @author: InterCAT Administrator
 */
public class GridPrinter implements Printable, Runnable
{
	private JTable m_Table;
	private boolean m_FitToPage;
	private boolean m_CancelPressed;

	private PrinterJob m_PrinterJob;
	private PageFormat m_PageFormat;
	private Vector m_GridPages;
	private double m_Scale;

	private Graphics m_PrintGraphics;
	private Component m_PrintComponent;
/**
 * GridPrinter constructor comment.
 */
public GridPrinter (JTable table, boolean fitToPage)
{
	super();

	m_Table = table;
	m_FitToPage = fitToPage;
	m_CancelPressed = false;
}
/**
 * Insert the method's description here.
 * Creation date: (3/22/2002 5:06:52 PM)
 * @return java.util.Vector
 * @param printerJob java.awt.print.PrinterJob
 */
private Vector buildPageVector(PrinterJob printerJob)
{
	// Calculate row header width
	int rowHeaderWidth = 0;
	if (m_Table.getParent ().getParent () instanceof JScrollPane)
	{
		JScrollPane scrollPane = (JScrollPane)m_Table.getParent ().getParent ();
		if (scrollPane.getRowHeader() != null)
		{
			rowHeaderWidth = scrollPane.getRowHeader().getWidth();
		}
	}
	
	//
	// Calculate scale
	//
	m_Scale = 1.0;
	if (m_FitToPage)
	{
		if (m_Table.getColumnModel().getTotalColumnWidth() >= m_PageFormat.getImageableWidth())
		{
			m_Scale = m_PageFormat.getImageableWidth() / (m_Table.getColumnModel().getTotalColumnWidth() + rowHeaderWidth);
		}
	}

	//
	// Calculate various areas before scaling
	//

	// Printable area rectangle
	Rectangle pageRect = new Rectangle ((int)(m_PageFormat.getImageableX() / m_Scale), 
										(int)(m_PageFormat.getImageableY() / m_Scale),
										(int)(m_PageFormat.getImageableWidth() / m_Scale),
										(int)(m_PageFormat.getImageableHeight() / m_Scale));

	// Table rectangle
	Rectangle tableRect = new Rectangle (pageRect);

	// Grid rectangle (table without the table header)
	Rectangle gridRect = new Rectangle (tableRect.x, tableRect.y + m_Table.getTableHeader().getHeight(),
										tableRect.width, tableRect.height - m_Table.getTableHeader().getHeight());

	// Adjust the grid rectangle if there is a row header
	gridRect.x += rowHeaderWidth;
	gridRect.width -= rowHeaderWidth;
	
	// Calculate table related sizes
	int numRowsOnAPage = (gridRect.height / m_Table.getRowHeight());
	int gridPrintHeight = (numRowsOnAPage * m_Table.getRowHeight());
	int currentColumn = 0;
	int clipWidth = 0;
	int shiftX = 0;
	
	Vector pageVector = new Vector ();
	while (currentColumn < m_Table.getColumnCount())
	{
		int currentPage = 0;

		// Calculate clip width for this column of pages
		if (m_FitToPage)
		{
			clipWidth = pageRect.width;
			currentColumn += m_Table.getColumnCount();
		}
		else
		{
			shiftX += clipWidth;
			clipWidth = 0;

			while (currentColumn < m_Table.getColumnCount() && 
					clipWidth + m_Table.getColumnModel().getColumn(currentColumn).getWidth() < gridRect.width)
			{
				clipWidth += m_Table.getColumnModel().getColumn(currentColumn).getWidth();
				++currentColumn;
			}
		}
		
		while (numRowsOnAPage * currentPage < m_Table.getRowCount())
		{
			GridPrinterPageInfo gppiPage = new GridPrinterPageInfo ();
			gppiPage.m_GridPrintWidth = clipWidth;
			gppiPage.m_GridPrintHeight = gridPrintHeight;
			gppiPage.m_TranslateX = gridRect.x - shiftX;
			gppiPage.m_TranslateY = gridRect.y - (gridPrintHeight * currentPage);
			gppiPage.m_ClipX = shiftX;
			gppiPage.m_ClipY = gridPrintHeight * currentPage;

			gppiPage.m_GridRect = gridRect;
			gppiPage.m_TableRect = tableRect;
			gppiPage.m_PageRect = pageRect;

			pageVector.addElement (gppiPage);
			++currentPage;
		}
	}

	return pageVector;
}
/**
 * Insert the method's description here.
 * Creation date: (3/26/2002 4:46:47 PM)
 * @return java.awt.print.PageFormat
 */
public PageFormat getDefaultPage (int orientation) 
{
	Paper paper = new Paper ();
	paper.setImageableArea (0.5 * 72, 0.5 * 72, 7.5 * 72, 10 * 72);
	PageFormat pageFormat = new PageFormat ();
	pageFormat.setPaper (paper);
	pageFormat.setOrientation (orientation);

	return pageFormat;
}
// Prints table so that width of table fits page width
public int print (Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException 
{
	try
	{
		if (m_CancelPressed || pageIndex >= m_GridPages.size())
		{
			return Printable.NO_SUCH_PAGE;
		}

		// Update progress dialog
		GridPrinterPageInfo gppiPage = (GridPrinterPageInfo)m_GridPages.elementAt (pageIndex);

		// set the scale
		Graphics2D g2 = (Graphics2D) g;
		g2.scale (m_Scale, m_Scale);
		
		// Set up the graphics object and print the grid
		g2.translate (gppiPage.m_TranslateX, gppiPage.m_TranslateY);
		g2.setClip (gppiPage.m_ClipX, gppiPage.m_ClipY, 
					gppiPage.m_GridPrintWidth, gppiPage.m_GridPrintHeight);
		printComponent (m_Table, g2);
		g2.setPaint (m_Table.getGridColor());
		
		// Draw left vertical line (table doesn't do this!) and translate back to normal
		g2.drawLine (gppiPage.m_ClipX, gppiPage.m_ClipY, gppiPage.m_ClipX, 
						Math.min (gppiPage.m_ClipY + gppiPage.m_GridPrintHeight, m_Table.getHeight ()) - 1);
		g2.translate (-gppiPage.m_TranslateX, -gppiPage.m_TranslateY);

		// Set up graphics object and print the table header
		g2.translate (gppiPage.m_TranslateX, gppiPage.m_TableRect.y);
		g2.setClip (gppiPage.m_ClipX, 0, gppiPage.m_GridPrintWidth, m_Table.getTableHeader().getHeight());
		printComponent (m_Table.getTableHeader (), g2);
		g2.translate (-gppiPage.m_TranslateX, -gppiPage.m_TableRect.y);

		// Set up graphics object and print the row header
		if (m_Table.getParent ().getParent () instanceof JScrollPane)
		{
			JScrollPane scrollPane = (JScrollPane)m_Table.getParent ().getParent ();
			if (scrollPane.getRowHeader () != null)
			{
				g2.translate (gppiPage.m_TableRect.x, gppiPage.m_TranslateY);
				g2.setClip (0, gppiPage.m_ClipY, scrollPane.getRowHeader ().getWidth (), gppiPage.m_GridPrintHeight);
				printComponent (scrollPane.getRowHeader().getView(), g2);

				if (scrollPane.getCorner (JScrollPane.UPPER_LEFT_CORNER) != null)
				{
					g2.translate (0, -m_Table.getTableHeader ().getHeight ());
					g2.setClip (0, 0, 
								scrollPane.getCorner (JScrollPane.UPPER_LEFT_CORNER).getWidth(), 
								scrollPane.getCorner (JScrollPane.UPPER_LEFT_CORNER).getHeight ());
					printComponent (scrollPane.getCorner (JScrollPane.UPPER_LEFT_CORNER), g2);
				}
			}
		}

		return Printable.PAGE_EXISTS;
	}
	catch (Throwable t)
	{
		throw new PrinterException (t.getMessage());
	}
}
/**
 * This method was created in VisualAge.
 */
public void print (PageFormat pageFormat) throws PrinterException
{
	m_PrinterJob = PDFPrinterJob.getPrinterJob();
	if (m_PrinterJob == null)
	{
		throw new PrinterException ("Unable to start print job.");
	}

	m_PageFormat = m_PrinterJob.pageDialog(pageFormat);
	boolean pd = m_PrinterJob.printDialog();
	if (pd)
	{
		m_PrinterJob.setPrintable(this, m_PageFormat);
		m_GridPages = buildPageVector (m_PrinterJob);
		m_PrinterJob.print();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (5/1/2002 4:47:10 PM)
 * @param c java.awt.Component
 */
private void printComponent(Component c, Graphics g) throws PrinterException
{
	//
	// Need to call component's print method in the swing thread as
	// swing is not reentrant and we're running in an independent thread
	//
	
	m_PrintGraphics = g;
	m_PrintComponent = c;

	run ();
}
/**
 * Insert the method's description here.
 * Creation date: (5/1/2002 6:06:16 PM)
 */
public void run() 
{
	m_PrintComponent.print (m_PrintGraphics);
}
}
