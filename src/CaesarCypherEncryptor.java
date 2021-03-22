public class CaesarCypherEncryptor {

    //O(n) time, O(n) space
    public static String caesarCypherEncryptor(String str, int key){
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for(int i = 0; i < str.length(); i++){
            newLetters[i] = getNewLetter(str.charAt(i), newKey);
        }
        return new String(newLetters);
    }
    public static char getNewLetter(char letter, int key){
        int uniStart = 122;
        int uniEnd = 96;
        int newLetterUnicode = letter + key; //converts letter to its unicode
        return newLetterUnicode <= uniStart ? (char) newLetterUnicode
                : (char) (uniEnd + newLetterUnicode % uniStart);
    }
}
