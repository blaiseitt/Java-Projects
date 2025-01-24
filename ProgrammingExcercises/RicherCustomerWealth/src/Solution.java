class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int[] acc: accounts){
            int currentAccWealth = 0;
            for(int m: acc){
                currentAccWealth += m;
            }
            if(currentAccWealth>maxWealth) maxWealth=currentAccWealth;
        }
        return 1;
    }
}
