import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<String> ransomList = new LinkedList<>(Arrays.asList(ransomNote.split("")));
        List<String> magazineList = new LinkedList<>(Arrays.asList(magazine.split("")));

        for(String ransom: ransomList){
            System.out.println(ransom);
            int ransomIdx = magazineList.indexOf(ransom);
            if(ransomIdx>=0){
                magazineList.remove(ransomIdx);
            }else{
                return false;
            }
        }
        return true;
    }
}