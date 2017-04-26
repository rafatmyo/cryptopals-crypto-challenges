/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Saurav
 */
public class Cryptography4 {

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
            s = s + (char) ba[j];
        }
        return s;
    }

    public static int score(String str) {
        int count = 0;
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == ' ')) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner sc = new Scanner(new File("4.txt"));
        byte[] td;
        int max = 0;
        byte key = 0;
        while (sc.hasNext()) {
            String s = sc.nextLine();
//            System.out.println(s);
            td = hexStringToByteArray(s);
            byte[] ans = td;
            for (int i = 0; i < 256; i++) {
                for (int j = 0; j < td.length; j++) {
                    ans[j] = (byte) (td[j] ^ (byte) i);
                }

                if (score(byteToString(ans)) > max) {
                    max = score(byteToString(ans));
                    key = (byte) i;

                }
            }
        }
        
        System.out.println("Key : " + (char) key );
    }

}
