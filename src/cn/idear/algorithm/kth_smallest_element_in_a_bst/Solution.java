package cn.idear.algorithm.kth_smallest_element_in_a_bst;

import cn.idear.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    enum ReturnType{
        PRE, IN, POST
    }

    class State{
        ReturnType retType = ReturnType.PRE;
        TreeNode node;
        State(TreeNode node){
            this.node = node;
        }
    }

    public int kthSmallest1(TreeNode root, int k) {
        int i = 0;
        Stack<State> stack = new Stack<>();
        stack.push(new State(root));
        while(!stack.isEmpty()){
            State state = stack.pop();
            switch(state.retType){
                case PRE:
                    state.retType = ReturnType.IN;
                    if(state.node.left != null){
                        stack.push(state);
                        stack.push(new State(state.node.left));
                        continue;
                    }

                case IN:
                    if(++i == k)
                        return state.node.val;
                    state.retType = ReturnType.POST;

                case POST:
                    if(state.node.right != null)
                        stack.push(new State(state.node.right));
                    break;

                default:
                    break;
            }
        }
        throw new RuntimeException();
    }

    int cnt = 0; boolean found = false; int result;
    public int kthSmallest(TreeNode root, int k) {
        if(found) return result;
        if(root.left != null)
            kthSmallest(root.left, k);
        if(++cnt == k) {
            result = root.val;
            found = true;
        }
        if(!found && root.right != null)
            kthSmallest(root.right, k);
        return result;
    }
}
