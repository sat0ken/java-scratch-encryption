package com.example.encryption.demo.chapter2;

import java.math.BigInteger;
public class GCDTrialDivision {
    public BigInteger gcd(BigInteger a, BigInteger b) {
        // 引数が正の数かチェック
        if (a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();
        }
        // Step1
        // 変数gを1で初期化。aとbを比較しaの方が小さい場合は値を交換
        BigInteger g = BigInteger.ONE;
        if (a.compareTo(b) < 0) {
            BigInteger t = a;
            a = b;
            b = t;
        }
        // Step2
        //　n=2とし、n<bが満たされる間、nを1ずつ増加させつつStep2-1を繰り返す
        for (BigInteger n = BigInteger.valueOf(2); n.compareTo(b) <= 0; n = n.add(BigInteger.ONE)) {
            // Step2-1
            // a,bともにnで割り切れる、余りが0である間、Step2-1-1を繰り返す
            while (a.remainder(n).equals(BigInteger.ZERO) && b.remainder(n).equals(BigInteger.ZERO)) {
                // Step2-1-1
                // g = ng
                g = n.multiply(g);
                // a=a/n
                a = a.divide(n);
                // b=b/n
                b = b.divide(n);
            }
        }
        // Step3
        return g;
    }
}
