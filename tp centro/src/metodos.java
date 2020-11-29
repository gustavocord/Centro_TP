
public interface metodos{

	
	
	void agregarEspecialidad(String nombre, double valor);
	void agregarMedico(String nombre, int matricula, String nomEspecialidad,double valorTratamiento);
	void agregarPacientePrivado(String nombre, int hC, Fecha nac); 
	 void agregarPacienteAmbulatorio(String nombre, int hC, Fecha nac );
	void agregarPacienteObraSocial(String nombre, int hC, Fecha nac, String
	osocial, double p);
	
	void agregarAtencion(int hC, Fecha fecha, int matricula);
	void agregarAtencion(int hC, Fecha fecha); 
}

