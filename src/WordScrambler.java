public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {

        scrambledWords = mixedWords(wordArr);

    }

    private String recombine(String word1, String word2) {
        return word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);
    }

    private String[] mixedWords(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(words[i].contains(" "))
                throw new IllegalArgumentException("Word Array must contain single words only! " + words[i] + " contains more than one word!");
        }
        if(words.length %2 != 0){
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        for(int i = 0; i < words.length; i = i+2){
            String firstComb = recombine(words[i], words[i+1]);
            String secondComb = recombine(words[i+1], words[i]);
            words[i] = firstComb;
            words[i+1] = secondComb;
        }
        return words;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}
