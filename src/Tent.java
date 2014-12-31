 import java.awt.*;
public class Tent {

	public Tent(Graphics g, int startX, int startY){
		
		Point Location = new Point(startX, startY);
		
		drawTent(g,Location);
		
	}
	
	public void drawTent(Graphics g, Point Location){
		
		g.setColor(new Color(255,250,150));
		Polygon t = new Polygon();
		t.addPoint(Location.getX(), Location.getY() - 15);
		t.addPoint(Location.getX() + 20, Location.getY()- 40);
		t.addPoint(Location.getX() + 30, Location.getY()- 55);
		
		t.addPoint(Location.getX() + 40, Location.getY() - 100);//top bar start 
		t.addPoint(Location.getX() + 90, Location.getY() - 85);
		t.addPoint(Location.getX() + 140, Location.getY() - 90);//top bar end
		
		t.addPoint(Location.getX() + 170, Location.getY() - 20);
		t.addPoint(Location.getX() + 200, Location.getY() + 20);
		
		t.addPoint(Location.getX() + 60, Location.getY() + 40);
		t.addPoint(Location.getX() + 30, Location.getY() + 0);// last segment
		g.fillPolygon(t);
		
		g.setColor(Color.black);
		g.drawLine(Location.getX() + 140, Location.getY() -90, Location.getX() + 132, Location.getY() + 31); // draws tent down
		
		g.drawLine(Location.getX() + 140, Location.getY() -90, Location.getX() + 115, Location.getY() - 35);// draws tent diagonal
		g.drawLine(Location.getX() + 115, Location.getY() -35, Location.getX() + 60, Location.getY() + 40);
		g.drawPolygon(t);
		
		
	}
	
	public void drawSupports(Graphics g, Point Location){
		
	}
	
}
