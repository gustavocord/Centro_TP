
public class Consulta {

	private int matricula;
	private String especialidad;
	private Fecha fecha ;
	
	

	public Consulta(int matricula,Fecha fecha, String esp) {
		this.matricula = matricula;
		this.fecha = fecha;
		this.especialidad = esp;
	}

	
	@Override
	public String toString() {
		return "fecha: "+fecha+"-Matricula del medico: "+matricula +" Pago";
	}


	public Fecha getFecha() {
		return fecha;
	}


	
	String getEspecialidad() {
		return especialidad;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + matricula;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	

}
