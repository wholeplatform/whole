package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class ChoiceSampleInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://lang.whole.org/MT3.001.01/").getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Document"));
        b0.wEntity_(e1.valueOf("DocumentSeq"));
        b0.wEntity_(e1.valueOf("GroupHeader"));
        b0.wEntity_(e1.valueOf("GroupHeaderSeq"));
        b0.wEntity(e1.valueOf("XSString"), "ID:001");
        b0.wEntity(e1.valueOf("XSString"), "23/10/2008");
        b0.wEntity(e1.valueOf("XSString"), "1000.00");
        b0.wEntity(e1.valueOf("XSInt"), 2);
        b0._wEntity(e1.valueOf("GroupHeaderSeq"));
        b0._wEntity(e1.valueOf("GroupHeader"));
        b0.wEntity_(e1.valueOf("DocumentList"), 2);
        b0.wEntity_(e1.valueOf("MessageType"));
        b0.wEntity_(e1.valueOf("MessageTypeSeq"));
        b0.wEntity(e1.valueOf("XSString"), "ID:002");
        b0.wEntity(e1.valueOf("XSString"), "500.50");
        b0.wEntity_(e1.valueOf("DebitorType"));
        b0.wEntity(e1.valueOf("XSString"), "ABNANAL02XX");
        b0._wEntity(e1.valueOf("DebitorType"));
        b0._wEntity(e1.valueOf("MessageTypeSeq"));
        b0._wEntity(e1.valueOf("MessageType"));
        b0.wEntity_(e1.valueOf("MessageType"));
        b0.wEntity_(e1.valueOf("MessageTypeSeq"));
        b0.wEntity(e1.valueOf("XSString"), "ID:003");
        b0.wEntity(e1.valueOf("XSString"), "499.50");
        b0.wEntity_(e1.valueOf("DebitorType"));
        b0.wEntity(e1.valueOf("XSString"), "ABNANAL02XX");
        b0._wEntity(e1.valueOf("DebitorType"));
        b0._wEntity(e1.valueOf("MessageTypeSeq"));
        b0._wEntity(e1.valueOf("MessageType"));
        b0._wEntity(e1.valueOf("DocumentList"));
        b0._wEntity(e1.valueOf("DocumentSeq"));
        b0._wEntity(e1.valueOf("Document"));
    }
}
