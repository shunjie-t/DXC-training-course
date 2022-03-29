package March25;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileImportStream {

	public static void main(String[] args) {
		// check exceptions such as FileNotFoundException, need to be handled. Surround with try catch.
		// whereas exception handling for uncheck exceptions are optional.
		try {
			FileInputStream fis = new FileInputStream("D://");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
