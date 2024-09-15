package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Model.UsedItem;
import com.example.finalproject.Repository.StudentRepository;
import com.example.finalproject.Repository.UsedItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsedItemService {

    private final UsedItemRepository usedItemRepository;
    private final StudentRepository studentRepository;

    public List<UsedItem> getAllUsedItem() {
        return usedItemRepository.findAll();
    }

    public void addUsedItem(UsedItem usedItem) {
      usedItemRepository.save(usedItem);
    }

    public void updateUsedItem(Integer id, UsedItem usedItem) {
        UsedItem usedItem1=usedItemRepository.findUsedItemById(id);
        if(usedItem1==null) {
            throw new ApiException("Used item Not Found");
        }
        usedItem1.setName(usedItem.getName());
        usedItem1.setDescription(usedItem.getDescription());
        usedItem1.setPrice(usedItem.getPrice());
        usedItem1.setCategory(usedItem.getCategory());
        usedItem1.setUsed(usedItem.isUsed());
       usedItemRepository.save(usedItem1);
    }

    public void deleteUsedItem(Integer id) {
        UsedItem usedItem1=usedItemRepository.findUsedItemById(id);
        if(usedItem1==null) {
            throw new ApiException("Used item Not Found");
        }
        usedItemRepository.delete(usedItem1);
    }

}
