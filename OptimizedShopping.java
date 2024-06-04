
import java.util.*;
public class OptimizedShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] units = {1, 2, 5, 10, 20, 50};
        List<Integer> result = findOptimizedSet(units, target);
        System.out.println("Optimized set: " + result);
        System.out.println("Average units: " + calculateAverage(result));
    }
    public static List<Integer> findOptimizedSet(int[] units, int target) {
        int[] dp = new int[target + 1];
        int[] parent = new int[target + 1];
        Arrays.fill(parent, -1);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < units.length; j++) {
                if (i >= units[j] && dp[i - units[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - units[j]] + 1;
                    parent[i] = j;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int remaining = target;
        while (parent[remaining] != -1) {
            int index = parent[remaining];
            result.add(units[index]);
            remaining -= units[index];
        }
        return result;
    }
    public static double calculateAverage(List<Integer> set) {
        if (set.isEmpty()) return 0.0;
        double sum = 0.0;
        for (int num : set) {
            sum += num;
        }
        return sum / set.size();
    }
}
