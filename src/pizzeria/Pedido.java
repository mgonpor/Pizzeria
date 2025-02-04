package pizzeria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enumerados.Tipo;

public class Pedido {
	
	private int id;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private Tipo tipo;
	private List<Pizza> pizzas;
	
	private static int ultimoId = 0;
	private static Pedido ultimoPedido;
	
	
	public Pedido(Cliente cliente, LocalDate fecha, String tipo) {   
		this.id = ultimoId++;
		setCliente(cliente);
		setFecha(fecha);
		setTipo(tipo);
		this.pizzas = new ArrayList<Pizza>();
		ultimoPedido = this;
	}
	public int getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public double getTotal() {
		calcularTotal();
		return total;
	}
	public String getTipo() {
		return tipo.toString();
	}
	public List<Pizza> getPizzas(){
		return pizzas;
	}
	public static Pedido getUltimoPedido() {
		if(ultimoPedido==null) {
			System.out.print("No se ha hecho ningun pedido");
		}
		return ultimoPedido;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public void setTipo(String tipo) {
		this.tipo = Tipo.valueOf(tipo.toUpperCase());
	}
	
	
	
	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}
	public void removePizza(Pizza pizza) {
		boolean dentro = false;
		for(Pizza p:pizzas) {
			if(p == pizza) {
				dentro=true;
				break;
			}
		}
		if(!dentro) {
			throw new IllegalArgumentException("Esa pizza no es de este pedido.");
		}
		this.pizzas.remove(pizza);
	}
	public void removePizza(int i) {
		if(i<0 || i>=pizzas.size()) {
			throw new IllegalArgumentException("Esa posición no existe en la lista");
		}
		this.pizzas.remove(i);
	}
	
	public void calcularTotal() {
		if(pizzas.size()<1) {
			throw new IllegalArgumentException("El pedido está vacío.");
		}
		for(Pizza p:pizzas) {
			this.total += p.getPrecio();
		}
	}
	
	public void mostrarPizzasDelPedido() {
		if(pizzas.size()<=0) {
			System.out.printf("\n	Ninguna añadida aún");
		}
		for(Pizza p:pizzas) {
			System.out.printf("\n	ID: %d, Nombre: %s, Precio: %.02f"
					+ "\n	Ingredientes: %s",p.getIdPizza(),p.getNombre(),p.getPrecio(),p.getIngredientes());
		}
	}
}
