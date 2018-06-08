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
                b0.FreshNames_(1);
                b0.Name("newEntity");
                b0._FreshNames();
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
                b0.Path_(3);
                b0.VariableRefStep("focusEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0.Clone_();
                b2.Resolver();
                b0._Clone();
                b0._Path();
                b0._PointwiseUpdate();
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.VariableRefStep("focusEntity");
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
                b0.FreshNames_(1);
                b0.Name("newEntity");
                b0._FreshNames();
                b0.Block_(4);
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
                b0.If_();
                b0.Some_();
                b0.Filter_();
                b0.VariableRefStep("newEntity");
                b0.And_(2);
                b0.KindTest("COMPOSITE");
                b0.Not_();
                b0.Some_();
                b0.ChildStep();
                b2.Resolver();
                b0._Some();
                b0._Not();
                b0._And();
                b0._Filter();
                b2.Resolver();
                b0._Some();
                b0.PointwiseInsert_();
                b0.Placement("INTO");
                b0.VariableRefStep("newEntity");
                b2.StageUpFragment_();
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Commons#Any");
                b2.VarName("placeholder");
                b2.Quantifier("!");
                b2._Variable();
                b2._StageUpFragment();
                b0._PointwiseInsert();
                b0._If();
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.VariableRefStep("newEntity");
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
                b0.Path_(3);
                b0.VariableRefStep("focusEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0.Clone_();
                b2.Resolver();
                b0._Clone();
                b0._Path();
                b0._PointwiseUpdate();
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.VariableRefStep("focusEntity");
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
                b0.FreshNames_(1);
                b0.Name("newEntity");
                b0._FreshNames();
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
                b0.Path_(3);
                b0.VariableRefStep("focusEntity");
                b2.Variable_();
                b2.VarType("http://lang.whole.org/Queries#FeatureStep");
                b2.VarName("intoFDUri");
                b2.Quantifier("?");
                b2._Variable();
                b0.Clone_();
                b2.Resolver();
                b0._Clone();
                b0._Path();
                b0._PointwiseUpdate();
                b0.PointwiseUpdate_();
                b0.Path_(2);
                b0.VariableRefStep("focusEntity");
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
