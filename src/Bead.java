import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bead extends GameObject {

    private BufferedImage image;
    private AffineTransform transform;

    public Bead(String imagePath) {
        try {
            image = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pain(Graphics2D graphics2D) {
        transform = new AffineTransform();
        transform.translate(getX() + getWidth() / 2.5, getY() + getWidth() / 2.5);
        transform.rotate(Math.PI / 2 + getAngle());
        transform.translate(-(float) (image.getWidth() / 2), -(float) (image.getHeight() / 2));
        graphics2D.drawImage(image, transform, null);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        resizeImage();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        resizeImage();
    }

    private void resizeImage() {
        image = Util.resize(image, getWidth(), getHeight());
    }
}
