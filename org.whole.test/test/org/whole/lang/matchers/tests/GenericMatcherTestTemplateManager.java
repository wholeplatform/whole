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
        put("fragment", newFragment());
        put("fragment1", newFragment1());
        put("fragment2", newFragment2());
        put("fragment3", newFragment3());
        put("fragment4", newFragment4());
        put("fragment5", newFragment5());
        put("fragment6", newFragment6());
        put("fragment7", newFragment7());
        put("fragment8", newFragment8());
        put("fragment9", newFragment9());
        put("fragment10", newFragment10());
        put("fragment11", newFragment11());
        put("fragment12", newFragment12());
        put("fragment13", newFragment13());
        put("fragment14", newFragment14());
        put("fragment15", newFragment15());
        put("fragment16", newFragment16());
        put("fragment17", newFragment17());
        put("fragment18", newFragment18());
        put("fragment19", newFragment19());
        put("fragment20", newFragment20());
        put("fragment21", newFragment21());
        put("fragment22", newFragment22());
        put("fragment23", newFragment23());
    }

    public ITemplateFactory<IEntity> newFragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v1");
                b1.Quantifier("?");
                b1._Variable();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("featureName");
                b1.Resolver();
                b0._Feature();
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("v2");
                b1.Quantifier("?");
                b1._Variable();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("featureName");
                b1.Resolver();
                b0._Feature();
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment13() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment14() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment15() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.Features_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._Features();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment16() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment17() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment18() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment19() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment20() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment21() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment22() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Model_();
                b0.SimpleName("ModelName");
                b0.TypeRelations_(0);
                b0._TypeRelations();
                b0.ModelDeclarations_(1);
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("EntityName");
                b0.Types_(1);
                b1.Resolver();
                b0._Types();
                b0.Features_(0);
                b0._Features();
                b0._SimpleEntity();
                b0._ModelDeclarations();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b0._Model();
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b0.Model_();
                b0.SimpleName("ModelName");
                b0.TypeRelations_(0);
                b0._TypeRelations();
                b0.ModelDeclarations_(1);
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("EntityName");
                b0.Types_(1);
                b1.Resolver();
                b0._Types();
                b0.Features_(0);
                b0._Features();
                b0._SimpleEntity();
                b0._ModelDeclarations();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b0._Model();
                b1._StageUpFragment();
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment23() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
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
                b0._ModelDeclarations();
            }
        };
    }
}
