package pizzeria;

public class Pizza {
	private String nombre;
	private String ingredientes;
	private double precio;
	
	public Pizza(String nombre, double precio, String ingredientes) {
		setIngredientes(ingredientes);
		setNombre(nombre);
		setPrecio(precio);
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre de las pizzas está en blanco o nulo");
		}
			this.nombre = nombre;	
		}
	

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		if(ingredientes == null || ingredientes.isBlank()) {
			throw new IllegalArgumentException("El nombre de los ingredientes está en blanco o nulo");
		}
			this.ingredientes = ingredientes;	
		
		
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if(precio<=0.0) {
			throw new IllegalArgumentException("El precio de la pizz es menor o igual cero");
		}
			this.precio = precio;
		
		
	}

}
