package check;

/**
 * There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'.
 * You are given a string colors of length n where colors[i] is the color of the ith piece.
 *
 * Alice and Bob are playing a game where they take alternating turns removing pieces from the line.
 * In this game, Alice moves first.
 *
 * Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'.
 * She is not allowed to remove pieces that are colored 'B'.
 * Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'.
 * He is not allowed to remove pieces that are colored 'A'.
 * Alice and Bob cannot remove pieces from the edge of the line.
 * If a player cannot make a move on their turn, that player loses and the other player wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
 *
 * Example 1:
 *
 * Input: colors = "AAABABB"
 * Output: true
 * Explanation:
 * AAABABB -> AABABB
 * Alice moves first.
 * She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.
 *
 * Now it's Bob's turn.
 * Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
 * Thus, Alice wins, so return true.
 * Example 2:
 *
 * Input: colors = "AA"
 * Output: false
 * Explanation:
 * Alice has her turn first.
 * There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
 * Thus, Bob wins, so return false.
 */


public class Solution {
    public static void main(String[] args) {
        //System.out.println(winnerOfGame("ABBBBBBBAAA"));
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }

    private static boolean winnerOfGame(String colors){
        int alice = 0;
        int bob = 0;
        for (int i = 1; i < colors.length()-1; i++) {
            if (colors.charAt(i-1) == 'A' &&
                    colors.charAt(i) == 'A' &&
                    colors.charAt(i+1) == 'A'){
                alice++;
            } else if (colors.charAt(i-1) == 'B' &&
                    colors.charAt(i) == 'B' &&
                    colors.charAt(i+1) == 'B'){
                bob++;
            }
        }
        return alice>bob;
    }



    /*public static boolean winnerOfGame(String colors) {
       boolean isAlice = true;
       while (true){
           char ch = isAlice ? 'A' : 'B';
           int index = getIndex(colors, ch);
           if (index == -1){
               return !isAlice;
           } else {
               colors = removeColor(index, colors);
               isAlice = !isAlice;
           }
       }
    }

    private static String removeColor(int index, String input){
        return input.substring(0, index) + input.substring(index+1);
    }

    private static int getIndex(String input, char ch){
        for (int i = 1; i < input.length()-1; i++) {
            if (input.charAt(i-1) == ch &&
            input.charAt(i) == ch &&
            input.charAt(i+1) == ch){
                return i;
            }
        }
        return -1;
    }*/

}
