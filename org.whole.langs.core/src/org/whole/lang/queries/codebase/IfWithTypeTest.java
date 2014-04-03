package org.whole.lang.queries.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.templates.AbstractTemplateFactory;

public class IfWithTypeTest extends AbstractTemplateFactory<org.whole.lang.queries.model.If> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b0.If_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Variable("typeTest", QueriesEntityDescriptorEnum.TypeTest, QuantifierEnum.MANDATORY);
        b1.Variable("expression", CommonsEntityDescriptorEnum.Any, QuantifierEnum.MANDATORY);
        b0._If();
    }
}
