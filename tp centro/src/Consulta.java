
public class Consulta {

	
	private Medico medico ;
	private Fecha fecha ;
	
	

	public Consulta(Medico medico, Fecha fecha) {
		this.medico = medico;
		this.fecha = fecha;
	}



	public Fecha getFecha() {
		return fecha;
	}


	
	String getEspecialidad() {
		return medico.getEspecialidad();
	}
}
