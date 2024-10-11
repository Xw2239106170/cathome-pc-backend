package com.cathome.pojo.ad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPojo {
    private Integer id;
    private String adName;
    private String brandName;
    private String address;
    private Integer price;
    private String image;
}
