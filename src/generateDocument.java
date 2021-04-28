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

    //O(m * (n + m)) time approx O(n^2) if n.length approx equal to m.length, O(1) space
    public static boolean generateDocumentV2(String characters, String document){
        for(int idx = 0; idx < document.length(); idx++){
            char character = document.charAt(idx);
            int documentFrequency = countCharacterFrequency(character, document); //O(n) time
            int charactersFrequency = countCharacterFrequency(character, characters); //O(m) time
            if(documentFrequency > charactersFrequency) return false;
        }
        return true;
    }
    public static int countCharacterFrequency(char character, String target){
        int frequency = 0;
        for(int idx = 0; idx < target.length(); idx++){
            char c = target.charAt(idx);
            if(c == character) frequency +=1;
        }
        return frequency;
    }
}
