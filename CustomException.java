public class CustomException extends Exception {
    String msg;

    CustomException(String str) {
        msg = str;
    }

    public String toString() {
        return ("Exception occurred: " + msg);
    }
}
