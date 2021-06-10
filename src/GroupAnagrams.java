import java.util.*;

//O(w*n*log(n)) time where w is number of words in input string, and n is length of the longest
//O(wn) space
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words){
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

        for(String word : words){
            char [] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if(anagrams.containsKey(sortedWord)){
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }
        }

        return new ArrayList<>(anagrams.values());
    }
}
