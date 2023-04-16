// Definition for singly-linked list.
class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleElementLinkedList {   
    // Function to find the middle element of linked list.
    public int getMiddle(ListNode head) {
        // If linked list is empty, return -1.
        if (head == null) {
            return -1;
        }
        
        // Slow and fast pointers for traversing the linked list.
        ListNode slow, fast;
        slow = fast = head;

        // Loop till the end of the list.
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1 step.
            fast = fast.next.next; // Move fast pointer by 2 steps.
        }

        // Slow pointer will be at the middle node.
        return slow.data;
    }

    public static void main(String[] args) {
        // Create a linked list with nodes 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Get middle node and print its value.
        MiddleElementLinkedList solution = new MiddleElementLinkedList();
        System.out.println("The middle element is: " + solution.getMiddle(head));
    }
}
