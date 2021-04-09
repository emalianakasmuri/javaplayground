package console.simple.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This application demonstrate the application of DataInputStream and 
 * DataOutputStream on the server side.
 * 
 * How to run this program?
 * 1. Open Terminal
 * 2. Change directory to workspace-dad/datainputstreamdemo/bin
 * 3. Type java console.simple.server.ServerSideApp
 * 
 * @author emalianakasmuri
 *
 */
public class ServerSideApp {

	public static void main(String[] args) {
		
		
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
				DataInputStream dataIS = new DataInputStream(socket.getInputStream());
				
				// Process request
				int request = dataIS.readInt();
				System.out.println("Request from client: " + request);
				
				
				
				System.out.println("Ready to serve another request");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

/*System.out.println("Request from client: " + dataIS.readFloat());
System.out.println("Request from client: " + dataIS.readDouble());
System.out.println("Request from client: " + dataIS.readBoolean());
System.out.println("Request from client: " + dataIS.readUTF());

byte raw[] = new byte[1024];
raw = dataIS.readAllBytes();

String data = new String(raw, StandardCharsets.UTF_8);

System.out.println("Request from client: " + data);*/


/* Put this code after line 46
// Create output stream to send result of data processing
DataOutputStream dataOS = new DataOutputStream(socket.getOutputStream());

// Send result
String responseData = "one";
System.out.println("Request to client: " + responseData);
dataOS.writeUTF(responseData);
dataOS.flush();
*/