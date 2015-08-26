package com.snippets;

/**
 * Created by root on 8/25/15.
 */
public class WordSubStringRegular {
    public static void main(String[] args) {

        {
            String substring = "do";
            String exampleText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

            int indexLocation = 0;
            int count = 0;
            while(indexLocation>=0){
                indexLocation = exampleText.indexOf(substring,indexLocation);
                if(indexLocation>=0){
                    indexLocation = indexLocation+1;
                    count++;
                }
            }
            System.out.println("Loop Count:"+count);
        }
    }
}
