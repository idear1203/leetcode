package cn.idear.algorithm.main;

import cn.idear.algorithm.happy_number.Solution;
import cn.idear.algorithm.util.ListNode;
import cn.idear.algorithm.util.TwoLevelList;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by wangdongwei on 8/23/15.
 * Test Suite.
 */
public class Main {
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
        ListNode expect = ListNode.createListByVal(new int[]{1, 2, 4});
        ListNode actual = ListNode.createListByVal(new int[]{1, 2, 3, 4});
        deleteNodeInALinkedList(actual, 3);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testRemoveLinkedListElements(){
        ListNode expect;
        ListNode head;
        Assert.assertEquals(null, removeLinkedListElements(null, 6));

        head = ListNode.createListByVal(new int[]{1, 2, 6, 3, 4, 5, 6});
        expect = ListNode.createListByVal(new int[]{1, 2, 3, 4, 5});
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

        expect = ListNode.createListByVal(new int[]{1, 2, 3, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 0);
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{1, 2, 3, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 1);
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{2, 1, 4, 3, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 2);
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{3, 2, 1, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 3);
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{4, 3, 2, 1, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 4);
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{5, 4, 3, 2, 1});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 5);
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{1, 2, 3, 4, 5});
        actual = reverseNodesInKGroups(new int[]{1, 2, 3, 4, 5}, 6);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSwapNodesInPairs(){
        ListNode expect;
        ListNode actual;

        expect = ListNode.createListByVal(new int[]{2, 1, 4, 3});
        actual = swapNodesInPairs(new int[]{1, 2, 3, 4});
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{2, 1, 3});
        actual = swapNodesInPairs(new int[]{1, 2, 3});
        Assert.assertEquals(expect, actual);

        expect = ListNode.createListByVal(new int[]{2, 1});
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

        origin = ListNode.createListByVal(new int[]{1, 2, 3});
        expect = ListNode.createListByVal(new int[]{1, 2});
        Assert.assertEquals(expect, removeNthNodeFromEndofList(origin, 1));

        origin = ListNode.createListByVal(new int[]{1, 2, 3});
        expect = ListNode.createListByVal(new int[]{1, 3});
        Assert.assertEquals(expect, removeNthNodeFromEndofList(origin, 2));

        origin = ListNode.createListByVal(new int[]{1, 2, 3});
        expect = ListNode.createListByVal(new int[]{2, 3});
        Assert.assertEquals(expect, removeNthNodeFromEndofList(origin, 3));

        origin = ListNode.createListByVal(new int[]{1});
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
        ListNode expect = ListNode.createListByVal(new int[]{1, 2});
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
        ListNode expect = ListNode.createListByVal(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode actual = mergeKSortedLists(new int[][]{{1, 5, 7}, {6, 8}, {2, 3}, {4, 9}});
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testMergeTwoSortedList(){
        ListNode expect = ListNode.createListByVal(new int[]{1,2,3,4,5,6,7,8,9});
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
        Assert.assertEquals(ListNode.createListByVal(new int[]{7, 0, 8}),rst);

        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6});
        Assert.assertEquals(ListNode.createListByVal(new int[]{7, 0, 4}),rst);

        rst = addTwoNumbers(new int[]{2, 4, 3}, new int[]{5, 6, 6});
        Assert.assertEquals(ListNode.createListByVal(new int[]{7, 0, 0, 1}),rst);
    }

    private  int[] twoSum(int[] nums , int target){
        cn.idear.algorithm.two_sum.Solution solution = new cn.idear.algorithm.two_sum.Solution();
        return solution.twoSum(nums, target);
    }

    private  ListNode addTwoNumbers(int[] l1, int[] l2){
        ListNode n1 = ListNode.createListByVal(l1);
        ListNode n2 = ListNode.createListByVal(l2);
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
        ListNode l1 = ListNode.createListByVal(nums1);
        ListNode l2 = ListNode.createListByVal(nums2);
        cn.idear.algorithm.merge_two_sorted_lists.Solution solution = new cn.idear.algorithm.merge_two_sorted_lists.Solution();
        return solution.mergeTwoLists(l1, l2);
    }

    private ListNode mergeKSortedLists(int[][] ints) {
        ListNode[] list = new ListNode[ints.length];
        for(int i = 0; i < ints.length; i++)
            list[i] = ListNode.createListByVal(ints[i]);
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
        ListNode head = ListNode.createListByVal(nums);
        return solution.isPalindrome(head);
    }

    private ListNode reverseLinkedList(int[] nums) {
        cn.idear.algorithm.reverse_linked_list.Solution solution =
                new cn.idear.algorithm.reverse_linked_list.Solution();
        return solution.reverseList(ListNode.createListByVal(nums));
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
        return solution.swapPairs(ListNode.createListByVal(nums));
    }

    private ListNode reverseNodesInKGroups(int[] nums, int k) {
        cn.idear.algorithm.reverse_nodes_in_k_group.Solution solution =
                new cn.idear.algorithm.reverse_nodes_in_k_group.Solution();
        return solution.reverseKGroup(ListNode.createListByVal(nums), k);
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
}
