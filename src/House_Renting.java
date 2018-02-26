/**
 * Represents de Principal Class of the App
 * @author Francisco López Navarro & Juan Perea Campos *
 */
import java.io.*;
import java.util.*;
public class House_Renting {
	private static Client[] cli = new Client[30];
	private static House[] hou = new House[40];
	private static Request[] req = new Request[50];
	
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main (String [] args) throws FileNotFoundException {
		int menu_option;
		
		readFile_Client(); // Reads the Clients file
		readFile_House(); // Reads the Houses file

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);

		do {
			System.out.println("---------------------------------\nWelcome to our House Renting App!");
			System.out.println("Choose an option: \n1.Show Availables Houses \n2.Make a Renting Request \n3.Show Client Requests \n4.Search Usual Clients \n5.Look for Discounts \n6.Show Specific House Requests \n7.Exit\n---------------------------------");
			menu_option = scan.nextInt();
			// Menu
			switch (menu_option) {
			case 1:
				available_Houses();
				break;
			case 2:
				make_Request();
				break;
			case 3:
				client_Requests();
				break;
			case 4:
				if(usual_Client(ask_DNI())) {
					System.out.println("---------------------------------"); 
					System.out.println("The client is a usual one.");
				} else {
					System.out.println("---------------------------------");
					System.out.println("The client is not a usual one.");
				}
				break;
			case 5:
				calculate_Discount();
				break;
			case 6:
				house_Requests();
				break;
			case 7:
				System.out.println("Thanks for using our house renting app. Hope to see you again soon!");
				break;
			} // End switch Menu
		} while (menu_option!=7);
	} // End Main
	
	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public static void readFile_Client() throws FileNotFoundException {
		String line, name, dni;
		long credit_card;
		int young_card_number, i;
		boolean young_card;
		
		try {
			Scanner scan = new Scanner(new FileReader("Clientes.txt"));
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				name = line.split(" ")[0];
				dni = line.split(" ")[1];
				credit_card = Long.parseLong(line.split(" ")[2]);
				young_card = Boolean.parseBoolean(line.split(" ")[3]);

				try {
					young_card_number = Integer.parseInt(line.split(" ")[4]);
				} catch(ArrayIndexOutOfBoundsException e) {
					young_card_number = 0;
				}
				
				i = last_Client();
				if(i == -1) {
					System.out.println("No more room for new clients. We are sorry!");
					System.out.println("The client "+name+" has not been added to the clients list.");
				} else {
					cli[i] = new Client(dni, name, credit_card, young_card, young_card_number);
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error has ocurred while trying to open the clients file.");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public static void readFile_House() throws FileNotFoundException {
		int house_ID, size, age, price, i;
		double kms;
		String type, status, line, specific_type;
		boolean characteristics, swimming_pool;
		
		try {
			Scanner scan = new Scanner(new FileReader("Viviendas.txt"));
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				type = line.split(" ")[0];
				house_ID = Integer.parseInt(line.split(" ")[1]); 
				size = Integer.parseInt(line.split(" ")[2]);
				price = Integer.parseInt(line.split(" ")[3]);
				age = Integer.parseInt(line.split(" ")[4]);
				status = line.split(" ")[5];
				specific_type = line.split(" ")[6];
				characteristics = Boolean.parseBoolean(line.split(" ")[7]);
				
				i = last_House();
				if(i == -1) { 
					System.out.println("No more room for new houses. We are sorry!");
					System.out.println("The client "+house_ID+" has not been added to the houses list.");
				} else {
					if(type.equalsIgnoreCase("c")) {
						kms = Double.parseDouble(line.split(" ")[6]);
						swimming_pool = Boolean.parseBoolean(line.split(" ")[7]);
						hou[i] = new Chalet(house_ID, size, age, price, status, type, swimming_pool, kms);
					} else if(type.equalsIgnoreCase("p")) {
						specific_type = line.split(" ")[6];
						characteristics = Boolean.parseBoolean(line.split(" ")[7]);
						hou[i] = new Other(house_ID, size, age, price, status, type, characteristics, specific_type);
					}
						
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error has ocurred when trying to open the houses file.");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public static void available_Houses () throws FileNotFoundException {
		int option;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);

		do {
			System.out.println("Which Houses do you want to look for? \n1.Houses Available to Buy \n2.Houses Available to Rent\n3.Return to main menu");
			option = scan.nextInt();

			switch (option) {
			case 1:
				houses_Status("venta"); // Calls the method passing the status 'venta'
				break;
			case 2:
				houses_Status("alquiler"); // Calls the method passing the status 'alquiler'
				break;
			}
		} while (option!=3);
	}

	/**
	 * 
	 * @param state
	 */
	public static void  houses_Status(String state) {
		System.out.println("---------------------------------");
		for(int i = 0; i<last_House(); i++)
			if(hou[i].getStatus().equalsIgnoreCase(state))
				System.out.println(hou[i].toString()); // Prints House List depending on the selected status
		System.out.println("---------------------------------");
	}

	/**
	 * 
	 */
	public static void make_Request() {
		String dni;
		Client auxCli;
		int iCli = last_Client(), iReq = last_Request();

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);

		System.out.println("- Insert your ID please -");
		dni = scan.nextLine();

		if((auxCli = search_Client(dni))!=null) {
			if(iReq == -1)
				System.out.println("No more room for new requets. We are sorry!");
			else
				req[iReq] = ask_RequestData(auxCli); // Asks for Request Data
		} else { 
			if(iCli == -1) {
				System.out.println("No more room for new clients. We are sorry!");
			} else {
				cli[iCli] = ask_ClientData(dni); // Asks for Client Data if not registered
				
				if(iReq == -1)
					System.out.println("No more room for new requets. We are sorry!");
				else
					req[iReq] = ask_RequestData(cli[iCli]); // Asks for Request Data
			}
		}
	}
	
	/**
	 * 
	 */
	public static void client_Requests() {
		String dni;

		dni = ask_DNI();
		
		System.out.println("---------------------------------");
		for(int i = 0; i<last_Request(); i++)
			if(req[i].getClient().getDNI().equalsIgnoreCase(dni))
				System.out.println(req[i].toString());
	}
	
	/**
	 * 
	 */
	public static void house_Requests() {
		int number_house, i;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		System.out.println("---------------------------------");
		for(i = 0; i<last_House(); i++)
			System.out.println("House number "+i+": "+hou[i].toString());
		System.out.println("---------------------------------");
		
		System.out.println("Which house do you want to select?");
		number_house = scan.nextInt();
		
		while(number_house<0 || number_house>=i) {
			System.out.println("Please insert a valid number of house: ");
			number_house = scan.nextInt();
		}
		
		System.out.println("---------------------------------");
		for(i = 0; i<last_Request(); i++)
			if(req[i].getHouse().getHouse_ID()==hou[number_house].getHouse_ID())
				System.out.println(req[i].toString());
	}
	
	/**
	 * 
	 * @return
	 */
	public static int last_Client() {
		for(int i = 0; i<cli.length; i++)
			if(cli[i]==null) return i;
		
		return -1;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int last_Request() {

		for(int i = 0; i<req.length; i++)
			if(req[i]==null) return i;
		
		return -1;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int last_House() {
		for(int i = 0; i<hou.length; i++)
			if(hou[i]==null) return i;
		
		return -1;
	}

	/**
	 * 
	 * @param dni
	 * @return
	 */
	public static Client ask_ClientData(String dni) {

		String name, have_young_card;
		long credit_card;
		int young_card_number = 0;
		boolean young_card = false;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);

		System.out.println("You're not a registered user. Complete the information below. Thanks!");
		System.out.println("- Insert your Name -");
		name = scan.nextLine();

		System.out.println("- Insert your Credit Card number -");
		credit_card = Integer.parseInt(scan.nextLine());

		System.out.println("Do you own a Young Card? (Yes/No)");
		have_young_card = scan.nextLine();
		while(!have_young_card.equalsIgnoreCase("yes") && !have_young_card.equalsIgnoreCase("no")) {
			System.out.println("Error. Please insert a correct option.");
			have_young_card = scan.nextLine();
		}

		if(have_young_card.equalsIgnoreCase("yes")) {
			young_card = true;
			System.out.println("- Insert your Young Card Number -");
			young_card_number = Integer.parseInt(scan.nextLine());
		}

		return new Client(dni, name, credit_card, young_card, young_card_number);
	}
	
	/**
	 * 
	 * @param cli
	 * @return
	 */
	public static Request ask_RequestData(Client cli) {
		String request;
		int rent_time=0, i, number_house;
		House house;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);

		System.out.println("- Insert your Request name -");
		request = scan.nextLine();
		
		System.out.println("---------------------------------");
		for(i = 0; i<last_House(); i++)
			System.out.println("House number "+i+": "+hou[i].toString());
		System.out.println("---------------------------------");
		
		System.out.println("Which house do you want to select?");
		number_house = scan.nextInt();
		
		while(number_house<0 || number_house>=i) {
			System.out.println("Please, insert a valid house number. Thanks!");
			number_house = scan.nextInt();
		}
		
		while(hou[number_house].getStatus().equalsIgnoreCase("venta")) {
			System.out.println("This house is not available to rent. Please, insert a valid house number. Thanks!");
			number_house = scan.nextInt();
		}
		
		house = hou[number_house];
		
		System.out.println("How many months do you want to rent it?");
		rent_time = scan.nextInt();
		
		while(rent_time<=0) {
			System.out.println("Please insert a valid rent time. Thanks!");
			rent_time = scan.nextInt();
		}
		
		return new Request(request, rent_time, house, cli);
	}
	
	/**
	 * 
	 * @return
	 */
	public static String ask_DNI() {
		String dni;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);

		System.out.println("- Insert your ID please -");
		dni = scan.nextLine();

		while(search_Client(dni)==null) {
			System.out.println("This client does not exist. Insert a correct one please.");
			dni = scan.nextLine();
		}
		
		return dni;
	}
	
	/**
	 * 
	 * @param dni
	 * @return
	 */
	public static boolean usual_Client(String dni) {

		int usual_number = 0;
		
		for(int i = 0; i<last_Request(); i++)
			if(req[i].getClient().getDNI().equalsIgnoreCase(dni))
				usual_number++;
		
		if(usual_number>=3)
			return true;
			
		return false;
	}
	
	 /**
	  * 
	  * @param dni
	  * @return
	  */
	public static Client search_Client(String dni) {
		for(int i = 0; i<last_Client(); i++)
			if(cli[i].getDNI().equalsIgnoreCase(dni)) return cli[i];

		return null;
	}
	
	/**
	 * 
	 */
	public static void calculate_Discount() {
		String dni;
		int discount = 0;
		
		dni = ask_DNI();
		
		if(usual_Client(dni)) {
			discount = 10;
			if(search_Client(dni).getYoung_card())
				discount = 25;
		} else if(search_Client(dni).getYoung_card())
			discount = 20;
		System.out.println("---------------------------------");
		System.out.println("The discount of the client is: "+discount+"%");
	}
	
} // End Class	