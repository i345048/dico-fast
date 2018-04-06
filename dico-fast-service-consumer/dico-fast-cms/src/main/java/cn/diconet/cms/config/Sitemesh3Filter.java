package cn.diconet.cms.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;

/**
 * sitemesh3过滤器
 */
@Configuration
@WebFilter
public class Sitemesh3Filter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPaths("/index", "/decorator/content","/decorator/footer","/decorator/header","/decorator/links","/decorator/scripts","/decorator/body")//拦截规则
                .addExcludedPath("/static/**") //白名单
             //  .addTagRuleBundle(new ScriptsTagRuleBundle())//自定义标签
        ;
    }
}
