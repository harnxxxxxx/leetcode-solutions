/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<Integer> rightSide(TreeNode root, Queue<TreeNode> queue ,List<Integer> result){

        while(!queue.isEmpty()){

            int n = queue.size();
            int temp = -1;

            while(n-- > 0){
                
                TreeNode str = queue.poll();

                if(str != null){
                    temp = str.val;
                    queue.add(str.left);
                    queue.add(str.right);
                }
            }
            if(temp != -1) result.add(temp);
        }

        return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        return rightSide(root,queue,result);
    }
}