

class Solution {
    private int[] nums;
    private int k;

    public boolean allocate(int mid){
        int a = 1;
        int subSum = 0;

        for(int num: nums){
            if(subSum + num <= mid){
                subSum += num;
            }
            else{
                subSum = num;
                a++;
            }
        }
        return (a <= k);
    }

    public int binarySearch(int low, int high){
        int mid = low + (high - low) / 2;

        if(low >= high) return mid;

        if(allocate(mid)){
            return binarySearch(low, mid);
        }
        else{
            return binarySearch(mid + 1, high);
        }

    }

    public int splitArray(int[] nums, int k) {
        this.nums = nums;
        this.k = k;

        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int num: nums){
            low = Math.max(low, num);
            high += num;
        }
        return binarySearch(low, high);
    }
}