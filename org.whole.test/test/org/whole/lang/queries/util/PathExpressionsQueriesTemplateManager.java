package org.whole.lang.queries.util;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

public class PathExpressionsQueriesTemplateManager extends AbstractTemplateManager {

    private static class SingletonHolder {
        private static final PathExpressionsQueriesTemplateManager instance = new PathExpressionsQueriesTemplateManager();
    }

    public static PathExpressionsQueriesTemplateManager instance() {
        return SingletonHolder.instance;
    }

    private PathExpressionsQueriesTemplateManager() {
        put("path1", newPath1());
        put("path1a", newPath1a());
        put("path1b", newPath1b());
        put("path1c", newPath1c());
        put("path1d", newPath1d());
        put("path2", newPath2());
        put("path3", newPath3());
        put("path4", newPath4());
        put("path5", newPath5());
        put("path6", newPath6());
        put("path7", newPath7());
        put("path8", newPath8());
        put("pathWithTuple", newPathWithTuple());
        put("testProduct1", newTestProduct1());
        put("testProduct2", newTestProduct2());
        put("testProduct3", newTestProduct3());
        put("testProduct4", newTestProduct4());
        put("findProduction", newFindProduction());
        put("nonTerminalSet", newNonTerminalSet());
        put("findNonTerminalOccurrences", newFindNonTerminalOccurrences());
        put("bindNonTerminalOccurrences", newBindNonTerminalOccurrences());
        put("findAllNonTerminalsUsed", newFindAllNonTerminalsUsed());
        put("recursiveProduction1", newRecursiveProduction1());
        put("recursiveProduction2", newRecursiveProduction2());
        put("recursiveProduction3", newRecursiveProduction3());
        put("recursiveProduction4", newRecursiveProduction4());
        put("recursiveProduction5", newRecursiveProduction5());
        put("recursiveProduction6", newRecursiveProduction6());
        put("unusedProduction", newUnusedProduction());
        put("exactlyOneDefUse", newExactlyOneDefUse());
        put("helperResultAs", newHelperResultAs());
    }

