// https://leetcode.com/problems/longest-happy-string

class Solution {
  public String longestDiverseString(int a, int b, int c) {
            StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("x");
        PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>((el1, el2) -> el2.getValue() - el1.getValue());

        if (a > 0) {
            priorityQueue.add(new Pair<>("a", a));
        }

        if (b > 0) {
            priorityQueue.add(new Pair<>("b", b));
        }

        if (c > 0) {
            priorityQueue.add(new Pair<>("c", c));
        }

        while (!priorityQueue.isEmpty()) {

            if (priorityQueue.size() == 1 && priorityQueue.peek().getKey().charAt(0) == stringBuilder.charAt(stringBuilder.length() - 1)) {
                break;
            }

            if (priorityQueue.peek().getKey().charAt(0) != stringBuilder.charAt(stringBuilder.length() - 1)) {
                Pair<String, Integer> pair = priorityQueue.poll();
                int repeatFactor = pair.getValue() >= 2 ? 2 : 1;
                for (int i=0;i<repeatFactor;i++){
                    stringBuilder.append(pair.getKey());
                }
                if (pair.getValue() - repeatFactor > 0) {
                    priorityQueue.add(new Pair<>(pair.getKey(), pair.getValue() - repeatFactor));
                }
            } else {
                Pair<String, Integer> pairOne = priorityQueue.poll();
                Pair<String, Integer> pairTwo = priorityQueue.poll();

                Double checkFactor = Double.valueOf(pairOne.getValue()) / Double.valueOf(pairTwo.getValue());
                int repeatFactor = checkFactor > 1.0 ? 1 : 2;

                priorityQueue.add(pairOne);
                if (pairTwo.getValue() - repeatFactor > 0) {
                    priorityQueue.add(new Pair<>(pairTwo.getKey(), pairTwo.getValue() - repeatFactor));
                }
                for (int i=0;i<repeatFactor;i++){
                    stringBuilder.append(pairTwo.getKey());
                }
            }
        }

        stringBuilder.replace(0, 1, "");
        return stringBuilder.toString();
    }
}