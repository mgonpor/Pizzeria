package main;

import java.time.LocalDate;
import java.util.Scanner;

import pizzeria.Cliente;
import pizzeria.Pedido;
import pizzeria.Pizza;
import pizzeria.Pizzeria;

public class Main {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int mMain;
		System.out.println("Bienvenido a la Pizzeria del EquipoA!" + "\n----------------------------------------");
		Pizzeria equipoA = new Pizzeria("equipoA");
		Pizza p1 = new Pizza("Kebab", 200, "salsa,carne");
		equipoA.addPizza(p1);
		Cliente c1 = new Cliente("Fran", "Fran", "fran", "674057757");
		equipoA.addCliente(c1);

		do {
			System.out.print("\nEscoga una opción:\n" + "1. Admin\n" + "2. Cliente");
			mMain = sca.nextInt();
			switch (mMain) {
			case 1:
				System.out.print("\nContraseña: ");
				String password = sca.next();
				menuAdmin(equipoA, password);
			case 2:
				equipoA.verClientes();
				System.out.print("\nIndique qué cliente es: ");
				int cliente = sca.nextInt();
				menuCliente(equipoA, cliente, sca, equipoA.getClientePorId(cliente));
			case 3:
				System.out.print("\nSaliendo del sistema...");
			default:
				System.out.print("\nElige una opción válida: ");
			}

		} while (mMain != 3);
	}

	public static void menuAdmin(Pizzeria pizzeria, String password) {
		Scanner sca = new Scanner(System.in);
		if (!password.equals("vladi")) {
			throw new IllegalArgumentException("\nContraseña incorrecta");
		}
		int eleccion;
		do {
			System.out.print("\n1. Nueva pizza" + "\n2. Nuevo cliente" + "\n3. Realizar pedido" + "\n4. Ver pizzas"
					+ "\n5. Ver pedidos" + "\n6. Ver clientes" + "\n7. Consultar cliente mediante su telefono"
					+ "\n8. Buscar pizzas con ingrediente" + "\n9. Buscar pizzas sin ingrediente"
					+ "\n10. Pedidos de hoy" + "\n11. Pedidos consumidos en el local" + "\n12. Pedidos para recoger"
					+ "\n13. Pedidos a domicilio" + "\n14. Pizza más cara" + "\n15. Pizza más barata"
					+ "\n16. Último pedido realizado" + "\n17. Salir");
			eleccion = sca.nextInt();
			switch (eleccion) {
			case 1:
				System.out.print("\nNombre: ");
				String nombre = sca.next();
				System.out.print("\nPrecio: ");
				double precio = sca.nextDouble();
				System.out.print("\nIngredientes: ");
				String ingredientes = sca.next();
				Pizza pizza = new Pizza(nombre, precio, ingredientes);
				pizzeria.addPizza(pizza);
				break;
			case 2:
				System.out.print("\nNombre: ");
				String nombreC = sca.next();
				System.out.print("\nDireccion: ");
				String direccion = sca.next();
				System.out.print("\nEmail: ");
				String email = sca.next();
				System.out.print("\nTelefono: ");
				String tel = sca.next();
				System.out.print("\nDinero disponible: ");
				double dineroDisponible = sca.nextDouble();
				Cliente cliente = new Cliente(nombreC, direccion, email, tel, dineroDisponible);
				pizzeria.addCliente(cliente);
				break;
			case 3:
				System.out.printf("Cliente (ID): ");
				int clienteP = sca.nextInt();
				Cliente cc = pizzeria.getClientePorId(clienteP);
				System.out.print("Tipo (local, recoger, domicilio): ");
				String tipo = sca.next();
				Pedido pedido = new Pedido(cc, tipo);
				int opcion = 0;
				do {
					System.out.println("\nDime la pizza que quieras añadir (0 finaliza pedido): ");
					opcion = sca.nextInt();
					if (opcion != 0) {
						pedido.addPizza(pizzeria.getPizzaPorId(opcion));
					}
				} while (opcion != 0);
				pizzeria.addPedido(pedido);
				break;
			case 4:
				pizzeria.verPizzas();
				break;
			case 5:
				pizzeria.verPedidos();
				break;
			case 6:
				pizzeria.verClientes();
				break;
			case 7:
				System.out.print("\nIndique el telefono: ");
				String telBuscar = sca.next();
				pizzeria.consultarCliente(telBuscar);
				break;
			case 8:
				System.out.printf("\nIngrediente a buscar: ");
				String ingr = sca.next();
				pizzeria.consultarPizzaCon(ingr);
				break;
			case 9:
				System.out.print("\nIngrediente a evitar: ");
				String ingr2 = sca.next();
				pizzeria.consultarPizzaSin(ingr2);
				break;
			case 10:
				pizzeria.consultarPedidosHoy();
				break;
			case 11:
				pizzeria.consultarPedidosLocal();
				break;
			case 12:
				pizzeria.consultarPedidosRecoger();
				break;
			case 13:
				pizzeria.consultarPedidosDomicilio();
				break;
			case 14:
				pizzeria.mostrarPizza(Pizza.getMasCara());
				break;
			case 15:
				pizzeria.mostrarPizza(Pizza.getMasBarata());
				break;
			case 16:
				pizzeria.mostrarPedido(Pedido.getUltimoPedido());
				break;
			case 17:
				System.out.print("\nAdmin saliendo...");
				break;
			default:
				System.out.print("\nElige entre 1 y 17.");
			}
		} while (eleccion != 17);
	}

	public static void menuCliente(Pizzeria pizzeria, int id, Scanner sca, Cliente cliente) {

		int eleccion;
		do {
			System.out.printf("\n----------------------" + "\nBienvenido soldado. Prepárate!");
			System.out.printf("\n1. Realizar un pedido" + "\n2. Ver pizzas" + "\n3. Buscar pizza sin ingrediente"
					+ "\n4. Buscar pizza con ingrediente" + "\n5. Volver");
			eleccion = sca.nextInt();
			switch (eleccion) {
			case 1:
				System.out.print("Tipo (local, recoger, domicilio): ");
				String tipo = sca.next();
				Pedido pedido = new Pedido(cliente, tipo);
				int opcion = 0;
				int opcion2 = 0;
				do {
					System.out.println("\nDime la pizza que quieras añadir (0 finaliza pedido): ");
					opcion = sca.nextInt();
					if (opcion != 0) {
						pedido.addPizza(pizzeria.getPizzaPorId(opcion));
					}
				} while (opcion != 0);
				do {
				pedido.mostrarPizzasDelPedido();
				System.out.printf("\n	Total: %.02f", pedido.getTotal());
				System.out.println("\n ¿Desea elminar alguna Pizza del pedido? (0 para no eliminar ninguna)");
				opcion2 = sca.nextInt();
					if (opcion2 != 0) {
						pedido.removePizza(pizzeria.getPizzaPorId(opcion2));
					}
				} while (opcion2 != 0);
				pizzeria.addPedido(pedido);
				break;
			case 2:
				pizzeria.verPizzas();
				break;
			case 3:
				System.out.print("\nIngrediente a evitar: ");
				String ingr2 = sca.next();
				pizzeria.consultarPizzaSin(ingr2);
				break;
			case 4:
				System.out.printf("\nIngrediente a buscar: ");
				String ingr = sca.next();
				pizzeria.consultarPizzaCon(ingr);
				break;
			case 5:
				System.out.print("\nCliente saliendo...");
				break;
			default:
				System.out.print("\nElige entre 1 y 5.");

			}
		} while (eleccion != 5);
	}
}