import java.util.HashMap;

public class generateDocument {

    //O(n + m) time
    //O(c) space where c is # unique chars in the document string
    public boolean generateDocument(String characters, String document){
        HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();

        for (int idx = 0; idx < document.length(); idx++){
            char character = document.charAt(idx);
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }

        for(int idx = 0; idx < characters.length(); idx++){
            char character = characters.charAt(idx);
            if(!characterCounts.containsKey(character) || characterCounts.get(character) == 0){
                return false;
            }
            characterCounts.put(character, characterCounts.get(character) - 1); //update count
        }
        return true;
    }
}
