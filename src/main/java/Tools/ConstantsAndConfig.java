package Tools;

import com.google.gson.JsonObject;

public class ConstantsAndConfig {
    private static JsonObject projectValues = JsonHelper.getResourceAsJson("config/config.json");
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    //region Getters

    public static String getDesiredDriver() {
        return String.valueOf(projectValues.get("desired_driver")).replaceAll("\"","");
    }
    static String getAnsiRed() {
        return ANSI_RED;
    }
    static String getAnsiReset() {
        return ANSI_RESET;
    }

    //endregion
}
