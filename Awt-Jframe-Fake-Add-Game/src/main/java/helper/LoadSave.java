package helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class LoadSave {

    private static ConcurrentHashMap<String, BufferedImage> imageCache = new ConcurrentHashMap<>();

    public static BufferedImage loadFullImage(final String imagePath) {
        if (imageCache.containsKey(imagePath)) {
            return imageCache.get(imagePath);
        }

        try {
            final URL resource = LoadSave.class.getResource(imagePath);
            if (resource == null) {
                throw new IllegalArgumentException("Image not found: " + imagePath);
            }
            final BufferedImage image = ImageIO.read(resource);
            imageCache.put(imagePath, image);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading image: " + imagePath);
        }

        return null;
    }

}
