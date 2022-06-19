import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class ReactObj extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Color color;
	
	public int speed = 0;
	
	public int rotation = 0;

	public ReactObj(int x, int y, int widht, int height) {
		super(x,y,widht,height);
		
		color = new Color (new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
		
		speed = new Random().nextInt(8-6)+6;
	}


	public void update() {
		
		x+=8;
		rotation+=4;
		if (rotation >=360)
			rotation = 0;
	}
}
