package com.cathome.controller.ad;

import com.cathome.pojo.Result;
import com.cathome.pojo.ad.AdPojo;
import com.cathome.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Transactional(rollbackFor = Exception.class)
//@RequestMapping("/ads") put方法不支持该种形式的接口设置
@CrossOrigin(origins = "*")
public class AdController {
    @Autowired
    private AdService adService;

    /**
     * 分页查询前端接口
     * @param page
     * @param pageSize
     * @param adName
     * @param brandName
     * @return
     */
    @GetMapping("/ads")
    public Result adList(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue ="5") Integer pageSize,
                         @RequestParam String adName,  @RequestParam String brandName){
        return Result.success(adService.adList(page, pageSize, adName, brandName));
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/ads/{id}")
    public Result adsById(@PathVariable Integer id){
        return Result.success(adService.adsByID(id));
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/ads/{id}")
    public Result adsDeleteById(@PathVariable Integer id){
        adService.adsDeleteById(id);
        return Result.success();
    }

    /**
     * 更新广告
     * @param adPojo
     * @return
     */
    @PutMapping("/ads")
    public Result adsUpdate(@RequestBody AdPojo adPojo){
        log.info("更新的信息:{}", adPojo);
        adService.adsUpdate(adPojo);
        return Result.success();
    }

    /**
     * 新增广告
     * @param adPojo
     * @return
     */
    @PostMapping("/ads")
    public Result adsInsert(@RequestBody AdPojo adPojo){
        adService.adsInsert(adPojo);
        return Result.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/ads")
    public Result adsDelete(@RequestParam List<Integer> ids){
        adService.adsDelete(ids);
        log.info("删除的ids{}", ids);
        return Result.success();
    }
}
