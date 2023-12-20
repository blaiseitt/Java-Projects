class Solution {
    public String longestCommonPrefix(String[] strs) {
        
    	int length = strs.length;
    	
    	int[] commonPrefixes = new int[length-1];
    	
    	if (length > 0) {
    		String first = strs[0];
    		int firstLength = first.length();
        	
        	for (int i = 1; i < strs.length; i++) {
        		//compare strings
        		int j = 0;
        		int currentLength = strs[i].length();
        		while (j < firstLength) {
        			
        			if (j == currentLength) {
        				commonPrefixes[i-1] = j;
        				break;
        			}
        			        			
        			if (strs[i].substring(j, j+1).equals(first.substring(j, j+1))) {
        				j += 1;
        				commonPrefixes[i-1] = j;
        			} else {
        				commonPrefixes[i-1] = j;
        				break;
        			}
        			
        			if (j == currentLength) {
        				commonPrefixes[i-1] = j;
        				break;
        			}
        		}
        		if (j == 0) {
        			break;
        		}
        	}
    	}
    	
    	if (commonPrefixes.length == 0) {
    		return strs[0];
    	} else {
    		return strs[0].substring(0, getMinValue(commonPrefixes));
    	}
    }
    
    private int getMinValue(int[] array) {
    	int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}   
    /*better solution -> use of indexOf
    
	public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs)
            while (s.indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        return prefix;
    }
}
     */
