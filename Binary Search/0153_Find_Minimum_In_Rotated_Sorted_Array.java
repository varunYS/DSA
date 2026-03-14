class Solution {
    public int binarySearch(int[] nums, int l, int h, int minNum){
        int m = (l + h) / 2;
        if(l == h)
            return Math.min(minNum, nums[l]);
        if(nums[l] <= nums[m] && nums[m] <= nums[h]){
            return Math.min(minNum, nums[l]);
        }
        else if(nums[l] <= nums[m] && nums[m] > nums[h]){
            minNum = Math.min(minNum, nums[l]);
            return binarySearch(nums, m + 1, h, minNum);
        }
        else if(nums[l] > nums[m] && nums[m] <= nums[h]){
            minNum = Math.min(minNum, nums[m]);
            return binarySearch(nums, l, m - 1, minNum);
        }
        return 0;
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n-1;
        int minNum = Integer.MAX_VALUE;
        
        return binarySearch(nums, l, h, minNum);
    }
}