Core API samples
================

This section shows some code examples of the core API.

#### Convert Postscript file to PDF

	package org.ghost4j.example;
	
	import org.ghost4j.Ghostscript;
	import org.ghost4j.GhostscriptException;
	
	/**
	 * Example showing how to convert a Postscript file to PDF.
	 * @author Gilles Grousset (gi.grousset@gmail.com)
	 */
	public class PDFConvertExample {
	
	     public static void main(String[] args) {
	
	        //get Ghostscript instance
	        Ghostscript gs = Ghostscript.getInstance();
	
	        //prepare Ghostscript interpreter parameters
	        //refer to Ghostscript documentation for parameter usage
	        String[] gsArgs = new String[10];
	        gsArgs[0] = "-ps2pdf";
	        gsArgs[1] = "-dNOPAUSE";
	        gsArgs[2] = "-dBATCH";
	        gsArgs[3] = "-dSAFER";
	        gsArgs[4] = "-sDEVICE=pdfwrite";
	        gsArgs[5] = "-sOutputFile=output.pdf";
	        gsArgs[6] = "-c";
	        gsArgs[7] = ".setpdfwrite";
	        gsArgs[8] = "-f";
	        gsArgs[9] = "input.ps";
	
	        //execute and exit interpreter
	        try {
	
	            gs.initialize(gsArgs);
	            gs.exit();
	
	        } catch (GhostscriptException e) {
	            System.out.println("ERROR: " + e.getMessage());
	        }
	     }
	
	}

#### Display callback

	package org.ghost4j.example;
	
	import java.awt.image.RenderedImage;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
	
	import org.ghost4j.Ghostscript;
	import org.ghost4j.GhostscriptException;
	import org.ghost4j.display.ImageWriterDisplayCallback;
	
	/**
	 * Example showing how to setup a display callback (to interract with the display) for the Ghostscript interpreter.
	 * In this example, a simple ImageWriterDisplayCallback is used as callback: it converts page rasters into images and stores them.
	 * @author Gilles Grousset (gi.grousset@gmail.com)
	 */
	public class DisplayCallbackExample {
	
	    public static void main(String[] args) {
	
	        //get Ghostscript instance
	        Ghostscript gs = Ghostscript.getInstance();
	
	        //create display callback (capture display output pages as images)
	        ImageWriterDisplayCallback displayCallback = new ImageWriterDisplayCallback();
	
	        //set display callback
	        gs.setDisplayCallback(displayCallback);
	
	        //prepare Ghostscript interpreter parameters with display device
	        String[] gsArgs = new String[7];
	        gsArgs[0] = "-dQUIET";
	        gsArgs[1] = "-dNOPAUSE";
	        gsArgs[2] = "-dBATCH";
	        gsArgs[3] = "-dSAFER";
	        gsArgs[4] = "-sDEVICE=display";
	        gsArgs[5] = "-sDisplayHandle=0";
	        gsArgs[6] = "-dDisplayFormat=16#804";
	
	        //run PostScript (also works with PDF) and exit interpreter
	        try {
	
	            gs.initialize(gsArgs);
	            gs.runFile("input.ps");
	            gs.exit();
	
	        } catch (GhostscriptException e) {
	            System.out.println("ERROR: " + e.getMessage());
	        }
	
	        //write images captured by the display callback to the disk in PNG format
	        try {
	            for (int i = 0; i < displayCallback.getImages().size(); i++) {
	                ImageIO.write((RenderedImage) displayCallback.getImages().get(i), "png", new File((i + 1) + ".png"));
	            }
	        } catch (IOException e) {
	            System.out.println("ERROR: " + e.getMessage());
	        }
	
	    }
	}
