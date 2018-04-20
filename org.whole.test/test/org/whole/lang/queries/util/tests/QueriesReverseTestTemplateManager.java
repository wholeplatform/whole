package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesReverseTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesReverseTestTemplateManager instance = new QueriesReverseTestTemplateManager();
    }

    public static QueriesReverseTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesReverseTestTemplateManager() {
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
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("assignActivity");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("instance");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Multiplication_(6);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(4);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2._Multiplication();
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
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(2);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Reverse_();
                b2.ChildStep();
                b2._Reverse();
                b2._Path();
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
                b1.Misc_(6);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(4);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(0);
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
                b2.Path_(2);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Reverse_();
                b2.DescendantStep();
                b2._Reverse();
                b2._Path();
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
                b1.Misc_(15);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2.Integer(11);
                b2.Integer(10);
                b2.Integer(9);
                b2.Integer(8);
                b2.Integer(7);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(6);
                b2.Integer(5);
                b2.Integer(4);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(3);
                b2.Integer(2);
                b2.Integer(1);
                b2.Integer(0);
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
                b2.Path_(2);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Reverse_();
                b2.DescendantOrSelfStep();
                b2._Reverse();
                b2._Path();
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
                b1.Misc_(16);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Multiplication_(6);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(4);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2._Multiplication();
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2.Integer(11);
                b2.Integer(10);
                b2.Integer(9);
                b2.Integer(8);
                b2.Integer(7);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(6);
                b2.Integer(5);
                b2.Integer(4);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(3);
                b2.Integer(2);
                b2.Integer(1);
                b2.Integer(0);
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
                b2.Path_(3);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(2);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.FollowingSiblingStep();
                b2._Reverse();
                b2._Path();
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
                b1.Misc_(3);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
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
                b2.Path_(3);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(2);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.FollowingSiblingOrSelfStep();
                b2._Reverse();
                b2._Path();
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
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(4);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment11() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(3);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(2);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.PrecedingSiblingStep();
                b2._Reverse();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment12() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(2);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment13() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(3);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(2);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.PrecedingSiblingOrSelfStep();
                b2._Reverse();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment14() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(3);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(4);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment15() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(3);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(2);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.AncestorOrSelfStep();
                b2._Reverse();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment16() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(2);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Multiplication_(6);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(4);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2._Multiplication();
                b2.Integer(4);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment17() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(3);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(2);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.AncestorStep();
                b2._Reverse();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment18() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Multiplication_(6);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(4);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2._Multiplication();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment19() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(4);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(1);
                b2._IndexTest();
                b2._Filter();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(1);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.AncestorStep();
                b2._Reverse();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment20() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(2);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Multiplication_(6);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(4);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2._Multiplication();
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment21() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(1);
                b0.StageDownFragment_();
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.Path_(4);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("instance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(1);
                b2._IndexTest();
                b2._Filter();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(1);
                b2._IndexTest();
                b2._Filter();
                b2.Reverse_();
                b2.AncestorOrSelfStep();
                b2._Reverse();
                b2._Path();
                b0._StageDownFragment();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment22() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.misc.builders.IMiscBuilder b1 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b1.Misc_(3);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Multiplication_(6);
                b2.Integer(0);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(4);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(6);
                b2._Addition();
                b2.Integer(7);
                b2.Addition_(4);
                b2.Integer(8);
                b2.Integer(9);
                b2.Integer(10);
                b2.Integer(11);
                b2._Addition();
                b2._Multiplication();
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
                b2.Integer(2);
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }
}
