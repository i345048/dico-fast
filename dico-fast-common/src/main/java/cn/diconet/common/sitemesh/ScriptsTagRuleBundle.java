package cn.diconet.common.sitemesh;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * @author Administrator
 * @Title: ${FILE_NAME}
 * @Package cn.diconet.web.sitemesh
 * @Description: 描述
 * @date 2018\3\29 002917:47
 */
public class ScriptsTagRuleBundle implements TagRuleBundle {

    @Override
    public void install(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
        state.addRule("pageScripts", new ExportTagToContentRule(siteMeshContext,contentProperty.getChild("pageScripts"), false));
    }

    @Override
    public void cleanUp(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {

    }
}
