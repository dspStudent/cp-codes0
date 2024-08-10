//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        if (k == 0) return head;

        Node walk = head;
        Node prev = null;

        // this loop runs k times and walk pointer moves k nodes ahead
        // and reaches new head node.
        while (k-- > 0 && walk != null) {
            prev = walk;
            walk = walk.next;
        }
        // considering cases where k>=n so nothing needs to be done.
        if (walk == null) return head;

        // we store the walk pointer which gives the first node in newHead.
        Node newHead = walk;

        // since prev points to the node placed before new head it is new tail
        // or the last node of new list so we store null in it's link part.
        prev.next = null;

        // we keep moving the walk pointer till we reach the last node of list.
        while (walk.next != null) walk = walk.next;

        // connecting last node of old list to old head.
        walk.next = head;

        // returning the new list.
        return newHead;
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends