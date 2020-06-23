class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();

        //function to get all the permutations of parentheses and put into a list
        backtrackHelper(result, "", 0, 0, n);

        return result;
    }

    //recursive function to add all the possibilities of n pairs of parentheses to a given list
    public void backtrackHelper(List<String> result, String currentString, int left, int right, int n){

        //base case, if the string is the size of n*2, then it is complete and we add it to the list
        if(currentString.length() == n*2){
            result.add(currentString);
            return;
        }
        //checks if the left parentheses are less than n
        if(left < n)
            backtrackHelper(result, currentString + "(", left+1, right, n);

        //checks if there are more left parentheses than right
        if(right < left)
            backtrackHelper(result, currentString + ")", left, right+1, n);
    }
}