import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;	
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Pseudo Top-Level Static
public final class Carver
{
	private Carver() {};

	public static Image paint_blue_line(Image image) throws Exception
	{
		BufferedImage temp = image.get_image();

		for (int i = 0; i < temp.getHeight(); ++i)
			temp.setRGB(10, i, 1, 1, create_pixel(0,0,255), 0, 0);
		
		return new Image(temp);
	}

	private static int[] create_pixel(int r, int g, int b)
	{
		int a = 255;
		int[] pixel = new int[4];
		pixel[0] = a;
		pixel[1] = r;
		pixel[2] = g;
		pixel[3] = b;

		return pixel;
	}	

	private static int[] create_pixel(int a, int r, int g, int b)
	{
		int[] pixel = new int[4];
		pixel[0] = a;
		pixel[1] = r;
		pixel[2] = g;
		pixel[3] = b;

		return pixel;
	}
}