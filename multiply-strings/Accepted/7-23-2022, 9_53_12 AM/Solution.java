// https://leetcode.com/problems/multiply-strings

import java.math.*;
class Solution {

public String multiply(String n1, String n2) {
    BigInteger nm=new BigInteger(n1);
    BigInteger kk=new BigInteger(n2);
    nm=nm.multiply(kk);
    return nm.toString();
}
}