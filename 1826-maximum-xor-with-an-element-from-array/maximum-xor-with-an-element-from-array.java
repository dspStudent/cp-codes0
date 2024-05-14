class Node {
    Node links[];
    Node(){
        links=new Node[2];
    }
    public boolean containsKey(int i){
        return links[i]!=null;
    }
    public Node getNext(int i){
        return links[i];
    }
    public void addLink(int i){
        links[i]=new Node();
    }
}
class Solution {
    Node root;
    public void insert(int num){
        Node tri=root;
        for(int i=31;i>=0;i--){
            int x=(num >> i)&1;
            if(!tri.containsKey(x))
            tri.addLink(x);
            tri=tri.getNext(x);
        }
    }
//      public  void insert(int num) {
//     Node tri = root;
//     for (int i = 31; i >= 0; i--) {
//       int bit = (num >> i) & 1;
//       if (!tri.containsKey(bit)) {
//         tri.addLink(bit);
//       }
//       tri = tri.getNext(bit);
//     }
//   }
     public int getMax(int num) {
    Node node = root;
    int maxNum = 0;
    for (int i = 31; i >= 0; i--) {
      int bit = (num >> i) & 1;
      if (node.containsKey(1 - bit)) {
        maxNum = maxNum | (1 << i);
        node = node.getNext(1 - bit);
      } else {
        node = node.getNext(bit);
      }
    }
    return maxNum;
  }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        root=new Node();
        Integer q[][]=new Integer[queries.length][3];
        int it=0;
        for(int i[]:queries){
            for(int ind=0;ind<3;ind++){
                if(ind==2)q[it][2]=it;
                else
                q[it][ind]=i[ind];
            }
            it++;
        }
        Arrays.sort(q, (i, j)->i[1]-j[1]);
        Arrays.sort(nums);
        it=0;
        for(Integer i[]:q){
            System.out.println(Arrays.toString(i));
        }
        int ans[]=new int[q.length];
        for(int i=0;i<q.length;i++){
            while(it<nums.length && nums[it]<=q[i][1]){
                insert(nums[it]);it++;
            }
            if(it==0)ans[q[i][2]]=-1;
            else ans[q[i][2]]=getMax(q[i][0]);
        }
        return ans;
    }
}