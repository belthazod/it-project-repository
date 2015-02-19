
package BEANS;

import javax.swing.JTextField;

/**
 *
 * @author Belthazod
 */
public class InputValidator {

    public static boolean checkInput(JTextField input){
        boolean result = true;
        if(input.getText().equals("")){
            result = false;
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
}