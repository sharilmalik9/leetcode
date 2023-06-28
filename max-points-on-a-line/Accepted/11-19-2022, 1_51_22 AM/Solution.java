// https://leetcode.com/problems/max-points-on-a-line

class Solution {
    public int maxPoints(int[][] p) {
    // If 0, 1, or 2 points, then there are that many points on a line.
    int n = p.length;
    if (n<= 2)  
        return p.length;
    // Else 3 or more points were passed so we need to test for co-linear triples.
    int maxP = 0;
    // Loop through the passed points to get point1 as first point.
    for (int i = n-1;i>=2;i--) {
        int x1 = p[i][0];
        int y1 = p[i][1];
        // Loop through all points after point1, to get point2.  This will define 
        // a line through point1 and point2.
        for (int j=i-1;j>=1;j--) {
            int x2 = p[j][0] - x1;
            int y2 = p[j][1] - y1;
            int Count = 2;
            // Loop through all points after point2, to get point3.  If point3 is 
            // on the same line as point1 and point2, then count another point on 
            // that same point1:point2 line.
            for (int k=j-1;k>=0;k--)
                if ((p[k][1]-y1)*x2 == (p[k][0]-x1)*y2)
                    Count++;
            maxP = Math.max(maxP, Count);
        }
    }
    return maxP;               
}
}