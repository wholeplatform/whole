package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesCartesianIteratorsTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesCartesianIteratorsTestTemplateManager instance = new QueriesCartesianIteratorsTestTemplateManager();
    }

    public static QueriesCartesianIteratorsTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesCartesianIteratorsTestTemplateManager() {
        put("fragment10", newFragment10());
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
    }

    public ITemplateFactory<IEntity> newFragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.java.builders.IJavaBuilder b0 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b0.InfixExpression_();
                b0.StringLiteral("");
                b0.InfixOperator("+");
                b0.ParenthesizedExpression_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._ParenthesizedExpression();
                b1.Resolver();
                b0._InfixExpression();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("create models");
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("leftValues");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.ModelDeclarations_(2);
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("Name1");
                b2.Types_(0);
                b2._Types();
                b2.Features_(3);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("name1");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("name2");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("namex");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b2._SimpleEntity();
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("Name2");
                b2.Types_(0);
                b2._Types();
                b2.Features_(2);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("namey");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("name1");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b2._SimpleEntity();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0._Assign();
                b0.Assign_();
                b0.Variable("rightValues");
                b1.StageUpFragment_();
                b2.Features_(3);
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("optional");
                b2._FeatureModifiers();
                b2.SimpleName("Type1");
                b2.SimpleName("name1");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("derived");
                b2._FeatureModifiers();
                b2.SimpleName("TypeXX2");
                b2.SimpleName("name2");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("derived");
                b2._FeatureModifiers();
                b2.SimpleName("Type2");
                b2.SimpleName("name2");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("leftValues");
                b1.Quantifier("!");
                b1._Variable();
                b1._StageUpFragment();
                b0.VariableTest("result");
                b0._Filter();
                b0.CartesianUpdate_();
                b0.Path_(4);
                b0.VariableRefStep("result");
                b0.ChildStep();
                b0.FeatureStep("features");
                b0.ChildStep();
                b0._Path();
                b0.Block_(2);
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("featureName");
                b0._Filter();
                b0.Path_(2);
                b0.VariableRefStep("rightValues");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("featureName");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b0._Block();
                b0._CartesianUpdate();
                b0.VariableRefStep("result");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name1");
                b0.Types_(0);
                b0._Types();
                b0.Features_(3);
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namex");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name2");
                b0.Types_(0);
                b0._Types();
                b0.Features_(2);
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namey");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("leftValues");
                b1.Quantifier("!");
                b1._Variable();
                b1._StageUpFragment();
                b0.VariableTest("result");
                b0._Filter();
                b0.CartesianUpdate_();
                b0.Path_(4);
                b0.VariableRefStep("result");
                b0.ChildStep();
                b0.FeatureStep("features");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("featureName");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b0.Path_(2);
                b0.VariableRefStep("rightValues");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("featureName");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b0._CartesianUpdate();
                b0.VariableRefStep("result");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name1");
                b0.Types_(0);
                b0._Types();
                b0.Features_(3);
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namex");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name2");
                b0.Types_(0);
                b0._Types();
                b0.Features_(2);
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namey");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("create models");
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("leftValues");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.ModelDeclarations_(2);
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("Name1");
                b2.Types_(0);
                b2._Types();
                b2.Features_(3);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("name1");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("name2");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("namex");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b2._SimpleEntity();
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b2.SimpleName("Name2");
                b2.Types_(0);
                b2._Types();
                b2.Features_(2);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("namey");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("featureType");
                b2.SimpleName("name1");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b2._SimpleEntity();
                b2._ModelDeclarations();
                b1._StageUpFragment();
                b0._Assign();
                b0.Assign_();
                b0.Variable("rightValues");
                b1.StageUpFragment_();
                b2.Features_(3);
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("optional");
                b2._FeatureModifiers();
                b2.SimpleName("Type1");
                b2.SimpleName("name1");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("derived");
                b2._FeatureModifiers();
                b2.SimpleName("TypeXX2");
                b2.SimpleName("name2");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("derived");
                b2._FeatureModifiers();
                b2.SimpleName("Type2");
                b2.SimpleName("name2");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("leftValues");
                b1.Quantifier("!");
                b1._Variable();
                b1._StageUpFragment();
                b0.VariableTest("result");
                b0._Filter();
                b0.CartesianInsert_();
                b0.Placement("BEFORE");
                b0.Path_(4);
                b0.VariableRefStep("result");
                b0.ChildStep();
                b0.FeatureStep("features");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("featureName");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b0.Path_(2);
                b0.VariableRefStep("rightValues");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("featureName");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b0._CartesianInsert();
                b0.VariableRefStep("result");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name1");
                b0.Types_(0);
                b0._Types();
                b0.Features_(6);
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("TypeXX2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namex");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name2");
                b0.Types_(0);
                b0._Types();
                b0.Features_(3);
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namey");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Commons#Any");
                b1.VarName("leftValues");
                b1.Quantifier("!");
                b1._Variable();
                b1._StageUpFragment();
                b0.VariableTest("result");
                b0._Filter();
                b0.CartesianInsert_();
                b0.Placement("INTO");
                b0.Path_(3);
                b0.VariableRefStep("result");
                b0.ChildStep();
                b0.FeatureStep("features");
                b0._Path();
                b0.Path_(2);
                b0.VariableRefStep("rightValues");
                b0.ChildStep();
                b0._Path();
                b0._CartesianInsert();
                b0.VariableRefStep("result");
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name1");
                b0.Types_(0);
                b0._Types();
                b0.Features_(9);
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("TypeXX2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namex");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("TypeXX2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name2");
                b0.Types_(0);
                b0._Types();
                b0.Features_(6);
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namey");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("TypeXX2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0._ModelDeclarations();
            }
        };
    }
}
