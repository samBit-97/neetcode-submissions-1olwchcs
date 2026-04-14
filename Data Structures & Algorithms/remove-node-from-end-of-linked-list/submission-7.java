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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            if (temp == null) return null;
            temp = temp.next;
        }

        if (temp == null) {
            return head.next;
        }
        
        ListNode slow = head;
        while (temp.next != null) {
            slow = slow.next;
            temp = temp.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
