package jPDFWriterSamples;

import java.awt.*;

/**
 * Insert the type's description here.
 * Creation date: (3/22/2002 5:04:22 PM)
 * @author: InterCAT Administrator
 */
public class GridPrinterPageInfo 
{
	public int m_TranslateX;
	public int m_TranslateY;
	public int m_ClipX;
	public int m_ClipY;

	public int m_GridPrintHeight;
	public int m_GridPrintWidth;
	public Rectangle m_GridRect;
	public Rectangle m_TableRect;
	public Rectangle m_PageRect;
/**
 * GridPrinterPageInfo constructor comment.
 */
public GridPrinterPageInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (3/25/2002 11:34:19 AM)
 * @return java.lang.String
 */
public String toString()
{
	return "[ClipX = " + m_ClipX + ", ClipY = " + m_ClipY + "TranslateX = " + m_TranslateX + ", TranslateY = " + m_TranslateY + ", GridPrintWidth = " + m_GridPrintWidth + ", GridPrintHeight = " + m_GridPrintHeight + "]" +
			"\n[GridRect = " + m_GridRect + ", TableRect = " + m_TableRect + ", PageRect = " + m_PageRect + "]";
}
}
