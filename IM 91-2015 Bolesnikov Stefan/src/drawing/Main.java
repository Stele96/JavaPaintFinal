package drawing;

public class Main {

	public static void main(String[] args) { 
		//static znaci da metoda u ovom slucaju pripada klasi a ne objektu(ne moras da pravis objekat da bi pozvao metodu)
		/*Point p = new Point(6,9);
		System.out.println(p);
		
		Line l = new Line(new Point(5,5,true),new Point(10,10));
		System.out.println(l);
		
		Rectangle r = new Rectangle(p,100,200);
		System.out.println(r);
		
		Circle c = new Circle(p,100,true);
		System.out.println(c);
		
		Doughnut d = new Doughnut(p,170,100,true);
		System.out.println(d);*/
		
		Rectangle r1 = new Rectangle(new Point(1,1),5,6);
		Rectangle r2 = new Rectangle(new Point(1,1),50,60);
		System.out.println(r1.area());
		System.out.println(r2.area());
		System.out.println(r1.compareTo(r2)); //oduzima r1 od r2 r1 je this r2 je objekat
		
		
	}

}
