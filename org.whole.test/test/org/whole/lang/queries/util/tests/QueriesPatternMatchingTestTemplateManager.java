package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesPatternMatchingTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesPatternMatchingTestTemplateManager instance = new QueriesPatternMatchingTestTemplateManager();
    }

    public static QueriesPatternMatchingTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesPatternMatchingTestTemplateManager() {
        put("fragment", newfragment());
        put("fragment1", newfragment1());
        put("fragment2", newfragment2());
        put("fragment3", newfragment3());
        put("fragment4", newfragment4());
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
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.OrdinaryCompilationUnit_();
                b2.PackageDeclaration_();
                b1.Resolver();
                b1.Resolver();
                b2.QualifiedName("org.whole.examples.javabeans.example");
                b2._PackageDeclaration();
                b2.ImportDeclarations_(0);
                b2._ImportDeclarations();
                b2.TypeDeclarations_(1);
                b2.ClassDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b2.SimpleName("Addition");
                b1.Resolver();
                b1.Resolver();
                b2.Types_(1);
                b2.SimpleType("Expression");
                b2._Types();
                b2.BodyDeclarations_(6);
                b2.FieldDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("private");
                b2._ExtendedModifiers();
                b2.SimpleType("Expression");
                b2.VariableDeclarationFragments_(1);
                b2.VariableDeclarationFragment_();
                b2.SimpleName("exp1");
                b2.ExtraDimensions(0);
                b1.Resolver();
                b2._VariableDeclarationFragment();
                b2._VariableDeclarationFragments();
                b2._FieldDeclaration();
                b2.MethodDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Resolver();
                b2.SimpleType("Expression");
                b2.SimpleName("getExp1");
                b2.Parameters_(0);
                b2._Parameters();
                b2.ExtraDimensions(0);
                b1.Resolver();
                b2.Block_(1);
                b2.ReturnStatement_();
                b2.SimpleName("exp1");
                b2._ReturnStatement();
                b2._Block();
                b2._MethodDeclaration();
                b2.MethodDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Resolver();
                b2.PrimitiveType("void");
                b2.SimpleName("setExp1");
                b2.Parameters_(1);
                b2.SingleVariableDeclaration_();
                b1.Resolver();
                b2.SimpleType("Expression");
                b2.Varargs(false);
                b2.SimpleName("exp1");
                b2.ExtraDimensions(0);
                b1.Resolver();
                b1.Resolver();
                b2._SingleVariableDeclaration();
                b2._Parameters();
                b2.ExtraDimensions(0);
                b1.Resolver();
                b2.Block_(1);
                b2.ExpressionStatement_();
                b2.Assignment_();
                b2.FieldAccess_();
                b2.ThisExpression_();
                b1.Resolver();
                b2._ThisExpression();
                b2.SimpleName("exp1");
                b2._FieldAccess();
                b2.AssignmentOperator("=");
                b2.SimpleName("exp1");
                b2._Assignment();
                b2._ExpressionStatement();
                b2._Block();
                b2._MethodDeclaration();
                b2.FieldDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("private");
                b2._ExtendedModifiers();
                b2.SimpleType("Expression");
                b2.VariableDeclarationFragments_(1);
                b2.VariableDeclarationFragment_();
                b2.SimpleName("exp2");
                b2.ExtraDimensions(0);
                b1.Resolver();
                b2._VariableDeclarationFragment();
                b2._VariableDeclarationFragments();
                b2._FieldDeclaration();
                b2.MethodDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Resolver();
                b2.SimpleType("Expression");
                b2.SimpleName("getExp2");
                b2.Parameters_(0);
                b2._Parameters();
                b2.ExtraDimensions(0);
                b1.Resolver();
                b2.Block_(1);
                b2.ReturnStatement_();
                b2.SimpleName("exp2");
                b2._ReturnStatement();
                b2._Block();
                b2._MethodDeclaration();
                b2.MethodDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Resolver();
                b2.PrimitiveType("void");
                b2.SimpleName("setExp2");
                b2.Parameters_(1);
                b2.SingleVariableDeclaration_();
                b1.Resolver();
                b2.SimpleType("Expression");
                b2.Varargs(false);
                b2.SimpleName("exp2");
                b2.ExtraDimensions(0);
                b1.Resolver();
                b1.Resolver();
                b2._SingleVariableDeclaration();
                b2._Parameters();
                b2.ExtraDimensions(0);
                b1.Resolver();
                b2.Block_(1);
                b2.ExpressionStatement_();
                b2.Assignment_();
                b2.FieldAccess_();
                b2.ThisExpression_();
                b1.Resolver();
                b2._ThisExpression();
                b2.SimpleName("exp2");
                b2._FieldAccess();
                b2.AssignmentOperator("=");
                b2.SimpleName("exp2");
                b2._Assignment();
                b2._ExpressionStatement();
                b2._Block();
                b2._MethodDeclaration();
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b2._TypeDeclarations();
                b2._OrdinaryCompilationUnit();
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
                b2.Path_(3);
                b0.StageUpFragment_();
                org.whole.lang.math.builders.IMathBuilder b3 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b3.Addition_(5);
                b3.Integer(0);
                b3.Integer(1);
                b3.Integer(2);
                b3.Integer(3);
                b3.Integer(4);
                b3._Addition();
                b0._StageUpFragment();
                b2.Filter_();
                b2.ChildStep();
                b2.IndexTest_();
                b2.IntLiteral(2);
                b2._IndexTest();
                b2._Filter();
                b2.Filter_();
                b2.SelfStep();
                b2.MatchTest_();
                b0.StageUpFragment_();
                b3.Integer(2);
                b0._StageUpFragment();
                b2._MatchTest();
                b2._Filter();
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
                b1.Misc_(1);
                org.whole.lang.math.builders.IMathBuilder b2 = (org.whole.lang.math.builders.IMathBuilder) op.wGetBuilder(org.whole.lang.math.reflect.MathLanguageKit.URI);
                b2.Integer(2);
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
                b2.Name("name");
                b2._FreshNames();
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
                b2.Filter_();
                b2.DescendantOrSelfStep();
                b2.MatchTest_();
                b0.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b4 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b4.SingleVariableDeclaration_();
                b0.Resolver();
                b4.SimpleType("Expression");
                b4.Varargs(false);
                b0.Variable_();
                b0.VarType("http://lang.whole.org/Java#SimpleName");
                b0.VarName("name");
                b0.Quantifier("!");
                b0._Variable();
                b4.ExtraDimensions(0);
                b0.Resolver();
                b0.Resolver();
                b4._SingleVariableDeclaration();
                b0._StageUpFragment();
                b2._MatchTest();
                b2._Filter();
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
                b2.SingleVariableDeclaration_();
                b0.Resolver();
                b2.SimpleType("Expression");
                b2.Varargs(false);
                b2.SimpleName("exp1");
                b2.ExtraDimensions(0);
                b0.Resolver();
                b0.Resolver();
                b2._SingleVariableDeclaration();
                b2.SingleVariableDeclaration_();
                b0.Resolver();
                b2.SimpleType("Expression");
                b2.Varargs(false);
                b2.SimpleName("exp2");
                b2.ExtraDimensions(0);
                b0.Resolver();
                b0.Resolver();
                b2._SingleVariableDeclaration();
                b1._Misc();
                b0._StageUpFragment();
            }
        };
    }
}
