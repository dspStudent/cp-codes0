class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>map=new HashMap<>();
        map.put(0, 0);
        map.put(nums[0]%k, 0);
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum%k==0)return true;
            if(map.containsKey(sum%k) && map.get(sum%k)+1!=i)return true;
            if(!map.containsKey(sum%k))
            map.put(sum%k, i);
        }
        System.out.println(map);
        return false;
    }
}