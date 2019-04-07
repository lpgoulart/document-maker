import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter; 
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
				String path = null;
			
				System.out.println("Enter the responsible name: ");
				responsible = scan.nextLine();
				
				System.out.println("Enter the client name: ");
				clientName = scan.nextLine();
				
				System.out.println("Enter the client phone: ");
				clientPhone = scan.nextLine();
				
				Client client = new Client( clientName, clientPhone );
				
			// Folder creation and verifying if it doesn't exist. If so create a new
				File directory = new File("responsibles/"+responsible);
			    
				if (directory.exists() && directory.isFile())
			    {
			        System.out.println("The dir with name could not be" +
			        " created as it is a normal file");
			    }
			    else
			    {
			        if (!directory.exists())
					{
					    directory.mkdir();
					}
					path = "responsibles/"+ responsible + "/" + clientName + ".txt";
			    }
			
			// File creation and verifying if it doesn't exist. If so create a new
				File file = new File(path);
					if (!file.exists()) {
					    file.createNewFile();
					    System.out.println("New client register");
					} else {
						System.out.println("There is a client with that  name register");
					}
				


		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
