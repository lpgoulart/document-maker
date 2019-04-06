
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter; 

class DocumentMaker {
	public static void main(String[] args) {
		try 
		{
			// Variable to read inputs from the user
				Scanner scan = new Scanner(System.in);
			// Strings variables
				String path;
				String fileName;
				String line;
			
			//Path where the new file it's going to be
				System.out.println("Enter the path for new file: ");
				path = scan.nextLine();
			
			// File creation and verifying if it doesn't exist. If so create a new
				File file = new File(path);
					if (!file.exists()) {
					    file.createNewFile();
					}
				System.out.println("File created");

			// This method Returns the absolute form of this abstract pathname. Equivalent to new File
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				
			// Writes text to a character-output stream
				BufferedWriter bw = new BufferedWriter(fw);


		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}