package org.whole.lang.pojo.templates;

import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class PojoTemplateManager extends AbstractTemplateManager {

    private static PojoTemplateManager instance;

    public static PojoTemplateManager instance() {
        if (instance == null)
            instance = new PojoTemplateManager();
                return instance;
    }

    private PojoTemplateManager() {
        put("findAllProductDeclarationsWithTemplateName", newFindAllProductDeclarationsWithTemplateName());
        put("findAllProductDeclarationsWithEmptyTemplate", newFindAllProductDeclarationsWithEmptyTemplate());
        put("findAllPropertiesWithoutTemplate", newFindAllPropertiesWithoutTemplate());
        put("findAllParametersWithoutType", newFindAllParametersWithoutType());
        put("findAllParametersWithoutTemlate", newFindAllParametersWithoutTemlate());
        put("findPropertyType", newFindPropertyType());
        put("findPropertyTemplate", newFindPropertyTemplate());
        put("findProductDeclarationByName", newFindProductDeclarationByName());
        put("findProductDeclarationByTemplateName", newFindProductDeclarationByTemplateName());
        put("findAllPropertyTypes", newFindAllPropertyTypes());
        put("findPropertyByTemplate", newFindPropertyByTemplate());
        put("findAllReadOnlyFields", newFindAllReadOnlyFields());
        put("findParameterByTemplate", newFindParameterByTemplate());
    }

    public ITemplateFactory newFindAllProductDeclarationsWithTemplateName() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.And_();
                b0.TypeTest("Name");
                b0.KindTest("IMPL");
                b0._And();
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindAllProductDeclarationsWithEmptyTemplate() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.KindTest("RESOLVER");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindAllPropertiesWithoutTemplate() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("PojoDeclaration");
                b0.VariableTest("pojo");
                b0._And();
                b0._Filter();
                b0.FeatureStep("properties");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.KindTest("RESOLVER");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindAllParametersWithoutType() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(6);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("PojoDeclaration");
                b0.VariableTest("pojo");
                b0._And();
                b0._Filter();
                b0.FeatureStep("constructors");
                b0.ChildStep();
                b0.FeatureStep("parameters");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("type");
                b0.KindTest("RESOLVER");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindAllParametersWithoutTemlate() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(6);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("PojoDeclaration");
                b0.VariableTest("pojo");
                b0._And();
                b0._Filter();
                b0.FeatureStep("constructors");
                b0.ChildStep();
                b0.FeatureStep("parameters");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.KindTest("RESOLVER");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindPropertyType() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("properties");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0.FeatureStep("type");
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindPropertyTemplate() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("properties");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0.FeatureStep("template");
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindProductDeclarationByName() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindProductDeclarationByTemplateName() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.VariableTest("templateName");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindAllPropertyTypes() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(5);
                b0.FeatureStep("declarations");
                b0.ChildStep();
                b0.FeatureStep("properties");
                b0.Filter_();
                b0.ChildStep();
                b0.VariableTest("property");
                b0._Filter();
                b0.FeatureStep("type");
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindPropertyByTemplate() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("properties");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.VariableTest("template");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindAllReadOnlyFields() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("properties");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Path_(2);
                b0.FeatureStep("annotations");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.pojo.builders.IPojoBuilder b2 = (org.whole.lang.pojo.builders.IPojoBuilder) op.wGetBuilder(org.whole.lang.pojo.reflect.PojoLanguageKit.URI);
                b2.Modifier("READ_ONLY");
                b1._StageUpFragment();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b0._ExpressionTest();
                b0._Filter();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.VariableTest("template");
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory newFindParameterByTemplate() {
        return new AbstractTemplateFactory() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("parameters");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("template");
                b0.VariableTest("template");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
            }
        };
    }
}
