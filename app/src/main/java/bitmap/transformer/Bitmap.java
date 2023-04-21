package bitmap.transformer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class Bitmap {
    private BufferedImage image;

    // Constructor reads the image file and stores it in a BufferedImage
    public Bitmap(String inputFilePath) throws IOException {
        image = ImageIO.read(new File(inputFilePath));
    }

    // Apply the specified transform to the image
    public void applyTransform(String transformName) {
        if ("invert".equals(transformName)) {
            invert();
        } else if ("blackAndWhite".equals(transformName)) {
            blackAndWhite();
        } else if ("rotate".equals(transformName)) {
            rotate();
        } else {
            System.err.println("Error: Unknown transform name: " + transformName);
        }
    }

    // Write transformed image to the output file
    public void writeToFile(String outputFilePath) throws IOException {
        ImageIO.write(image, "bmp", new File(outputFilePath));
    }

    // Invert colors of image
    // Invert colors of image
    private void invert() {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgba = image.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
                image.setRGB(x, y, col.getRGB());
            }
        }
    }

    // Convert image to black and white
    // Convert image to black and white
    private void blackAndWhite() {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgba = image.getRGB(x, y);
                Color col = new Color(rgba, true);
                int gray = (col.getRed() + col.getGreen() + col.getBlue()) / 3;
                col = new Color(gray, gray, gray);
                image.setRGB(x, y, col.getRGB());
            }
        }
    }

    private void rotate() {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(height, width, image.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int newX = height - y - 1;
                int newY = x;
                result.setRGB(newX, newY, image.getRGB(x, y));
            }
        }

        image = result;
    }


}
