package jPDFWriterSamples;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Style;

import org.ghost4j.document.PaperSize;

import com.qoppa.pdfWriter.PDFPage;

public class JPdfPage {
	
	private String tag;
	private int width;
	private int height;
	private PaperSize paperSize;
	public PaperSize getPaperSize() {
		return paperSize;
	}

	public void setPaperSize(PaperSize paperSize) {
		this.paperSize = paperSize;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	PDFPage newPage;
	public PDFPage getNewPage() {
		return newPage;
	}

	public void setNewPage(PDFPage newPage) {
		this.newPage = newPage;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	List<Graphic> pageObjects = new ArrayList<>();
	
	public void addObject(Graphic object) {
		pageObjects.add(object);
	}

	public List<Graphic> getPageObjects() {
		return pageObjects;
	}

	public void setPageObjects(List<Graphic> pageObjects) {
		this.pageObjects = pageObjects;
	}
	
	public void translate(int translateX, int translateY) {
		
	    Graphics2D g2d = this.getNewPage().createGraphics();
		for (Graphic graphic : pageObjects) {
			int x = graphic.getX() + translateX;
			
			System.out.println(translateX);
			graphic.setX(x);
			graphic.setY(graphic.getY() + translateY);
				
			if(graphic instanceof Text) {
				Text text2 = (Text) graphic;
				Font deriveFont = new Font(Font.SANS_SERIF, Font.ITALIC, 5);
				g2d.setFont(deriveFont);
				g2d.setColor(Color.black);
				g2d.drawString(text2.getText(), text2.getX(), text2.getY());
			} else if(graphic instanceof DImage) {
				 DImage dimage = (DImage) graphic;
				 
				 AffineTransform t = new AffineTransform();
				 g2d.drawImage(dimage.getImage(), dimage.getX(), dimage.getY(), null);
				 
				 //g2d.drawImage(dimage.getImage(), t, null);
			} else if(graphic instanceof DRect) {
				DRect dimage2 = (DRect) graphic;
				
				g2d.setColor(Color.red);
				Stroke st = new BasicStroke();
				g2d.setStroke(st);
				g2d.drawRect(dimage2.getX(), dimage2.getY(), dimage2.getWidth(), dimage2.getHeight());
		    }
			
			graphic.reset();
		}
	}
	

}
