package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
	private String nombre;
	private List<Pizza> listaPizzas;
	private List<Pedido> listaPedidos;
	private List<Cliente> listaClientes;

	public Pizzeria(String nombre) {
		setNombre(nombre);
		this.listaClientes = new ArrayList<Cliente>();
		this.listaPedidos = new ArrayList<Pedido>();
		this.listaPizzas = new ArrayList<Pizza>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addPizza(Pizza pizza) {
		this.listaPizzas.add(pizza);
	}

	public void removePizza(Pizza pizza) {
		this.listaPizzas.remove(pizza);
	}

	public void addCliente(Cliente cliente) {
		this.listaClientes.add(cliente);
	}

	public void removeCliente(Cliente cliente) {
		this.listaClientes.remove(cliente);

	}

	public void addPedido(Pedido pedido) {
		this.listaPedidos.add(pedido);

	}

	public void removePedido(Pedido pedido) {
		this.listaPedidos.remove(pedido);

	}
}
