package drawing;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		
		Point p = new Point(100, 100);
		p.draw(g);
		
		Line l = new Line(new Point(200, 200),new Point(500,100),true);
		l.draw(g);
		
		Rectangle r = new Rectangle(p,500,200);
		r.draw(g);
		
		Circle c = new Circle(new Point(200,200),100);
		c.draw(g);
		
	}
}
