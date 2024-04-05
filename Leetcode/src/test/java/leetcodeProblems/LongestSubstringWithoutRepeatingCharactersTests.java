package leetcodeProblems;

import org.harald.leetcodeProblems.LongestSubstringWithoutRepeatingCharacters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTests {

    @Test
    void longestSubstring_successful_1() {
        LongestSubstringWithoutRepeatingCharacters e = new LongestSubstringWithoutRepeatingCharacters();

        int result = e.lengthOfLongestSubstring("abcabcbb");

        assertEquals(3, result);
    }

    @Test
    void longestSubstring_successful_2() {
        LongestSubstringWithoutRepeatingCharacters e = new LongestSubstringWithoutRepeatingCharacters();

        int result = e.lengthOfLongestSubstring("bbbbb");

        assertEquals(1, result);
    }

    @Test
    void longestSubstring_successful_3() {
        LongestSubstringWithoutRepeatingCharacters e = new LongestSubstringWithoutRepeatingCharacters();

        int result = e.lengthOfLongestSubstring("abcabcd");

        assertEquals(4, result);
    }



}
