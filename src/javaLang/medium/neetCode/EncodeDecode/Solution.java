package javaLang.medium.neetCode.EncodeDecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder numberSb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!='#') {numberSb.append(str.charAt(i));}
            else {
                int charLenth = Integer.parseInt(numberSb.toString());
                int endPos = i+1+charLenth;
                result.add(str.substring(i+1, endPos));
                i = endPos -1;
                numberSb = new StringBuilder();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = {"we","say",":","yes","!@#$%^&*()"};
        List<String> inputList = Arrays.asList(input);
        String encodedString = encode(inputList);
        List<String> decodedString = decode(encodedString);
    }
}
