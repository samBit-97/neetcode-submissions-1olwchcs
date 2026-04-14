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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode prevSegment = dummy;
        dummy.next = head;

        while (true) {
            ListNode kth = shiftKNodes(prevSegment.next, k);
            if (kth == null) break;
            ListNode nextSegment = kth.next;

            ListNode prev = kth.next;
            ListNode curr = prevSegment.next;
            while (curr != nextSegment) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = prevSegment.next;
            prevSegment.next = kth;
            prevSegment = temp;
        }

        return dummy.next;
    }

    private ListNode shiftKNodes(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

}
