package app.converters;

import app.data.Type;

import java.util.HashMap;
import java.util.Map;

public class TypeConverter {
    private static Map<String, String> productTypes;
    static {
        productTypes = new HashMap<>();
        productTypes.put("T_shirt", "Футболка");
        productTypes.put("shorts", "Шорты");
        productTypes.put("sundress", "Сарафан");
        productTypes.put("dress", "Платье");
        productTypes.put("pajamas", "Пижама");
        productTypes.put("homeSuit", "Домашний костюм");
        productTypes.put("robe", "Халат");
        productTypes.put("shirt", "Рубашка");
        productTypes.put("trousers", "Брюки");
    }

    public static String productTypeRus(Type productType) {
        return productTypes.get(productType.getTitle());
    }

    public static String productTypeEng(String type) {
        for (Map.Entry<String, String> entries: productTypes.entrySet()) {
            if (entries.getValue().equals(type)) return entries.getKey();
        }
        return "";
    }
}
