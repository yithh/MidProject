import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Vehicle> vehicles;
	
	public Main() {
		vehicles = new ArrayList<>();
	}
	
	public  void inputMenu() {
		Scanner sc = new Scanner(System.in);
		boolean validInput = false;
		
		while (true) {
			System.out.print("\nMenu:\n" +
							"1. Input\n"
							+ "2. View\n"
							+ "3. Exit\n"
							+ ">> ");
			int option = 0;
			try {
				option = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid Input");
			}
			switch (option) {
			case 1:
				do {
					System.out.println("\n Enter Vehicle Details:");
					System.out.print("Tipe kendaraan (Car | Motorcycle): ");
					String vehicleType = sc.nextLine();
					if (vehicleType.equalsIgnoreCase("Car")) {
						Car mobil = inputCar(sc);
						if (mobil != null) {
							vehicles.add(mobil);
							validInput = true;
						} else {
							System.out.println("Invalid Input");
						}
					}
				} while (!validInput);
				break;
			case 2:
				viewMenu();
				break;
				
			case 3:
				System.out.println("Exiting Program...");
				break;
				
			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}
	
	private void viewMenu() {
		System.out.println("\nVehicle List: ");
		if(vehicles.isEmpty()) {
			System.out.println("No Vehicles added yet.");
		} else {
			for (int i = 0; i < vehicles.size(); i++) {
				System.out.println("Vehicle " + (i+1) + ": ");
				vehicles.get(i).display();
				vehicles.get(i).specificInfo();
			}
		}
		
	}

	private Car inputCar(Scanner sc) {
		String type;
		String brand;
		String name;
		String licenseNumber;
		int topSpeed;
		int gasCap;
		int wheel;
		int entertainmentSystem;
		boolean validInput = false;
		
		do {
			System.out.print("Type (SUV | Supercar | Minivan): ");
			type = sc.nextLine();
		} while (!type.matches("(?i)SUV|Minivan|Supercar"));
		
		System.out.print("Brand: ");
		brand = sc.nextLine();
		
		System.out.print("Name: ");
		name = sc.nextLine();
		
		System.out.println("License: ");
		licenseNumber = sc.nextLine();
		
		System.out.println("Top Speed: ");
		topSpeed = sc.nextInt();
		
		System.out.println("GasCap: ");
		gasCap = sc.nextInt();
		
		System.out.println("Wheel: ");
		wheel = sc.nextInt();
		
		System.out.println("Entertainment System: ");
		entertainmentSystem = sc.nextInt();
		
		return null;
	}

	public static void main(String[] args) {
		Main menu = new Main();
		menu.inputMenu();
	}
}
