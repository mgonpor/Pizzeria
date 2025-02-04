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
		System.out.println("Bienvenido a la Pizzeria del EquipoA!"
				+ "\n----------------------------------------");
		Pizzeria equipoA = new Pizzeria("equipoA");
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
				menuCliente(equipoA, cliente, sca);
			default:
				System.out.print("\nElige una opción válida: ");
			}

		} while (mMain != 4);
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
				int tel = sca.nextInt();
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
				Pedido pedido = new Pedido(cc, LocalDate.now(), tipo);
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
				int telBuscar = sca.nextInt();
				pizzeria.consultarCliente(telBuscar);
				break;
			case 8:
				System.out.printf("\nIngrediente a buscar: ");
				String ingr = sca.next();
				pizzeria.consultarPizzaCon(ingr);
				break;
			case 9:
				System.out.print("\ningrediente a evitar: ");
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
				pizzeria.mostrarPizza(Pizza.getMasBarata());
				break;
			case 15:
				pizzeria.mostrarPizza(Pizza.getMasCara());
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

	public static void menuCliente(Pizzeria p, int id, Scanner sca) {

		int eleccion;
		do {
			System.out.printf("Bienvenido soldado. Prepárate!");
			System.out.printf("\n1. Realizar un pedido" + "\n2. Ver pizzas" + "3. Buscar pizza sin ingrediente\n"
					+ "\n4. Buscar pizza con ingrediente" + "\n5. Volver");
			eleccion = sca.nextInt();
			switch (eleccion) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				p.verPizzas();
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