package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Anagram {

	public static int anagram(char[] a, char[] b) {
		int[] arr = new int[26];
		int[] arr1 = new int[26];
		Arrays.fill(arr, 0);
		for (char c : a) {
			arr[c-'a']++;
			arr1[c-'a']++;
		}
		for (char c : b) {
			int i = c-'a';
			arr1[c-'a']--;
			if (arr[i] > 0) {
				arr[i]--;
			} else {
				arr[c - 'a']++;
			}
		}
		int counter = 0;
		for (int i : arr) {
			counter += i;
		}
		return counter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		scanner.close();
		System.out.println(anagram(a.toCharArray(), b.toCharArray()));
	}
}
