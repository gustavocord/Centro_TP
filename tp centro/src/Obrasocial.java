
import java.util.HashMap;


public class Obrasocial extends Paciente{

	
	private String nombreObrasocial;
	private double  porcentaje;
	private HashMap<Internacion ,String> internaciones;
	
	
	public Obrasocial(String nombre, Integer historia, Fecha fechaNac, String nombreObrasocial ,double porcentaje) {
		super(nombre, historia, fechaNac);
		this.nombreObrasocial = nombreObrasocial;
		this.internaciones = new HashMap <Internacion,String>();
		this.porcentaje=porcentaje;
	}
	

	
	@Override
	public String toString() {
		return super.toString()+"- nombreObrasocial: "+this.nombreObrasocial+"- Porcentaje: "+this.porcentaje ;
	}
	
	
	@Override
	public void pagarSaldo() {
		this.importeApagar=0;
	}
	
	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		return this.importeApagar;
	}

	public void nuevainternacion(String area, Fecha fecha, double precioInternacion) {
		
			internaciones.put(new Internacion(area,fecha,precioInternacion),"no");	
		
	}
public void altaInternacion (Fecha alta) {
	if (internaciones!= null ) { //verifica si hay internaciones
		
		for (Internacion i: internaciones.keySet()) {
		
			// verifica si la fecha de ingreso es menos a la de alta y la fecha de alta es nula
			if (i.getFecha_ingreso().esMenor(alta)&& i.getFecha_alta()==null ) {
				
				i.setFecha_alta(alta);
				
				int cantDias = i.getFecha_ingreso().diferenciaDias(i.getFecha_alta()); // guarda la cantidad de dias internado
				
				//calcula el importe a pagar con la cantidad de dias y porcentaje
				this.importeApagar = this.importeApagar + cantDias*(i.getPrecioInternacion()*porcentaje);
				
			}
		}
	}
}
 

// verifica si un paciente esta internado si la fecha de ingreso existe y la fecha de alta null
	public boolean estaInternado() {
		if (internaciones != null) {
			boolean internado=false;
				for (Internacion i: internaciones.keySet()) {
				internado= internado || i.getFecha_ingreso()!=null && i.getFecha_alta()==null;
			}
			return internado;
			}
		else {
			
		return false;}
	}
	public HashMap<Internacion, String> historico(){

		return internaciones;
	}

}
