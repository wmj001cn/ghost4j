package jPDFWriterSamples;

import java.awt.Image;

public class DImage extends Graphic{
	
	public DImage(Image image, int x, int y) {
		super(x, y);
		this.image = image;
		// TODO Auto-generated constructor stub
	}

	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
	

}
