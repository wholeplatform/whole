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
        put("path1", newpath1());
        put("path1a", newpath1a());
        put("path1b", newpath1b());
        put("path1c", newpath1c());
        put("path1d", newpath1d());
        put("path2", newpath2());
        put("path3", newpath3());
        put("path4", newpath4());
        put("path5", newpath5());
        put("path6", newpath6());
        put("path7", newpath7());
        put("path8", newpath8());
        put("pathWithTuple", newpathWithTuple());
        put("testProduct1", newtestProduct1());
        put("testProduct2", newtestProduct2());
        put("testProduct3", newtestProduct3());
        put("testProduct4", newtestProduct4());
        put("findProduction", newfindProduction());
        put("nonTerminalSet", newnonTerminalSet());
        put("findNonTerminalOccurrences", newfindNonTerminalOccurrences());
        put("bindNonTerminalOccurrences", newbindNonTerminalOccurrences());
        put("findAllNonTerminalsUsed", newfindAllNonTerminalsUsed());
        put("recursiveProduction1", newrecursiveProduction1());
        put("recursiveProduction2", newrecursiveProduction2());
        put("recursiveProduction3", newrecursiveProduction3());
        put("recursiveProduction4", newrecursiveProduction4());
        put("recursiveProduction5", newrecursiveProduction5());
        put("recursiveProduction6", newrecursiveProduction6());
        put("unusedProduction", newunusedProduction());
        put("exactlyOneDefUse", newexactlyOneDefUse());
        put("helperResultAs", newhelperResultAs());
    }

    public ITemplateFactory<IEntity> newpath1() {
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

    public ITemplateFactory<IEntity> newpath1a() {
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

    public ITemplateFactory<IEntity> newpath1b() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
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

    public ITemplateFactory<IEntity> newpath1c() {
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

    public ITemplateFactory<IEntity> newpath1d() {
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
                b0.And_(2);
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

    public ITemplateFactory<IEntity> newpath2() {
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
                b0.Or_(2);
                b0.KindTest("SIMPLE");
                b0.KindTest("DATA");
                b0._Or();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newpath3() {
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

    public ITemplateFactory<IEntity> newpath4() {
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

    public ITemplateFactory<IEntity> newpath5() {
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
                b0.And_(2);
                b0.SubtypeTest("Production");
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("rule");
                b0.TypeTest("Choose");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newpath6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.GreaterOrEquals_();
                b0.VariableRefStep("index");
                b0.IntLiteral(2);
                b0._GreaterOrEquals();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newpath7() {
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
                b0.MatchTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.StageUpFragment_();
                org.whole.lang.grammars.builders.IGrammarsBuilder b2 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
                b2.As_();
                b2.NonTerminal("IName");
                b2.Name("tag");
                b2._As();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newpath8() {
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
                b0.MatchTest_();
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
                b0._MatchTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newpathWithTuple() {
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

    public ITemplateFactory<IEntity> newtestProduct1() {
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

    public ITemplateFactory<IEntity> newtestProduct2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(3);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
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

    public ITemplateFactory<IEntity> newtestProduct3() {
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

    public ITemplateFactory<IEntity> newtestProduct4() {
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

    public ITemplateFactory<IEntity> newfindProduction() {
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
                b0.And_(2);
                b0.TypeTest("Production");
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newnonTerminalSet() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.DistinctTest_();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._DistinctTest();
                b0._And();
                b0._Filter();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindNonTerminalOccurrences() {
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

    public ITemplateFactory<IEntity> newbindNonTerminalOccurrences() {
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
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newfindAllNonTerminalsUsed() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(4);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.DistinctTest_();
                b1.Resolver();
                b0._DistinctTest();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newrecursiveProduction1() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.MatchTest_();
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
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("pname");
                b0._And();
                b0._Filter();
                b0._Path();
                b1._StageDownFragment();
                b1.Resolver();
                b2._Production();
                b1._StageUpFragment();
                b0._MatchTest();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newrecursiveProduction2() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.And_(2);
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0.Some_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("pname");
                b0._And();
                b0._Filter();
                b0._Path();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newrecursiveProduction3() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
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
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("pname");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newrecursiveProduction4() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
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
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0.PointwiseEquals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._PointwiseEquals();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newrecursiveProduction5() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.And_(2);
                b0.TypeTest("Production");
                b0.VariableTest("prod");
                b0._And();
                b0.Some_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0.PointwiseEquals_();
                b0.Path_(2);
                b0.VariableRefStep("prod");
                b0.FeatureStep("name");
                b0._Path();
                b0.VariableRefStep("nt");
                b0._PointwiseEquals();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newrecursiveProduction6() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
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
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0.Equals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._Equals();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newunusedProduction() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
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
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0.NotEquals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._NotEquals();
                b0._Every();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newexactlyOneDefUse() {
        return new AbstractTemplateFactory<IEntity>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
                b0.Path_(2);
                b0.FeatureStep("phraseStructure");
                b0.Filter_();
                b0.ChildStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.One_();
                b0.Path_(2);
                b0.FeatureStep("rule");
                b0.CartesianProduct_(2);
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.TypeTest("Production");
                b0.Some_();
                b0.Filter_();
                b0.FeatureStep("name");
                b0.VariableTest("pname");
                b0._Filter();
                org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0.Path_(1);
                b0.Filter_();
                b0.DescendantOrSelfStep();
                b0.And_(2);
                b0.And_(2);
                b0.TypeTest("NonTerminal");
                b0.VariableTest("nt");
                b0._And();
                b0.Some_();
                b0.Filter_();
                b0.ParentStep();
                b0.Not_();
                b0.TypeTest("Production");
                b0._Not();
                b0._Filter();
                b1.Resolver();
                b0._Some();
                b0._And();
                b0._Filter();
                b0._Path();
                b0._CartesianProduct();
                b0._Path();
                b0.Equals_();
                b0.VariableRefStep("pname");
                b0.VariableRefStep("nt");
                b0._Equals();
                b0._One();
                b0._And();
                b0._Filter();
                b0._Path();
            }
        };
    }

    public ITemplateFactory<IEntity> newhelperResultAs() {
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
