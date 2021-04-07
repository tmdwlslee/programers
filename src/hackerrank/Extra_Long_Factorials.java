package hackerrank;

import java.math.BigInteger;

public class Extra_Long_Factorials {
    static void extraLongFactorials(int n) {
        BigInteger bNum = new BigInteger("1");
        while (n > 0) {
            BigInteger temp = new BigInteger(n + "");
            bNum = bNum.multiply(temp);
            --n;
        }
        System.out.println(bNum.toString());
    }

    public static void main(String[] args) {
        extraLongFactorials(5);
    }
}
