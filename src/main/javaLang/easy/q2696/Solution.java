package main.javaLang.easy.q2696;

import java.util.Stack;

class Solution {
    public int minLength(String s) {
        Stack<String> count = new Stack<>();
        String[] sArr = s.split("");
        for(String ss : sArr){
            String pre ="";
            if(!count.isEmpty()){
                pre = count.peek();
            }
            if ((pre+ss).equals("AB") || (pre+ss).equals("CD")){
                count.pop();
            } else {
                count.add(ss);
            }
        }
        return count.size();
    }
}
