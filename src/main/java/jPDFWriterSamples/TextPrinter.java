/**
 * Qoppa Software - Source Code Sample
 */
package jPDFWriterSamples;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.FileReader;
import java.util.Vector;

import com.qoppa.pdfWriter.PDFPrinterJob;

public class TextPrinter implements Printable
{
	private int m_CurrentPage;
	private int m_CurrentPageStartLine;
	private int m_CurrentPageEndLine;
	private Vector m_Lines;

	public static void main (String [] args)
	{
        try
        {
    	    // Load a text file into a string
    	    FileReader inputFile = new FileReader ("input.txt");
    	    StringBuffer fileContent = new StringBuffer ();
    	    char [] buffer = new char [256];
    	    int charsRead = inputFile.read(buffer);
    	    while (charsRead > 0)
    	    {
    	        fileContent.append(buffer, 0, charsRead);
    	        charsRead = inputFile.read (buffer);
    	    }
    	    
    	    // Create object to print the text
    		TextPrinter textPrinter = new TextPrinter (fileContent);
    		
    		// Create a PDF printer job and print the text to it
    		PrinterJob printerJob = PDFPrinterJob.getPrinterJob();
    		printerJob.setPrintable(textPrinter);
			printerJob.print();
		}
		catch (Throwable t)
		{
		    t.printStackTrace();
		}
		
		// Exit
		System.exit(0);
	}
	
	
	public TextPrinter (StringBuffer printString)
	{
		// Break up the string into lines
		int currentIndex = 0;
		m_Lines = new Vector ();
		
		do
		{
			String nextLine = null;
			int endOfLine = printString.indexOf("\n", currentIndex);
			if (endOfLine == -1)
			{
				nextLine = printString.substring (currentIndex);
				currentIndex = -1;
			}
			else
			{
				nextLine = printString.substring (currentIndex, endOfLine);
				currentIndex = endOfLine + 1;
			}
			m_Lines.addElement (nextLine);
		} while (currentIndex != -1);
	}

	
	public int print (Graphics g, PageFormat pf, int pageIndex)
	{
		int lineHeight = g.getFontMetrics().getHeight();
		
		// Reset current pos
		int currentLine = 0;
		if (pageIndex == 0)
		{
			// Need to do this in case the instance of this class
			// gets used multiple times to print a string
			m_CurrentPage = 0;
			m_CurrentPageStartLine = 0;
		}
		// Need to do this because Java PrinterJob can call this
		// method multiple times for the same page;
		else if (m_CurrentPage == pageIndex)
		{
			currentLine = m_CurrentPageStartLine;
		}
		else
		{
			currentLine = m_CurrentPageEndLine + 1;
			m_CurrentPageStartLine = currentLine;
		}
		
		// If we're out of lines, tell the PrinterJob we're done
		if (currentLine >= m_Lines.size())
		{
			return Printable.NO_SUCH_PAGE;
		}
		
		// Loop through lines until we fill the page
		double currentY = pf.getImageableY() + lineHeight;
		while (currentLine < m_Lines.size() && 
				currentY + lineHeight < pf.getImageableY() + pf.getImageableHeight())
		{
			// Draw the next line
			String nextLine = (String)m_Lines.elementAt (currentLine);
			g.drawString (nextLine, (int)pf.getImageableX(), (int)currentY);
			
			// Advance to the next line
			++currentLine;
			currentY += lineHeight;
		}
		
		// Save the ned line and current page
		// Again, we have to do this because of multiple calls for the same page.
		m_CurrentPageEndLine = currentLine;
		m_CurrentPage = pageIndex;

		return Printable.PAGE_EXISTS;
	}
}
