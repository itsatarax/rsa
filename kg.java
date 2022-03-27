import java.util.*;
import java.math.BigInteger;
import java.lang.*;

class kg {
  public static void main(String[] args){
    Random rand1 = new Random(System.currentTimeMillis());
    Random rand2 = new Random(System.currentTimeMillis()*10);
    int pubkey = Integer.parseInt(args[0]);
    BigInteger p = BigInteger.probablePrime(32,rand1);
    BigInteger q = BigInteger.probablePrime(32,rand2);
    BigInteger n = p.multiply(q);
    BigInteger p_1 = p.subtract(new BigInteger("1"));
    BigInteger q_1 = q.subtract(new BigInteger("1"));
    BigInteger pq = p_1.multiply(q_1);
    while(true){
      BigInteger gcd = pq.gcd(new BigInteger(""+pubkey));
      if(gcd.equals(BigInteger.ONE)){
        break;
      }
      pubkey++;
    }
    BigInteger bigpubkey = new BigInteger(""+pubkey);
    BigInteger bigprvkey = bigpubkey.modInverse(pq);
    System.out.println("public key: " + bigpubkey +"," + n);
    System.out.println("private key: " +bigprvkey +"," + n);
  }
}
