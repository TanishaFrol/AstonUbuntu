package app.converters;

import app.data.Material;
import app.data.Order;
import app.repositories.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaterialConverterTest {
    private static List<Material> materialList;
    @BeforeAll
    static void beforeAll() {
        Material cooler = new Material(1L, "cooler");
        Material footer = new Material(2L, "footer");
        Material viscose = new Material(3L, "viscose");
        Material velours = new Material(4L, "velours");
        Material synthetic = new Material(5L, "synthetic");
        materialList = Arrays.asList(cooler, footer, viscose, velours, synthetic);
    }
    @Test
    void materialRus() {
        Assertions.assertEquals("Кулирка", MaterialConverter.materialRus(materialList.get(0)));
        Assertions.assertEquals("Футер", MaterialConverter.materialRus(materialList.get(1)));
        Assertions.assertEquals("Вискоза", MaterialConverter.materialRus(materialList.get(2)));
        Assertions.assertEquals("Велюр", MaterialConverter.materialRus(materialList.get(3)));
        Assertions.assertEquals("Синтетика", MaterialConverter.materialRus(materialList.get(4)));
    }
    @Test
    void materialEng() {
        Assertions.assertEquals("cooler", MaterialConverter.materialEng("Кулирка"));
        Assertions.assertEquals("footer", MaterialConverter.materialEng("Футер"));
        Assertions.assertEquals("viscose", MaterialConverter.materialEng("Вискоза"));
        Assertions.assertEquals("velours", MaterialConverter.materialEng("Велюр"));
        Assertions.assertEquals("synthetic", MaterialConverter.materialEng("Синтетика"));
    }
}