import java.awt.*;

public class Forest{

	public Forest(Graphics g, int Rows, int startX, int startY, int Length, int Height, int minPerRow, int maxPerRow) {
		
		Point Size = new Point(Length,Height);
		Point Location = new Point(startX, startY);
		Point Quantity = new Point(minPerRow, maxPerRow);  // x = min number of trees  y = max number of trees
		
		int i = 0;
		int numberOfTrees;
		
		while (i < Rows){
			
			numberOfTrees = (int) ((Math.random()* Quantity.getY()) + Quantity.getX());
			
			treeLine forest = new treeLine(g, numberOfTrees,Location.getX(),Location.getY(), Size.getX());
			
			Location.setY(Location.getY() + (int)((double)Size.getY() / (double)Rows));
			i++;
		}		
	}	
}

class treeLine {

	public treeLine(Graphics g, int numberOfTrees, int startX, int startY, int Length){  // x = length y= height
		
		Point Location = new Point(startX, startY);
		Point Size = new Point(Length,0);
		
		int i = 0;
		
		while (i < numberOfTrees)
		{				
			Location.setX(Location.getX() + (int) ((double)Size.getX() / (double) numberOfTrees));  
			pineTree tree = new pineTree(g,Location.getX(),Location.getY());

			i++;
		}
	}
}


