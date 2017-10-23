/** 
 * PasswordTest.java
 * @author Sammy Lincroft
 * @date 9/27/17
 * a driver class for testing the Vigenere class 
 * uses a snazzy GUI! 
 * */

//import the JOptionPane to allow for GUI (see main method)
import javax.swing.JOptionPane;

public class PasswordTest{
  
  /**
   * method main 
   * instanciates and tests out a Vigenere cypher
   * */
  public static void main(String args[]){
    
    //declare private variables 
    String message, key, encrypted, decrypted;
    int decrypt;
    
    // ask the user what they would like to encrypt and what password they would like to use
    message = JOptionPane.showInputDialog("Enter the message to be encrypted:");
    key = JOptionPane.showInputDialog("Enter your password:");
    //create a new Vigenere cypher with the users settings 
    Vigenere mySecret = new Vigenere(message, key);
    //encrypt the message and store it in encrypted
    mySecret.encrypt();
    encrypted = mySecret.toString();
    //print encrypted to the terminal and the GUI
    System.out.println(encrypted);
    JOptionPane.showMessageDialog(null, encrypted);
    
    //ask if the user would like to decrypt the message
    decrypt = JOptionPane.showConfirmDialog(null, "Do you want it decrypted?");
    
    //if they would print the decrypted message to the GUI and the terminal
    if(decrypt == JOptionPane.YES_OPTION){
      decrypted = mySecret.decrypt();
      System.out.println(decrypted);
      JOptionPane.showMessageDialog(null, decrypted);
    }
    
  }
}