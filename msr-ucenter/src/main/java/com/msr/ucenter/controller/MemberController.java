package com.msr.ucenter.controller;


import com.msr.common.vo.R;
import com.msr.ucenter.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-06-12
 */
@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/ucenter/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Value("${ucenter.user.name}")
    private String userName;

    @Value("${ucenter.user.age}")
    private int age;


    @ApiOperation(value = "读取配置文件内容")
    @GetMapping(value = "test")
    public R testNacosConfig(){
        return R.ok().data("userName",userName).data("age",age);
    }

    @ApiOperation(value = "今日注册数")
    @GetMapping(value = "count-register/{day}")
    public R registerCount(
            @ApiParam(name = "day", value = "统计日期")
            @PathVariable String day){
        Integer count = memberService.countRegisterByDay(day);
        return R.ok().data("countRegister", count);
    }

}

