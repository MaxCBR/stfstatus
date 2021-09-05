package com.milab.stfstatus;

import com.milab.stfstatus.entity.Handset;
import com.milab.stfstatus.repository.HandsetRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class handsetRepositoryTest {
    @Autowired
    private HandsetRepository handsetRepository;

    @Test
    public void addHandset() {
        Handset handset = Handset.builder()
                .model("S21")
                .notes("new phone 2")
                .SerialNumber("AAABBBCCCDD")
                .Owner("MiLab")
                .build();
        Handset savedHandset = handsetRepository.save(handset);

        Assertions.assertThat(savedHandset).isNotNull();
        Assertions.assertThat(savedHandset.getHandsetId()).isGreaterThan(0);
    }

    @Test
    public void findAllHandsets(){
        List<Handset> handsets = handsetRepository.findAll();

        Assertions.assertThat(handsets.size()).isGreaterThan(0);
        for (Handset handset : handsets) {
            System.out.println(handset);
        }
    }

    @Test
    public void updateHandset(){
        int handsetId=1;
        Handset handset = handsetRepository.findById(handsetId).get();

        handset.setOwner("Ericsson");
        handsetRepository.save(handset);

        Assertions.assertThat(handsetRepository.findById(handsetId).get().getOwner()).isEqualTo("Ericsson");
    }

    @Test
    public void deleteHandsetById(){
        handsetRepository.deleteById(1);
        Optional<Handset> optionalHandset = handsetRepository.findById(1);

        Assertions.assertThat(optionalHandset).isNotPresent();
        Assertions.assertThat(optionalHandset).isNotPresent();
    }

    @Test
    public void getHandsetById(){
        Optional<Handset> optionalHandset = handsetRepository.findById(1);

        Assertions.assertThat(optionalHandset).isPresent();
        System.out.println(optionalHandset.get());
    }
}
