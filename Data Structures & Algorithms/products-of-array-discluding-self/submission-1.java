class Solution {
    public int[] productExceptSelf(int[] nums) {
        
       int n = nums.length;
        int[] res = new int[n];
        
        // Pasul 1: Calculăm produsele din stânga
        // Primul element nu are nimic în stânga, deci pornim cu 1
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // Pasul 2: Calculăm produsele din dreapta și le înmulțim direct cu rezultatul
        int rightProd = 1; // Ultimul element nu are nimic în dreapta
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * rightProd; // Înmulțim stânga (deja în res) cu dreapta
            rightProd *= nums[i];        // Actualizăm produsul din dreapta pentru următorul pas
        }
        
        return res;
    }
}  
