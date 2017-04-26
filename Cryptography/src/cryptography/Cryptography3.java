/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author Saurav
 */
public class Cryptography3 {

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String byteToString(byte[] ba) {
        String s = "";
        for (int j = 0; j < ba.length; j++) {
            s=s+(char)ba[j];
        }
        return s;
    }

    public static int score(String str){
        int count=0;
        char c;
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c==' '))
                count++;
        }
        return count;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String text = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";

        byte[] td = hexStringToByteArray(text);
        byte[] ans = td;

        int max=0;
        byte key=0;
        String msg="";
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < td.length; j++) {
                ans[j] = (byte) (td[j] ^ (byte) i);
            }

//            System.out.println(i + "  "+ score(byteToString(ans)) +" "+byteToString(ans));
            if(score(byteToString(ans))>max){
                max =score(byteToString(ans));
                key=(byte)i;
                msg=byteToString(ans);
            }
        }
        System.out.println("Key : "+ (char)key + " , Message : " + msg);
        
    }

}
