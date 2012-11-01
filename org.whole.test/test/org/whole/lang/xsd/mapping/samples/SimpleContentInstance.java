package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class SimpleContentInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://samples.lang.whole.org/sample").getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Sample"));
        b0.Resolver();
        b0.wEntity_(e1.valueOf("SampleSeq"));
        b0.wEntity_(e1.valueOf("StringType"));
        b0.wEntity(e1.valueOf("XSID"), "id0");
        b0.wEntity(e1.valueOf("XSString"), "VAL4");
        b0._wEntity(e1.valueOf("StringType"));
        b0.wEntity_(e1.valueOf("LocalizedStringType"));
        b0.wEntity(e1.valueOf("XSID"), "id1");
        b0.wEntity(e1.valueOf("XSString"), "it");
        b0.wEntity(e1.valueOf("XSString"), "false");
        b0._wEntity(e1.valueOf("LocalizedStringType"));
        b0.wEntity_(e1.valueOf("TokenType"));
        b0.wEntity(e1.valueOf("XSID"), "id2");
        b0.wEntity(e1.valueOf("XSString"), "127");
        b0._wEntity(e1.valueOf("TokenType"));
        b0.wEntity_(e1.valueOf("LocalizedTokenType"));
        b0.wEntity(e1.valueOf("XSID"), "id3");
        b0.wEntity(e1.valueOf("XSString"), "it");
        b0.wEntity(e1.valueOf("XSString"), "P5Y");
        b0._wEntity(e1.valueOf("LocalizedTokenType"));
        b0.wEntity_(e1.valueOf("EnumType"));
        b0.wEntity(e1.valueOf("XSID"), "id4");
        b0.wEntity(e1.valueOf("EnumType1"), "VAL2");
        b0._wEntity(e1.valueOf("EnumType"));
        b0._wEntity(e1.valueOf("SampleSeq"));
        b0._wEntity(e1.valueOf("Sample"));
    }
}
