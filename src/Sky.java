import java.awt.*;

public class Sky {
	
	public Sky(Graphics g,double red, double green, double blue)	//accepts color of sky at darkest
	{
		drawSky(g,red,green,blue); // draws the sky gradient with the color passed to it when new objected instan
	}
	
	public void drawSky(Graphics g, double red, double green, double blue){//using double values  for small increases for colors
		
		int x1 = 0;
		int x2 = 900;
		int y = 0;
		while (y < 650)	//draws gradient only in blue values changing as it is a sky
		{
			g.setColor(new Color((int)red, (int)green, (int)blue));
			g.drawLine(x1, y, x2, y);
			
			if (blue < 255){  // limits maximum value so color doesn't overflow
				blue += .3 ; // increases darkness of blue
			}
			y++;
		}
		Clouds(g); // draws clouds
	}
	
	public void Clouds(Graphics g){		// sets # of clouds and sets locations + sizes passes to construct cloud
		Point Location = new Point(0,0);  // start x and y of clouds in top left
		Point Size = new Point(0,0);
		
		//draws first cloud 
		constructCloud(g, Location, Size,500,125,150,50);	//passes to cloud constructor and is drawn from there
		
		// draws second cloud 
		constructCloud(g,Location, Size, 150,170,220,70); 
	}
	
	public void constructCloud(Graphics g,Point Location, Point Size, int locationX, int locationY, int sizeX, int sizeY){ 
		//assigns the passed points to create size + locations of clouds using the point class and then issues the draw command
		
		Location.setX(locationX);	
		Location.setY(locationY);
		Size.setX(sizeX);
		Size.setY(sizeY);
		
		drawCloud(g,Location,Size);
	}
	
	public void drawCloud(Graphics g, Point Location, Point Size ){ // draws a cloud at given location + size
		
		int i = 0;
		while (i < 175)  // number of circles per cloud
		{
			int alpha = (int)(Math.random()*60)+40;
			g.setColor(new Color(240,240,240,alpha));
			
			// takes the passed varaibles and creates a boxed zone of where the cliud can be and generates random points within to draw clouds
			Point Cloud = new Point((int)(Math.random()*Size.getX())+Location.getX(), (int)(Math.random()*Size.getY())+Location.getY());  // random start x,y locations of a cloud
			Point cloudDimensions = new Point((int)(Math.random()*50), (int)(Math.random()*50));  // x = width y = height	random hieght / width of indivdual ovals within cloud
			
			g.fillOval(Cloud.getX(),Cloud.getY(),cloudDimensions.getX(),cloudDimensions.getY());
			
			i++;
		}	
	}
}	
	

class nightSky extends Sky{
	
	private static double red = 0;
	private static double green = 0;
	private static double blue = 20;
	
	public nightSky(Graphics g)
	{
		super(g, red, green, blue);	// passes the color up
		drawMoon(g);
		drawStars(g);
	}
	
	public void  drawMoon(Graphics g)
	{
		//outline
		int t = 80; //transparency
		int r = 0; //loop control
		Point Location = new Point(800,-100);
		Point Size = new Point(200,200); 	// x= width y = hieght
		
		while (r < 30){
		g.setColor(new Color(247,247,247,t));
		g.fillArc(Location.getX(),Location.getY(),Size.getX(),Size.getY(),180,90);
		
		Location.setX(Location.getX()-1);			//slides starting x to the left
		Location.setY(Location.getY()- 1);			//slides starting y further up
		Size.setX(Size.getX()+ 2);					//increases width
		Size.setY(Size.getY() + 2);					// increases hieght
		
		if (t > 10){
			t -= 2;			//increases transparency if greater than 0
		}
				
		r++;
	}
		
		g.setColor(new Color(247,247,247,t));
		g.fillArc(800,-100,200,200,180,90);
				
		//craters
		g.setColor(new Color(212,212,212,255));
		int i = 0;
		Point crater = new Point(0,0);
		Point starDimensions = new Point(0,0);   // x = width y = height
		
		while (i<15)
		{
			crater.setX((int)(Math.random()*55)+825);
			crater.setY((int)(Math.random()*55));
			starDimensions.setX((int)(Math.random()*15)+5);   // assigns a random width
			starDimensions.setY((int)(Math.random()*15)+5);	// assigns a random height
			g.fillOval(crater.getX(), crater.getY(), starDimensions.getX(), starDimensions.getY());
				
			i++;
		}
	}
	
	public void  drawStars(Graphics g)
	{	
		Point starStart = new Point(0,0);
		Point starEnd = new Point(0,0);
		
		int i = 0;
		
		while (i<600)
		{											//will draw line 2 pixels long
			g.setColor(new Color(222,222,222));
			starStart.setX((int)(Math.random()*900));
			starEnd.setX(starStart.getX() +1);
			
			starStart.setY((int)(Math.random()*650));
			starEnd.setY(starStart.getY()+1);
			
			g.drawLine(starStart.getX(),starStart.getY(),starEnd.getX(),starEnd.getY());
			i++;
		}			
	}	
}
