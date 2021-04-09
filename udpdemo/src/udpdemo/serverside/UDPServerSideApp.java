package udpdemo.serverside;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * An example of server-Side application using UDP
 * 
 * How to run this application
 * 1. Open terminal
 * 2. Change to directory to /workspace-dad/udpdemo/bin
 * 3. java udpdemo.serverside.UDPServerSideApp
 * 4. Initial output: 
 * 	UDPServerSideApp: Demonstration of UDP Server-Side Application.
 * 5. Final output: 
 * 	Message received: Good morning.
 * 
 * 
 * @author emalianakasmuri
 *
 */

public class UDPServerSideApp {

	public static void main(String[] args) {
		
		System.out.println("UDPServerSideApp: Demonstration of UDP Server-Side Application.");
        
        try {
        	
    		// Declaration of port no to received datagram packet
    		int portNo = 1234;
    		
    		// Create a socket to listen at port 1234
            DatagramSocket datagramSocket = new DatagramSocket(portNo);
        	
        	while (true) {
                
                // Variable to received data from port 1234
                byte[] receivedData = new byte[65535];
          
                // Datagram to hold received packet
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                
                // Received packet datagram
				datagramSocket.receive(receivedPacket);
				
				// Retrieve data from packet 
				String retreiveMessage = new String(receivedPacket.getData());
				System.out.println("\nMessage received: " + retreiveMessage + ".\n");
				
				// Clear the buffer after every message.
	            receivedData = new byte[65535];
	            
        	}
				
		} catch (IOException e) {
				
			e.printStackTrace();
        }
        
        System.out.println("UDPClientSideApp: end of program.");
    }
}
