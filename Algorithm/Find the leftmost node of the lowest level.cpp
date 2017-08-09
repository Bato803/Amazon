class Solution {
public:
    int findBottomLeftValue(TreeNode* root) {
        if (!root) return 0;
        int max_depth = 1, res = root->val;
        helper(root, 1, max_depth, res);
        return res;
    }
    void helper(TreeNode* node, int depth, int& max_depth, int& res) {
        if (!node) return;
        if (depth > max_depth) {
            max_depth = depth;
            res = node->val;
        }
        helper(node->left, depth + 1, max_depth, res);
        helper(node->right, depth + 1, max_depth, res);
    }
};
