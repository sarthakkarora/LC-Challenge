import java.util.*;

public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rows = new HashMap<>();
        Map<Integer, TreeSet<Integer>> cols = new HashMap<>();
        
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            rows.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            cols.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }
        
        int count = 0;
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            
            boolean hasLeft = rows.get(x).lower(y) != null;
            boolean hasRight = rows.get(x).higher(y) != null;
            boolean hasAbove = cols.get(y).lower(x) != null;
            boolean hasBelow = cols.get(y).higher(x) != null;
            
            if (hasLeft && hasRight && hasAbove && hasBelow) {
                count++;
            }
        }
        
        return count;
    }
}
