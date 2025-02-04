package pizzeria;

public class Pizza {

	private static Pizza masBarata;
	private static Pizza masCara;
	private static int ultimoId = 1;

	private int id;
	private String nombre;
	private String ingredientes;
	private double precio;

	public Pizza(String nombre, double precio, String ingredientes) {
		this.id = ultimoId++;
		setIngredientes(ingredientes);
		setNombre(nombre);
		setPrecio(precio);

		if (masBarata == null) {
			masBarata = this;
		}
		if (this.precio < masBarata.precio) {
			masBarata = this;

		}

		if (masCara == null) {
			masCara = this;
		}
		if (this.precio > masCara.precio) {
			masCara = this;
		}

	}

	public static Pizza getMasBarata() {
		return masBarata;
	}

	public static Pizza getMasCara() {
		return masCara;
	}

	public String getNombre() {
		return nombre;
	}
	public int getIdPizza() {
		return id;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre de las pizzas está en blanco o nulo");
		}
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		if (ingredientes == null || ingredientes.isBlank()) {
			throw new IllegalArgumentException("El nombre de los ingredientes está en blanco o nulo");
		}
		this.ingredientes = ingredientes.toUpperCase();

	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio <= 0.0) {
			throw new IllegalArgumentException("El precio de la pizz es menor o igual cero");
		}
		this.precio = precio;

	}

	
}
