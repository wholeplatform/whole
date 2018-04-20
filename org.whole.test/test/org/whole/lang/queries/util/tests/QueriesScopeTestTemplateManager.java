package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesScopeTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesScopeTestTemplateManager instance = new QueriesScopeTestTemplateManager();
    }

    public static QueriesScopeTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesScopeTestTemplateManager() {
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
                b0.AssignActivity_();
                b0.Text("assignActivity");
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("fileName");
                b0.StringLiteral("QueriesTests");
                b0._Assign();
                b0.Assign_();
                b0.Variable("fileNameWithExtension");
                b0.StringLiteral("QueriesTests.xwl");
                b0._Assign();
                b0._Assignments();
                b0._AssignActivity();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Scope_();
                b2.ScopeNames_(0);
                b2._ScopeNames();
                b2.VariableRefStep("fileName");
                b2._Scope();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(0);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Sequence_(2);
                b2.VariableRefStep("fileName");
                b2.Scope_();
                b2.ScopeNames_(1);
                b2.Name("self");
                b2._ScopeNames();
                b2.VariableRefStep("fileName");
                b2._Scope();
                b2._Sequence();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                org.whole.lang.environment.builders.IEnvironmentBuilder b2 = (org.whole.lang.environment.builders.IEnvironmentBuilder) op.wGetBuilder(org.whole.lang.environment.reflect.EnvironmentLanguageKit.URI);
                b2.StringData("QueriesTests");
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Sequence_(2);
                b2.VariableRefStep("fileName");
                b2.Scope_();
                b2.ScopeNames_(0);
                b2._ScopeNames();
                b2.VariableRefStep("fileName");
                b2._Scope();
                b2._Sequence();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                org.whole.lang.environment.builders.IEnvironmentBuilder b2 = (org.whole.lang.environment.builders.IEnvironmentBuilder) op.wGetBuilder(org.whole.lang.environment.reflect.EnvironmentLanguageKit.URI);
                b2.StringData("QueriesTests");
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Sequence_(2);
                b2.VariableRefStep("fileName");
                b2.Scope_();
                b2.ScopeNames_(1);
                b2.Name("fileName");
                b2._ScopeNames();
                b2.Block_(2);
                b2.Filter_();
                b2.StringLiteral("testFileName");
                b2.VariableTest("fileName");
                b2._Filter();
                b2.VariableRefStep("fileName");
                b2._Block();
                b2._Scope();
                b2._Sequence();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(2);
                org.whole.lang.environment.builders.IEnvironmentBuilder b2 = (org.whole.lang.environment.builders.IEnvironmentBuilder) op.wGetBuilder(org.whole.lang.environment.reflect.EnvironmentLanguageKit.URI);
                b2.StringData("QueriesTests");
                b2.StringData("QueriesTests");
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Sequence_(3);
                b2.VariableRefStep("fileName");
                b2.VariableRefStep("fileNameWithExtension");
                b2.Scope_();
                b2.FreshNames_(1);
                b2.Name("fileName");
                b2._FreshNames();
                b2.Block_(2);
                b2.Filter_();
                b2.StringLiteral("testFileName");
                b2.VariableTest("fileName");
                b2._Filter();
                b2.Scope_();
                b2.ScopeNames_(1);
                b2.Name("fileName");
                b2._ScopeNames();
                b2.Block_(2);
                b2.Filter_();
                b2.StringLiteral("testFileName.extension");
                b2.VariableTest("fileNameWithExtension");
                b2._Filter();
                b2.Sequence_(2);
                b2.VariableRefStep("fileName");
                b2.VariableRefStep("fileNameWithExtension");
                b2._Sequence();
                b2._Block();
                b2._Scope();
                b2._Block();
                b2._Scope();
                b2._Sequence();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(4);
                org.whole.lang.environment.builders.IEnvironmentBuilder b2 = (org.whole.lang.environment.builders.IEnvironmentBuilder) op.wGetBuilder(org.whole.lang.environment.reflect.EnvironmentLanguageKit.URI);
                b2.StringData("QueriesTests");
                b2.StringData("QueriesTests.xwl");
                b2.StringData("testFileName");
                b2.StringData("testFileName.extension");
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }
}
