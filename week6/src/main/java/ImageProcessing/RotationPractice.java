/**
 * This script is a practice of rotating an image.
 * Main takes a parameter which is an integer in degree, the image will rotate clockwise
 * 90 degrees x time, where x = input mod 90.
 */

package ImageProcessing;

import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class RotationPractice {
	public static void main(String[] args) throws Exception {
		
		try {
            File file = new File("week6\\src\\main\\java\\ImageProcessing");
            File inputFile = new File(file, "sample.jpg");
            File outpuFile = new File(file, "samplerotated.jpg");

            BufferedImage originalImage = ImageIO.read(inputFile);
            
            int operationNum = (Integer.parseInt(args[0])) / 90;

            for (int i = 0; i < operationNum; i++) {
                originalImage = rotateClockWise(originalImage);
            }
            
			ImageIO.write((RenderedImage) originalImage, "jpg", outpuFile);

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public static BufferedImage rotateClockWise(BufferedImage bufferedImage) throws Exception {
 
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
 
		BufferedImage rotatedImage = new BufferedImage(height, width, bufferedImage.getType());
		// create a new rotated buffer image obj

		for (int i = 0; i < width; i++) {
			for (int j = height - 1; j >= 0; j--) {
				// for each pixel
                final int colorInfo = bufferedImage.getRGB(i, j);
                // get the color info

				rotatedImage.setRGB(height - 1 - j, i, colorInfo);
				// set the new pixel to the corresponding position
			}
		}

		return rotatedImage;
	}
	
}