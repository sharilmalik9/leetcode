// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pas = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList();
        int num1=0, num2=0;
        for(int i=0;i<numRows;i++)
        {
            if(i==0)
            {
                temp.add(i,1);
            }
            else if(i==1)
            {
                temp.add(1);
                temp.add(1);
            }
            else
            {
                for(int j=0; j<i;j++)
                {
                    if(j==0)
                    {
                        temp.add(0,1);
                    }
                    else
                    {
                        num1 = pas.get(i-1).get(j);
                        num2 = pas.get(i-1).get(j-1);
                        temp.add(j,num1+num2);
                    }
                }
                temp.add(1);
            }
            pas.add(new ArrayList(temp));
            temp.clear();
        }
        return pas;
    }
}