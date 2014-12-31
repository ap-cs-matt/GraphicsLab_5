
public class myColor {
	private int Red;
	private int Green;
	private int Blue;
	private int Alpha;
	
	//constructors
	public myColor(){
		Red = 0;
		Green = 0;
		Blue = 0;
		Alpha = 255;
	}
	
	public myColor(int Red, int Green, int Blue){
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		Alpha = 255;
	}
	
	public myColor(int Red, int Green, int Blue, int Alpha){
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		this.Alpha = Alpha;
	}
	
	//redifine all colors
	public void setColor(int Red, int Green, int Blue){
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		Alpha = 255;
	}
	public void setColor(int Red, int Green, int Blue, int Alpha){
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		this.Alpha = Alpha;
	}
	
	//get methods
	public int getRed(){
		return Red;
	}
	public int getGreen(){
		return Green;
	}
	public int getBlue(){
		return Blue;
	}
	public int getAlpha(){
		return Alpha;
	}
	
	
	
	//set methods
	public void setRed(int Red){
		this.Red = Red;
	}
	public void setGreen(int Green){
		this.Green = Green;
	}
	public void setBlue(int Blue){
		this.Blue = Blue;
	}
	public void setAlpha(int Alpha){
		this.Alpha = Alpha;
	}
	
	//to string method
	public String toString(){
		return Red + ", " + Blue + ", " + Green + ", " + Alpha;
	}
	
}

