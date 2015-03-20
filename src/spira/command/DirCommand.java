package spira.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirCommand {

	public static void main(String args[]){
		// Process p1;
		//Process p2;
		try {

			Process p1 = Runtime.getRuntime().exec("java -cp ./bin spira.command.Server"); //getruntime is a static method 
			Process	p2=Runtime.getRuntime().exec("java -cp ./bin spira.command.Client"); //getruntime is a static method 

			//its a factory method - it will return a runtime object for instance border factory,.accept, .io, url.openconnection
			//runtime is a singleton = there is only one copy of the object across the whole program
			BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));//p.getErrorStream() = prints out what error
			
			String line;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
