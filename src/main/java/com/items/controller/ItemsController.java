package com.items.controller;

import com.items.domain.Item;
import com.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(
            method = RequestMethod.POST,
            headers="Accept=application/json",
            produces="application/json"
    )
    public Item save(@RequestBody Item item) {
        System.out.println("Item: " + item.toString());
        return itemService.save(item);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            headers="Accept=application/json",
            produces="application/json"
    )
    public List get() {
        return itemService.get();
    }

    @RequestMapping(
            value="{id}",
            method = RequestMethod.PUT,
            headers="Accept=application/json",
            produces="application/json"
    )
    public void putGroup(@PathVariable long id, @RequestBody Item item) {
        itemService.save(item);
    }


    @RequestMapping(
            value="{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable long id) {
        itemService.delete(id);
    }


}
