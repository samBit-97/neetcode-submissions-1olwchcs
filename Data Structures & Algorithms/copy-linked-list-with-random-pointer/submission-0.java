/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         Node temp = head;

        // Interweave nodes
        while (temp != null) {
            Node next = temp.next;

            Node copy = new Node(temp.val);
            copy.next = next;
            temp.next = copy;

            temp = next;
        }

        // fix random nodes for clone nodes
        temp = head;
        while (temp != null) {
            Node clone = temp.next;
            clone.random = temp.random != null ? temp.random.next : null;
            temp = clone.next;
        }

        // Detach from original list
        Node dummy = new Node(0);
        Node tail = dummy;

        temp = head;
        while (temp != null) {
            Node clone = temp.next;
            temp.next = clone.next; // fix original list
            tail.next = clone;
            tail = tail.next;
            temp = temp.next;
        }

        return dummy.next;
 
    }
}
