package March29;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriter {
	public static void main(String[] args) throws Exception {
		int a;
		
		String InputPath = "D://io//input.txt";
		String OutputPath = "D://io//Output.txt";
		
		FileReader fr = new FileReader(InputPath);
		FileWriter fw = new FileWriter(OutputPath);
		
		while((a = fr.read()) != -1) {
			fw.write(a);
		}
		fw.flush();
		
		fr.close();
		fw.close();
	}
}
