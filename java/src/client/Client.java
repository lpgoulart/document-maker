package client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Client {
	private String clientName;
	private String clientPhone;
	private File document;
	
	public Client( String name, String phone ) {
		this.clientName = name;
		this.clientPhone = phone;
		this.document = new File ("document.txt");
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
	public String checkResponsible ( String responsible ) {
		File directory = new File("responsibles/"+responsible);
		String path = null;
	    
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
		
		return path;
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
				}
		} catch ( IOException e ) {
			System.out.println(e);
		}
	}
	
	
}
