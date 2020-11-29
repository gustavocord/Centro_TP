import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Fecha {

	private  LocalDate fecha ;
    

	public Fecha( int dia , int mes , int anio) {
		 
		this.fecha = LocalDate.of(anio, mes, dia); //le paso los parametros que usamos en el constructor para crear la fecha
	}
	
	
	
	@Override
	public String toString() {
		return this.fecha.toString();
	}
	
	// devuelve la fecha de hoy  (en el momento que se ejecuta)
	public static Fecha hoy() {
		LocalDate fecha = LocalDate.now();
		return new Fecha(fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear());
		}
	
	
	// devuelve verdadero si la fecha por parametro es menos que la de instancia
	public  boolean esMenor( Fecha fecha2) {
		
		
		return this.fecha.isBefore(fecha2.fecha);
		
	
	}
	

	
	public LocalDate getFecha() {
		return fecha;
	}


//calcula la cantidad de dias entre la fecha de la instancia y la fecha por parametro
	public int diferenciaDias(Fecha fin) {
		long dias = DAYS.between(this.fecha, fin.fecha);
		int d = (int)dias;
		return d;
	}
}
