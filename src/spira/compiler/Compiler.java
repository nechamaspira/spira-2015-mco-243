package spira.compiler;

import java.util.ArrayList;
import java.util.Scanner;

public class Compiler {

 

	public static void main(String[] args) {

		ArrayList<String> instructions = new ArrayList<String>();
		char[] array = new char[256];
		
		String line;
		int i = 0;
		
		while(i<array.length){
			array[i]='0';
			i++;
		}
		i=0;
		int j=0;
		String secondWord;
		String firstWord;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter");
		line = keyboard.nextLine();

		do {
			
			//line = keyboard.nextLine();
			if(!line.substring(0, 2).equals("//")){
				instructions.add(line);
			}
			line = keyboard.nextLine();

			if(line.equals(String.valueOf(-1))){
				break;
			}
		} while (keyboard.hasNext());
	//} while (!line.equals(String.valueOf(-1)));

		do {
			String entireCode = instructions.get(j);
			String []words = entireCode.split(" "); 
			//int space = entireCode.indexOf(" ");

			firstWord= words[0];
			//if (entireCode.contains(" ")) {
			//	firstWord = entireCode.substring(0, space);
			//} else {
			//	firstWord = entireCode;
			//}

			firstWord =firstWord.toUpperCase();
			switch (firstWord) {
			case "LD":
				array[i++] = '0';
				//int position = entireCode.indexOf(" ");
				secondWord = words[1];
				
				//secondWord = entireCode.substring(space+1,space+3);

				secondWord = secondWord.toUpperCase();
				//secondWord = entireCode.substring( space,space+1);
				String hexNumber = Integer.toHexString(Integer.parseInt(secondWord));
				hexNumber = hexNumber.toUpperCase();
				if(hexNumber.length()==1){
					array[i++]='0';
					array[i++]=hexNumber.charAt(0);
				}
				else{
					array[i++]=hexNumber.charAt(0);
					array[i++]=hexNumber.charAt(1);
				}
				break;
			case "ST":
				array[i++] = '1';
				secondWord = words[1];

				//secondWord = entireCode.substring( space+1,space+3);
				 hexNumber = Integer.toHexString(Integer.parseInt(secondWord));
					hexNumber = hexNumber.toUpperCase();

				if(hexNumber.length()==1){
					array[i++]='0';
					array[i++]=hexNumber.charAt(0);
				}
				else{
					array[i++]=hexNumber.charAt(0);
					array[i++]=hexNumber.charAt(1);
				}
				//i++;
				break;
			case "SWP":
				array[i++]='2';
				//i++;
				break;
			case "ADD":
				array[i++]='3';
				//i++;
				break;
			case "INC":
				array[i++]='4';
				//i++;
				break;
			case "DEC":
				array[i++]='5';
				//i++;
				break;
			case "BZ":
				array[i++] = '6';
				//secondWord = entireCode.substring( space+1,space+3);
				secondWord = words[1];

				 hexNumber = Integer.toHexString(Integer.parseInt(secondWord));
					hexNumber = hexNumber.toUpperCase();

				if(hexNumber.length()==1){
					array[i++]='0';
					array[i++]=hexNumber.charAt(0);
				}
				else{
					array[i++]=hexNumber.charAt(0);
					array[i++]=hexNumber.charAt(1);
				}
				//i++;

				break;
			case "BR":
				array[i++] = '7';
				secondWord = words[1];

				//secondWord = entireCode.substring( space+1,space+3);
				 hexNumber = Integer.toHexString(Integer.parseInt(secondWord));
					hexNumber = hexNumber.toUpperCase();

				if(hexNumber.length()==1){
					array[i++]='0';
					array[i++]=hexNumber.charAt(0);
				}
				else{
					array[i++]=hexNumber.charAt(0);
					array[i++]=hexNumber.charAt(1);
				}
				//i++;
				break;
				
			case "STP":
				array[i++] = '8';
				//i++;
				break;
			
			case "DATA":
				hexNumber = Integer.toHexString(Integer.parseInt(words[2]));
				hexNumber = hexNumber.toUpperCase();
				array[Integer.parseInt(words[1])] = hexNumber.charAt(0);
				break;
			}	
		j++;
		} while (j < instructions.size());
	
		System.out.println(array);
		System.out.println("\n");
		keyboard.close();
	}

}
