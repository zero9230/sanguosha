package manager;

public class Utils {
    public static void assertTrue(boolean bool, String s) {
        if (!bool) {
            IO.println("assertion failed: " + s);
        }
    }

    public static void assertTrue(boolean bool) {
        assertTrue(bool, "(unfilled assertion)");
    }
}