

public class Medico {
	private String nombre;
	private int  matricula;
	private double honorarios;
	private String especialidad;

	Medico (String n, int mat, double hono, String especialidad){ //Constructor
		this.nombre = n;
		this.matricula= mat;
		this.honorarios= hono;
		this.especialidad= especialidad;
	}


	
	
	public int getNrodematricula() {
		return matricula;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public double getHonorario() {
		return honorarios;
	}

	
	
	@Override
	public String toString() {
		return "Medico ["+nombre + ", matricula=" + matricula + ", honorarios=" + honorarios
				+ ", especialidad=" + especialidad + "]";
	}
	
	
	
	
	
	
}
