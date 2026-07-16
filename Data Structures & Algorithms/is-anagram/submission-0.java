class Solution {
    public boolean isAnagram(String s, String t) {

        int[] fr = new int[101];

        
        for (int i = 0; i < s.length(); i++) {

            fr[s.charAt(i) - 'a']++;
            
        }

        for (int i = 0; i < t.length(); i++) {
            fr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 101; i++) {
            if (fr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
