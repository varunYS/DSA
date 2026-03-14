class Solution {
    private int[] piles;
    private int h;

    public boolean canFinish(int k){
        int hoursSpent = 0;
        for(int pile : piles) hoursSpent += (pile + k - 1) / k;

        return hoursSpent <= h;
    }

    public int binarySearch(int low, int high){
        int mid = low + (high - low) / 2;

        if(low >= high) return mid;

        if(canFinish(mid))
            return binarySearch(low, mid);
        else
            return binarySearch(mid + 1, high);
    }

    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        this.h = h;

        int maxPile = 0;
        for(int pile : piles) maxPile = Math.max(maxPile, pile);

        return binarySearch(1, maxPile);
    }
}

