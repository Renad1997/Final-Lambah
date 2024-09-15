package com.example.finalproject.Controller;

import com.example.finalproject.Model.Student;
import com.example.finalproject.Model.UsedItem;
import com.example.finalproject.Service.UsedItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usedItem")
public class UsedItemController {

    private final UsedItemService usedItemService;

    @GetMapping("/get")
    public ResponseEntity getAllUsedItem() {
        return ResponseEntity.status(200).body(usedItemService.getAllUsedItem());
    }

    @PostMapping("/add")
    public ResponseEntity addUsedItem(@Valid @RequestBody UsedItem usedItem) {
        usedItemService.addUsedItem(usedItem);
        return ResponseEntity.status(200).body("Used item added ");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUsedItem(@PathVariable Integer id,@Valid @RequestBody UsedItem usedItem) {
       usedItemService.updateUsedItem(id, usedItem);
        return ResponseEntity.status(200).body("Used item updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsedItem(@PathVariable Integer id) {
        usedItemService.deleteUsedItem(id);
        return ResponseEntity.status(200).body("Used item deleted");
    }


}
