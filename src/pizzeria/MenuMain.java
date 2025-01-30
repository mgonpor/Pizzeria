package pizzeria;

public class MenuMain {
	public static void menu() {
		System.out.println("Escoga una opción:\n" + "1. Pizzas\n" + "2. Pedidos\n" + "3. Clientes\n" + "4. Salir");
	}

	public static void menuPizza() {
		System.out.println("~PIZZAS~");
		System.out.println("Escoga una opción:\n" + "1. Nueva Piezza\n" + "2. Ver Pizzas\n"
				+ "3. Buscar Pizzas con Ingredientes\n" + "4. Buscar Pizzas sin Ingredientes\n" + "5. Pizza más Cara\n"
				+ "6. Pizza más Barata\n" + "7. Volver");
	}

	public static void menuPedidos() {
		System.out.println("\n~PEDIDOS~");
		System.out.println("1. Realizar un Pedido\n"
				+ "2. Ver Pedidos\n"
				+ "3. Pedidos de Hoy\n"
				+ "4. Pedidos consumidos en el local\n"
				+ "5. Pedidos para recoger\n"
				+ "6. Pedidos a domicilio\n"
				+ "7. Último pedido Realizado\n"
				+ "8. Volver");
	}
}
