package org.whole.lang.json.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.json.model.Object;
import org.whole.lang.factories.GenericEntityFactory;

/**
 *  @generator  Whole
 */
public class JSONTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final JSONTemplateManager instance = new JSONTemplateManager();
    }

    public static JSONTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private JSONTemplateManager() {
        put("empty", new AbstractTemplateFactory<Object>() {

            public Object create() {
                return GenericEntityFactory.instance.create(JSONEntityDescriptorEnum.Object);
            }
        });
    }
}
