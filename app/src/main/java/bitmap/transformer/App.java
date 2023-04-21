package bitmap.transformer;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String inputFilePath;
        String outputFolderPath;
        String transformName;

        if (args.length > 0) {
            // Use command-line arguments
            inputFilePath = args[0];
            if (args.length > 1) {
                outputFolderPath = args[1];
            } else {
                outputFolderPath = "output";
            }
            if (args.length > 2) {
                transformName = args[2];
            } else {
                transformName = "rotate";
            }
        } else {
            // Use interactive mode
            boolean useOwnImage = askUseOwnImage();
            if (useOwnImage) {
                inputFilePath = getInputFilePath();
                outputFolderPath = getOutputFolderPath();
            } else {
                inputFilePath = "baldy-8bit.bmp";
                outputFolderPath = "output";
            }
            transformName = getTransformName();
        }

        System.out.println("Using input file: " + inputFilePath);
        System.out.println("Applying transformation: " + transformName);

        // Create the output file name with a timestamp
        String outputFileName = outputFolderPath + File.separator + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + "_output.bmp";
        System.out.println("Saving output to: " + outputFileName);

        try {
            // Read the input bitmap file
            Bitmap bitmap = new Bitmap(inputFilePath);

            // Apply the chosen transformation
            bitmap.applyTransform(transformName);

            // Check if the output folder exists, and create it if it doesn't
            File outputFolder = new File(outputFolderPath);
            if (!outputFolder.exists()) {
                outputFolder.mkdir();
            }

            // Write the output bitmap file
            bitmap.writeToFile(outputFileName);

            // Log a success message upon completion
            System.out.println("Transform complete!");
            System.out.println("You can find the output image at: " + outputFileName);
        } catch (IOException e) {
            // Log an error message if something goes wrong
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static boolean askUseOwnImage() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user if they want to use their own image
        System.out.println("Do you want to use your own image? (yes/no)");
        String useOwnImage = scanner.nextLine().trim().toLowerCase();

        return "yes".equals(useOwnImage);
    }

    private static String getInputFilePath() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the input file path
        System.out.println("Enter the path to your image file:");
        String inputFilePath = scanner.nextLine();

        return inputFilePath;
    }

    private static String getOutputFolderPath() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the output folder path
        System.out.println("Enter the path to the output folder (default is 'output'):");
        String outputFolderPath = scanner.nextLine();

        if (outputFolderPath.isEmpty()) {
            return "output";
        } else {
            return outputFolderPath;
        }
    }

    private static String getTransformName() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose a transformation method
        System.out.println("Choose a transformation method:");
        System.out.println("1. Invert");
        System.out.println("2. Black and white");
        System.out.println("3. Rotate");
        System.out.println("Enter the number of the transformation method you want to use (default is 3. Rotate):");

        // Get the user's choice of transformation method
        int choice = scanner.nextInt();

        // Set the transformName based on the user's choice
        switch (choice) {
            case 1:
                return "invert";
            case 2:
                return "blackAndWhite";
            case 3:
            default:
                return "rotate";
        }
    }
}