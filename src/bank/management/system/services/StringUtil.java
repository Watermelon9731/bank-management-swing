package bank.management.system.services;

import java.text.DecimalFormat;

public class StringUtil {
    public static String parseStringToValue(String input) {
        input = input.replace(".", "");
        int value = Integer.parseInt(input);
        return String.valueOf(value);
    }

    public static String parseIntValueToFormatStringValue(int input) {
        DecimalFormat df = new DecimalFormat("#,###");

        return df.format(input).replace(",", ".");
    }
}
