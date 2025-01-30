package main;

import java.util.Scanner;

import pizzeria.Pizza;

public class Main {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int mMain;
		int mPizza;
		int mPedido;
		int mCliente;

		System.out.println("Bienvenido a la Pizzeria del EquipoA");
		pizzeria.MenuMain.menu();
		do {

			mMain = sca.nextInt();

			if (mMain == 1) {
				pizzeria.MenuMain.menuPizza();
				mPizza = sca.nextInt();
				switch (mPizza) {
				case 1: 
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					pizzeria.MenuMain.menu();
					break;
				default:
					System.out.println("\n\nIntroduce una opción correcta: ");
					pizzeria.MenuMain.menuPizza();
					break;
				}
			} else if (mMain == 2) {
				pizzeria.MenuMain.menuPedidos();
				mPedido = sca.nextInt();
				switch (mPedido) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					pizzeria.MenuMain.menu();
					break;
				default:
					System.out.println("\n\nIntroduce una opción correcta: ");
					pizzeria.MenuMain.menuPedidos();
					break;
				}
			} else if (mMain == 3) {
				pizzeria.MenuMain.menuCliente();
				mCliente = sca.nextInt();
				switch(mCliente) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
						
				}

			}
		} while (mMain != 4);
	}

	public static Pizza nuevaPizza(Scanner sc) {
		System.out.print("nombre ");
		String nombre = sc.next();
		return new Pizza(nombre, 19, "jajajajajaj");
	}

}
