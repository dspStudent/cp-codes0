class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer>map=new HashMap<>();
        map.put(0, 1);
        int count=0, sum=0;
        for(int i:nums){
            sum+=i;
            // System.out.println(sum%k);
            int mod=((sum)%k+k)%k;
            if(map.containsKey(mod)){
                count+=map.get(mod);
                map.put(mod, map.get(mod) +1);
            }
            else map.put(mod, 1);
        }
        System.out.print(map);
        return count;
    }
}
// count=0

// 0 1
// 8 1
// 

