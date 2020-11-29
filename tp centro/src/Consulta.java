
public class Consulta {

	
	private Medico medico ;
	private Fecha fecha ;
	
	

	public Consulta(Medico medico, Fecha fecha) {
		this.medico = medico;
		this.fecha = fecha;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	
	String getEspecialidad() {
		return medico.getEspecialidad();
	}
}
