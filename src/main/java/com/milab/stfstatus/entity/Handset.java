package com.milab.stfstatus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "handset",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_sn",
                columnNames = "sierial_number"
        )
)
public class Handset {
    @Id
    @SequenceGenerator(
            name = "handset_sequence",
            sequenceName = "handset_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "handset_sequence"
    )
    @Column(name = "handset_id")
    private int handsetId;
    private String model;
    private String Owner;
    private String notes;
    @Column(
            name = "sierial_number",
            nullable = false
    )
    private String SierialNumber;
//    Private StfSetup stfSetup;
}
