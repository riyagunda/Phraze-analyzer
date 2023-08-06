import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Program to test PhraseAnalyzer methods
 * @author Suzanne Balik
 * @author Michelle Glatz 
 * @author Riya Gunda
 */
public class PhraseAnalyzerTest {
    
    /** Delta value used for average length tests */
    public static final double DELTA = 0.00001;


    /**
     * Test the isValidPhrase method using only lowercase letters
     */
    @Test
    public void testIsValidPhraseOnlyLowerCaseLetters() {
        String[] phrase = {"apple", "ball", "cat"};
        assertTrue(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"apple\", \"ball\", \"cat\"})");
        String[] phraseCopy = {"apple", "ball", "cat"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    }

    /**
     * Test the isValidPhrase method using mixed case letters
     */
    @Test
    public void testIsValidPhraseOnlyLettersMixedCase() {
        String[] phrase = {"Apple", "Ball", "Cat"};
        assertTrue(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"Apple\", \"Ball\", \"Cat\"})");
        String[] phraseCopy = {"Apple", "Ball", "Cat"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    }    

    /**
     * Test the isValidPhrase method using non-word groups of letters
     */
    @Test
    public void testIsValidPhraseNonWordLetters() {
        String[] phrase = {"x", "ahl", "wccqxom"};
        assertTrue(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"x\", \"ahl\", \"wccqxom\"})");
        String[] phraseCopy = {"x", "ahl", "wccqxom"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    } 
    
    /**
     * Test the isValidPhrase method with valid punctuations
     */
    @Test
    public void testIsValidPhraseWithValidPunctuation() {
        String[] phrase = {"apple,", "ball;", "cat.", "happy!"};
        assertTrue(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"apple,\", \"ball;\", \"cat.\", \"happy!\"})");
        String[] phraseCopy = {"apple,", "ball;", "cat.", "happy!"};
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    }  

     /**
     * Test the isValidPhrase method using multiple punctuation values
     */
    @Test
    public void testIsValidPhraseWordWithMultiplePunctuation() {
        String[] phrase = {"Apple;,", "Ball", "Cat"};
        assertFalse(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"Apple;,\", \"Ball\", \"Cat\"})");
        String[] phraseCopy = {"Apple;,", "Ball", "Cat"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    } 

    /**
     * Test the isValidPhrase method using a word of 0 length
     */
    @Test
    public void testIsValidPhraseZeroLengthWord() {
        String[] phrase = {"", "Ball", "Cat"};
        assertFalse(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"\", \"Ball\", \"Cat\"})");
        String[] phraseCopy = {"", "Ball", "Cat"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    } 

    /**
     * Test the isValidPhrase method using a word of 0 length with a punctuation only
     */
    @Test
    public void testIsValidPhraseZeroLengthWordWithPunctuation() {
        String[] phrase = {"apple", ",", "Cat"};
        assertFalse(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"apple\", \",\", \"Cat\"})");
        String[] phraseCopy = {"apple", ",", "Cat"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    } 

    /**
     * Test the isValidPhrase method using a word that is null in the array
     */
    @Test
    public void testIsValidPhraseNullWord() {
        String[] phrase = {"apple", null, "Cat"};
        assertFalse(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"apple\", null, \"Cat\"})");
        String[] phraseCopy = {"apple", null, "Cat"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    } 
    
    /**
     * Test the isValidPhrase method using a null phrase
     */
    @Test
    public void testIsValidPhraseNull() {
        assertFalse(PhraseAnalyzer.isValidPhrase(null), 
                   "PhraseAnalyzer.isValidPhrase(null)");
    }

    /**
     * Test the isValidPhrase method using an empty phrase
     */
    @Test
    public void testIsValidPhraseEmpty() {
        String[] phrase = {};
        assertFalse(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({})");
        String[] phraseCopy = {};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");                  
    }  

    /**
     * Test the isValidPhrase method using numbers
     */                 
    @Test
    public void testIsValidPhraseNumbers() {
        String[] phrase = {"x", "5", "wccqxom"};
        assertFalse(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"x\", \"5\", \"wccqxom\"})");
        String[] phraseCopy = {"x", "5", "wccqxom"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    } 

    /**
     * Test the isValidPhrase method using a question mark as a 
     */
    @Test
    public void testIsValidPhraseQuestionMarkPunctuation() {
        String[] phrase = {"x", "?", "wccqxom"};
        assertFalse(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"x\", \"?\", \"wccqxom\"})");
        String[] phraseCopy = {"x", "?", "wccqxom"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    } 

    /**
     * Test the isValidPhrase method using only upper case letters
     */
    @Test
    public void testIsValidPhraseUpperCaseWords() {
        String[] phrase = {"HELLO", "HAVE", "A", "GREAT", "DAY"};
        assertTrue(PhraseAnalyzer.isValidPhrase(phrase), 
                   "PhraseAnalyzer.isValidPhrase({\"HELLO\", \"HAVE\", \"A\", \"GREAT\", \"DAY\"})"
                   );
        String[] phraseCopy = {"HELLO", "HAVE", "A", "GREAT", "DAY"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");
    }  

    /**
     * Test the getWords method using words with punctuations only
     */
    @Test
    public void testGetWordsWithPunctuation() {
        String[] phrase = {"apple!", "ball,", "cat;", "done."};
        String[] expected = {"apple", "ball", "cat", "done"};
        assertArrayEquals(expected, PhraseAnalyzer.getWords(phrase), 
                          "PhraseAnalyzer.getWords({\"apple!\", \"ball,\", \"cat;\". \"done.\"})");
        String[] phraseCopy = {"apple!", "ball,", "cat;", "done."};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");                         
    }
    
    /**
     * Test the getWords method using words with no punctuation
     */
    @Test
    public void testGetWordsNoPunctuation() {
        String[] phrase = {"APPLE", "BALL", "CAT"};
        String[] expected = {"APPLE", "BALL", "CAT"};
        assertArrayEquals(expected, PhraseAnalyzer.getWords(phrase), 
                          "PhraseAnalyzer.getWords({\"APPLE\", \"BALL\", \"CAT\"})");
        String[] phraseCopy = {"APPLE", "BALL", "CAT"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");                            
    }
    
    /**
     * Test the getWords method using letters that do not form words
     */
    @Test
    public void testGetWordsNonWordLetters() {
        String[] phrase = {"x", "ahl", "wccqxom"};
        String[] expected = {"x", "ahl", "wccqxom"};
        assertArrayEquals(expected, PhraseAnalyzer.getWords(phrase), 
                          "PhraseAnalyzer.getWords({\"x\", \"ahl\", \"wccqxom\"})");
        String[] phraseCopy = {"x", "ahl", "wccqxom"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");                           
    } 

    /**
     * Test the getWords method using words of mixed case
     */
    @Test
    public void testGetWordsMixedCaseWords() {
        String[] phrase = {"hEy", "its", "RiYa"};
        String[] expected = {"hEy", "its", "RiYa"};
        assertArrayEquals(expected, PhraseAnalyzer.getWords(phrase), 
                          "PhraseAnalyzer.getWords({\"hEy\", \"its\", \"RiYa\"})");
        String[] phraseCopy = {"hEy", "its", "RiYa"};
        // Test that method does not modify array
        assertArrayEquals(phraseCopy, phrase, 
                          "Check that array not modified");                           
    } 

    /**
     * Test the getSmallestWords method with only one small word
     */
    @Test
    public void testGetSmallestWordsOne() {
        String[] words = {"apple", "ball", "cat"};
        String expected = "cat";
        assertEquals(expected, PhraseAnalyzer.getSmallestWords(words),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"ball\", \"cat\"})");
        String[] wordsCopy = {"apple", "ball", "cat"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                     
    }
    
    /**
     * Test the getSmallestWords method with the same small words 
     * with different cases
     */
    @Test
    public void testGetSmallestWordsSameWordDifferentCase() {
        String[] words = {"apple", "ball", "cat", "CaT"};
        String expected = "cat, CaT";
        assertEquals(expected, PhraseAnalyzer.getSmallestWords(words),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"ball\", \"cat\", \"CaT\"})");
        String[] wordsCopy = {"apple", "ball", "cat", "CaT"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                      
    } 

    /**
     * Test the getSmallestWords method with the multiple of the same
     * small words in the array
     */
    @Test
    public void testGetSmallestWordsMultipleSameWord() {
        String[] words = {"apple", "ball", "cat", "cat"};
        String expected = "cat";
        assertEquals(expected, PhraseAnalyzer.getSmallestWords(words),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"ball\", \"cat\", \"cat\"})");
        String[] wordsCopy = {"apple", "ball", "cat", "cat"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");  
        
        // Checking that using String equals method rather than ==
        String[] words2 = {"apple", "ball", "cat", new String("cat")};
        assertEquals(expected, PhraseAnalyzer.getSmallestWords(words2),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"ball\", \"cat\", \"cat\"})");
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words2, 
                          "Check that array not modified");                      
    } 

    /**
     * Test the getSmallestWords method with different small words 
     * of the same size
     */
    @Test
    public void testGetSmallestWordsDifferentSmallWords() {
        String[] words = {"apple", "ball", "bat", "cat"};
        String expected = "bat, cat";
        assertEquals(expected, PhraseAnalyzer.getSmallestWords(words),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"ball\", \"bat\", \"cat\"})");
        String[] wordsCopy = {"apple", "ball", "bat", "cat"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");  
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                      
    }   

    /**
     * Test the getLargestWords method with only one large word
     */
    @Test
    public void testGetLargestWordsOne() {
        String[] words = {"apple", "ball", "cat"};
        String expected = "apple";
        assertEquals(expected, PhraseAnalyzer.getLargestWords(words),
                     "PhraseAnalyzer.getLargestWords({\"apple\", \"ball\", \"cat\"})");
        String[] wordsCopy = {"apple", "ball", "cat"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                      
    }

    /**
     * Test the getLargestWords method with multiple large words
     */
    @Test
    public void testGetLargestWordsMultiple() {
        String[] words = {"apple", "kitty", "aaa"};
        String expected = "apple, kitty";
        assertEquals(expected, PhraseAnalyzer.getLargestWords(words),
                     "PhraseAnalyzer.getLargestWords({\"apple\", \"kitty\", \"aaa\"})");
        String[] wordsCopy = {"apple", "kitty", "aaa"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                      
    } 

    /**
     * Test the getLargestWords method with multiple of the large
     * words in the array
     */
    @Test
    public void testGetLargestWordsMultipleSameWord() {
        String[] words = {"apple", "ball", "cat", "apple"};
        String expected = "apple";
        assertEquals(expected, PhraseAnalyzer.getLargestWords(words),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"ball\", \"cat\", \"apple\"})");
        String[] wordsCopy = {"apple", "ball", "cat", "apple"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");   
        
        // Checking that using String equals method rather than ==
        String[] words2 = {new String("apple"), "ball", "cat", "apple"};
        assertEquals(expected, PhraseAnalyzer.getLargestWords(words2),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"ball\", \"cat\", \"apple\"})");
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words2, 
                          "Check that array not modified");                       
    } 

    /**
     * Test the getLargestWords method with the same large word
     * in a different case
     */
    @Test
    public void testGetLargestWordsSameWordDifferentCase() {
        String[] words = {"apple", "Apple", "cat", "food"};
        String expected = "apple, Apple";
        assertEquals(expected, PhraseAnalyzer.getLargestWords(words),
                     "PhraseAnalyzer.getSmallestWords({\"apple\", \"Apple\", \"cat\", \"food\"})");
        String[] wordsCopy = {"apple", "Apple", "cat", "food"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                      
    }
    
    /**
     * Test the getAverageLength method with words of different lengths
     */
    @Test
    public void testGetAverageWordLengthDifferentLengths() {
        String[] words = {"apple", "ball", "cat"};
        assertEquals(4.00000, PhraseAnalyzer.getAverageWordLength(words), DELTA,
                     "PhraseAnalyzer.getAverageWordLength({\"apple\", \"ball\", \"cat\"})");
                     
        String[] wordsCopy = {"apple", "ball", "cat"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                       
    }
     
    /**
     * Test the getAverageLength method with words that would
     * produce a non-integer average length value
     */
    @Test
    public void testGetAverageWordLengthNotInteger() {
        String[] words = {"apple", "cat", "XY", "kitty", "dog", "eight", "yes"};
        assertEquals(3.71429, PhraseAnalyzer.getAverageWordLength(words), DELTA, 
                     "PhraseAnalyzer.getAverageWordLength(" + 
                     "{\"apple\",\"cat\",\"XY\",\"kitty\",\"dog\",\"eight\", \"yes\"})");
        String[] wordsCopy = {"apple", "cat", "XY", "kitty", "dog", "eight", "yes"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                       
    }    
    
    /**
     * Test the getAverageLength method using only one word
     */
    @Test
    public void testGetAverageWordLengthOneWord() {
        String[] words = {"onlyone"};
        assertEquals(7.00000, PhraseAnalyzer.getAverageWordLength(words), DELTA, 
                     "PhraseAnalyzer.getAverageWordLength({\"onlyone\"})");
        String[] wordsCopy = {"onlyone"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                       
    }

    /**
     * Test the getAverageLength method with different words of 
     * the same length
     */
    @Test
    public void testGetAverageWordLengthSameLengthDifferentWords() {
        String[] words = {"have","soup","cold"};
        assertEquals(4.00000, PhraseAnalyzer.getAverageWordLength(words), DELTA, 
                     "PhraseAnalyzer.getAverageWordLength({\"have\",\"soup\",\"cold\"})");
        String[] wordsCopy = {"have","soup","cold"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                       
    }
    
    /**
     * Test the getLetterTally method with words in lower case
     */
    @Test
    public void testGetLetterTallyAllLowerCase() {
        String[] words = {"apple", "ball", "cat"};
        //                a, b, c, d, e, f, g, h, i, j, k, l, m,
        int[] expected = {3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 3, 0,
        //                n, o, p, q, r, s, t, u, v, w, x, y, z
                          0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, PhraseAnalyzer.getLetterTally(words),
                          "PhraseAnalyzer.getLetterTally({\"apple\", \"ball\", \"cat\"})");
        String[] wordsCopy = {"apple", "ball", "cat"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                            
    }    
    
    /**
     * Test the getLetterTally method with words in mixed case
     */
    @Test
    public void testGetLetterTallyMixedCase() {
        String[] words = {"ApPlE", "BaLL", "Cat"};
        //                a, b, c, d, e, f, g, h, i, j, k, l, m,
        int[] expected = {3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 3, 0,
        //                n, o, p, q, r, s, t, u, v, w, x, y, z
                          0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, PhraseAnalyzer.getLetterTally(words),
                          "PhraseAnalyzer.getLetterTally({\"ApPlE\", \"BaLL\", \"Cat\"})");
        String[] wordsCopy = {"ApPlE", "BaLL", "Cat"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                            
    }  

    /**
     * Test the getLetterTally method using an array with all
     * the letters in the alphabet
     */
    @Test
    public void testGetLetterTallyFullAlphabet() {
        String[] words = {"abcdefghijkl", "mnopqrstuvwxyz"};
        //                a, b, c, d, e, f, g, h, i, j, k, l, m,
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        //                n, o, p, q, r, s, t, u, v, w, x, y, z
                          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expected, PhraseAnalyzer.getLetterTally(words),
                          "PhraseAnalyzer.getLetterTally({\"abcdefghijkl\", \"mnopqrstuvwxyz\"})");
        String[] wordsCopy = {"abcdefghijkl", "mnopqrstuvwxyz"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                            
    } 

    /**
     * Test the getLetterTally method using capital lettered words
     */
    @Test
    public void testGetLetterTallyCapitalLetters() {
        String[] words = {"APPLE", "BALL", "CAT"};
        //                a, b, c, d, e, f, g, h, i, j, k, l, m,
        int[] expected = {3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 3, 0,
        //                n, o, p, q, r, s, t, u, v, w, x, y, z
                          0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, PhraseAnalyzer.getLetterTally(words),
                          "PhraseAnalyzer.getLetterTally({\"APPLE\", \"BALL\", \"CAT\"})");
        String[] wordsCopy = {"APPLE", "BALL", "CAT"};
        // Test that method does not modify array
        assertArrayEquals(wordsCopy, words, 
                          "Check that array not modified");                            
    }   
        

    /**
     * Test the PhraseAnalyzer methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
                     
        String[] phrase = {};       
                      
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getWords(null),
                                 "PhraseAnalyzer.getWords(null)");
        assertEquals("Invalid phrase", exception.getMessage(),
                     "Testing PhraseAnalyzer.getWords(null) - " +
                     "exception message when phrase is null");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getWords(phrase),
                                 "PhraseAnalyzer.getWords(phrase)");
        assertEquals("Invalid phrase", exception.getMessage(),
                     "Testing PhraseAnalyzer.getWords(phrase) - " +
                     "exception message when phrase has zero length");
                     
        String[] invalidWord = {"abc12"};
        String[] nullWord = {null};
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getWords(invalidWord),
                                 "PhraseAnalyzer.getWords({\"abc12\"})");
        assertEquals("Invalid phrase", exception.getMessage(),
                     "Testing PhraseAnalyzer.getWords({\"abc12\"}) - " +
                     "exception message when phrase is invalid");
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getWords(nullWord),
                                 "PhraseAnalyzer.getWords({null})");
        assertEquals("Invalid phrase", exception.getMessage(),
                     "Testing PhraseAnalyzer.getWords({null}) - " +
                     "exception message when phrase contains null word");                    
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getSmallestWords(null),
                                 "PhraseAnalyzer.getSmallestWords(null)");
        assertEquals("Null words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getSmallestWords(words) - " +
                     "exception message when words is null");
        
        String[] words = {};
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getSmallestWords(words),
                                 "PhraseAnalyzer.getSmallestWords({})");
        assertEquals("Zero length", exception.getMessage(),
                     "Testing PhraseAnalyzer.getSmallestWords(words) - " +
                     "exception message when words has zero length");
                     
        String[] words2 = {""};
        String[] words3 = {"ac2"};

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getSmallestWords(words2),
                                 "PhraseAnalyzer.getSmallestWords({\"\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getSmallestWords({\"\"}) - " +
                     "exception message when a word has zero length"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getSmallestWords(words3),
                                 "PhraseAnalyzer.getSmallestWords({\"ac2\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getSmallestWords({\"ac2\"}) - " +
                     "exception message when a word contains a number"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getSmallestWords(nullWord),
                                 "PhraseAnalyzer.getSmallestWords({null})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getSmallestWords({null}) - " +
                     "exception message when a word is null");                       
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLargestWords(null),
                                 "PhraseAnalyzer.getLargestWords(null)");
        assertEquals("Null words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLargestWords(null) - " +
                     "exception message when words is null");
        
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLargestWords(words),
                                 "PhraseAnalyzer.getLargestWords({})");
        assertEquals("Zero length", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLargestWords(words) - " +
                     "exception message when words has zero length");
                     

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLargestWords(words2),
                                 "PhraseAnalyzer.getLargestWords({\"\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLargestWords({\"\"}) - " +
                     "exception message when a word has zero length"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getSmallestWords(words3),
                                 "PhraseAnalyzer.getLargestWords({\"ac2\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLargestWords({\"ac2\"}) - " +
                     "exception message when a word contains a number"); 


        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLargestWords(nullWord),
                                 "PhraseAnalyzer.getLargestWords({null})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLargestWords({null}) - " +
                     "exception message when a word is null");                     
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getAverageWordLength(null),
                                 "PhraseAnalyzer.getAverageWordLength(null)");
        assertEquals("Null words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getAverageWordLength(words) - " +
                     "exception message when words is null");
        
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getAverageWordLength(words),
                                 "PhraseAnalyzer.getAverageWordLength({})");
        assertEquals("Zero length", exception.getMessage(),
                     "Testing PhraseAnalyzer.getAverageWordLength(words) - " +
                     "exception message when words has zero length");
                    

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getAverageWordLength(words2),
                                 "PhraseAnalyzer.getAverageWordLength({\"\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getAverageWordLength({\"\"}) - " +
                     "exception message when when a word has zero length"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getAverageWordLength(words3),
                                 "PhraseAnalyzer.getAverageWordLength({\"ac2\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getAverageWordLength({\"ac2\"}) - " +
                     "exception message when a word contains a number"); 


        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getAverageWordLength(nullWord),
                                 "PhraseAnalyzer.getAverageWordLength({null})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getAverageWordLength({null}) - " +
                     "exception message when a word is null");                      

                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLetterTally(null),
                                 "PhraseAnalyzer.getLetterTally(null)");
        assertEquals("Null words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLetterTally(words) - " +
                     "exception message when words is null");                     
        
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLetterTally(words),
                                 "PhraseAnalyzer.getLetterTally({})");
        assertEquals("Zero length", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLetterTally(words) - " +
                     "exception message when words has zero length");
                     

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLetterTally(words2),
                                 "PhraseAnalyzer.getLetterTally({\"\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.LetterTally({\"\"}) - " +
                     "exception message when when a word has zero length"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLetterTally(words3),
                                 "PhraseAnalyzer.getLetterTally({\"ac2\"})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLetterTally({\"ac2\"}) - " +
                     "exception message when a word contains a number"); 


        exception = assertThrows(IllegalArgumentException.class,
            () -> PhraseAnalyzer.getLetterTally(nullWord),
                                 "PhraseAnalyzer.getLetterTally({null})");
        assertEquals("Invalid words", exception.getMessage(),
                     "Testing PhraseAnalyzer.getLetterTally({null}) - " +
                     "exception message when a word is null");                     
                     
    }
}