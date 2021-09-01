package com.string;

public class PermutationOfAString {
	public static void main(String[] args) {
		PermutationOfAString obj = new PermutationOfAString();
		obj.printAllPermutations("ABC", 0, 2);
	}

	void printAllPermutations(String str, int left, int right) {
		if (left == right)
			System.out.println(str);
		else {
			for (int i = left; i <= right; i++) {
				str = swap(str, left, i);
				printAllPermutations(str, left + 1, right);
				str = swap(str, left, i);
			}
		}
	}

	String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
