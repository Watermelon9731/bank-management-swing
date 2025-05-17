package bank.management.system.constants;

import java.awt.*;

public class Background {
    public static final Color BACKGROUND_COLOR = new Color(222, 255, 228);
    public static final Integer BACKGROUND_WIDTH = 840;
    public static final Integer BACKGROUND_HEIGHT = 580;

    public static final Integer HEADING_FONT_SIZE = 20;
    public static final Integer DETAIL_FONT_SIZE = 16;

    public static final Integer ATM_BUTTON_LEFT_START_X = 200;
    public static final Integer ATM_BUTTON_RIGHT_START_X = 490;
    public static final Integer ATM_BUTTON_START_Y = 290;
    public static final Integer ATM_BUTTON_HEIGHT = 32;

    public static final Color BUTTON_INFO = new Color(228, 127, 0);
    public static final Color BUTTON_PRIMARY = new Color(1, 93, 158);
    public static final Color BUTTON_WARNING = new Color(165, 8, 8);

    public static int getPositionY(int startY, int level) {
        if (startY < 0 || startY >= BACKGROUND_HEIGHT) {
            return 0;
        }
        return (startY + ATM_BUTTON_HEIGHT * level + 18 * level);
    }
}
