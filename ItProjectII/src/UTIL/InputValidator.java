
package UTIL;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The InputValidator servers as a tool check user Input depending on the 
 * conditions set.
 * @author Belthazod
 */
public class InputValidator {
    
/**
 *  Checks if the given String is Empty. If so, a Dialog box appears
 *  indicating the error message specified with it.
 * 
 * @param input - the String to be checked
 * @param message - the Error message to show when the String is empty.
 * @return result - true if the given String is not empty otherwise returns 
 *      false.
 */
    public static boolean checkInput(String input, String message){
        boolean result = true;
        if(input.trim().equals("")){
            JOptionPane.showMessageDialog(null, message, "Input error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return result;
    }

/**
 *  Clears a given set of JTextFields of any text.
 * 
 * @param inputs - the array of JTextFields to be cleared of any value.
 */
    public static void clearInput(JTextField[] inputs){
        for(int i = 0; i<inputs.length ; i++){
            inputs[i].setText("");
        }
    }

/**
 *  Clears a single JTextField of any text.
 * 
 * @param input - the JTextField to be cleared of any value.
 */
    public static void clearInput(JTextField input){
        input.setText("");
    }
    
/**
 *  Checks if the given String is an integer. If not so, the error message 
 *  specified would pop out in the form of a dialog box.
 * 
 * @param input - the String to be checked.
 * @param message - the error message to show when the String is not an integer.
 */
    public static boolean checkIfNumber(String input, String message){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException x){
            JOptionPane.showMessageDialog(null, message, "Input error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}