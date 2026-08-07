/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int bonus = 0;

        while (l1 != null || l2 != null || bonus != 0) {
            int v1;
            if (l1 != null) {
                v1 = l1.val;
            } else {
                v1 = 0;
            }

            int v2;
            if (l2 != null) {
                v2 = l2.val;
            } else {
                v2 = 0;
            }

            int total = v1 + v2 + bonus;

            bonus = total / 10;
            int digit = total % 10;

            tail.next = new ListNode(digit);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }


    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
            
        }

        return prev;

    }
}
