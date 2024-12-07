import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Juan Pérez", "juan@example.com");
        cliente.registrarse();
        cliente.iniciarSesion();

        Producto producto1 = new Producto(101, "Laptop", 800.00, 10);
        Producto producto2 = new Producto(102, "Smartphone", 300.00, 20);

        Pedido pedido = new Pedido(1);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        Pago pago = new Pago(1, "Tarjeta de Crédito", pedido.calcularTotal());
        pago.procesarPago();
        pago.confirmarPago();

        Factura factura = new Factura(1, cliente, pedido, pago);
        factura.crearFactura();
        factura.pagarFactura();
    }

    private static class Cliente {
        private  int idCliente;
	public String nombre;
	public String email;

	public Cliente(int idCliente, String nombre, String email) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
	}

	public void registrarse() {
		System.out.println(nombre + " se ha registrado.");
	}

	public void iniciarSesion() {
		System.out.println(nombre + " ha iniciado sesión.");
	}

	public void cerrarSesion() {
		System.out.println(nombre + " ha cerrado sesión.");
	}

	public int getIdCliente() {
		return idCliente;
	}
    }

    private static class Producto {
        private int idProducto;
	public String nombre;
	public double precio;
	public int stock;

	public Producto(int idProducto, String nombre, double precio, int stock) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public void agregarStock(int cantidad) {
		stock += cantidad;
		System.out.println("Se han agregado " + cantidad + " unidades de " + nombre + ". Stock actual: " + stock);
	}

	public void reducirStock(int cantidad) {
		if (stock >= cantidad) {
			stock -= cantidad;
			System.out.println("Se han reducido " + cantidad + " unidades de " + nombre + ". Stock actual: " + stock);
		} else {
			System.out.println("No hay suficiente stock de " + nombre);
		}
	}

	public double getPrecio() {
		return precio;
	}

	public String getnombre() {
		return nombre;
	}
        public int getidProducto() {
               return idProducto;
        }
    }

    private static class Pedido {
        private int idPedido;
	private List<Producto> listaProductos;
	private double total;

	public Pedido(int idPedido) {
		this.idPedido = idPedido;
		this.listaProductos = new ArrayList<>();
		this.total = 0.0;
	}

	public void agregarProducto(Producto producto) {
		listaProductos.add(producto);
		total += producto.getPrecio();
		System.out.println("Producto " + producto.getnombre() + " agregado al carrito. Total: " + total);
	}

	public void eliminarProducto(Producto producto) {
		if (listaProductos.remove(producto)) {
			total -= producto.getPrecio();
			System.out.println("Producto " + producto.getnombre() + " eliminado del carrito. Total: " + total);
		} else {
			System.out.println("El producto no está en el carrito.");
		}
	}

	public double calcularTotal() {
		return total;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}
        public int getidPedido() {
                return idPedido;
        }
    }

    private static class Pago {
        private int idPago;
	private String metodoPago;
	private double monto;

	public Pago(int idPago, String metodoPago, double monto) {
		this.idPago = idPago;
		this.metodoPago = metodoPago;
		this.monto = monto;
	}

	public void procesarPago() {
		System.out.println("Procesando pago #"+ idPago +" de " + monto + " dólares con el método " + metodoPago + ".");
	}

	public void confirmarPago() {
		System.out.println("Pago de " + monto + " dólares confirmado.");
	}
    }

    private static class Factura {
        private int idFactura;
	private Cliente cliente;
	private Pedido pedido;
	private Pago pago;
	private String estado;

	public Factura(int idFactura, Cliente cliente, Pedido pedido, Pago pago) {
		this.idFactura = idFactura;
		this.cliente = cliente;
		this.pedido = pedido;
		this.pago = pago;
		this.estado = "Creada";
	}

	public void crearFactura() {
		System.out.println("Factura " + idFactura + " creada para el cliente " + cliente.getIdCliente() + ".");
	}

	public void anularFactura() {
		estado = "Anulada";
		System.out.println("Factura " + idFactura + " ha sido anulada.");
	}

	public void pagarFactura() {
		estado = "Pagada";
		System.out.println("Factura " + idFactura + " ha sido pagada.");
	}

	public String getEstado() {
		return estado;
	}
    }
}