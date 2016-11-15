package com.measures.controller;

import com.measures.domain.Measure;
import com.measures.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measures")
public class MeasuresController {
    @Autowired
    private MeasureService measureService;

    @RequestMapping(
            method = RequestMethod.POST,
            headers="Accept=application/json",
            produces="application/json"
    )
    public Measure save(@RequestBody Measure m) {
        return measureService.save(m);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            headers="Accept=application/json",
            produces="application/json"
    )
    public List get() {
        return measureService.get();
    }

    @RequestMapping(
            value="{id}",
            method = RequestMethod.PUT,
            headers="Accept=application/json",
            produces="application/json"
    )
    public void putGroup(@PathVariable long id, @RequestBody Measure m) {
        measureService.save(m);
    }


    @RequestMapping(
            value="{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable long id) {
        measureService.delete(id);
    }
}
