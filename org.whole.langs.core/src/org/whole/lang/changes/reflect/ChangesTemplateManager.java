package org.whole.lang.changes.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.changes.model.RevisionTrack;
import org.whole.lang.factories.GenericEntityFactory;

/**
 *  @generator  Whole
 */
public class ChangesTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final ChangesTemplateManager instance = new ChangesTemplateManager();
    }

    public static ChangesTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private ChangesTemplateManager() {
        put("empty", new AbstractTemplateFactory<RevisionTrack>() {

            public RevisionTrack create() {
                return GenericEntityFactory.instance.create(ChangesEntityDescriptorEnum.RevisionTrack);
            }
        });
    }
}
