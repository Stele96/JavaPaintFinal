package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel implements MouseListener {

	static int obj = 0;
	int mx,my,w,h,radius,inR,outR,sx,sy,ex,ey,c=1; //mouse x y width height radius unutrasnji radius, outer radius startXY endXY
	boolean pointBool, lineStartBool, lineEndBool, rectBool, circleBool, doughnutBool;
	static ArrayList<Shapes> shapesArrList = new ArrayList<Shapes>();//static pripada klasi ne mora da se pravi objekat te klase da bi se pozvala metoda ako je staticna
	private Color fill = Color.BLACK;
	private Color out = Color.BLACK;
	
	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		System.out.println(rectBool);

		switch (obj) {
		
		case 1:
			pointBool = true;
			out = DrawingFrm.out;
			break;
			
		case 2:
			if(c % 2 == 0) {
				sx = mx;
				sy = my;
				lineStartBool = true;
				
			} else {
				ex = mx;
				ey = my;
				out = DrawingFrm.out;
				lineEndBool = true;
			}
			break;
			
		case 3:
			DlgRect dlgRect = new DlgRect();
			dlgRect.getTxtXRectangle().setText(String.valueOf(mx));
			dlgRect.getTxtXRectangle().setEditable(false);
			dlgRect.getTxtYRectangle().setText(String.valueOf(my));
			dlgRect.getTxtYRectangle().setEditable(false);
			dlgRect.setVisible(true);
			if(dlgRect.isOk == true) {
				w = Integer.parseInt(dlgRect.getTxtWidthRectangle().getText());
				h = Integer.parseInt(dlgRect.getTxtHeightRectangle().getText());
				fill = dlgRect.getFill();
				out = dlgRect.getOutline();
				if(dlgRect.isFillBool() == false && dlgRect.isOutlineBool() == false) {
					fill = DrawingFrm.fill;
					out = DrawingFrm.out;
				}
				rectBool = true;
			}
			break;
			
		case 4:
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.getTxtXCircle().setText(String.valueOf(mx));
			dlgCircle.getTxtYCircle().setText(String.valueOf(my));
			dlgCircle.getTxtXCircle().setEditable(false);
			dlgCircle.getTxtYCircle().setEditable(false);
			dlgCircle.setVisible(true);
			if(dlgCircle.isOk == true) {
				radius = Integer.parseInt(dlgCircle.getTxtRadiusCircle().getText());
				fill = dlgCircle.getFill(); ////ovooooooo
				out = dlgCircle.getOutline();//ovooooo
				if(dlgCircle.isFillBool() == false && dlgCircle.isOutlineBool() == false) {
					fill = DrawingFrm.fill;
					out = DrawingFrm.out;
				}
				circleBool = true;
			}
			break;
			
		case 5:
			DlgDoughnut dlgDoughnut = new DlgDoughnut();
			dlgDoughnut.getTxtXDoughnut().setText(String.valueOf(mx));
			dlgDoughnut.getTxtYDoughnut().setText(String.valueOf(my));
			dlgDoughnut.getTxtXDoughnut().setEditable(false);
			dlgDoughnut.getTxtYDoughnut().setEditable(false);
			dlgDoughnut.setVisible(true);
			if(dlgDoughnut.isOk == true) {
				 inR = Integer.parseInt(dlgDoughnut.getTxtInnerRadiusDoughnut().getText());
				 outR = Integer.parseInt(dlgDoughnut.getTxtOuterRadiusDoughnut().getText());
				 fill = dlgDoughnut.getFill();
				 out = dlgDoughnut.getOutline();
				 if(dlgDoughnut.isFillBool() == false && dlgDoughnut.isOutlineBool() == false) {
						fill = DrawingFrm.fill;
						out = DrawingFrm.out;
					}
				 doughnutBool = true;
			}
			break;
			
		case 6:
			boolean match = false;
			Collections.reverse(shapesArrList);
			for (Shapes shapes : shapesArrList) {
				shapes.setSelected(false);
				if(match == false) {
					if(shapes.contains(mx, my)) {
						shapes.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapesArrList);
			break;
		}
		
		
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		switch (obj) {
		
		case 1:
			if(pointBool == true) {
				Point p = new Point(mx, my, false);
				p.setOutline(out);
				shapesArrList.add(p);
				System.out.println(shapesArrList);
				pointBool = false;
			}
			break;
			
		case 2:
			if(lineStartBool && lineEndBool == true) {
				Line l = new Line(new Point(sx, sy), new Point(ex, ey), false);
				l.setOutline(out);
				shapesArrList.add(l);
				System.out.println(shapesArrList);
				lineStartBool = false;
				lineEndBool = false;
			}
			break;
		
		case 3:
			if(rectBool == true) {
				Rectangle r = new Rectangle(new Point(mx, my), w, h, false);
				shapesArrList.add(r);
				r.setOutline(out);
				r.setFill(fill);
				System.out.println(shapesArrList);
				rectBool = false;
			}
			break;
			
		case 4:
			if(circleBool == true) {
				Circle c = new Circle(new Point(mx, my), radius, false);
				c.setOutline(out);//ovvooooooo
				c.setFill(fill); //ovooooooo
				shapesArrList.add(c);
				System.out.println(shapesArrList);
				circleBool = false;
			}
			break;
			
		case 5:
			if(doughnutBool == true) {
				Doughnut d = new Doughnut(new Point(mx, my), outR, inR, false);
				d.setOutline(out);
				d.setFill(fill);
				shapesArrList.add(d);
				System.out.println(shapesArrList);
				doughnutBool = false;
			}
			
		}
		for (Shapes shapes : shapesArrList) {
			shapes.AreaPainter(g);
			shapes.draw(g);
		}
		
		
		repaint();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (obj) {
		
			case 2:
				c++;
				break;
		
		}
	}

}
