//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = null;
            Node tail = head;

            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (head == null) {
                    head = new Node(temp);
                    tail = head;
                } else {
                    Node newNode = new Node(temp);
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
            }
            int x = sc.nextInt();

            Solution obj = new Solution();
            Node res = obj.deleteNode(head, x);

            Node.printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        Node del = head;
        x = x - 1;
        while (x-- > 0) del = del.next;

        /* base case */
        // if head_ref or del is null, return null.
        if (head == null || del == null) return null;

        /* If Node to be deleted is head Node */
        // if del is equal to head_ref, update head_ref to next node.
        if (head == del) head = del.next;

        /* Change next only if Node to be deleted is NOT the last Node */
        // if del next is not null, update previous node of del next to del previous.
        if (del.next != null) del.next.prev = del.prev;

        /* Change prev only if Node to be deleted is NOT the first Node */
        // if del previous is not null, update next node of del previous to del next.
        if (del.prev != null) del.prev.next = del.next;

        // return updated head_ref.
        return head;
    }
}