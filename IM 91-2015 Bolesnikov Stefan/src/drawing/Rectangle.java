package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shapes {
	private Point ulp;
	private int width;
	private int height;
	private boolean selected;
	
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point ulp, int width, int height) {
		this.ulp = ulp;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point ulp, int width, int height, boolean selected) {
		this(ulp,width,height);
		this.selected = selected;
	}

	public int area() {
		return height*width;
	}
	
	//instancef proverava da li je neki objekat pripada nekoj klasi
	//compareto poredi dva objekta
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return (int)(this.area()-((Rectangle)o).area());  //this je r1..... downcast int
		}
		return 0; //ne mora else
	}
	
	public Point getUlp() {
		return ulp;
	}

	public void setUlp(Point ulp) {
		this.ulp = ulp;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return "Rectangle [ulp= " + ulp + " , width= " + width + " , height= " + height + " , selected= " + selected + "]";
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawRect(this.getUlp().getX(), this.getUlp().getY(), this.getWidth(), this.getHeight());
		if(isSelected() == true) {
			g.setColor(Color.black);
			g.drawRect(this.getUlp().getX() - 3, this.getUlp().getY() - 3, 6, 6); //gore levo
			g.drawRect(this.getUlp().getX() + this.getWidth() - 3, this.getUlp().getY() - 3, 6, 6); //gore desno
			g.drawRect(this.getUlp().getX() - 3, this.getUlp().getY() + this.getHeight() - 3, 6, 6); //dole levo
			g.drawRect(this.getUlp().getX() + this.getWidth() - 3, this.getUlp().getY() + this.getHeight() - 3, 6, 6); //dole desno
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		if( (this.getUlp().getX() <= x) && 
			(this.getUlp().getX() + this.getWidth() >= x) &&
			(this.getUlp().getY() <= y) &&
			(this.getUlp().getY() + this.getHeight() >= y)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void DialogEdit() {
		DlgRect dlgRect = new DlgRect();
		for (Shapes shapes : PnlDrawing.shapesArrList) {
			if (shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				dlgRect.getTxtXRectangle().setText(split[4]);
				dlgRect.getTxtYRectangle().setText(split[7]);
				dlgRect.getTxtWidthRectangle().setText(split[13]);
				dlgRect.getTxtHeightRectangle().setText(split[16]);
			}
		}
		dlgRect.setVisible(true);
		
	}

	@Override
	public void move(int newX, int newY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillRect(this.getUlp().getX() + 1, this.getUlp().getY() + 1, this.getWidth() - 1, this.getHeight() - 1);
	}
	
	
	
	
}
