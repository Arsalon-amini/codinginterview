import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberMnemonics {
    public static Map<Character, String[]> DIGIT_LETTERS = new HashMap<Character,String[]>();

    static {
        DIGIT_LETTERS.put('0', new String[] {"0"});
        DIGIT_LETTERS.put('1', new String[] {"1"});
        DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
        DIGIT_LETTERS.put('3', new String[] {"d","e","f"});
        DIGIT_LETTERS.put('4', new String[] {"g","h","i"});
        DIGIT_LETTERS.put('5', new String[] {"j","k","l"});
        DIGIT_LETTERS.put('6', new String[] {"m","n","o"});
        DIGIT_LETTERS.put('7', new String[] {"p","q","r","s"});
        DIGIT_LETTERS.put('8', new String[] {"t","u","v"});
        DIGIT_LETTERS.put('9', new String[] {"w","x","y","z"});
    }

    //O(4^n * n) time | O(4^n * n) space
    public ArrayList<String> getPhoneNumberMnemonics(String phoneNumber){
        String[] currentMnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonic, "0");

        ArrayList<String> mnemonicsResult = new ArrayList<String>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsResult);
        return mnemonicsResult;
    }

    public void phoneNumberMnemonicsHelper(int idx, String phoneNumber, String[] currentMnemonic, ArrayList<String> mnemonicsResult){
        if(idx == phoneNumber.length()){
            String mnemonic = String.join("", currentMnemonic); //O(n) operation at base case
            mnemonicsResult.add(mnemonic);
        } else {
            char digit = phoneNumber.charAt(idx); //extract digit
            String [] lettersRepresentingDigit = DIGIT_LETTERS.get(digit); //all chars representing digit
            //loop through all chars representing that digit
            for(String letter : lettersRepresentingDigit){
                currentMnemonic[idx] = letter; //replacing digit w/ a different char from list
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsResult);
            }
        }
    }

}
