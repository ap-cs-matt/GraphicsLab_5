import java.awt.*;
import java.applet.*;


public class GraphicsLab05_Matthew_Pearce extends Applet{
	
	public void paint (Graphics g)
	{
		//random comment
		Antialiasing.applyAntialiasing(g); 
		nightSky sky = new nightSky(g);			//creates the night sky 
		Ground ground = new Ground(g);
		
		
		
		//creates a forest using two seperate forest to acount for the sloped road 
		Forest forest = new Forest(g, 6, 200,350,595, 40, 3,8);  // graphics, rows, startX, startY, length, height, min per row, max per row 
		Forest forest2 = new Forest(g, 2, 300,420,490, 20, 2,7);
		
		Tent tent1 = new Tent(g,665,500);
		Tent tent2 = new Tent(g,5,530);
		
		Fire fire = new Fire(g,780,630,70,50);		//last two dimensions only control density of fire not of entire campfire
		Fire fire2 = new Fire(g,195,640,50,40);
		
		Highway road = new Highway(g);	//draws the forest ground / building ground color
		
	}	
}


