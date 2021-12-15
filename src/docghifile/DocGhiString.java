package docghifile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocGhiString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("ghifile.txt");
		if(!file.exists())
			file.createNewFile();
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		int c = fileInputStream.read();
		while(c != -1) {
			System.out.print((char) c);
			c = fileInputStream.read();
		}
		fileInputStream.close();
		
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		String s = "tam biet";
		fileOutputStream.write(s.getBytes());
		fileOutputStream.close();
	}

}
