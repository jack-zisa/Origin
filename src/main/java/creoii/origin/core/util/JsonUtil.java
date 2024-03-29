package creoii.origin.core.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonUtil {
    public static String getString(JsonObject object, String name) {
        return object.has(name) ? object.get(name).getAsString() : null;
    }

    public static String getString(JsonObject object, String name, String fallback) {
        return object.has(name) ? object.get(name).getAsString() : fallback;
    }

    public static int getInt(JsonObject object, String name) {
        return object.has(name) ? object.get(name).getAsInt() : null;
    }

    public static int getInt(JsonObject object, String name, int fallback) {
        return object.has(name) ? object.get(name).getAsInt() : fallback;
    }

    public static float getFloat(JsonObject object, String name) {
        return object.has(name) ? object.get(name).getAsFloat() : null;
    }

    public static float getFloat(JsonObject object, String name, float fallback) {
        return object.has(name) ? object.get(name).getAsFloat() : fallback;
    }

    public static JsonArray getArray(JsonObject object, String name) {
        return object.has(name) ? object.getAsJsonArray(name) : null;
    }

    public static boolean getBoolean(JsonObject object, String name) {
        return object.has(name) ? object.get(name).getAsBoolean() : null;
    }

    public static boolean getBoolean(JsonObject object, String name, boolean fallback) {
        return object.has(name) ? object.get(name).getAsBoolean() : fallback;
    }
}
