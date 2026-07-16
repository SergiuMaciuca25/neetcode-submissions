class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String x : strs) {
            int len = x.length();

            res.append(len);
            res.append('#');
            res.append(x);

        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + 1 + len);
            res.add(word);

            i = j + 1 + len;
        }


    return res;
    }
}
