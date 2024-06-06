class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        HashMap<Integer, Integer>map=new HashMap<>();
        for(int i:hand){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            else map.put(i, 1);
        }
        for(int i:hand){
            if(!map.containsKey(i))continue;
            int n=groupSize;
            int j=i;
            while(n>0){
                if(!map.containsKey(j))return false;
                if(map.isEmpty())return false;
                n--;
                if(map.get(j)==1)map.remove(j);
                else map.put(j, map.get(j)-1);
                j++;
            }
        }
        return true;

    }
}

// 1-1
// 2-2
// 3-2
// 4-1
// 6-1
// 7-1
// 8-1