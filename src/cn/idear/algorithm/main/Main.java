package cn.idear.algorithm.main;

import cn.idear.algorithm.happy_number.Solution;
import cn.idear.algorithm.lru_cache.LRUCache;
import cn.idear.algorithm.min_stack.MinStack;
import cn.idear.algorithm.util.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by wangdongwei on 8/23/15.
 * Unit Test.
 */
public class Main {

    @Test
    public void testFactorialTrailingZeros(){
        Assert.assertEquals(536870902, factorialTrailingZeros(Integer.MAX_VALUE));
    }

    @Test
    public void testFindPeakElement(){
        Assert.assertEquals(2, findPeakElement(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void testExcelSheetColumnNumber(){
        Assert.assertEquals(1, excelSheetColumnNumber("A"));
        Assert.assertEquals(2, excelSheetColumnNumber("B"));
        Assert.assertEquals(3, excelSheetColumnNumber("C"));
        Assert.assertEquals(27, excelSheetColumnNumber("AA"));
        Assert.assertEquals(28, excelSheetColumnNumber("AB"));
    }

    @Test
    public void testMinStack(){
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        Assert.assertEquals(0, stack.getMin());
        stack.pop();
        Assert.assertEquals(0, stack.getMin());
        stack.pop();
        Assert.assertEquals(0, stack.getMin());
        stack.pop();
        Assert.assertEquals(2, stack.getMin());
    }

    @Test
    public void testMaximumProductSubarray(){
        Assert.assertEquals(6, maximumProductSubarray(new int[]{2, 3, -2, 4}));
    }

    @Test
    public void testLRUCache(){
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        Assert.assertEquals(1, cache.get(2));
        cache.set(3, 2);
        Assert.assertEquals(1, cache.get(2));
        Assert.assertEquals(2, cache.get(3));
    }

    @Test
    public void testRandomListNode(){

    }

    @Test
    public void testCandy(){
        Assert.assertEquals(3, candy(new int[]{1, 1, 1}));
        Assert.assertEquals(4, candy(new int[]{1, 2, 1}));
    }

    @Test
    public void testGasStation(){
        Assert.assertEquals(0, gasStation(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        Assert.assertEquals(-1, gasStation(new int[]{1, 2, 3}, new int[]{2, 3, 4}));
    }

    @Test
    public void testMajorityElementII(){
        Assert.assertEquals(Collections.singletonList(1), majorityElementII(new int[]{1}));
        Assert.assertEquals(Arrays.asList(1, 2), majorityElementII(new int[]{1, 2}));
        Assert.assertEquals(Collections.emptyList(), majorityElementII(new int[]{1, 2, 3}));
        Assert.assertEquals(Collections.emptyList(), majorityElementII(new int[0]));
        Assert.assertEquals(Collections.singletonList(2), majorityElementII(new int[]{2, 2, 1, 3}));
    }

    @Test
    public void testMajorityElement(){
        Assert.assertEquals(3, majorityElement(new int[]{4, 2, 1, 2, 3, 3, 3, 3, 3, 3, 5}));
    }

    @Test
    public void testIntersectionOfTwoLinkedLists(){
        ListNode expect, actual;
        expect = ListNode.make(new int[]{4, 5, 6});
        actual = intersectionOfTwoLinkedLists(new int[]{1, 2}, new int[]{7, 8, 9}, expect);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testCloneGraph(){
        UndirectedGraphNode expect, actual;
        int[] nums = new int[]{0, 0, 0};
        expect = UndirectedGraphNode.make(nums);
        actual = cloneGraph(UndirectedGraphNode.make(nums));
        Assert.assertEquals(expect, actual);
        nums = new int[]{0, 1, 5, -1, 1, 2, 5, -1, 2, 3, -1, 3, 4, 4, -1, 4, 5, 5, -1, 5};
        expect = UndirectedGraphNode.make(nums);
        actual = cloneGraph( UndirectedGraphNode.make(nums));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testWordLadder(){
        Assert.assertEquals(5, wordLadder("hit", "cog", new String[]{"hot","dot","dog","lot","log"}));
    }

    @Test
    public void testSingleNumberII(){
        Assert.assertEquals(5, singleNumberII(new int[]{0, 0, 0, 5}));
    }

    @Test
    public void testSingleNumber(){
        Assert.assertEquals(4, singleNumber(new int[]{1, 2, 3, 4, 2, 3, 1}));
    }

    @Test
    public void testNumberOfIslands(){
        Assert.assertEquals(1, numberofIslands(new String[]{
                "11110",
                "11010",
                "11000",
                "00000"
        }));
        Assert.assertEquals(3, numberofIslands(new String[]{
                "11000",
                "11000",
                "00100",
                "00011"
        }));
    }

    @Test
    public void testSurroundedRegions(){
        String[] expect, actual;
        expect = new String[]{
                "XXXX",
                "XXXX",
                "XXXX",
                "XOXX"
        };
        actual = surroundedRegions(new String[]{
                "XXXX",
                "XOOX",
                "XXOX",
                "XOXX"
        });
        for(int i = 0; i < expect.length; i++)
            Assert.assertEquals(expect[i], actual[i]);
    }

    private String[] surroundedRegions(String[] boards) {
        int m = boards.length;
        char[][] board = new char[m][];
        for(int i = 0; i < m; i++)
            board[i] = boards[i].toCharArray();
        cn.idear.algorithm.surrounded_regions.Solution solution =
                new cn.idear.algorithm.surrounded_regions.Solution();
        solution.solve(board);
        for(int i = 0; i < m; i++)
            boards[i] = String.valueOf(board[i]);
        return boards;
    }

    @Test
    public void testFirstBadVersion(){
        Assert.assertEquals(4, firstBadVersion(6, 4));
        Assert.assertEquals(1, firstBadVersion(3, 1));
        Assert.assertEquals(2, firstBadVersion(3, 2));
        Assert.assertEquals(3, firstBadVersion(3, 3));
    }

    @Test
    public void testLongestConsecutiveSequence(){
        Assert.assertEquals(4, longestConsecutiveSequence(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    public void testBinaryTreeMaximumPathSum(){
        Assert.assertEquals(6, binaryTreeMaximumPathSum(new int[]{1, 2, 3}));
    }

    @Test
    public void testBestTimeToBuyAndSellStockIII(){
        Assert.assertEquals(0, bestTimeToBuyAndSellStockIII(new int[0]));
        Assert.assertEquals(2, bestTimeToBuyAndSellStockIII(new int[]{2, 1, 2, 0, 1}));
    }

    @Test
    public void testBestTimeToBuyAndSellStockII(){
        Assert.assertEquals(5, bestTimeToBuyAndSellStockII(new int[]{0, 1, 2, 3, 5, 4}));
    }

    @Test
    public void testBestTimeToBuyAndSellStock(){
        Assert.assertEquals(3, bestTimeToBuyAndSellStock(new int[]{0, 1, 2, 3}));
    }

    @Test
    public void testExcelSheetColumnTitle(){
        Assert.assertEquals("AA", excelSheetColumnTitle(27));
        Assert.assertEquals("AB", excelSheetColumnTitle(28));
        Assert.assertEquals("ZZ", excelSheetColumnTitle(702));
    }

    @Test
    public void testKthLargestElementInAnArray(){
        Assert.assertEquals(1, kthLargestElementInAnArray(new int[]{3, 2, 1, 5, 6, 4}, 6));
        Assert.assertEquals(2, kthLargestElementInAnArray(new int[]{3, 2, 1, 5, 6, 4}, 5));
        Assert.assertEquals(3, kthLargestElementInAnArray(new int[]{3, 2, 1, 5, 6, 4}, 4));
        Assert.assertEquals(4, kthLargestElementInAnArray(new int[]{3, 2, 1, 5, 6, 4}, 3));
        Assert.assertEquals(5, kthLargestElementInAnArray(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assert.assertEquals(6, kthLargestElementInAnArray(new int[]{3, 2, 1, 5, 6, 4}, 1));
    }

    @Test
    public void testReorderList(){
        Assert.assertEquals(ListNode.make(new int[]{1, 3, 2}), reorderList(new int[]{1, 2, 3}));
    }

    @Test
    public void testSumRootToLeafNumbers(){
        Assert.assertTrue(25 == sumRootToLeafNumbers(new int[]{1, 2, 3}));
    }

    @Test
    public void testCompareVersionNumbers(){
        Assert.assertTrue(1 == compareVersionNumbers("1" , "0"));
        Assert.assertTrue(0 == compareVersionNumbers("1.0" , "1"));
    }

    @Test
    public void testValidPalindrome(){
        Assert.assertTrue(validPalindrome(""));
        Assert.assertTrue(validPalindrome("*&*&("));
        Assert.assertTrue(validPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(validPalindrome("race a car"));
        Assert.assertFalse(validPalindrome("1a2"));
    }

    @Test
    public void testTriangle(){
        Assert.assertEquals(11, triangle(new Integer[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        }));
    }

    @Test
    public void testPascalsTriangleII(){
        List<Integer> expect, actual;
        expect = Arrays.asList(1, 4, 6, 4, 1);
        actual = pascalsTriangleII(4);
        Assert.assertEquals(expect, actual);

        expect = Collections.singletonList(1);
        actual = pascalsTriangleII(0);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testPascalsTriangle(){
        TwoLevelList<Integer> expect, actual;
        expect = TwoLevelList.make(new Integer[][]{
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1}
        });
        actual = pascalTriangle(5);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFlattenBinaryTreeToLinkedList(){
        TreeNode expect, actual;
        expect = TreeNode.createTree(new int[]{1, 0, 2, 0, 0});
        actual = flattenBinaryTreeToLinkedList(new int[]{1, 2, 0, 0, 0});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testPathSumII(){
        TwoLevelList<Integer> expect, actual;
        expect = TwoLevelList.make(new Integer[][]{
                {5, 4, 11, 2},
                {5, 8, 4, 5}
        });
        actual = pathSumII(new int[]{5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0}, 22);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testPathSum(){
        Assert.assertTrue(pathSum(new int[]{5, 4, 8, 11, 13, 4, 7, 2, 0, 1, 0, 0, 0, 0, 0, 0}, 22));
    }

    @Test
    public void testMinimumDepthOfBinaryTree(){
        Assert.assertEquals(2, minimumDepthOfBinaryTree(new int[]{1, 2, 0, 0, 0}));
    }

    @Test
    public void testBalancedBinaryTree(){
        Assert.assertTrue(balancedBinaryTree(new int[0]));
        Assert.assertTrue(balancedBinaryTree(new int[]{1, 0, 0}));
        Assert.assertTrue(balancedBinaryTree(new int[]{2, 1, 0, 0, 0}));
        Assert.assertFalse(balancedBinaryTree(new int[]{1, 2, 0, 3, 0, 0, 0}));
    }

    @Test
    public void testConvertSortedListToBinarySearchTree(){
        TreeNode expect, actual;
        expect = TreeNode.createTree(new int[]{1, 0, 0});
        actual = convertSortedListToBinarySearchTree(new int[]{1});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{2, 1, 0, 0, 0});
        actual = convertSortedListToBinarySearchTree(new int[]{1, 2});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{2, 1, 3, 0, 0, 0, 0});
        actual = convertSortedListToBinarySearchTree(new int[]{1, 2, 3});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{3, 2, 4, 1, 0, 0, 0, 0, 0});
        actual = convertSortedListToBinarySearchTree(new int[]{1, 2, 3, 4});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testConvertSortedArrayToBinarySearchTree(){
        TreeNode expect, actual;
        expect = TreeNode.createTree(new int[]{1, 0, 0});
        actual = convertSortedArrayToBinarySearchTree(new int[]{1});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{2, 1, 0, 0, 0});
        actual = convertSortedArrayToBinarySearchTree(new int[]{1, 2});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{2, 1, 3, 0, 0, 0, 0});
        actual = convertSortedArrayToBinarySearchTree(new int[]{1, 2, 3});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{3, 2, 4, 1, 0, 0, 0, 0, 0});
        actual = convertSortedArrayToBinarySearchTree(new int[]{1, 2, 3, 4});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testBinaryTreeLevelOrderTraversalII(){
        TwoLevelList<Integer> expect, actual;
        expect = TwoLevelList.make(new Integer[][]{
                {22, 23, 24},
                {9, 17},
                {1}
        });
        actual = binaryTreeLevelOrderTraversalII(new int[]{1, 9, 17, 0, 22, 23, 24, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testConstructBinaryTreeFromInorderAndPostorderTraversal(){
        TreeNode expect, actual;

        expect = TreeNode.createTree(new int[]{1, 0, 0});
        actual = constructBinaryTreeFromInOrderAndPostOrderTraversal(new int[]{1}, new int[]{1});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{1, 0, 2, 0, 0});
        actual = constructBinaryTreeFromInOrderAndPostOrderTraversal(new int[]{1, 2}, new int[]{2, 1});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testConstructBinaryTreeFromPreorderAndInorderTraversal(){
        TreeNode expect, actual;

        expect = TreeNode.createTree(new int[]{1, 0, 0});
        actual = constructBinaryTreefromPreorderandInorderTraversal(new int[]{1}, new int[]{1});
        Assert.assertEquals(expect, actual);

        expect = TreeNode.createTree(new int[]{1, 0, 2, 0, 0});
        actual = constructBinaryTreefromPreorderandInorderTraversal(new int[]{1, 2}, new int[]{1, 2});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testMaximumDepthOfBinaryTree(){
        Assert.assertEquals(3, maximumDepthofBinaryTree(new int[]{1, 9, 17, 0, 22, 23, 24, 0, 0, 0, 0, 0, 0}));
    }

    @Test
    public void testZigzagBinaryTreeLevelOrderTraversal(){
        TwoLevelList<Integer> expect, actual;
        expect = TwoLevelList.make(new Integer[][]{
                {1},
                {17, 9},
                {22, 23, 24}
        });
        actual = binaryZigzagTreeLevelOrderTraversal(new int[]{1, 9, 17, 0, 22, 23, 24, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testBinaryTreeLevelOrderTraversal(){
        TwoLevelList<Integer> expect, actual;
        expect = TwoLevelList.make(new Integer[][]{
                {1},
                {9, 17},
                {22, 23, 24}
        });
        actual = binaryTreeLevelOrderTraversal(new int[]{1, 9, 17, 0, 22, 23, 24, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSymmetricTree(){
        Assert.assertTrue(symmetricTree(new int[]{1, 2, 2, 3, 4, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0}));
        Assert.assertFalse(symmetricTree(new int[]{1, 2, 2, 0, 3, 0, 3, 0, 0, 0, 0}));
    }

    @Test
    public void testSameTree(){
        TreeNode expect, actual;
        Assert.assertTrue(sameTree(null, null));

        expect = TreeNode.createTree(new int[]{1, 0, 0});
        actual = TreeNode.createTree(new int[]{1, 2, 0, 0, 0});
        Assert.assertFalse(sameTree(expect, actual));
    }

    private boolean sameTree(TreeNode p, TreeNode q) {
        cn.idear.algorithm.same_tree.Solution solution =
                new cn.idear.algorithm.same_tree.Solution();
        return solution.isSameTree(p, q);
    }

    @Test
    public void testRecoverBinarySearchTree(){
        TreeNode expect, actual;
        expect = TreeNode.createTree(new int[]{4, 2, 5, 1, 3, 0, 0, 0, 0, 0, 0});
        actual = recoverBinarySearchTree(TreeNode.createTree(new int[]{4, 5, 2, 1, 3, 0, 0, 0, 0, 0, 0}));
        Assert.assertEquals(expect, actual);

        actual = recoverBinarySearchTree(TreeNode.createTree(new int[]{4, 3, 5, 1, 2, 0, 0, 0, 0, 0, 0}));
        Assert.assertEquals(expect, actual);
    }

    private TreeNode recoverBinarySearchTree(TreeNode root) {
        cn.idear.algorithm.recover_binary_search_tree.Solution solution =
                new cn.idear.algorithm.recover_binary_search_tree.Solution();
        solution.recoverTree(root);
        return root;
    }

    @Test
    public void testValidateBinarySearchTree(){
        Assert.assertFalse(validateBinarySearchTree(new int[]{3, 1, 5, 0, 4, 0, 0, 0, 0}));
        Assert.assertTrue(validateBinarySearchTree(new int[]{Integer.MAX_VALUE, 0, 0}));
    }

    private boolean validateBinarySearchTree(int[] nums) {
        TreeNode root = TreeNode.createTree(nums);
        cn.idear.algorithm.validate_binary_search_tree.Solution solution =
                new cn.idear.algorithm.validate_binary_search_tree.Solution();
        return solution.isValidBST(root);
    }

    @Test
    public void testUniqueBinarySearchTreeII(){
        Assert.assertEquals(1, uniqueBinarySearchTreeII(0).size());
        Assert.assertEquals(1, uniqueBinarySearchTreeII(1).size());
        Assert.assertEquals(2, uniqueBinarySearchTreeII(2).size());
        Assert.assertEquals(5, uniqueBinarySearchTreeII(3).size());
        Assert.assertEquals(14, uniqueBinarySearchTreeII(4).size());
    }

    @Test
    public void testUniqueBinarySearchTree(){
        Assert.assertEquals(1, uniqueBinarySearchTree(0));
        Assert.assertEquals(1, uniqueBinarySearchTree(1));
        Assert.assertEquals(2, uniqueBinarySearchTree(2));
        Assert.assertEquals(5, uniqueBinarySearchTree(3));
        Assert.assertEquals(14, uniqueBinarySearchTree(4));
    }

    @Test
    public void testMoveZeros(){
        Assert.assertTrue(Arrays.equals(new int[]{1, 3, 2, 0, 0}, moveZeros(new int[]{0, 1, 0, 3, 2})));
    }

    @Test
    public void testBinaryTreePostorderTraversal(){
        List<Integer> expect, actual;
        expect = Arrays.asList(3, 2, 1);
        actual = binaryTreePostorderTraversal(new int[]{1, 0, 2, 3});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testBinaryTreePreorderTraversal(){
        List<Integer> expect, actual;
        expect = Arrays.asList(1, 2, 3);
        actual = binaryTreePreorderTraversal(new int[]{1, 0, 2, 3});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testBinaryTreeInorderTraversal(){
        List<Integer> expect, actual;
        expect = Arrays.asList(1, 3, 2);
        actual = binaryTreeInorderTraversal(new int[]{1, 0, 2, 3});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testRestoreIpAddress(){
        List<String> expect, actual;
        expect = Arrays.asList("255.255.11.135", "255.255.111.35");
        actual = restoreIpAddress("25525511135");
        Assert.assertEquals(expect, actual);

        expect = new ArrayList<>();
        actual = restoreIpAddress("22");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testDecodeWays(){
        Assert.assertEquals(2, decodeWays("12"));
        Assert.assertEquals(0, decodeWays("0"));
        Assert.assertEquals(0, decodeWays("01"));
        Assert.assertEquals(0, decodeWays("012"));
        Assert.assertEquals(0, decodeWays("100"));
        Assert.assertEquals(1, decodeWays("110"));
        Assert.assertEquals(2, decodeWays("227"));
    }

    @Test
    public void testReverseLinkedListII(){
        ListNode expect, actual;

        expect = ListNode.make(new int[]{1, 4, 3, 2, 5});
        actual = reverseLinkedListII(new int[]{1, 2, 3, 4, 5}, 2, 4);
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{1, 5, 4, 3, 2});
        actual = reverseLinkedListII(new int[]{1, 2, 3, 4, 5}, 2, 5);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testLargestRectangleInHistogram(){
        Assert.assertEquals(10, largestRectangleInHistogram(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(4, largestRectangleInHistogram(new int[]{1, 2, 2}));
        Assert.assertEquals(6, largestRectangleInHistogram(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(largestRectangleInHistogram(new int[]{
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        }));
    }

    @Test
    public void testWordSearch(){
        char[][] board = generateBoard(new String[]{
                "ABCE",
                "SFCS",
                "ADEE"
        });
        Assert.assertTrue(wordSearch(board, "ABCCED"));
        Assert.assertTrue(wordSearch(board, "SEE"));
        Assert.assertFalse(wordSearch(board, "ABCB"));
    }

    @Test
    public void testSortColors(){
        int[] expect, actual;
        expect = new int[]{0, 0, 0, 1, 1, 2, 2, 2, 2};
        actual = sortColors(new int[]{0, 1, 2, 0, 1, 2, 0, 2, 2});
        Assert.assertTrue(Arrays.equals(expect, actual));
    }

    @Test
    public void testSubsetsII(){
        TwoLevelList<Integer> expect, actual;
        expect = TwoLevelList.make(new Integer[][]{
                {2}, {1}, {1, 2}, {1, 2, 2}, {2, 2}, {}
        });
        actual = subsetsII(new int[]{1, 2, 2});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testGrayCode(){
        Assert.assertEquals(Arrays.asList(0, 1, 3, 2), grayCode(2));
    }

    @Test
    public void testPartition(){
        ListNode expect, actual;
        expect = ListNode.make(new int[]{1, 2, 2, 4, 3, 5});
        actual = partition(new int[]{1, 4, 3, 2, 5, 2}, 3);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSubsets(){
        TwoLevelList<Integer> expect, actual;
        expect = TwoLevelList.make(new Integer[][]{
                {3}, {1}, {2}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}, {}
        });
        actual = subsets(new int[]{2, 3, 1});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testEditDistance(){
        Assert.assertEquals(3, editDistance("cafe", "coffee"));
    }

    @Test
    public void testRemoveDuplicatesFromSortedArrayII(){
        int[] expect, actual;
        expect = new int[]{1, 1, 2, 2, 3, 3};
        actual = new int[]{1, 1, 1, 2, 2, 3};
        Assert.assertEquals(5, removeDuplicatesFromSortedArrayII(actual));
        Assert.assertTrue(Arrays.equals(expect, actual));
    }

    @Test
    public void testRemoveDuplicatesFromSortedListII(){
        ListNode expect,actual;
        expect = null;
        actual = removeDuplicatesFromSortedListII(new int[]{1, 1, 1});
        Assert.assertEquals(expect, actual);

        expect = null;
        actual = removeDuplicatesFromSortedListII(new int[]{1, 1, 2, 2});
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{1, 2, 5});
        actual = removeDuplicatesFromSortedListII(new int[]{1, 2, 3, 3, 4, 4, 5});
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{2, 3});
        actual = removeDuplicatesFromSortedListII(new int[]{1, 1, 1, 2, 3});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testRemoveDuplicatesFromSortedList(){
        ListNode expect,actual;
        expect = ListNode.make(new int[]{1});
        actual = removeDuplicatesFromSortedList(new int[]{1, 1, 1});
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{1, 1, 2});
        actual = removeDuplicatesFromSortedList(new int[]{1, 2});
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{1, 1, 2, 3, 3});
        actual = removeDuplicatesFromSortedList(new int[]{1, 2, 3});
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{1});
        actual = removeDuplicatesFromSortedList(new int[]{1, 1});
        Assert.assertEquals(expect, actual);
    }

    private ListNode removeDuplicatesFromSortedList(int[] nums) {
        ListNode head = ListNode.make(nums);
        cn.idear.algorithm.remove_duplicates_from_sorted_list.Solution solution =
                new cn.idear.algorithm.remove_duplicates_from_sorted_list.Solution();
        return solution.deleteDuplicates(head);
    }

    @Test
    public void testSearchA2DMatrixII(){
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Assert.assertTrue(searchA2DMatrixII(matrix, 5));
        Assert.assertFalse(searchA2DMatrixII(matrix, 20));

        matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        Assert.assertTrue(searchA2DMatrixII(matrix, 5));
    }

    @Test
    public void testSearchA2DMatrix(){
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Assert.assertTrue(searchA2DMatrix(matrix, 3));
        Assert.assertFalse(searchA2DMatrix(matrix, 8));
        Assert.assertFalse(searchA2DMatrix(matrix, 22));
        Assert.assertFalse(searchA2DMatrix(matrix, 51));
        Assert.assertTrue(searchA2DMatrix(matrix, 50));
    }

    @Test
    public void testSetMatrixZeros(){
        int[][] expect, actual;
        expect = new int[][]{
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 1}
        };
        actual = setMatrixZeros(new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        });
        for(int i = 0; i < expect.length; i++)
            Assert.assertTrue(Arrays.equals(expect[i], actual[i]));
    }

    @Test
    public void testSimplifyPath(){
        Assert.assertEquals("/home", simplifyPath("/home/"));
        Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));
        Assert.assertEquals("/", simplifyPath("/../"));
        Assert.assertEquals("/home/foo", simplifyPath("/home//foo/"));
    }

    @Test
    public void testClimbingStairs(){
        Assert.assertEquals(1, climbingStairs(0));
        Assert.assertEquals(1, climbingStairs(1));
        Assert.assertEquals(2, climbingStairs(2));
        Assert.assertEquals(3, climbingStairs(3));
        Assert.assertEquals(5, climbingStairs(4));
        Assert.assertEquals(8, climbingStairs(5));
    }

    @Test
    public void testMySqrt(){
        int num;
        num = 0;
        Assert.assertEquals((int)Math.sqrt(num), mySqrt(num));
        num = 1;
        Assert.assertEquals((int)Math.sqrt(num), mySqrt(num));
        num = 121;
        Assert.assertEquals((int)Math.sqrt(num), mySqrt(num));
        num = 123;
        Assert.assertEquals((int)Math.sqrt(num), mySqrt(num));
        num = Integer.MAX_VALUE;
        Assert.assertEquals((int) Math.sqrt(num), mySqrt(num));
        num = 674478281;
        Assert.assertEquals((int)Math.sqrt(num), mySqrt(num));
        num = 3;
        Assert.assertEquals((int)Math.sqrt(num), mySqrt(num));
        num = 6;
        Assert.assertEquals((int)Math.sqrt(num), mySqrt(num));
    }

    @Test
    public void testTextJustification(){
        List<String> expect, actual;
        expect = Arrays.asList(
            "This    is    an",
            "example  of text",
            "justification.  ");
        actual = textJustification(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        },16);
        Assert.assertEquals(expect, actual);

        expect = new ArrayList<String>(){{add("");}};
        actual = textJustification(new String[0], 0);
        Assert.assertEquals(expect, actual);

        expect = Arrays.asList(
                "What must be", "shall be.   "
        );
        actual = textJustification(new String[]{
                "What","must","be","shall","be."
        }, 12);
        Assert.assertEquals(expect, actual);

        expect = Arrays.asList(
                "Don't  go  around  saying  the",
                "world  owes  you a living; the",
                "world owes you nothing; it was","here first.                   ");
        actual = textJustification(new String[]{
                "Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes",
                "you","nothing;","it","was","here","first."
        }, 30);
    }

    @Test
    public void testInsertIntervals(){
        List<Interval> expect, actual;

        expect = Interval.createIntervals(new int[][]{
                {1, 5}, {6,9}
        });
        actual = insertIntervals(new int[][]{
                {1, 3}, {6, 9}
        }, new int[]{2, 5});
        Assert.assertEquals(expect, actual);

        expect = Interval.createIntervals(new int[][]{
                {1, 2}, {3, 10}, {12, 16}
        });
        actual = insertIntervals(new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        }, new int[]{4, 9});
        Assert.assertEquals(expect, actual);
    }

    private List<Interval> insertIntervals(int[][] nums, int[] newNums) {
        List<Interval> intervals = Interval.createIntervals(nums);
        Assert.assertTrue(newNums.length == 2);
        Interval newInterval = new Interval(newNums[0], newNums[1]);
        cn.idear.algorithm.insert_interval.Solution solution =
                new cn.idear.algorithm.insert_interval.Solution();
        return solution.insert(intervals, newInterval);
    }

    @Test
    public void testMergeIntervals(){
        List<Interval> expect;
        expect = Interval.createIntervals(new int[][]{
                {1, 6}, {8, 10}, {15, 18}
        });
        List<Interval> actual;
        actual = mergeIntervals(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        Assert.assertEquals(expect, actual);

        expect = Interval.createIntervals(new int[][]{
                {1, 10}
        });
        actual = mergeIntervals(new int[][]{
                {2,3},{4,5},{6,7},{8,9},{1,10}
        });
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testJumpGame(){
        Assert.assertTrue(jumpGame(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(jumpGame(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void testMinimumPathSum(){
        Assert.assertEquals(17, minimumPathSum(new int[][]{
                {1, 3, 2},
                {7, 4, 6},
                {9, 8, 5}
        }));
    }

    @Test
    public void testUniquePathsII(){
        Assert.assertEquals(2, uniquePathsII(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
        Assert.assertEquals(0, uniquePathsII(new int[][]{
                {0, 0},
                {0, 1},
        }));
        Assert.assertEquals(0, uniquePathsII(new int[][]{
                {1, 0},
                {0, 0},
        }));
        Assert.assertEquals(0, uniquePathsII(new int[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        }));
        Assert.assertEquals(10, uniquePathsII(new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,0,0,0}
        }));
        Assert.assertEquals(1, uniquePathsII(new int[][]{
                {0}
        }));
    }

    @Test
    public void testUniquePaths(){
        Assert.assertEquals(3, uniquePaths(3, 2));
        Assert.assertEquals(3, uniquePaths(2, 3));
        Assert.assertEquals(6, uniquePaths(3, 3));
    }

    @Test
    public void testRotateArray(){
        int[] expect;
        int[] actual;
        expect = new int[]{5, 6, 7, 1, 2, 3, 4};
        actual = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        Assert.assertTrue(Arrays.equals(expect, actual));

        expect = new int[]{2, 1};
        actual = rotateArray(new int[]{1, 2}, 1);
        Assert.assertTrue(Arrays.equals(expect, actual));

        expect = new int[]{5, 6, 1, 2, 3, 4};
        actual = rotateArray(new int[]{1, 2, 3, 4, 5, 6}, 2);
        Assert.assertTrue(Arrays.equals(expect, actual));
    }

    @Test
    public void testRotateList(){
        ListNode expect;
        ListNode actual;
        expect = ListNode.make(new int[]{4, 5, 1, 2, 3});
        actual = rotateList(new int[]{1, 2, 3, 4, 5}, 2);
        Assert.assertEquals(expect, actual);

        actual = rotateList(new int[]{1, 2, 3, 4, 5}, 7);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testLengthOfLastWord(){
        Assert.assertEquals(5, lengthOfLastWord("hello world"));
    }

    @Test
    public void testSpiralMatrixII(){
        int[][] expect = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] actual = sprialMatrixII(3);
        for(int i = 0; i < expect.length; i++)
            Assert.assertTrue(Arrays.equals(expect[i], actual[i]));
    }

    @Test
    public void testSpiralMatrix(){
        List<Integer> expect;
        expect = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        List<Integer> actual;
        actual = spiralMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Assert.assertEquals(expect, actual);
        actual = spiralMatrix(new int[][]{{3},{2}});
        expect = Arrays.asList(3, 2);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testMaximumSubarray(){
        Assert.assertEquals(6, maximumSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testNQueensII(){
        Assert.assertEquals(2, nQueensII(4));
    }

    @Test
    public void testNQueens(){
        TwoLevelList<String> expect;
        expect = TwoLevelList.make(new String[][]{
                {
                        ".Q..",  // Solution 1
                        "...Q",
                        "Q...",
                        "..Q."
                },

                {
                        "..Q.",  // Solution 2
                        "Q...",
                        "...Q",
                        ".Q.."
                }
        });
        Assert.assertEquals(expect, nQueens(4));
        expect = TwoLevelList.make(new String[][]{{"Q"}});
        Assert.assertEquals(expect, nQueens(1));
    }

    @Test
    public void testJumpGameII(){
        Assert.assertEquals(2, jumpGameII(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void testTrappingRainWater(){
        Assert.assertEquals(6, trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    public void testMyPowXN(){
        Assert.assertEquals(0, Double.compare(4.0, myPowXN(2.0, 2)));
        Assert.assertEquals(0, Double.compare(8.0, myPowXN(2.0, 3)));
        Assert.assertEquals(0, Double.compare(4.0, myPowXN(0.5, -2)));
        //Assert.assertTrue(0.00003 == myPowXN(34.00515, -3));
        Assert.assertEquals(0, Double.compare(1.00000, myPowXN(-1.00000, Integer.MIN_VALUE)));
    }

    @Test
    public void testGroupAnagrams(){
        TwoLevelList<String> expect;
        expect = TwoLevelList.make(new String[][]{
                {"ate", "eat", "tea"},
                {"nat", "tan"},
                {"bat"}
        });
        TwoLevelList<String> actual = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testRotateImage(){
        int[][] expect = new int[][]{
                {13,  9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };
        int[][] actual = new int[][]{
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateImage(actual);
        for(int i = 0; i < actual.length; i++)
            Assert.assertTrue(Arrays.equals(expect[i], actual[i]));
    }

    @Test
    public void testWildcardMatching(){
        Assert.assertFalse(wildcardExpressionMatching("aa", "a"));
        Assert.assertTrue(wildcardExpressionMatching("aa", "aa"));
        Assert.assertFalse(wildcardExpressionMatching("aaa", "aa"));
        Assert.assertTrue(wildcardExpressionMatching("aa", "a*"));
        Assert.assertTrue(wildcardExpressionMatching("aa", "?*"));
        Assert.assertTrue(wildcardExpressionMatching("ab", "?*"));
        Assert.assertFalse(wildcardExpressionMatching("aab", "c*a*b"));

        Assert.assertTrue(wildcardExpressionMatching("", ""));
        Assert.assertTrue(wildcardExpressionMatching("abcdeff", "?*"));
        Assert.assertFalse(wildcardExpressionMatching("a", "ab*"));
        Assert.assertFalse(wildcardExpressionMatching("bb", "?bab"));
        Assert.assertFalse(wildcardExpressionMatching("ab", "?*c"));
        Assert.assertFalse(wildcardExpressionMatching("aaba", "ab*a*c*a"));

        Assert.assertTrue(wildcardExpressionMatching("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
        Assert.assertTrue(wildcardExpressionMatching("bababbbbabababaabbaabbaababbbbbabaabbaaabababbaaabbbababbbbaaaaaabbbbbbabaaabbbbaababbbaaabaabaaababababaaabbbbbbababbabbbbabaabbabaabbabbbbaaabaabbbaaabaaaababbbbbabbbababbbaababaaaababaaaabbbbbbaaaabbb", "b*a*b*a****b**b*ab**ab*bb*abbb****babb**a*a*b*bb***aa*bb*b***bbba*bb*aa**b*a**b**b***a*bbbaa*bb***b*"));
    }

    @Test
    public void testMissingNumber(){
        Assert.assertEquals(2, missingNumber(new int[]{0, 1, 3}));
        Assert.assertEquals(3, missingNumber(new int[]{0, 1, 2}));
    }

    @Test
    public void testFirstMissingPositive(){
        Assert.assertEquals(3, firstMissingPositive(new int[]{1, 2, 0}));
        Assert.assertEquals(2, firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    @Test
    public void testCombinationSumII(){
        TwoLevelList<Integer> expect;
        TwoLevelList<Integer> actual;
        expect = TwoLevelList.make(new Integer[][]{{1, 7}, {1, 2, 5}, {2, 6}, {1, 1, 6}});
        actual = TwoLevelList.make(combinationSumII(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        Assert.assertEquals(expect, actual);
    }

    private List<List<Integer>> combinationSumII(int[] nums, int target) {
        cn.idear.algorithm.combination_sum_ii.Solution solution =
                new cn.idear.algorithm.combination_sum_ii.Solution();
        return solution.combinationSum2(nums, target);
    }

    @Test
    public void testFindMinimusInRotatedSortedArrayII(){
        Assert.assertEquals(0, findMinimusInRotatedSortedArrayII(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(4, findMinimusInRotatedSortedArrayII(new int[]{4}));
        Assert.assertEquals(4, findMinimusInRotatedSortedArrayII(new int[]{4, 5}));
    }

    @Test
    public void testFindMinimusInRotatedSortedArray(){
        Assert.assertEquals(0, findMinimusInRotatedSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(4, findMinimusInRotatedSortedArray(new int[]{4}));
        Assert.assertEquals(4, findMinimusInRotatedSortedArray(new int[]{4, 5}));
    }

    @Test
    public void testSearchInRotatedSortedArrayII(){
        int[] nums = new int[]{4, 4, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        Assert.assertFalse(searchInRotatedSortedArrayII(nums, 0));
        Assert.assertTrue(searchInRotatedSortedArrayII(nums, 1));
        Assert.assertTrue(searchInRotatedSortedArrayII(nums, 2));
        Assert.assertTrue(searchInRotatedSortedArrayII(nums, 3));
        Assert.assertTrue(searchInRotatedSortedArrayII(nums, 4));
    }

    @Test
    public void testSearchInRotatedSortedArray(){
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(0, searchInRotatedSortedArray(nums, 4));
        Assert.assertEquals(1, searchInRotatedSortedArray(nums, 5));
        Assert.assertEquals(2, searchInRotatedSortedArray(nums, 6));
        Assert.assertEquals(3, searchInRotatedSortedArray(nums, 7));
        Assert.assertEquals(4, searchInRotatedSortedArray(nums, 0));
        Assert.assertEquals(5, searchInRotatedSortedArray(nums, 1));
        Assert.assertEquals(6, searchInRotatedSortedArray(nums, 2));
        Assert.assertEquals(-1, searchInRotatedSortedArray(nums, 3));
        Assert.assertEquals(1, searchInRotatedSortedArray(new int[]{5, 1, 3}, 1));
        Assert.assertEquals(0, searchInRotatedSortedArray(new int[]{5, 1, 3}, 5));
        Assert.assertEquals(4, searchInRotatedSortedArray(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        Assert.assertEquals(1, searchInRotatedSortedArray(new int[]{5, 1, 2, 3, 4}, 1));
    }

    @Test
    public void testLongestValidParenthesis(){
        Assert.assertEquals(4, longestValidParenthesis(")()())"));
        Assert.assertEquals(6, longestValidParenthesis("()(())"));
    }

    @Test
    public void testCountAndSay(){
        Assert.assertEquals("1", countAndSay(1));
        Assert.assertEquals("11", countAndSay(2));
        Assert.assertEquals("21", countAndSay(3));
        Assert.assertEquals("1211", countAndSay(4));
        Assert.assertEquals("111221", countAndSay(5));
        Assert.assertEquals("312211", countAndSay(6));
    }

    @Test
    public void testSudokuSolver(){
        String[] expect = new String[]{
                "534678912",
                "672195348",
                "198342567",
                "859761423",
                "426853791",
                "713924856",
                "961537284",
                "287419635",
                "345286179"
        };
        String[] actual = sudokuSolver(new String[]{
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"
        });
        Assert.assertTrue(Arrays.equals(expect, actual));
    }

    @Test
    public void testValidSudoku(){
        Assert.assertTrue(validSudoku(new String[]{
                ".87654321",
                "2........",
                "3........",
                "4........",
                "5........",
                "6........",
                "7........",
                "8........",
                "9........"
        }));
    }

    @Test
    public void testSearchInsertPosition(){
        int[] nums = new int[]{1, 3, 5, 6};
        Assert.assertEquals(2, searchInsertPosition(nums, 5));
        Assert.assertEquals(1, searchInsertPosition(nums, 2));
        Assert.assertEquals(4, searchInsertPosition(nums, 7));
        Assert.assertEquals(0, searchInsertPosition(nums, 0));
    }

    @Test
    public void testSearchForARange(){
        Assert.assertTrue(Arrays.equals(new int[]{-1, -1}, searchForARange(new int[0], 2)));
        Assert.assertTrue(Arrays.equals(new int[]{3, 4},
                searchForARange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    @Test
    public void testPermutationII(){
        List<List<Integer>> result;
        result = permutationII(new int[]{1, 1, 2});
        Assert.assertTrue(result.size() == 3);
    }

    @Test
    public void testCombinations(){
        List<List<Integer>> list;

        list = combinations(4, 0);
        Assert.assertTrue(list.size() == 1);

        list = combinations(4, 1);
        Assert.assertTrue(list.size() == 4);

        list = combinations(4, 2);
        Assert.assertTrue(list.size() == 6);

        list = combinations(4, 3);
        Assert.assertTrue(list.size() == 4);

        list = combinations(4, 4);
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void testPermutationSequence(){
        Assert.assertEquals("1", permutationSequence(1, 1));
        Assert.assertEquals("123", permutationSequence(3, 1));
        Assert.assertEquals("132", permutationSequence(3, 2));
        Assert.assertEquals("213", permutationSequence(3, 3));
        Assert.assertEquals("231", permutationSequence(3, 4));
        Assert.assertEquals("312", permutationSequence(3, 5));
        Assert.assertEquals("321", permutationSequence(3, 6));
    }

    @Test
    public void testPermutation(){
        List<List<Integer>> result;

        result = permutation(new int[]{});
        Assert.assertTrue(result.size() == 0);

        result = permutation(new int[]{1});
        Assert.assertTrue(result.size() == 1);

        result = permutation(new int[]{1, 2});
        Assert.assertTrue(result.size() == 2);

        result = permutation(new int[]{1, 2, 3});
        Assert.assertTrue(result.size() == 6);

        result = permutation(new int[]{1, 1});
        Assert.assertTrue(result.size() == 1);

        result = permutation(new int[]{1, 1, 2});
        Assert.assertTrue(result.size() == 3);
    }

    @Test
    public void testNextPermutation(){
        Assert.assertTrue(Arrays.equals(new int[]{}, nextPermutation(new int[]{})));
        Assert.assertTrue(Arrays.equals(new int[]{1}, nextPermutation(new int[]{1})));
        Assert.assertTrue(Arrays.equals(new int[]{1, 3, 2}, nextPermutation(new int[]{1, 2, 3})));
        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 3}, nextPermutation(new int[]{3, 2, 1})));
        Assert.assertTrue(Arrays.equals(new int[]{1, 5, 1}, nextPermutation(new int[]{1, 1, 5})));
        Assert.assertTrue(Arrays.equals(new int[]{0, 0, 1}, nextPermutation(new int[]{1, 0, 0})));
        Assert.assertTrue(Arrays.equals(new int[]{2, 1, 3}, nextPermutation(new int[]{1, 3, 2})));
    }

    @Test
    public void testSubstringWithConcentationOfAllWords(){
        List<Integer> expect;
        List<Integer> actual;

        expect = Arrays.asList(0, 9);
        actual = substringWithConcentationOfAllWords("barfoothebarfooman", new String[]{ "foo", "bar" });
        Assert.assertEquals(expect, actual);

        expect = Collections.singletonList(8);
        actual = substringWithConcentationOfAllWords("wordgoodgoodgoodbestword", new String[]{
                "word", "good", "best", "good"
        });
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testDivideTwoIntegers(){
        Assert.assertEquals(3,divideTwoIntegers(12, 4));
        Assert.assertEquals(3,divideTwoIntegers(13, 4));
        Assert.assertEquals(Integer.MAX_VALUE,divideTwoIntegers(13, 0));
        Assert.assertEquals(-3,divideTwoIntegers(-12, 4));
        Assert.assertEquals(-3,divideTwoIntegers(12, -4));
        Assert.assertEquals(3,divideTwoIntegers(-12, -4));
        Assert.assertEquals(10,divideTwoIntegers(10, 1));
        Assert.assertEquals(Integer.MAX_VALUE - 2,divideTwoIntegers(Integer.MAX_VALUE - 2, 1));
        Assert.assertEquals(Integer.MAX_VALUE,divideTwoIntegers(Integer.MAX_VALUE, 1));
        Assert.assertEquals(Integer.MAX_VALUE,divideTwoIntegers(Integer.MIN_VALUE, -1));
    }

    @Test
    public void testDeleteNodeInALinkedList(){
        ListNode expect = ListNode.make(new int[]{1, 2, 4});
        ListNode actual = ListNode.make(new int[]{1, 2, 3, 4});
        deleteNodeInALinkedList(actual, 3);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testRemoveLinkedListElements(){
        ListNode expect;
        ListNode head;
        Assert.assertEquals(null, removeLinkedListElements(null, 6));

        head = ListNode.make(new int[]{1, 2, 6, 3, 4, 5, 6});
        expect = ListNode.make(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals(expect, removeLinkedListElements(head, 6));
    }

    @Test
    public void testRemoveElement(){
        int[] array;
        array = new int[]{1, 2, 2};
        Assert.assertEquals(2, removeElement(array, 1));
        Assert.assertTrue(Arrays.equals(new int[]{2, 2, 2}, array));

        array = new int[]{1, 2, 2};
        Assert.assertEquals(1, removeElement(array, 2));
        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 2}, array));

        array = new int[]{2, 2, 2};
        Assert.assertEquals(0, removeElement(array, 2));
        Assert.assertTrue(Arrays.equals(new int[]{2, 2, 2}, array));
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray(){
        Assert.assertEquals(0, removeDuplicatesFromSortedArray(new int[]{}));
        Assert.assertEquals(1, removeDuplicatesFromSortedArray(new int[]{1}));
        int[] array = new int[]{1, 1, 2};
        Assert.assertEquals(2, removeDuplicatesFromSortedArray(array));
        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 2}, array));
    }

    @Test
    public void testReverseNodesInKGroups(){
        ListNode expect;
        ListNode actual;

        expect = ListNode.make(new int[]{1, 2, 3, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 0);
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{1, 2, 3, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 1);
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{2, 1, 4, 3, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 2);
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{3, 2, 1, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 3);
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{4, 3, 2, 1, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 4);
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{5, 4, 3, 2, 1});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 5);
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{1, 2, 3, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 6);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSwapNodesInPairs(){
        ListNode expect;
        ListNode actual;

        expect = ListNode.make(new int[]{2, 1, 4, 3});
        actual = swapNodesInPairs(new int[]{1, 2, 3, 4});
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{2, 1, 3});
        actual = swapNodesInPairs(new int[]{1, 2, 3});
        Assert.assertEquals(expect, actual);

        expect = ListNode.make(new int[]{2, 1});
        actual = swapNodesInPairs(new int[]{1, 2});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFourSum(){
        Set<List<Integer>>  expect;
        Set<List<Integer>>  actual;
        expect = new HashSet<>();
        expect.add(Arrays.asList(-1, 0, 0, 1));
        expect.add(Arrays.asList(-2, -1, 1, 2));
        expect.add(Arrays.asList(-2, 0, 0, 2));
        actual = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        Assert.assertEquals(expect, actual);

        expect = new HashSet<>();
        expect.add(Arrays.asList(0, 0, 0, 0));
        actual = fourSum(new int[]{0, 0, 0, 0}, 0);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testCombinationSum(){
        Set<List<Integer>>  expect;
        expect = new HashSet<>();
        expect.add(Arrays.asList(2, 2, 3));
        expect.add(Collections.singletonList(7));
        Set<List<Integer>> actual;
        actual = combinationSum(new int[]{2, 3, 6, 7}, 7);
        Assert.assertEquals(expect, actual);

        actual = combinationSum(new int[]{}, 7);
        Assert.assertTrue(actual.isEmpty());

        actual = combinationSum(new int[]{2, 2}, 7);
        Assert.assertTrue(actual.isEmpty());

        expect = new HashSet<>();
        expect.add(Arrays.asList(1,1,1,1));
        expect.add(Arrays.asList(1,1,2));
        expect.add(Arrays.asList(2, 2));
        actual = combinationSum(new int[]{1,1,1,1,2}, 4);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testGenerateParentheses(){
        Assert.assertTrue(generateParentheses(0).size() == 1);
        Assert.assertTrue(generateParentheses(1).size() == 1);
        Assert.assertTrue(generateParentheses(2).size() == 2);
        Assert.assertTrue(generateParentheses(3).size() == 5);
    }

    @Test
    public void testLetterCombinationsOfAPhoneNumber(){
        List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actual = letterCombinationsOfAPhoneNumber("23");
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testThreeSumClosest(){
        Assert.assertEquals(2, threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    @Test
    public void testThreeSum(){
        Set<List<Integer>> expect;
        expect = new HashSet<>();
        expect.add(new ArrayList<Integer>() {{
            add(-1);add(0);add(1);
        }});
        expect.add(new ArrayList<Integer>(){{
            add(-1); add(-1); add(2);
        }});
        Set<List<Integer>> actual = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testRegularExpressionMatching(){
        Assert.assertFalse(regularExpressionMatching("aa", "a"));
        Assert.assertTrue(regularExpressionMatching("aa", "aa"));
        Assert.assertFalse(regularExpressionMatching("aaa", "aa"));
        Assert.assertTrue(regularExpressionMatching("aa", "a*"));
        Assert.assertTrue(regularExpressionMatching("aa", ".*"));
        Assert.assertTrue(regularExpressionMatching("ab", ".*"));
        Assert.assertTrue(regularExpressionMatching("aab", "c*a*b"));

        Assert.assertTrue(regularExpressionMatching("", ""));
        Assert.assertTrue(regularExpressionMatching("abcdeff", ".*"));
        Assert.assertTrue(regularExpressionMatching("a", "ab*"));
        Assert.assertFalse(regularExpressionMatching("bb", ".bab"));
        Assert.assertFalse(regularExpressionMatching("ab", ".*c"));
        Assert.assertFalse(regularExpressionMatching("aaba", "ab*a*c*a"));
    }

    @Test
    public void testValidParentheses(){
        Assert.assertTrue(validParentheses(""));
        Assert.assertFalse(validParentheses("]"));
        Assert.assertTrue(validParentheses("{([])}"));
        Assert.assertFalse(validParentheses("(()"));
        Assert.assertFalse(validParentheses("(]"));
        Assert.assertFalse(validParentheses("([)]"));
    }

    @Test
    public void testRemoveNthNodeFromEndofList(){
        ListNode origin;
        ListNode expect;

        origin = ListNode.make(new int[]{1, 2, 3});
        expect = ListNode.make(new int[]{1, 2});
        Assert.assertEquals(expect, removeNthNodeFromEndofList(origin, 1));

        origin = ListNode.make(new int[]{1, 2, 3});
        expect = ListNode.make(new int[]{1, 3});
        Assert.assertEquals(expect, removeNthNodeFromEndofList(origin, 2));

        origin = ListNode.make(new int[]{1, 2, 3});
        expect = ListNode.make(new int[]{2, 3});
        Assert.assertEquals(expect, removeNthNodeFromEndofList(origin, 3));

        origin = ListNode.make(new int[]{1});
        Assert.assertEquals(null, removeNthNodeFromEndofList(origin, 1));
    }

    @Test
    public void testLongestCommonPrefix(){
        String[] strs = new String[]{"abcdefhijk", "abcm", "ab","abcde"};
        Assert.assertEquals("ab", longestCommonPrefix(strs));

        strs = new String[]{};
        Assert.assertEquals("", longestCommonPrefix(strs));

        strs = new String[]{"abc"};
        Assert.assertEquals("abc",longestCommonPrefix(strs));
    }

    @Test
    public void testRomainToInteger(){
        Assert.assertEquals(3943, romainToInteger("MMMCMXLIII"));
        Assert.assertEquals(86, romainToInteger("LXXXVI"));
    }

    @Test
    public void testIntegerToRomain(){
        Assert.assertEquals("MMMCMXLIII", integerToRomain(3943));
        Assert.assertEquals("LXXXVI", integerToRomain(86));
    }

    @Test
    public void testContainerWithMostWater(){
        int rst;
        rst = containerWithMostWater(new int[]{3, 4, 2, 1});
        Assert.assertTrue(4 == rst);
    }

    @Test
    public void testReverseLinkedList(){
        ListNode expect = ListNode.make(new int[]{1, 2});
        ListNode actual = reverseLinkedList(new int[]{2, 1});
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void testPalindromeLinkedList(){
        Assert.assertTrue(palindromeLinkedList(new int[]{1}));
        Assert.assertTrue(palindromeLinkedList(new int[]{1, 2, 1}));
        Assert.assertTrue(palindromeLinkedList(new int[]{1, 2, 2, 1}));
        Assert.assertFalse(palindromeLinkedList(new int[]{1, 2, 3, 1, 1}));
    }

    @Test
    public void testPalindromeNumber(){
        Assert.assertFalse(palindromeNumber(-1));
        Assert.assertFalse(palindromeNumber(-12));
        Assert.assertFalse(palindromeNumber(Integer.MIN_VALUE));
        Assert.assertTrue(palindromeNumber(2442));
    }

    @Test
    public void testValidNumber(){
        Assert.assertFalse(validNumber("959440.94f"));
        Assert.assertTrue(validNumber("3."));
        Assert.assertFalse(validNumber("3.."));
    }

    @Test
    public void testStringToInteger(){
        Assert.assertTrue(10 == stringToInteger("   010"));
        Assert.assertTrue(0 == stringToInteger(""));
        Assert.assertTrue(-12 == stringToInteger("-12u"));
        Assert.assertTrue(Integer.MAX_VALUE == stringToInteger(Integer.MAX_VALUE + "4"));
        Assert.assertTrue(Integer.MIN_VALUE == stringToInteger(Integer.MIN_VALUE + "4"));
        Assert.assertTrue(Integer.MIN_VALUE == stringToInteger(Integer.MIN_VALUE + ""));
        Assert.assertTrue(0 == stringToInteger(" b11228552307"));
        Assert.assertTrue(0 == stringToInteger("+-2"));
    }

    @Test
    public void testReverseInteger(){
        Assert.assertTrue(321 == reverseInteger(123));
        Assert.assertTrue(-321 == reverseInteger(-123));
        Assert.assertTrue(-1 == reverseInteger(-1));
        Assert.assertTrue(0 == reverseInteger(0));
        Assert.assertTrue(0 == reverseInteger(Integer.MAX_VALUE));
        Assert.assertTrue(0 == reverseInteger(Integer.MIN_VALUE));
        Assert.assertTrue(1 == reverseInteger(100));
    }

    @Test
    public void testLongestPalindromicSubstring(){
        String rst;
        rst = longestPalindromicSubstring("");
        Assert.assertEquals("",rst);

        rst = longestPalindromicSubstring("a");
        Assert.assertEquals("a",rst);

        rst = longestPalindromicSubstring("aa");
        Assert.assertEquals("aa",rst);

        rst = longestPalindromicSubstring("ab");
        Assert.assertEquals("a",rst);

        rst = longestPalindromicSubstring("abad");
        Assert.assertEquals("aba",rst);

        rst = longestPalindromicSubstring("dabace");
        Assert.assertEquals("aba",rst);

        rst = longestPalindromicSubstring("aaaa");
        Assert.assertEquals("aaaa",rst);
    }

    @Test
    public void testZigZagConversation(){
        String rst;
        rst = zigZagConversation("PAYPALISHIRING", 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", rst);

        rst = zigZagConversation("PAYPALISHIRING", 1);
        Assert.assertEquals("PAYPALISHIRING", rst);
    }

    @Test
    public void testAddDigit(){
        Assert.assertTrue(2 == addDigit(38));
        Assert.assertTrue(0 == addDigit(0));
        Assert.assertTrue(9 == addDigit(9));
    }

    @Test
    public void testHappyNumber(){
        Assert.assertTrue(isHappy(19));
    }

    @Test
    public void testUglyNumber(){
        Assert.assertTrue(isUgly(6));
        Assert.assertTrue(isUgly(8));
        Assert.assertTrue(!isUgly(14));
        Assert.assertTrue(!isUgly(0));
    }

    @Test
    public void testMergeKSortedLists(){
        ListNode expect = ListNode.make(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNode actual = mergeKSortedLists(new int[][]{{1, 5, 7}, {6, 8}, {2, 3}, {4, 9}});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testMergeTwoSortedList(){
        ListNode expect = ListNode.make(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        ListNode actual = mergeTwoSortedList(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testMergeSortedArray(){
        int[] nums1 = new int[100];
        nums1[0] = 1; nums1[1] = 3; nums1[2] = 5; nums1[3] = 7; nums1[4] = 9;
        mergeSortedArray(nums1, 5, new int[]{2, 4, 6, 8}, 4);
    }

    @Test
    public void testMedianOfTwoSortedArrays(){
        double rst;
        rst = medianOfTwoSortedArrays(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10});
        Assert.assertTrue(5.5 == rst);

        rst = medianOfTwoSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5});
        Assert.assertTrue(3 == rst);

        rst = medianOfTwoSortedArrays(new int[]{5}, new int[]{1, 2, 3, 4});
        Assert.assertTrue(3 == rst);

        rst = medianOfTwoSortedArrays(new int[]{2, 3, 4, 5, 6}, new int[]{1});
        Assert.assertTrue(3.5 == rst);

        rst = medianOfTwoSortedArrays(new int[]{1, 2}, new int[]{1, 2});
        Assert.assertTrue(1.5 == rst);
    }

    @Test
    public void testLongestSubstringWithoutRepeatingCharacters(){
        int rst;
        rst = longestSubstringWithoutRepeatingCharacters("abcabcbb");
        Assert.assertEquals(3,rst);

        rst = longestSubstringWithoutRepeatingCharacters("bbbbb");
        Assert.assertEquals(1,rst);

        rst = longestSubstringWithoutRepeatingCharacters("abcd");
        Assert.assertEquals(4,rst);

        longestSubstringWithoutRepeatingCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCD");
    }


    @Test
    public  void  testPlusOne(){
        String rst;
        rst = plusOne(new int[]{9,9,9});
        Assert.assertEquals("1000", rst);

        rst = plusOne(new int[]{1,0});
        Assert.assertEquals("11", rst);
    }

    @Test
    public void testMultiplyString(){
        String rst ;
        rst = multiplyString("25", "25");
        Assert.assertEquals("625", rst);

        rst = multiplyString("0", "0");
        Assert.assertEquals("0", rst);

        rst = multiplyString("0", "1");
        Assert.assertEquals("0", rst);

        rst = multiplyString("256", "16");
        Assert.assertEquals("4096", rst);

        rst = multiplyString("123", "456");
        Assert.assertEquals("56088", rst);
    }


    @Test
    public void testAddBinary(){
        String rst;
        rst = addBinary("11","1");
        Assert.assertEquals("100",rst);

        rst = addBinary("0","0");
        Assert.assertEquals("0",rst);
    }

    @Test
    public void testTwoSum(){
        int[] rst;
        rst = twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, rst));
    }

    @Test
    public void testAddTwoNumbers(){
        ListNode rst;
        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6, 4});
        Assert.assertEquals(ListNode.make(new int[]{7, 0, 8}),rst);

        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6});
        Assert.assertEquals(ListNode.make(new int[]{7, 0, 4}),rst);

        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6, 6});
        Assert.assertEquals(ListNode.make(new int[]{7, 0, 0, 1}),rst);
    }

    private  int[] twoSum(int[] nums , int target){
        cn.idear.algorithm.two_sum.Solution solution = new cn.idear.algorithm.two_sum.Solution();
        return solution.twoSum(nums, target);
    }

    private  ListNode addTwoNumbers(int[] l1, int[] l2){
        ListNode n1 = ListNode.make(l1);
        ListNode n2 = ListNode.make(l2);
        cn.idear.algorithm.add_two_numbers.Solution solution = new cn.idear.algorithm.add_two_numbers.Solution();
        return  solution.addTwoNumbers(n1, n2);
    }

    private  String addBinary(String a, String b){
        cn.idear.algorithm.add_binary.Solution solution = new cn.idear.algorithm.add_binary.Solution();
        return solution.addBinary(a,b);
    }

    private String multiplyString(String num1, String num2) {
        cn.idear.algorithm.multiply_string.Solution solution = new cn.idear.algorithm.multiply_string.Solution();
        return solution.multiply(num1,num2);
    }

    private String plusOne(int[] digits) {
        cn.idear.algorithm.plus_one.Solution solution = new cn.idear.algorithm.plus_one.Solution();
        int[] rst = solution.plusOne(digits);
        String str = "";
        for (int aRst : rst) str += aRst;
        return str;
    }

    private int longestSubstringWithoutRepeatingCharacters(String s) {
        cn.idear.algorithm.longest_substring_without_repeating_characters.Solution solution =
                new cn.idear.algorithm.longest_substring_without_repeating_characters.Solution();
        return solution.lengthOfLongestSubstring(s);
    }

    private double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        cn.idear.algorithm.median_of_two_sorted_arrays.Solution solution =
                new cn.idear.algorithm.median_of_two_sorted_arrays.Solution();
        return solution.findMedianSortedArrays(nums1,nums2);
    }

    private void mergeSortedArray(int[] ints, int m, int[] ints1, int n) {
        cn.idear.algorithm.merge_sorted_array.Solution solution = new cn.idear.algorithm.merge_sorted_array.Solution();
        solution.merge(ints, m, ints1, n);
    }

    private ListNode mergeTwoSortedList(int[] nums1, int[] nums2) {
        ListNode l1 = ListNode.make(nums1);
        ListNode l2 = ListNode.make(nums2);
        cn.idear.algorithm.merge_two_sorted_lists.Solution solution = new cn.idear.algorithm.merge_two_sorted_lists.Solution();
        return solution.mergeTwoLists(l1, l2);
    }

    private ListNode mergeKSortedLists(int[][] ints) {
        ListNode[] list = new ListNode[ints.length];
        for(int i = 0; i < ints.length; i++)
            list[i] = ListNode.make(ints[i]);
        cn.idear.algorithm.merge_k_sorted_lists.Solution solution =
                new cn.idear.algorithm.merge_k_sorted_lists.Solution();
        return solution.mergeKLists(list);
    }

    private boolean isUgly(int num){
        cn.idear.algorithm.ugly_number.Solution solution = new cn.idear.algorithm.ugly_number.Solution();
        return solution.isUgly(num);
    }

    private boolean isHappy(int n) {
        Solution solution = new Solution();
        return solution.isHappy(n);
    }

    private int addDigit(int num) {
        cn.idear.algorithm.add_digits.Solution solution = new cn.idear.algorithm.add_digits.Solution();
        return solution.addDigits(num);
    }

    private String zigZagConversation(String s, int numRows) {
        cn.idear.algorithm.zigzag_conversation.Solution solution =
                new cn.idear.algorithm.zigzag_conversation.Solution();
        return solution.convert(s,numRows);
    }

    private String longestPalindromicSubstring(String s) {
        cn.idear.algorithm.longest_palindromic_substring.Solution solution =
                new cn.idear.algorithm.longest_palindromic_substring.Solution();
        return solution.longestPalindrome(s);
    }

    private int reverseInteger(int num) {
        cn.idear.algorithm.reverse_integer.Solution solution =
                new cn.idear.algorithm.reverse_integer.Solution();
        return solution.reverse(num);
    }

    private int stringToInteger(String s) {
        cn.idear.algorithm.string_to_integer.Solution solution = new cn.idear.algorithm.string_to_integer.Solution();
        return solution.myAtoi(s);
    }

    private boolean validNumber(String s) {
        cn.idear.algorithm.valid_number.Solution solution = new cn.idear.algorithm.valid_number.Solution();
        return solution.isNumber(s);
    }

    private boolean palindromeNumber(int x) {
        cn.idear.algorithm.palindrome_number.Solution solution = new cn.idear.algorithm.palindrome_number.Solution();
        return solution.isPalindrome(x);
    }

    private boolean palindromeLinkedList(int[] nums) {
        cn.idear.algorithm.palindrome_linked_list.Solution solution =
                new cn.idear.algorithm.palindrome_linked_list.Solution();
        ListNode head = ListNode.make(nums);
        return solution.isPalindrome(head);
    }

    private ListNode reverseLinkedList(int[] nums) {
        cn.idear.algorithm.reverse_linked_list.Solution solution =
                new cn.idear.algorithm.reverse_linked_list.Solution();
        return solution.reverseList(ListNode.make(nums));
    }

    private int containerWithMostWater(int[] nums) {
        cn.idear.algorithm.container_with_most_water.Solution solution =
                new cn.idear.algorithm.container_with_most_water.Solution();
        return solution.maxArea(nums);
    }

    private String integerToRomain(int num) {
        cn.idear.algorithm.integer_to_roman.Solution solution =
                new cn.idear.algorithm.integer_to_roman.Solution();
        return solution.intToRoman(num);
    }

    private int romainToInteger(String romain) {
        cn.idear.algorithm.roman_to_integer.Solution solution =
                new cn.idear.algorithm.roman_to_integer.Solution();
        return solution.romanToInt(romain);
    }

    private String longestCommonPrefix(String[] strs) {
        cn.idear.algorithm.longest_common_prefix.Solution solution =
                new cn.idear.algorithm.longest_common_prefix.Solution();
        return solution.longestCommonPrefix(strs);
    }

    private ListNode removeNthNodeFromEndofList(ListNode origin, int n) {
        cn.idear.algorithm.remove_nth_node_from_end_of_list.Solution solution =
                new cn.idear.algorithm.remove_nth_node_from_end_of_list.Solution();
        return solution.removeNthFromEnd(origin, n);
    }

    private boolean validParentheses(String s) {
        cn.idear.algorithm.valid_parentheses.Solution solution =
                new cn.idear.algorithm.valid_parentheses.Solution();
        return solution.isValid(s);
    }

    private boolean regularExpressionMatching(String s, String p) {
        cn.idear.algorithm.regular_expression_matching.Solution solution =
                new cn.idear.algorithm.regular_expression_matching.Solution();
        return solution.isMatch(s, p);
    }

    private Set<List<Integer>> threeSum(int[] ints) {
        cn.idear.algorithm.three_sum.Solution solution = new cn.idear.algorithm.three_sum.Solution();
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(solution.threeSum(ints));
        return set;
    }

    private int threeSumClosest(int[] nums, int target) {
        cn.idear.algorithm.three_sum_closest.Solution solution =
                new cn.idear.algorithm.three_sum_closest.Solution();
        return solution.threeSumClosest(nums, target);
    }

    private List<String> letterCombinationsOfAPhoneNumber(String s) {
        cn.idear.algorithm.letter_combinations_of_a_phone_number.Solution solution =
                new cn.idear.algorithm.letter_combinations_of_a_phone_number.Solution();
        return solution.letterCombinations(s);
    }

    private List<String> generateParentheses(int num) {
        cn.idear.algorithm.generate_parentheses.Solution solution =
                new cn.idear.algorithm.generate_parentheses.Solution();
        return solution.generateParenthesis(num);
    }

    private Set<List<Integer>> combinationSum(int[] candidates, int target) {
        cn.idear.algorithm.combination_sum.Solution solution =
                new cn.idear.algorithm.combination_sum.Solution();
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(solution.combinationSum(candidates, target));
        return set;
    }

    private Set<List<Integer>> fourSum(int[] nums, int target) {
        cn.idear.algorithm.four_sum.Solution solution =
                new cn.idear.algorithm.four_sum.Solution();
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(solution.fourSum(nums, target));
        return set;
    }

    private ListNode swapNodesInPairs(int[] nums) {
        cn.idear.algorithm.swap_nodes_in_pairs.Solution solution =
                new cn.idear.algorithm.swap_nodes_in_pairs.Solution();
        return solution.swapPairs(ListNode.make(nums));
    }

    private ListNode reverseNodesInKGroups(int[] nums, int k) {
        cn.idear.algorithm.reverse_nodes_in_k_group.Solution solution =
                new cn.idear.algorithm.reverse_nodes_in_k_group.Solution();
        return solution.reverseKGroup(ListNode.make(nums), k);
    }

    private int removeDuplicatesFromSortedArray(int[] nums) {
        cn.idear.algorithm.remove_duplicates_from_sorted_array.Solution solution
                = new cn.idear.algorithm.remove_duplicates_from_sorted_array.Solution();
        return solution.removeDuplicates(nums);
    }

    private int removeElement(int[] array, int num) {
        cn.idear.algorithm.remove_element.Solution solution =
                new cn.idear.algorithm.remove_element.Solution();
        return solution.removeElement(array, num);
    }

    private ListNode removeLinkedListElements(ListNode head, int val) {
        cn.idear.algorithm.remove_linked_list_elements.Solution solution =
                new cn.idear.algorithm.remove_linked_list_elements.Solution();
        return solution.removeElements(head, val);
    }

    private void deleteNodeInALinkedList(ListNode head, int k) {
        ListNode toDelete = head;
        for(int i = 0; i < k - 1; i++)
           toDelete = toDelete.next;
        cn.idear.algorithm.delete_node_in_a_linked_list.Solution solution =
                new cn.idear.algorithm.delete_node_in_a_linked_list.Solution();
        solution.deleteNode(toDelete);
    }

    private int divideTwoIntegers(int dividend, int divisor) {
        cn.idear.algorithm.divide_two_integers.Solution solution =
                new cn.idear.algorithm.divide_two_integers.Solution();
        return solution.divide(dividend, divisor);
    }

    private List<Integer> substringWithConcentationOfAllWords(String s, String[] dict) {
        cn.idear.algorithm.substring_with_concatenation_of_all_words.Solution solution
                = new cn.idear.algorithm.substring_with_concatenation_of_all_words.Solution();
        return solution.findSubstring(s, dict);
    }

    private int[] nextPermutation(int[] nums) {
        cn.idear.algorithm.next_permutation.Solution solution =
                new cn.idear.algorithm.next_permutation.Solution();
        solution.nextPermutation(nums);
        return nums;
    }

    private List<List<Integer>> permutation(int[] nums) {
        cn.idear.algorithm.permutation.Solution solution = new cn.idear.algorithm.permutation.Solution();
        return solution.permute(nums);
    }

    private String permutationSequence(int n, int k) {
        cn.idear.algorithm.permutation_sequence.Solution solution =
                new cn.idear.algorithm.permutation_sequence.Solution();
        return solution.getPermutation(n, k);
    }

    private List<List<Integer>> combinations(int n, int k) {
        cn.idear.algorithm.combinations.Solution solution =
                new cn.idear.algorithm.combinations.Solution();
        return solution.combine(n, k);
    }

    private List<List<Integer>> permutationII(int[] nums) {
        cn.idear.algorithm.permutation_ii.Solution solution =
                new cn.idear.algorithm.permutation_ii.Solution();
        return solution.permuteUnique(nums);
    }

    private int[] searchForARange(int[] nums, int target) {
        cn.idear.algorithm.search_for_a_range.Solution solution =
                new cn.idear.algorithm.search_for_a_range.Solution();
        return solution.searchRange(nums, target);
    }

    private int searchInsertPosition(int[] nums, int target) {
        cn.idear.algorithm.search_insert_position.Solution solution =
                new cn.idear.algorithm.search_insert_position.Solution();
        return solution.searchInsert(nums, target);
    }

    private boolean validSudoku(String[] strings) {
        char[][] board = new char[9][9];
        for(int i = 0; i < 9; i++)
            board[i] = strings[i].toCharArray();
        cn.idear.algorithm.valid_sudoku.Solution solution =
                new cn.idear.algorithm.valid_sudoku.Solution();
        return solution.isValidSudoku(board);
    }

    private String[] sudokuSolver(String[] strings) {
        char[][] board = new char[9][9];
        for(int i = 0; i < 9; i++)
            board[i] = strings[i].toCharArray();
        cn.idear.algorithm.sudoku_solver.Solution solution =
                new cn.idear.algorithm.sudoku_solver.Solution();
        solution.solveSudoku(board);
        for(int i = 0; i < 9; i++)
            strings[i] = new String(board[i]);
        return strings;
    }

    private String countAndSay(int n) {
        cn.idear.algorithm.count_and_say.Solution solution =
                new cn.idear.algorithm.count_and_say.Solution();
        return solution.countAndSay(n);
    }

    private int longestValidParenthesis(String s) {
        cn.idear.algorithm.longeset_valid_parenthesis.Solution solution =
                new cn.idear.algorithm.longeset_valid_parenthesis.Solution();
        return solution.longestValidParentheses(s);
    }

    private int searchInRotatedSortedArray(int[] nums, int target) {
        cn.idear.algorithm.search_in_rotated_sorted_array.Solution solution =
                new cn.idear.algorithm.search_in_rotated_sorted_array.Solution();
        return solution.search(nums, target);
    }

    private boolean searchInRotatedSortedArrayII(int[] nums, int target) {
        cn.idear.algorithm.search_in_rotated_sorted_array_ii.Solution solution =
                new cn.idear.algorithm.search_in_rotated_sorted_array_ii.Solution();
        return solution.search(nums, target);
    }

    private int findMinimusInRotatedSortedArray(int[] nums) {
        cn.idear.algorithm.find_minimum_in_rotated_sorted_array.Solution solution =
                new cn.idear.algorithm.find_minimum_in_rotated_sorted_array.Solution();
        return solution.findMin(nums);
    }

    private int findMinimusInRotatedSortedArrayII(int[] nums) {
        cn.idear.algorithm.find_minimum_in_rotated_sorted_array_ii.Solution solution =
                new cn.idear.algorithm.find_minimum_in_rotated_sorted_array_ii.Solution();
        return solution.findMin(nums);
    }

    private int firstMissingPositive(int[] nums) {
        cn.idear.algorithm.first_missing_positive.Solution solution =
                new cn.idear.algorithm.first_missing_positive.Solution();
        return solution.firstMissingPositive(nums);
    }

    private int missingNumber(int[] nums) {
        cn.idear.algorithm.missing_number.Solution solution =
                new cn.idear.algorithm.missing_number.Solution();
        return solution.missingNumber(nums);
    }

    private boolean wildcardExpressionMatching(String s, String p) {
        cn.idear.algorithm.wildcard_matching.Solution solution =
                new cn.idear.algorithm.wildcard_matching.Solution();
        return solution.isMatch(s, p);
    }

    private int[][] rotateImage(int[][] matrix) {
        cn.idear.algorithm.rotate_image.Solution solution =
                new cn.idear.algorithm.rotate_image.Solution();
        solution.rotate(matrix);
        return matrix;
    }

    private TwoLevelList<String> groupAnagrams(String[] strings) {
        cn.idear.algorithm.group_anagrams.Solution solution =
                new cn.idear.algorithm.group_anagrams.Solution();
        return TwoLevelList.make(solution.groupAnagrams(strings));
    }

    private double myPowXN(double x, int n) {
        cn.idear.algorithm.pow_x_n.Solution solution =
                new cn.idear.algorithm.pow_x_n.Solution();
        return solution.myPow(x, n);
    }

    private int trappingRainWater(int[] nums) {
        cn.idear.algorithm.trapping_rain_water.Solution solution =
                new cn.idear.algorithm.trapping_rain_water.Solution();
        return solution.trap(nums);
    }

    private int jumpGameII(int[] nums) {
        cn.idear.algorithm.jump_game_ii.Solution solution =
                new cn.idear.algorithm.jump_game_ii.Solution();
        return solution.jump(nums);
    }

    private TwoLevelList<String> nQueens(int n) {
        cn.idear.algorithm.n_queens.Solution solution =
                new cn.idear.algorithm.n_queens.Solution();
        return TwoLevelList.make(solution.solveNQueens(n));
    }

    private int nQueensII(int n) {
        cn.idear.algorithm.n_queens_ii.Solution solution =
                new cn.idear.algorithm.n_queens_ii.Solution();
        return solution.totalNQueens(n);
    }

    private int maximumSubarray(int[] nums) {
        cn.idear.algorithm.maximum_subarray.Solution solution =
                new cn.idear.algorithm.maximum_subarray.Solution();
        return solution.maxSubArray(nums);
    }

    private List<Integer> spiralMatrix(int[][] nums) {
        cn.idear.algorithm.spiral_matrix.Solution solution =
                new cn.idear.algorithm.spiral_matrix.Solution();
        return solution.spiralOrder(nums);
    }

    private int[][] sprialMatrixII(int n) {
        cn.idear.algorithm.spiral_matrix_ii.Solution solution =
                new cn.idear.algorithm.spiral_matrix_ii.Solution();
        return solution.generateMatrix(n);
    }

    private int lengthOfLastWord(String s) {
        cn.idear.algorithm.length_of_last_word.Solution solution =
                new cn.idear.algorithm.length_of_last_word.Solution();
        return solution.lengthOfLastWord(s);
    }

    private ListNode rotateList(int[] nums, int k) {
        ListNode head = ListNode.make(nums);
        cn.idear.algorithm.rotate_list.Solution solution =
                new cn.idear.algorithm.rotate_list.Solution();
        return solution.rotateRight(head, k);
    }

    private int[] rotateArray(int[] nums, int k) {
        cn.idear.algorithm.rotate_array.Solution solution =
                new cn.idear.algorithm.rotate_array.Solution();
        solution.rotate(nums, k);
        return nums;
    }

    private int uniquePaths(int m, int n) {
        cn.idear.algorithm.unique_paths.Solution solution =
                new cn.idear.algorithm.unique_paths.Solution();
        return solution.uniquePaths(m, n);
    }

    private int uniquePathsII(int[][] nums) {
        cn.idear.algorithm.unique_paths_ii.Solution solution =
                new cn.idear.algorithm.unique_paths_ii.Solution();
        int rst = solution.uniquePathsWithObstacles(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.println(Arrays.toString(nums[i]));
        return rst;
    }

    private int minimumPathSum(int[][] grid) {
        cn.idear.algorithm.minimum_path_sum.Solution solution =
                new cn.idear.algorithm.minimum_path_sum.Solution();
        int rst = solution.minPathSum(grid);
        for(int i = 0; i < grid.length; i++)
            System.out.println(Arrays.toString(grid[i]));
        return rst;
    }

    private boolean jumpGame(int[] nums) {
        cn.idear.algorithm.jump_game.Solution solution =
                new cn.idear.algorithm.jump_game.Solution();
        return solution.canJump(nums);
    }

    private List<Interval> mergeIntervals(int[][] nums) {
        List<Interval> intervals = Interval.createIntervals(nums);
        cn.idear.algorithm.merge_intervals.Solution solution =
                new cn.idear.algorithm.merge_intervals.Solution();
        return solution.merge(intervals);
    }

    private List<String> textJustification(String[] words, int maxWidth) {
        cn.idear.algorithm.text_justification.Solution solution =
                new cn.idear.algorithm.text_justification.Solution();
        return solution.fullJustify(words, maxWidth);
    }

    private int mySqrt(int x) {
        cn.idear.algorithm.sqrt_x.Solution solution =
                new cn.idear.algorithm.sqrt_x.Solution();
        return solution.mySqrt(x);
    }

    private int climbingStairs(int n) {
        cn.idear.algorithm.climbing_stairs.Solution solution =
                new cn.idear.algorithm.climbing_stairs.Solution();
        return solution.climbStairs(n);
    }

    private String simplifyPath(String s) {
        cn.idear.algorithm.simplify_path.Solution solution =
                new cn.idear.algorithm.simplify_path.Solution();
        return solution.simplifyPath(s);
    }

    private int[][] setMatrixZeros(int[][] matrix) {
        cn.idear.algorithm.set_matrix_zeros.Solution solution =
                new cn.idear.algorithm.set_matrix_zeros.Solution();
        solution.setZeroes(matrix);
        return matrix;
    }

    private boolean searchA2DMatrix(int[][] matrix, int target) {
        cn.idear.algorithm.search_a_2d_matrix.Solution solution =
                new cn.idear.algorithm.search_a_2d_matrix.Solution();
        return solution.searchMatrix(matrix, target);
    }

    private boolean searchA2DMatrixII(int[][] matrix, int target) {
        cn.idear.algorithm.search_a_2d_matrix_ii.Solution solution =
                new cn.idear.algorithm.search_a_2d_matrix_ii.Solution();
        return solution.searchMatrix(matrix, target);
    }

    private ListNode removeDuplicatesFromSortedListII(int[] nums) {
        cn.idear.algorithm.remove_duplicates_from_sorted_list_ii.Solution solution =
                new cn.idear.algorithm.remove_duplicates_from_sorted_list_ii.Solution();
        return solution.deleteDuplicates(ListNode.make(nums));
    }

    private int removeDuplicatesFromSortedArrayII(int[] nums) {
        cn.idear.algorithm.remove_duplicates_from_sorted_array_ii.Solution solution =
                new cn.idear.algorithm.remove_duplicates_from_sorted_array_ii.Solution();
        return solution.removeDuplicates(nums);
    }

    private TwoLevelList<Integer> subsets(int[] nums) {
        cn.idear.algorithm.subsets.Solution solution =
                new cn.idear.algorithm.subsets.Solution();
        return TwoLevelList.make(solution.subsets(nums));
    }

    private ListNode partition(int[] nums, int x) {
        cn.idear.algorithm.partition_list.Solution solution =
                new cn.idear.algorithm.partition_list.Solution();
        return solution.partition(ListNode.make(nums), x);
    }

    private List<Integer> grayCode(int n) {
        cn.idear.algorithm.gray_code.Solution solution =
                new cn.idear.algorithm.gray_code.Solution();
        return solution.grayCode(n);
    }

    private int largestRectangleInHistogram(int[] nums) {
        cn.idear.algorithm.largest_rectangle_in_histogram.Solution solution =
                new cn.idear.algorithm.largest_rectangle_in_histogram.Solution();
        return  solution.largestRectangleArea(nums);
    }

    private ListNode reverseLinkedListII(int[] nums, int m, int n) {
        cn.idear.algorithm.reverse_linked_list_ii.Solution solution =
                new cn.idear.algorithm.reverse_linked_list_ii.Solution();
        return solution.reverseBetween(ListNode.make(nums), m, n);
    }

    private int decodeWays(String s) {
        cn.idear.algorithm.decode_ways.Solution solution =
                new cn.idear.algorithm.decode_ways.Solution();
        return solution.numDecodings(s);
    }

    private TwoLevelList<Integer> subsetsII(int[] nums) {
        cn.idear.algorithm.subsets_ii.Solution solution =
                new cn.idear.algorithm.subsets_ii.Solution();
        return TwoLevelList.make(solution.subsetsWithDup(nums));
    }

    private int editDistance(String word1, String word2) {
        cn.idear.algorithm.edit_distance.Solution solution =
                new cn.idear.algorithm.edit_distance.Solution();
        return solution.minDistance(word1, word2);
    }

    private int[] sortColors(int[] nums) {
        cn.idear.algorithm.sort_colors.Solution solution =
                new cn.idear.algorithm.sort_colors.Solution();
        solution.sortColors(nums);
        return nums;
    }

    private char[][] generateBoard(String[] strings) {
        if(strings.length == 0)
            return new char[0][];
        int m = strings.length;
        int n = strings[0].length();
        char[][] board = new char[m][n];
        for(int i = 0; i < m; i++)
            board[i] = strings[i].toCharArray();
        return board;
    }

    private boolean wordSearch(char[][] board, String word) {
        cn.idear.algorithm.word_search.Solution solution =
                new cn.idear.algorithm.word_search.Solution();
        return solution.exist(board, word);
    }

    private List<String> restoreIpAddress(String s) {
        cn.idear.algorithm.restore_ip_address.Solution solution =
                new cn.idear.algorithm.restore_ip_address.Solution();
        return solution.restoreIpAddresses(s);
    }

    private List<Integer> binaryTreeInorderTraversal(int[] nums) {
        cn.idear.algorithm.binary_tree_inorder_traversal.Solution solution =
                new cn.idear.algorithm.binary_tree_inorder_traversal.Solution();
        return solution.inorderTraversal(TreeNode.createTree(nums));
    }

    private List<Integer> binaryTreePreorderTraversal(int[] nums) {
        cn.idear.algorithm.binary_tree_preorder_traversal.Solution solution =
                new cn.idear.algorithm.binary_tree_preorder_traversal.Solution();
        return solution.preorderTraversal(TreeNode.createTree(nums));
    }

    private List<Integer> binaryTreePostorderTraversal(int[] nums) {
        cn.idear.algorithm.binary_tree_postorder_traversal.Solution solution =
                new cn.idear.algorithm.binary_tree_postorder_traversal.Solution();
        return solution.postorderTraversal(TreeNode.createTree(nums));
    }

    private int[] moveZeros(int[] nums) {
        cn.idear.algorithm.move_zeros.Solution solution =
                new cn.idear.algorithm.move_zeros.Solution();
        solution.moveZeroes(nums);
        return nums;
    }

    private int uniqueBinarySearchTree(int n) {
        cn.idear.algorithm.unique_binary_search_tree.Solution solution =
                new cn.idear.algorithm.unique_binary_search_tree.Solution();
        return solution.numTrees(n);
    }

    private List<TreeNode> uniqueBinarySearchTreeII(int n) {
        cn.idear.algorithm.unique_binary_search_trees_ii.Solution solution =
                new cn.idear.algorithm.unique_binary_search_trees_ii.Solution();
        return solution.generateTrees(n);
    }

    private boolean symmetricTree(int[] nums) {
        TreeNode root = TreeNode.createTree(nums);
        cn.idear.algorithm.symmetric_tree.Solution solution =
                new cn.idear.algorithm.symmetric_tree.Solution();
        return solution.isSymmetric(root);
    }

    private TwoLevelList<Integer> binaryTreeLevelOrderTraversal(int[] nums) {
        TreeNode root = TreeNode.createTree(nums);
        cn.idear.algorithm.binary_tree_level_order_traversal.Solution solution =
                new cn.idear.algorithm.binary_tree_level_order_traversal.Solution();
        return TwoLevelList.make(solution.levelOrder(root));
    }

    private TwoLevelList<Integer> binaryZigzagTreeLevelOrderTraversal(int[] nums) {
        cn.idear.algorithm.binary_tree_zigzag_level_order_traversal.Solution solution =
                new cn.idear.algorithm.binary_tree_zigzag_level_order_traversal.Solution();
        return TwoLevelList.make(solution.zigzagLevelOrder(TreeNode.createTree(nums)));
    }

    private int maximumDepthofBinaryTree(int[] nums) {
        cn.idear.algorithm.maximum_depth_of_binary_tree.Solution solution =
                new cn.idear.algorithm.maximum_depth_of_binary_tree.Solution();
        return solution.maxDepth(TreeNode.createTree(nums));
    }

    private TreeNode constructBinaryTreefromPreorderandInorderTraversal(int[] preorder, int[] inorder) {
        cn.idear.algorithm.construct_binary_tree_from_preorder_and_inorder_traversal.Solution solution =
                new cn.idear.algorithm.construct_binary_tree_from_preorder_and_inorder_traversal.Solution();
        return solution.buildTree(preorder, inorder);
    }

    private TreeNode constructBinaryTreeFromInOrderAndPostOrderTraversal(int[] inorder, int[] postorder) {
        cn.idear.algorithm.construct_binary_tree_from_inorder_and_postorder_traversal.Solution solution =
                new cn.idear.algorithm.construct_binary_tree_from_inorder_and_postorder_traversal.Solution();
        return solution.buildTree(inorder, postorder);
    }

    private TwoLevelList<Integer> binaryTreeLevelOrderTraversalII(int[] nums) {
        cn.idear.algorithm.binary_tree_level_order_traversal_ii.Solution solution =
                new cn.idear.algorithm.binary_tree_level_order_traversal_ii.Solution();
        return TwoLevelList.make(solution.levelOrderBottom(TreeNode.createTree(nums)));
    }

    private TreeNode convertSortedArrayToBinarySearchTree(int[] nums) {
        cn.idear.algorithm.convert_sorted_array_to_binary_search_tree.Solution solution =
                new cn.idear.algorithm.convert_sorted_array_to_binary_search_tree.Solution();
        return solution.sortedArrayToBST(nums);
    }

    private TreeNode convertSortedListToBinarySearchTree(int[] nums) {
        cn.idear.algorithm.convert_sorted_list_to_binary_search_tree.Solution solution =
                new cn.idear.algorithm.convert_sorted_list_to_binary_search_tree.Solution();
        return solution.sortedListToBST(ListNode.make(nums));
    }

    private boolean balancedBinaryTree(int[] nums) {
        cn.idear.algorithm.balanced_binary_tree.Solution solution =
                new cn.idear.algorithm.balanced_binary_tree.Solution();
        return solution.isBalanced(TreeNode.createTree(nums));
    }

    private int minimumDepthOfBinaryTree(int[] nums) {
        cn.idear.algorithm.minimum_depth_of_binary_tree.Solution solution =
                new cn.idear.algorithm.minimum_depth_of_binary_tree.Solution();
        return solution.minDepth(TreeNode.createTree(nums));
    }

    private boolean pathSum(int[] nums, int sum) {
        cn.idear.algorithm.path_sum.Solution solution =
                new cn.idear.algorithm.path_sum.Solution();
        return solution.hasPathSum(TreeNode.createTree(nums), sum);
    }

    private TwoLevelList<Integer> pathSumII(int[] nums, int sum) {
        cn.idear.algorithm.path_sum_ii.Solution solution =
                new cn.idear.algorithm.path_sum_ii.Solution();
        return TwoLevelList.make(solution.pathSum(TreeNode.createTree(nums), sum));
    }

    private TreeNode flattenBinaryTreeToLinkedList(int[] nums) {
        cn.idear.algorithm.flatten_binary_tree_to_linked_list.Solution solution =
                new cn.idear.algorithm.flatten_binary_tree_to_linked_list.Solution();
        TreeNode root = TreeNode.createTree(nums);
        solution.flatten(root);
        return root;
    }

    private TwoLevelList<Integer> pascalTriangle(int numRows) {
        cn.idear.algorithm.pascals_triangle.Solution solution =
                new cn.idear.algorithm.pascals_triangle.Solution();
        return TwoLevelList.make(solution.generate(numRows));
    }

    private List<Integer> pascalsTriangleII(int indexRows) {
        cn.idear.algorithm.pascals_triangle_ii.Solution solution =
                new cn.idear.algorithm.pascals_triangle_ii.Solution();
        return solution.getRow(indexRows);
    }

    private int triangle(Integer[][] nums) {
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            triangle.add(Arrays.asList(nums[i]));
        cn.idear.algorithm.triangle.Solution solution =
                new cn.idear.algorithm.triangle.Solution();
        return solution.minimumTotal(triangle);
    }

    private boolean validPalindrome(String s) {
        cn.idear.algorithm.valid_palindrome.Solution solution =
                new cn.idear.algorithm.valid_palindrome.Solution();
        return solution.isPalindrome(s);
    }

    private int compareVersionNumbers(String version1, String version2) {
        cn.idear.algorithm.compare_version_numbers.Solution solution =
                new cn.idear.algorithm.compare_version_numbers.Solution();
        return solution.compareVersion(version1, version2);
    }

    private int sumRootToLeafNumbers(int[] nums) {
        cn.idear.algorithm.sum_root_to_leaf_numbers.Solution solution =
                new cn.idear.algorithm.sum_root_to_leaf_numbers.Solution();
        return solution.sumNumbers(TreeNode.createTree(nums));
    }

    private ListNode reorderList(int[] nums) {
        ListNode head = ListNode.make(nums);
        cn.idear.algorithm.reorder_list.Solution solution =
                new cn.idear.algorithm.reorder_list.Solution();
        solution.reorderList(head);
        return head;
    }

    private int kthLargestElementInAnArray(int[] nums, int k) {
        cn.idear.algorithm.kth_largest_element_in_an_array.Solution solution =
                new cn.idear.algorithm.kth_largest_element_in_an_array.Solution();
        return solution.findKthLargest(nums, k);
    }

    private String excelSheetColumnTitle(int n) {
        cn.idear.algorithm.excel_sheet_column_title.Solution solution =
                new cn.idear.algorithm.excel_sheet_column_title.Solution();
        return solution.convertToTitle(n);
    }

    private int bestTimeToBuyAndSellStock(int[] nums) {
        cn.idear.algorithm.best_time_to_buy_and_sell_stock.Solution solution =
                new cn.idear.algorithm.best_time_to_buy_and_sell_stock.Solution();
        return solution.maxProfit(nums);
    }

    private int bestTimeToBuyAndSellStockII(int[] nums) {
        cn.idear.algorithm.best_time_to_buy_and_sell_stock_ii.Solution solution =
                new cn.idear.algorithm.best_time_to_buy_and_sell_stock_ii.Solution();
        return solution.maxProfit(nums);
    }

    private int bestTimeToBuyAndSellStockIII(int[] nums) {
        cn.idear.algorithm.best_time_to_buy_and_sell_stock_iii.Solution solution =
                new cn.idear.algorithm.best_time_to_buy_and_sell_stock_iii.Solution();
        return solution.maxProfit(nums);
    }

    private int binaryTreeMaximumPathSum(int[] nums) {
        cn.idear.algorithm.binary_tree_maximum_path_sum.Solution solution =
                new cn.idear.algorithm.binary_tree_maximum_path_sum.Solution();
        return solution.maxPathSum(TreeNode.createTree(nums));
    }

    private int longestConsecutiveSequence(int[] nums) {
        cn.idear.algorithm.longest_consecutive_sequence.Solution solution =
                new cn.idear.algorithm.longest_consecutive_sequence.Solution();
        return solution.longestConsecutive(nums);
    }

    private int firstBadVersion(int n, int firstBadVersion) {
        cn.idear.algorithm.first_bad_version.Solution solution =
                new cn.idear.algorithm.first_bad_version.Solution();
        solution.setFirstBadVersion(firstBadVersion);
        return solution.firstBadVersion(n);
    }

    private int numberofIslands(String[] strings) {
        char[][] grid = new char[strings.length][];
        for(int i = 0; i < strings.length; i++)
            grid[i] = strings[i].toCharArray();
        cn.idear.algorithm.number_of_islands.Solution solution =
                new cn.idear.algorithm.number_of_islands.Solution();
        return solution.numIslands(grid);
    }

    private int singleNumber(int[] nums) {
        cn.idear.algorithm.single_number.Solution solution =
                new cn.idear.algorithm.single_number.Solution();
        return solution.singleNumber(nums);
    }


    private int singleNumberII(int[] nums) {
        cn.idear.algorithm.single_number_ii.Solution solution =
                new cn.idear.algorithm.single_number_ii.Solution();
        return solution.singleNumber(nums);
    }

    private int wordLadder(String startWord, String endWord, String[] wordList) {
        HashSet<String> set = new HashSet<>();
        for(String s : wordList)
            set.add(s);
        cn.idear.algorithm.word_ladder.Solution solution =
                new cn.idear.algorithm.word_ladder.Solution();
        return solution.ladderLength(startWord, endWord, set);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        cn.idear.algorithm.clone_graph.Solution solution =
                new cn.idear.algorithm.clone_graph.Solution();
        return solution.cloneGraph(node);
    }

    private ListNode intersectionOfTwoLinkedLists(int[] numsA, int[] numsB, ListNode headC) {
        ListNode headA, headB;
        headA = mergeNode4IntersectionProblem(numsA, headC);
        headB = mergeNode4IntersectionProblem(numsB, headC);
        cn.idear.algorithm.intersection_of_two_linked_lists.Solution solution =
                new cn.idear.algorithm.intersection_of_two_linked_lists.Solution();
        return solution.getIntersectionNode(headA, headB);
    }

    private ListNode mergeNode4IntersectionProblem(int nums[], ListNode laterHead){
        ListNode head;
        if(nums.length == 0)
            head = laterHead;
        else{
            head = ListNode.make(nums);
            ListNode cur;
            for(cur = head; cur.next != null; cur = cur.next);
            cur.next = laterHead;
        }
        return head;
    }

    private int majorityElement(int[] nums) {
        cn.idear.algorithm.majority_element.Solution solution =
                new cn.idear.algorithm.majority_element.Solution();
        return solution.majorityElement(nums);
    }

    private List<Integer> majorityElementII(int[] nums) {
        cn.idear.algorithm.majority_element_ii.Solution solution =
                new cn.idear.algorithm.majority_element_ii.Solution();
        return solution.majorityElement(nums);
    }

    private int gasStation(int[] gas, int[] cost) {
        cn.idear.algorithm.gas_station.Solution solution =
                new cn.idear.algorithm.gas_station.Solution();
        return solution.canCompleteCircuit(gas, cost);
    }

    private int candy(int[] nums) {
        cn.idear.algorithm.candy.Solution solution =
                new cn.idear.algorithm.candy.Solution();
        return solution.candy(nums);
    }

    private int maximumProductSubarray(int[] nums) {
        cn.idear.algorithm.maximum_product_subarray.Solution solution =
                new cn.idear.algorithm.maximum_product_subarray.Solution();
        return solution.maxProduct(nums);
    }

    private int excelSheetColumnNumber(String s) {
        cn.idear.algorithm.excel_sheet_column_number.Solution solution =
                new cn.idear.algorithm.excel_sheet_column_number.Solution();
        return solution.titleToNumber(s);
    }

    private int findPeakElement(int[] nums) {
        cn.idear.algorithm.find_peak_element.Solution solution =
                new cn.idear.algorithm.find_peak_element.Solution();
        return solution.findPeakElement(nums);
    }

    private int factorialTrailingZeros(int n) {
        cn.idear.algorithm.factorial_trailing_zeroes.Solution solution =
                new cn.idear.algorithm.factorial_trailing_zeroes.Solution();
        return solution.trailingZeroes(n);
    }

}
