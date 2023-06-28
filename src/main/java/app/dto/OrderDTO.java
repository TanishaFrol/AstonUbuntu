package app.dto;

import app.converters.MaterialConverter;
import app.converters.TypeConverter;
import app.data.Order;
import app.data.Size;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Data
public class OrderDTO {
    private Long id;
    private int units;
    private String deadlines;
    private String productType;
    private String material;
    private String size;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.units = order.getUnits();
        this.deadlines = order.getDeadlines();
        this.productType = TypeConverter.productTypeRus(order.getProductType());
        this.material = MaterialConverter.materialRus(order.getMaterial());
        this.size = sizeRangeToString(order.getSizes());
    }

    private String sizeRangeToString(Set<Size> sizeRange) {

        List<Size> sortedSizeRange = sizeRange.stream().sorted(new Comparator<Size>() {
            @Override
            public int compare(Size o1, Size o2) {
                if (o1.getTitle() > o2.getTitle()) return 1;
                if (o1.getTitle() < o2.getTitle()) return -1;
                else return 0;
            }
        }).collect(Collectors.toList());
        if (sizeRange.size() == 1) {
            return "[ " + sortedSizeRange.get(0).getTitle() + " ]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[ ").append(sortedSizeRange.get(0).getTitle()).append(" - ").append(sortedSizeRange.get(sortedSizeRange.size() - 1).getTitle()).append(" ]");
        return str.toString();
    }
}
