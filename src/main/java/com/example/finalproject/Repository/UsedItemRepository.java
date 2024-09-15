package com.example.finalproject.Repository;

import com.example.finalproject.Model.UsedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedItemRepository extends JpaRepository<UsedItem, Integer> {

    UsedItem findUsedItemById(Integer id);

}
