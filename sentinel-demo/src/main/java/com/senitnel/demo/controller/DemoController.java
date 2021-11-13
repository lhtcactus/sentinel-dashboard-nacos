package com.senitnel.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lht
 * @since 2021/11/11 11:59 上午
 */
@RestController
public class DemoController {

    /**
     * 没有任何限流降级的处理
     * @since  2021/11/11 12:03 下午
     * @author lht
     */
    @SentinelResource("test")
    @GetMapping("test")
    public String test(){
        return "ok";
    }

    /**
     * 限流处理
     * @since  2021/11/11 12:04 下午
     * @author lht
     */
    @SentinelResource(value = "test/bolck",blockHandler = "testBolckHandler")
    @GetMapping("test/bolck")
    public String testBolck(){
        return "ok";
    }

    /**
     * testBolck 的限流策略
     */
    public String testBolckHandler(BlockException e){
        return "请求过多，限流";
    }

    /**
     * 降级处理
     * @param  s 参数
     * @since  2021/11/11 12:04 下午
     * @author lht
     */
    @SentinelResource(value = "test/error",fallback = "testErrorFallback")
    @GetMapping("test/error")
    public String testError(String s){
        if("error".equals(s)){
            throw new RuntimeException("error");
        }
        return "ok";
    }

    /**
     * testError 的降级策略
     */
    public String testErrorFallback(String s,Throwable t){
        return "请求失败，降级";
    }
}
