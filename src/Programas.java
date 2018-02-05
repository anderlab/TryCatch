import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Programas {


		private String titulo;
		private String genero;
		private int temporadas;
		private int capitulos;
		private int duracion;
		private Date diaEstreno;
		private String nombreProductora;
		
		
	//	SimpleDateFormat formatter = new SimpleDateFormat ("dd/mm/yyyy");
		

		
	
		
		
		//Getters y setters
		
	
		public Date getDiaEstreno() {
			return diaEstreno;
		}
		public void setDiaEstreno(Date diaEstreno) {
			this.diaEstreno = diaEstreno;
		}
//		public SimpleDateFormat getFormatter() {
//			return formatter;
//		}
//		public void setFormatter(SimpleDateFormat formatter) {
//			this.formatter = formatter;
//		}
		
		public int getDuracion() {
			return duracion;
		}
		public void setDuracion(int duracion) {
			this.duracion = duracion;
		}
			
	
		public String getNombreProductora() {
			return nombreProductora;
		}
		public void setNombreProductora(String nombreProductora) {
			this.nombreProductora = nombreProductora;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public int getTemporadas() {
			return temporadas;
		}
		public void setTemporadas(int temporadas) {
			this.temporadas = temporadas;
		}
		public int getCapitulos() {
			return capitulos;
		}
		public void setCapitulos(int capitulos) {
			this.capitulos = capitulos;
			
			
			
			
		}


	
		
		
		
		
		
		
		
		
		
		
		
}
