
import java.util.*;
import java.util.Map.Entry;


public class Privado extends Paciente{

	private HashMap<Consulta,String> consultas;
	private HashSet<Fecha> guardias;


	
	Privado(String n, Integer hC, Fecha nac) {
		super(n, hC, nac);
		this.consultas= new HashMap<Consulta,String>();
		this.guardias= new HashSet<Fecha>();
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pagarSaldo() {
		this.importeApagar=0;
		Iterator<Entry<Consulta,String>> it = consultas.entrySet().iterator();
 		while (it.hasNext()) {
 			Map.Entry<Consulta,String> c = it.next();
 			if (c.getValue().equals("no")) {
 				consultas.put(c.getKey(), "si");
 			}
			
 			
		}
		
		
	}
	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		return this.importeApagar;
	}
	
	

	


//agrega una guardia
public void nuevaGuardia(Fecha fecha) {
	guardias.add(fecha);
	
	
}
	
//agrega una nueva consulta al consultorio y le pasa a consulta el medico a cargo
public void nuevaConsulta (int matricula , Fecha fecha ,String espe, double valorEspe ) {
	
	 	Consulta c = new Consulta(matricula,fecha,espe );
		consultas.put(c,"no");
		this.importeApagar=valorEspe + this.importeApagar;
		
		
		
		
}

//verifica si el paciente hizo una consulta el dia que se quiere atender en consultorio
public boolean hizoConsulta(Fecha fecha) {
	if (consultas!=null ) {
		for(Consulta c: consultas.keySet() ) {
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
 		
			Iterator<Entry<Consulta,String>> it = consultas.entrySet().iterator();
 		while (it.hasNext()) {
 			Map.Entry<Consulta,String> c = it.next();
 			registro.put(c.getKey().getFecha(), c.getKey().getEspecialidad());
 			}
		}
		return registro;
}

public HashMap<Consulta, String> historico(){

	return consultas;
}


}
