import java.util.ArrayList;

public class Parqueadero {
	private ArrayList<Vehiculo> vehiculos;

	public Parqueadero() {
		this.vehiculos = new ArrayList<>();
	}

	public void registrarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public Vehiculo consultarVehiculo(String placa) {
		for (Vehiculo v : vehiculos) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				return v;
			}
		}
		return null;
	}

	public boolean actualizarVehiculo(String placa, String nuevoModelo, String nuevoPropietario) {
		Vehiculo vehiculo = consultarVehiculo(placa);
		if (vehiculo != null) {
			vehiculo.setModelo(nuevoModelo);
			vehiculo.setPropietario(nuevoPropietario);
			return true;
		}
		return false;
	}

	public ArrayList<Vehiculo> listarVehiculos() {
		return vehiculos;
	}
}
