package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class SchemeModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Scheme");
        b0.TypeRelations_(0);
        b0._TypeRelations();
        b0.ModelDeclarations_(23);
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Definitions");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Definition");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Definition");
        b0.Types_(0);
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpression");
        b0.SimpleName("expression");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Branches");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Branch");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Branch");
        b0.Types_(0);
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpression");
        b0.SimpleName("test");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpression");
        b0.SimpleName("body");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("SchemeExpressions");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("SchemeExpression");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("SchemeExpression");
        b0.Types_(0);
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ApplyExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpressions");
        b0.SimpleName("expressions");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("LambdaExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Names");
        b0.SimpleName("args");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpression");
        b0.SimpleName("body");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("AndExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpressions");
        b0.SimpleName("expressions");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("OrExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpressions");
        b0.SimpleName("expressions");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("CondExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Branches");
        b0.SimpleName("branches");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpression");
        b0.SimpleName("elseBody");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("LocalExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Definitions");
        b0.SimpleName("definitions");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpression");
        b0.SimpleName("body");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IdExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("ConstExpression");
        b0.Types_(1);
        b0.SimpleName("SchemeExpression");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("ClosureValue");
        b0.Types_(1);
        b0.SimpleName("ConstExpression");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("Names");
        b0.SimpleName("args");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeExpression");
        b0.SimpleName("body");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("SchemeEnvironment");
        b0.SimpleName("env");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.EnumEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("BuiltinValue");
        b0.Types_(1);
        b0.SimpleName("ConstExpression");
        b0._Types();
        b0.EnumValues_(16);
        b0.EnumValue("boolp");
        b0.EnumValue("car");
        b0.EnumValue("cdr");
        b0.EnumValue("cons");
        b0.EnumValue("divide");
        b0.EnumValue("eqvp");
        b0.EnumValue("intp");
        b0.EnumValue("list");
        b0.EnumValue("minus");
        b0.EnumValue("nullp");
        b0.EnumValue("pairp");
        b0.EnumValue("plus");
        b0.EnumValue("rel");
        b0.EnumValue("stringeq");
        b0.EnumValue("stringp");
        b0.EnumValue("times");
        b0._EnumValues();
        b0._EnumEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("BooleanValue");
        b0.Types_(1);
        b0.SimpleName("ConstExpression");
        b0._Types();
        b0.DataType("boolean");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("IntValue");
        b0.Types_(1);
        b0.SimpleName("ConstExpression");
        b0._Types();
        b0.DataType("int");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("StringValue");
        b0.Types_(1);
        b0.SimpleName("ConstExpression");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("PairValue");
        b0.Types_(1);
        b0.SimpleName("ConstExpression");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("ConstExpression");
        b0.SimpleName("car");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(0);
        b0._FeatureModifiers();
        b0.SimpleName("ConstExpression");
        b0.SimpleName("cdr");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Names");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Name");
        b0._CompositeEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Name");
        b0.Types_(0);
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("SchemeEnvironment");
        b0.Types_(0);
        b0._Types();
        b0.DataType("org.whole.lang.bindings.IBindingManager");
        b0._DataEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.scheme");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/Scheme");
        b0._Model();
    }
}
