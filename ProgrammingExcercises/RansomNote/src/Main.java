public class Main {
    public static void main(String[] args){
        String ransomNote1 = "a";
        String ransomNote2 = "aa";
        String ransomNote3 = "aba";
        String magazine1 = "b";
        String magazine2 = "abc";
        String magazine3 = "acdba";

        Solution solution = new Solution();
        System.out.println(solution.canConstruct(ransomNote1,magazine1));
        System.out.println(solution.canConstruct(ransomNote2,magazine2));
        System.out.println(solution.canConstruct(ransomNote3,magazine3));
    }
}