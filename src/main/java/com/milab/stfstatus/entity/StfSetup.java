package com.milab.stfstatus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "stf_setup"
)
public class StfSetup {

    @Id
//    @SequenceGenerator(
//            name = "StfSetup_sequence",
//            sequenceName = "StfSetup_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "StfSetup_sequence"
//    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setupId;
    private String setupName;
    private String setupNotes;

}
