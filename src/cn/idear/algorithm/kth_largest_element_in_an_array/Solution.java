package cn.idear.algorithm.kth_largest_element_in_an_array;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {

//    public int findKthLargest(int[] nums, int k) {
//        return findKthLargestHelper(nums, k, 0, nums.length);
//    }
//
//    private int findKthLargestHelper(int[] nums, int k, int start, int end){
//        for(int i = 1; i <= k; i++){
//            int index = findLargestIndex(nums, start, end);
//            swap(nums, start++, index);
//        }
//        return nums[k - 1];
//    }
//
//    private void swap(int[] nums, int l, int r){
//        int tmp = nums[l];
//        nums[l] = nums[r];
//        nums[r] = tmp;
//    }
//
//    private int findLargestIndex(int[] nums, int start, int end){
//        int max = start;
//        for(int i = start + 1; i < end; i++){
//            if(nums[i] > nums[max])
//                max = i;
//        }
//        return max;
//    }

    public int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        /**
         * 堆中初始化为前k个元素
         */
        for(int i = 0; i < k; i++)
            heap.add(nums[i]);
        for(int i = k; i < nums.length; i++){
            /**
             * 每次遇到比堆顶元素大的，就将堆顶元素替换掉。这样最终堆中为k个最大的元素，且堆顶元素为这k个最大元素中最小的那个
             */
            if(nums[i] > heap.data[0]){
                heap.data[0] = nums[i];
                heap.update(0);
            }
        }
        return heap.data[0];
    }

    class MinHeap{
        int currentSize = 0;
        int[] data;

        MinHeap(int size){
            data = new int[size];
        }

        int left(int i){
            return 2 * i + 1;
        }

        int right(int i){
            return 2 * i + 2;
        }

        int parent(int i){
            return (i - 1)>>1;
        }

        void add(int num){
            int i = currentSize++;
            data[i] = num;
            while(i > 0 && data[parent(i)] > data[i]){
                swap(i, parent(i));
                i = parent(i);
            }
        }

        void update(int i){
            int l = left(i);
            int r = right(i);
            int min = i;
            if(l < currentSize && data[l] < data[min])
                min = l;
            if(r < currentSize && data[r] < data[min])
                min = r;
            if(min != i){
                swap(i, min);
                update(min);
            }
        }

        void swap(int i, int j){
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }
}
