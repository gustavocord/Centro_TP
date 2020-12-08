public abstract  class Paciente {

	
	private String nombre;
	private Integer nroHistoria;
	protected double importeApagar;
	private Fecha FechaNacimiento;
	
	
	
	
	public Paciente(String nombre , Integer historia , Fecha fecha  ) {
		
		this.nombre = nombre;
		this.nroHistoria = historia;
		this.FechaNacimiento = fecha;
		this.importeApagar =0;
	}
	
	
	@Override
	public String toString() {
		return "Paciente hC: "+this.nroHistoria+ "- "+this.nombre+"- fecha: "+this.FechaNacimiento;
	}
	
	
	public abstract double getSaldo();

	public abstract void pagarSaldo();


	public int getNroHistoria() {
		return nroHistoria;
	}



	
	
}
