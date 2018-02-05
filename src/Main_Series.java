
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Main_Series {

	public static void main(String[] args)  {
		
		
		final int INSERTAR = 1;
		final int LISTAR = 2;
		final int LISTAR_AÑO = 3;
		final int LISTAR_ALFAB = 4;
		final int GUARDAR = 5;
		final int MODIFICAR_TITULO=6;
		final int MODIFICAR_DURACION=7;
		final int BORRAR = 8;
		final int SALIR = 0;
		
		Serie serie;
		
		
		ArrayList <Serie> series= new ArrayList <Serie>();
		
		String nombreFichero ="src/seriestv";
		File fichero= new File(nombreFichero);
		
		Scanner lectorF;
		try {
			lectorF = new Scanner (fichero);
		
		Scanner lector= new Scanner (System.in);
		
		int opcion;
		
		//Cargamos lista
		while (lectorF.hasNextLine()){
			
			String linea =lectorF.nextLine();
			String[] arrayLinea = linea.split(",");
			
			serie= new Serie();
			
			serie.setTitulo(arrayLinea[0]);
			serie.setGenero(arrayLinea[1]);
			serie.setTemporadas(Integer.parseInt(arrayLinea[2]));
			serie.setCapitulos(Integer.parseInt(arrayLinea[3]));
			serie.setDuracion(Integer.parseInt(arrayLinea[4]));
			serie.setAnioEmision(Integer.parseInt(arrayLinea[5]));
			serie.setNombreProductora(arrayLinea[6]);
			
			series.add(serie);
		}
		
		
		do{
			
			System.out.println("---Menu---\n");
			System.out.println(INSERTAR+ " Insertar Serie");
			System.out.println(LISTAR+ " Listar Series");
			System.out.println(LISTAR_AÑO+ " Listar series por años");
			System.out.println(LISTAR_ALFAB+ " Listar series alfabeticamente");
			System.out.println(GUARDAR+" Guardar cambios");
			System.out.println(MODIFICAR_TITULO +" Cambiar titulo");
			System.out.println(MODIFICAR_DURACION+ " Cambiar duracion");
			System.out.println(BORRAR+" Borrar serie");
			System.out.println(SALIR+ " Salir");
			
			
			opcion =Integer.parseInt(lector.nextLine());
			
			switch(opcion){
			
			
			case INSERTAR:
				
				serie= new Serie();
				insertar(serie, series, lector);
				System.out.println("Serie insertada, pulse guardar para guardar los cambios, y listar para verlos");
					
				
			break;
			
			case LISTAR:
				
				listar(series);
			
			break;
			
			
			case LISTAR_AÑO:
				
				AniosComparator ac= new AniosComparator();
				series.sort(ac);
				listar(series);
				
				
				
				
			break;
				
			case LISTAR_ALFAB:
				
				TitulosComparator tc= new TitulosComparator();
				series.sort(tc);
				listar(series);
				
			break;
			
			
			
			case GUARDAR:
				
				guardarCambios(series,nombreFichero);
				System.out.println("Cambios guardados, pulse la opcion listar para ver los cambios");
				
			break;
				
			
			case MODIFICAR_TITULO:
				
				
				modificarTitulo(lector, series);
				
				
			break;	
			
			case MODIFICAR_DURACION:
				
				
				modificarDuracion(lector, series);
				
			break;
			
			case BORRAR:
				
				borrar(series, lector);
				System.out.println("Serie borrada, recuerde pulsar guardar para guardar los cambios, y listar para verlos");
				
				
				
			break;
			
				case SALIR:
				
				System.out.println("Saliendo....");
				break;

			default:
				System.out.println("Opcion mal");
				break;
			
			}
			
		
			
			
		}while(opcion!=SALIR);
		
		
		
		
		}catch (FileNotFoundException e) {
			
			//System.err.println("No se ha encontrado el fichero especificado" +" --Error: "+ e.getMessage());
			
			System.out.print("No se encuentra la ruta especificada --> ");
			System.err.println (nombreFichero);
			
		}catch (NullPointerException e ){
			
			System.err.println("Alguno de los campos introducidos es nulo, porfavor rellene todos los campos" +" --Error: "+ e.getMessage());
			
		}catch (NumberFormatException e){
			System.err.println("Error en el formato de datos insertados, o datos insertados vacios"+" --Error: "+ e.getMessage());
			
		}
		
		
	}






	//Metodos

	private static void borrar(ArrayList<Serie> series, Scanner lector) {
		Iterator <Serie> i= series.iterator();
		
		
		System.out.println("Introduce el titulo de la serie a borrar: ");
		String tituloB= lector.nextLine();
		
		while(i.hasNext()){
			
			Serie s= i.next();
			
			if(s.getTitulo().equals(tituloB)){
				i.remove();
			}
			
			
			
		}
		
	}

	
	
	


	private static void insertar(Serie serie, ArrayList<Serie> series, Scanner lector) {
		System.out.println("Introduce nombre de la serie");
		String nombre =lector.nextLine();
		
		System.out.println("Introduce genero de la serie");
		String genero = lector.nextLine();
		
		System.out.println("Introduce temporadas de la serie");
		int temporadas = Integer.parseInt(lector.nextLine());
		
		System.out.println("Introduce capitulos de la serie");
		int capitulos = Integer.parseInt(lector.nextLine());
		
		System.out.println("Introduce duracion de los capitulos en minutos");
		int duracion = Integer.parseInt(lector.nextLine());
		
		System.out.println("Introduce año de emision de la serie");
		int anioEmision = Integer.parseInt(lector.nextLine());
		
		System.out.println("Introduce nombre de la productora");
		String productora = lector.nextLine();
		
		System.out.println("Introduce fecha de estreno [dd/mm/yyyy]");
		String estreno= lector.nextLine();
		
	//	SimpleDateFormat formatter = new SimpleDateFormat ("dd/mm/yyyy");
		
		
		serie.setTitulo(nombre);
		serie.setGenero(genero);
		serie.setTemporadas(temporadas);
		serie.setCapitulos(capitulos);
		serie.setDuracion(duracion);
		serie.setAnioEmision(anioEmision);
		serie.setNombreProductora(productora);
		//serie.setDiaEstreno(formatter.parse(estreno));
		series.add(serie);
		
		
	}
	
	
	private static void listar(ArrayList<Serie> series) {
		
		
		if(series.isEmpty()){
			System.out.println("La lista esta vacia");
		}else{
			
			Iterator <Serie> i = series.iterator();
			
			while(i.hasNext()){
				
				Serie s = i.next();
				
				s.mostrarInfo();
				
				
			}
			
		}
		
	}
	
	
	private static void guardarCambios( ArrayList <Serie> series, String nombreFichero){
		
		FileWriter fileWriter= null;
		
		try{
			
			fileWriter = new FileWriter (nombreFichero);
			PrintWriter printWriter = new PrintWriter (fileWriter);
			
			Iterator <Serie> it = series.iterator();
			
			while(it.hasNext()){
				Serie serie=it.next();
				printWriter.println(serie.getTitulo()+","+serie.getGenero()+","+serie.getTemporadas()+","+serie.getCapitulos()+","+serie.getDuracion()+","+serie.getAnioEmision()+","+serie.getNombreProductora());
			}
			fileWriter.close();
			
			
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	private static void modificarTitulo(Scanner lector1, ArrayList<Serie> series) {
		
		System.out.println("Introduce el nombre de la serie para cambiarle el titulo");
		
		String titulo1= lector1.nextLine();
		
		System.out.println("Introduce el nuevo titulo");
		
		String tituloN = (lector1.nextLine());
		
		
		if(series.isEmpty()){
			System.out.println("Esa serie no esta en la lista");
		}else{
			
			Iterator <Serie> i = series.iterator();
			
			while(i.hasNext()){
				
				Serie s = i.next();
				
				if(s.getTitulo().equals(titulo1)){
					
					s.setTitulo(tituloN);;
				}
				
				
				}
			}
			
		}
		
		
		private static void modificarDuracion(Scanner lector1, ArrayList<Serie> series) {
			
			System.out.println("Introduce el nombre de la serie para cambiarle la duracion");
			
			String titulo1= lector1.nextLine();
			
			System.out.println("Introduce la nueva duracion");
			
			int duracionN = (Integer.parseInt(lector1.nextLine()));
			
			
			if(series.isEmpty()){
				System.out.println("Esa serie no esta en la lista");
			}else{
				
				Iterator <Serie> i = series.iterator();
				
				while(i.hasNext()){
					
					Serie s = i.next();
					
					if(s.getTitulo().equals(titulo1)){
						
						s.setDuracion(duracionN);;;
					}
					
					
				}
				
			}
		
		
		
	}



}
