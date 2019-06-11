package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shapes {
	private Point center;
	private int radius; //poluprecnik
	private boolean selected;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		this.selected = selected;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return "Circle [center= " + center + " , radius= " + radius + " , selected= " + selected + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawOval(this.getCenter().getX() - this.getRadius(),this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		if(isSelected() == true) {
			g.setColor(Color.black);
			g.drawRect(this.getCenter().getX() -3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() -3, this.getCenter().getY() + this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.getRadius() -3, this.getCenter().getY() -3, 6, 6);
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= this.getRadius();
	}

	@Override
	public void DialogEdit() {
		DlgCircle dlgCircle = new DlgCircle();
		for (Shapes shapes : PnlDrawing.shapesArrList) {
			if (shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				dlgCircle.getTxtXCircle().setText(split[4]);
				dlgCircle.getTxtYCircle().setText(split[7]);
				dlgCircle.getTxtRadiusCircle().setText(split[13]);
			}
		}
		dlgCircle.setVisible(true);
	}

	@Override
	public void move(int newX, int newY) {
		
	}

	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius() * 2, this.getRadius() * 2);
		
	}
	
	
	
	
}
