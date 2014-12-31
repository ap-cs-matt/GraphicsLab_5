import java.awt.*;
class Fire extends firePit{

		public Fire(Graphics g ,int startX, int startY, int width, int height){// sets # of Fires and sets locations + sizes passes to construct Fire
			
			super(g,startX, startY);
			
			
			Point Location = new Point(startX, startY - 110);  // start x and y of Fires in top left
			Point Size = new Point(width, height);
			
			//draws first Fire 
			drawFire(g, Location, Size);	//passes to Fire constructor and is drawn from there 
		}
		
		public void drawFire(Graphics g, Point Location, Point Size ){ // draws a Fire at given location + size
			
			int i = 0;
			myColor fireColor = new myColor(255,75,0);
			
			while (i < ((double)Size.getX() / 2)  + 12)  // number of circles per Fire relative to its length
			{
				fireColor.setAlpha((int)(Math.random() * 60)+140);
				fireColor.setRed((int)(Math.random()*100)+130);
				fireColor.setGreen((int)(Math.random()*50) + 30);
			
				
				g.setColor(new Color(fireColor.getRed(), fireColor.getGreen(), fireColor.getBlue(),fireColor.getAlpha()));
				
				// takes the passed varaibles and creates a boxed zone of where the cliud can be and generates random points within to draw Fires
				
				Point Fire = new Point((int)(Math.random()*Size.getX())+Location.getX(), (int)(Math.random()*Size.getY())+Location.getY());  // random start x,y locations of a Fire
				Point fireDimensions = new Point((int)(Math.random()*50), (int)(Math.random()*50));  // x = width y = height	random hieght / width of indivdual ovals within Fire
				
				while (fireDimensions.getX() + 25 > fireDimensions.getY()) // makes sure no perfect circles are drawn
				{
					fireDimensions.setX((int)(Math.random()*50)); 
					fireDimensions.setY((int)(Math.random()*50));  // x = width y = height	random hieght / width of indivdual ovals within Fire
				}
				g.fillOval(Fire.getX(),Fire.getY(),fireDimensions.getX(),fireDimensions.getY());
				
				i++;
			}	
		}	
	}
	
	

	class firePit{
		firePit(Graphics g, int startX, int startY){
			
			Point Location = new Point(startX,startY);
			//draws a circle of rocks	
			drawRock(g,Location.getX(),Location.getY());
			drawRock(g,Location.getX() - 15,Location.getY() - 20);
			drawRock(g,Location.getX(),Location.getY() - 30);
			drawRock(g,Location.getX() + 30,Location.getY() - 35);
			drawRock(g,Location.getX() + 35,Location.getY() - 15);
			drawRock(g,Location.getX() + 20,Location.getY() - 10);
		}
		
		public void drawRock(Graphics g, int startX, int startY){
			
			
			Point Location = new Point(startX, startY);
			g.setColor(new Color(120,120,120));
			
			//rock shape
			Polygon r = new Polygon();
			r.addPoint(Location.getX() + 45,Location.getY());
			r.addPoint(Location.getX() + 25, Location.getY() - 5);
			r.addPoint(Location.getX() + 17, Location.getY() - 10);
			r.addPoint(Location.getX() + 15, Location.getY() - 15);
			r.addPoint(Location.getX() + 7,Location.getY()-20);
			r.addPoint(Location.getX() + 0, Location.getY() - 30);
			r.addPoint(Location.getX() + 10, Location.getY()- 40);
			r.addPoint(Location.getX() + 20, Location.getY()- 42);
			r.addPoint(Location.getX() + 30, Location.getY()- 45);
			r.addPoint(Location.getX() + 40, Location.getY()- 40);
			r.addPoint(Location.getX() + 45, Location.getY()- 35);
			r.addPoint(Location.getX() + 55, Location.getY()- 25);
			
			g.fillPolygon(r);
			
			g.setColor(Color.black);
			g.drawPolygon(r);
		}
		
	}
