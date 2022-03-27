import java.math.BigInteger;
import java.util.*;
class ed{
  public static void main(String[] args){
    BigInteger bigpubkey = new BigInteger(args[0]);
    BigInteger bigprvkey = new BigInteger(args[1]);
    BigInteger n = new BigInteger(args[2]);
    int asciiVal = Integer.parseInt(args[3]);
    BigInteger val = new BigInteger(""+ asciiVal);
    BigInteger cipherval = val.modPow(bigpubkey,n);
    System.out.println("Cipher text: " + cipherval);
    BigInteger plainval = cipherval.modPow(bigprvkey,n);
    int oplainval = plainval.intValue();
    System.out.println("Plain text: "+ oplainval);
  }
}
