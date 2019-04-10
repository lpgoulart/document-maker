import java.util.Scanner;
import client.Client;
import client.Informations;

class DocumentMaker {
	private static Scanner scan;

	public static void main(String[] args) {
		try 
		{
			Informations serviceOrder = new Informations(); 
			String responsible = null;
			String clientName;
			String clientPhone;
			String entry;
		
			scan = new Scanner(System.in);
			// Strings variables
			String path;	
			
				System.out.println("Enter the responsible name: ");
				responsible = scan.nextLine();
				
				System.out.println("Enter the client name: ");
				clientName = scan.nextLine();
				
				System.out.println("Enter the client phone: ");
				clientPhone = scan.nextLine();
				
				Client client = new Client( clientName, clientPhone );
				
				client.checkResponsible( responsible );
//				client.createClientFile(path);
				serviceOrder.description();
				
				System.out.println("Done description of product!!");

		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
