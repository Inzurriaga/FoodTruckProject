import java.util.Scanner;

public class FoodTruckApp {

	private FoodTruck[] trucks;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public FoodTruckApp() {
		this.trucks = new FoodTruck[5];
	}

	public void run() {
		Scanner input = new Scanner(System.in);
		introduction();
		createTrucks(input);
		while (trucks.length > 0) {
			menu();
			System.out.print("User input: ");
			int menuOption = input.nextInt();
			if (menuOption == 1) {
				listTrucks();
			} else if (menuOption == 2) {
				averageTrucksRating();
			} else if (menuOption == 3) {
				listHighestRatingTruck();
			} else if (menuOption == 4) {
				break;
			} else {
				System.out.println("invalid input");
			}
			System.out.println();
		}
		exitMessage();
	}

	public void introduction() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ "*        Welcome to the amazing food truck app.        *\n"
				+ "*  Enter five of your favorite trucks or enter \"quit\"  *\n"
				+ "* on the truck name to exit the loop to create trucks. *\n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

	public void createTrucks(Scanner input) {
		for (int i = 0; i < trucks.length; i++) {
			System.out.print("Enter trucks " + (i + 1) + " name: ");
			String name = input.next();
			if (name.toLowerCase().equals("quit")) {
				break;
			}
			System.out.print("Enter trucks " + (i + 1) + " type: ");
			String type = input.next();
			System.out.print("Enter trucks " + (i + 1) + " rating: ");
			int rating = input.nextInt();
			System.out.println();
			trucks[i] = new FoodTruck(name, rating, type);
		}
	}

	public void menu() {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ "* 1) List all trucks                        *\n" + "* 2) See average rating of trucks           *\n"
				+ "* 3) See highest rating truck               *\n" + "* 4) Quit                                   *\n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public void listTrucks() {
		System.out.println("\n----------------- Truck list -----------------\n");
		for (FoodTruck truck : trucks) {
			if (truck == null) {
				break;
			}
			System.out.println(truck.toString());
		}
		System.out.println("\n----------------------------------------------");
	}

	public void averageTrucksRating() {
		double sum = 0;
		int count = 0;
		for (FoodTruck truck : trucks) {
			if (truck == null) {
				break;
			}
			sum += truck.getRating();
			count++;
		}
		System.out.println("Average Rating: " + (Math.round((sum / count) * 10) / 10.0));
	}

	public void listHighestRatingTruck() {
		System.out.println("\n----------- Highest Rating Truck(s) -----------\n");
		int count = 0;
		int highestRating = Integer.MIN_VALUE;
		for (FoodTruck truck : trucks) {
			if (truck == null) {
				break;
			}
			if (highestRating < truck.getRating()) {
				highestRating = truck.getRating();
				count = 0;
			}
			if (highestRating == truck.getRating()) {
				count++;
			}
		}
		for (FoodTruck truck : trucks) {
			if (truck == null) {
				break;
			}
			if(truck.getRating() == highestRating) {
				System.out.println(truck.toString());
			}
		}
		System.out.println("\n-----------------------------------------------");
	}

	private void exitMessage() {
		System.out.println("Thank you have a good day!!!");
	}
}
