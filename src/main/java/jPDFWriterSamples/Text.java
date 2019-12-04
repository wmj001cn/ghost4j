package jPDFWriterSamples;

public class Text extends Graphic{
	private String text;
	
	
	public Text(String text, int x, int y) {
		super(x, y);
		this.text = text;
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
