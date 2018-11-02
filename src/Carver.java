import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;	
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

//Pseudo Top-Level Static
public final class Carver
{
	private Carver() {};

	private static int _create_pixel(int r, int g, int b)
	{
		return (new Color(r, g, b)).getRGB();
	}	

	private static int _create_pixel(int a, int r, int g, int b)
	{
		return (new Color(r, g, b, a)).getRGB();
	}

	private static int _rgb_to_gs_pix(int pixel)
	{
		int blue  =  pixel & 0xff;
		int green = (pixel & 0xff00)     >>   8;
		int red   = (pixel & 0xff0000)   >>  16;
		int alpha = (pixel & 0xff000000) >>> 24;

		//CCIR 601
		int avg   = (int)(0.2989*((double)red) + 0.5870*((double)green) + 0.1140*((double)blue));
		
		return (new Color(avg, avg, avg, alpha)).getRGB();
	}

	public static void paint_blue_line(Image image) throws Exception
	{
		BufferedImage img = image.get_image();
		int red = (0 << 24) + (255 << 16) + (0 << 8) + 255;

		for (int i = 0; i < img.getHeight(); ++i)
			img.setRGB(10, i, red);
	}

	public static void rgb_to_gs(Image image) throws Exception
	{
		BufferedImage img = image.get_image();

		for (int i = 0; i < img.getHeight(); ++i)
			for (int j = 0; j < img.getWidth(); ++j)
				img.setRGB(j, i, _rgb_to_gs_pix(img.getRGB(j, i)));
	}
}