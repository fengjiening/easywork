package org.fengjiening.exception;

import lombok.extern.slf4j.Slf4j;

import org.fengjiening.api.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * 异常处理器
 *
 * @Author scott
 * @Date 2019
 */
@RestControllerAdvice
@Slf4j
public class WorkExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(WorkException.class)
    public Result<?> handleRRException(WorkException e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<?> handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(404, "路径不存在，请检查路径是否正确");
    }



    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error("操作失败，" + e.getMessage());
    }

    /**
     * @param e
     * @return
     * @Author 政辉
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        StringBuffer sb = new StringBuffer();
        sb.append("不支持");
        sb.append(e.getMethod());
        sb.append("请求方法，");
        sb.append("支持以下");
        String[] methods = e.getSupportedMethods();
        if (methods != null) {
            for (String str : methods) {
                sb.append(str);
                sb.append("、");
            }
        }
        log.error(sb.toString(), e);
        //return Result.error("没有权限，请联系管理员授权");
        return Result.error(405, sb.toString());
    }

    /**
     * spring默认上传大小100MB 超出大小捕获异常MaxUploadSizeExceededException
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result<?> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error(e.getMessage(), e);
        return Result.error("文件大小超出100MB限制, 请压缩或降低文件质量! ");
    }

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public Result<?> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
//        log.error(e.getMessage(), e);
//        return Result.error("字段太长,超出数据库字段的长度");
//    }
//
//    @ExceptionHandler(PoolException.class)
//    public Result<?> handlePoolException(PoolException e) {
//        log.error(e.getMessage(), e);
//        return Result.error("Redis 连接异常!");
//    }

    /**
     * 参数不支持异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        ObjectError error = errors.get(0);
        String errorInfo = error.getDefaultMessage();
        log.warn(errorInfo, e);
        return Result.error(400, errorInfo);
    }
}
