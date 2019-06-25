package com.tcl.mibc.fallback;

import com.alibaba.fastjson.JSON;
import com.tcl.mibc.constant.ResponseCode;
import com.tcl.mibc.constant.ResponseResult;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * appcenter回退
 *
 * @author linglong.he
 * @date 2019-06-17 14:11
 **/
@Component
public class AppcenterFallBackProvider implements FallbackProvider{

    @Override
    public String getRoute() {
        // 表明是为哪个微服务提供回退，*表示为所有微服务提供回退
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return this.response(cause);
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return this.response(null);
    }

    private ClientHttpResponse response(final Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                ResponseResult responseResult = new ResponseResult(ResponseCode.MICRO_SERVICE_ERROR);
                if(cause != null)
                    responseResult.setMsg(cause.toString());
                return new ByteArrayInputStream(JSON.toJSONString(responseResult).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                // headers设定
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
