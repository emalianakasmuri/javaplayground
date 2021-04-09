package console.simple.client;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * This application demonstrate the application of DataInputStream and 
 * DataOutputStream on the client-side.
 * 
 * How to run this program?
 * 1. Run in Eclipse
 * 
 * @author emalianakasmuri
 *
 */

public class ClientSideApp {
	
	public static void main (String args[]) {
		
		// Specify the file
		File file = new File("ikealogo.jpeg");
		
		// Convert file to byte
		byte fileByte[] = new byte[(int)file.length()];
		
		
		try {
			
			// Data to establish connection to server
			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);
			
			// Read the file, and put it into bytes data
			FileInputStream fileIS = new FileInputStream(file);
			fileIS.read(fileByte, 0, fileByte.length);
			
			// Open stream to send data
			BufferedOutputStream bufferOS = new BufferedOutputStream(socket.getOutputStream());
			bufferOS.write(fileByte, 0, fileByte.length);
			
			fileIS.close();
			bufferOS.close();
			
			// Close socket
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nClientSideApp: End of application.\n");
		
	}

}


			
			
			
			