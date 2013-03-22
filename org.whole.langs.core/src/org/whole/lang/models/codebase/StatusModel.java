package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class StatusModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Status");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.ModelDeclarations_(2);
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Status");
        b0.Types_(0);
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Message");
        b0.SimpleName("error");
        b1.Resolver();
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Message");
        b0.SimpleName("cause");
        b1.Resolver();
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Message");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.status");
        b1.Resolver();
        b0.URI("whole:org.whole.lang.status:Status");
        b0._Model();
    }
}
