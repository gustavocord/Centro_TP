
public class Ambulatorio extends Paciente{

	private String tratamiento ;
	private Medico medicoResponsable;
	
	
	public Ambulatorio(String nombre, int  historia ,Fecha fecha) {
		super(nombre, historia, fecha);
		this.tratamiento=null;
	}
	
	
	@Override
	public String toString() {
		return super.toString()+"; Tipo: Ambulatorio"+ "- Ttos: "+this.tratamiento + " medico responsable :"+ medicoResponsable.toString();
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
	public String getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	// agrega un nuevo tratamiento , medico responsable e importe a pagar
public void nuevoTratamiento(String tratamiento , Medico medico ) {
	
	this.tratamiento =tratamiento ;
	this.importeApagar=medico.getHonorario()+this.importeApagar;
	this.medicoResponsable=medico;
}


public Medico getMedicoResponsable() {
	return medicoResponsable;
}



	
	
}
