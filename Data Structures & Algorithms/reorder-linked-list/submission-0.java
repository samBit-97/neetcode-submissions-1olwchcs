/**
 * Definition for singly-linked list.
 * public class ListListNode {
 *     int val;
 *     ListListNode next;
 *     ListListNode() {}
 *     ListListNode(int val) { this.val = val; }
 *     ListListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
                if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        ListNode firstHalfHead = head;
        ListNode secondHalfHead = prev;
        while (firstHalfHead != null && secondHalfHead != null) {
            ListNode temp1 = firstHalfHead.next;
            ListNode temp2 = secondHalfHead.next;

            firstHalfHead.next = secondHalfHead;
            secondHalfHead.next = temp1;

            firstHalfHead = temp1;
            secondHalfHead = temp2;
        }
    }
}
