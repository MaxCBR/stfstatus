package com.milab.stfstatus.service;

import com.milab.stfstatus.entity.Handset;
import com.milab.stfstatus.repository.HandsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandsetService {
    @Autowired
    HandsetRepository handsetRepository;

    public List<Handset> findAllHandsets(){
        return handsetRepository.findAll();
    }
}
