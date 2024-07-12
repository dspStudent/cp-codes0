class Solution {
    int count=0;
    public StringBuilder f(char a, char b, StringBuilder s, int p){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==b){
                if(st.isEmpty()==false && st.peek()==a){
                    st.pop();
                    count+=p;
                }
                else{
                    st.push(c);
                }
            }
            else{
                st.push(c);
            }
        }
        s.setLength(0);
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        return s.reverse();
    }
    public int maximumGain(String str, int x, int y) {  
        char a='a', b='b';
        StringBuilder s=new StringBuilder(str);
        int max=Math.max(x, y);
        if(x>y){
            System.out.println(s);
            s=f(a, b, s, x);
            System.out.println(s);
            f(b, a, s, y);
        }
        else{
            System.out.println(s);
            s=f(b, a, s, y);
            System.out.println(s);
            f(a, b, s, x);
        }
        return count;
    }
}