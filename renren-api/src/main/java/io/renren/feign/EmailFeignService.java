package io.renren.feign;

import io.renren.feign.req.Request;
import io.renren.feign.req.TextEmailDTO;
import io.renren.feign.res.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author lijiali
 * @ClassName: EmailFeignService
 * @ProjectName renren-security
 * @date 2021/1/30 0030下午 6:06
 */
@FeignClient(name="sany-email")
public interface EmailFeignService {
    @GetMapping(value = "/echo/name/{str}")
    String echo(@PathVariable("str") String str);
    /**
     * @Author lijiali
     * @Description //发送文本邮件信息
     * @Date 下午 10:38 2021/1/30 0030
     **/
    @RequestMapping(value = "/email/sendTextMail", method = RequestMethod.POST)
    Result<Integer> sendTextMail(@RequestBody Request<TextEmailDTO> request);
}
