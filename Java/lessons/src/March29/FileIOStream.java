package march29;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOStream {
	public static void main(String[] args) throws Exception {
		String InputPath = "D://io//input.txt";
		String OutputPath = "D://io//output.txt";
		int a;
		
		FileInputStream fis = new FileInputStream(InputPath);
		FileOutputStream fos = new FileOutputStream(OutputPath);
			
		while((a = fis.read()) != -1) {
			fos.write(a);
		}
		
		fis.close();
		fos.close();
	}
}
