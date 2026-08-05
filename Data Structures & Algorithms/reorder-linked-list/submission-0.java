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
    public void reorderList(ListNode head) {
         if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }



        ListNode secondList = reverseList(slow.next);

        slow.next = null;

        ListNode firstList = head;

        ListNode current = firstList;
        ListNode insert = secondList;

        while (insert != null) {


            ListNode nextInFirst = current.next;
            ListNode nextInSecond = insert.next;

            current.next = insert;
            insert.next = nextInFirst;

            current = nextInFirst;
            insert = nextInSecond;
        }
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
