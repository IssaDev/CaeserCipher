import edu.duke.*;

/**
 * Write a description of CaeserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaeserCipher {
       public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        int idx = 0;
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
                if(Character.isLowerCase(currChar)){
                   currChar =  Character.toUpperCase(currChar);
                    idx = alphabet.indexOf(currChar);
                    currChar =  Character.toLowerCase(currChar);
                }
                else{
                //Find the index of currChar in the alphabet (call it idx)
                idx = alphabet.indexOf(currChar);
            }
            //If currChar is in the alphabet
            if(idx != -1){
                if(Character.isLowerCase(currChar)){
                  //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);  
                encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
                else{
                   char newChar = shiftedAlphabet.charAt(idx); 
                   encrypted.setCharAt(i,newChar);
                }
                //Replace the ith character of encrypted with newChar
                
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int key = 15;
        
       // FileResource fr = new FileResource();
        //String message = fr.asString();
        String encrypted = encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        int idx =0;
        char newChar = ' ';
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
                currChar =  Character.toUpperCase(currChar);
                idx = alphabet.indexOf(currChar);
                currChar =  Character.toLowerCase(currChar);
            }else{
                idx = alphabet.indexOf(currChar);
            }
            if(idx != -1){
                if(Character.isLowerCase(currChar)){
                     if(i%2==0){
                          newChar = shiftedAlphabet1.charAt(idx); 
                        }
                        else{
                             newChar = shiftedAlphabet2.charAt(idx); 
                        }
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
                else{
                     if(i%2==0){
                          newChar = shiftedAlphabet1.charAt(idx); 
                        }
                        else{
                             newChar = shiftedAlphabet2.charAt(idx); 
                        }
                    encrypted.setCharAt(i,newChar);
                }
                
            }
           
        }
        return encrypted.toString();
    }
    
     public void testencryptTwoKeys() {
        int key1 = 21;
        int key2 = 8;
       // FileResource fr = new FileResource();
        //String message = fr.asString();
        String encrypted = encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", key1,key2);
        System.out.println(encrypted);
        String decrypted = encryptTwoKeys(encrypted, 26-key1, 26-key2);
        System.out.println(decrypted);
    }

}
