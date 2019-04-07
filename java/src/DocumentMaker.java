import java.util.Scanner;
import java.io.File;
import client.Client;

class DocumentMaker {
	private static Scanner scan;

	public static void main(String[] args) {
		try 
		{
			// 
			String responsible = null;
			String clientName;
			String clientPhone;
		
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
				
				path = client.checkResponsible( responsible );
				client.createClientFile(path);
			
			
				


		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
