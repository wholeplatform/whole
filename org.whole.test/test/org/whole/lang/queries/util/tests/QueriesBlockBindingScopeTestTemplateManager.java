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
        put("fragment9", newFragment9());
        put("fragment", newFragment());
        put("fragment1", newFragment1());
        put("fragment2", newFragment2());
        put("fragment3", newFragment3());
        put("fragment4", newFragment4());
        put("fragment5", newFragment5());
    }

    public ITemplateFactory<IEntity> newFragment9() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
                b0.ModelDeclarations_(2);
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name1");
                b0.Types_(0);
                b0._Types();
                b0.Features_(9);
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("TypeXX2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namex");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("TypeXX2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0.SimpleEntity_();
                b0.EntityModifiers_(0);
                b0._EntityModifiers();
                b0.SimpleName("Name2");
                b0.Types_(0);
                b0._Types();
                b0.Features_(6);
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("namey");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(0);
                b0._FeatureModifiers();
                b0.SimpleName("featureType");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("optional");
                b0._FeatureModifiers();
                b0.SimpleName("Type1");
                b0.SimpleName("name1");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("TypeXX2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0.Feature_();
                b0.FeatureModifiers_(1);
                b0.FeatureModifier("derived");
                b0._FeatureModifiers();
                b0.SimpleName("Type2");
                b0.SimpleName("name2");
                b1.Resolver();
                b0._Feature();
                b0._Features();
                b0._SimpleEntity();
                b0._ModelDeclarations();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment() {
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
                b0.ExpressionTest_();
                b0.BooleanLiteral(true);
                b0._ExpressionTest();
                b0.StringLiteral("");
                b0._If();
                b0._Singleton();
                b0._Addition();
                b0._Block();
                b0._For();
            }
        };
    }

    public ITemplateFactory<IEntity> newFragment1() {
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

    public ITemplateFactory<IEntity> newFragment2() {
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
                b0.ExpressionTest_();
                b0.BooleanLiteral(true);
                b0._ExpressionTest();
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

    public ITemplateFactory<IEntity> newFragment3() {
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

    public ITemplateFactory<IEntity> newFragment4() {
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
                b0.ExpressionTest_();
                b0.BooleanLiteral(true);
                b0._ExpressionTest();
                b2._GuardedAction();
                b2.GuardedAction_();
                b2.Label("Action 2");
                b0.SelfStep();
                b0.ExpressionTest_();
                b0.BooleanLiteral(true);
                b0._ExpressionTest();
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

    public ITemplateFactory<IEntity> newFragment5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.actions.builders.IActionsBuilder b0 = (org.whole.lang.actions.builders.IActionsBuilder) op.wGetBuilder(org.whole.lang.actions.reflect.ActionsLanguageKit.URI);
                b0.GuardedAction_();
                b0.Label("Action 2");
                org.whole.lang.queries.builders.IQueriesBuilder b1 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b1.SelfStep();
                b1.ExpressionTest_();
                b1.BooleanLiteral(true);
                b1._ExpressionTest();
                b0._GuardedAction();
            }
        };
    }
}
