package com.model;
 
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Rectangle; 
import java.awt.Toolkit; 
import java.awt.Robot; 
import java.awt.image.BufferedImage; 
import java.io.IOException; 
import java.io.File; 
import javax.imageio.ImageIO; 

public class ScreenShot { 
 public static final long serialVersionUID = 1L;
 
 public ScreenShot(){
	 try { 
         Thread.sleep(120); 
         Robot r = new Robot(); 
 
         String path = "C:\\Users\\Akib\\Pictures\\PAScreenshot\\"+"PAShot"+(int) (Math.random()*10000+1)+".jpg"; 
 
         Rectangle capture =  
         new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
         BufferedImage Image = r.createScreenCapture(capture); 
         ImageIO.write(Image, "jpg", new File(path)); 
         //MainController.botSay("Saved Screenshot is opening in folder..."); 
     } 
     catch (AWTException | IOException | InterruptedException ex) { 
         System.out.println(ex); 
     }
		try {
			Desktop.getDesktop().open(new File("C:\\\\Users\\\\Akib\\\\Pictures\\\\PAScreenshot"));
		} catch (IOException e) {
			e.printStackTrace();
		}
 }
}
