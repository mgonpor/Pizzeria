package pizzeria;

public class Cliente {
	// Atributos
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private double dineroDisponible;
	
	// Constructores
	public Cliente(String nombre, String direccion, String email, String telefono, double dineroDisponible) {
		super();
		setNombre(nombre);
		setDireccion(direccion);
		setEmail(email);
		setTelefono(telefono);
		setDineroDisponible(dineroDisponible);
	}
	public Cliente(String nombre, String direccion, String email, String telefono) {
		super();
		setNombre(nombre);
		setDireccion(direccion);
		setEmail(email);
		setTelefono(telefono);
		this.dineroDisponible = 0.0;
	}
	
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo o estar vacío");
		}
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		if(direccion == null || direccion.isBlank()) {
			throw new IllegalArgumentException("La direccion no puede ser nula o estar vacío");
		}
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email == null || email.isBlank()) {
			throw new IllegalArgumentException("El email no puede ser nulo o estar vacío");
		}
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		if(telefono == null || telefono.isBlank()) {
			throw new IllegalArgumentException("El telefono no puede ser nulo o estar vacío");
		}
		this.telefono = telefono;
	}
	public double getDineroDisponible() {
		return dineroDisponible;
	}
	public void setDineroDisponible(double dineroDisponible) {
		if(dineroDisponible < 0) {
			throw new IllegalArgumentException("El dinero disponible no puede ser negativo");
		}
		this.dineroDisponible = dineroDisponible;
	}
	
}
