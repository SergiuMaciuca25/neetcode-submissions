class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

        int[] fr = new int[26];
        int[] window = new int[26];

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) {
            return false;
        }

        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);

            fr[ch - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(fr, window)) {
            return true;
        }

        for (int right = n1; right < n2; right++) {
            char enteringChar = s2.charAt(right);
            window[enteringChar - 'a']++;

            char leavingChar = s2.charAt(right - n1);
            window[leavingChar - 'a']--;

            if (matches(fr, window)) {
                return true;
            }

        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

}
