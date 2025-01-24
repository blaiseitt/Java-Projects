import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> rowsStrength = new ArrayList<>();
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            int currentRowStrength = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) currentRowStrength++;
                else {
                    rowsStrength.add(currentRowStrength);
                    break;
                }
                if (currentRowStrength == cols) rowsStrength.add(currentRowStrength);
            }
        }
        int valuePlaceholder = rows + cols + 1;
        int weakestRows[] = new int[k];
        int minIdx;
        int minStrength;

        for (int i = 0; i < k; i++) {
            minStrength = Collections.min(rowsStrength);
            minIdx = rowsStrength.indexOf(minStrength);//rowsStrength.lastIndexOf(minStrength);

            weakestRows[i] = minIdx;
            rowsStrength.set(minIdx, valuePlaceholder);
        }

        return weakestRows;
    }
}
