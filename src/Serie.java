import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Serie extends Programas implements Mostrator {
	

	private int anioEmision;
	private String nombreFichero="src/seriestv";
	
	
	
	public Scanner creaLector() throws FileNotFoundException{
		
		File fichero= new File(this.nombreFichero);
		
		Scanner lectorF;
	
		lectorF = new Scanner (fichero);

		return lectorF;
		
	}
	
	
	
	
	@Override
	public void mostrarInfo() {
		
		
		System.out.println("Titulo: "+super.getTitulo());
		System.out.println("Genero: "+super.getGenero());
		System.out.println("Temporadas: "+super.getTemporadas());
		System.out.println("Numero de capitulos: "+super.getCapitulos());
		System.out.println("Duracion espisodios: "+super.getDuracion()+" minutos");
		System.out.println("Año de emision "+ this.getAnioEmision());
		System.out.println("Productora: "+super.getNombreProductora()+"\n");
		
	}

	// Getters y Setters
	public int getAnioEmision() {
		return anioEmision;
	}
	public void setAnioEmision(int anioEmision) {
		this.anioEmision = anioEmision;
	}




	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}


}
