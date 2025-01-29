class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int spotsCount = 0;
        int flowerbedLength = flowerbed.length;

        for (int i = 0; i < flowerbedLength - 1; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbedLength > 1) {
                        if (flowerbed[i + 1] == 0) {
                            flowerbed[i] = 1;
                            spotsCount++;
                            i++;
                        }
                    } else {
                        flowerbed[i] = 1;
                        spotsCount++;
                        i++;
                    }
                }
                else {
                    if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        spotsCount++;
                        i++;
                    }
                }
            }
        }

        if (flowerbed[flowerbedLength - 1] == 0) {
            if (flowerbedLength > 1) {
                if (flowerbed[flowerbedLength - 2] == 0) {
                    flowerbed[flowerbedLength - 1] = 1;
                    spotsCount++;
                }
            } else {
                flowerbed[flowerbedLength - 1] = 1;
                spotsCount++;
            }
        }

        return spotsCount >= n;
    }
}