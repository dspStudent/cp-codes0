class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i=0, j=0, n=s.length(), maxLen=0, cost=0;
        while(j<n ){
            int gape=Math.abs(s.charAt(j)-t.charAt(j));
            System.out.println(gape);
            if(gape+cost <= maxCost ){
                cost+=gape;
                System.out.println("i "+i+" j "+j+" "+maxLen+" "+(int)(j-i+1));
                maxLen=Math.max(maxLen, j-i+1);
            }
            else{
                cost+=Math.abs(s.charAt(j)-t.charAt(j));
                while(cost > maxCost){
                    cost-=Math.abs(s.charAt(i)-t.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return maxLen;
    }
}