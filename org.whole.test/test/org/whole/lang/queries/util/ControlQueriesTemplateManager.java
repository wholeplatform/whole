package org.whole.lang.queries.util;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class ControlQueriesTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final ControlQueriesTemplateManager instance = new ControlQueriesTemplateManager();
    }

    public static ControlQueriesTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private ControlQueriesTemplateManager() {
        put("if1", newIf1());
        put("if2", newIf2());
        put("if3", newIf3());
        put("if4", newIf4());
        put("if5", newIf5());
        put("do1", newDo1());
        put("for1", newFor1());
        put("choose1", newChoose1());
        put("choose2", newChoose2());
        put("choose3", newChoose3());
        put("choose4", newChoose4());
        put("choose5", newChoose5());
        put("call1", newCall1());
        put("call2", newCall2());
        put("call3", newCall3());
        put("call4", newCall4());
        put("call5", newCall5());
        put("call6", newCall6());
        put("call7", newCall7());
        put("queryDecl1", newQueryDecl1());
        put("queryDecl2", newQueryDecl2());
        put("queryDecl3", newQueryDecl3());
        put("queryDecl4", newQueryDecl4());
        put("queryDecl5", newQueryDecl5());
        put("queryDecl6", newQueryDecl6());
        put("queryDecl7", newQueryDecl7());
        put("queryDecl8", newQueryDecl8());
        put("queryDecl9", newQueryDecl9());
        put("queryDecl10", newQueryDecl10());
    }

    public ITemplateFactory<IEntity> newIf1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.If_();
                b0.TypeTest("Model");
                b0.FeatureStep("name");
                b0._If();
            }
        };
    }

    public ITemplateFactory<IEntity> newIf2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.If_();
                b0.And_(2);
                b0.TypeTest("Model");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("n");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.ClassDeclaration_();
                b1.Resolver();
                b1.Resolver();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#SimpleName");
                b1.VarName("n");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2.BodyDeclarations_(0);
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b1._StageUpFragment();
                b0._If();
            }
        };
    }

    public ITemplateFactory<IEntity> newIf3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.If_();
                b0.TypeTest("Model");
                b0.Select_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.ClassDeclaration_();
                b1.Resolver();
                b1.Resolver();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#SimpleName");
                b1.VarName("cname");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2.BodyDeclarations_(0);
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b1._StageUpFragment();
                b0.Filter_();
                b0.SelfStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("ename");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0.Filter_();
                b1.SameStageFragment_();
                b2.MethodInvocation_();
                b2.SimpleName("org.whole.lang.util.StringUtils");
                b1.Resolver();
                b2.SimpleName("toUpperCap");
                b2.Arguments_(1);
                b2.SimpleName("ename");
                b2._Arguments();
                b2._MethodInvocation();
                b1._SameStageFragment();
                b0.VariableTest("cname");
                b0._Filter();
                b0._Select();
                b0._If();
            }
        };
    }

    public ITemplateFactory<IEntity> newIf4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.If_();
                b0.And_(2);
                b0.TypeTest("Division");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("exp1");
                b0.VariableTest("exp1");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("exp2");
                b0.VariableTest("exp2");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b0.Sequence_(2);
                b0.Filter_();
                b0.VariableRefStep("exp1");
                b0.VariableTest("a");
                b0._Filter();
                b0.Filter_();
                b0.VariableRefStep("exp2");
                b0.VariableTest("b");
                b0._Filter();
                b0._Sequence();
                b0._If();
            }
        };
    }

    public ITemplateFactory<IEntity> newIf5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.If_();
                b0.And_(2);
                b0.TypeTest("Division");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("exp1");
                b0.VariableTest("exp1");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("exp2");
                b0.VariableTest("exp2");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Division_();
                b1.StageDownFragment_();
                b0.Filter_();
                b0.VariableRefStep("exp1");
                b0.VariableTest("a");
                b0._Filter();
                b1._StageDownFragment();
                b1.StageDownFragment_();
                b0.Filter_();
                b0.VariableRefStep("exp2");
                b0.VariableTest("b");
                b0._Filter();
                b1._StageDownFragment();
                b0._Division();
                b1._StageUpFragment();
                b0._If();
            }
        };
    }

    public ITemplateFactory<IEntity> newDo1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Do_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.ClassDeclaration_();
                b2.Javadoc_();
                b2.Tags_(1);
                b2.TagElement_();
                b2.TagName("author");
                b2.DocElements_(1);
                b2.TextElement(" Riccardo");
                b2._DocElements();
                b2._TagElement();
                b2._Tags();
                b2._Javadoc();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b2.SimpleName("HelloWorld");
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2.BodyDeclarations_(1);
                b2.MethodDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(2);
                b2.Modifier("public");
                b2.Modifier("static");
                b2._ExtendedModifiers();
                b1.Resolver();
                b2.PrimitiveType("void");
                b2.SimpleName("main");
                b2.Parameters_(1);
                b2.SingleVariableDeclaration_();
                b1.Resolver();
                b2.ArrayType_();
                b2.SimpleType("String");
                b2._ArrayType();
                b2.Varargs(false);
                b2.SimpleName("args");
                b2.ExtraDimensions(0);
                b1.Resolver();
                b2._SingleVariableDeclaration();
                b2._Parameters();
                b1.Resolver();
                b1.Resolver();
                b2.Block_(1);
                b2.ExpressionStatement_();
                b2.MethodInvocation_();
                b2.QualifiedName("System.out");
                b2.Types_(0);
                b2._Types();
                b2.SimpleName("println");
                b2.Arguments_(1);
                b2.StringLiteral("hello world");
                b2._Arguments();
                b2._MethodInvocation();
                b2._ExpressionStatement();
                b2._Block();
                b2._MethodDeclaration();
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b1._StageUpFragment();
                b0._Do();
            }
        };
    }

    public ITemplateFactory<IEntity> newFor1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.For_();
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0._Path();
                b0.FeatureStep("name");
                b0._For();
            }
        };
    }

    public ITemplateFactory<IEntity> newChoose1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Choose_(3);
                b0.If_();
                b0.TypeTest("EnumEntity");
                b0.FeatureStep("values");
                b0._If();
                b0.For_();
                b0.Path_(3);
                b0.Filter_();
                b0.SelfStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0.FeatureStep("features");
                b0.ChildStep();
                b0._Path();
                b0.FeatureStep("name");
                b0._For();
                b0.If_();
                b0.TypeTest("CompositeEntity");
                b0.FeatureStep("componentType");
                b0._If();
                b0._Choose();
            }
        };
    }

    public ITemplateFactory<IEntity> newChoose2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Select_();
                b0.SelfStep();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.ChildStep();
                b0.Choose_(4);
                b0.If_();
                b0.TypeTest("EnumEntity");
                b0.Path_(2);
                b0.FeatureStep("values");
                b0.ChildStep();
                b0._Path();
                b0._If();
                b0.For_();
                b0.Path_(3);
                b0.Filter_();
                b0.SelfStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0.FeatureStep("features");
                b0.ChildStep();
                b0._Path();
                b0.FeatureStep("name");
                b0._For();
                b0.If_();
                b0.TypeTest("CompositeEntity");
                b0.FeatureStep("componentType");
                b0._If();
                b0.If_();
                b0.TypeTest("DataEntity");
                b0.FeatureStep("dataType");
                b0._If();
                b0._Choose();
                b0._Path();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Select();
            }
        };
    }

    public ITemplateFactory<IEntity> newChoose3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Select_();
                b0.Choose_(5);
                b0.If_();
                b0.TypeTest("EnumEntity");
                b0.Path_(2);
                b0.FeatureStep("values");
                b0.ChildStep();
                b0._Path();
                b0._If();
                b0.For_();
                b0.Path_(3);
                b0.Filter_();
                b0.SelfStep();
                b0.TypeTest("SimpleEntity");
                b0._Filter();
                b0.FeatureStep("features");
                b0.ChildStep();
                b0._Path();
                b0.FeatureStep("name");
                b0._For();
                b0.If_();
                b0.TypeTest("CompositeEntity");
                b0.FeatureStep("componentType");
                b0._If();
                b0.If_();
                b0.TypeTest("DataEntity");
                b0.FeatureStep("dataType");
                b0._If();
                b0.Do_();
                b0.StringLiteral("OTHERWISE");
                b0._Do();
                b0._Choose();
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.ChildStep();
                b0._Path();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Select();
            }
        };
    }

    public ITemplateFactory<IEntity> newChoose4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Select_();
                b0.Filter_();
                b0.Choose_(4);
                b0.If_();
                b0.TypeTest("SimpleEntity");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.ClassDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2.SimpleType("AbstractSimpleEntity");
                b2.Types_(0);
                b2._Types();
                b2.BodyDeclarations_(0);
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b1._StageUpFragment();
                b0._If();
                b0.If_();
                b0.TypeTest("CompositeEntity");
                b1.StageUpFragment_();
                b2.ClassDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2.SimpleType("AbstractCompositeEntity");
                b2.Types_(0);
                b2._Types();
                b2.BodyDeclarations_(0);
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b1._StageUpFragment();
                b0._If();
                b0.If_();
                b0.TypeTest("DataEntity");
                b1.StageUpFragment_();
                b2.ClassDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2.SimpleType("AbstractDataEntity");
                b2.Types_(0);
                b2._Types();
                b2.BodyDeclarations_(0);
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b1._StageUpFragment();
                b0._If();
                b0.If_();
                b0.TypeTest("EnumEntity");
                b1.StageUpFragment_();
                b2.ClassDeclaration_();
                b1.Resolver();
                b2.ExtendedModifiers_(1);
                b2.Modifier("public");
                b2._ExtendedModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2.SimpleType("AbstractEnumEntity");
                b2.Types_(0);
                b2._Types();
                b2.BodyDeclarations_(0);
                b2._BodyDeclarations();
                b2._ClassDeclaration();
                b1._StageUpFragment();
                b0._If();
                b0._Choose();
                b0.VariableTest("type");
                b0._Filter();
                b0.Path_(2);
                b0.FeatureStep("declarations");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b1.Resolver();
                b0._Select();
            }
        };
    }

    public ITemplateFactory<IEntity> newChoose5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.Filter_();
                b0.SelfStep();
                b0.TypeTest("CompilationUnit");
                b0._Filter();
                b0.FeatureStep("types");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._Filter();
                b0.Choose_(3);
                b0.If_();
                b0.TypeTest("EnumDeclaration");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.EnumEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b2.Types_(0);
                b2._Types();
                b2.EnumValues_(0);
                b2._EnumValues();
                b2._EnumEntity();
                b1._StageUpFragment();
                b0._If();
                b0.Path_(2);
                b0.Filter_();
                b0.SelfStep();
                b0.TypeTest("ClassDeclaration");
                b0._Filter();
                b0.Choose_(2);
                b0.If_();
                b0.ExpressionTest_();
                b0.Path_(2);
                b0.FeatureStep("superInterfaceTypes");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b3 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b3.SimpleType("List");
                b1._StageUpFragment();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
                b0._ExpressionTest();
                b1.StageUpFragment_();
                b2.CompositeEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b2.Types_(0);
                b2._Types();
                b2.ComponentModifiers_(1);
                b2.ComponentModifier("ordered");
                b2._ComponentModifiers();
                b1.Resolver();
                b2._CompositeEntity();
                b1._StageUpFragment();
                b0._If();
                b0.Do_();
                b1.StageUpFragment_();
                b2.SimpleEntity_();
                b2.EntityModifiers_(0);
                b2._EntityModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b2.Types_(0);
                b2._Types();
                b2.Features_(0);
                b2._Features();
                b2._SimpleEntity();
                b1._StageUpFragment();
                b0._Do();
                b0._Choose();
                b0._Path();
                b0.If_();
                b0.TypeTest("InterfaceDeclaration");
                b1.StageUpFragment_();
                b2.SimpleEntity_();
                b2.EntityModifiers_(1);
                b2.EntityModifier("abstract");
                b2._EntityModifiers();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Models#SimpleName");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b2.Types_(0);
                b2._Types();
                b2.Features_(0);
                b2._Features();
                b2._SimpleEntity();
                b1._StageUpFragment();
                b0._If();
                b0._Choose();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newCall1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("nestedProductions");
                b0._Filter();
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0.Call_();
                b0.Name("nestedProductions");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newCall2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("productions");
                b0._Filter();
                b0.Filter_();
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("nestedProductions");
                b0._Filter();
                b0.Path_(3);
                b0.Call_();
                b0.Name("productions");
                b1.Resolver();
                b0._Call();
                b0.Call_();
                b0.Name("nestedProductions");
                b1.Resolver();
                b0._Call();
                b0.FeatureStep("name");
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newCall3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.TypeTest("NonTerminal");
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("nonTerminalsInRule");
                b0._Filter();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.Call_();
                b0.Name("nonTerminalsInRule");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newCall4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("name");
                b0._And();
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("nonTerminalsInRuleWithName");
                b0._Filter();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Call_();
                b0.Name("nonTerminalsInRuleWithName");
                b1.Resolver();
                b0._Call();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newCall5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("productionsWithName");
                b0._Filter();
                b0.Filter_();
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("name");
                b0._And();
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("nonTerminalsInRuleWithName");
                b0._Filter();
                b0.Filter_();
                b0.Call_();
                b0.Name("productionsWithName");
                b1.Resolver();
                b0._Call();
                b0.ExpressionTest_();
                b0.Call_();
                b0.Name("nonTerminalsInRuleWithName");
                b1.Resolver();
                b0._Call();
                b0._ExpressionTest();
                b0._Filter();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newCall6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("productions");
                b0._Filter();
                b0.Filter_();
                b1.StageUpFragment_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("name");
                b0._And();
                b0._Filter();
                b0._Path();
                b1._StageUpFragment();
                b0.VariableTest("nonTerminalsInRuleWithName");
                b0._Filter();
                b0.Filter_();
                b0.Call_();
                b0.Name("productions");
                b1.Resolver();
                b0._Call();
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Call_();
                b0.Name("nonTerminalsInRuleWithName");
                b1.Resolver();
                b0._Call();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newCall7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(4);
                b0.Filter_();
                b0.Addition_();
                b0.StringLiteral("my");
                b0.StringLiteral("Name");
                b0._Addition();
                b0.VariableTest("calculateName");
                b0._Filter();
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.ConditionalExpression_();
                b2.MethodInvocation_();
                b2.SimpleName("name");
                b2.Types_(0);
                b2._Types();
                b2.SimpleName("startsWith");
                b2.Arguments_(1);
                b2.StringLiteral("my");
                b2._Arguments();
                b2._MethodInvocation();
                b2.InfixExpression_();
                b2.SimpleName("name");
                b2.InfixOperator("+");
                b2.StringLiteral("Impl");
                b2.Expressions_(0);
                b2._Expressions();
                b2._InfixExpression();
                b2.SimpleName("name");
                b2._ConditionalExpression();
                b1._StageUpFragment();
                b0.VariableTest("appendImplSuffix");
                b0._Filter();
                b0.Filter_();
                b0.Call_();
                b0.Name("calculateName");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("name");
                b0._Filter();
                b0.Call_();
                b0.Name("appendImplSuffix");
                b1.Resolver();
                b0._Call();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("nonTerminalsInRule");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.TypeTest("NonTerminal");
                b0._Filter();
                b0._Path();
                b0._QueryDeclaration();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.Call_();
                b0.Name("nonTerminalsInRule");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("nonTerminalsInRuleWithName");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("name");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._QueryDeclaration();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Call_();
                b0.Name("nonTerminalsInRuleWithName");
                b1.Resolver();
                b0._Call();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(3);
                b0.QueryDeclaration_();
                b0.Name("productions");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0._Path();
                b0._QueryDeclaration();
                b0.QueryDeclaration_();
                b0.Name("nonTerminalsInRuleWithName");
                b1.Resolver();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("name");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._QueryDeclaration();
                b0.Filter_();
                b0.Call_();
                b0.Name("productions");
                b1.Resolver();
                b0._Call();
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Call_();
                b0.Name("nonTerminalsInRuleWithName");
                b1.Resolver();
                b0._Call();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("recursiveProductions");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("nonTerminalsInRule");
                b1.Resolver();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.TypeTest("NonTerminal");
                b0._Filter();
                b0._Path();
                b0._QueryDeclaration();
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.Call_();
                b0.Name("nonTerminalsInRule");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("pname");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
                b0._Block();
                b0._QueryDeclaration();
                b0.Call_();
                b0.Name("recursiveProductions");
                b1.Resolver();
                b0._Call();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(4);
                b0.QueryDeclaration_();
                b0.Name("firstChildName");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Path_(2);
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
                b0._QueryDeclaration();
                b0.QueryDeclaration_();
                b0.Name("componentType");
                b1.Resolver();
                b0.FeatureStep("componentType");
                b0._QueryDeclaration();
                b0.QueryDeclaration_();
                b0.Name("entityInfo");
                b1.Resolver();
                b0.Choose_(4);
                b0.If_();
                b0.TypeTest("SimpleEntity");
                b0.Path_(2);
                b0.FeatureStep("features");
                b0.Call_();
                b0.Name("firstChildName");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._If();
                b0.If_();
                b0.TypeTest("CompositeEntity");
                b0.Call_();
                b0.Name("componentType");
                b1.Resolver();
                b0._Call();
                b0._If();
                b0.If_();
                b0.TypeTest("EnumEntity");
                b0.SelfStep();
                b0._If();
                b0.If_();
                b0.TypeTest("DataEntity");
                b0.FeatureStep("name");
                b0._If();
                b0._Choose();
                b0._QueryDeclaration();
                b0.Path_(3);
                b0.FeatureStep("declarations");
                b0.ChildStep();
                b0.Call_();
                b0.Name("entityInfo");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("leftmostChild");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0.Choose_(2);
                b0.Path_(2);
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.Call_();
                b0.Name("leftmostChild");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0.SelfStep();
                b0._Choose();
                b0._QueryDeclaration();
                b0.Sequence_(3);
                b0.Path_(2);
                b0.IntLiteral(5);
                b0.Call_();
                b0.Name("leftmostChild");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0.Path_(2);
                b1.StageUpFragment_();
                b0.Division_();
                b0.Addition_();
                b0.Subtraction_();
                b0.IntLiteral(10);
                b0.IntLiteral(8);
                b0._Subtraction();
                b0.IntLiteral(3);
                b0._Addition();
                b0.Addition_();
                b0.IntLiteral(5);
                b0.IntLiteral(3);
                b0._Addition();
                b0._Division();
                b1._StageUpFragment();
                b0.Call_();
                b0.Name("leftmostChild");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0.Path_(2);
                b1.StageUpFragment_();
                b0.Division_();
                b0.Addition_();
                b0.IntLiteral(8);
                b0.IntLiteral(3);
                b0._Addition();
                b0.IntLiteral(5);
                b0._Division();
                b1._StageUpFragment();
                b0.Call_();
                b0.Name("leftmostChild");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Sequence();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("Queries2JavaTranslator");
                b0.Names_(5);
                b0.Name("exp1");
                b0.Name("exp2");
                b0.Name("jexp");
                b0.Name("jexp1");
                b0.Name("jexp2");
                b0._Names();
                b0.Block_(3);
                b0.Path_(2);
                b0.FeatureStep("exp1");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Call();
                b0.VariableTest("jexp1");
                b0._Filter();
                b0._Path();
                b0.Path_(2);
                b0.FeatureStep("exp2");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("jexp2");
                b0._Filter();
                b0._Path();
                b0.Choose_(6);
                b0.If_();
                b0.TypeTest("http://lang.whole.org/Queries#Multiplication");
                b0.Select_();
                b1.StageUpFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.InfixExpression_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp1");
                b1.Quantifier("!");
                b1._Variable();
                b2.InfixOperator("*");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2._InfixExpression();
                b1._StageUpFragment();
                b0.Filter_();
                b0.SelfStep();
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Queries#exp1");
                b0.VariableTest("exp1");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("http://lang.whole.org/Queries#exp2");
                b0.VariableTest("exp2");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0.Sequence_(2);
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("jexp1");
                b0._Filter();
                b0._Path();
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("jexp2");
                b0._Filter();
                b0._Path();
                b0._Sequence();
                b0._Select();
                b0._If();
                b0.If_();
                b0.And_(2);
                b0.TypeTest("http://lang.whole.org/Queries#Division");
                b0.And_(2);
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("exp1");
                b0.VariableTest("exp1");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("exp2");
                b0.VariableTest("exp2");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b1.StageUpFragment_();
                b2.InfixExpression_();
                b1.StageDownFragment_();
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b1._StageDownFragment();
                b2.InfixOperator("/");
                b1.StageDownFragment_();
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b1._StageDownFragment();
                b1.Resolver();
                b2._InfixExpression();
                b1._StageUpFragment();
                b0._If();
                b0.If_();
                b0.ExpressionTest_();
                b1.StageUpFragment_();
                b0.Remainder_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp1");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp2");
                b1.Quantifier("!");
                b1._Variable();
                b0._Remainder();
                b1._StageUpFragment();
                b0._ExpressionTest();
                b1.StageUpFragment_();
                b2.InfixExpression_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp1");
                b1.Quantifier("!");
                b1._Variable();
                b2.InfixOperator("%");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2._InfixExpression();
                b1._StageUpFragment();
                b0._If();
                b0.If_();
                b0.ExpressionTest_();
                b1.StageUpFragment_();
                b0.Addition_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp1");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp2");
                b1.Quantifier("!");
                b1._Variable();
                b0._Addition();
                b1._StageUpFragment();
                b0._ExpressionTest();
                b1.StageUpFragment_();
                b2.InfixExpression_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp1");
                b1.Quantifier("!");
                b1._Variable();
                b2.InfixOperator("+");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2._InfixExpression();
                b1._StageUpFragment();
                b0._If();
                b0.If_();
                b0.ExpressionTest_();
                b1.StageUpFragment_();
                b0.Subtraction_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp1");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp2");
                b1.Quantifier("!");
                b1._Variable();
                b0._Subtraction();
                b1._StageUpFragment();
                b0._ExpressionTest();
                b1.StageUpFragment_();
                b2.InfixExpression_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp1");
                b1.Quantifier("!");
                b1._Variable();
                b2.InfixOperator("-");
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp2");
                b1.Quantifier("!");
                b1._Variable();
                b1.Resolver();
                b2._InfixExpression();
                b1._StageUpFragment();
                b0._If();
                b0.If_();
                b0.SubtypeTest("http://lang.whole.org/Queries#Literal");
                b0.Select_();
                b1.StageUpFragment_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Java#Expression");
                b1.VarName("jexp");
                b1.Quantifier("!");
                b1._Variable();
                b1._StageUpFragment();
                b0.Filter_();
                b0.SelfStep();
                b0.VariableTest("jexp");
                b0._Filter();
                b1.Resolver();
                b0._Select();
                b0._If();
                b0._Choose();
                b0._Block();
                b0._QueryDeclaration();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("qd");
                b0.Names_(1);
                b0.Name("value");
                b0._Names();
                b0.VariableRefStep("value");
                b0._QueryDeclaration();
                b0.Path_(2);
                b0.Filter_();
                b0.ChildStep();
                b0.VariableTest("modifier");
                b0._Filter();
                b0.Call_();
                b0.Name("qd");
                b0.Expressions_(1);
                b0.VariableRefStep("modifier");
                b0._Expressions();
                b0._Call();
                b0._Path();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("Queries2JavaTranslator");
                b0.Names_(2);
                b0.Name("exp1");
                b0.Name("exp2");
                b0._Names();
                b0.Choose_(2);
                b0.If_();
                b0.ExpressionTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                b0.Addition_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp1");
                b1.Quantifier("!");
                b1._Variable();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Queries#Expression");
                b1.VarName("exp2");
                b1.Quantifier("!");
                b1._Variable();
                b0._Addition();
                b1._StageUpFragment();
                b0._ExpressionTest();
                b1.StageUpFragment_();
                b0.Addition_();
                b1.StageDownFragment_();
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b1._StageDownFragment();
                b1.StageDownFragment_();
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b1._StageDownFragment();
                b0._Addition();
                b1._StageUpFragment();
                b0._If();
                b0.SelfStep();
                b0._Choose();
                b0._QueryDeclaration();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Block();
            }
        };
    }

    public ITemplateFactory<IEntity> newQueryDecl10() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Block_(2);
                b0.QueryDeclaration_();
                b0.Name("Queries2JavaTranslator");
                b0.Names_(2);
                b0.Name("exp1");
                b0.Name("exp2");
                b0._Names();
                b0.Choose_(7);
                b0.Select_();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixExpression");
                b0.Bindings_(3);
                b0.Bind_();
                b0.Name("leftOperand");
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Bind();
                b0.Bind_();
                b0.Name("operator");
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixOperator");
                b0.Expressions_(1);
                b0.CharLiteral('*');
                b0._Expressions();
                b0._EntityTemplate();
                b0._Bind();
                b0.Bind_();
                b0.Name("rightOperand");
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Queries#Multiplication");
                b0.Bindings_(2);
                b0.Bind_();
                b0.Name("exp1");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("exp2");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b1.Resolver();
                b0._Select();
                b0.If_();
                b0.ExpressionTest_();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Queries#Addition");
                b0.Bindings_(2);
                b0.Bind_();
                b0.Name("exp1");
                b0.Filter_();
                b1.Resolver();
                b0.VariableTest("exp0");
                b0._Filter();
                b0._Bind();
                b0.Bind_();
                b0.Name("exp2");
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Queries#Addition");
                b0.Bindings_(2);
                b0.Bind_();
                b0.Name("exp1");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("exp2");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._ExpressionTest();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixExpression");
                b0.Bindings_(4);
                b0.Bind_();
                b0.Name("leftOperand");
                b0.Path_(2);
                b0.VariableRefStep("exp0");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Bind();
                b0.Bind_();
                b0.Name("operator");
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixOperator");
                b0.Expressions_(1);
                b0.CharLiteral('+');
                b0._Expressions();
                b0._EntityTemplate();
                b0._Bind();
                b0.Bind_();
                b0.Name("rightOperand");
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Bind();
                b0.Bind_();
                b0.Name("extendedOperands");
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._If();
                b0.If_();
                b0.ExpressionTest_();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Queries#Addition");
                b0.Bindings_(2);
                b0.Bind_();
                b0.Name("exp1");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("exp2");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._ExpressionTest();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixExpression");
                b0.Bindings_(3);
                b0.Bind_();
                b0.Name("leftOperand");
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Bind();
                b0.Bind_();
                b0.Name("operator");
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixOperator");
                b0.Expressions_(1);
                b0.CharLiteral('+');
                b0._Expressions();
                b0._EntityTemplate();
                b0._Bind();
                b0.Bind_();
                b0.Name("rightOperand");
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Path();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._If();
                b0.If_();
                b0.ExpressionTest_();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Queries#Subtraction");
                b0.Bindings_(2);
                b0.Bind_();
                b0.Name("exp1");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("exp2");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._ExpressionTest();
                b0.Block_(3);
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("leftOperand");
                b0._Filter();
                b0._Path();
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("rightOperand");
                b0._Filter();
                b0._Path();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixExpression");
                b0.Bindings_(3);
                b0.Bind_();
                b0.Name("leftOperand");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("operator");
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixOperator");
                b0.Expressions_(1);
                b0.CharLiteral('-');
                b0._Expressions();
                b0._EntityTemplate();
                b0._Bind();
                b0.Bind_();
                b0.Name("rightOperand");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._Block();
                b0._If();
                b0.For_();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Queries#Subtraction");
                b0.Bindings_(2);
                b0.Bind_();
                b0.Name("exp1");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("exp2");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0.Block_(3);
                b0.Path_(2);
                b0.VariableRefStep("exp1");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("leftOperand");
                b0._Filter();
                b0._Path();
                b0.Path_(2);
                b0.VariableRefStep("exp2");
                b0.Filter_();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0.VariableTest("rightOperand");
                b0._Filter();
                b0._Path();
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixExpression");
                b0.Bindings_(3);
                b0.Bind_();
                b0.Name("leftOperand");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("operator");
                b0.EntityTemplate_();
                b0.EntityType("http://lang.whole.org/Java#InfixOperator");
                b0.Expressions_(1);
                b0.CharLiteral('-');
                b0._Expressions();
                b0._EntityTemplate();
                b0._Bind();
                b0.Bind_();
                b0.Name("rightOperand");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityTemplate();
                b0._Block();
                b0._For();
                b0.EntityCall_();
                b0.EntityType("fun");
                b0.Bindings_(2);
                b0.Bind_();
                b0.Name("a1");
                b1.Resolver();
                b0._Bind();
                b0.Bind_();
                b0.Name("a2");
                b1.Resolver();
                b0._Bind();
                b0._Bindings();
                b0._EntityCall();
                b0.SelfStep();
                b0._Choose();
                b0._QueryDeclaration();
                b0.Call_();
                b0.Name("Queries2JavaTranslator");
                b1.Resolver();
                b0._Call();
                b0._Block();
            }
        };
    }
}
