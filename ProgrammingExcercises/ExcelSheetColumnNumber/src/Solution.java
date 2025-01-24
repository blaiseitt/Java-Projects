class Solution {

    private static int ASCII_A_VALUE = 65-1;
    private static int NUMBER_OF_LETTERS = 26;

    public int titleToNumber(String columnTitle) {

        byte[] asciiValues = columnTitle.getBytes();
        int titleLength = columnTitle.length();
        //TODO develop this solution using Stream maybe
        int columnValue = 0;
        int power = 0;
        for (int i = titleLength-1; i >= 0; i--) {
            columnValue += (asciiValues[i] - ASCII_A_VALUE) * (Math.pow(NUMBER_OF_LETTERS, power));
            power++;
        }

        return columnValue;
    }
}
