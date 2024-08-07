class Solution {
    String f(int num){
        String ans="";
        if (num == 11) {
                    ans += "Eleven";
                } else if (num == 12) {
                    ans += "Twelve";
                } else if (num == 13) {
                    ans += "Thirteen";
                } else if (num == 14) {
                    ans += "Fourteen";
                } else if (num == 15) {
                    ans += "Fifteen";
                } else if (num == 16) {
                    ans += "Sixteen";
                } else if (num == 17) {
                    ans += "Seventeen";
                } else if (num == 18) {
                    ans += "Eighteen";
                } else if (num == 19) {
                    ans += "Nineteen";
                }
        return ans;
    }
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        String ones[]={"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        String tens[]={"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String hun="Hundred", tho="Thousand", mil="Million";

        int n=(num+"").length();
        String ns=num+"", ans="";
        int i=0;
        while(i<n){
            if(ns.charAt(i)=='0'){
                i++;
                continue;
            }
            if(n-i==10){
                ans+=ones[Integer.parseInt(ns.charAt(i)+"")-1]+" "+"Billion"+" ";
                i++;
                continue;
            }
            if(n-i==9){
                String nn=ns.charAt(i)+""+ns.charAt(i+1)+""+ns.charAt(i+2);
                ans+=numberToWords(Integer.parseInt(nn))+" "+mil+" ";
                i+=3;
                continue;
            }
            if(n-i==8){
                String nn=ns.charAt(i)+""+ns.charAt(i+1);
                ans+=numberToWords(Integer.parseInt(nn))+" "+mil+" ";
                i+=2;
                continue;
            }
            if(n-i==7){
                ans+=ones[Integer.parseInt(ns.charAt(i)+"")-1]+" "+mil+" ";
                i++;
                continue;
            }
            
            if(n-i==6){
                String nn=ns.charAt(i)+""+ns.charAt(i+1)+""+ns.charAt(i+2);
                ans+=numberToWords(Integer.parseInt(nn))+" "+tho+" ";
                i+=3;
                continue;
            }
            if(n-i==5){
                String nn=ns.charAt(i)+""+ns.charAt(i+1);
                ans+=numberToWords(Integer.parseInt(nn))+" "+tho+" ";
                i+=2;
                continue;
            }
            if(n-i==4){
                ans+=ones[Integer.parseInt(ns.charAt(i)+"")-1]+" "+tho+" ";
                i++;
                continue;
            }
            if(n-i==3){
                String nn=ns.charAt(i+1)+""+ns.charAt(i+2);
                int number=Integer.parseInt(nn);
                if(number==0){
                    ans+=ones[Integer.parseInt(ns.charAt(i)+"")-1]+" "+hun+" ";
                    
                }
                else
                ans+=ones[Integer.parseInt(ns.charAt(i)+"")-1]+" "+hun+" "+numberToWords(Integer.parseInt(nn));
                break;
            }
            if(n-i==2){
                
                if(num>=11 && num<=19){
                    ans+=f(num);
                    break;
                }

                String nn=ns.charAt(i+1)+"";
                String pre="";
                if(nn.charAt(0)!='0')pre=ones[Integer.parseInt(nn)-1];
                ans+=tens[Integer.parseInt(ns.charAt(i)+"")-1]+" "+pre;
                break;
            }
            if(n-i==1){
                ans+=ones[Integer.parseInt(ns.charAt(i)+"")-1];
                i++;
            }
        }
        String answer[]=ans.split(" ");
        ans="";
        for(int it=0;it<answer.length;it++){
            if(it==answer.length-1)ans+=answer[it];
            else
            ans+=answer[it]+" ";
 
        }
        return ans;
    }
}

//  2147483647