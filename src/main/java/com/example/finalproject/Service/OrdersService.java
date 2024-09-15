package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Orders;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Repository.OrdersRepository;
import com.example.finalproject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;


    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public void addOrder(Orders order) {
      ordersRepository.save(order);
    }
    public void updateOrder(Integer id,Orders order) {
        Orders order1=ordersRepository.findOrdersById(id);
        if(order1==null) {
            throw new ApiException("Order Not Found");
        }
        order1.setOrderDate(order.getOrderDate());
        order1.setTotalPrice(order.getTotalPrice());
        order1.setStatus(order.getStatus());
        ordersRepository.save(order1);
    }

    public void deleteOrder(Integer id) {
        Orders order1=ordersRepository.findOrdersById(id);
        if(order1==null) {
            throw new ApiException("Order Not Found");
        }

        ordersRepository.delete(order1);
    }

    /*Renad*/
    // Get orders by status
    public List<Orders> getOrdersByStatus(String status) {
        return ordersRepository.findOrdersByStatus(status);
    }
    /*Renad*/
    public String changeOrderStatus(Integer order_id, String status) {
        Orders order1=ordersRepository.findOrdersById(order_id);
        if(order1==null) {
            throw new ApiException("Order Not Found");
        }
        order1.setStatus(status);
        ordersRepository.save(order1);
        return "Order Status Changed Successfully";
    }


}
