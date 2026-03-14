class Solution {
    private int[] weights;
    private int days;

    public boolean ship(int capacity){
        int requiredDays = 1;
        int shippedWeight = 0;

        for(int weight : weights){
            if(shippedWeight + weight <= capacity){
                shippedWeight += weight;
            }
            else{
                requiredDays++;
                shippedWeight = weight;
            }
        }
        if(requiredDays <= days) return true;
        return false;
    }

    public int binarySearch(int low, int high){
        int mid = low + (high - low) / 2;
        if(low >= high) return mid;

        if(ship(mid)){
            return binarySearch(low, mid);
        }
        else{
            return binarySearch(mid + 1, high);
        }
    }

    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        this.days = days;
        int totalWeight = 0;
        int maxWeight = Integer.MIN_VALUE;

        for(int weight : weights){
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        return binarySearch(maxWeight, totalWeight);
    }
}