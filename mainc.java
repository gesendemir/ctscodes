package Allcontained;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class mainc {

	public static final int MAX_LEN = 10000000;
	public static void main(String[] args) {
		long[] m0 = {};
		long[] m1 = { 1, 2, 5 };
		long[] m2 = { 4, 3, 2, 1, 8, 7, 6, 5 };
		long[] m3 = { 2, 1, 5 };
		long[] m4 = { 2, 1, 4, 3, 2 };
		
		System.out.println("m0 subset of m1: result " + allContained(m0, m1) + " | expected: true");
		System.out.println("m0 subset of m2: result " + allContained(m0, m2) + " | expected: true");
		System.out.println("m0 subset of m3: result " + allContained(m0, m3) + " | expected: true");
		System.out.println("m0 subset of m4: result " + allContained(m0, m4) + " | expected: true");
		System.out.println("m1 subset of m0: result " + allContained(m1, m0) + " | expected: false");
		System.out.println("m1 subset of m2: result " + allContained(m1, m2) + " | expected: true");
		System.out.println("m2 subset of m1: result " + allContained(m2, m1) + " | expected: false");
		System.out.println("m0 subset of m0: result " + allContained(m0, m0) + " | expected: true");
		System.out.println("m1 subset of m1: result " + allContained(m1, m1) + " | expected: true");
		System.out.println("m1 subset of m3: result " + allContained(m1, m3) + " | expected: true");
		System.out.println("m3 subset of m1: result " + allContained(m3, m1) + " | expected: true");
		System.out.println("m4 subset of m0: result " + allContained(m4, m0) + " | expected: false");
		System.out.println("m4 subset of m1: result " + allContained(m4, m1) + " | expected: false");
		System.out.println("m4 subset of m2: result " + allContained(m4, m2) + " | expected: true");
		System.out.println("m4 subset of m3: result " + allContained(m4, m3) + " | expected: false");
		System.out.println("m4 subset of m4: result " + allContained(m4, m4) + " | expected: true");

		//Running time test:
		for (int len = 100; len <= MAX_LEN; len *= 10) {
			System.out.println("Array length " + len + ": ");
			long[] a1 = new long[len];
			long[] a2 = new long[len];

			for (int i = 0; i < len; i++) {
				a1[i] = i;
				a2[len - 1 - i] = i;
			}
			long start = System.nanoTime();
			boolean result = allContained(a1, a2);
			long ende = System.nanoTime();
			
			System.out.println("\ta1 contained in a2: " + result + " Running time: "
					+ ((ende - start) / 1e6) + " ms");
		}
	}


	public static boolean allContained(long[] a1, long[] a2) {
		if(a1.length == 0) return true;
		if(a2.length == 0) return false;
		Arrays.sort(a2);
		
		for(int i = 0; i < a1.length; i++) {
			 if(Arrays.binarySearch(a2, a1[i]) < 0) return false;
				
		}
		

		return true;
	}
}
