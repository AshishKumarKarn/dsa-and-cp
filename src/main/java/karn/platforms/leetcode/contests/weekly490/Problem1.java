package karn.platforms.leetcode.contests.weekly490;

//https://leetcode.com/problems/find-the-score-difference-in-a-game/
public class Problem1 {
    public int scoreDifference(int[] nums) {
        boolean act1 = true;
        boolean act2 = false;
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                act1 = !act1;
                act2 = !act2;
            }
            if (((i + 1) % 6) == 0) {
                act1 = !act1;
                act2 = !act2;
            }
            if (act1) {
                score1 += nums[i];
            } else {
                score2 += nums[i];
            }
        }
        return (score1 - score2);

    }
}