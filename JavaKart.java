package com.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.model.User;

public class JavaKart {
	Scanner scanner = new Scanner(System.in);
    User currentUser = null;
    Scanner s=new Scanner(System.in);
	User u=new User();
    
    List<String> laptop=new ArrayList<String>();
	List<String> smartphone=new ArrayList<String>();
	List<String> watch=new ArrayList<String>();
	List<String> shoe=new ArrayList<String>();
    List<String> cart = new ArrayList<>();
    List<Integer> cart1 = new ArrayList<>();
    Map<String, List<String>> products = new HashMap<>();
    List<Integer> plaptop=new ArrayList<Integer>();
	List<Integer> psmartphone=new ArrayList<Integer>();
	List<Integer> pwatch=new ArrayList<Integer>();
	List<Integer> pshoe=new ArrayList<Integer>();
	Map<Integer, List<Integer>> prices = new HashMap<>();
	
	public void initialisePrices() {
		plaptop.add(40000);
		plaptop.add(45000);
		plaptop.add(35000);
		plaptop.add(40000);
		plaptop.add(48000);
		
		psmartphone.add(13000);
		psmartphone.add(16000);
		psmartphone.add(15000);
		psmartphone.add(18000);
		psmartphone.add(20000);
		
		pwatch.add(1200);
		pwatch.add(5000);
		pwatch.add(3000);
		pwatch.add(1230);
		pwatch.add(6000);
		
		pshoe.add(2000);
		pshoe.add(1800);
		pshoe.add(3000);
		pshoe.add(1500);
		pshoe.add(1200);
		
		prices.put(1,plaptop);
		prices.put(2,psmartphone);
		prices.put(3,pwatch);
		prices.put(4,pshoe);
	}
    //InitializeProducts
    public void initializeProducts() {
    	laptop.add("Asus intel core i5 | 12gen | 8GB-RAM | 256-SSD | price-40000 | rating: 4.5");
		laptop.add("Dell inspiron core i3 | 12gen | 8GB-RAM | 256-SSD | price-45000 | rating: 4.6");
		laptop.add("HP-Victus intel core i5 |12gen| 16GB-RAM| 256-SSD | price-35000 | rating: 4");
		laptop.add("samsung Galaxy Book4 intel core i7 | 13gen| 16GB-RAM | 512-SSD | price-40000 | rating: 4.5");
		laptop.add("Lenovo Ideapad Slim 3 intel core i5 | 12gen| 16GB-RAM | 512-SSD | price-48000 | rating: 4.6");
		
		smartphone.add("POCO M6 5G|Orion Blue | 4GB-RAM | 128GB-ROM | price-13000 | rating: 4.3)");
		smartphone.add("REDMI 12 5G | Moonstone silver | 8GB-RAM | 256GB-ROM | price-16000 | rating: 4.4");
		smartphone.add("OPPO F27 Pro+ | Midnight Navy | 8GB-RAM | 256GB-ROM | price-15000 | rating: 4.5");
		smartphone.add("Xiaomi 11i 5G | Purple Mist | 8GB-RAM | 128GB-ROM | price-18000 | rating: 4.5");
		smartphone.add("vivo T3 Ultra | Lunar Gray | 8GB-RAM | 256GB-ROM | price-20000 | rating: 4.6");
				
		watch.add("CASIO A1558WA | Water resistence | Digital | Grey |warrenty-2y | price-1200 | rating: 4.5");
		watch.add("SONATA | Casual | Analog | Black | warrenty-1.5y | price-5000 | rating: 4.4");
		watch.add("TIMEX | Water resistence | Digital | silver | warrenty-1y | price-3000 | rating: 4.5");
		watch.add("FOSSIL | Water resistence | Digital | warrenty-1.5y | price-1230 | rating: 4.4");
		watch.add("TITAN | Water resistence | Digital | Grey|warrenty-3y | price-6000 | rating: 4.6");
				
		shoe.add("Adidas | outer material-synthetic | colour-White | Occation-Sports | price-2000 | rating: 4.6");
		shoe.add("Reebok | outer material-synthetic | colour-Red | Occation-Sports | price-1800 | rating: 4.7");
		shoe.add("Puma | outer material-synthetic | colour-White | Occation-Sports | price-3000 | rating: 4.5");
		shoe.add("Sparks | outer material-synthetic | colour-White | Occation-Sports | price-1500 | rating: 4.4");
		shoe.add("Campus | outer material-synthetic | colour-Black | Occation-Sports | price-1200 | rating: 4.5");
		
        products.put("Laptops",laptop);
        products.put("Smartphones", smartphone);
        products.put("Watches", watch);
        products.put("Shoes", shoe);
    }
    //Registration
	public void Registration() {
		System.out.println("Enter your Name: ");
		String name=s.nextLine();
		u.setName(name);
		System.out.println("Enter your Mobile no: ");
		long mobNo=s.nextLong();
		u.setMobileNm(mobNo);
		System.out.println("Enter your Email: ");
		String email=s.next()+s.nextLine();
		u.setEmail(email);
		System.out.println("Enter your username: ");
		String userNm=s.next();
		u.setUserName(userNm);
		//set password
		while(true) {
			System.out.println("Enter your Password: ");
			String pass=s.next();
			System.out.println("Confirm your password: ");
			String ps=s.next()+s.nextLine();
			if(pass.equals(ps)) {
				u.setPassWord(pass);
				break;
			}else {
				System.out.println("Password doesn't match...!!!\nRe-Enter again...\n");
			}
		}
		System.out.println("\nRegistration successfull...\nYou can login now...\n");
	}
	//Login
	public void Login() {
		while(true) {
			System.out.println("Enter your username or email: ");
			String em=s.next()+s.nextLine();
			if(em.equals(u.getUserName())|| em.equals(u.getEmail())) {
				System.out.println("Enter your password: ");
				String pass=s.nextLine();
				if(pass.equals(u.getPassWord())) {
					System.out.println("\nLogin successfully...\n");
					handleShopping();
					break;
				}else {
				System.out.println("Password dosn't match...!!!");
				}
			}else {
				System.out.println("Something Wrong...!!!\nTry again...");
			}
		}
	}
	//handleShopping
    public void handleShopping() {
        while (true) {
            System.out.println("1. View Products\n2. Logout\nEnter choice(number) : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showProductMenu();
                    break;
                case 2:
                    System.out.println("Logging out...\n");
                    currentUser = null;
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    //Product Menu
    public void showProductMenu() {
    	int Pcategory;
        String category = "";
        System.out.println("Product Categories:");
        System.out.println("1. Laptops\n2. Smartphones\n3. Watches\n4. Shoes\nEnter choice(number) :");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
            	Pcategory = choice;
            	category = "Laptops";
                break;
            case 2:
            	Pcategory = choice;
                category = "Smartphones";
                break;
            case 3:
            	Pcategory = choice;
                category = "Watches";
                break;
            case 4:
            	Pcategory = choice;
                category = "Shoes";
                break;
            default:
                System.out.println("Invalid choice... \nReturning to main menue.");
                return;
        }
        showProductOptions(category,Pcategory);
    }
    //Product Options
    public void showProductOptions(String category,int Pcategory) {
        System.out.println("\nAvailable " + category + ":");
        List<String> items = products.get(category);
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\n"+(i + 1) + ". " + items.get(i)+"\n__________________________________________________________________________________________________");
        }
        System.out.println("\nEnter the product to add to the cart(number) :");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Bill(Pcategory,choice);
        if (choice > 0 && choice <= items.size()) {
            cart.add(items.get(choice - 1));
            System.out.println(items.get(choice - 1) + " added to cart.");
            System.out.println("\n1. Add more products\n2. Proceed to next");
            int nextChoice = scanner.nextInt();
            scanner.nextLine();
            if (nextChoice == 1) {
                showProductMenu();
            } else {
                checkout();
            }
        } else {
            System.out.println("Invalid choice... \nReturning to product menue.");
            showProductMenu();
        }
    }
	//price setting
    int totalPrice;
    public void Bill(int Pcategory,int choice) { 
    	List<Integer> productPrices = prices.get(Pcategory);
    	if (choice > 0 && choice <= productPrices.size()) {
            cart1.add(productPrices.get(choice - 1));
    	}
    	totalPrice=0;
    	for(int i = 0; i < cart1.size(); i++) {
    		totalPrice = totalPrice + cart1.get(i);
        }
	 }
    //checkout
    public void checkout() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~ CART CONTENTS ~~~~~~~~~~~~~~~~~~~~~~");
        	for(int i = 0; i < cart.size(); i++) {
            System.out.println("\n"+(i + 1) + ". " +cart.get(i));
            System.out.println("______________________________________________________________________________________________");
        	}
        System.out.println("\n1. Delete a product\n2. Continue to payment\nchoice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            deleteProductFromCart();
        } else {
            finalizePayment();
        }
    }
    //Deletion
    public void deleteProductFromCart() {
        System.out.println("Enter the product number to delete from cart:");
        int productIndex = scanner.nextInt();
        if (productIndex >= 1 && productIndex <= cart.size()) {
        	System.out.println(cart.get(productIndex-1) + " removed from cart.");
            cart.remove(cart.get(productIndex-1));
            totalPrice = totalPrice-(cart1.get(productIndex-1));
            cart1.remove(cart1.get(productIndex-1));
        } else {
            System.out.println("Product not found in cart.");
        }
        checkout();
    }
    //finalize Payment
    public void finalizePayment() {
    	System.out.println("Total Bill : "+totalPrice);
        System.out.println("\n1. Net Banking\n2. Cash on Delivery\nYour choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            NetBanking();
        } else {
            CashOnDelivery();
        }
    }
    //OTP Generate
    public static String OTPGen(){
		SecureRandom sr=new SecureRandom();
		String nm = "0123456789";
		StringBuffer sb = new StringBuffer(6);
		for(int i=0;i<6;i++){
			sb.append(nm.charAt(sr.nextInt(nm.length())));
		}
		String res=sb.toString();
		return res;
	}
    //NetBanking()
    public void NetBanking() {
        System.out.println("Enter Net Banking Username:");
        String username = scanner.nextLine();
        System.out.println("Enter Net Banking Password:");
        String password = scanner.nextLine();
        String otp = OTPGen();
        System.out.println("Your OTP is: " + otp);
        System.out.println("Enter OTP:");
        String enteredOtp = scanner.nextLine();
        if (otp.equals(enteredOtp)) {
        	System.out.println("Total Bill : "+totalPrice);
            System.out.println("\n$"+totalPrice+" Paid successfully... \n\nYour product will be delivered within 2 to 3 working days.");
        } else {
            System.out.println("Invalid OTP...\nPayment failed.");
        }
        System.out.println("Thank you for shopping with us...");
    }
  //CashOnDelivery()
    public void CashOnDelivery() {
        System.out.println("You chose Cash on Delivery...\nPay your bill after the product is delivered.");
        System.out.println("\nProduct Details : ");
        for (String item : cart) {
            System.out.println("\n"+item);
            System.out.println("_________________________________________________________________________________________");
        }
        System.out.println("\nTotal Bill : "+totalPrice);
        System.out.println("\nThank you for shopping with us...\n");
    }
}