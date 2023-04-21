package bitmap.transformer;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Initialize a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Default input file path
        String defaultInputFilePath = "baldy-8bit.bmp";
        String inputFilePath;

        // Ask the user if they want to use their own bitmap
        System.out.println("Do you want to use your own bitmap? (yes/no)");
        String useOwnBitmap = scanner.nextLine().trim().toLowerCase();

        // If the user wants to use their own bitmap, prompt for the path
        if ("yes".equals(useOwnBitmap)) {
            System.out.println("Enter the path to your bitmap file:");
            inputFilePath = scanner.nextLine();
        } else {
            // If the user does not want to use their own bitmap, use the default input file path
            inputFilePath = defaultInputFilePath;
        }

        // Prompt the user to choose a transformation method
        System.out.println("Choose a transformation method:");
        System.out.println("1. Invert");
        System.out.println("2. Black and white");
        System.out.println("3. Rotate");
        System.out.println("Enter the number of the transformation method you want to use:");

        // Get the user's choice of transformation method
        int choice = scanner.nextInt();
        String transformName;

        // Set the transformName based on the user's choice
        switch (choice) {
            case 1:
                transformName = "invert";
                break;
            case 2:
                transformName = "blackAndWhite";
                break;
            case 3:
                transformName = "rotate";
                break;
            default:
                System.err.println("Invalid choice, exiting.");
                scanner.close();
                return;
        }

        // Close the scanner
        scanner.close();

        // Default output folder path
        String outputFolderPath = "output";
        // Create the output file name with a timestamp
        String outputFileName = outputFolderPath + File.separator + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + "_output.bmp";

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
        } catch (IOException e) {
            // Log an error message if something goes wrong
            System.err.println("Error: " + e.getMessage());
        }
    }
}
