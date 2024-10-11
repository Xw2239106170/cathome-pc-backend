package com.cathome.controller.cat;

import com.cathome.pojo.Result;
import com.cathome.pojo.cat.CatPojo;
import com.cathome.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 猫咪controller
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@Transactional(rollbackFor = Exception.class)
public class CatController {
    @Autowired
    private CatService catService;
    /**
     * 查询所有猫咪，分页查询
     * @return
     */
    @GetMapping("/cats")
    public Result selectCat(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "5") Integer pageSize,
                            @RequestParam String catName, @RequestParam String state){
        return Result.success(catService.selectCat(page, pageSize, catName, state));
    }


    /**
     * 这个有问题需要解决
     * 根据id查询猫咪信息回显于编辑表单
     * @param id
     * @return
     */
    @GetMapping("/cats/{id}")
    public Result selectById( @PathVariable Integer id){
        log.info("查询到的信息{}", catService.searchById(id));
        return Result.success(catService.searchById(id));
    }

    /**
     * 更新猫咪信息
     * @return
     */
    @PutMapping("/cats")
    public Result editCat(@RequestBody CatPojo catPojo) {
        log.info("更新的信息{}", catPojo);
        catService.updateCat(catPojo);
        return Result.success();
    }

    /**
     * 根据id删除猫咪信息
     * @param id
     * @return
     */
    @DeleteMapping("/cats/{id}")
    public Result deleteCat(@PathVariable Integer id){
        catService.deleteCat(id);
        return Result.success();
    }

    /**
     * 新增猫咪
     * @param catPojo
     * @return
     */
    @PostMapping("/cats")
    public Result insertCat(@RequestBody CatPojo catPojo){
        log.info("插入的信息{}", catPojo);
        catService.insertCat(catPojo);
        return Result.success();
    }

}
