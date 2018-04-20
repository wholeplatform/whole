package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesQuantifiedPredicateBindingTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesQuantifiedPredicateBindingTestTemplateManager instance = new QueriesQuantifiedPredicateBindingTestTemplateManager();
    }

    public static QueriesQuantifiedPredicateBindingTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesQuantifiedPredicateBindingTestTemplateManager() {
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
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("assignActivity");
                b0.Assignments_(1);
                b0.Assign_();
                b0.Variable("instance");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Multiplication_(7);
                b2.Integer(0);
                b2.Division_();
                b2.Integer(1);
                b2.Integer(2);
                b2._Division();
                b2.Integer(3);
                b2.Integer(4);
                b2.Subtraction_();
                b2.Integer(5);
                b2.Integer(6);
                b2._Subtraction();
                b2.Integer(7);
                b2.Subtraction_();
                b2.Integer(8);
                b2.Integer(9);
                b2._Subtraction();
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
                b2.Scope_();
                b2.FreshNames_(1);
                b2.Name("exp");
                b2._FreshNames();
                b2.Select_();
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(2);
                b3.Integer(5);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Math#Expression");
                b0.VarName("exp");
                b0.Quantifier("!");
                b0._Variable();
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.VariableRefStep("instance");
                b2.One_();
                b2.DescendantOrSelfStep();
                b2.And_(2);
                b2.TypeTest("Subtraction");
                b2.VariableTest("exp");
                b2._And();
                b2._One();
                b2._Filter();
                b0.Resolver();
                b2.TemplateNames();
                b2._Select();
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
                b2.Scope_();
                b2.FreshNames_(1);
                b2.Name("exp");
                b2._FreshNames();
                b2.Select_();
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(2);
                b3.Integer(5);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Math#Expression");
                b0.VarName("exp");
                b0.Quantifier("!");
                b0._Variable();
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.VariableRefStep("instance");
                b2.One_();
                b2.DescendantOrSelfStep();
                b2.And_(2);
                b2.TypeTest("Division");
                b2.VariableTest("exp");
                b2._And();
                b2._One();
                b2._Filter();
                b0.Resolver();
                b2.TemplateNames();
                b2._Select();
                b2._Scope();
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
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Division_();
                b2.Integer(1);
                b2.Integer(2);
                b2._Division();
                b2._Addition();
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
                b2.Scope_();
                b2.FreshNames_(1);
                b2.Name("exp");
                b2._FreshNames();
                b2.Select_();
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(2);
                b3.Integer(5);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Math#Expression");
                b0.VarName("exp");
                b0.Quantifier("!");
                b0._Variable();
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.VariableRefStep("instance");
                b2.Some_();
                b2.DescendantOrSelfStep();
                b2.And_(2);
                b2.TypeTest("Remainder");
                b2.VariableTest("exp");
                b2._And();
                b2._Some();
                b2._Filter();
                b0.Resolver();
                b2.TemplateNames();
                b2._Select();
                b2._Scope();
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
                b1.Misc_(0);
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
                b2.Scope_();
                b2.FreshNames_(1);
                b2.Name("exp");
                b2._FreshNames();
                b2.Select_();
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(2);
                b3.Integer(5);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Math#Expression");
                b0.VarName("exp");
                b0.Quantifier("!");
                b0._Variable();
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.VariableRefStep("instance");
                b2.Some_();
                b2.DescendantOrSelfStep();
                b2.And_(2);
                b2.TypeTest("Subtraction");
                b2.VariableTest("exp");
                b2._And();
                b2._Some();
                b2._Filter();
                b0.Resolver();
                b2.TemplateNames();
                b2._Select();
                b2._Scope();
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
                b1.Misc_(1);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Subtraction_();
                b2.Integer(5);
                b2.Integer(6);
                b2._Subtraction();
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
                b2.Scope_();
                b2.FreshNames_(1);
                b2.Name("exp");
                b2._FreshNames();
                b2.Select_();
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(2);
                b3.Integer(5);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Math#Expression");
                b0.VarName("exp");
                b0.Quantifier("+");
                b0._Variable();
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.VariableRefStep("instance");
                b2.Every_();
                b2.DescendantOrSelfStep();
                b2.And_(2);
                b2.TypeTest("Remainder");
                b2.VariableTest("exp");
                b2._And();
                b2._Every();
                b2._Filter();
                b0.Resolver();
                b2.TemplateNames();
                b2._Select();
                b2._Scope();
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
                b1.Misc_(0);
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
                b2.Scope_();
                b2.FreshNames_(1);
                b2.Name("exp");
                b2._FreshNames();
                b2.Select_();
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(2);
                b3.Integer(5);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Math#Expression");
                b0.VarName("exp");
                b0.Quantifier("+");
                b0._Variable();
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.VariableRefStep("instance");
                b2.Every_();
                b2.Filter_();
                b2.ChildStep();
                b2.KindTest("DATA");
                b2._Filter();
                b2.And_(2);
                b2.TypeTest("Integer");
                b2.VariableTest("exp");
                b2._And();
                b2._Every();
                b2._Filter();
                b0.Resolver();
                b2.TemplateNames();
                b2._Select();
                b2._Scope();
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
                b1.Misc_(1);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(2);
                b2.Integer(5);
                b2.Integer(7);
                b2._Addition();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }
}
