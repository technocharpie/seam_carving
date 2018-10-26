//package seam_carving;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;	
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SeamCarving
{	
	public static void main(String[] args)
  	{
  		try
  		{
	  		String dir = System.getProperty("user.dir");
	  		String img = "the_kiss.jpg";
	  		File ori  = new File(dir+"/"+img);
	  		
	  		
			Image my_img = new Image(dir, img);
			Image test2  = new Image(dir, img);
			test2.show();
			my_img = Carver.paint_blue_line(my_img);
			my_img.show();
			my_img.to_file("jpg", dir+"/test_img.jpg");
    	}
    	catch ( Exception e)
		{
			e.printStackTrace();
    	}
  	}

}