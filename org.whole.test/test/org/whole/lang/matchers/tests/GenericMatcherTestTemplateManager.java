package org.whole.lang.matchers.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class GenericMatcherTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final GenericMatcherTestTemplateManager instance = new GenericMatcherTestTemplateManager();
    }

    public static GenericMatcherTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private GenericMatcherTestTemplateManager() {
        put("fragment", newfragment());
        put("fragment1", newfragment1());
        put("fragment2", newfragment2());
        put("fragment3", newfragment3());
        put("fragment4", newfragment4());
        put("fragment5", newfragment5());
        put("fragment6", newfragment6());
        put("fragment7", newfragment7());
        put("fragment8", newfragment8());
        put("fragment9", newfragment9());
        put("fragment10", newfragment10());
        put("fragment11", newfragment11());
        put("fragment12", newfragment12());
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("featureName");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v3");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("featureName");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Feature");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Feature");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Feature");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Feature");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.Features_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Feature");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#Feature");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b2._Features();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.ModelDeclarations_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleEntity");
                b1.VarName("v1");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleEntity");
                b1.VarName("v1");
                b1.Quantifier("!");
                b1._Variable();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.ModelDeclarations_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.ModelDeclarations_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleEntity");
                b1.VarName("v1");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#DataEntity");
                b1.VarName("v1");
                b1.Quantifier("!");
                b1._Variable();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.ModelDeclarations_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.ModelDeclarations_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.ModelDeclarations_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleEntity");
                b1.VarName("v1");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleEntity");
                b1.VarName("v1");
                b1.Quantifier("!");
                b1._Variable();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.ModelDeclarations_(2);
                b1.StageUpFragment_();
                b2.Model_();
                b2.SimpleName("ModelName");
                b2.TypeRelations_(0);
                b2._TypeRelations();
                b2.ModelDeclarations_(1);
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("EntityName");
                b2.Types_(1);
                b1.Resolver();
                b2._Types();
                b2.Features_(0);
                b2._Features();
                b2._SimpleEntity();
                b2._ModelDeclarations();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2._Model();
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.Model_();
                b2.SimpleName("ModelName");
                b2.TypeRelations_(0);
                b2._TypeRelations();
                b2.ModelDeclarations_(1);
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("EntityName");
                b2.Types_(1);
                b1.Resolver();
                b2._Types();
                b2.Features_(0);
                b2._Features();
                b2._SimpleEntity();
                b2._ModelDeclarations();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2._Model();
                b1._StageUpFragment();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0.MatchTest_();
                b1.StageUpFragment_();
                b2.ModelDeclarations_(2);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b1.VarName("v2");
                b1.Quantifier("!");
                b1._Variable();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Path();
            }
        };
    }
}
