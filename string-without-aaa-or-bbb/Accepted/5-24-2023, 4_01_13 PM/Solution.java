// https://leetcode.com/problems/string-without-aaa-or-bbb

class Solution {
    public String strWithout3a3b(int a, int b) {
     String str="";

      while(a!=b)
      {
         if(a>b)
         {
             str=str+"aa";
             str=str+"b";
             a=a-2;
             b--;
             if(b==0||a==0)
             {
                 break;
             }
         }
         else if(b>a)
         {
             str=str+"bb";
             str=str+"a";
             b=b-2;
             a--;
             if(b==0||a==0)
             {
                 break;
             }
         }
        else
        {
            break;
        }
      }
    if(a==0&&b!=0)
    {
        while(b!=0)
        {
            str=str+"b";
            b--;
        }
    }
     if(a!=0&&b==0)
    {
        while(a!=0)
        {
            str=str+"a";
            a--;
        }
    }
     while(a==b&&(a!=0))
     {
         
         str=str+"a";
         str=str+"b";
         a--;
         b--;
     }
      return str;
    }
}