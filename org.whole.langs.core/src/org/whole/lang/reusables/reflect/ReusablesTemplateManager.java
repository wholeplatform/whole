package org.whole.lang.reusables.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.reusables.model.Adapt;
import org.whole.lang.factories.GenericEntityFactory;

/**
 *  @generator  Whole
 */
public class ReusablesTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final ReusablesTemplateManager instance = new ReusablesTemplateManager();
    }

    public static ReusablesTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private ReusablesTemplateManager() {
        put("empty", new AbstractTemplateFactory<Adapt>() {

            public Adapt create() {
                return GenericEntityFactory.instance.create(ReusablesEntityDescriptorEnum.Adapt);
            }
        });
    }
}
