class Solution {
    public int binarySearch(int[] nums, int low, int high){
        int mid = low + (high - low)/2;

        if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid + 1])
            return mid;
        else if(nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1])
            return binarySearch(nums, mid + 1, high);
        else if(nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1])
            return binarySearch(nums, low, mid - 1);
        else if(nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]){
            if(nums[mid - 1] < nums[mid + 1])
                return binarySearch(nums, mid + 1, high);
            else
                return binarySearch(nums, low, mid - 1);
        }
        return -1;
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if((n == 1) || (nums[0] > nums[1]))
            return 0;
        if(nums[n - 1] > nums[n - 2])
            return n - 1;
        return binarySearch(nums, 1, n - 2);
    }
}