import java.util.List;

public class ValidSubsequence {
    //O(n) time, O(1) space

    public boolean isValidSubsequence(List<Integer> array, List<Integer> sequence){
        int arrIdx = 0;
        int seqIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()){
            if(array.get(arrIdx).equals(sequence.get(seqIdx))){
                seqIdx++; //move to next integer in sequence array
            }
            arrIdx++; //move to next integer in main array
        }
        return seqIdx == sequence.size(); //entire sequence traversed
    }

    public boolean isValidSubseq(List<Integer> array, List<Integer> sequence){
        int seqIdx = 0;
        for(var value: array){
            if(seqIdx == sequence.size()){
                break;
            }
            if(sequence.get(seqIdx).equals(value)){
                seqIdx++;
            }
        }
        return seqIdx == sequence.size(); //true if sequence fully traversed
    }
}
