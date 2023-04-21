# bitmap-transformer

Bitmap Transformer is a simple Java application that allows users to apply various transformations to bitmap images.

## Features
The following transformations can be applied:

* Invert colors
* Convert to black and white
* Rotate the image by 90 degrees

* Usage
There are two ways to interact with the application:

Building and Running with Gradle
You can also build and run the application using Gradle:

#### Build the application:
```bash
./gradlew build
```
#### Run the application in interactive mode:
```bash
./gradlew run
```

#### Run the application with command-line arguments:
```bash
./gradlew run --args 'input output transform'
```
Replace input, output, and transform with the appropriate values.

### Dependencies
Java JDK 11 or later
Gradle 7.0 or later

### License
This project is licensed under the MIT License.

1. Gather User input:
   - [x] a. Input file path
   - [x] b. Output file path
   - [x] c. Transformation name
2. Create a Bitmap class:
   - [x] a. Define instance variables for header, width, height, pixel data, etc.
   - [x] b. Define a constructor to initialize the Bitmap object
   - [x] c. Define methods for reading, parsing, and writing bitmap files
   - [ ] d. Define methods for each transformation
3. Read the input bitmap file:
   - [x] a. Create a new Bitmap object
   - [x] b. Read the file using a BufferImage and Image I/O
   - [ ] c. Parse the file header and pixel data into the Bitmap object
4. Apply the chosen transformation.
   - [ ] a. Based on the user input, call the corresponding transformation method
   - [ ] b. Modify the pixel data of the Bitmap object according to the transformation
5. Write the transformed bitmap to the output file:
   - [ ] a. Serialize the transformed Bitmap object to binary data
   - [ ] b. Write the binary data to the output file using a FileOutputStream
6. Handle errors and log messages:
   - [ ] a. Check for invalid inputs, file paths, or transformation names, and log appropriate error messages
   - [ ] b. Log a success message upon successful completion
7. Implement testing using JUnit:
   - [ ] a. Write tests for each method in the Bitmap class
   - [ ] b. Test with valid and invalid inputs to ensure correct functionality
8. Document the project in README.md:
   - [ ] a. Describe the supported transformations
   - [ ] b. Provide examples of how to run the code and see outputs
