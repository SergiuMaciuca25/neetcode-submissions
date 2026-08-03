class Solution {
    public int evalRPN(String[] tokens) {
        

        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                char op = token.charAt(0);

                int n2 = st.pop();
                int n1 = st.pop();

                int res = 0;

                if (op == '+') {
                    res = n1 + n2;
                } else if (op == '-') {
                    res = n1 - n2;
                } else if (op == '*') {
                    res = n1 * n2;
                 } else if (op == '/') {
                    res = n1 / n2;
                 }

                 st.push(res);
                
            } else {
                int n = Integer.parseInt(token);
                st.push(n);
                
            }
        }

        return st.peek();
    }
}
