package jPDFWriterSamples;

import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;

import com.qoppa.pdfWriter.PDFDocument;


/**
 * @author Gerald Holmann
 *
 */
public class PDFWriterFrame extends JFrame
{
	public PDFWriterFrame() 
    {
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        PDFWriterSample samplePanel = new PDFWriterSample();
        this.setContentPane(samplePanel);
        this.setSize(683, 790);
        DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
        this.setLocation ((dm.getWidth() - 683) / 2, (dm.getHeight() - 790) / 2);
        this.setTitle("jPDFWriter Sample - " + PDFDocument.getVersion());
        
        try
		{
    		// Try to set multiple images, java 1.6 only
			Method setIconImages = this.getClass().getMethod("setIconImages", new Class[] {List.class});
			Vector imageList = new Vector();
			imageList.add(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jPDFWriter16.png")));
			imageList.add(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jPDFWriter32.png")));
			setIconImages.invoke(this, new Object[] {imageList});
		}
		catch (Throwable t1)
		{
			try
	        {
	            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jPDFWriter16.png")));
	        }
	        catch(Throwable t2)
	        {
	            // ignore
	        }
		}
	}
	
	
	public static void  main (String [] args)
	{
		try
		{
			// Create a log file in the user's home directory
			File outFile = new File(System.getProperty("user.home") + File.separator + "jpdfwriter.log");
			PrintStream out = new PrintStream(new FileOutputStream(outFile));
			System.setOut(out);
			System.setErr(out);
		}
		catch (Throwable t)
		{
			// Do nothing, continue without log file
		}
		
        // look and feel
        PDFWriterSample.setLookAndFeel();

        // Create and show Frame
        PDFWriterFrame frame = new PDFWriterFrame ();
	    frame.setVisible(true);
	}
}