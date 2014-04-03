package org.whole.lang.modules.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.modules.model.Module;
import org.whole.lang.factories.GenericEntityFactory;

/**
 *  @generator  Whole
 */
public class ModulesTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final ModulesTemplateManager instance = new ModulesTemplateManager();
    }

    public static ModulesTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private ModulesTemplateManager() {
        put("empty", new AbstractTemplateFactory<Module>() {

            public Module create() {
                return GenericEntityFactory.instance.create(ModulesEntityDescriptorEnum.Module);
            }
        });
    }
}
