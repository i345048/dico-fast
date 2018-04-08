package cn.diconet.cms.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\8 0008
 */
@Slf4j
public class RequestInterceptorConfig implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate template) {
        String accessToken = null ;//WebContextUtil.getAccessToken();
        log.debug("RequestInterceptorConfig accessToken :" + accessToken);
        template.header(AUTHORIZATION_HEADER,
                String.format("%s %s",
                        BEARER_TOKEN_TYPE,
                        accessToken));
    }
}
