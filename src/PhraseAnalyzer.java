/**
 * Input the phrase for the program
 * @author Riya Gunda
 */
public class PhraseAnalyzer {
    /**
     * setting variable for the number zero
     */
    public static final int NUMBER_ZERO = 0;

    /**
     * setting variable for the number one
     */
    public static final int NUMBER_ONE = 1;

    /**
     * setting variable for the number two
     */
    public static final int NUMBER_TWO = 2;

    /**
     * setting variable for the number three
     */
    public static final int NUMBER_THREE = 3;

    /**
     * setting variable for the number four
     */
    public static final int NUMBER_FOUR = 4;

    /**
     * setting variable for the number five
     */
    public static final int NUMBER_FIVE = 5;

    /**
     * setting variable for the number six
     */
    public static final int NUMBER_SIX = 6;

    /**
     * setting variable for the number seven
     */
    public static final int NUMBER_SEVEN = 7;

    /**
     * setting variable for the number eight
     */
    public static final int NUMBER_EIGHT = 8;

    /**
     * setting variable for the number nine
     */
    public static final int NUMBER_NINE = 9;

    /**
     * setting variable for a char array of all the
     * alphabets
     */
    public static final char[] ALPHABETS = {'a','b','c','d','e','f','g','h',
        'i','j','k','l','m','n','o','p','q', 'r','s','t','u','v','w','x','y','z'};

    /**
     * setting a variable for number of letters
     */
    public static final int NUMBER_OF_ALPHABETS = 26;

    /**
     * Program starts
     * @param args from command line
     */    
    
    public static void main(String[] args){
        String phrase = "";
        for (String arg : args) {
            phrase += arg;
            phrase += " ";
        }
        String[] arrayPhrase = new String[phrase.length()];
        arrayPhrase = phrase.split(" ");

        System.out.println();
        boolean validYN = isValidPhrase(arrayPhrase);

        if(!validYN) {
            System.out.println("Invalid phrase");
            System.exit(0);
        } 

        String swString = getSmallestWords(arrayPhrase);
        System.out.println("Smallest word(s): " + swString);

        String lwString = getLargestWords(arrayPhrase);
        System.out.println("Largest word(s): " + lwString);

        double avgVal = getAverageWordLength(arrayPhrase);
        System.out.printf("Average word length: %.2f", avgVal);
        System.out.println();

        // divider
        int[] tester = getLetterTally(arrayPhrase);
        System.out.println();
        int len = 0;
        for(int i = 0; i < tester.length; i++){
            if(tester[i] != 0){
                len++;
            }
        }

        int[] leastFreq = new int[len];
        int x = 0;
        for(int i = 0; i < tester.length; i++){
            if(tester[i] > 0){
                leastFreq[x] = tester[i];
                x++;
            }
        }
        
        char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
            'r','s','t','u','v','w','x','y','z'};
            
        int least = Integer.MAX_VALUE;
        for(int i = 0; i < leastFreq.length ; i++){
            if (leastFreq[i] < least) {
                least = leastFreq[i];
            }
        }
        
        String leastFreqLetters = "";
        for(int i = 0; i < getLetterTally(arrayPhrase).length; i++) {
            if (getLetterTally(arrayPhrase)[i] == least) {
                leastFreqLetters += alphabets[i] + ", ";
            }
        }

        int lf = leastFreqLetters.length() - NUMBER_TWO;
        String lfString = leastFreqLetters.substring(0, lf);

        System.out.println("Least frequently used letter(s): " + lfString);

        // divider
        int most = leastFreq[0];
        for(int i = 0; i < getLetterTally(arrayPhrase).length; i++) {
            if(getLetterTally(arrayPhrase)[i] > most){
                most = getLetterTally(arrayPhrase)[i];
            }
        }
        
        String mostFreqLetters = "";
        for(int i = 0; i < getLetterTally(arrayPhrase).length; i++) {
            if (getLetterTally(arrayPhrase)[i] == most) {
                mostFreqLetters += alphabets[i] + ", ";
            }
        }
        int mf = mostFreqLetters.length() - NUMBER_TWO;
        String mfString = mostFreqLetters.substring(0, mf);

