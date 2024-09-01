package DSA.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break
public class L139WordBreak {

    public boolean wordBreak(String str, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = str.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (wordSet.contains(str.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    //TC: O(N^2)
    //SC: O(N)
}
