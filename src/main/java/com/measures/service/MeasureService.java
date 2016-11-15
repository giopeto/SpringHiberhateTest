package com.measures.service;


import com.groups.domain.Group;
import com.measures.domain.Measure;

import java.util.List;

public interface MeasureService {
    public Measure save(Measure m);
    public List get();
    public void delete(Long id);
}
