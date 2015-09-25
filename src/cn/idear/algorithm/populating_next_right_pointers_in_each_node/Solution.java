package cn.idear.algorithm.populating_next_right_pointers_in_each_node;

import cn.idear.algorithm.util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangdongwei on 9/25/15.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
       if(root == null || root.left == null)
           return;
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
//    public void connect(TreeLinkNode root) {
//        if(root == null)
//            return;
//        if(root.left != null){
//            connect(root.left);
//            connect(root.right);
//            for(TreeLinkNode l = root.left, r= root.right; l != null ; l = l.right, r = r.left)
//                l.next = r;
//        }
//    }

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
