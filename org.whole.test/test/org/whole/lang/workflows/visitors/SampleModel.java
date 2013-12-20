package org.whole.lang.workflows.visitors;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class SampleModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Sample");
        b0.TypeRelations();
        b0.ModelDeclarations_(3);
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DataList");
        b0.Types();
        b0.ComponentModifiers();
        b0.SimpleName("DataType");
        b0._CompositeEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("StringType");
        b0.Types_(1);
        b0.SimpleName("DataType");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("IntType");
        b0.Types_(1);
        b0.SimpleName("DataType");
        b0._Types();
        b0.DataType("int");
        b0._DataEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/SampleM");
        b0._Model();
    }
}
