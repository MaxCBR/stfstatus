package com.milab.stfstatus.repository;

import com.milab.stfstatus.entity.Handset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandsetRepository extends JpaRepository<Handset,Integer> {
}
