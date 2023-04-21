/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.nio.file.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;



public class App {
    public static void main(String[] args) throws IOException {

        // Get Bitmap Image File Path
        Path baldPic = Paths.get("baldy-8bit.bmp");
        System.out.println(baldPic.toAbsolutePath());

        //Use File Path to Read Bitmap Image with Buffered Image and ImageIO
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(baldPic.toUri()));
        } catch (IOException e) {
            System.out.println("Cannot Get Image: " + e.getMessage());
        }


        // 1. Gather user input
        if (args.length < 3) {
            System.err.println("Usages: java BitmapTransformer requires at least 3 arguments: input-file-path output-file-path transform-name");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];
        String transformName = args[2];

        try {
            // 3. Read the input bitmap file
            Bitmap bitmap = new Bitmap(inputFilePath);

            // 4. Apply the chosen transformation.
            bitmap.applyTransform(transformName);
            // 5. Write the output bitmap file
            bitmap.writeToFile(outputFilePath);

            // 6a. Log a success message upon completion
            System.out.println("Transform complete!");
        } catch (IOException e) {
            // 6b. Log an error message if something goes wron
            System.err.println("Error: " + e.getMessage());
        }

        new Bitmap("/baldy-8bit.bmp");
    }
}