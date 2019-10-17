package Tools;

import com.google.gson.*;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class JsonHelper {
    public static JsonObject getFileAsJson(String path)
    {
        JsonParser parser = new JsonParser();
        try {
            Object object = parser.parse(new FileReader(path));
            return (JsonObject) object;
        }
        catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static JsonObject getResourceAsJson(String path)
    {
        JsonParser parser = new JsonParser();
        try {
            Object object = parser.parse(IOUtils.toString(
                    JsonElement.class.getClassLoader().getResource(path)));
            return (JsonObject) object;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    private static String prettifyJson(String jsonString)
    {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }
}
