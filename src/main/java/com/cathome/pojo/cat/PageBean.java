package com.cathome.pojo;

import com.cathome.pojo.cat.CatPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PageBean {
    private Long total;
    private List<CatPojo> rows;
}
