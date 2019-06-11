package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shapes {
//promenljive su private
//metode su public
	private int x;
	private int y;
	private boolean selected;
	
	//konstruktor je metoda koja sluzi za kreiranje objekata ona je public i ima isto ime kao i ime klase
	//ne mozemo imati dva ista kontruktora sa istim parametrima i sluzi za postavljanje vrednosti
	//ovo ispod je prazan konstruktor ako ne prosledis parametre nikakve
	public Point () {
		
	}
	
	public Point (int x,int y) {
		this.x = x; //desni x je ovaj u zagradi a levi je gore
		this.y = y;
	}
	
	public Point (int x, int y, boolean selected) {
		this(x,y); //ova linija mora da bude prva jer je kao ovo gore pa uzima od toga samo je dodato
		this.selected = selected;
	}
	
	//get i set su public metode za pristup i postavljanje vrednosti
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return "Point [x= " + x + " , y= " + y + " , selected= " + selected + "]";
	}

	@Override
	public int compareTo(Object o) { //od kordinatnog pocetka uporedjuje tacke
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getX()-2, this.getY(), this.getX()+2, this.getY());
		g.drawLine(this.getX(), this.getY()-2, this.getX(), this.getY()+2);
		if(isSelected()==true) {
			g.setColor(Color.black);
			g.drawRect(this.getX()-3, this.getY()-3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		if(this.distance(x, y)<=3) {
			return true;
		} else {
			return false;
		}
	}
	
	public double distance(int x, int y) {
		double dx = this.x - x;
		double dy = this.y - y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}

	@Override
	public void DialogEdit() {
		DlgPoint dlgPoint = new DlgPoint();
		for (Shapes shapes : PnlDrawing.shapesArrList) {
			if (shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				dlgPoint.getTxtXPoint().setText(split[2]);
				dlgPoint.getTxtYPoint().setText(split[5]);
			}
		}
		dlgPoint.setVisible(true);
	}

	@Override
	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;
		
	}

	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
