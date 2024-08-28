package com.cathome.controller.cat;

import com.cathome.pojo.Result;
import com.cathome.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 猫咪controller
 */
@RestController
@Slf4j
public class CatController {
    @Autowired
    private CatService catService;
    /**
     * 查询所有猫咪
     * @return
     */
    @GetMapping("/cat")
    public Result selectCat(){
        return Result.success(catService.selectCat());
    }
}
