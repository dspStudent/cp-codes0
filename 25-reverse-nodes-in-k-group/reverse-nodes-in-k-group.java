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
    private ListNode reverse(ListNode head){
        if(head.next==null)return head;
        ListNode temp=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)return null;
        ListNode partTail=head, partHead=head;
        for(int i=0;i<k-1;i++){
            if(partTail.next==null && i!=k-2)return partHead;
            partTail=partTail.next;
        }
        if(partTail==null)return partHead;
        ListNode nextHead=partTail.next;
        partTail.next=null;
        partTail=reverse(partHead);
        partHead.next=reverseKGroup(nextHead, k);
        return partTail;
    }
}