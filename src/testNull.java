import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class testNull {

	@Test
	public void test() throws FileNotFoundException {
		
		Serie serie= new Serie();
		assertNull(serie.lector());
	}

}
