package gameUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameHome extends JPanel {

    private BufferedImage backgroundImage;
    private int width;
    private int height;

    public GameHome(String backgroundPath, int width, int height) {
        this.width = width;
        this.height = height;
        setBackground(Color.GRAY);

        try {
            backgroundImage = ImageIO.read(getClass().getResource(backgroundPath));

//            BufferedImage tThumbImage = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
//            Graphics2D tGraphics2D = tThumbImage.createGraphics(); //create a graphics object to paint to
//            tGraphics2D.setBackground( Color.WHITE );
//            tGraphics2D.setPaint( Color.WHITE );
//            tGraphics2D.fillRect( 0, 0, width, height );
//            tGraphics2D.setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );
//            tGraphics2D.drawImage( backgroundImage, 0, 0, width, height, null ); //draw the image scaled
//
//            ImageIO.write( tThumbImage, "JPG", tThumbnailTarget ); //write the image to a file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(backgroundImage, 0, 0, width, height, null);
    }
}
