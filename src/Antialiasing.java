import java.awt.*;

public class Antialiasing
{

	public static void applyAntialiasing(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		
		RenderingHints rh= new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setRenderingHints(rh);
	}

}
