package cn.idear.algorithm.populating_next_right_pointers_in_each_node_ii;

import cn.idear.algorithm.util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangdongwei on 9/25/15.
 */
public class Solution {

    /**
     * 自顶向下完成对下一层左右子树之间的连线。及root的后继兄弟子树的连线
     * @param root
     * @return
     */
    public void connect(TreeLinkNode root) {
       if(root == null)
           return;
        /**
         * root是叶子结点没有左右子树结束。
         */
        if(root.left == null && root.right == null)
            return;
        TreeLinkNode brother = findLeftMostChild(root.next);
        if (root.left == null) {
            root.right.next = brother;
        } else if (root.right == null) {
            root.left.next = brother;
        } else {
            root.left.next = root.right;
            root.right.next = brother;
        }
        /**
         * 第一次提交出错。原因：找左子树在右子树的后继依赖于右子树的完成。
         */
        connect(root.right);
        connect(root.left);
    }
//    /**
//     * 自底向上
//     * @param node
//     * @return
//     */
//    public void connect(TreeLinkNode root) {
//        if(root == null)
//            return;
//        connect(root.left);
//        connect(root.right);
//        for(TreeLinkNode lhead = root.left, rhead = root.right; lhead != null && rhead != null;){
//            TreeLinkNode l, r = rhead;
//            for(l = lhead; l.next != null; l = l.next);
//            lhead = findLeftMostChild(lhead);
//            rhead = findLeftMostChild(rhead);
//            l.next = r;
//        }
//    }

    private TreeLinkNode findLeftMostChild(TreeLinkNode node) {
        if(node == null)
            return null;
        if(node.left != null)
            return node.left;
        if(node.right != null)
            return node.right;
        return findLeftMostChild(node.next);
    }

    public void connect1(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        TreeLinkNode dummy = new TreeLinkNode(0);
        while(!queue.isEmpty()){
            int len = queue.size();
            TreeLinkNode cur = dummy;
            for(int i = 0; i < len; i++){
                TreeLinkNode node = queue.poll();
                cur.next = node;
                cur = cur.next;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
    }
}
