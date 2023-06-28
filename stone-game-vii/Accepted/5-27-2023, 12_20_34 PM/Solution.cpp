// https://leetcode.com/problems/stone-game-vii

class Solution {
public:
   int dp[1001][1001][2] = {};
    
    /*
    * sumOfStonesBetween contains all the sub-arrays sums, thus speeding up the computation of the score's difference
    */
    int sumOfStonesBetween[1001][1001] = {};
    
    int game(int leftmostStoneIdx, int rightmostStoneIdx, int turn)
    {
        /*
        *   There's no remaining stone, exit condition
        */
        if(leftmostStoneIdx >= rightmostStoneIdx) return 0;
        
        /*
        *   If we have already happened to compute the result for the same situation, we return the previously computed result.
        */
        if(dp[leftmostStoneIdx][rightmostStoneIdx][turn]!=0) 
            return dp[leftmostStoneIdx][rightmostStoneIdx][turn];
        
        //Alice's turn
        if(turn==0)
        {
            /*
            *   When Alice picks the rightmost stone, the final score difference increases by the sum of the remaining stones
            *   (sumOfStonesBetween[leftmostStoneIdx][rightmostStoneIdx-1])
            */
            int scoreDiffPickingRightmostStone = 
                sumOfStonesBetween[leftmostStoneIdx][rightmostStoneIdx-1] + 
                game(leftmostStoneIdx, rightmostStoneIdx-1, 1);
            /*
            *   When Alice picks the leftmost stone, the final score difference increases by the sum of the remaining stones
            *   (sumOfStonesBetween[leftmostStoneIdx+1][rightmostStoneIdx])
            */
            int scoreDiffPickingLeftmostStone = 
                sumOfStonesBetween[leftmostStoneIdx+1][rightmostStoneIdx] + 
                game(leftmostStoneIdx+1, rightmostStoneIdx, 1);
            
            /*
            *   Once computed the two different score's differences that Alice can get based on the stone she picked,
            *   she will keep only the result maximixing this difference.
            *   We store the solution in dp, so that we can reause it in case we come across the same situation later on.
            */
            dp[leftmostStoneIdx][rightmostStoneIdx][0] = max(scoreDiffPickingRightmostStone, scoreDiffPickingLeftmostStone);
            
            return  dp[leftmostStoneIdx][rightmostStoneIdx][0];
        }
        //Bob's turn
        else
        {
            /*
            *   When Bob picks the rightmost stone, the final score difference decreses by the sum of the remaining stones
            *   (sumOfStonesBetween[leftmostStoneIdx][rightmostStoneIdx-1])
            */
            int scoreDiffPickingRightmostStone = 
                game(leftmostStoneIdx, rightmostStoneIdx-1, 0) - 
                sumOfStonesBetween[leftmostStoneIdx][rightmostStoneIdx-1];
            
            /*
            *   When Bob picks the leftmost stone, the final score difference decreases by the sum of the remaining stones
            *   (sumOfStonesBetween[leftmostStoneIdx+1][rightmostStoneIdx])
            */
            int scoreDiffPickingLeftmostStone = 
                game(leftmostStoneIdx+1, rightmostStoneIdx, 0) - 
                sumOfStonesBetween[leftmostStoneIdx+1][rightmostStoneIdx];
            
            /*
            *   Once computed the two different score's differences that Bob can get based on the stone he picked,
            *   he will keep only the result minimizing this difference.
            *   We store the solution in dp, so that we can reause it in case we come across the same situation later on.
            */
            dp[leftmostStoneIdx][rightmostStoneIdx][1] = min(scoreDiffPickingRightmostStone, scoreDiffPickingLeftmostStone);
            
            return  dp[leftmostStoneIdx][rightmostStoneIdx][1];
        }
        
    }
    
    int stoneGameVII(vector<int>& stones) 
    {
        /*
        * Fill up the matrix sumOfStonesBetween[start][end] with the sums of the stones between 'start' and 'end'.
        * This way we won't need to go through each remaining stone to compute the total sum every single time a player picks one.
        * EXAMPLE: input [5,3,1,4,2]
        * sumOfStonesBetween[][]:
        *
        *    rightmostStone |   5   |   3   |   1   |   4   |   2   |
        * leftmostStone     |
        *           5       |   5   |   8   |   9   |   13  |   15  |
        *           3       |       |   3   |   4   |   8   |   10  |
        *           1       |       |       |   1   |   5   |   7   |
        *           4       |       |       |       |   4   |   6   |
        *           2       |       |       |       |       |   2   |
        *
        *   sumOfStonesBetween[1][3] = 8, meaning that given the input [5,3,1,4,2], considering the subarray between indexes 0 and 3 -
        *   [3,1,4] - the total sum of these stones is 8.
        */
        for(int leftmostStoneIdx=0; leftmostStoneIdx<stones.size(); ++leftmostStoneIdx)
        {
            for(int rightmostStoneIdx=leftmostStoneIdx; rightmostStoneIdx<stones.size(); ++rightmostStoneIdx)
            {
                /*
                * sumOfStonesBetween[IDX][IDX] = stones[IDX]; 
                */
                if(leftmostStoneIdx == rightmostStoneIdx)
                    sumOfStonesBetween[leftmostStoneIdx][rightmostStoneIdx] = stones[leftmostStoneIdx];
                /*
                * sumOfStonesBetween[A][B] = sumOfStonesBetween[A][B-1] + stones[B]
                */
                else
                    sumOfStonesBetween[leftmostStoneIdx][rightmostStoneIdx] = 
                        sumOfStonesBetween[leftmostStoneIdx][rightmostStoneIdx-1] +
                        stones[rightmostStoneIdx];
            }
        }
        
        return game(0, stones.size()-1, 0);
    }
};