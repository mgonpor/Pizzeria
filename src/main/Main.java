package main;

import java.util.Scanner;

import pizzeria.Pizza;

public class Main {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int mMain;
		int mPizza;
		int mPedido;

		System.out.println("Bienvenido a la Pizzeria del EquipoA");
		pizzeria.MenuMain.menu();
		do {

			mMain = sca.nextInt();

			if (mMain == 1) {
				pizzeria.MenuMain.menuPizza();
				mPizza = sca.nextInt();
				switch (mPizza) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
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
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					pizzeria.MenuMain.menu();
					break;
				default:
					System.out.println("\n\nIntroduce una opción correcta: ");
					pizzeria.MenuMain.menuPedidos();
					break;
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
