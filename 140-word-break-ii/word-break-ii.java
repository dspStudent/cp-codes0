class Solution {
    private List<String>ans;
    private Set<String>set;
    private void f(int i, int j, String s, List<String>part){
        if(i>=j){
            String joinPart=String.join(" ", part);
            ans.add(joinPart);
            return;
        }
      for(int k=i;k<j;k++){
        if(set.contains(s.substring(i, k+1))){
            part.add(s.substring(i, k+1));
            f(k+1, j, s, new ArrayList<>(part));
            part.remove(part.size()-1);
        }
      }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans=new ArrayList<>();
        set=new HashSet<>();
        for(String i:wordDict)set.add(i);
        f(0, s.length(), s, new ArrayList<>());
        
        // System.out.println(ans);
        return ans;
    }
}