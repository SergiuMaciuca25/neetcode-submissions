class Solution {
    public int findDuplicate(int[] nums) {
         // Why: we're treating each index as a "node" and nums[index] as
        // the pointer to the "next node". Since values are in [1, n] and
        // there are n+1 slots, at least two indices must point to the
        // same value somewhere -> that creates a cycle in this implicit
        // linked list. The duplicate number IS the entrance to that cycle.

        // Start both pointers at the same place: nums[0].
        // (We don't start at index 0 itself, we start by taking one step
        // from it, so slow and fast are aligned before the loop begins.)
        int slow = nums[0];
        int fast = nums[0];

        // ----- PHASE 1: prove a cycle exists, find a meeting point -----
        // slow moves one step at a time: slow = nums[slow]
        // fast moves two steps at a time: fast = nums[nums[fast]]
        // Why two speeds: if there's a cycle, the faster pointer will
        // eventually "lap" the slower one and they'll land on the same
        // value. If there were no cycle, fast would hit a dead end —
        // but here a cycle is guaranteed by the pigeonhole principle,
        // so this loop is guaranteed to terminate.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // At this point, slow and fast are both sitting on some node
        // that is INSIDE the cycle (not necessarily the entrance yet).

        // ----- PHASE 2: find the actual entrance to the cycle -----
        // Why reset slow to nums[0]: there's a mathematical property of
        // cycle detection (Floyd's algorithm) that says: the distance
        // from the START to the cycle entrance is equal to the distance
        // from the MEETING POINT to the cycle entrance (going around the
        // loop). So if we now move slow from the start and fast from the
        // meeting point, both at ONE step at a time, they are guaranteed
        // to meet exactly at the cycle entrance.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];  // one step at a time now, no more double-speed
            fast = nums[fast];  // also one step at a time
        }

        // Why this is the answer: the cycle entrance is the value that
        // TWO DIFFERENT indices point to -- which can only happen because
        // that value is the duplicate. Every other value in [1, n] is
        // pointed to by exactly one index (since it only appears once).
        return slow;
    }
}
