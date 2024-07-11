class Solution {
    public String reverseParentheses(String s) {

		Stack<String>st = new Stack<>();

		String temp = "";

		for (char c : s.toCharArray()) {
			if (c == '(') {
				st.push(temp);
				temp = "";
				continue;
			}
			if(c==')'){
				StringBuilder sb=new StringBuilder(temp);
				temp=st.pop()+sb.reverse().toString();
				continue;
			}

			temp+=c+"";

		}
		return temp;

	}
}

// ReverseSubstringsBetweenEachPairOfParentheses