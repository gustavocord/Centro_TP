public abstract  class Paciente {

	
	private String nombre;
	private Integer nroHistoria;
	protected double importeApagar;
	private Fecha fecha;
	
	
	
	
	public Paciente(String nombre , Integer historia , Fecha fecha  ) {
		
		this.nombre = nombre;
		this.nroHistoria = historia;
		this.fecha = fecha;
		this.importeApagar =0;
	}
	
	
	@Override
	public String toString() {
		return "Paciente hC: "+this.nroHistoria+ "- "+this.nombre+"- fecha: "+this.fecha;
	}
	
	
	public abstract double getSaldo();

	public abstract void pagarSaldo();


	public int getNroHistoria() {
		return nroHistoria;
	}



	
	
}
