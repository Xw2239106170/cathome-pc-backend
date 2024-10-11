package com.cathome.pojo.ad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdBean {
    private Long total;
    private List<AdPojo> rows;
}
