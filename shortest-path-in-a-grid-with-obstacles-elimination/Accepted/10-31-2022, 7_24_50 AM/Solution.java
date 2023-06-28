// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination

class Solution 
{
	int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	int[][] visited;
	public int shortestPath(int[][] grid, int k)
	{
		int m = grid.length;
		int n = grid[0].length;
		visited = new int[m][n];

		for(int[] i : visited)
			Arrays.fill(i, Integer.MAX_VALUE);

		int ans = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0,0});

		while(!queue.isEmpty())
		{
			int size = queue.size();
			while(size-- > 0)
			{
				int[] curr = queue.poll();
				if(curr[0] == m-1 && curr[1] == n-1)
					return ans;

				for(int[] dir : dirs)
				{
					int newX = curr[0] + dir[0];
					int newY = curr[1] + dir[1];

					if(newX < 0 || newY < 0 || newX >= m || newY >= n)
						continue;

					int newK = curr[2] + grid[newX][newY];
					if(newK > k)
						continue;

					if(visited[newX][newY] <= newK)     // continue if there is any better solution
						continue;

					visited[newX][newY] = newK;
					queue.add(new int[] {newX, newY, newK});
				 }
			}
			ans++;
		}
		return -1;
	}
}