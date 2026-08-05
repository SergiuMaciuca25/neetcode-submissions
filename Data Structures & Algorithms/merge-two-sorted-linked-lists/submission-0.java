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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode res = new ListNode(-1);

        ListNode tail = res;

        while (list1 != null && list2 != null) {

            ListNode l1 = list1;
            ListNode l2 = list2;

            int v1 = l1.val;
            int v2 = l2.val;

            if (v1 < v2) {
                tail.next = l1;
                list1 = list1.next;
                 tail = tail.next;
            } else {
                tail.next = l2;
                list2 = list2.next;
                 tail = tail.next;
            }

        
        }

        while (list1 != null) {
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }

        return res.next;
    }
}