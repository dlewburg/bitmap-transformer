package bitmap.transformer;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;

class AppTest {
    // Test the invert transformation.
    @Test
    public void testApplyInvertTransform() throws IOException {
        testApplyTransform("invert");
    }

    // Test the black and white transformation.
    @Test
    public void testApplyBlackAndWhiteTransform() throws IOException {
        testApplyTransform("blackAndWhite");
    }

    // Test the rotate transformation.
    @Test
    public void testApplyRotateTransform() throws IOException {
        testApplyTransform("rotate");
    }

    // Test per transformation on an input image.
    private void testApplyTransform(String transformName) throws IOException {
        // Set inputFile string to Path object.
        Path inputFile = new File("src/test/resources/baldy-8bit.bmp").toPath();
        // Temp output file for storing the transformed image.
        Path outputFile = Files.createTempFile("OutputFile", ".bmp");
        // Instantiate a Bitmap object for the input image.
        Bitmap bitmap = new Bitmap(inputFile.toString());

        // Apply transformation to the input image.
        bitmap.applyTransform(transformName);

        // Write transformed image to output file.
        bitmap.writeToFile(outputFile.toString());

        // Load original input image into BufferedImage object.
        BufferedImage inputImage = ImageIO.read(inputFile.toFile());
        // Load transformed output image into BufferedImage object.
        BufferedImage outputImage = ImageIO.read(outputFile.toFile());

        // Assert input and output images aren't
        assertFalse(imagesEqual(inputImage, outputImage));
    }

    // Method to compare two images for equality.
    private boolean imagesEqual(BufferedImage img1, BufferedImage img2) {
        // Get the width and height of both images.
        int width1 = img1.getWidth();
        int height1 = img1.getHeight();
        int width2 = img2.getWidth();
        int height2 = img2.getHeight();

        // Return false if the dimensions of the images do not match.
        if (width1 != width2 || height1 != height2) {
            return false;
        }

        // Compare pixel values in both images.
        for (int x = 0; x < width1; x++) {
            for (int y = 0; y < height1; y++) {
                // If any pixel value does not match, return false.
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    return false;
                }
            }
        }
        // If all pixel values match, return true.
        return true;
    }
}
