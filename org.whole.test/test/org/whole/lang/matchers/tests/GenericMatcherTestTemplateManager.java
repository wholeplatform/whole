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
        put("fragment13", newfragment13());
        put("fragment14", newfragment14());
        put("fragment15", newfragment15());
        put("fragment16", newfragment16());
        put("fragment17", newfragment17());
        put("fragment18", newfragment18());
        put("fragment19", newfragment19());
        put("fragment20", newfragment20());
        put("fragment21", newfragment21());
        put("fragment22", newfragment22());
        put("fragment23", newfragment23());
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("featureName");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v3");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("featureName");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment13() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Commons#Any");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment14() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v1");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment15() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.Features_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#Feature");
                b0.VarName("v2");
                b0.Quantifier("?");
                b0._Variable();
                b1._Features();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment16() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#SimpleEntity");
                b0.VarName("v1");
                b0.Quantifier("!");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#SimpleEntity");
                b0.VarName("v1");
                b0.Quantifier("!");
                b0._Variable();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment17() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment18() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#SimpleEntity");
                b0.VarName("v1");
                b0.Quantifier("!");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#DataEntity");
                b0.VarName("v1");
                b0.Quantifier("!");
                b0._Variable();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment19() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment20() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment21() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#SimpleEntity");
                b0.VarName("v1");
                b0.Quantifier("!");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#SimpleEntity");
                b0.VarName("v1");
                b0.Quantifier("!");
                b0._Variable();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment22() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.StageUpFragment_();
                b1.Model_();
                b1.SimpleName("ModelName");
                b1.TypeRelations_(0);
                b1._TypeRelations();
                b1.ModelDeclarations_(1);
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("EntityName");
                b1.Types_(1);
                b0.Resolver();
                b1._Types();
                b1.Features_(0);
                b1._Features();
                b1._SimpleEntity();
                b1._ModelDeclarations();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b1._Model();
                b0._StageUpFragment();
                b0.StageUpFragment_();
                b1.Model_();
                b1.SimpleName("ModelName");
                b1.TypeRelations_(0);
                b1._TypeRelations();
                b1.ModelDeclarations_(1);
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("EntityName");
                b1.Types_(1);
                b0.Resolver();
                b1._Types();
                b1.Features_(0);
                b1._Features();
                b1._SimpleEntity();
                b1._ModelDeclarations();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b1._Model();
                b0._StageUpFragment();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment23() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Models#ModelDeclaration");
                b0.VarName("v2");
                b0.Quantifier("!");
                b0._Variable();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }
}
