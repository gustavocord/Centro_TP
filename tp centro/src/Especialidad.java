
public class Especialidad {

	
	private String nombre;
	private int codigo;
	private double valor;
	
	Especialidad(String nombre , double valor){
		
		this.nombre=nombre;
		this.valor=valor ;
		
	
		
	}
	@Override
	public String toString() {
		return this.nombre.toString();
	}
	public String getNombre() {
		return nombre;
	}


	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialidad other = (Especialidad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
