
package VIEW;

/**
 *
 * @author weak_2030
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;

public class ItProjectII {
    
    static SplashScreen mySplash;                   // instantiated by JVM we use it to get graphics
    static Graphics2D splashGraphics;               // graphics context for overlay of the splash image
    static Rectangle2D.Double splashTextArea;       // area where we draw the text
    static Rectangle2D.Double splashProgressArea;   // area where we draw the progress bar
    static Font font;                               // used to draw our text


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        splashInit();           // initialize splash overlay drawing parameters
        appInit();              // simulate what an application would do before starting
        if (mySplash != null)   // check if we really had a spash screen
            mySplash.close();   // we're done with it
        
    //    UserLogIn main = new UserLogIn();
     //   main.setVisible(true);
     //   main.setTitle("Ocampo's Battery Trading and Autosupply Inventory System");
     //   main.setLocationRelativeTo(null);
        
        
       Main main = new Main();
      main.setVisible(true);
       main.setTitle("Just Another Inventory System");
                
    }
    
private static void appInit()
    {
        for (int i = 1; i <= 10; i++)
        {   
            int pctDone = i * 10;       
            splashText("Doing task #" + i);     
                       
            try
            {
                Thread.sleep(1000);           
            }
            catch (InterruptedException ex)
            {
                break;
            }
        }
    }

    
    private static void splashInit()
    {
        // the splash screen object is created by the JVM, if it is displaying a splash image
        
        mySplash = SplashScreen.getSplashScreen();
        // if there are any problems displaying the splash image
        // the call to getSplashScreen will returned null

        if (mySplash != null)
        {
            // get the size of the image now being displayed
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;

            // stake out some area for our status information
            splashTextArea = new Rectangle2D.Double(15., height*0.88, width * .45, 32.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height*.92, width*.4, 12 );

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 14);
            splashGraphics.setFont(font);

            // initialize the status info
            
            
        }
    }
    
    public static void splashText(String str)
    {
        if (mySplash != null && mySplash.isVisible())
        {  
           

          
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int)(splashTextArea.getX() + 10),(int)(splashTextArea.getY() + 15));

        
            mySplash.update();
        }
    }
 
 

}

