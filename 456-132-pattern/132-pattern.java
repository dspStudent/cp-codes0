class Solution {
    public boolean find132pattern(int[] a) {
        int n=a.length;
        Stack<Integer>st=new Stack<>();
        int kel=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(a[i]<kel)return true;
            while(!st.isEmpty() && st.peek()<a[i]){
                kel=st.pop();
            }
            st.push(a[i]);
        }
        return false;
    }
}