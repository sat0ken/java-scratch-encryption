package com.example.encryption.demo.chapter2;

import java.math.BigInteger;

public class ExtendedEuclidGCD {
    // 拡張ユークリッド互除法の実装
    public void gcd(BigInteger a, BigInteger b) {
        if (a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();
        }
        // Step1
        BigInteger xPrev = BigInteger.ONE, x = BigInteger.ZERO;
        BigInteger yPrev = BigInteger.ONE, y = BigInteger.ZERO;
        BigInteger rPrev = a, r = b;
        // Step2
        while (!r.equals(BigInteger.ZERO)) {
            // Step2-1
            BigInteger qNext = rPrev.divide(r);
            BigInteger rNext = rPrev.remainder(r);
            // Step2-2
            BigInteger xNext = xPrev.subtract(qNext.multiply(x));
            BigInteger yNext = yPrev.subtract(qNext.multiply(y));
            // Step2
            xPrev = x; x = xNext;
            yPrev = y; y = yNext;
            rPrev = r; r = rNext;
        }
        // Step3
        this.gcd_ = rPrev;
        this.x_ = xPrev;
        this.y_ = yPrev;
    }
    private BigInteger x_, y_, gcd_;
    public BigInteger getX() { return this.x_; }
    public BigInteger getY() { return this.y_; }
    public BigInteger getGCD() { return this.gcd_; }

}
