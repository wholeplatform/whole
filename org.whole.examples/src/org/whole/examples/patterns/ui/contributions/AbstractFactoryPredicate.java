package org.whole.examples.patterns.ui.contributions;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class AbstractFactoryPredicate extends AbstractTemplateFactory<org.whole.lang.queries.model.ExpressionTest> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b0.ExpressionTest_();
        b0.Path_(3);
        b0.Filter_();
        b0.SelfStep();
        b0.TypeTest("CompilationUnit");
        b0._Filter();
        b0.FeatureStep("types");
        b0.Filter_();
        b0.ChildStep();
        b0.And_();
        b0.TypeTest("InterfaceDeclaration");
        b0.And_();
        b0.ExpressionTest_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.SameStageFragment_();
        org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
        b2.MethodInvocation_();
        b2.SimpleName("org.whole.examples.helpers.Helpers");
        b1.Resolver();
        b2.SimpleName("isAbstractFactory");
        b2.Arguments_(1);
        b2.SimpleName("self");
        b2._Arguments();
        b2._MethodInvocation();
        b1._SameStageFragment();
        b0._ExpressionTest();
        b0.Some_();
        b0.Path_(2);
        b0.FeatureStep("bodyDeclarations");
        b0.Filter_();
        b0.ChildStep();
        b0.TypeTest("MethodDeclaration");
        b0._Filter();
        b0._Path();
        b0.ExpressionTest_();
        b1.SameStageFragment_();
        b2.MethodInvocation_();
        b2.SimpleName("org.whole.examples.helpers.Helpers");
        b1.Resolver();
        b2.SimpleName("isFactoryMethod");
        b2.Arguments_(1);
        b2.SimpleName("self");
        b2._Arguments();
        b2._MethodInvocation();
        b1._SameStageFragment();
        b0._ExpressionTest();
        b0._Some();
        b0._And();
        b0._And();
        b0._Filter();
        b0._Path();
        b0._ExpressionTest();
    }
}
