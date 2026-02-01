package karn.platforms.leetcode.contests.biweekly175;

//https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/
public class Problem1 {
    public String reverseByType(String s) {
        StringBuilder lower = new StringBuilder();
        StringBuilder sp = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='a'&&c<='z'){
                lower.append(c);
            }else{
                sp.append(c);
            }
        }
        lower.reverse();
        sp.reverse();
        StringBuilder result = new StringBuilder();
        int l = 0;
        int spp = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='a'&&c<='z'){
                result.append(lower.charAt(l++));
            }else{
                result.append(sp.charAt(spp++));
            }
        }
        return result.toString();
    }
}
