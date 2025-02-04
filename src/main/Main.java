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
		main.MenuMain.menu();
		do {

			mMain = sca.nextInt();

			if (mMain == 1) {
				main.MenuMain.menuPizza();
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
					main.MenuMain.menu();
					break;
				default:
					System.out.println("\n\nIntroduce una opci�n correcta: ");
					main.MenuMain.menuPizza();
					break;
				}
			} else if (mMain == 2) {
				main.MenuMain.menuPedidos();
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
					main.MenuMain.menu();
					break;
				default:
					System.out.println("\n\nIntroduce una opci�n correcta: ");
					main.MenuMain.menuPedidos();
					break;
				}
			} else if (mMain == 3) {
				main.MenuMain.menuCliente();
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


}
