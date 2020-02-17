package pj5.IOStream;

import java.io.File;
import java.io.IOException;

public class FileClass {
	public static void main(String[] args) {
		// Three ways to access a file
		File file1=new File("week5\\src\\main\\java\\pj5\\IOStream\\demo1.txt");
		File file2=new File("week5\\src\\main\\java","pj5\\IOStream\\demo2.txt");
		File file3=new File("week5\\src\\main\\java\\pj5\\IOStream");
		File file4=new File(file3,"demo3.txt");
		
		System.out.println(file3.isDirectory());
		System.out.println(file3.isFile());

		//create dir
		File file=new File("week5\\src\\main\\java\\pj5");
		if(! file.exists()) {
			file.mkdirs();
		}

		//create file
		if(! file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(file1.isAbsolute());

		System.out.println(file1.getPath());

		System.out.println(file1.getAbsolutePath());

		System.out.println(file1.getName());
	}
}