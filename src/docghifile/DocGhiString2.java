package docghifile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocGhiString2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File("ghifile");
		if(!dir.exists())
			dir.mkdir();
		
		File file = new File("ghifile/test.txt");
		if(!file.exists())
			file.createNewFile();
		FileReader fileReader = new FileReader(file);
		
		int c = fileReader.read();
		while(c!= -1) {
			System.out.print((char)c);
			c = fileReader.read();
		}
		fileReader.close();
		
		FileWriter fileWriter = new FileWriter(file);
		String s = "tam biet!";
		fileWriter.write(s);
		fileWriter.close();
	}

}
