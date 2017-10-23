/** Vigenere.java 
  * @author Sammy Lincroft
  * @date 9/27/17
  * 
  * Class Vigenere is an implementation of the encryptable interface that uses a keyword to shift each letter of a message
  * forward to create an encrypted message. For example: if shifting the word hello by the word cat the letter one would follow the 
  * pattern 
  * H + C = H + 2 = J
  * E + A = E + 0 = E
  * L + T = L + 20 (%26) = E
  * L + C = L + 2 = N
  * O + A = O + 0 = O 
  * to produce the resulting encrypted message JEENO 
  * */

public class Vigenere implements Encryptable{
  
  /** 
   * @param message the message to be encrypted
   * @param secret the string to hold the secret message 
   * @param key the keyword used to encrypt the message
   * @param encrypted a boolean that tracks whether the secret is currently encrypted
   * @param alpha a static string holding the capital letter of the alphabet for reference when shifting characters
   * */
  
  private String message;
  private String secret;
  private String key;
  private boolean encrypted;
  private static String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
  /** constructor for the Vigenere class
    * @param _message the message to encrypt
    * @param _key the keyword to use when encrypting 
    * */
  Vigenere(String _message, String _key){
    key = _key.toUpperCase().replaceAll(" ", "");
    message = _message.toUpperCase().replaceAll(" ", "");
    secret = message;
  }
  
  /**
   * method encrypt uses the keyword to encrypt the message and stores the result in secret. Sets the state of encrypted to true.
   * */
  public void encrypt(){
    secret = "";
    for(int i=0; i<message.length(); i++){
      secret+=shift(message.charAt(i), key.charAt(i%key.length()));
    }
    encrypted=true;
  }
  
  /**
   * If the state of encrypted is true, decrypts the secret using the keyword and returns the result, 
   * otherwise does nothing and returns the empty string. 
   * @return the decrypted string or "" if the string has yet to be encrypted
   */
  public String decrypt(){
    if(encrypted){
      String decrypted="";
      for(int i=0; i<message.length(); i++){
        decrypted+=shiftBack(secret.charAt(i), key.charAt(i%key.length()));
      }
      return decrypted;
    }
    return "";
  }
  
  /**
   * method isEncrypted
   * @return true if the state of secret is currently encrypted, false if it has not been encrypted
   * */
  public boolean isEncrypted(){
    return encrypted;
  }
  
  /**
   * method shift 
   * @param m the message character
   * @param k the keyword character
   * @return the message character shifted forward by the keyword character
   * */
  private char shift(char m, char k){
    //System.out.println(m + " + " +k);
   int mPos=alpha.indexOf(m);
   int kPos=alpha.indexOf(k);
   int oPos=(mPos+kPos)%alpha.length();
   return(alpha.charAt(oPos));
  }
  
  /** 
   * method shiftBack
   * @param m the encrypted message character
   * @param k the keyword character
   * @return the message character shifted backwards by the keyword character 
   * */
  private char shiftBack(char m, char k){
    //System.out.println(m + " - " +k);
    int mPos=alpha.indexOf(m);
    int kPos=alpha.indexOf(k);
    int oPos=mPos-kPos;
    if(oPos<0){
      oPos=alpha.length()+oPos;
    }
    return(alpha.charAt(oPos));
  }
  
  /**
   * method toString
   * @return the message in secret (may be encrypted or not)
   * */
  public String toString(){
    return secret;
  }
  
  
}
