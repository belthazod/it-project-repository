
package UTIL;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The InputValidator servers as a tool check user Input depending on the 
 * conditions set.
 * @author Belthazod
 */
public class InputValidator {
    
    public static boolean checkInput(String input, String message){
        boolean result = true;
        if(input.equals("")){
            JOptionPane.showMessageDialog(null, message, "Input error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return result;
    }
    
    public static void clearInput(JTextField[] inputs){
        for(int i = 0; i<inputs.length ; i++){
            inputs[i].setText("");
        }
    }
    
    public static void clearInput(JTextField input){
        input.setText("");
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