
package UTIL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        try{
            if(input.trim().equals("")){
            JOptionPane.showMessageDialog(null, message, "Input error", JOptionPane.ERROR_MESSAGE);
            result = false;
            }
        }catch(NullPointerException npe){
            result = false;
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
    public static boolean match(String input){
        Pattern pat = Pattern.compile("09[0-9]{9}");
        Matcher mat = pat.matcher(input);
        boolean match = mat.matches();
        return match;
    }
    
    public static boolean match2(String input){
        Pattern pat2 = Pattern.compile("\\+639[0-9]{9}");
        Matcher mat2 = pat2.matcher(input);
        boolean match2 = mat2.matches();
        return match2;
    }
    
    public static boolean match3(String input){
        Pattern pat3 = Pattern.compile("\\d{3}[0-9]{7}");
        Matcher mat3 = pat3.matcher(input);
        boolean match3 = mat3.matches();
        return match3;
    }
    
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