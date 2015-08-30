package cn.idear.algorithm.text_justification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if(words.length == 0){
            result.add("");
            return result;
        }
        List<List<String>> strings = cutText(words, maxWidth);
        for(int i = 0; i < strings.size(); i++)
            result.add(justify(strings.get(i), maxWidth, i == strings.size() - 1));
        return result;
    }

    private String justify(List<String> string, int maxWidth, boolean isLastLine) {
        StringBuffer sb = new StringBuffer();
        int size = string.size();
        if(isLastLine){
           sb.append(string.get(0));
           for(int i = 1; i < string.size(); i++) {
               sb.append(' ');
               sb.append(string.get(i));
           }
            int len = sb.toString().length();
            for(int i = len; i < maxWidth; i++)
                sb.append(' ');
        }
        else if(size == 1){
            String word = string.get(0);
            sb.append(word);
            for(int i = word.length(); i < maxWidth; i++)
                sb.append(' ');
        }else{
            int spaces;
            int length = 0;
            for(String str : string)
                length += str.length();
            spaces = maxWidth - length;
            int every = spaces / (size - 1);
            int remainder = spaces % (size - 1);
            for(int i = 0; i < string.size(); i++){
                String str = string.get(i);
                if(i > 0)
                    for(int j = 0; j < every; j++)
                        sb.append(' ');
                sb.append(str);
                if(remainder > 0) {
                    sb.append(' ');
                    remainder--;
                }
            }
        }
        return sb.toString();
    }

    private List<List<String>> cutText(String[] words, int maxWidth) {
        List<List<String>> result = new ArrayList<>();
        int curLength = 0;
        List<String> container = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String newWord = words[i];
            if(curLength == 0 || curLength + 1 + newWord.length() <= maxWidth){
                container.add(newWord);
                if(curLength == 0)
                    curLength = newWord.length();
                else
                    curLength += newWord.length() + 1;
            }else{
                result.add(container);
                container = new ArrayList<>();
                container.add(newWord);
                curLength = newWord.length();
            }
        }
        if(!container.isEmpty())
            result.add(container);
        return result;
    }
}
