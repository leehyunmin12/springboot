package com.example.fisrtproject.api;

import com.example.fisrtproject.dto.CoffeeForm;
import com.example.fisrtproject.entity.Coffee;
import com.example.fisrtproject.service.CoffeeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeController {
    @Autowired
    private CoffeeServices coffeeServices;

    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return coffeeServices.index();
    }

    @GetMapping("/api/coffee/{id}")
    public Coffee find(@PathVariable Long id) {
        return coffeeServices.find(id);
    }

    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeForm dto) {
        Coffee created = coffeeServices.create(dto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> update(@RequestBody CoffeeForm dto, @PathVariable Long id) {
        Coffee updated = coffeeServices.update(dto, id);
        return (updated!=null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id){
        Coffee deleted = coffeeServices.delete(id);
        return (deleted!=null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
