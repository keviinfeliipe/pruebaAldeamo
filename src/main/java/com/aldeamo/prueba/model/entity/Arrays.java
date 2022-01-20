package com.aldeamo.prueba.model.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Table(name ="arrays")
public class Arrays {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "input_array")
    private String inputArray;

}
