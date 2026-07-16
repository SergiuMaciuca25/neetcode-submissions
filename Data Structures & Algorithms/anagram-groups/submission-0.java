class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String cuv = strs[i];

            int[] frecv = new int[26];

            for (int j = 0; j < cuv.length(); j++) {

                char lit = cuv.charAt(j);

                int poz = lit - 'a';

                frecv[poz]++;
            }

            String amprent = Arrays.toString(frecv);

            if (!map.containsKey(amprent)) {
                map.put(amprent, new ArrayList<>());
            }

            map.get(amprent).add(cuv);

        }

        return new ArrayList<>(map.values());
    }
}
