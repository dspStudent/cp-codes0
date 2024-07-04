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
    private ListNode addSum(ListNode start, ListNode end){
        int sum=end.val;
        while(start!=end){
            sum+=start.val;
            start=start.next;
        }
        String s=sum+"";
        return new ListNode(Integer.parseInt(s+""));
    }
    public ListNode mergeNodes(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode partHead=head, partTail=head;
        partTail=partHead.next;
        while(partTail.next!=null && partTail.val!=0){
            partTail=partTail.next;
        }
        partHead=addSum(partHead, partTail);
        ListNode t=partTail;
        // while(t!=null){
        //     System.out.print(t.val+" ");
        //     t=t.next;
        // }
        // System.out.println();
        partHead.next=mergeNodes(partTail);
        return partHead;
    }
}

