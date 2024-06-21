class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<Integer>st1=new Stack<>();
        Stack<String>st2=new Stack<>();
        String temp="";
        int num=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='['){
                st1.push(num);
                num=0;
                st2.push(temp);
                temp="";
            }
            else if(c==']'){
                int times=st1.peek();
                String res="";
                while(times-->0)res+=temp;
                temp=res;
                temp=st2.peek()+temp;
                st2.pop();
                st1.pop();
            }
            else if(c>='0' && c<='9'){
                num*=10;
                num+=c-'0';
            }
            else{
                temp+=c;
            }
        }
        return temp;
    }
}