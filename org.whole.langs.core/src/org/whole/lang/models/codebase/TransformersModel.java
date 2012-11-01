package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class TransformersModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Transformers");
        b0.TypeRelations_(0);
        b0._TypeRelations();
        b0.ModelDeclarations_(6);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Transformer");
        b0.Types();
        b0.Features_(5);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Description");
        b0.SimpleName("description");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Contract");
        b0.SimpleName("contract");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Strategy");
        b0.SimpleName("strategy");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Rules");
        b0.SimpleName("rules");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Name");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Description");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Rules");
        b0.Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("ordered");
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("Rule");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Rule");
        b0.Types();
        b0.Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("RewriteRule");
        b0.Types_(1);
        b0.SimpleName("Rule");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Term");
        b0.SimpleName("pattern");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Term");
        b0.SimpleName("replacement");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Expression");
        b0.SimpleName("condition");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.transformers");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/Transformers");
        b0._Model();
    }
}
