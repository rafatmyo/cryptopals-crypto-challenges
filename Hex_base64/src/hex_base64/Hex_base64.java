
package hex_base64;

import java.math.BigInteger;
import org.apache.commons.codec.binary.Base64;

public class Hex_base64  {
    
  public static void main(String... args) {
      
    String hexadecimal = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
    System.out.println("hexadecimal: " + hexadecimal);

    BigInteger bigint = new BigInteger(hexadecimal, 16);

    StringBuilder sb = new StringBuilder();
    byte[] ba = Base64.encodeInteger(bigint);
    for (byte b : ba) {
        sb.append((char)b);
    }
    String s = sb.toString();
    System.out.println("base64: " + s);
    System.out.println("encoded: " + Base64.isBase64(s));
  }
}