package org.harald.leetcodeProblems;

import java.util.HashMap;
import java.util.Objects;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int highestCount = 0;
        int count = 0;
        HashMap<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.clear();
            count = 0;

            for (int j = i; j < s.length(); j++) {
                char character = s.charAt(j);
                if (!map.containsKey(character)) {
                    count++;
                    map.put(character, true);
                }
                if (count > highestCount) {
                    highestCount = count;
                }
            }

        }


        return highestCount;
    }

}
