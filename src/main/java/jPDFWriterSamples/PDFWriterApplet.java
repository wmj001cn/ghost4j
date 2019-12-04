package jPDFWriterSamples;

import javax.swing.JApplet;

/**
 * @author Gerald Holmann
 *
 */
public class PDFWriterApplet extends JApplet
{
	/**
	 * Initialize the applet.
	 */
	public void init() 
	{
        // look and feel
        PDFWriterSample.setLookAndFeel();

        // Set the size
        setSize(700, 700);

        // Create sample panel and set as content pane
        PDFWriterSample samplePanel = new PDFWriterSample();
        samplePanel.getjpAPI().setVisible(false);
        setContentPane(samplePanel);
	}
}