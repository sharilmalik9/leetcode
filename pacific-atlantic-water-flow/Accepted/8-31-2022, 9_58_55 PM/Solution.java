// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {
   public List<List<Integer>> pacificAtlantic(int[][] heights) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	Boolean[][] dp1 = new Boolean[heights.length][heights[0].length];
	Boolean[][] dp2 = new Boolean[heights.length][heights[0].length];
      
	for(int i = 0;i<heights.length;i++)
        
	{
		canReachTo(heights, i, 0, heights[i][0], dp1);
		canReachTo(heights, i, heights[0].length-1, heights[i][heights[0].length-1], dp2);
	}
       
	for(int i = 0;i<heights[0].length;i++)
	{
		canReachTo(heights, 0, i, heights[0][i], dp1);
		canReachTo(heights, heights.length-1, i, heights[heights.length-1][i], dp2);
		
	}
      
	for(int i = 0;i<heights.length;i++)
	{
		for(int j = 0;j<heights[i].length;j++)
		{
			if(dp1[i][j] != null && dp2[i][j] != null && dp1[i][j]== true && dp2[i][j]==true)
			{
				ArrayList<Integer> res = new ArrayList<Integer>();
				res.add(i);
				res.add(j);
				result.add(res);
			}
		}
	}
 	return result;  
    }

public void canReachTo(int[][] heights, int i, int j,int prev, Boolean[][] dp1 )
{
	if(i<0||j<0)
		return;
	if(i>=heights.length||j>= heights[0].length)
		return;
	if(dp1[i][j] != null && dp1[i][j])
		return;
	
	if(prev<= heights[i][j])
	{
		dp1[i][j] = true;
		canReachTo(heights,i+1,j,heights[i][j],dp1);
		canReachTo(heights,i-1,j,heights[i][j],dp1);
		canReachTo(heights,i,j+1,heights[i][j],dp1);
		canReachTo(heights,i,j-1,heights[i][j],dp1);
			 
	}
    else
	    dp1[i][j] = false;
}
}