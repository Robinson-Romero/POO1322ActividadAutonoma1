public class Vehiculo {
	private String placa;
	private String modelo;
	private String propietario;

	public Vehiculo(String placa, String modelo, String propietario) {
		this.placa = placa;
		this.modelo = modelo;
		this.propietario = propietario;
	}

	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Vehiculo{" +
		       "placa='" + placa + '\'' +
		       ", modelo='" + modelo + '\'' +
		       ", propietario='" + propietario + '\'' +
		       '}';
	}
}
