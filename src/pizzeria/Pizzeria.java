package pizzeria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enumerados.Tipo;

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
		boolean encontrado=false;
		for(Pizza i : this.listaPizzas) {
			if(i.getIdPizza()==pizza.getIdPizza()) {
				encontrado=true;
			}
		}
		if(encontrado) {
			throw new IllegalArgumentException("Esta pizza ya está añadida");
		}
		this.listaPizzas.add(pizza);	
	}

	public void removePizza(Pizza pizza) {
		boolean encontrado=false;
		for(Pizza i : this.listaPizzas) {
			if(i.getIdPizza()==pizza.getIdPizza()) {
				encontrado=true;
			}
		}
		if(!encontrado) {
			throw new IllegalArgumentException("Esta pizza no está añadida");
		}
		
		this.listaPizzas.remove(pizza);	
		
	}


	public void addCliente(Cliente cliente) {
		boolean encontrado=false;
		for(Cliente i : this.listaClientes) {
			if(i.getIdCliente()==cliente.getIdCliente()) {
				encontrado=true;
			}
		}
		if(encontrado) {
			throw new IllegalArgumentException("Este cliente ya está añadido");
		}
		
		
		this.listaClientes.add(cliente);
	}

	public void removeCliente(Cliente cliente) {
		boolean encontrado=false;
		for(Cliente i : this.listaClientes) {
			if(i.getIdCliente()==cliente.getIdCliente()) {
				encontrado=true;
			}
		}
		if(!encontrado) {
			throw new IllegalArgumentException("Este cliente no está añadido");
		}
		
		this.listaClientes.remove(cliente);	
	}

	public void addPedido(Pedido pedido) {
		boolean encontrado=false;
		for(Pedido i : this.listaPedidos) {
			if(i.getId()==pedido.getId()) {
				encontrado=true;
			}
		}
		if(encontrado) {
			throw new IllegalArgumentException("Este pedido ya está añadido");
		}
		this.listaPedidos.add(pedido);

	}

	public void removePedido(Pedido pedido) {
		boolean encontrado=false;
		for(Pedido i : this.listaPedidos) {
			if(i.getId()==pedido.getId()) {
				encontrado=true;
			}
		}
		if(!encontrado) {
			throw new IllegalArgumentException("Este pedidono está añadido");
		}
	
		this.listaPedidos.remove(pedido);

	}

	public void verPizzas() {
		System.out.println("\n------------------------");
		System.out.println("\nPizzas Totales");
		for(Pizza p: listaPizzas) {
			System.out.printf("\nPizza %d: %s",p.getIdPizza(),p.getNombre());
			System.out.printf("\nIngredientes: %s", p.getIngredientes());
		}
		System.out.print("\n------------------------");
	}
	public void verPedidos() {
		System.out.print("\n------------------------");
		System.out.print("\nPedidos Totales");
		for(Pedido pe: listaPedidos) {
			System.out.printf("\nNumero de Pedido: %d, cliente: %s",pe.getId(), pe.getCliente().getNombre());
		}
		System.out.print("\n------------------------");
	}
	public void verClientes() {
		System.out.print("\n------------------------");
		System.out.print("\nClientes");
		for(Cliente c: listaClientes) {
			System.out.printf("\nCliente %d: %s",c.getIdCliente(),c.getNombre());
		}
		System.out.print("\n------------------------");
	}
	
	public Cliente getClientePorId(int id) {
		Cliente c = null;
		for(Cliente cc:listaClientes) {
			if(cc.getIdCliente() == id) {
				c=cc;
			}
		}
		if(c == null) {
			throw new IllegalArgumentException("No existe un cliente con ese id");
		}
		return c;
	}
	public Pizza getPizzaPorId(int id) {
		Pizza p = null;
		for(Pizza pp:listaPizzas) {
			if(pp.getIdPizza() == id) {
				p=pp;
			}
		}
		if(p == null) {
			throw new IllegalArgumentException("No existe una pizza con ese id");
		}
		return p;
	}
	
	public void consultarCliente(int telefono) {
		boolean existe = false;
		for(Cliente elem:listaClientes) {
			if(elem.getTelefono() == telefono) {
				existe=true;
				System.out.printf("\n%d:%s",elem.getIdCliente(), elem.getNombre());
			}
		}
		if(!existe) {
			System.out.printf("\nNo se ha encontrado un cliente con ese numero.");
		}
	}
	public void consultarPizzaCon(String ingrediente) {
		boolean existe = false;
		for(Pizza p:listaPizzas) {
			if(p.getIngredientes().contains(ingrediente.toUpperCase())){
				System.out.printf("\nLa pizza %s tiene %s", p.getNombre(), ingrediente);
				existe = true;
			}
		}
		if(!existe) {
			System.out.printf("\nNo se ha encontrado una pizza con %s.", ingrediente);
		}
	}
	public void consultarPizzaSin(String ingrediente) {
		boolean existe = false;
		for(Pizza p:listaPizzas) {
			if(!p.getIngredientes().contains(ingrediente.toUpperCase())){
				System.out.printf("\nLa pizza %s no tiene %s", p.getNombre(), ingrediente);
				existe = true;
			}
		}
		if(!existe) {
			System.out.printf("\nTodas las pizzas tienen %s", ingrediente);
		}
	}
	public void consultarPedidosHoy() {
		System.out.printf("\nPedidos de hoy: ");
		for(Pedido p:listaPedidos) {
			if(p.getFecha().getDayOfYear() == LocalDate.now().getDayOfYear()) {
				System.out.printf("\nId: %d, cliente: %s", p.getId(), p.getCliente().getNombre());
			}
		}
	}
	public void consultarPedidosLocal() {
		System.out.printf("\nPedidos en el local: ");
		for(Pedido p:listaPedidos) {
			if(Tipo.valueOf(p.getTipo()) == Tipo.LOCAL) {
				System.out.printf("\nId: , cliente: %s", p.getId(), p.getCliente().getNombre());
			}
		}
	}
	public void consultarPedidosRecoger() {
		System.out.printf("\nPedidos en para recoger: ");
		for(Pedido p:listaPedidos) {
			if(Tipo.valueOf(p.getTipo()) == Tipo.RECOGER) {
				System.out.printf("\nId: %d, cliente: %s", p.getId(), p.getCliente().getNombre());
			}
		}
	}
	public void consultarPedidosDomicilio() {
		System.out.printf("\nPedidos a domicilio: ");
		for(Pedido p:listaPedidos) {
			if(Tipo.valueOf(p.getTipo()) == Tipo.DOMICILIO) {
				System.out.printf("\nId: %d, cliente: %s", p.getId(), p.getCliente().getNombre());
			}
		}
	}
	public void mostrarPizza(Pizza p) {
		if(p == null) {
			System.out.printf("\nNo puede ser nula");
		}else {
			System.out.printf("\nID: %d "
					+ "\nNombre: %s, "
					+ "\nPrecio: %.02f"
					+ "\nIngredientes: %s",p.getIdPizza(),p.getNombre(),p.getPrecio(),p.getIngredientes());
		}
	}
	
	public void mostrarPedido(Pedido pe) {
		if(pe == null) {
			System.out.printf("\nNo puede ser nula");
		}else {
			System.out.printf("\nID: %d "
					+ "\nCliente: %s, "
					+ "\nFecha: %s"
					+ "\nTipo: %s",pe.getId(),pe.getCliente().getNombre(),pe.getFecha().toString(),pe.getTipo());
		}
	}

}
