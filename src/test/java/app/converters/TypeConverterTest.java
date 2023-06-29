package app.converters;

import app.data.Material;
import app.data.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeConverterTest {
    private static List<Type> typeList;
    @BeforeAll
    static void beforeAll() {
        Type T_shirt = new Type(1L, "T_shirt");
        Type shorts = new Type(2L, "shorts");
        Type sundress = new Type(3L, "sundress");
        Type dress = new Type(4L, "dress");
        Type pajamas = new Type(5L, "pajamas");
        typeList = Arrays.asList(T_shirt, shorts, sundress, dress, pajamas);
    }
    @Test
    void productTypeRus() {
        Assertions.assertEquals("Футболка", TypeConverter.productTypeRus(typeList.get(0)));
        Assertions.assertEquals("Шорты", TypeConverter.productTypeRus(typeList.get(1)));
        Assertions.assertEquals("Сарафан", TypeConverter.productTypeRus(typeList.get(2)));
        Assertions.assertEquals("Платье", TypeConverter.productTypeRus(typeList.get(3)));
        Assertions.assertEquals("Пижама", TypeConverter.productTypeRus(typeList.get(4)));
    }
    @Test
    void productTypeEng() {
        Assertions.assertEquals("T_shirt", TypeConverter.productTypeEng("Футболка"));
        Assertions.assertEquals("shorts", TypeConverter.productTypeEng("Шорты"));
        Assertions.assertEquals("sundress", TypeConverter.productTypeEng("Сарафан"));
        Assertions.assertEquals("dress", TypeConverter.productTypeEng("Платье"));
        Assertions.assertEquals("pajamas", TypeConverter.productTypeEng("Пижама"));
    }
}