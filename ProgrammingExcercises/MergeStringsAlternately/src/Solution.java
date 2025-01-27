class Solution {
    public String mergeAlternately(String word1, String word2) {

        int word1Length = word1.length();
        int word2Length = word2.length();
        int combinedWordsLength = word1Length + word2Length;

        char[] outputArray = new char[combinedWordsLength];


        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int wordPointer = 0;
        int outputPointer = 0;

        while (wordPointer < word1Length || wordPointer < word2Length) {
            if (wordPointer < word1Length) {
                outputArray[outputPointer] = word1Array[wordPointer];
                outputPointer++;
            }

            if (wordPointer < word2Length) {
                outputArray[outputPointer] = word2Array[wordPointer];
                outputPointer++;
            }

            wordPointer++;
        }

        return new String(outputArray);
    }
}