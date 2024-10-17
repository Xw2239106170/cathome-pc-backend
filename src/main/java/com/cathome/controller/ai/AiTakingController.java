package com.cathome.controller.ai;

import com.cathome.pojo.Result;
import com.cathome.utils.SparkManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional(rollbackFor = Exception.class)
@CrossOrigin(origins = "*")
@Slf4j
public class AiTakingController {
    @Autowired
    private SparkManager sparkManager;

    /**
     * ai对话聊天
     * @param sentence
     * @return
     */
    @GetMapping("/ai")
    public Result AiTaking(@RequestParam String sentence) {
        log.info("对话的信息{}", sentence);
        String res = sparkManager.sendMesToAIUseXingHuo(sentence);
        return Result.success(res);
    }
}
