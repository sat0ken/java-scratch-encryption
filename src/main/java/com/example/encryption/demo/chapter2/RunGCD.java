package com.example.encryption.demo.chapter2;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RunGCD {
    public static void runGCD(Integer bitCount, Integer dataCount) {
        GCDBinaryEuclid gcd = new GCDBinaryEuclid();
        if (bitCount <= 0 || dataCount <= 0) {
            return;
        }

        BigInteger[] randoms = new BigInteger[dataCount + 1];
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < randoms.length;) {
            BigInteger v = new BigInteger(bitCount, r);
            if (v.signum() != 0) {
                randoms[i++] = v;
            }
        }
        long t = Long.MAX_VALUE;
        for (int j=0; j < 10; j++) {
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < dataCount; i++) {
                gcd.gcd(randoms[i], randoms[i+1]);
                long t2 = System.currentTimeMillis();
                long d = t2 - t1;
                if (d < t) {
                    t = d;
                }
                System.out.print(" " + d);
            }
            System.out.println(" : " + t);
        }
    }
}
