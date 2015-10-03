package cn.idear.algorithm.binary_search_tree_iterator;

import cn.idear.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by wangdongwei on 10/3/15.
 */
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    /**
     * 实际上只需要将左子树压栈即可。next函数的时候把右子树入栈。
     * @param root
     */
    public BSTIterator(TreeNode root) {
        pushStack(root);
    }

    private void pushStack(TreeNode root){
        for(TreeNode cur = root; cur != null; cur = cur.left)
            stack.push(cur);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if(cur.right != null)
            pushStack(cur.right);
        return cur.val;
    }

//    /**
//     * Accepted.
//     * O(1) time
//     * O(n) time n is size of root，利用DFS将所有元素压栈。
//     */
//    private Stack<TreeNode> stack = new Stack<>();
//
//    public BSTIterator(TreeNode root) {
//        initialStack(root);
//    }
//
//    private void initialStack(TreeNode root){
//        if(root != null){
//            initialStack(root.right);
//            stack.push(root);
//            initialStack(root.left);
//        }
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return stack.pop().val;
//    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
