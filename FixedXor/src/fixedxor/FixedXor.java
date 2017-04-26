/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedxor;

import java.math.BigInteger;
import java.lang.*;

/**
 *
 * @author Tempadmin
 */
public class FixedXor {

   
    public static void main(String[] args) {
        
        String hex1 = "1c0111001f010100061a024b53535009181c";
        String hex2 = "686974207468652062756c6c277320657965";
        
        BigInteger bigint1 = new BigInteger(hex1, 16);
        BigInteger bigint2 = new BigInteger(hex2, 16);
        
        BigInteger bigint3 = bigint1.xor(bigint2);
        
         String hexNewValue = bigint3.toString(16);
       
        System.out.println("Hexadecimal valor 1: "+hex1);
        System.out.println("Hexadecimal valor 2: "+hex2);
        System.out.println("HexaDecimal valor XOR:"+hexNewValue);
    }
    
}
