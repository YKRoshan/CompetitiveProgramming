package com.linklist;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = null;
		ListNode t1 = l1;
		if (t1 == null) {
			l1 = new ListNode(2, null);
			t1 = l1;
		}
		t1.next = new ListNode(4, null);
		t1 = t1.next;
		t1.next = new ListNode(3, null);
		t1 = t1.next;

		ListNode l2 = null;
		ListNode t2 = l2;
		if (t2 == null) {
			l2 = new ListNode(5, null);
			t2 = l2;
		}
		t2.next = new ListNode(6, null);
		t2 = t2.next;
		t2.next = new ListNode(4, null);
		t2 = t2.next;


		ListNode ans = addTwoNumbers(l1, l2);
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = null;
		ListNode t = ans;
		int c = 0;
		while (l1 != null && l2 != null) {
			int v = l1.val + l2.val + c;
			c = 0;
			if (v >= 10) {
				v -= 10;
				c = 1;
			}
			ListNode t1 = new ListNode(v, null);
			System.out.println("Val " + t1.val);
			if (t == null) {
				ans = t1;
				t = ans;
			} else {
				t.next = t1;
				t = t.next;
			}

			ListNode t3 = ans;
			while (t3 != null) {
				System.out.println(t3.val);
				t3 = t3.next;
			}

			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int v = l1.val + c;
			c = 0;
			if (v >= 10) {
				v -= 10;
				c = 1;
			}
			ListNode t1 = new ListNode(v);
			if (t == null)
				t = t1;
			else
				t.next = t1;
			l1 = l1.next;
		}
		while (l2 != null) {
			int v = l2.val + c;
			c = 0;
			if (v >= 10) {
				v -= 10;
				c = 1;
			}
			ListNode t1 = new ListNode(v);
			if (t == null)
				t = t1;
			else
				t.next = t1;
			l2 = l2.next;
		}
		return ans;
	}
}
