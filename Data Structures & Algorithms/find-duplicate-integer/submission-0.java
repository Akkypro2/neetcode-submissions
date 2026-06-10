class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Detect cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];          // 1 step
            fast = nums[nums[fast]];    // 2 steps
        } while (slow != fast);

        // Step 2: Find cycle start (duplicate)
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}