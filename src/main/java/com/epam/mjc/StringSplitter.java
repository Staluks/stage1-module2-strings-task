package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> list = new ArrayList<>();
        list.add(source);
        for(String i:delimiters){
            for(int a = 0; a<list.size(); a++){
                if(list.get(a).contains(i)){
                    StringTokenizer st = new StringTokenizer(list.get(a), i);
                    int index = 0;
                    list.remove(a);
                    while(st.hasMoreTokens()){
                        list.add(a+index,st.nextToken());
                        System.out.println(list.get(a+index));
                        index++;

                    }

                }
            }
        }
        return list;
//        throw new UnsupportedOperationException("You should implement this method.");
    }
}
