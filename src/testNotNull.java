import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;



public class testNotNull {

	@Test
	public void test() throws FileNotFoundException {
		Serie serie= new Serie();
		assertNotNull(serie.lector());
	}

}
