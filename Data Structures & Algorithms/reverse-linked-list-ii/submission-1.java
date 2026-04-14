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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        if (left == right) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevSegment = dummy;

        for (int i = 1; i < left; i++) {
            prevSegment = prevSegment.next;
        }

        ListNode curr = prevSegment.next;
        ListNode after = curr.next;
        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        ListNode start = prevSegment.next;
        prevSegment.next = prev;
        start.next = curr;

        return dummy.next;
    }
}