package pj5.IOStream;

import java.io.*;

public class SerializationTest {
	public static void main(String[] args) {
		// creates object

		Goods goods1 = new Goods("001", "PC", 3000);
		try {
			File file = new File("week5\\src\\main\\java\\pj5\\IOStream");
            File file2 = new File(file, "demo1.txt");
			FileOutputStream fos = new FileOutputStream(file2);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream(file2);
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			oos.writeObject(goods1);

			oos.flush();

			try {
				Goods goods = (Goods) ois.readObject();
				System.out.println(goods);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			fos.close();
			oos.close();
			fis.close();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}