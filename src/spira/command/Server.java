package spira.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {

			ServerSocket serverSocket = new ServerSocket(3772);// listen for the
																// other socket
			while (true) {
				Socket socket = serverSocket.accept(); // the socket gets
														// returned by a server
			//	Thread t = new Thread() { // socket //thiss is a
					// blocking call = it
					// will stay here untill
				//	@Override
				//	public void run() { // a socket gets
						// returned

						try {

							InputStream in = socket.getInputStream();

							BufferedReader reader = new BufferedReader(
									new InputStreamReader(in));// point of this
							String line;
							while ((line = reader.readLine()) != null) {
								System.out.println(line);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
			//	};
			//	t.start();

		//	}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
