package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shapes {
	private Point start;
	private Point end;
	
	private boolean selected;
	
	public Line() {
		
	}
	
	public Line(Point start,Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Line(Point start,Point end, boolean selected) {
		this(start,end);
		this.selected = selected;
	}
	
	public Point middleOfLine() {
		int middleX = (this.getStart().getX() + this.getEnd().getX())/2;
		int middleY = (this.getStart().getY() + this.getEnd().getY())/2;
		Point middle = new Point(middleX,middleY);
		return middle; //mora da vrati jer nije void
		
	}
	
	public Point getStart() {
		return start;
	}
	
	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return "Line [start= " + start + " , end= " + end + " , selected= " + selected + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
		if(isSelected() == true) {
			g.setColor(Color.black);
			g.drawRect(this.getStart().getX() - 3, this.getStart().getY() - 3, 6, 6);
			g.drawRect(this.getEnd().getX() - 3, this.getEnd().getY() - 3, 6, 6);
			g.drawRect(this.middleOfLine().getX() - 3, this.middleOfLine().getY() - 3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		if((start.distance(x, y) + end.distance(x, y)) - length()<=0.05 ) {
			return true;
			} else {
			return false;
		}
	}
	
	public double length() { //knjiga
		return start.distance(end.getX(), end.getY());
	}

	@Override
	public void DialogEdit() {
		DlgLine dlgLine = new DlgLine();
		for (Shapes shapes : PnlDrawing.shapesArrList) {
			if (shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				dlgLine.getTxtXLine().setText(split[4]);
				dlgLine.getTxtYLine().setText(split[7]);
				dlgLine.getTxtXLineEND().setText(split[15]);
				dlgLine.getTxtYLineEND().setText(split[18]);
			}
		}
		dlgLine.setVisible(true);
	}

	@Override
	public void move(int newX, int newY) {
	}

	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

