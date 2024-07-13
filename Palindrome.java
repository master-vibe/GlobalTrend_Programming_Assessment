public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int first = 0;
        int last = s.length() - 1;
        while(first <= last) {
            char currFirst = s.charAt(first);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                first++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                first++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
