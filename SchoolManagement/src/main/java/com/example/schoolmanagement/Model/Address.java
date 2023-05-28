package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {



    @Id

    @GeneratedValue(generator = "teacher_id", strategy = GenerationType.SEQUENCE)

    @SequenceGenerator(name = "id", sequenceName = "teacher_id", initialValue = 1, allocationSize = 1)

    private Integer id;


    private String area;


    private String street;


    private String buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}

