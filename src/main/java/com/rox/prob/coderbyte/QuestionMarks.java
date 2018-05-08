package com.rox.prob.coderbyte;

/**
 * Take an input string parameter and determine if exactly 3 question marks exist between every pair of numbers
 * that add up to 10. If so, return true, otherwise return false. Some examples test cases are below:
 * <pre>
 *    "arrb6???4xxbl5???eee5" => true
 *    "acc?7??sss?3rr1??????5" => true
 *    "5??aaaaaaaaaaaaaaaaaaa?5?5" => false
 *    "9???1???9???1???9" => true
 *    "aa6?9" => false
 * </pre>
 *
 * NOTES:
 * But in the examples "<code>9???1???9???1???9</code>" contains two pairs which add up to 10 which have 9
 * "<code>?</code>"s between them and "<code>aa6?9</code>" should be true as all digit pairs which add up to 10
 * (of which there are 0), satisfy the constraint
 */
public class QuestionMarks {
    public boolean solution(final String value){
        char[] valueChars = value.toCharArray();

        for (int c=0; c< valueChars.length; c++){
            if (Character.isDigit(valueChars[c])){
                int numericValue = Character.getNumericValue(valueChars[c]);
                int searchValue = 10 - numericValue;

                int questionMarkCount = 0;
                for (int sc=c+1; sc< valueChars.length; sc++){
                    if (Character.isDigit(valueChars[sc])){
                        if (searchValue == Character.getNumericValue(valueChars[sc])){
                            if (questionMarkCount != 3) {
                                System.out.println("Between '" + valueChars[c] + "' and '" + valueChars[sc] + "' there are " + questionMarkCount + " '?'s");
                                return false;
                            }
                        }
                    }else if (valueChars[sc] == '?'){
                        questionMarkCount++;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        final QuestionMarks problem = new QuestionMarks();

        //System.out.println(problem.solution("arrb6???4xxbl5???eee5"));
        //System.out.println(problem.solution("acc?7??sss?3rr1??????5"));
        //System.out.println(problem.solution("5??aaaaaaaaaaaaaaaaaaa?5?5"));
        System.out.println(problem.solution("9???1???9???1???9"));
        System.out.println(problem.solution("aa6?9"));
    }
}
