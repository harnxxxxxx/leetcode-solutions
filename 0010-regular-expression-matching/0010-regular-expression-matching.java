public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Fill first row for patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the rest of the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Safe only if j >= 2
                    if (j >= 2) {
                        char prev = p.charAt(j - 2);

                        // * means zero occurrence of prev
                        dp[i][j] = dp[i][j - 2];

                        // * means one or more occurrence if match
                        if (prev == sc || prev == '.') {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }
        }

        return dp[m][n];
    }

}