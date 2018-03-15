import edu.duke.*;
/**
 * Write a description of CaseserBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaseserBreaker {
    public int[] countLetters(String message){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet = alphabet.toLowerCase();
        int[] counts = new int[26];
        for(int i=0; i<message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alphabet.indexOf(ch);
            if(dex != -1){
                counts[dex]++;
            }
        }
        return counts;
    }

    public int getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex = indexOfMax(freqs);
        int dkey = maxDex -4;
        if(maxDex <4){
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }

     public int indexOfMax(int[]values){
        int maxIndex = 0;
        for(int i=0; i<values.length;i++){
            if(values[i] > values[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

   /* public String decrypt(String encrypted){
        CaeserCipher cc = new CaeserCipher();
        
        return cc.encrypt(encrypted, 26-dkey);
    }*/

    public String decryptTwoKeys(String encrypted){
        CaeserCipher cc = new CaeserCipher();
        String s1 = halfOf(encrypted,0);
        String s2 = halfOf(encrypted,1);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        System.out.println("the two keys are " + key1 + " and " + key2);
        return cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }

    public String halfOf(String word, int start){
        StringBuilder sb = new StringBuilder ();
        for(int i=0; i<word.length();i++){
            if(i%2 == start){
                char ch =word.charAt(i);
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public void testHalf(){
        String s = halfOf("Qbkm Zgis", 1);
        System.out.println(s);
    }
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource();
       String message = fr.asString();
        //String msg = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String decrypted = decryptTwoKeys(message);
        System.out.println("The decrypted message : " + decrypted); 
    }
    
        public String decrypt(String encrypted){
        CaeserCipher cc = new CaeserCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = indexOfMax(freqs);
        int dkey = maxDex -4;
        if(maxDex <4){
            dkey = 26 - (4-maxDex);
        }
        return cc.encrypt(encrypted, 26-dkey);
    }

}
