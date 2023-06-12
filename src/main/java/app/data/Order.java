package app.data;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "units")
    private int units;
    @Column(name = "deadlines")
    private String deadlines;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type productType;
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
    @ManyToMany
    @JoinTable(name = "orders_sizes",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "sizes_id"))
    private Set<Size> sizes = new LinkedHashSet<>();

    public Order(int units, Type productType, Material material, String deadlines, Set<Size> sizes) {
        this.units = units;
        this.productType = productType;
        this.material = material;
        this.deadlines = deadlines;
        this.sizes = sizes;
    }

    @Override
    public String toString() {
        return "Order{" + id + " " + units + " " + productType + " " + material + " " + deadlines + " " + sizes + "}";
    }
}

