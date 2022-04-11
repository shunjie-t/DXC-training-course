package march29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriter {
	public static void main(String[] args) throws Exception {
		String a;
		
		String InputPath = "D://io//input.txt";
		String OutputPath = "D://io//output.txt";
		
		FileReader fr = new FileReader(InputPath);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(OutputPath);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while((a = br.readLine()) != null) {
			bw.write(a);
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}
