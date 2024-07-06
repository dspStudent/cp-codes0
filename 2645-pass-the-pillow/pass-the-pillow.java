class Solution {
    public int passThePillow(int n, int time) {
        int ans=1;
        int flip=1;
        while(time!=0){
            time--;
            ans=flip==1?ans+1:ans-1;
            if(ans==n)flip=0;
            if(ans==1)flip=1;
        }
        return ans;
    }
}



// 1   2   3
//   _   _