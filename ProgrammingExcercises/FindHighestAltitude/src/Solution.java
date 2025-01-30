class Solution {
    public int largestAltitude(int[] gain) {

        int tempAltitude = 0;
        int maxAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            tempAltitude = tempAltitude + gain[i];
            maxAltitude = Math.max(tempAltitude, maxAltitude);
        }
        return maxAltitude;
    }
}