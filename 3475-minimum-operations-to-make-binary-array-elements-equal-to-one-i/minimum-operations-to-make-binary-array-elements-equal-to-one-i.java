class Solution {
    public int minOperations(int[] a) {
        int n=a.length;
        int i=0,c=0;
        while(i<n-2){
            if(a[i]==0){
                c++;
                for(int j=i;j<i+3;j++){
                    a[j]=1-a[j];
                }
            }
            // System.out.println(Arrays.toString(a));
            i++;
        }
        return Arrays.stream(a).filter(i1->i1==0).count()==0?c:-1;
    }
}


