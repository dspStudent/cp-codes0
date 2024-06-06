class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer>map=new TreeMap<>();
        for(int i:hand){
            if(map.containsKey(i))map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }
        while(!map.isEmpty()){
            int first=map.firstKey();
            if(map.get(first)==1)map.remove(first);
            else map.put(first, map.get(first)-1);
            for(int i=1;i<groupSize;i++){
                if(map.containsKey(first+i)==false)return false;
                if(map.get(first+i)==1)map.remove(first+i);
                else map.put(first+i, map.get(first+i)-1);
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