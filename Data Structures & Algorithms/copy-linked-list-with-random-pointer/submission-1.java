class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert copy nodes in between
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;

            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = nextNode;

            curr = nextNode;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node nextOriginal = curr.next.next;

            // extract copy
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;

            // restore original list
            curr.next = nextOriginal;

            curr = nextOriginal;
        }

        return dummy.next;
    }
}