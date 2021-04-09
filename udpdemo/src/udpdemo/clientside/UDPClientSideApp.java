package udpdemo.clientside;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * An example of client-side application using UDP
 * @author emalianakasmuri
 *
 */

public class UDPClientSideApp {

	public static void main(String[] args) {
		
		System.out.println("UDPClientSideApp: Demonstration of UDP Client-Side Application.");
		
		try {

			// Create the socket object to transmit the data.
			DatagramSocket datagramSocket = new DatagramSocket();

			// Get IP address
			InetAddress ip = InetAddress.getLocalHost();
			
			// Declare port no
			int portNo = 1234;

			// Convert the String input into the byte array
			String text = "Good morning";
			byte buf[] = text.getBytes();

			// Wrap data in datagram packet (constructor no 5)
			DatagramPacket outPacket = new DatagramPacket(buf, buf.length, ip, portNo);

			// Send datagram packet
			System.out.println("\nSending '" + text + "' out on network.\n");
			datagramSocket.send(outPacket);
			
			
			datagramSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("UDPClientSideApp: end of program.");

	}

}
