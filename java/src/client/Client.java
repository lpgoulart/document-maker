package client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Client {

	private static Scanner scan;

	private String clientName;
	private String clientPhone;
	private File document;
	private String path;
	private String responsible;
	
	public Client( String name, String phone ) {
		this.clientName = name;
		this.clientPhone = phone;
		this.document = new File ("document.txt");
		scan = new Scanner(System.in);
		this.path = null;
		this.responsible = "";
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientPhone
	 */
	public String getClientPhone() {
		return clientPhone;
	}

	/**
	 * @param clientPhone the clientPhone to set
	 */
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	
	// Folder creation and verifying if it doesn't exist. If so create a new
	public void checkResponsible ( String responsible ) throws IOException {
		this.responsible = responsible;
		File directory = new File("responsibles/"+this.responsible);
	    
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
			path = "responsibles/"+ this.responsible + "/" + clientName + ".txt";
	    }
		
		createClientFile (path);
	}
	
	// File creation and verifying if it doesn't exist. If so create a new
	public void createClientFile ( String path ) throws IOException {
		try {
			File file = new File(path);
				if (!file.exists()) {
				    System.out.println("New client register");
				    Files.copy(this.document.toPath(), file.toPath());
				} else {
					System.out.println("There is a client with that  name register");
					chooseAnotherName();
					System.out.println("New client register");
				}
		} catch ( IOException e ) {
			System.out.println(e);
		}
	}

	public void chooseAnotherName () {
		System.out.println("Please choose another name for client!");
		String entry; 
		entry = scan.nextLine();
		this.clientName = entry;

		path = "responsibles/"+ this.responsible + "/" + clientName + ".txt"; 

		try {
			File file = new File(path);
				if (!file.exists()) {
				    Files.copy(this.document.toPath(), file.toPath());
				} else {
					System.out.println("There is a client with that  name register");
					chooseAnotherName();
				}
		} catch ( IOException e ) {
			System.out.println(e);
		}
	}
	
	
}
