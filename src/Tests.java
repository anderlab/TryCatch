import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class Tests {

	@Test(expected = FileNotFoundException.class)
	public void testLector1() throws FileNotFoundException {

		Serie serie = new Serie();
		serie.setNombreFichero("kaixo");
		serie.creaLector();

	}

	@Test
	public void testLector2() {

		Serie serie = new Serie();
		serie.setNombreFichero("kaixo");
		try {
			serie.creaLector();
			fail("Se esperaba FileNotfoundException");
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");

		}

	}


}
