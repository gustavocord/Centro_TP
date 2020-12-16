

public class Tratamiento {

	private String nombreTrata;
	private int matricula;
	
	Tratamiento (String nomTto , int matricula){ //Constructor
		this.nombreTrata = nomTto;
		this.matricula=matricula;
	
	}
	@Override
	public String toString() {
		return "Tratamiento [Nombre del tratamiento :" + this.nombreTrata + ", Medico matricula: "+ this.matricula+" Pago :" ;
	}

	

}