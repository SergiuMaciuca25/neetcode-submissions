class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> indices = new Stack<>();

        int n = temperatures.length;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                int poppedIndex = indices.pop();
                res[poppedIndex] = i - poppedIndex;
            }

            indices.push(i);
        }
        return res;
    }   
}
