/**
 * This script is a practice of transforming an image into grey image.
 */

package ImageProcessing;

import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class GrayImagePractice {
	public static void main(String[] args) throws Exception {
		
		try {
            File file = new File("week6\\src\\main\\java\\ImageProcessing");
            File inputFile = new File(file, "sample.jpg");
            File outpuFile = new File(file, "samplegrey.jpg");

			BufferedImage originalImage = ImageIO.read(inputFile);

			BufferedImage greyImage = grayImageGenerator(originalImage);

			ImageIO.write((RenderedImage) greyImage, "jpg", outpuFile);

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public static BufferedImage grayImageGenerator(BufferedImage bufferedImage) throws Exception {
 
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
 
		BufferedImage grayBufferedImage = new BufferedImage(width, height, bufferedImage.getType());
		// create a new gray buffer image obj

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				// for each pixel
				final int colorInfo = bufferedImage.getRGB(i, j);

				final int r = (colorInfo >> 16) & 0xff;
				// Extract the part for red, same logic below
				final int g = (colorInfo >> 8) & 0xff;
				final int b = colorInfo & 0xff;

				int gray = (int) (0.33 * r + 0.34 * g + 0.33 * b);
				// calculate the shadow value

				int newPixel = colorToRGB(255, gray, gray, gray);
				grayBufferedImage.setRGB(i, j, newPixel);
				// set the new pixel with only gray ARGB info to the original position
			}
		}

		return grayBufferedImage;
	}

	/*
	The tool below takes 4 parameters which are ARGB information for a pixel and convert
	them to an int java ARGB format using left shift.
	Adapted from https://blog.csdn.net/wokuailewozihao/article/details/79742651
	*/

	private static int colorToRGB(int alpha, int red, int green, int blue) {
 
		int pixelARGB = 0;
		pixelARGB += alpha;
		pixelARGB = pixelARGB << 8;
		// make space for the next value, same logic below

		pixelARGB += red;
		pixelARGB = pixelARGB << 8;
		pixelARGB += green;
		pixelARGB = pixelARGB << 8;
		pixelARGB += blue;
 
		return pixelARGB;
	}

}

