import java.awt.*;

public class Highway extends Road{
	
	public Highway(Graphics g) {
		super(g);		
		drawCenterLines(g);
		drawSideLines(g);
		
		drawLeftStreetLamp(g,215,520); //middle left
		drawLeftStreetLamp(g,120,425); //top left
		drawLeftStreetLamp(g,350,630); //bottom left
		
		drawSpeedSign(g,"60",200,400);  //draws sign upper right
		drawSpeedSign(g,"25",500,565);	//draws sign lower right
		drawReverseSpeedSign(g,70,400);	//draws sign upper left
		drawReverseSpeedSign(g,300,600);	//draws sign lower left		 
	}
	
	public void drawCenterLines(Graphics g){
		//draws two yellow lines down the center
		g.setColor(Color.yellow);
		Polygon r = new Polygon();
		r.addPoint(97, 350);
		r.addPoint(102,350);
		r.addPoint(555,650);
		r.addPoint(545,650);
		
		g.drawPolygon(r);
	}
	
	public void drawSideLines(Graphics g){
		
		g.setColor(Color.white);
		
		//draws white line on right
		Polygon s = new Polygon();
		s.addPoint(145, 350);
		s.addPoint(147,350);
		s.addPoint(684,650);
		s.addPoint(680,650);
		g.fillPolygon(s);
		
		//draw white line on left
		Polygon q = new Polygon();
		q.addPoint(54, 350);
		q.addPoint(57,350);
		q.addPoint(415,650);
		q.addPoint(411,650);
		
		g.fillPolygon(q);
	}

	public void drawSpeedSign(Graphics g, String Speed, int startX, int startY){
		
		Point Location = new Point(startX, startY);
		g.setColor(new Color(130,130,130));
		g.fillRoundRect(Location.getX(), Location.getY() - 100, 4, 75,10,10);			//draws sign pole
		
		g.setColor(new Color(200,200,200));
		g.fillRoundRect(Location.getX()-15,Location.getY() - 100, 34,40,10,10);		//draw sign background
		
		g.setColor(new Color(0,0,0));		//sets color to black
		
		Font font = new Font("Arial",Font.BOLD,10);
		g.setFont(font);
		g.drawString("Speed", Location.getX()-13, Location.getY() - 90);		//draws word speed
		g.drawString("Limit",Location.getX() -9 , Location.getY()-63);			//draws word limit
		
		Font font2 = new Font("Arial",Font.BOLD,20);
		g.setFont(font2);
		g.drawString(Speed, Location.getX()-8, Location.getY() - 73); //draws speedlimit
	}
	
	public void drawReverseSpeedSign(Graphics g, int startX, int startY){ //draws speed sign with pole drawn first to appear as being viewd from behind
		
		Point Location = new Point(startX, startY);
		
		g.setColor(new Color(200,200,200));
		g.fillRoundRect(Location.getX()-15,Location.getY() - 100, 34,40,10,10);
		
		g.setColor(new Color(130,130,130));
		g.fillRoundRect(Location.getX(), Location.getY() - 100, 4, 75,10,10); // draws pole	
	}
	
	public void drawLeftStreetLamp(Graphics g, int startX, int startY){
		
		Point streetLamp = new Point(startX,startY);
		Point Size = new Point(10,10);
		
		g.setColor(new Color(130,130,130));
		g.fillRect(streetLamp.getX(), streetLamp.getY() - 150, 5, 150);	//draws post
		g.fillRoundRect(streetLamp.getX()-5, streetLamp.getY() - 155, 45,5,10,10);	//draws light extension
		g.fillRoundRect(streetLamp.getX() + 30, streetLamp.getY()-160,20,20,20,12);	//draws light holder
		
		g.setColor(new Color(255,255,0));
		g.fillRoundRect(streetLamp.getX() + 35, streetLamp.getY()-152,12,12,20,12);	//draws light 
		
		//light on road glow
		int alpha = 35;
		int i = 0; //loop control
		
		while (i < 50){
		myColor Lamp = new myColor(255,255,0,alpha);
		g.setColor(new Color(Lamp.getRed(), Lamp.getGreen(), Lamp.getBlue(), Lamp.getAlpha()));
		
		g.fillOval(streetLamp.getX() + 38, streetLamp.getY() - 55, Size.getX(), Size.getY());
		
		if (alpha > 5){ //makes light not entirely disapear
		alpha --;
		}
		
		//increase lamp glow size
		streetLamp.setX(streetLamp.getX()-1);
		streetLamp.setY(streetLamp.getY()-1);
		
		Size.setX(Size.getX() + 2);
		Size.setY(Size.getY() + 2);
		i++;
		}
	}
}

	class Road{
		
		public Road(Graphics g){
			drawRoad(g);	
		}
		
		public void drawRoad(Graphics g){
			
			//draws road at an angle
			g.setColor(new Color(84,84,84));
			Polygon p = new Polygon();
			p.addPoint(700,650);
			p.addPoint(400,650);
			p.addPoint(50,350);
			p.addPoint(150, 350);
			
			g.fillPolygon(p);			
		}	
	}	
	
	class Ground{
		
		public Ground(Graphics g){
			drawForestGround(g);
			drawStoreGround(g);
		}
		
		public void drawForestGround(Graphics g){
			//draw park ground on right
					g.setColor(new Color(25,54,0));
					Polygon h = new Polygon();
					h.addPoint(150,350);
					h.addPoint(900, 350);
					h.addPoint(900,650);
					h.addPoint(700, 650);
					
					g.fillPolygon(h);
		}
		
		public void drawStoreGround(Graphics g){
			//draw city ground on left
			g.setColor(new Color(25, 54, 0));
			Polygon c = new Polygon();
			c.addPoint(0,350);
			c.addPoint(50,350);
			c.addPoint(400, 650);
			c.addPoint(0,650);
			
			g.fillPolygon(c);
		}
	}