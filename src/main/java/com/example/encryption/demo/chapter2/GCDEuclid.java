package com.example.encryption.demo.chapter2;

import java.math.BigInteger;

public class GCDEuclid {

    // ユークリッド互除法によりaとbの最大公約数を求める
    public BigInteger gcd(BigInteger a, BigInteger b) {

        if (a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();
        }
        // Step1
        // aをbで割った余りをrとし,r≠0である間繰り返し
        for (BigInteger r = a.remainder(b);
             !r.equals(BigInteger.ZERO);
             r = a.remainder(b)) {
            // Step1-1
            // a=rとする
            a = b;
            // Step1-2
            // aとbを入れ替える
            b = r;
        }
        return b;
    }
}
