/**
 * Qoppa Software - Source Code Sample
 */
package jPDFWriterSamples;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.ghost4j.document.PaperSize;
public class GMCAlternatives
{
    public static void main (String [] args) throws IOException
    {
    		JPdfDoc oneUpDoc = loadDoc();
    	
    		
            JPdfDoc sheet = new JPdfDoc();
            JPdfPage page = new JPdfPage();
            page.setTag("F");
    		page.setPaperSize(PaperSize.A4);
    		sheet.addPage(page);
    		
    		int gutterX = 5;
    		int gutterY = 10;
    		int rowCount = 5;
    		int colCount = 6;
    		
            List<JPdfPage> pages = sheet.getPagesByTag("F");
            for (JPdfPage myPage : pages) {
            	
            	 JPdfPage oneUpPage = oneUpDoc.getPages().get(0);
				 myPage.setPageObjects(oneUpPage.getPageObjects());
            	 
            	 PaperSize paperSize = oneUpPage.getPaperSize();
				 int oneUpWidth = paperSize.getWidth();
                 int oneUpHeight = paperSize.getHeight();
                 
                 int translateX = 0;
                 int translateY = 0;
                 for (int j = 0; j < rowCount; j++) {
                 	for (int i = 0; i < colCount; i++) {
                 		myPage.translate(translateX, translateY);
                     	translateX += oneUpWidth + gutterX;
                 	}
                 	translateX = 0;
					translateY += oneUpHeight + gutterY;
     			}
			}
            
            sheet.save();
    }

	private static JPdfDoc loadDoc() throws IOException {
		JPdfDoc mydoc = new JPdfDoc();
		
		JPdfPage page = new JPdfPage();
		page.setTag("F");
		page.setPaperSize(new PaperSize(78, 150));
		List<Graphic> pageObjects = createTag();
		page.setPageObjects(pageObjects);
		mydoc.addPage(page);
		return mydoc;
	}

	private static List<Graphic> createTag() throws IOException {
		List<Graphic> tag = new ArrayList<>();
		Text text = new Text("Hello World", 10, 20);
		tag.add(text);
		
		DImage image = new DImage(ImageIO.read(new File("test.png")), 10, 50);
		tag.add(image);
		
		DRect dRect = new DRect(1, 1, 78, 150);
		tag.add(dRect);
		return tag;
	}

	private static void place(Graphics2D g2d, List<Graphic> tag,
			int translateX, int translateY) {
		
	}

}
