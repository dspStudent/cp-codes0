class Solution {
    public int countTriplets(int[] arr) {
       int xor=0, count=0, n=arr.length;
        for(int i=0;i<n;i++){
            xor=arr[i];
            for(int j=i+1;j<n;j++){
                xor=xor^arr[j];
                if(xor==0)count+=(j-i);
            }
           
        }
        return count;
    }
}