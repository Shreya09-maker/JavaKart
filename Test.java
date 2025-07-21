package com.customer;
import com.service.JavaKart;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		JavaKart k=new JavaKart();
		k.initializeProducts();
		k.initialisePrices();
		
		while(true) {
		System.out.println("~~~~~~~~~~~~~~  Welcome to JavaKart ~~~~~~~~~~~~~~");
		System.out.println("\nNOTE : new user can REGISTER first...!!!");
        System.out.println("\n1. Register\n2. Login\n3. Exit\nEnter your choice(number):");
		int ch=s.nextInt();
		switch (ch) {
			case 1:
				k.Registration();
				break;
			case 2:
				k.Login();
				break;
			case 3:
				System.out.println("Exiting successfully...\nVisit again...");
				System.exit(0);
			default:
				System.out.println("Invalid choice...\nplease try again...\n");
			}
		}
	}
}