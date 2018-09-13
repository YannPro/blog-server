package com.yannyao.blog.common.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.yannyao.blog.common.exception.ApiErrors;
import com.yannyao.blog.common.exception.BaseErrors;
import com.yannyao.blog.common.exception.BusinessException;
import com.yannyao.blog.common.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sun.misc.BASE64Encoder;

import javax.validation.ValidationException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Auther: YJY
 * @Date: 2018/9/13 10:08
 * @Description:
 */
@EnableWebMvc
@ControllerAdvice
@ResponseBody
public class ErrorHandler {
//    @Value("${kafka.postfix}")
//    private String postfix;
//    @Value("${mns.topic.sts}")
//    private String ststopic;

//    @Value("${db.url:}")
//    private String dburl;
//
//    @Value("${spring.datasource.url:}")
//    private String dburlnm;


//    private String moduleName;
//
//    public String getModuleName(){
//        if(moduleName == null){
//            try{
//                String OpString = dburl==null? dburlnm : dburl;
//                int lastQIndex  = OpString.lastIndexOf("?");
//                OpString = OpString.substring(0, lastQIndex);
//                int lastSlashIndex = OpString.lastIndexOf("/");
//                moduleName = OpString.substring(lastSlashIndex+1);
//            }
//            catch (Exception e){
//                moduleName = "";
//            }
//        }
//        return moduleName;
//    }


//    @Resource
//    private MnsProducer mnsProducer;
    private final static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
    private final static BASE64Encoder base64Encoder = new BASE64Encoder();

    @ExceptionHandler(BusinessException.class)
    public BaseResponse handlerBusinessException(BusinessException e) {
        logger.error(e.getErrMsg(), e);
        BaseResponse resp = new BaseResponse(e);
        return resp;
    }

    @ExceptionHandler(JsonMappingException.class)
    public BaseResponse handlerException(JsonMappingException e) {
        sendMsg(e);
        logger.error("json格式错误", e);
        BaseResponse resp = new BaseResponse(BaseErrors.JSON_FORMAT_ERROR);
        return resp;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse handlerException(HttpMessageNotReadableException e) {
        sendMsg(e);
        logger.error("错误", e);
        BaseResponse resp = new BaseResponse(BaseErrors.JSON_FORMAT_ERROR);
        return resp;
    }

    @ExceptionHandler(JsonParseException.class)
    public BaseResponse handlerException(JsonParseException e) {
        sendMsg(e);
        logger.error("json格式错误", e);
        BaseResponse resp = new BaseResponse(BaseErrors.JSON_FORMAT_ERROR);
        return resp;
    }

    @ExceptionHandler(InvalidFormatException.class)
    public BaseResponse handlerException(InvalidFormatException e) {
        sendMsg(e);
        logger.error("错误", e);
        BaseResponse resp = new BaseResponse(BaseErrors.JSON_FORMAT_ERROR);
        return resp;
    }

    @ExceptionHandler(ValidationException.class)
    public BaseResponse handlerValidationException(ValidationException e) {
        sendMsg(e);
        logger.error(e.getCause().getMessage(), e);
        BaseResponse resp = new BaseResponse((ApiErrors) e.getCause());
        return resp;
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(Exception e) {
        sendMsg(e);
        logger.error("SYS_ERROR", e);
        BaseResponse resp = new BaseResponse(BaseErrors.SERVER_ERROR.setArgs(e.getMessage()).setEmArgs("服务器出小差了~"));
//        sendError(e.getMessage(),e.printStackTrace());

        return resp;
    }

    public void sendError(String errMsg, String errStack) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("topic", "error/exception");
//        jsonObject.put("serviceName", getModuleName());
//        jsonObject.put("errMsg", errMsg);
//        jsonObject.put("errStack", base64Encoder.encode(errStack.getBytes()));
//        mnsProducer.producer(ststopic, jsonObject.toJSONString());
    }

    public void sendMsg(Exception e) {
        e.printStackTrace();
        sendError(e.getMessage(), getStackTrace(e));
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }

}
