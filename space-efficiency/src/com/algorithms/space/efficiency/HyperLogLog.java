package com.algorithms.space.efficiency;

import java.util.HashSet;
import java.util.Set;

/*This Class covers the implementation of HyperLogLog algorithm which is
 * very much used for space efficiency with minimal time
 * Please refer more details on Google paper
 * 
 * https://stefanheule.com/papers/edbt13-hyperloglog.pdf
 * 
 */

public class HyperLogLog {
	 // Let h : D → {0, 1}^32
    // Let m = 2^p with p ∈ [4..16].

    public static void main(String args[]) {
        // assign precision p = 16;
        // Input Set to find the cardinality estimate
        int p = 16;
        Set<Long> s = new HashSet<>();
        doHyperLogLog(p, s);
    }

    private static int[] initializeMRegisters(int size) {
        return new int[size - 1];
    }

    // P in the range of 4<=16
    private static int getMSize(int p) {
        return (int) Math.pow(2, p);
    }

    public static long linearCounting(int m, int v) {
        return (long) (m * Math.log(m / v));
    }

    public static Long doHyperLogLog(int p, Set<Long> s) {
        // Initialize M Registers
        int m = getMSize(p);
        doAggregation(p, initializeMRegisters(m), s);
        return null;
    }
    
    public static void doAggregation(int p, int[] mRegisters, Set<Long> s) {
        String h, sub;
        int idx, w, subIndex;
        for (Long l : s) {
            h = doHashing(l);
            idx = Integer.parseInt(h.substring(0, 32 - p), 2);
            sub = h.substring(32 - p, 32);
            subIndex = sub.indexOf("1");
            w = ((subIndex == -1) ? 0 : subIndex + 1);
            mRegisters[idx] = (mRegisters[idx] > w ? mRegisters[idx] : w);
        }
    }

    public static String doHashing(Long l) {
        return Long.toBinaryString(l);
    }

}
