class Solution {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public void h(StringBuilder s, List<List<String>> ans, List<String> currentPalindromes, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(currentPalindromes)); // Add copy of current palindromes list
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String subStr = s.substring(start, end + 1);
            if (isPalindrome(subStr)) {
                currentPalindromes.add(subStr);
                h(s, ans, currentPalindromes, end + 1);
                currentPalindromes.remove(currentPalindromes.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        h(new StringBuilder(s), ans, new ArrayList<>(), 0);
        return ans;
    }
}
