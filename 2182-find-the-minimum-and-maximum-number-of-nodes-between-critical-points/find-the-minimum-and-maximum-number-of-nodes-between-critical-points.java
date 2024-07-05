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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next==null)return new int[]{-1, -1};
        List<Integer>nodes=new ArrayList<>();
        ListNode prev=head, cur=head.next, nex=head.next.next;
        int it=2;
        while(nex!=null){
            if(cur.val > prev.val && cur.val> nex.val){
                nodes.add(it);
            }
            if(cur.val < prev.val && cur.val < nex.val){
                nodes.add(it);
            }
            it++;
            prev=prev.next;
            nex=nex.next;
            cur=cur.next;
        }
        System.out.println(nodes);
        if(nodes.size()==0)return new int[]{-1, -1};
        if(nodes.size()==1)return new int[]{-1, -1};
        int max=nodes.get(nodes.size()-1)-nodes.get(0);
        int min=(int)1e9;
        for(int i=1;i<nodes.size();i++){
            min=Math.min(min, nodes.get(i)-nodes.get(i-1));
        }
        return new int[]{min, max};
    }
}