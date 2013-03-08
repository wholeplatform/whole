package org.whole.lang.e4.ui.util;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class WrapActionsTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final WrapActionsTemplateManager instance = new WrapActionsTemplateManager();
    }

    public static WrapActionsTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private WrapActionsTemplateManager() {
        put("WrapIn", newWrapIn());
        put("WrapInIndex", newWrapInIndex());
        put("WrapWithin", newWrapWithin());
    }

    public ITemplateFactory<IEntity> newWrapIn() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Scope_();
                b0.Names_(1);
                b0.Name("newEntity");
                b0._Names();
                b0.Block_(2);
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.Filter_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b1 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b1.CreateEntity_();
                b1.Text("create replacement entity");
                org.whole.lang.commons.builders.ICommonsBuilder b2 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b2.Resolver();
                b1.Registry("DEFAULT");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Workflows#StringLiteral");
                b2.VarName("edUri");
                b2.Quantifier("!");
                b2._Variable();
                b2.Resolver();
                b1._CreateEntity();
                b0.VariableTest("newEntity");
                b0._Filter();
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("fdUri");
                b2.Quantifier("!");
                b2._Variable();
                b0._Path();
                b1.InvokeJavaClassMethod_();
                b1.Text("clone entity");
                b2.Resolver();
                b2.Resolver();
                b1.StringLiteral("org.whole.lang.util.EntityUtils");
                b1.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b1.Expressions_(1);
                b0.Path_(2);
                b0.VariableRefStep("primarySelectedEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0._Path();
                b1._Expressions();
                b1._InvokeJavaClassMethod();
                b0._PointwiseUpdate();
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.VariableRefStep("primarySelectedEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0._Path();
                b0.VariableRefStep("newEntity");
                b0._PointwiseUpdate();
                b0._Block();
                b0._Scope();
            }
        };
    }

    public ITemplateFactory<IEntity> newWrapInIndex() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Scope_();
                b0.Names_(1);
                b0.Name("newEntity");
                b0._Names();
                b0.Block_(2);
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.Filter_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b1 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b1.CreateEntity_();
                b1.Text("create replacement entity");
                org.whole.lang.commons.builders.ICommonsBuilder b2 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b2.Resolver();
                b1.Registry("DEFAULT");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Workflows#StringLiteral");
                b2.VarName("edUri");
                b2.Quantifier("!");
                b2._Variable();
                b2.Resolver();
                b1._CreateEntity();
                b0.VariableTest("newEntity");
                b0._Filter();
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#IntLiteral");
                b2.VarName("fdIndex");
                b2.Quantifier("!");
                b2._Variable();
                b0._IndexTest();
                b0._Filter();
                b0._Path();
                b1.InvokeJavaClassMethod_();
                b1.Text("clone entity");
                b2.Resolver();
                b2.Resolver();
                b1.StringLiteral("org.whole.lang.util.EntityUtils");
                b1.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b1.Expressions_(1);
                b0.Path_(2);
                b0.VariableRefStep("primarySelectedEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0._Path();
                b1._Expressions();
                b1._InvokeJavaClassMethod();
                b0._PointwiseUpdate();
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.VariableRefStep("primarySelectedEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0._Path();
                b0.VariableRefStep("newEntity");
                b0._PointwiseUpdate();
                b0._Block();
                b0._Scope();
            }
        };
    }

    public ITemplateFactory<IEntity> newWrapWithin() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Scope_();
                b0.Names_(1);
                b0.Name("newEntity");
                b0._Names();
                b0.Block_(2);
                b0.PointwiseUpdate_();
                b0.Path_(3);
                b0.Filter_();
                org.whole.lang.workflows.builders.IWorkflowsBuilder b1 = (org.whole.lang.workflows.builders.IWorkflowsBuilder) op.wGetBuilder(org.whole.lang.workflows.reflect.WorkflowsLanguageKit.URI);
                b1.CreateEntity_();
                b1.Text("create replacement entity");
                org.whole.lang.commons.builders.ICommonsBuilder b2 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b2.Resolver();
                b1.Registry("DEFAULT");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Workflows#StringLiteral");
                b2.VarName("edUri");
                b2.Quantifier("!");
                b2._Variable();
                b2.Resolver();
                b1._CreateEntity();
                b0.VariableTest("newEntity");
                b0._Filter();
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("fdUri");
                b2.Quantifier("!");
                b2._Variable();
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0._Path();
                b1.InvokeJavaClassMethod_();
                b1.Text("clone entity");
                b2.Resolver();
                b2.Resolver();
                b1.StringLiteral("org.whole.lang.util.EntityUtils");
                b1.StringLiteral("clone(org.whole.lang.model.IEntity)");
                b1.Expressions_(1);
                b0.Path_(2);
                b0.VariableRefStep("primarySelectedEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0._Path();
                b1._Expressions();
                b1._InvokeJavaClassMethod();
                b0._PointwiseUpdate();
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.VariableRefStep("primarySelectedEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0._Path();
                b0.VariableRefStep("newEntity");
                b0._PointwiseUpdate();
                b0._Block();
                b0._Scope();
            }
        };
    }
}
