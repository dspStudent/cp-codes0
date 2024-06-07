class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String s[]=sentence.split(" ");
        // boolean vis[]=new boolean[s.length];
        System.out.print(Arrays.toString(s));
        for(int i=0;i<s.length;i++){
            // boolean tf=false;
            for(String w:dictionary){
                if(s[i].startsWith(w)){
                    s[i]=""+w;
                    // tf=true;
                    // break;
                }
            }
        }
        return String.join(" ", s);
    }
}