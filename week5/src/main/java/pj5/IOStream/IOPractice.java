/*
bit stream, comparing to string stream from last week
*/
package pj5.IOStream;

import java.io.*;

public class IOPractice {
	public static void main(String[] args) {
		// copy file
		try {
            File file = new File("week5\\src\\main\\java\\pj5\\IOStream");
            File file2 = new File(file, "sample.jpg");
            File file3 = new File(file, "samplecopy.jpg");
			FileInputStream fis=new FileInputStream(file2);
			BufferedInputStream bis=new BufferedInputStream(fis);
			FileOutputStream fos=new FileOutputStream(file3);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			int n=0;
			byte[] b=new byte[1024];
			
			while((n=bis.read(b))!=-1){
				bos.write(b,0,n);
			}
            bos.flush();

			fis.close();
			fos.close();
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}
