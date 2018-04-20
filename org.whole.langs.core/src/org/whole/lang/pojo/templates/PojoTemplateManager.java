package org.whole.lang.pojo.templates;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class PojoTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final PojoTemplateManager instance = new PojoTemplateManager();
    }

    public static PojoTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private PojoTemplateManager() {
        put("findAllProductDeclarationsWithTemplateName", newfindAllProductDeclarationsWithTemplateName());
        put("findAllProductDeclarationsWithEmptyTemplate", newfindAllProductDeclarationsWithEmptyTemplate());
        put("findAllPropertiesWithoutTemplate", newfindAllPropertiesWithoutTemplate());
        put("findAllParametersWithoutType", newfindAllParametersWithoutType());
        put("findAllParametersWithoutTemlate", newfindAllParametersWithoutTemlate());
        put("findPropertyType", newfindPropertyType());
        put("findPropertyTemplate", newfindPropertyTemplate());
        put("findProductDeclarationByName", newfindProductDeclarationByName());
        put("findProductDeclarationByTemplateName", newfindProductDeclarationByTemplateName());
        put("findAllPropertyTypes", newfindAllPropertyTypes());
        put("findPropertyByTemplate", newfindPropertyByTemplate());
        put("findAllReadOnlyFields", newfindAllReadOnlyFields());
        put("findParameterByTemplate", newfindParameterByTemplate());
    }

    public ITemplateFactory<IEntity> newfindAllProductDeclarationsWithTemplateName() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.And_(2);
                b0.TypeTest("http://lang.whole.org/Pojo#Name");
                b0.KindTest("IMPL");
                b0._And();
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindAllProductDeclarationsWithEmptyTemplate() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.KindTest("RESOLVER");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindAllPropertiesWithoutTemplate() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("http://lang.whole.org/Pojo#PojoDeclaration");
                b0.VariableTest("pojo");
                b0._And();
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Pojo#properties");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.KindTest("RESOLVER");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindAllParametersWithoutType() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(6);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("http://lang.whole.org/Pojo#PojoDeclaration");
                b0.VariableTest("pojo");
                b0._And();
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Pojo#constructors");
                b0.ChildStep();
                b0.FeatureStep("http://lang.whole.org/Pojo#parameters");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#type");
                b0.KindTest("RESOLVER");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindAllParametersWithoutTemlate() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(6);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("http://lang.whole.org/Pojo#PojoDeclaration");
                b0.VariableTest("pojo");
                b0._And();
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Pojo#constructors");
                b0.ChildStep();
                b0.FeatureStep("http://lang.whole.org/Pojo#parameters");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.KindTest("RESOLVER");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindPropertyType() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("http://lang.whole.org/Pojo#properties");
                b0.Filter_();
                b0.ChildStep();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Pojo#type");
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindPropertyTemplate() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("http://lang.whole.org/Pojo#properties");
                b0.Filter_();
                b0.ChildStep();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindProductDeclarationByName() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#name");
                b0.VariableTest("name");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindProductDeclarationByTemplateName() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.VariableTest("templateName");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindAllPropertyTypes() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(5);
                b0.FeatureStep("http://lang.whole.org/Pojo#declarations");
                b0.ChildStep();
                b0.FeatureStep("http://lang.whole.org/Pojo#properties");
                b0.Filter_();
                b0.ChildStep();
                b0.VariableTest("property");
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Pojo#type");
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindPropertyByTemplate() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("http://lang.whole.org/Pojo#properties");
                b0.Filter_();
                b0.ChildStep();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.VariableTest("template");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindAllReadOnlyFields() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("http://lang.whole.org/Pojo#properties");
                b0.Filter_();
                b0.ChildStep();
                b0.Some_();
                b0.Path_(2);
                b0.FeatureStep("http://lang.whole.org/Pojo#annotations");
                b0.Filter_();
                b0.ChildStep();
                b0.MatchTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.pojo.builders.IPojoBuilder b2 = (org.whole.lang.pojo.builders.IPojoBuilder) op.wGetBuilder(org.whole.lang.pojo.reflect.PojoLanguageKit.URI);
                b2.Modifier("READ_ONLY");
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Filter();
                b0._Path();
                b1.Resolver();
                b0._Some();
                b0._Filter();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.VariableTest("template");
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindParameterByTemplate() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("http://lang.whole.org/Pojo#parameters");
                b0.Filter_();
                b0.ChildStep();
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Pojo#template");
                b0.VariableTest("template");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._Filter();
                b0._Path();
            }
        };
    }
}
