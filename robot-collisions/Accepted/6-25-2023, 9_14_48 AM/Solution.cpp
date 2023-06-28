// https://leetcode.com/problems/robot-collisions

class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        
        vector<pair<int,int>> sortedPositions(n);
        
        for(int i = 0; i < n; i++) {
            sortedPositions[i] = {positions[i], i};
        }
        
        sort(sortedPositions.begin(), sortedPositions.end());
        
        stack<int> healthStack;
        for(int i = 0; i < n; i++) {
            int index = sortedPositions[i].second;
            int currentHealth = healths[index];
            if(directions[index] == 'L') {
                if(healthStack.empty() || directions[healthStack.top()] == 'L') {
                    healthStack.push(index);
                } else {
                    if(currentHealth < healths[healthStack.top()]) {
                        healths[healthStack.top()]--;
                    } else if(currentHealth == healths[healthStack.top()]) {
                        healthStack.pop();
                    } else {
                        while(!healthStack.empty() && directions[healthStack.top()] == 'R' && currentHealth > healths[healthStack.top()]) {
                            healthStack.pop();
                            currentHealth--;
                        }
                        if(healthStack.empty() || directions[healthStack.top()] == 'L') {
                            healths[index] = currentHealth;
                            healthStack.push(index);
                        } else if(directions[healthStack.top()] == 'R') {
                            if(currentHealth == healths[healthStack.top()]) {
                                healthStack.pop();
                            } else {
                                healths[healthStack.top()]--;
                            }
                        }
                    }
                }
            } else {
                healthStack.push(index);
            }
        }
        
        vector<int> survivedIndices;
        
        while(!healthStack.empty()) {
            survivedIndices.push_back(healthStack.top());
            healthStack.pop();
        }
        
        sort(survivedIndices.begin(), survivedIndices.end());
        
        vector<int> finalSurvivedHealths;
        
        for(auto index : survivedIndices) {
            finalSurvivedHealths.push_back(healths[index]);
        }
        
        return finalSurvivedHealths;
    }
};
