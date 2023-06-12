package app.services;

import app.data.Material;
import app.data.Order;
import app.data.Size;
import app.data.Type;
import app.repositories.MaterialRepository;
import app.repositories.OrderRepository;
import app.repositories.SizeRepository;
import app.repositories.TypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private TypeRepository productTypeRepo;
    @Autowired
    private MaterialRepository materialTypeRepo;
    @Autowired
    private SizeRepository sizeRepo;


    @Transactional
    public List<Order> getOrderList() {
        return (List<Order>) orderRepo.findAll();
    }
    @Transactional
    public List<Type> getProductTypeList() {
        return (List<Type>) productTypeRepo.findAll();
    }
    @Transactional
    public List<Material> getMaterialList() {
        return (List<Material>) materialTypeRepo.findAll();
    }
    @Transactional
    public List<Size> getSizeList() {
        return (List<Size>) sizeRepo.findAll();
    }
}
