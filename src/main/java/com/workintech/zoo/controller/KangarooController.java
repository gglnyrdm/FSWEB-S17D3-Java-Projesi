package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;
    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
    }
    @GetMapping("/")
    public List<Kangaroo> getAll(){
        return kangaroos.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable int id){
        return kangaroos.get(id);
    }
    @PostMapping("/")
    public Kangaroo create(@RequestBody Kangaroo kangaroo){
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }
    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable int id,@RequestBody Kangaroo kangaroo){
        return kangaroos.put(kangaroo.getId(),kangaroo);
    }
    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable int id){
        return kangaroos.remove(id);
    }
}
