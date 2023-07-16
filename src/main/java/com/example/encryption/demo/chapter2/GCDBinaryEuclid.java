package com.example.encryption.demo.chapter2;

import java.math.BigInteger;

public class GCDBinaryEuclid {
    // バイナリユークリッド互除法によりaとbの最大公約数を求める
    public BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();
        }
        // Step1
        int g = 0;
        // Step2
        // a>0が満たされる間繰り返し
        while (a.signum() > 0 ) {
            // aとbが奇数であるかチェック、testBit()で最下位bitの状態を取得
            // 最下位bitが0なら元の値は偶数、1なら奇数
            boolean aIsOdd = a.testBit(0);
            boolean bIsOdd = b.testBit(0);
            // Step2-1
            // aとbが偶数であれば、a=a/2, b=b/2, g++する
            // 右へ1bitシフトすることで2で割る
            if (!aIsOdd && !bIsOdd) {
                a = a.shiftRight(1);
                b = b.shiftRight(1);
                g++;
            } else if (!aIsOdd && bIsOdd) {
                // Step2-2
                // aが偶数、bが奇数であれば、a=a/2とする
                // aを右へ1bitシフトすることでaを2で割った値で更新
                a = a.shiftRight(1);
            } else if (aIsOdd && !bIsOdd) {
                // Step2-3
                // aが奇数、bが偶数であれば、b=b/2とする
                // bを右へ1bitシフトすることでbを2で割った値で更新
                b = b.shiftRight(1);
            } else {
                // Step2-4
                // aとbが奇数であり、t=|a-b|/2に対してa>bであればa=tとし、a<bであればb=tとする
                if (a.compareTo(b) < 0) {
                    // subtract()でaとbの差を求め、shiftRight()で2で割った値で更新
                    b = b.subtract(a).shiftRight(1);
                } else {
                    a = a.subtract(b).shiftRight(1);
                }
            }
        }
        // Step3
        return b.shiftLeft(g);
    }
}
