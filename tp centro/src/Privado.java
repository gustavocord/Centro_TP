
import java.util.*;
public class Privado  extends Paciente{

	private HashSet<Consulta> consultas;
	private HashSet<Fecha> guardias;

	
	Privado(String n, Integer hC, Fecha nac) {
		super(n, hC, nac);
		this.consultas= new HashSet<Consulta>();
		this.guardias= new HashSet<Fecha>();
		
		// TODO Auto-generated constructor stub
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
	public HashSet<Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(HashSet<Consulta> consultas) {
		this.consultas = consultas;
	}


	public HashSet<Fecha> getGuardias() {
		return guardias;
	}


	public void setGuardias(HashSet<Fecha> guardias) {
		this.guardias = guardias;
	}
	 	

	//agrega una guardia
public void nuevaGuardia(Fecha fecha) {
	guardias.add(fecha);
	
	
}
	
//agrega una nueva consulta al consultorio y agrega el valor del medico a importe a pagar
public void nuevaConsulta (Medico m , Fecha fecha , double valor) {
	
	 
		consultas.add(new Consulta(m,fecha ));
		this.importeApagar=valor+this.importeApagar;
		
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

}
