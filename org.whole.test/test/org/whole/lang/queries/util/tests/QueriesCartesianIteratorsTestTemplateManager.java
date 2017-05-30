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
    }

    public ITemplateFactory<IEntity> newfragment() {
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

    public ITemplateFactory<IEntity> newfragment1() {
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

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name1");
                b1.Types_(0);
                b1._Types();
                b1.Features_(3);
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("Type2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namex");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name2");
                b1.Types_(0);
                b1._Types();
                b1.Features_(2);
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namey");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
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

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name1");
                b1.Types_(0);
                b1._Types();
                b1.Features_(3);
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("Type2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namex");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name2");
                b1.Types_(0);
                b1._Types();
                b1.Features_(2);
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namey");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
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

    public ITemplateFactory<IEntity> newfragment6() {
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

    public ITemplateFactory<IEntity> newfragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name1");
                b1.Types_(0);
                b1._Types();
                b1.Features_(6);
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("TypeXX2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("Type2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namex");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name2");
                b1.Types_(0);
                b1._Types();
                b1.Features_(3);
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namey");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment8() {
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

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.ModelDeclarations_(2);
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name1");
                b1.Types_(0);
                b1._Types();
                b1.Features_(9);
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("TypeXX2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("Type2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namex");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("TypeXX2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("Type2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1.SimpleEntity_();
                b1.EntityModifiers_(0);
                b1._EntityModifiers();
                b1.SimpleName("Name2");
                b1.Types_(0);
                b1._Types();
                b1.Features_(6);
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("namey");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(0);
                b1._FeatureModifiers();
                b1.SimpleName("featureType");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("optional");
                b1._FeatureModifiers();
                b1.SimpleName("Type1");
                b1.SimpleName("name1");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("TypeXX2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1.Feature_();
                b1.FeatureModifiers_(1);
                b1.FeatureModifier("derived");
                b1._FeatureModifiers();
                b1.SimpleName("Type2");
                b1.SimpleName("name2");
                b0.Resolver();
                b1._Feature();
                b1._Features();
                b1._SimpleEntity();
                b1._ModelDeclarations();
                b0._StageUpFragment();
            }
        };
    }
}
