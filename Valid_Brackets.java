public class Valid_Brackets {
    public static boolean isValid(String s) {
        int len; ;
        do {
            len = s.length();
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        } while(len!=s.length());

        return s.trim().isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
