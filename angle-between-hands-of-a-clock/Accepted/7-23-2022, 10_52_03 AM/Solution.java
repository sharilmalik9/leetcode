// https://leetcode.com/problems/angle-between-hands-of-a-clock

class Solution {
   public double angleClock(int hour, int minutes) {
    double degOfMinHand = minutes * 6;
    double degOfHourHand = (hour * 30) + (degOfMinHand / 12);
    double diff = Math.abs(degOfHourHand - degOfMinHand);
    return Math.min(diff, 360 - diff);
}
}