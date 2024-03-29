package com.dog.doger.app.framework.exception;

import com.dog.doger.app.business.enums.ErrorEnum;
import com.dog.doger.app.business.vo.ResultVo;
import com.dog.doger.app.framework.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: 20190409_jingxiangjia_admin
 * @Package: com.duoqio.boot.framework.exception
 * @ClassName: GlobalExceptionHandler
 * @Author: fanYang
 * @Description: 全局异常处理
 * @Date: 2020/6/5 10:11
 * @copyright: 重庆物界
 * @website: www.wujie.com
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    private ResultVo<Object> handlerErrorInfo(HttpServletRequest request, Exception e) {
        log.error("{} Exception", request.getRequestURI(), e);
        if (e instanceof com.dog.doger.app.framework.exception.CustomException) {
            return ResultVo.err(((CustomException) e).getCode(), e.getMessage());
        } else {
            return ResultVo.err(ErrorEnum.GATEWAY_ERROR.getErrCode(), ErrorEnum.GATEWAY_ERROR.getErrMsg() + " : " + e.getMessage());
        }
    }

}
