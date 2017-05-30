package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesStagingTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesStagingTestTemplateManager instance = new QueriesStagingTestTemplateManager();
    }

    public static QueriesStagingTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesStagingTestTemplateManager() {
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
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateModel_();
                b0.Text("create feature");
                b0.Variable("feature");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("optional");
                b2._FeatureModifiers();
                b2.SimpleName("Type");
                b2.SimpleName("name");
                b1.Resolver();
                b2._Feature();
                b1._StageUpFragment();
                b1.Resolver();
                b0._CreateModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Do_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b1.StageDownFragment_();
                b0.Path_(2);
                b0.VariableRefStep("feature");
                b0.FeatureStep("type");
                b0._Path();
                b1._StageDownFragment();
                b1._StageUpFragment();
                b0._Do();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.VariableRefStep("feature");
                b0.FeatureStep("type");
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.SimpleName("Type");
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateModel_();
                b0.Text("create feature");
                b0.Variable("feature");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("optional");
                b2._FeatureModifiers();
                b2.SimpleName("Type");
                b2.SimpleName("name");
                b1.Resolver();
                b2._Feature();
                b1._StageUpFragment();
                b1.Resolver();
                b0._CreateModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Do_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b1.StageDownFragment_();
                b0.Singleton_();
                b0.Path_(2);
                b0.VariableRefStep("feature");
                b0.FeatureStep("type");
                b0._Path();
                b0._Singleton();
                b1._StageDownFragment();
                b1._StageUpFragment();
                b0._Do();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.VariableRefStep("feature");
                b0.FeatureStep("type");
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b1 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b1.SimpleName("Type");
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.CreateModel_();
                b0.Text("create feature");
                b0.Variable("feature");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Feature_();
                b2.FeatureModifiers_(1);
                b2.FeatureModifier("optional");
                b2._FeatureModifiers();
                b2.SimpleName("Type");
                b2.SimpleName("name");
                b1.Resolver();
                b2._Feature();
                b1._StageUpFragment();
                b1.Resolver();
                b0._CreateModel();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Do_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.InfixExpression_();
                b2.StringLiteral("");
                b2.InfixOperator("+");
                b2.ParenthesizedExpression_();
                b1.StageDownFragment_();
                b0.Path_(2);
                b0.VariableRefStep("feature");
                b0.FeatureStep("UNKfeatureStep");
                b0._Path();
                b1._StageDownFragment();
                b2._ParenthesizedExpression();
                b1.Resolver();
                b2._InfixExpression();
                b1._StageUpFragment();
                b0._Do();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b1 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b1.InfixExpression_();
                b1.StringLiteral("");
                b1.InfixOperator("+");
                b1.ParenthesizedExpression_();
                b0.Resolver();
                b1._ParenthesizedExpression();
                b0.Resolver();
                b1._InfixExpression();
                b0._StageUpFragment();
            }
        };
    }
}
