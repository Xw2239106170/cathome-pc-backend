package com.cathome.pojo.cat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatPojo {
    private Integer id;
    private String catName;
    private Integer age;
    private Short state;
    private String condition;
    private String address;
    private String image;
    private LocalDate entrydate;
}
