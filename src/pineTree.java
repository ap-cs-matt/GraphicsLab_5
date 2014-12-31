import java.awt.*;

public class pineTree {

	private Point Left = new Point(0,0);
	private Point Right = new Point(0,0);
	private Point Top = new Point(0,0);
	
	public pineTree(Graphics g, int x, int y)
	{
		constructPineTree(g,x,y);
	}
	
	public void drawPineTree(Graphics g,Point Left, Point Right, Point Top){

		int i = 1;
		int slide = 8;
		int top = 20;
		
		drawStump(g);
		
		//draws tree
		while( i < 8)
		{
			g.setColor(new Color(53,134,0));
			
			Polygon p = new Polygon();
			p.addPoint(Left.getX(),Left.getY());
			p.addPoint(Right.getX(),Right.getY());
			p.addPoint(Top.getX(),Top.getY());
			g.fillPolygon(p);
			
			//draws outline in black
			g.setColor(Color.black);
			g.drawPolygon(p);
			
			Left.setX(Left.getX() + slide);
			Left.setY(Left.getY() - top );
			Right.setX(Right.getX() -slide);
			Right.setY(Right.getY() - top  );
			Top.setY(Top.getY() - top);
			
			slide = (int) (slide *.85);
			top = (int) ((double)top * .95);
			i++;
		}	
		
	}
	
	public void constructPineTree(Graphics g, int x, int y){ //the coordinates of the bottom right of the tree not including stump
		Left.setX(x);
		Left.setY(y);
		
		Right.setX(x+100);
		Right.setY(y);
		
		Top.setX(x + 50);
		Top.setY(y - 50);
		
		drawPineTree(g,Left, Right,Top);
	}
	
	public void drawStump(Graphics g)
	{
		//draw filled in portion of stump
		g.setColor(new Color(117,80,0));
		g.fillRect(Top.getX()-7, Left.getY(), 14, 25);
		
		//draws outline of the stump
		g.setColor(Color.black);
		g.drawRect(Top.getX()-7, Left.getY(), 14, 25);
	}
}



