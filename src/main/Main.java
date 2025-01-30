package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int m1;
		
		System.out.println("Bienvenido a la Pizzeria del EquipoA");
		do {
		pizzeria.MenuMain.menu();;
		m1 = sca.nextInt();
		
		if(m1 == 1) {
			System.out.println("PIZZAS");
			System.out.println("Escoga una opción:\n"
					+ "1. Nueva Piezza\n"
					+ "2. Ver Pizzas\n"
					+ "3. Buscar Pizzas con Ingredientes\n"
					+ "4. Buscar Pizzas sin Ingredientes\n"
					+ "5. Pizza más Cara\n"
					+ "6. Pizza más Barata\n"
					+ "7. Volver");
			int m2 = sca.nextInt();
			if(m2 == 7) {
			}
		}
		}while(m1 != 4);
	}

}
