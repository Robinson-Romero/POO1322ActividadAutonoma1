import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Parqueadero parqueadero = new Parqueadero();
		int opcion;

		do {
			System.out.println("1. Registrar vehiculo");
			System.out.println("2. Consultar vehiculo");
			System.out.println("3. Actualizar vehiculo");
			System.out.println("4. Listar vehiculos");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opcion: ");
			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				// Registro
				System.out.print("Ingrese la placa: ");
				String placa = scanner.nextLine();
				System.out.print("Ingrese el modelo: ");
				String modelo = scanner.nextLine();
				System.out.print("Ingrese el propietario: ");
				String propietario = scanner.nextLine();
				parqueadero.registrarVehiculo(new Vehiculo(placa, modelo, propietario));
				System.out.println("Vehiculo registrado con exito.");
				break;

			case 2:
				// Consulta
				System.out.print("Ingrese la placa a consultar: ");
				String placaConsulta = scanner.nextLine();
				Vehiculo vehiculoConsultado = parqueadero.consultarVehiculo(placaConsulta);
				if (vehiculoConsultado != null) {
					System.out.println("Vehiculo encontrado: " + vehiculoConsultado);
				} else {
					System.out.println("Vehiculo no encontrado.");
				}
				break;

			case 3:
				// Actualizacion
				System.out.print("Ingrese la placa del vehiculo a actualizar: ");
				String placaActualizar = scanner.nextLine();
				System.out.print("Ingrese el nuevo modelo: ");
				String nuevoModelo = scanner.nextLine();
				System.out.print("Ingrese el nuevo propietario: ");
				String nuevoPropietario = scanner.nextLine();
				boolean actualizado = parqueadero.actualizarVehiculo(placaActualizar, nuevoModelo, nuevoPropietario);
				if (actualizado) {
					System.out.println("Vehiculo actualizado con exito.");
				} else {
					System.out.println("Vehiculo no encontrado.");
				}
				break;

			case 4:
				// Listar vehC-culos
				System.out.println("Lista de vehiculos:");
				for (Vehiculo v : parqueadero.listarVehiculos()) {
					System.out.println(v);
				}
				break;

			case 0:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opcion no valida. Intente de nuevo.");
				break;
			}
		} while (opcion != 0);

		scanner.close();
	}
}
