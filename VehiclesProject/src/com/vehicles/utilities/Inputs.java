package com.vehicles.utilities;

import javax.swing.JOptionPane;

public class Inputs {
	
	/**
	 * Method that invokes JOptionPane Class to jump a window 
	 * asking the user to enter information and retrieve a string.
	 * This method does not allow the user to enter an empty input, 
	 * it requires that it has at least one word and at most two.
	 * The input window is inside a while loop and its 
	 * output condition is a regex "\\w+\\s?\\w*"
	 * @param msg: Message that tells the user what to insert
	 * @return string in TitleCase (method)
	 */
	public static String returnString(String msg) {
		String userInput;
		
		try {
			do {
				userInput = JOptionPane.showInputDialog(msg);
			} while (!userInput.matches("\\w+\\s?\\w*"));
			
			userInput = toTitleCase(userInput);
		} catch (Exception e) {
			System.out.println("Inputing canceled by user");
			userInput = "NulL";
		}
		
		return userInput; 
	}
	
	/**
	 * Method that invokes JOptionPane Class to jump a window 
	 * asking the user to enter information and retrieve a string.
	 * This method does not allow the user to enter an empty input,
	 * requires you to enter at least four numbers and two or three letters.
	 * The input window is inside a while loop and its 
	 * output condition is a regex "^\\d{4}\\s?\\w{2,3}|\\w{2,3}\\s?\\d{4}$"
	 * 
	 * @param msg: Message that tells the user what to insert
	 * @return if there is a space between letters and numbers this method 
	 * removes it and returns a string with 6 or 7 characters in uppercase.
	 */
	public static String returnPlate(String msg) {
		String userPlate;
		
		try {
			
			userPlate = JOptionPane.showInputDialog(msg);
			
			while (!userPlate.matches("^\\d{4}\\s?\\w{2,3}|\\w{2,3}\\s?\\d{4}$")) {
				JOptionPane.showMessageDialog(null, "ERROR! La matrícula ha de contenir 4 números i 2 o 3 lletres.");
				userPlate = JOptionPane.showInputDialog(msg);
			}
			
			userPlate = userPlate.toUpperCase().replaceAll("\\s", "");
			
		} catch (Exception e) {
			System.out.println("Inputing canceled by user");
			userPlate = "NulL";
		}
		
		
		return userPlate; 
	}
	
	/**
	 * Method that invokes JOptionPane Class to jump a window 
	 * asking the user to enter information and retrieve a Double.
	 * This method does not allow the user to enter an empty input,
	 * requires the user to enter a numeric value between 0.4 and 4.0,
	 * if the user enters a comma-separated numeric, it will be exchanged for a period.
	 * The input window is inside a while loop and its 
	 * output condition is a regex "^[0]*\\.+[4-9]+|[1-3]\\.*\\d*|[4]\\.*[0]*$"
	 * @param msg: Message that tells the user what to insert
	 * @return double between 0.4 and 4.0
	 */
	public static Double returnDiameter(String msg) {
		
		Double convertedDiameter;
		
		try {
			
			String userDiameter = JOptionPane.showInputDialog(msg).replace(',', '.');
			
			while (!userDiameter.matches("^[0]*\\.+[4-9]+|[1-3]\\.*\\d*|[4]\\.*[0]*$")) {
				JOptionPane.showMessageDialog(null, "ERROR! El diàmetre ha d'estar entre 0,4 i 4,0.");
				userDiameter = JOptionPane.showInputDialog(msg).replace(',', '.');
			}
			
			convertedDiameter = Double.parseDouble(userDiameter);
			
		} catch (Exception e) {
			System.out.println("Inputing canceled by user");
			convertedDiameter = -1.0;
		}
		
		
		return convertedDiameter; 
	}
	
	/**
	 * Method that invokes JOptionPane Class 
	 * to jump a window that shows users a message 
	 * @param msg: string you want the user to be notified of
	 */
	public static void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	/**
	 * method that uses JOptionPane Class to pop up a 
	 * confirmation window with a yes, no and cancel options
	 * @param msg string with text that should appear in the confirmation
	 * @return int: 0=yes, 1=no, 2=cancel
	 */
	public static int confirmationMessage(String msg) {
		int confirmation = JOptionPane.showConfirmDialog(null,
                msg, "Confirmeu la informació del vehicle",JOptionPane.YES_NO_CANCEL_OPTION);
		
		return confirmation;
	}
	
	/**
	 * method that converts a string to TitleCase, 
	 * that is, each of the words in the string 
	 * will have the first capital letter 
	 * and all other lowercase letters.
	 * @param input: string you want to convert
	 * @return this same string capitalized only the first letters of each word
	 */
	public static String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder(input.length());
	    boolean nextTitleCase = true;

	    for (char c : input.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        } else {
	        	c = Character.toLowerCase(c);
	        }

	        titleCase.append(c);
	    }

	    return titleCase.toString();
	}

}
