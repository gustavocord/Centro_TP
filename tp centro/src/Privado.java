
import java.util.*;
public class Privado  extends Paciente{

	private HashSet<Consulta> consultas;
	private HashSet<Fecha> guardias;
	private HashSet<Consulta> consultasPagas;

	
	Privado(String n, Integer hC, Fecha nac) {
		super(n, hC, nac);
		this.consultas= new HashSet<Consulta>();
		this.guardias= new HashSet<Fecha>();
		this.consultasPagas = new HashSet<Consulta>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pagarSaldo() {
		this.importeApagar=0;
		this.consultasPagas=(HashSet<Consulta>) this.consultas.clone();
	}
	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		return this.importeApagar;
	}


	
	

	public HashSet<Consulta> getConsultasPagas() {
		return consultasPagas;
	}

//agrega una guardia
public void nuevaGuardia(Fecha fecha) {
	guardias.add(fecha);
	
	
}
	
//agrega una nueva consulta al consultorio y le pasa a consulta el medico a cargo
public void nuevaConsulta (Medico m , Fecha fecha , double valorEspe ) {
	
	 
		consultas.add(new Consulta(m,fecha ));
		this.importeApagar=valorEspe + this.importeApagar;
		
		
		
}

//verifica si el paciente hizo una consulta el dia que se quiere atender en consultorio
public boolean hizoConsulta(Fecha fecha) {
	if (consultas!=null ) {
		for(Consulta c: consultas ) {
			if (c.getFecha().equals(Fecha.hoy())) {
				return true ;
			}
		}
	}return false;
}
//verifica si el paciente hizo una consulta el dia que se quiere atender en guardia
public boolean hizoConsultaguardia(Fecha fecha) {
	if (guardias!=null ) {
		for(Fecha f: guardias ) {
			if (f.equals(Fecha.hoy())) {
				return true ;
			}
		}
	}return false;
}

//devuelve un hashmap de todas las atenciones en consultorio
public HashMap<Fecha, String> atCE(){
		HashMap<Fecha, String> registro = new HashMap<Fecha, String>();
		if (consultas != null) {
 		
			Iterator<Consulta> it = consultas.iterator();
 		while (it.hasNext()) {
 			Consulta c = it.next();
 			registro.put(c.getFecha(), c.getEspecialidad());
 			}
		}
		return registro;
}

public HashMap<Fecha, String> consultasP(){
	HashMap<Fecha, String> registro = new HashMap<Fecha, String>();
	if (consultasPagas != null) {
		
		Iterator<Consulta> it = consultasPagas.iterator();
		while (it.hasNext()) {
			Consulta c = it.next();
			registro.put(c.getFecha(), c.getEspecialidad());
			}
	}
	return registro;
}

}
