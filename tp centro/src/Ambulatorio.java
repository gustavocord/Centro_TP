import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Ambulatorio extends Paciente{

	private HashMap<Tratamiento,String>tratamientos ;

	
	
	public Ambulatorio(String nombre, int  historia ,Fecha fecha) {
		super(nombre, historia, fecha);
		this.tratamientos=new HashMap<Tratamiento,String>();
	}
	
	
	
	@Override
	public String toString() {
		return super.toString()+"; Tipo: Ambulatorio"+ "- Ttos: "+tratamientos.toString();
	}

	@Override
	public void pagarSaldo() {
		this.importeApagar=0;
		Iterator<Entry<Tratamiento,String>> it = tratamientos.entrySet().iterator();
 		while (it.hasNext()) {
 			Map.Entry<Tratamiento,String> trata = it.next();
 			if (trata.getValue().equals("no")) {
 				tratamientos.put(trata.getKey(), "si");
 			}
 				}
	}
	
	public double getSaldo() {
		// TODO Auto-generated method stub
		return this.importeApagar;
	}
	
	
	
	// agrega un nuevo tratamiento , medico responsable e importe a pagar
public void nuevoTratamiento(String tratamiento , Medico medico ) {
	
	this.tratamientos.put(new Tratamiento(tratamiento,medico.getMatricula()) ,"no");
	this.importeApagar=medico.getHonorario() +this.importeApagar;
	
}

public HashMap<Tratamiento, String> historico(){

	return tratamientos;
}





	
	
}
