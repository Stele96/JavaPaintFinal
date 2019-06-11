package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Doughnut extends Circle {
	private int innerRadius;
	
	public Doughnut() {
		
	}
	
	public Doughnut(Point center,int radius, int innerRadius) {
		super(center,radius); //uzima iz nadrednjene klase pa je super
		this.innerRadius = innerRadius;
	}
	
	public Doughnut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);//poziva se set ali nece da radi sa super(selected) jer ne mogu this i to da dele prvo mesto
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public String toString() {
		return "Doughnut [ InnerRadius= " + innerRadius + " , [ Outer " + super.toString() + " ] ]";
	}
	
	public void draw(Graphics g) {
		g.setColor(getOutline());
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
	}
	
	public boolean contains(int x, int y) {
		double dFromDistance = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromDistance > innerRadius;
	}
	
	@Override
	public void DialogEdit() {
		DlgDoughnut dlgDoughnut = new DlgDoughnut();
		for (Shapes shapes : PnlDrawing.shapesArrList) {
			if (shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				dlgDoughnut.getTxtXDoughnut().setText(split[11]);
				dlgDoughnut.getTxtYDoughnut().setText(split[14]);
				dlgDoughnut.getTxtInnerRadiusDoughnut().setText(split[3]);
				dlgDoughnut.getTxtOuterRadiusDoughnut().setText(split[20]);
			}
		}
		dlgDoughnut.setVisible(true);
	}
	
	@Override
	public void AreaPainter(Graphics g) {
		super.AreaPainter(g);
		g.setColor(getFill());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);	
	}
	
}
