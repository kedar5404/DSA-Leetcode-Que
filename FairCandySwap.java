/*
 * Alice and Bob have a different total number of candies. You are given two integer 
 * arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith 
 * box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of 
 * candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the 
exchange, they both have the same total amount of candy. The total amount of candy a 
person has is the sum of the number of candies in each box they have.

Return an integer array answer where answer[0] is the number of candies in the box that 
Alice must exchange, and answer[1] is the number of candies in the box that Bob must 
exchange. If there are multiple answers, you may return any one of them. It is guaranteed 
that at least one answer exists.
 */
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] ans = new int[2];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            count1 = count1 + aliceSizes[i];
        }
        for (int j = 0; j < bobSizes.length; j++) {
            count2 = count2 + bobSizes[j];
        }
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                if (count1 - aliceSizes[i] + bobSizes[j] == count2 - bobSizes[j] + aliceSizes[i]) {
                    ans[0] = aliceSizes[i];
                    ans[1] = bobSizes[j];
                    break;
                }
            }
        }
        return ans;
    }
}

public class FairCandySwap {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] aliceSizes = { 1, 2, 5 };
        int[] bobSizes = { 2, 4 };

        // Get the result
        int[] result = solution.fairCandySwap(aliceSizes, bobSizes);

        // Print the result
        System.out.println("Alice should swap: " + result[0]);
        System.out.println("Bob should swap: " + result[1]);
    }
}