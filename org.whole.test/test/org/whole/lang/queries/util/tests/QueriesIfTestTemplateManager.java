package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesIfTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesIfTestTemplateManager instance = new QueriesIfTestTemplateManager();
    }

    public static QueriesIfTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesIfTestTemplateManager() {
        put("fragment", newfragment());
        put("fragment1", newfragment1());
        put("fragment2", newfragment2());
        put("fragment3", newfragment3());
        put("fragment4", newfragment4());
        put("fragment5", newfragment5());
        put("fragment6", newfragment6());
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.workflows.builders.IWorkflowsBuilder b0 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b0.AssignActivity_();
                b0.Text("assignActivity");
                b0.Assignments_(2);
                b0.Assign_();
                b0.Variable("mathInstance");
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
                b0.Assign_();
                b0.Variable("javaInstance");
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b3 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b3.InterfaceDeclaration_();
                b1.Resolver();
                b3.ExtendedModifiers_(1);
                b3.Modifier("public");
                b3._ExtendedModifiers();
                b3.SimpleName("MyVisitor");
                b1.Resolver();
                b1.Resolver();
                b3.BodyDeclarations_(2);
                b3.MethodDeclaration_();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3.PrimitiveType("byte");
                b3.SimpleName("m1");
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3._MethodDeclaration();
                b3.MethodDeclaration_();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3.PrimitiveType("int");
                b3.SimpleName("m2");
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b3._MethodDeclaration();
                b3._BodyDeclarations();
                b3._InterfaceDeclaration();
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
                b2.Names_(1);
                b2.Name("add3");
                b2._Names();
                b2.Sequence_(2);
                b2.If_();
                b2.Equals_();
                b2.Singleton_();
                b2.Path_(3);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("mathInstance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Filter_();
                b2.ChildStep();
                b2.And_(2);
                b2.IndexTest_();
                b2.IntLiteral(1);
                b2._IndexTest();
                b2.VariableTest("add3");
                b2._And();
                b2._Filter();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(1);
                b2._IndexTest();
                b2._Filter();
                b2._Path();
                b2._Singleton();
                b2.IntLiteral(2);
                b2._Equals();
                b2.VariableRefStep("add3");
                b2._If();
                b2.VariableRefStep("add3");
                b2._Sequence();
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
                b1.Misc_(2);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Addition_(3);
                b2.Integer(1);
                b2.Integer(2);
                b2.Integer(3);
                b2._Addition();
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
                b2.Names_(2);
                b2.Name("visitorName");
                b2.Name("bodyDeclarations");
                b2._Names();
                b2.Path_(2);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("javaInstance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Sequence_(1);
                b2.If_();
                b2.MatchTest_();
                b0.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b4 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b4.InterfaceDeclaration_();
                b0.Resolver();
                b4.ExtendedModifiers_(1);
                b4.Modifier("public");
                b4._ExtendedModifiers();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Java#SimpleName");
                b0.VarName("visitorName");
                b0.Quantifier("!");
                b0._Variable();
                b0.Resolver();
                b0.Resolver();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Java#BodyDeclarations");
                b0.VarName("bodyDeclarations");
                b0.Quantifier("!");
                b0._Variable();
                b4._InterfaceDeclaration();
                b0._StageUpFragment();
                b2._MatchTest();
                b2.Sequence_(2);
                b2.VariableRefStep("visitorName");
                b2.VariableRefStep("bodyDeclarations");
                b2._Sequence();
                b2._If();
                b2._Sequence();
                b2._Path();
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
                b1.Misc_(2);
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.SimpleName("MyVisitor");
                b2.BodyDeclarations_(2);
                b2.MethodDeclaration_();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2.PrimitiveType("byte");
                b2.SimpleName("m1");
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2._MethodDeclaration();
                b2.MethodDeclaration_();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2.PrimitiveType("int");
                b2.SimpleName("m2");
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2._MethodDeclaration();
                b2._BodyDeclarations();
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
                b2.Names_(2);
                b2.Name("visitorName");
                b2.Name("bodyDeclarations");
                b2._Names();
                b2.Path_(2);
                org.whole.lang.workflows.builders.IWorkflowsBuilder b3 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b3.InvokeJavaClassMethod_();
                b3.Text("EntityUtils.clone(instance)");
                b0.Resolver();
                b0.Resolver();
                b3.StringLiteral("org.whole.lang.util.EntityUtils");
                b3.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b3.Expressions_(1);
                b3.Variable("javaInstance");
                b3._Expressions();
                b3._InvokeJavaClassMethod();
                b2.Sequence_(1);
                b2.If_();
                b2.And_(3);
                b2.MatchTest_();
                b0.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b4 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b4.InterfaceDeclaration_();
                b0.Resolver();
                b4.ExtendedModifiers_(1);
                b4.Modifier("public");
                b4._ExtendedModifiers();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Java#SimpleName");
                b0.VarName("visitorName");
                b0.Quantifier("!");
                b0._Variable();
                b0.Resolver();
                b0.Resolver();
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Java#BodyDeclarations");
                b0.VarName("bodyDeclarations");
                b0.Quantifier("!");
                b0._Variable();
                b4._InterfaceDeclaration();
                b0._StageUpFragment();
                b2._MatchTest();
                b3.InvokeJavaInstanceMethod_();
                b3.Text("isVisitorName");
                b0.Resolver();
                b3.Variable("visitorName");
                b0.Resolver();
                b3.StringLiteral("java.lang.String");
                b3.StringLiteral("endsWith(java.lang.String)");
                b3.Expressions_(1);
                b2.StringLiteral("Visitor");
                b3._Expressions();
                b3._InvokeJavaInstanceMethod();
                b2.Every_();
                b2.Path_(2);
                b2.VariableRefStep("bodyDeclarations");
                b2.ChildStep();
                b2._Path();
                b2.TypeTest("http://lang.whole.org/Java#MethodDeclaration");
                b2._Every();
                b2._And();
                b2.Sequence_(3);
                b2.SelfStep();
                b2.VariableRefStep("visitorName");
                b2.VariableRefStep("bodyDeclarations");
                b2._Sequence();
                b2._If();
                b2._Sequence();
                b2._Path();
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
                b1.Misc_(3);
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.InterfaceDeclaration_();
                b0.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b2.SimpleName("MyVisitor");
                b0.Resolver();
                b0.Resolver();
                b2.BodyDeclarations_(2);
                b2.MethodDeclaration_();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2.PrimitiveType("byte");
                b2.SimpleName("m1");
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2._MethodDeclaration();
                b2.MethodDeclaration_();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2.PrimitiveType("int");
                b2.SimpleName("m2");
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2._MethodDeclaration();
                b2._BodyDeclarations();
                b2._InterfaceDeclaration();
                b2.SimpleName("MyVisitor");
                b2.BodyDeclarations_(2);
                b2.MethodDeclaration_();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2.PrimitiveType("byte");
                b2.SimpleName("m1");
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2._MethodDeclaration();
                b2.MethodDeclaration_();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2.PrimitiveType("int");
                b2.SimpleName("m2");
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b0.Resolver();
                b2._MethodDeclaration();
                b2._BodyDeclarations();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }
}
