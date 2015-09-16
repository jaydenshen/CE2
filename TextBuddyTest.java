import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


public class TextBuddyTest {

	@Test
	public void testClearTheFile() throws IOException {
		
		FileToWrite file = new FileToWrite("textbuddy.txt");
		file.clearTheFile();
		File returnFile = file.returnFile();
		assertEquals(0,returnFile.length());
		
	}

}
