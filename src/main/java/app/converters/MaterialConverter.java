package app.converters;

import app.data.Material;

import java.util.HashMap;
import java.util.Map;

public class MaterialConverter {
    private static Map<String, String> materialTypes;
    static {
        materialTypes = new HashMap<>();
        materialTypes.put("cooler", "Кулирка");
        materialTypes.put("footer", "Футер");
        materialTypes.put("viscose", "Вискоза");
        materialTypes.put("velours", "Велюр");
        materialTypes.put("synthetic", "Синтетика");
    }

    public static String materialRus(Material material) {
        return materialTypes.get(material.getTitle());
    }

    public static String materialEng(String type) {
        for (Map.Entry<String, String> entries: materialTypes.entrySet()) {
            if (entries.getValue().equals(type)) return entries.getKey();
        }
        return "";
    }
}
