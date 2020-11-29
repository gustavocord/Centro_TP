

public class Internacion {
	
	private int nrodehabitacion ;
	private String area;
	private Fecha fecha_ingreso;
	private Fecha fecha_alta;
	private double precioInternacion;
	
	
	public Internacion(String area, Fecha fecha_ingreso ,double precioInternacion) {
		this.area = area;
		this.fecha_ingreso = fecha_ingreso;
		this.precioInternacion = precioInternacion;
		this.fecha_alta=null;
	}
	
	@Override
	public String toString() {
		return "Area: "+area+"-Fecha ingreso: "+this.fecha_ingreso+"-Fecha alta: "+fecha_alta;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Internacion other = (Internacion) obj;
		if (fecha_ingreso == null) {
			if (other.fecha_ingreso != null)
				return false;
		} else if (!fecha_ingreso.equals(other.fecha_ingreso))
			return false;
		return true;
	}

	
	public int getNrodehabitacion() {
		return nrodehabitacion;
	}


	public void setNrodehabitacion(int nrodehabitacion) {
		this.nrodehabitacion = nrodehabitacion;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public Fecha getFecha_ingreso() {
		return fecha_ingreso;
	}


	public void setFecha_ingreso(Fecha fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}


	public Fecha getFecha_alta() {
		return fecha_alta;
	}


	public void setFecha_alta(Fecha fecha_alta) {
		this.fecha_alta = fecha_alta;
	}


	public double getPrecioInternacion() {
		return precioInternacion;
	}


	public void setPrecioInternacion(double precioInternacion) {
		this.precioInternacion = precioInternacion;
	}


	
	
}
