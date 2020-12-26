package stack;

import org.junit.jupiter.api.Test;

public class solution321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int lenOfnums1 = nums1.length;
        int lenOfNums2 = nums2.length;
        int[] maxSubSequeue = new int[k];
        int start = Math.max(0, k - lenOfNums2);
        int end = Math.min(k, lenOfnums1);
        for (int i = start; i < end; i++) {
            int[] subSequeue1 =  getMaxSubSequeue(nums1, i);
            int[] subSequeue2 = getMaxSubSequeue(nums2, k - i);
            int[] curMaxSubSequeue = merge(subSequeue1, subSequeue2);
            if(compare()){

            }
        }
    }

    private int[] getMaxSubSequeue(int[] nums, int k){
        return removeKdigits(nums,nums.length - k);
    }

    private

    @Test
    public void test() {

    }
}
