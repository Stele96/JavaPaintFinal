package drawing;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shapes implements Comparable, Moveable { //extends ne moras da nasledis sve metode a implements mora
	private boolean selected;
	private Color outline = Color.black;
	private Color fill = Color.white;
	
	public Shapes() {
		
	}
	
	public Shapes(boolean selected) {
		this.selected = selected;
	}
	
	public abstract void draw(Graphics g);

	public abstract boolean contains(int x, int y); //nema telo {} jer je apstraktna pa je dovoljno ;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract void DialogEdit(); //aostraktne metode obicne zagrade ;

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}
	
	public abstract void AreaPainter(Graphics g);
	
	
}
