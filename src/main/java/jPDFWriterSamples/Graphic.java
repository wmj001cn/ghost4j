package jPDFWriterSamples;

public class Graphic {
	
	protected int x;
	protected int y;
	
	protected int originalX;
	protected int originalY;
	
	public int getX() {
		return x;
	}
	public Graphic(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		
		this.originalX = x;
		this.originalY = y;
	}
	
	public void reset(){
		this.x = this.originalX;
		this.y = this.originalY;
	}
	
	public void setX(int x) {
		System.out.println("setting x to:" + x);
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	

}
