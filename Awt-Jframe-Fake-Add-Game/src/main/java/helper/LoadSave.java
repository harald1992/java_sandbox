package helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class LoadSave {

    private static final ConcurrentHashMap<String, BufferedImage> imageCache = new ConcurrentHashMap<>();

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

//    private static boolean isImageFile(final String imagePath) {
//        final URL resource = LoadSave.class.getResource(imagePath);
//        if (resource == null) {
//            return false;
//        }
//        return true;
//    }

    private static ArrayList<String> listFilesUsingJavaIO(final String dir) {
        final URL resource = LoadSave.class.getResource(dir);
        if (resource == null) {
            return null;
        }
        return new ArrayList<>(Stream.of(Objects.requireNonNull(new File(resource.getPath()).listFiles())).filter(file -> !file.isDirectory()).map(File::getName).toList());
    }

    public static ArrayList<BufferedImage> loadImagesFromFolder(final String folderPath) {
        final ArrayList<String> fileNames = listFilesUsingJavaIO(folderPath);
        final ArrayList<BufferedImage> list = new ArrayList<>();

        assert fileNames != null;
        for (final String fileName : fileNames) {
            System.out.println(fileName);
            if (fileName.endsWith(".png")) {
                final var img = loadFullImage(folderPath + "/" + fileName);
                if (img != null) {
                    list.add(img);
                }
            }

        }
        return list;

    }

    public static BufferedImage getSubImageFromSpriteSheet(final BufferedImage spriteSheet, final int xCord, final int yCord, final int padding) throws RasterFormatException {
        final int step = 128;

        final int spriteWidth = 128 - 2 * padding;
        final int spriteHeight = 128 - 2 * padding;
        final int x = xCord * step + padding;
        final int y = yCord * step + padding;

        return spriteSheet.getSubimage(x, y, spriteWidth, spriteHeight);
    }

}
