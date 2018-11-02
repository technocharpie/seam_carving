//package seam_carving;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;	
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Image
{	
	private BufferedImage image;
	private ImageIcon     icon;
	private JLabel        label;
	private JFrame 	      frame;


	//==CONSTRUCTOR==========
	public Image()
	{
		this.image = null;
		this.icon  = null;
		this.label = new JLabel();
		this.frame = new JFrame();

		this.frame.setLayout(new FlowLayout());
		this.frame.setSize(1000,1000);
		this.frame.setVisible(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Image(String dir, String img)
	{
		try
		{
			File ori  = new File(dir+"/"+img);
			//File copy = new File(dir+"/temp_file.jpg")
			//copy.createNewFile();

      		this.image = ImageIO.read(new File(dir+"/"+img));
      		this.icon  = new ImageIcon(image);
      		this.label = new JLabel();
      		this.frame = new JFrame();

      		this.frame.setLayout(new FlowLayout());
			this.frame.setSize(image.getWidth() + 20, image.getHeight() + 40);
      		this.label.setIcon(icon);
      		this.frame.add(label);
			this.frame.setVisible(false);
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Image(BufferedImage img) throws Exception
	{	
		if (img == null)
			throw new Exception("Null image passed into constructor.");

		this.image = img;
		this.icon  = new ImageIcon(image);
		this.label = new JLabel();
	      	this.frame = new JFrame();

	      	this.frame.setLayout(new FlowLayout());
		this.frame.setSize(image.getWidth() + 20, image.getHeight() + 40);
  		this.label.setIcon(icon);
  		this.frame.add(label);
		this.frame.setVisible(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Image(Image img) throws Exception
	{
		if (img == null)
			throw new Exception("Null image passed into constructor.");

		this.image = img.get_image();
		this.icon  = img.get_icon();//img.get_icon();
		this.label = new JLabel();
		this.frame = new JFrame(); //img.get_frame();
		this.frame.setLayout(new FlowLayout());
		this.frame.setSize(this.image.getWidth() + 100, this.image.getHeight() + 40);
		this.label.setIcon(this.icon);
		this.frame.add(this.label);
		this.frame.setVisible(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	//==GETTER==========
	public BufferedImage get_image()
	{
		return this.image;
	}

	public ImageIcon get_icon()
	{
		return this.icon;
	}

	public JLabel get_label()
	{
		return this.label;
	}

	public JFrame get_frame()
	{
		return this.frame;
	}



	//==SETTER==========
	public void load_image(String dir, String img)
	{
		try
		{
	      		this.image = ImageIO.read(new File(dir+"/"+img));
	      		this.icon  = new ImageIcon(this.image);
	      		this.label.setIcon(icon);
  			this.frame.add(label); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void load_image(BufferedImage img)
	{
		this.image = img;
		this.icon  = new ImageIcon(this.image);
  		this.label.setIcon(this.icon);
		this.frame.add(this.label);
	}

	public void load_image(Image img)
	{
		this.image = img.get_image();
	}



	//==MISC.==========
	public void show()
	{
		this.frame.setVisible(true);
	}

	public void hide()
	{
		this.frame.setVisible(false);
	}	    

	private static void copy_file(File source, File dest) throws IOException 
	{
	    InputStream is = null;
	    OutputStream os = null;
	    try 
	    {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;

	        while ((length = is.read(buffer)) > 0) 
	            os.write(buffer, 0, length);
	        
	    } 
	    finally 
	    {
	        is.close();
	        os.close();
	    }
	}

	public void to_file(String file_type, String path) throws Exception
	{
		ImageIO.write(this.image, file_type, new File(path));
	}

}
