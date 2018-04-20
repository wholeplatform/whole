package org.whole.lang.queries.util.tests;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class QueriesBlockBindingScopeTestTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final QueriesBlockBindingScopeTestTemplateManager instance = new QueriesBlockBindingScopeTestTemplateManager();
    }

    public static QueriesBlockBindingScopeTestTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private QueriesBlockBindingScopeTestTemplateManager() {
        put("fragment", newfragment());
        put("fragment1", newfragment1());
        put("fragment2", newfragment2());
        put("fragment3", newfragment3());
        put("fragment4", newfragment4());
        put("fragment5", newfragment5());
    }

    public ITemplateFactory<IEntity> newfragment() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.For_();
                b0.Path_(2);
                b0.Sequence_(1);
                b0.Do_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("*");
                b2.SimpleName("aa");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("*");
                b2.SimpleName("cc");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0._Do();
                b0._Sequence();
                b0.ChildStep();
                b0._Path();
                b0.Block_(2);
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0.Addition_();
                b0.VariableRefStep("name");
                b0.Singleton_();
                b0.If_();
                b0.BooleanLiteral(true);
                b0.StringLiteral("");
                b0._If();
                b0._Singleton();
                b0._Addition();
                b0._Block();
                b0._For();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.misc.builders.IMiscBuilder b0 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b0.Misc_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.environment.builders.IEnvironmentBuilder b2 = (org.whole.lang.environment.builders.IEnvironmentBuilder) op.wGetBuilder(org.whole.lang.environment.reflect.EnvironmentLanguageKit.URI);
                b2.StringData("aa");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.StringData("cc");
                b1._StageUpFragment();
                b0._Misc();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.For_();
                b0.Path_(2);
                b0.Sequence_(1);
                b0.Do_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.models.builders.IModelsBuilder b2 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b2.Features_(2);
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("*");
                b2.SimpleName("aa");
                b1.Resolver();
                b2._Feature();
                b2.Feature_();
                b2.FeatureModifiers_(0);
                b2._FeatureModifiers();
                b2.SimpleName("*");
                b2.SimpleName("cc");
                b1.Resolver();
                b2._Feature();
                b2._Features();
                b1._StageUpFragment();
                b0._Do();
                b0._Sequence();
                b0.ChildStep();
                b0._Path();
                b0.Block_(3);
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0.If_();
                b0.BooleanLiteral(true);
                b0.Filter_();
                b0.StringLiteral("");
                b0.VariableTest("newType");
                b0._Filter();
                b0._If();
                b0.Addition_();
                b0.VariableRefStep("name");
                b0.VariableRefStep("newType");
                b0._Addition();
                b0._Block();
                b0._For();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.misc.builders.IMiscBuilder b0 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
                b0.Misc_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.environment.builders.IEnvironmentBuilder b2 = (org.whole.lang.environment.builders.IEnvironmentBuilder) op.wGetBuilder(org.whole.lang.environment.reflect.EnvironmentLanguageKit.URI);
                b2.StringData("aa");
                b1._StageUpFragment();
                b1.StageUpFragment_();
                b2.StringData("cc");
                b1._StageUpFragment();
                b0._Misc();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.actions.builders.IActionsBuilder b2 = (org.whole.lang.actions.builders.IActionsBuilder) op.wGetBuilder(org.whole.lang.actions.reflect.ActionsLanguageKit.URI);
                b2.LanguageActionFactory_();
                b2.URI("whole:org.whole.bugfixtest:ActionsScoppia");
                b2.Namespace("org.whole.bugfixtest");
                b2.Name("Test");
                b1.Resolver();
                b1.Resolver();
                b2.ToolbarActions_();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b1.Resolver();
                b2._ToolbarActions();
                b2.ContextMenuActions_();
                b2.MenuActions_(0);
                b2._MenuActions();
                b2.MenuActions_(0);
                b2._MenuActions();
                b2.MenuActions_(0);
                b2._MenuActions();
                b2.MenuActions_(2);
                b2.GuardedAction_();
                b2.Label("Action 1");
                b0.SelfStep();
                b0.BooleanLiteral(true);
                b2._GuardedAction();
                b2.GuardedAction_();
                b2.Label("Action 2");
                b0.SelfStep();
                b0.BooleanLiteral(true);
                b2._GuardedAction();
                b2._MenuActions();
                b2.MenuActions_(0);
                b2._MenuActions();
                b1.Resolver();
                b2._ContextMenuActions();
                b2._LanguageActionFactory();
                b1._StageUpFragment();
                b0.Block_(2);
                b0.Path_(4);
                b0.FeatureStep("http://lang.whole.org/Actions#contextMenuActions");
                b0.FeatureStep("http://lang.whole.org/Actions#analyzeMenuActions");
                b0.Filter_();
                b0.ChildStep();
                b0.VariableTest("pippo");
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Actions#enablerPredicate");
                b0._Path();
                b0.Path_(5);
                b0.FeatureStep("http://lang.whole.org/Actions#contextMenuActions");
                b0.FeatureStep("http://lang.whole.org/Actions#analyzeMenuActions");
                b0.Filter_();
                b0.ChildStep();
                b0.VariableTest("pippo");
                b0._Filter();
                b0.FeatureStep("http://lang.whole.org/Actions#enablerPredicate");
                b0.VariableRefStep("pippo");
                b0._Path();
                b0._Block();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b0.StageUpFragment_();
                org.whole.lang.actions.builders.IActionsBuilder b1 = (org.whole.lang.actions.builders.IActionsBuilder) op.wGetBuilder(org.whole.lang.actions.reflect.ActionsLanguageKit.URI);
                b1.GuardedAction_();
                b1.Label("Action 2");
                org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b2.SelfStep();
                b2.BooleanLiteral(true);
                b1._GuardedAction();
                b0._StageUpFragment();
            }
        };
    }
}