    public ITemplateFactory<IEntity> newPath1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(5);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.FeatureStep("name");
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath1a() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(2);
                b0._IndexTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath1b() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.IndexTest_();
                b0.IntLiteral(2);
                b0._IndexTest();
                b0.TypeTest("Production");
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath1c() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.Filter_();
                b0.FollowingSiblingStep();
                b0.IndexTest_();
                b0.IntLiteral(2);
                b0._IndexTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath1d() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.Filter_();
                b0.FollowingSiblingStep();
                b0.And_();
                b0.IndexTest_();
                b0.IntLiteral(2);
                b0._IndexTest();
                b0.TypeTest("Production");
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantStep();
                b0.Or_();
                b0.KindTest("SIMPLE");
                b0.KindTest("DATA");
                b0._Or();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.IndexTest_();
                b0.IntLiteral(0);
                b0._IndexTest();
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantStep();
                b0.Not_();
                b0.KindTest("COMPOSITE");
                b0._Not();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.SubtypeTest("Production");
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantStep();
                b0.SubtypeTest("Production");
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.Sequence_(2);
                b0.FeatureStep("phraseStructure");
                b0.FeatureStep("lexicalStructure");
                b0._Sequence();
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.SubtypeTest("Production");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("rule");
                b0.TypeTest("Choose");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.ExpressionTest_();
                b0.GreaterOrEquals_();
                b0.VariableRefStep("index");
                b0.IntLiteral(2);
                b0._GreaterOrEquals();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath7() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.SubtypeTest("Production");
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantStep();
                b0.ExpressionTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.grammars.builders.IGrammarsBuilder b2 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
                b2.As_();
                b2.NonTerminal("IName");
                b2.Name("tag");
                b2._As();
                b1._StageUpFragment();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPath8() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.SubtypeTest("Production");
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantStep();
                b0.ExpressionTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.grammars.builders.IGrammarsBuilder b2 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
                b2.Production_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Grammars#NonTerminal");
                b1.VarName("name");
                b1.Quantifier("!");
                b1._Variable();
                b2.NonTerminal("STRING");
                b1.Resolver();
                b2._Production();
                b1._StageUpFragment();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newPathWithTuple() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.Filter_();
                b0.StringLiteral("a");
                b0.VariableTest("exp1");
                b0._Filter();
                b0.Tuple_(2);
                b0.VariableRefStep("exp1");
                b0.StringLiteral("b");
                b0._Tuple();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newTestProduct1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.CartesianProduct_(2);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.VariableTest("pp");
                b0._Filter();
                b0._Path();
                b0.Path_(2);
                b0.FeatureStep("lexicalStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.VariableTest("lp");
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
            }
        };
    }

    public ITemplateFactory<IEntity> newTestProduct2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.VariableTest("prod");
                b0._And();
                b0._Filter();
                b0.CartesianProduct_(2);
                b0.FeatureStep("name");
                b0.FeatureStep("rule");
                b0._CartesianProduct();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newTestProduct3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.CartesianProduct_(2);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name1");
                b0._Filter();
                b0._Path();
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name2");
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
            }
        };
    }

    public ITemplateFactory<IEntity> newTestProduct4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.PointwiseProduct_(2);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("name");
                b0._Filter();
                b0._Path();
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0.Filter_();
                b0.FeatureStep("rule");
                b0.VariableTest("rule");
                b0._Filter();
                b0._Path();
                b0._PointwiseProduct();
            }
        };
    }

    public ITemplateFactory<IEntity> newFindProduction() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.Sequence_(2);
                b0.FeatureStep("phraseStructure");
                b0.FeatureStep("lexicalStructure");
                b0._Sequence();
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newNonTerminalSet() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.DistinctTest();
                b0._And();
                b0._Filter();
            }
        };
    }

    public ITemplateFactory<IEntity> newFindNonTerminalOccurrences() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0.Filter_();
                b0.DescendantStep();
                b0.TypeTest("NonTerminal");
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newBindNonTerminalOccurrences() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.TypeTest("Production");
                b0._Filter();
                b0.Filter_();
                b0.DescendantStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newFindAllNonTerminalsUsed() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.DistinctTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newRecursiveProduction1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.ExpressionTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.grammars.builders.IGrammarsBuilder b2 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
                b2.Production_();
                b1.Variable_();
                b1.VarType("http://lang.whole.org/Grammars#NonTerminal");
                b1.VarName("pname");
                b1.Quantifier("!");
                b1._Variable();
                b1.StageDownFragment_();
                b0.Path_(1);
                b0.Filter_();
                b0.DescendantStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("pname");
                b0._And();
                b0._Filter();
                b0._Path();
                b1._StageDownFragment();
                b1.Resolver();
                b2._Production();
                b1._StageUpFragment();
                b0._ExpressionTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newRecursiveProduction2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.And_();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0._ExpressionTest();
                b0.ExpressionTest_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("pname");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._ExpressionTest();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newRecursiveProduction3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.ExpressionTest_();
                b0.CartesianProduct_(2);
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("pname");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newRecursiveProduction4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.Some_();
                b0.CartesianProduct_(2);
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0.ExpressionTest_();
                b0.PointwiseEquals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._PointwiseEquals();
                b0._ExpressionTest();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newRecursiveProduction5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.And_();
                b0.TypeTest("Production");
                b0.VariableTest("prod");
                b0._And();
                b0.Some_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0.ExpressionTest_();
                b0.PointwiseEquals_();
                b0.Path_(2);
                b0.VariableRefStep("prod");
                b0.FeatureStep("name");
                b0._Path();
                b0.VariableRefStep("nt");
                b0._PointwiseEquals();
                b0._ExpressionTest();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newRecursiveProduction6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.Some_();
                b0.CartesianProduct_(2);
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0.ExpressionTest_();
                b0.Equals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._Equals();
                b0._ExpressionTest();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newUnusedProduction() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.Every_();
                b0.CartesianProduct_(2);
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0.Path_(4);
                b0.ParentStep();
                b0.ChildStep();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0.ExpressionTest_();
                b0.NotEquals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._NotEquals();
                b0._ExpressionTest();
                b0._Every();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newExactlyOneDefUse() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.One_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.CartesianProduct_(2);
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.TypeTest("Production");
                b0.ExpressionTest_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0.Path_(1);
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_();
                b0.And_();
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0.ExpressionTest_();
                b0.Filter_();
                b0.ParentStep();
                b0.Not_();
                b0.TypeTest("Production");
                b0._Not();
                b0._Filter();
                b0._ExpressionTest();
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0._Path();
                b0.ExpressionTest_();
                b0.Equals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._Equals();
                b0._ExpressionTest();
                b0._One();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newHelperResultAs() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Filter_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.SameStageFragment_();
                org.whole.lang.java.builders.IJavaBuilder b2 = (org.whole.lang.java.builders.IJavaBuilder) op.wGetBuilder(org.whole.lang.java.reflect.JavaLanguageKit.URI);
                b2.MethodInvocation_();
                b2.SimpleName("org.whole.lang.util.StringUtils");
                b1.Resolver();
                b2.SimpleName("toUpperCap");
                b2.Arguments_(1);
                b2.SimpleName("ftype");
                b2._Arguments();
                b2._MethodInvocation();
                b1._SameStageFragment();
                b0.VariableTest("jtype");
                b0._Filter();
            }
        };
    }
}
