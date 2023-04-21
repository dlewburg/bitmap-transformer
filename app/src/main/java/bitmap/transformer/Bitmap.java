package bitmap.transformer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bitmap {
    private BufferedImage image;

    // Constructor reads the image file and stores it in a BufferedImage
    public Bitmap(String inputFilePath) throws IOException {
        File name = new File(inputFilePath);
        image = ImageIO.read(name);
        return;
    }

    // Apply the specified transform to the image
    public void applyTransform(String transformName) {
        if ("invert".equals(transformName)) {
            invert();
        } else if ("blackAndWhite".equals(transformName)) {
            blackAndWhite();
        } else if ("randomize".equals(transformName)) {
            randomize();
        } else {
            System.err.println("Error: Unknown transform name: " + transformName);
        }
    }

    // Write transformed image to the output file
    public void writeToFile(String outputFilePath) throws IOException {
        ImageIO.write(image, "bmp", new File(outputFilePath));
    }

    // Invert colors of image
    private void invert() {
        // TODO: implement this method
    }

    // Convert image to black and white
    private void blackAndWhite() {
        // TODO: implement this method
    }

    // Randomize colors of image
    private void randomize() {
        // TODO: implement this method
    }
}
