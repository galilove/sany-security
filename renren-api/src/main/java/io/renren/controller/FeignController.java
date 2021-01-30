package io.renren.controller;

import com.alibaba.fastjson.JSONObject;
import io.renren.feign.EmailFeignService;
import io.renren.feign.req.Request;
import io.renren.feign.req.TextEmailDTO;
import io.renren.feign.res.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lijiali
 * @ClassName: FeignController
 * @ProjectName renren-security
 * @date 2021/1/30 0030下午 6:05
 */
@RestController
@RequestMapping("/feign/")
@Slf4j
public class FeignController {
    @Autowired
    private EmailFeignService emailFeignService;

    @GetMapping("test/{str}")
    public String test(@PathVariable(name="str") String str) {
        return emailFeignService.echo(str);
    }

    @GetMapping("test1/{str}")
    public String test1(@PathVariable(name="str") String str) {
        return "hello" + str;
    }

    @RequestMapping(value = "/sendTextMail", method = RequestMethod.POST)
    public Result<Integer> sendTextMail(@RequestBody Request<TextEmailDTO> request){
        log.info("发送邮件请求入参={}", JSONObject.toJSONString(request));
        Result<Integer> result = emailFeignService.sendTextMail(request);
        log.info("调用邮件服务接口返回信息为{}",result);
        return result;
    }
}
