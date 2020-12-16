

// mañana seguir y revisar error por error
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Centro implements Interfaz  {
	HashMap<Integer, Paciente> pacientes; 
	HashMap<Integer, Medico> medicos;        
	HashMap<String ,Especialidad> especialidades; 
	String nombre;
	String CUIT;
	double precioInternacion;

	Centro ( String nombre, String CUIT, double pInternacion){
		this.CUIT = CUIT;
		this.nombre = nombre;
		this.precioInternacion = pInternacion;
		this.pacientes = new HashMap<Integer, Paciente>();
		this.medicos = new HashMap<Integer, Medico>();
		this.especialidades = new HashMap<String ,Especialidad> ();
	}
	
	
	@Override
	public String toString() { 
		StringBuilder sb = new StringBuilder();
		sb.append("----------"+this.nombre+"---------");
		sb.append("\nCUIT: "+this.CUIT);
		sb.append("\n Medicos: "+medicos.toString());
		sb.append("\nEspecialidades que ofrece el Centro: "+this.especialidades);
		sb.append("\nPacientes del Centro:"+pacientes.toString());
		sb.append("\nPrecio de internacion por dia: "+this.precioInternacion+"$");
		
		return sb.toString();
	}
	
	 
	public void agregarEspecialidad(String nombre, double valor) {	

		if (!this.especialidades.containsKey(nombre)) {
			this.especialidades.put(nombre,new Especialidad(nombre,valor));
			
		} else
			throw new RuntimeException("Esa especialidad ya exixte");
}
	
	public void agregarMedico(String nombre, int  matricula, String nomEspecialidad,double valorTratamiento) {
	
		if (medicos.containsKey((Integer)matricula)) {

			throw new RuntimeException("ERROR el medico ya existe ");
			
		}
		else {
		
		medicos.put(matricula, new Medico(nombre, (Integer)matricula,valorTratamiento,nomEspecialidad));
		}
	}//asegurada la no repeticion porque .put lo garantiza dado que matricula es key
	
		
		
	public void agregarPacientePrivado(String nombre, int hC, Fecha nac) {
		if(pertenecePrivado(hC)) {
			throw new RuntimeException("ERROR el paciente ya existe ");
		}
		pacientes.put(hC, new Privado(nombre, (Integer)hC, nac));

	}
	public void agregarPacienteAmbulatorio(String nombre, int hC, Fecha nac) {
		if(perteneceAmbulatorio(hC)) {
			throw new RuntimeException("ERROR el paciente ya existe ");
		}
		pacientes.put(hC, new Ambulatorio(nombre, (Integer)hC, nac));

	}
	public void agregarPacienteObraSocial(String nombre, int hC, Fecha nac, String osocial, double porcentaje) {
		if (perteneceOsocial(hC)) {
			throw new RuntimeException("ERROR el paciente ya existe ");
		}
		pacientes.put(hC, new Obrasocial(nombre, (Integer)hC, nac ,osocial ,porcentaje));
	}
	
	
	public void agregarAtencion(int hC, Fecha fecha, int matricula) { //agrega consulta en consultorio
		
		Medico m = medicos.get((Integer)matricula);
		//verifica que el paciente sea de tipo privado y que exista la hc en el centro
		if(pertenecePrivado(hC)) {
			Privado ob= (Privado)pacientes.get(hC);
			if (!ob.hizoConsulta(fecha)) // verifca si hizo consulta en consultorio
				
					//si la especialidad esta contenida en un medico
					if (especialidades.containsKey(m.getEspecialidad()))  
					{	
						ob.nuevaConsulta(matricula ,fecha,m.getEspecialidad() ,especialidades.get(m.getEspecialidad()).getValor() );
					}
					else {
						throw new RuntimeException("ERROR al agregar la consulta");
					}
				 			
			  }	
			}
	
	public void agregarAtencion(int hC, Fecha fecha) { //en guardia
		if(pertenecePrivado(hC)) {
			Privado ob= (Privado)pacientes.get(hC);
				if(!ob.hizoConsultaguardia(fecha)) { //si no hizo consulta en guardia lo agrego
					ob.nuevaGuardia(fecha);
					}
		}
	} 
	
	//agregar internacion
	
	public void agregarInternacion(int hC, String area, Fecha fingreso) {
			//verifico que el paciente sea de obra social y sea valido
		if (perteneceOsocial(hC)) { 
			Obrasocial ob = (Obrasocial)pacientes.get((Integer)hC);
				//si el paciente no esta internado lo agrego a internacion
				if(!ob.estaInternado())
					ob.nuevainternacion(area,fingreso,this.precioInternacion);
			}
		}
		
	//doy de alta un paciente 
	public void altaInternacion(int hC, Fecha fechaAlta) {
		if (perteneceOsocial(hC))
		{
			Obrasocial ob= (Obrasocial)pacientes.get(hC);
			ob.altaInternacion(fechaAlta);
		}
		
	}
	
	
	public void agregarTratamiento(int hC, int matricula, String tratamiento) {
		// verifico que el paciente y el medico sean validos
		if(perteneceAmbulatorio(hC) && perteneceMedico(matricula)) {
			Ambulatorio amb = (Ambulatorio) pacientes.get((Integer)hC);
			amb.nuevoTratamiento(tratamiento,medicos.get((Integer)matricula));
		}
		
	
	}
	
	
	public double getSaldo(int hC) {
		return (pacientes.get(hC).getSaldo());
			
		
	}
	
	public void pagarSaldo(int hC) {
		if (pertenecePaciente(hC)) 
		{
			pacientes.get(hC).pagarSaldo();
		}
	}
	
	public Map<Fecha, String> atencionesEnConsultorio(int hC){
		if (pertenecePrivado(hC)) {
			Privado p = (Privado)pacientes.get((Integer)hC);
			return p.atCE();
		}
		return null;
		
	}
	
	//devuelve lista internacdos

	public LinkedList<Integer> listaInternacion(){  //Devuelve una lista con las hC de la pacientes internados
		LinkedList<Integer> nueva = new LinkedList<Integer>();
		//por cada paciente de paciente de obra social
		for (Paciente paciente : pacientes.values()) {
			
			if (perteneceOsocial(paciente.getNroHistoria())) {
				
				Obrasocial ob = (Obrasocial)paciente;
					//si el paciente esta internado le doy el alta
					if (ob.estaInternado()){
						nueva.add(paciente.getNroHistoria());
				}
				
			}
		}
			
		
		return nueva;
	}
// metodos que corroboran si pertenecen al centro
	public boolean pertenecePaciente(int nroHistoria) {
		
		return pacientes.containsKey((Integer)nroHistoria);
		
	}
	
	
	public boolean pertenecePrivado(int hC) {
		return (pacientes.containsKey((Integer)hC)&& pacientes.get((Integer)hC) instanceof Privado);
		
	}
	
	
	public boolean perteneceOsocial(int hC) {
		return (pacientes.containsKey((Integer)hC)&& pacientes.get((Integer)hC) instanceof Obrasocial);
	}
	
	
	public boolean perteneceAmbulatorio(int hC) {
		return (pacientes.containsKey((Integer)hC)&& pacientes.get((Integer)hC) instanceof Ambulatorio);
		
	}
	
	public boolean perteneceMedico(int matricula) {
		return (medicos.containsKey((Integer)matricula));
		
	}
	
	////prueba de funcionamiento
	//void consultasPagas (Integer hC) {
	//		Privado p = (Privado)pacientes.get(hC);
	//		System.out.println(p.consultasP());
	//	
	//}
/////////////////////////////////////////////////////

	
	
	
public static void main(String[] args) {

	Centro centro=new Centro("Centro Medico Dolores Fuentes","30-36542563-0",3000);
	centro.agregarEspecialidad("Pediatria",2000);
	centro.agregarEspecialidad("Cardiologia",3000);
	centro.agregarEspecialidad("Traumatologia",2500);
	centro.agregarMedico("Dr Perez", 55555, "Pediatria", 5000);
	centro.agregarMedico("Dr Rodriguez", 66666, "Cardiologia", 8000);
	centro.agregarMedico("Dr Curetta", 77777, "Traumatologia", 2000);
	centro.agregarPacientePrivado("Juan", 111, new Fecha(20,11,1980));
	centro.agregarPacienteObraSocial("Carlos", 222, new Fecha(15,1,1940), "Pami",
	0.3);
	centro.agregarPacienteAmbulatorio("Pedro", 333, new Fecha(28,2,1970));
	centro.agregarPacienteObraSocial("Jose", 444, new Fecha(15,1,1940), "Ospe",
	0.2);
	centro.agregarAtencion(111, new Fecha(25,10,2020));
	centro.agregarAtencion(111, Fecha.hoy(), 55555);
	System.out.println("Lista de internacion:" + centro.listaInternacion());
	System.out.println("\nSe agrega una internacion...\n");
	centro.agregarInternacion(222,"Cardiologia",new Fecha(20,10,2020));
	System.out.println("Lista de internacion:" + centro.listaInternacion());
	System.out.println("\nSe da de alta la internacion...\n");
	centro.altaInternacion(222, new Fecha(14,11,2020));
	System.out.println("Lista de internacion:" + centro.listaInternacion());
	System.out.println("\nSe agregan dos nuevas internaciones...\n");
	centro.agregarInternacion(222,"General",new Fecha(16,11,2020));//cambio
	centro.agregarInternacion(444,"Pediatria",new Fecha(17,11,2020));
	System.out.println("Lista de internacion:" + centro.listaInternacion());
	centro.agregarTratamiento(333, 66666, "Angioplastia");
	System.out.println("\n\n" + centro.toString());
	System.out.println("Deuda paciente HC 111: " + centro.getSaldo(111));
	System.out.println("Deuda paciente HC 222: " + centro.getSaldo(222));
	System.out.println("Deuda paciente HC 333: " + centro.getSaldo(333));
	System.out.println("\nSaldando deudas...\n");
	centro.pagarSaldo(111);
	centro.pagarSaldo(333);
	centro.pagarSaldo(222);
	System.out.println("Deuda paciente HC 111: " + centro.getSaldo(111));
	System.out.println("Deuda paciente HC 222: " + centro.getSaldo(222));
	System.out.println("Deuda paciente HC 333: " + centro.getSaldo(333));
	System.out.println("\n\n"+centro.toString());
	System.out.println("\nAgrego nueva atencion paciente 111...\n");
	centro.agregarAtencion(111, new Fecha(18,11,2020),77777);
	System.out.println("Atenciones paciente 111:");
	centro.agregarAtencion(111, new Fecha(18,11,2020),77777);
	System.out.println(centro.atencionesEnConsultorio(111));
	
	
	
	}





	

}
