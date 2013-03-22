package org.whole.lang.status.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class StatusTemplate extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("whole:org.whole.lang.status:Status").getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Status"));
        b0.wEntity(e1.valueOf("Message"), "error message");
        b0.wEntity(e1.valueOf("Message"), "cause message");
        b0._wEntity(e1.valueOf("Status"));
    }
}