        System.out.println("Most frequently used letter(s): " + mfString);
    }

    /**
     * This method return true if the phrase is valid, else false
     * @param phrase String array
     * @return boolean values true or false based on the entered phrase
     */
    public static boolean isValidPhrase(String[] phrase) {
        if (phrase == null || phrase.length == NUMBER_ZERO) {
            return false;
        }        
        boolean l = false;
        boolean p = false;
        
        for (String wordPhrase : phrase) {
            if (wordPhrase == null || wordPhrase.isEmpty()) {
                return false;
            }

            for(int i = 0; i < wordPhrase.length(); i++){
                char check  = wordPhrase.charAt(i);
                if(Character.isLetter(check)) {
                    l = true;
                } else if(i == wordPhrase.length() - 1 && 
                    (check == '.' || check == ',' || check == '!' ||
                        check == ';')) {
                    p = true;                    
                } else {
                    return false;                    
                }

                if (wordPhrase.length() == 1 && p) {
                    return false;
                }
            }   
        }

        if(l){
            return true;
        }   

        return false;
    }

    /**
     * Returns a String array of the "words" in the phrase without any punctuation
     * in the order they appeared in the phrase.
     *
     * It does not change the array in any way.
     * @param phrase String array
     * @return the same array without any punctuations
     * @throws IllegalArgumentException with the message, "Invalid phrase", if
     * the phrase is invalid.
     */
    public static String[] getWords(String[] phrase) {
        if (!isValidPhrase(phrase)) {
            throw new IllegalArgumentException("Invalid phrase");
        }

        String [] wordsPhrase = new String[phrase.length];
        int newIndex = NUMBER_ZERO;
        String newBuild = "";

        for(int i = NUMBER_ZERO; i < phrase.length; i++) {
            String word = phrase[i];
            for(int j = NUMBER_ZERO; j < word.length(); j++){
                char check = word.charAt(j);
                if(Character.isWhitespace(check) || Character.isLetter(check)) {
                    newBuild += check;
                }
            }
            wordsPhrase[newIndex] = newBuild;
            newIndex++;
            newBuild = "";
        }
        
        return wordsPhrase;
    }

    /**
     * Returns a String containing the smallest unique word(s)
     * in the order they appear in the words array, with multiple words
     * separated by a comma followed by a space, but with no comma or space at the
     * end of the String.
     *
     * This method does not change the words array.
     * @param words a String array with multiple words separated by a comma and
     *              then a space
     * @return a String containing the smallest unique words from the array
     * @throws IllegalArgumentException with the message, "Null words", if the
     * words array is null.
     * @throws IllegalArgumentException with the message, "Zero length", if the
     * length of the words array is 0.
     * @throws IllegalArgumentException with the message, "Invalid words", if
     * any word is null, has a length of 0, or contains a non-letter character
     */
    public static String getSmallestWords(String[] words) {
        words = getWords(words);
        if(words == null) {
            throw new IllegalArgumentException("Null words");
        }

        if(words.length == 0) {
            throw new IllegalArgumentException("Zero length");
        }

        for (int i = NUMBER_ZERO; i < words.length; i++) {
            String wordPhrase = words[i];
            if (wordPhrase == null || wordPhrase.length() == 0) {
                throw new IllegalArgumentException("Invalid words");
            }

            for (int j = NUMBER_ZERO; j < wordPhrase.length(); j++) {
                if (!Character.isLetter(wordPhrase.charAt(j))) {
                    throw new IllegalArgumentException("Invalid words");
                }
            }
        }

        String[] temp = new String[words.length];
        int index = NUMBER_ZERO;
        boolean unique = true;
        for(int i = NUMBER_ZERO; i < words.length; i++){
            String word = words[i];
            unique = true;
            for(int x = NUMBER_ZERO; x < words.length; x++) {
                if(word.equals(temp[x])) {
                    unique = false;
                    break;
                }
            }
            if(unique){
                temp[index] = word;
                index++;
            }
        }

        int count = NUMBER_ZERO;
        for(int i = NUMBER_ZERO; i < words.length; i++) {
            if(temp[i] == null){
                break;
            }
            count++;
        }

        String[] holder = new String[count];

        for(int i = NUMBER_ZERO; i < holder.length; i++){
            holder[i] = temp[i];
        }

        String smallestWords = "";
        int j = NUMBER_ZERO;
        int minLength = holder[NUMBER_ZERO].length();
        for(int i = NUMBER_ZERO; i < holder.length; i++) {
            j = holder[i].length();
            if(j < minLength){
                minLength = j;
            }
        }

        for(int i = NUMBER_ZERO; i < holder.length; i++) {
            if(holder[i].length() == minLength) {
                smallestWords += holder[i] + ", ";
            }
        }

        int lf = smallestWords.length() - NUMBER_TWO;
        String f = smallestWords.substring(NUMBER_ZERO,lf);
        return f;
    }

    /**
     * Returns a String containing the largest unique word(s)
     * in the order they appear in the words array, with multiple words
     * separated by a comma followed by a space, but with no comma or space at the
     * end of the String.
     *
     * This method does not change the words array.
     * @param words a String array with multiple words separated by a comma and
     *              then a space
     * @return a String containing the smallest unique words from the array
     * @throws IllegalArgumentException with the message, "Null words", if the
     * words array is null.
     * @throws IllegalArgumentException with the message, "Zero length", if the
     * length of the words array is 0.
     * @throws IllegalArgumentException with the message, "Invalid words", if
     * any word is null, has a length of 0, or contains a non-letter character
     */
    public static String getLargestWords(String[] words) {
        words = getWords(words);
        if(words == null) {
            throw new IllegalArgumentException("Null words");
        }

        if(words.length == NUMBER_ZERO) {
            throw new IllegalArgumentException("Zero length");
        }

        for (int i = NUMBER_ZERO; i < words.length; i++) {
            String word = words[i];
            if (word == null || word.length() == NUMBER_ZERO) {
                throw new IllegalArgumentException("Invalid words");
            }
            for (int j = NUMBER_ZERO; j < word.length(); j++) {
                if (!Character.isLetter(word.charAt(j))) {
                    throw new IllegalArgumentException("Invalid words");
                }
            }
        }

        String[] temp = new String[words.length];
        int index = NUMBER_ZERO;
        boolean unique = true;
        
        for(int i = NUMBER_ZERO; i < words.length; i++){
            String word = words[i];
            unique = true;
            for(int x = NUMBER_ZERO; x < temp.length; x++) {
                if(word.equals(temp[x])) {
                    unique = false;
                    break;
                }
            }
        
            if(unique){
                temp[index] = words[i];
                index++;
            }
        }
        
        int count = NUMBER_ZERO;
        for(int i = NUMBER_ZERO; i < words.length; i++) {
            if(temp[i] == null){
                break;
            }
            count++;
        }

        String[] holder = new String[count];

        for(int i = NUMBER_ZERO; i < holder.length; i++){
            holder[i] = temp[i];
        }

        String largestWords = "";
        int j = NUMBER_ZERO;
        int maxLength = NUMBER_ZERO;
        for(int i = NUMBER_ZERO; i < holder.length; i++) {
            j = holder[i].length();
            if(j > maxLength){
                maxLength = j;
            }
        }

        for(int i = NUMBER_ZERO; i < holder.length; i++) {
            if(holder[i].length() == maxLength) {
                largestWords += holder[i] + ", ";
            }
        }

        int lf = largestWords.length() - NUMBER_TWO;
        String f = largestWords.substring(NUMBER_ZERO, lf);
        return f;
    }

    /**
     * Returns average length of the words in the "words" array. 
     * The returned value is not rounded and does not change the array.
     * @param words a String array
     * @return a double value of the average length of the words in the
     * array
     * @throws IllegalArgumentException with the message, "Null words", if the
     * words array is null.
     * @throws IllegalArgumentException with the message, "Zero length", if the
     * length of the words array is 0.
     * @throws IllegalArgumentException with the message, "Invalid words", if
     * any word is null, has a length of 0, or contains a non-letter character
     */
    public static double getAverageWordLength(String[] words) {
        words = getWords(words);
        if(words == null) {
            throw new IllegalArgumentException("Null words");
        }

        if(words.length == NUMBER_ZERO) {
            throw new IllegalArgumentException("Zero length");
        }

        double total = (double) NUMBER_ZERO;
        for(int i = NUMBER_ZERO; i < words.length; i++){
            total += words[i].length();
        }
        double arrayLength = words.length;
        return total / arrayLength;
    }

    /**
     * Returns a "letter tally" array, an integer array with 26 elements such that
     * element 0 contains the number of a/A's in the words in the given array
     * element 1 contains the number of b/B's in the words in the given array
     * and so on.
     * 
     * This method does not change the words array
     * 
     * @param words a String array
     * @return a double value of the average length of the words in the
     * array
     * @throws IllegalArgumentException with the message, "Null words", if the
     * words array is null.
     * @throws IllegalArgumentException with the message, "Zero length", if the
     * length of the words array is 0.
     * @throws IllegalArgumentException with the message, "Invalid words", if
     * any word is null, has a length of 0, or contains a non-letter character
     */
    public static int[] getLetterTally(String[] words) {
        words = getWords(words); 
        int[] counter = new int[NUMBER_OF_ALPHABETS];
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                for(int x = 0; x < ALPHABETS.length; x++) {
                    char input = words[i].charAt(j);
                    input = Character.toLowerCase(input);
                    if(input == ALPHABETS[x]) {
                        counter[x] += 1;
                    }
                }
            }
        }
        return counter;
    }
}
