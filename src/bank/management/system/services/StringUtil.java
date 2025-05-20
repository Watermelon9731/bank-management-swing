package bank.management.system.services;

public class StringUtil {
    public static String parseStringToValue(String input) {
        input = input.replace(".", "");
        long value = Long.parseLong(input);
        return String.valueOf(value);
    }
}
