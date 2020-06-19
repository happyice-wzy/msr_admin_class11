package com.msr.statistics.feign;

import com.msr.common.vo.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Service
@FeignClient("msr-ucenter")
public interface UcenterFeignService {
    @ApiOperation(value = "今日注册数")
    @GetMapping(value = "/ucenter/member/count-register/{day}")
    public R registerCount(@ApiParam(name = "day", value = "统计日期") @PathVariable String day);


}

