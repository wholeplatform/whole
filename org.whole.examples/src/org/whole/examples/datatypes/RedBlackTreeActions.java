package org.whole.examples.datatypes;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class RedBlackTreeActions extends AbstractTemplateFactory<org.whole.lang.actions.model.LanguageActionFactory> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.actions.builders.IActionsBuilder b0 = (org.whole.lang.actions.builders.IActionsBuilder) op.wGetBuilder(org.whole.lang.actions.reflect.ActionsLanguageKit.URI);
        b0.LanguageActionFactory_();
        b0.URI("whole:org.whole.examples.datatypes:RedBlackTreeActions");
        b0.Namespace("org.whole.examples.datatypes");
        b0.Name("RedBlackTreeActions");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://datatypes.examples.whole.org/RedBlackTree");
        b0.ToolbarActions_();
        b0.SimpleAction_();
        b0.Label("validator");
        org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b2.Block_(7);
        b2.QueryDeclaration_();
        b2.Name("addError");
        b2.Names_(2);
        b2.Name("message");
        b2.Name("location");
        b2._Names();
        b2.Sequence_(1);
        b1.SameStageFragment_();
        org.whole.lang.java.builders.IJavaBuilder b3 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
        b3.ExpressionStatement_();
        b3.MethodInvocation_();
        b3.SimpleName("decorationManager");
        b3.Types_(0);
        b3._Types();
        b3.SimpleName("addError");
        b3.Arguments_(3);
        b3.SimpleName("self");
        b3.SimpleName("message");
        b3.MethodInvocation_();
        b3.SimpleName("location");
        b3.Types_(0);
        b3._Types();
        b3.SimpleName("toString");
        b3.Arguments_(0);
        b3._Arguments();
        b3._MethodInvocation();
        b3._Arguments();
        b3._MethodInvocation();
        b3._ExpressionStatement();
        b1._SameStageFragment();
        b2._Sequence();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("addWarning");
        b2.Names_(2);
        b2.Name("message");
        b2.Name("location");
        b2._Names();
        b2.Sequence_(1);
        b1.SameStageFragment_();
        b3.ExpressionStatement_();
        b3.MethodInvocation_();
        b3.SimpleName("decorationManager");
        b3.Types_(0);
        b3._Types();
        b3.SimpleName("addWarning");
        b3.Arguments_(3);
        b3.SimpleName("node");
        b3.SimpleName("message");
        b3.MethodInvocation_();
        b3.SimpleName("location");
        b3.Types_(0);
        b3._Types();
        b3.SimpleName("toString");
        b3.Arguments_(0);
        b3._Arguments();
        b3._MethodInvocation();
        b3._Arguments();
        b3._MethodInvocation();
        b3._ExpressionStatement();
        b1._SameStageFragment();
        b2._Sequence();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("validateRootNode");
        b1.Resolver();
        b2.If_();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("color");
        b2.MatchTest_();
        b1.StageUpFragment_();
        org.whole.examples.datatypes.redblacktree.builders.IRedBlackTreeBuilder b4 = (org.whole.examples.datatypes.redblacktree.builders.IRedBlackTreeBuilder) op.wGetBuilder(org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeLanguageKit.URI);
        b4.Color("RED");
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2.Call_();
        b2.Name("addError");
        b2.Expressions_(2);
        b2.StringLiteral("The tree root must be black");
        b2.Singleton_();
        b2.FeatureStep("value");
        b2._Singleton();
        b2._Expressions();
        b2._Call();
        b2._If();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("validateRedNodes");
        b1.Resolver();
        b2.Path_(2);
        b2.Filter_();
        b2.DescendantStep();
        b2.And_(2);
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("color");
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.Color("RED");
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2.Some_();
        b2.Path_(2);
        b2.ParentStep();
        b2.Filter_();
        b2.FeatureStep("color");
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.Color("RED");
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Filter();
        b2._Path();
        b1.Resolver();
        b2._Some();
        b2._And();
        b2._Filter();
        b2.Call_();
        b2.Name("addError");
        b2.Expressions_(2);
        b2.StringLiteral("The parent of a red node must be black");
        b2.Singleton_();
        b2.FeatureStep("value");
        b2._Singleton();
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("validateOrder");
        b2.Names_(1);
        b2.Name("value");
        b2._Names();
        b2.Block_(2);
        b2.QueryDeclaration_();
        b2.Name("checkTreeValues");
        b2.Names_(3);
        b2.Name("minValue");
        b2.Name("maxValue");
        b2.Name("value");
        b2._Names();
        b2.Path_(2);
        b2.Filter_();
        b2.SelfStep();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("value");
        b2.VariableTest("value");
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2._Filter();
        b2.Sequence_(3);
        b2.If_();
        b2.Or_(2);
        b2.ExpressionTest_();
        b2.LessThan_();
        b2.VariableRefStep("value");
        b2.VariableRefStep("minValue");
        b2._LessThan();
        b2._ExpressionTest();
        b2.ExpressionTest_();
        b2.GreaterThan_();
        b2.VariableRefStep("value");
        b2.VariableRefStep("maxValue");
        b2._GreaterThan();
        b2._ExpressionTest();
        b2._Or();
        b2.Call_();
        b2.Name("addError");
        b2.Expressions_(2);
        b2.StringLiteral("The value is not in order");
        b2.VariableRefStep("value");
        b2._Expressions();
        b2._Call();
        b2._If();
        b2.Path_(2);
        b2.FeatureStep("left");
        b2.Call_();
        b2.Name("checkTreeValues");
        b2.Expressions_(2);
        b2.VariableRefStep("minValue");
        b2.VariableRefStep("value");
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2.Path_(2);
        b2.FeatureStep("right");
        b2.Call_();
        b2.Name("checkTreeValues");
        b2.Expressions_(2);
        b2.VariableRefStep("value");
        b2.VariableRefStep("maxValue");
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2._Sequence();
        b2._Path();
        b2._QueryDeclaration();
        b2.Path_(2);
        b2.Filter_();
        b2.SelfStep();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("value");
        b2.VariableTest("value");
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2._Filter();
        b2.Sequence_(2);
        b2.Path_(2);
        b2.FeatureStep("left");
        b2.Call_();
        b2.Name("checkTreeValues");
        b2.Expressions_(2);
        b1.SameStageFragment_();
        b3.FieldAccess_();
        b3.SimpleName("Integer");
        b3.SimpleName("MIN_VALUE");
        b3._FieldAccess();
        b1._SameStageFragment();
        b2.VariableRefStep("value");
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2.Path_(2);
        b2.FeatureStep("right");
        b2.Call_();
        b2.Name("checkTreeValues");
        b2.Expressions_(2);
        b2.VariableRefStep("value");
        b1.SameStageFragment_();
        b3.FieldAccess_();
        b3.SimpleName("Integer");
        b3.SimpleName("MAX_VALUE");
        b3._FieldAccess();
        b1._SameStageFragment();
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2._Sequence();
        b2._Path();
        b2._Block();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("validateBlackPaths");
        b2.Names_(2);
        b2.Name("size1");
        b2.Name("size2");
        b2._Names();
        b2.Block_(4);
        b2.Filter_();
        b2.Choose_(2);
        b2.Path_(2);
        b2.FeatureStep("left");
        b2.Call_();
        b2.Name("validateBlackPaths");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2.IntLiteral(0);
        b2._Choose();
        b2.VariableTest("size1");
        b2._Filter();
        b2.Filter_();
        b2.Choose_(2);
        b2.Path_(2);
        b2.FeatureStep("right");
        b2.Call_();
        b2.Name("validateBlackPaths");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2.IntLiteral(0);
        b2._Choose();
        b2.VariableTest("size2");
        b2._Filter();
        b2.If_();
        b2.ExpressionTest_();
        b2.NotEquals_();
        b2.VariableRefStep("size1");
        b2.VariableRefStep("size2");
        b2._NotEquals();
        b2._ExpressionTest();
        b2.Call_();
        b2.Name("addError");
        b2.Expressions_(2);
        b2.StringLiteral("Every simple path must have the same number of black nodes");
        b2.Singleton_();
        b2.FeatureStep("value");
        b2._Singleton();
        b2._Expressions();
        b2._Call();
        b2._If();
        b2.Choose_(2);
        b2.If_();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("color");
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.Color("BLACK");
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2.Addition_();
        b2.VariableRefStep("size1");
        b2.IntLiteral(1);
        b2._Addition();
        b2._If();
        b2.Do_();
        b2.VariableRefStep("size1");
        b2._Do();
        b2._Choose();
        b2._Block();
        b2._QueryDeclaration();
        b2.Sequence_(4);
        b2.Call_();
        b2.Name("validateRootNode");
        b1.Resolver();
        b2._Call();
        b2.Call_();
        b2.Name("validateRedNodes");
        b1.Resolver();
        b2._Call();
        b2.Call_();
        b2.Name("validateOrder");
        b1.Resolver();
        b2._Call();
        b2.Call_();
        b2.Name("validateBlackPaths");
        b1.Resolver();
        b2._Call();
        b2._Sequence();
        b2._Block();
        b0._SimpleAction();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b0._ToolbarActions();
        b0.ContextMenuActions_();
        b0.MenuActions_(3);
        b0.GuardedAction_();
        b0.Label("insert random value");
        b2.Block_(3);
        b2.QueryDeclaration_();
        b2.Name("insert");
        b2.Names_(2);
        b2.Name("value");
        b2.Name("nodeValue");
        b2._Names();
        b2.Choose_(3);
        b2.If_();
        b2.TypeTest("http://lang.whole.org/Commons#Resolver");
        b2.Path_(2);
        b2.PointwiseUpdate_();
        b2.SelfStep();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("value");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Resolver();
        b1.Resolver();
        b4._RBNode();
        b1._StageUpFragment();
        b2._PointwiseUpdate();
        b2.Call_();
        b2.Name("balance");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2._If();
        b2.If_();
        b2.LessThan_();
        b2.VariableRefStep("value");
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#value");
        b2._LessThan();
        b2.Path_(2);
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#left");
        b2.Call_();
        b2.Name("insert");
        b2.Expressions_(1);
        b2.VariableRefStep("value");
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2._If();
        b2.Do_();
        b2.Path_(2);
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#right");
        b2.Call_();
        b2.Name("insert");
        b2.Expressions_(1);
        b2.VariableRefStep("value");
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2._Do();
        b2._Choose();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("balance");
        b2.Names_(7);
        b2.Name("x");
        b2.Name("y");
        b2.Name("z");
        b2.Name("a");
        b2.Name("b");
        b2.Name("c");
        b2.Name("d");
        b2._Names();
        b2.Choose_(2);
        b2.PointwiseUpdate_();
        b2.Path_(2);
        b2.Filter_();
        b2.SelfStep();
        b2.Some_();
        b2.Filter_();
        b2.ParentStep();
        b2.SubtypeTest("http://lang.whole.org/Commons#Fragment");
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2._Filter();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#color");
        b2._Path();
        b1.StageUpFragment_();
        b4.Color("BLACK");
        b1._StageUpFragment();
        b2._PointwiseUpdate();
        b2.Path_(2);
        b2.ParentStep();
        b2.Choose_(2);
        b2.If_();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#color");
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.Color("BLACK");
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2.SelfStep();
        b2._If();
        b2.Path_(2);
        b2.ParentStep();
        b2.Choose_(2);
        b2.Path_(2);
        b2.CartesianUpdate_();
        b2.Filter_();
        b2.SelfStep();
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("y");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("x");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("a");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("b");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("z");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("c");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("d");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4._RBNode();
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Filter();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("y");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("x");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("a");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("b");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("z");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("c");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("d");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4._RBNode();
        b1._StageUpFragment();
        b2._CartesianUpdate();
        b2.Call_();
        b2.Name("balance");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2.CartesianUpdate_();
        b2.Filter_();
        b2.SelfStep();
        b2.Or_(2);
        b2.Or_(2);
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("z");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("y");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("x");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("a");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("b");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("c");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("d");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b1._StageUpFragment();
        b2._MatchTest();
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("z");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("x");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("a");
        b1.Quantifier("!");
        b1._Variable();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("y");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("b");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("c");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4._RBNode();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("d");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Or();
        b2.Or_(2);
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("x");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("a");
        b1.Quantifier("!");
        b1._Variable();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("z");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("y");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("b");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("c");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("d");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4._RBNode();
        b1._StageUpFragment();
        b2._MatchTest();
        b2.MatchTest_();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("x");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("a");
        b1.Quantifier("!");
        b1._Variable();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("y");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("b");
        b1.Quantifier("!");
        b1._Variable();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("z");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("c");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("d");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4._RBNode();
        b4._RBNode();
        b1._StageUpFragment();
        b2._MatchTest();
        b2._Or();
        b2._Or();
        b2._Filter();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("y");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("BLACK");
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("x");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("a");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("b");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("z");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("c");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b1.VarName("d");
        b1.Quantifier("!");
        b1._Variable();
        b4._RBNode();
        b4._RBNode();
        b1._StageUpFragment();
        b2._CartesianUpdate();
        b2._Choose();
        b2._Path();
        b2._Choose();
        b2._Path();
        b2._Choose();
        b2._QueryDeclaration();
        b2.Call_();
        b2.Name("insert");
        b2.Expressions_(1);
        b1.SameStageFragment_();
        b3.MethodInvocation_();
        b3.ClassInstanceCreation_();
        b1.Resolver();
        b1.Resolver();
        b3.SimpleType("Random");
        b1.Resolver();
        b1.Resolver();
        b3._ClassInstanceCreation();
        b3.Types_(0);
        b3._Types();
        b3.SimpleName("nextInt");
        b3.Arguments_(1);
        b3.ShortLiteral((short) 99);
        b3._Arguments();
        b3._MethodInvocation();
        b1._SameStageFragment();
        b2._Expressions();
        b2._Call();
        b2._Block();
        b2.TypeTest("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b0._GuardedAction();
        b0.GuardedAction_();
        b0.Label("insert random value (unbalanced)");
        b2.Block_(2);
        b2.QueryDeclaration_();
        b2.Name("insert");
        b2.Names_(2);
        b2.Name("value");
        b2.Name("nodeValue");
        b2._Names();
        b2.Choose_(3);
        b2.If_();
        b2.TypeTest("http://lang.whole.org/Commons#Resolver");
        b2.Path_(2);
        b2.PointwiseUpdate_();
        b2.SelfStep();
        b1.StageUpFragment_();
        b4.RBNode_();
        b1.Variable_();
        b1.VarType("http://datatypes.examples.whole.org/RedBlackTree#Value");
        b1.VarName("value");
        b1.Quantifier("!");
        b1._Variable();
        b4.Color("RED");
        b1.Resolver();
        b1.Resolver();
        b4._RBNode();
        b1._StageUpFragment();
        b2._PointwiseUpdate();
        b2.Call_();
        b2.Name("balance");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2._If();
        b2.If_();
        b2.LessThan_();
        b2.VariableRefStep("value");
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#value");
        b2._LessThan();
        b2.Path_(2);
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#left");
        b2.Call_();
        b2.Name("insert");
        b2.Expressions_(1);
        b2.VariableRefStep("value");
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2._If();
        b2.Do_();
        b2.Path_(2);
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#right");
        b2.Call_();
        b2.Name("insert");
        b2.Expressions_(1);
        b2.VariableRefStep("value");
        b2._Expressions();
        b2._Call();
        b2._Path();
        b2._Do();
        b2._Choose();
        b2._QueryDeclaration();
        b2.Call_();
        b2.Name("insert");
        b2.Expressions_(1);
        b1.SameStageFragment_();
        b3.MethodInvocation_();
        b3.ClassInstanceCreation_();
        b1.Resolver();
        b1.Resolver();
        b3.SimpleType("Random");
        b1.Resolver();
        b1.Resolver();
        b3._ClassInstanceCreation();
        b3.Types_(0);
        b3._Types();
        b3.SimpleName("nextInt");
        b3.Arguments_(1);
        b3.ShortLiteral((short) 99);
        b3._Arguments();
        b3._MethodInvocation();
        b1._SameStageFragment();
        b2._Expressions();
        b2._Call();
        b2._Block();
        b2.TypeTest("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b0._GuardedAction();
        b0.GuardedAction_();
        b0.Label("delete root value (unbalanced)");
        b2.Block_(3);
        b2.QueryDeclaration_();
        b2.Name("deleteRBNode");
        b2.Names_(1);
        b2.Name("succValue");
        b2._Names();
        b2.Choose_(3);
        b2.PointwiseUpdate_();
        b2.Filter_();
        b2.SelfStep();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#left");
        b2.TypeTest("http://lang.whole.org/Commons#Resolver");
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2._Filter();
        b2.Delete_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#right");
        b2._Delete();
        b2._PointwiseUpdate();
        b2.PointwiseUpdate_();
        b2.Filter_();
        b2.SelfStep();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#right");
        b2.TypeTest("http://lang.whole.org/Commons#Resolver");
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2._Filter();
        b2.Delete_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#left");
        b2._Delete();
        b2._PointwiseUpdate();
        b2.Block_(2);
        b2.Path_(3);
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#right");
        b2.Filter_();
        b2.Call_();
        b2.Name("leftmostRBNode");
        b1.Resolver();
        b2._Call();
        b2.Some_();
        b2.Filter_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#value");
        b2.VariableTest("succValue");
        b2._Filter();
        b1.Resolver();
        b2._Some();
        b2._Filter();
        b2.Call_();
        b2.Name("deleteRBNode");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2.PointwiseUpdate_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#value");
        b2.VariableRefStep("succValue");
        b2._PointwiseUpdate();
        b2._Block();
        b2._Choose();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("leftmostRBNode");
        b1.Resolver();
        b2.Choose_(2);
        b2.Path_(2);
        b2.Filter_();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#left");
        b2.KindTest("IMPL");
        b2._Filter();
        b2.Call_();
        b2.Name("leftmostRBNode");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2.SelfStep();
        b2._Choose();
        b2._QueryDeclaration();
        b2.Call_();
        b2.Name("deleteRBNode");
        b1.Resolver();
        b2._Call();
        b2._Block();
        b2.TypeTest("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b0._GuardedAction();
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b0.MenuActions_(1);
        b0.GuardedAction_();
        b0.Label("print values in order");
        b2.Block_(2);
        b2.QueryDeclaration_();
        b2.Name("printRBNode");
        b1.Resolver();
        b2.Sequence_(3);
        b2.Path_(2);
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#left");
        b2.Call_();
        b2.Name("printRBNode");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#value");
        b2.Path_(2);
        b2.FeatureStep("http://datatypes.examples.whole.org/RedBlackTree#right");
        b2.Call_();
        b2.Name("printRBNode");
        b1.Resolver();
        b2._Call();
        b2._Path();
        b2._Sequence();
        b2._QueryDeclaration();
        b2.Call_();
        b2.Name("printRBNode");
        b1.Resolver();
        b2._Call();
        b2._Block();
        b2.TypeTest("http://datatypes.examples.whole.org/RedBlackTree#RBNode");
        b0._GuardedAction();
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b1.Resolver();
        b0._ContextMenuActions();
        b0._LanguageActionFactory();
    }
}
