package spira.microprocessor;

import java.util.Scanner;

public class MicroprocessorSimulation {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		// System.out.println("enter in 256 hex characters");
		String letters = keyboard.nextLine();

		char[] array = letters.toCharArray();
		char code;
		char accumulatorA = '0';
		char accumulatorB = '0';

		int place;
		int i = 0;
		String s;
		do {
			code = array[i];

			switch (code) {
			case '0':
				s = (String.valueOf(array[i + 1]) + String
						.valueOf(array[i + 2]));
				place = Integer.parseInt(s, 16);
				accumulatorA = array[place];
				i = i + 3;
				break;
			case '1':
				s = (String.valueOf(array[i + 1]) + String
						.valueOf(array[i + 2]));
				place = Integer.parseInt(s, 16);
				array[place] = accumulatorA;
				i = i + 3;
				break;
			case '2':
				char temp = accumulatorA;
				accumulatorA = accumulatorB;
				accumulatorB = temp;
				i++;
				break;
			case '3':
				s = (String.valueOf('0') + String.valueOf(accumulatorA));
				int A = Integer.parseInt(s, 16);
				s = (String.valueOf('0') + String.valueOf(accumulatorB));
				int B = Integer.parseInt(s, 16);
				int sum = A + B;
				String hex = Integer.toHexString(sum);
				hex = hex.toUpperCase();
				if (hex.length() == 1) {
					hex = "0" + hex;
				}
				accumulatorB = hex.charAt(0);

				accumulatorA = hex.charAt(1);
				i++;
				break;
			case '4':

				int number = Integer.parseInt(String.valueOf(accumulatorA), 16);
				if (number < 15) {
					number++;
				} else {
					number = 0;
				}
				String accA = Integer.toHexString(number);
				accumulatorA = accA.charAt(0);

				i++;
				break;
			case '5':

				number = Integer.parseInt(String.valueOf(accumulatorA), 16);
				if (number == 0) {
					number = 15;
				} else {
					number--;
				}
				accA = Integer.toHexString(number);
				accumulatorA = accA.charAt(0);
				i++;
				break;
			case '6':

				if (accumulatorA == '0') {
					s = (String.valueOf(array[i + 1]) + String
							.valueOf(array[i + 2]));
					place = Integer.parseInt(s, 16);
					i = place;
				} else {
					i = i + 3;
				}

				break;
			case '7':
				s = (String.valueOf(array[i + 1]) + String
						.valueOf(array[i + 2]));
				s = s.toUpperCase();
				place = Integer.parseInt(s, 16);
				i = place;
				break;

			}
		} while (code != '8');

		System.out.println(array);
		System.out.println("\n");

		keyboard.close();
	}

	/*public static int getDecimal(char i, char j) {

		String s = (String.valueOf(i) + String.valueOf(j));
		s = s.toUpperCase();
		int number = Integer.parseInt(s, 16);

		return number;
		
		 * int first = 0; int second = 0;
		 * 
		 * if (i == 'A') { first = 10 * 16; } else if (i == 'B') { first = 11 *
		 * 16; } else if (i == 'C') { first = 12 * 16; } else if (i == 'D') {
		 * first = 13 * 16; } else if (i == 'E') { first = 14 * 16; } else if (i
		 * == 'F') { first = 15 * 16; }else { String it = String.valueOf(i);
		 * first = Integer.parseInt(it); first = i * 16; } if (i == 'A') {
		 * second = 10; } else if (i == 'B') { second = 11; } else if (i == 'C')
		 * { second = 12; } else if (i == 'D') { second = 13; } else if (i ==
		 * 'E') { second = 14; } else if (i == 'F') { second = 15; } else {
		 * 
		 * String it = String.valueOf(j); second = Integer.parseInt(it); } int
		 * sum = first + second; return sum;
		 
	}*/

}
