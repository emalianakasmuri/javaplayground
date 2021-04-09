package console.simple.server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * How to run this application?
 * 1. Run on terminal
 * 
 * @author emalianakasmuri
 *
 */
public class ServerSideApp {

	public static void main(String[] args) {
		
		String fileName = "logo.jpeg";
		
		try {
			
			// Port to receive and respond to request
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println("Ready for request");
			
			// Server need to be alive forever thus the while(true)
			while (true) {
				
				// Accept client request for connection
				Socket socket = serverSocket.accept();
				
				// Create input stream to read data
				BufferedInputStream bufferIS = new BufferedInputStream(socket.getInputStream());
				
				// Process request
				byte rawData[] = bufferIS.readAllBytes();
				
				// Put the raw data into a file
				FileOutputStream fileOS = new FileOutputStream(new File(fileName));
				fileOS.write(rawData);
				
				// Get size of file
				File file =new File(fileName);
				FileInputStream fileIS = new FileInputStream(file);
				byte logoByte[] = fileIS.readAllBytes();
				System.out.println("Size of file = " + logoByte.length);
				
				fileIS.close();
				fileOS.close();
				bufferIS.close();
				socket.close();
				
				System.out.println("Ready to serve another request");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
