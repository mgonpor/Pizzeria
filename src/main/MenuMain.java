package main;

public class MenuMain {
	public static void menu() {
		System.out.println("Escoga una opción:\n" + "1. Pizzas\n" + "2. Pedidos\n" + "3. Clientes\n" + "4. Salir");
	}

	public static void menuPizza() {
		System.out.println("~PIZZAS~");
		System.out.println("Escoga una opci�n:\n" + "1. Nueva Piezza\n" +"2. Eliminar Pizza" +"3. Ver Pizzas\n"
				+ "4. Buscar Pizzas con Ingredientes\n" + "5. Buscar Pizzas sin Ingredientes\n" + "6. Pizza m�s Cara\n"
				+ "7. Pizza m�s Barata\n" + "8. Volver");
	}

	public static void menuPedidos() {
		System.out.println("\n~PEDIDOS~");
		System.out.println("1. Realizar un Pedido\n"
				+ "2. Ver Pedidos\n"
				+ "3. Pedidos de Hoy\n"
				+ "4. Pedidos consumidos en el local\n"
				+ "5. Pedidos para recoger\n"
				+ "6. Pedidos a domicilio\n"
				+ "7. �ltimo pedido Realizado\n"
				+ "8. Volver");
	}
	
	public static void menuCliente() {
		System.out.println("\n~CLIENTES~");
		System.out.println("1. Nuevo Cliente\n"
				+ "2. Ver Clientes\n"
				+ "3. Eliminar Cliente\n"
				+ "4. Consultar Cliente por su tel�fono\n"
				+ "5. Volver");
	}
	
}
