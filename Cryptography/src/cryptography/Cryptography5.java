/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Saurav
 */
public class Cryptography5 {
    
    final protected static char[] hexArray = "0123456789abcdef".toCharArray();
    public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for ( int j = 0; j < bytes.length; j++ ) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String text = "Burning 'em, if you ain't quick and nimble I go crazy when I hear a cymbal";
        String key = "ICE";
        
        byte[] tb = text.getBytes(StandardCharsets.US_ASCII);
        byte[] kb = key.getBytes(StandardCharsets.US_ASCII);
        byte[] bb = tb;
        for(int i=0;i<text.length();i++){
            bb[i]=(byte) (tb[i]^kb[i%3]);
        }
        System.out.println(bytesToHex(bb));
    }

}
