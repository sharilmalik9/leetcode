// https://leetcode.com/problems/cousins-in-binary-tree-ii

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* replaceValueInTree(TreeNode* root) {
        
        if(root==NULL)return root;
        vector<int> total;
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            int size=q.size();
            int sum=0;
            while(size--){
                TreeNode* curr=q.front();
                q.pop();
                
                sum+=curr->val;
                
                if(curr->left!=NULL)q.push(curr->left);
                if(curr->right!=NULL)q.push(curr->right);
            }
            total.push_back(sum);
        }
        
        
        
        
       
        
        
        total.push_back(0);
        total.push_back(0);
        total.push_back(0);

        
        int level=1;
        
        root->val=0;
        q.push(root);
        
        while(!q.empty()){
            int size=q.size();
            while(size--){
                TreeNode* curr=q.front();
                q.pop();
                
                int level_sum=total[level];
                
                int curr_sum=0;
                if(curr->left!=NULL){
                    curr_sum+=curr->left->val;
                }
                
                if(curr->right!=NULL){
                    curr_sum+=curr->right->val;
                }
                
                int value=level_sum-curr_sum;
                
            
                if(curr->left!=NULL){
                    curr->left->val=value;
                    
                    q.push(curr->left);
                }
                
                if(curr->right!=NULL){
                    curr->right->val=value;
                    q.push(curr->right);
                    
                }
            }
            
            level++;
        }
        
        
        return root;
        
    }
};