package console.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import data.model.Location;


/**
 * This class demonstrate the application of ObjectInputStream and 
 * ObjectOutputStream at the server-side application.
 * 
 * How to run this program?
 * 
 * 1. Open Terminal
 * 2. Change the directory to /workspace-dad/demoObjectStream/bin
 * 3. Run -> java console.server.ClientSideApp
 * 
 * @author emalianakasmuri
 *
 */

public class ClientSideApp {

	/**
	 * Main entry point of program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo of Object Stream\n");

		// Request data
		Location location = new Location();
		location.setName("Programming Lab 1");
		

		try {

			// Data to establish connection to server
			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

			// Send request to server
			System.out.println("Send object to server: " + location);
			objectOS.writeObject(location);
			objectOS.flush();
			
			// Open stream to receive object
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			
			// Get object from stream and display details
			location = (Location) objectIS.readObject();
			System.out.println ("Id for " + location.getName() + " is " + location.getLocationId());
			
			// Close all closeable objects
			objectOS.close();
			objectIS.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}

}
