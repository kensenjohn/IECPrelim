package com.snippets;

/**
 * Created by root on 8/26/15.
 */
public class WordSubStringRecursive {
    private String subString ="do";
    private String exampleText = "Lorem ipsum dolor sit amet, eeeeee consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    private int count = 0;
    public static void main(String[] args) {
        WordSubStringRecursive subStringRecursive = new WordSubStringRecursive();
        int count = subStringRecursive.countSubstring(0);
        System.out.println("Count:"+count);
    }

    public int countSubstring(int indexOfCount ){
        indexOfCount = this.exampleText.indexOf(subString,indexOfCount);
        if(indexOfCount == -1){
            return count;
        }
        this.count++;
        indexOfCount = indexOfCount + 1;
        return countSubstring(indexOfCount);
    }
}
