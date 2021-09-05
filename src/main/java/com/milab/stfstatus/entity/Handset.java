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
                columnNames = "serial_number"
        )
)
public class Handset {
    @Id
    @SequenceGenerator(
            name = "handset_sequence",
            sequenceName = "handset_sequence",
            allocationSize = 1
    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "handset_sequence"
//    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "handset_id")
    private int handsetId;
    private String model;
    private String Owner;
    private String notes;
    @Column(
            name = "serial_number",
            nullable = false,
            unique = true
    )
    private String SerialNumber;
//    Private StfSetup stfSetup;
}
