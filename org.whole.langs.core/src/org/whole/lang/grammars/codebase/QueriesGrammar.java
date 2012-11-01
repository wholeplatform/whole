package org.whole.lang.grammars.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class QueriesGrammar extends AbstractTemplateFactory<org.whole.lang.grammars.model.Grammar> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.grammars.builders.IGrammarsBuilder b0 = (org.whole.lang.grammars.builders.IGrammarsBuilder) op.wGetBuilder(org.whole.lang.grammars.reflect.GrammarsLanguageKit.URI);
        b0.Grammar_();
        b0.Name("QueriesGrammar");
        b0.URI("http://lang.whole.org/Queries");
        b0.NonTerminal("PathExpression");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.Productions_(2);
        b0.Production_();
        b0.NonTerminal("STRING");
        b0.DataTerminal_();
        b0.RegExp("(?s).*");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b0.DataType("STRING");
        b0._Production();
        b0.Production_();
        b0.NonTerminal("INT");
        b0.DataTerminal_();
        b0.RegExp("[0..9]+");
        b0.Category("LITERAL");
        b0.Format("%s");
        b0._DataTerminal();
        b0.DataType("INT");
        b0._Production();
        b0._Productions();
        b0.Productions_(8);
        b0.Production_();
        b0.NonTerminal("Expression");
        b0.Choose_(2);
        b0.NonTerminal("PathExpression");
        b0.Production_();
        b0.NonTerminal("Tuple");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.Repeat_();
        b0.Size(0);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp(",");
        b0.Category("DELIMITER");
        b0.Literal(", ");
        b0._LiteralTerminal();
        b0.NonTerminal("Expression");
        b0._Repeat();
        b0.LiteralTerminal_();
        b0.RegExp(")");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Statement");
        b0.Choose_(4);
        b0.Production_();
        b0.NonTerminal("SelectInto");
        b0.Concatenate_(7);
        b0.LiteralTerminal_();
        b0.RegExp("SELECT");
        b0.Category("DELIMITER");
        b0.Literal("SELECT");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("Expression");
        b0.Name("selectClause");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("INTO");
        b0.Category("DELIMITER");
        b0.Literal("INTO");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("intoClause");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("FROM");
        b0.Category("DELIMITER");
        b0.Literal("FROM");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("fromClause");
        b0._As();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("WHERE");
        b0.Category("DELIMITER");
        b0.Literal("WHERE");
        b0._LiteralTerminal();
        b0.NonTerminal("PathExpression");
        b0._Concatenate();
        b0._Optional();
        b0.Name("whereClause");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Insert");
        b0.Concatenate_(5);
        b0.LiteralTerminal_();
        b0.RegExp("INSERT");
        b0.Category("DELIMITER");
        b0.Literal("INSERT");
        b0._LiteralTerminal();
        b0.As_();
        b0.Choose_(3);
        b0.LiteralTerminal_();
        b0.RegExp("INTO");
        b0.Category("DELIMITER");
        b0.Literal("INTO");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("BEFORE");
        b0.Category("DELIMITER");
        b0.Literal("BEFORE");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("AFTER");
        b0.Category("DELIMITER");
        b0.Literal("AFTER");
        b0._LiteralTerminal();
        b0._Choose();
        b0.Name("position");
        b0._As();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("intoClause");
        b0._As();
        b0.As_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("VALUES");
        b0.Category("DELIMITER");
        b0.Literal("VALUES");
        b0._LiteralTerminal();
        b0.NonTerminal("Expression");
        b0._Concatenate();
        b0.Name("valuesClause");
        b0._As();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("WHERE");
        b0.Category("DELIMITER");
        b0.Literal("WHERE");
        b0._LiteralTerminal();
        b0.NonTerminal("PathExpression");
        b0._Concatenate();
        b0._Optional();
        b0.Name("whereClause");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Update");
        b0.Concatenate_(5);
        b0.LiteralTerminal_();
        b0.RegExp("UPDATE");
        b0.Category("DELIMITER");
        b0.Literal("UPDATE");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("updateClause");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("SET");
        b0.Category("DELIMITER");
        b0.Literal("SET");
        b0._LiteralTerminal();
        b0.As_();
        b0.Repeat_();
        b0.Size(1);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp(";");
        b0.Category("DELIMITER");
        b0.Literal(";");
        b0._LiteralTerminal();
        b0.Production_();
        b0.NonTerminal("Assignment");
        b0.Concatenate_(3);
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("lvalue");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("=");
        b0.Category("DELIMITER");
        b0.Literal("=");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("Expression");
        b0.Name("rvalue");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Repeat();
        b0.Name("setClause");
        b0._As();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("WHERE");
        b0.Category("DELIMITER");
        b0.Literal("WHERE");
        b0._LiteralTerminal();
        b0.NonTerminal("PathExpression");
        b0._Concatenate();
        b0._Optional();
        b0.Name("whereClause");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Delete");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("DELETE");
        b0.Category("DELIMITER");
        b0.Literal("DELETE");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("FROM");
        b0.Category("DELIMITER");
        b0.Literal("FROM");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("fromClause");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Declaration");
        b0.Production_();
        b0.NonTerminal("Relation");
        b0.Concatenate_(7);
        b0.LiteralTerminal_();
        b0.RegExp("RELATION");
        b0.Category("DELIMITER");
        b0.Literal("RELATION");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("SimpleName");
        b0.Name("name");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("domainClause");
        b0._As();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("WHEN");
        b0.Category("DELIMITER");
        b0.Literal("WHEN");
        b0._LiteralTerminal();
        b0.NonTerminal("Predicate");
        b0._Concatenate();
        b0._Optional();
        b0.Name("whenClause");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp(")");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("WHERE");
        b0.Category("DELIMITER");
        b0.Literal("WHERE");
        b0._LiteralTerminal();
        b0.NonTerminal("Predicate");
        b0._Concatenate();
        b0._Optional();
        b0.Name("whereClause");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("PathExpression");
        b0.Choose_(3);
        b0.NonTerminal("StepExpression");
        b0.Production_();
        b0.NonTerminal("Path");
        b0.Repeat_();
        b0.Size(0);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp("/");
        b0.Category("DELIMITER");
        b0.Literal("/");
        b0._LiteralTerminal();
        b0.NonTerminal("StepExpression");
        b0._Repeat();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Select");
        b0.Concatenate_(7);
        b0.LiteralTerminal_();
        b0.RegExp("SELECT");
        b0.Category("DELIMITER");
        b0.Literal("SELECT");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("Expression");
        b0.Name("selectClause");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("FROM");
        b0.Category("DELIMITER");
        b0.Literal("FROM");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("fromClause");
        b0._As();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("WHERE");
        b0.Category("DELIMITER");
        b0.Literal("WHERE");
        b0._LiteralTerminal();
        b0.NonTerminal("PathExpression");
        b0._Concatenate();
        b0._Optional();
        b0.Name("whereClause");
        b0._As();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.As_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("GROUP BY");
        b0.Category("DELIMITER");
        b0.Literal("GROUP BY");
        b0._LiteralTerminal();
        b0.NonTerminal("Expression");
        b0._Concatenate();
        b0.Name("groupByClause");
        b0._As();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("HAVING");
        b0.Category("DELIMITER");
        b0.Literal("HAVING");
        b0._LiteralTerminal();
        b0.NonTerminal("Predicate");
        b0._Concatenate();
        b0._Optional();
        b0.Name("havingClause");
        b0._As();
        b0._Concatenate();
        b0._Optional();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("ORDER BY");
        b0.Category("DELIMITER");
        b0.Literal("ORDER BY");
        b0._LiteralTerminal();
        b0.NonTerminal("Expression");
        b0._Concatenate();
        b0._Optional();
        b0.Name("orderByClause");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("StepExpression");
        b0.Choose_(10);
        b0.Production_();
        b0.NonTerminal("Sequence");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.Repeat_();
        b0.Size(1);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp(",");
        b0.Category("DELIMITER");
        b0.Literal(",");
        b0._LiteralTerminal();
        b0.NonTerminal("PathExpression");
        b0._Repeat();
        b0.LiteralTerminal_();
        b0.RegExp(")");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Product");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.Repeat_();
        b0.Size(1);
        b0.Unbounded();
        b0.LiteralTerminal_();
        b0.RegExp(";");
        b0.Category("DELIMITER");
        b0.Literal(";");
        b0._LiteralTerminal();
        b0.NonTerminal("PathExpression");
        b0._Repeat();
        b0.LiteralTerminal_();
        b0.RegExp(")");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Filter");
        b0.Concatenate_(2);
        b0.As_();
        b0.NonTerminal("StepExpression");
        b0.Name("expression");
        b0._As();
        b0.As_();
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q[\\E");
        b0.Category("DELIMITER");
        b0.Literal("[");
        b0._LiteralTerminal();
        b0.NonTerminal("Predicate");
        b0.LiteralTerminal_();
        b0.RegExp("]");
        b0.Category("DELIMITER");
        b0.Literal("]");
        b0._LiteralTerminal();
        b0._Concatenate();
        b0.Name("predicate");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("VariableRefStep");
        b0.NonTerminal("STRING");
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("RootStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qroot()\\E");
        b0.Category("DELIMITER");
        b0.Literal("root()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("FragmentRootStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qfragment-root()\\E");
        b0.Category("DELIMITER");
        b0.Literal("fragment-root()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("SelfStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qself()\\E");
        b0.Category("DELIMITER");
        b0.Literal("self()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("TypeStep");
        b0.NonTerminal("STRING");
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("ForwardStep");
        b0.Choose_(6);
        b0.Production_();
        b0.NonTerminal("FeatureStep");
        b0.NonTerminal("STRING");
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("ChildStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qchild()\\E");
        b0.Category("DELIMITER");
        b0.Literal("child()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("DescendantStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qdescendant()\\E");
        b0.Category("DELIMITER");
        b0.Literal("descendant()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("DescendantOrSelfStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qdescendant-or-self()\\E");
        b0.Category("DELIMITER");
        b0.Literal("descendant-or-self()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("FollowingSiblingStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qfollowing-sibling()\\E");
        b0.Category("DELIMITER");
        b0.Literal("following-sibling()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("FollowingStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qfollowing()\\E");
        b0.Category("DELIMITER");
        b0.Literal("following()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("ReverseStep");
        b0.Choose_(5);
        b0.Production_();
        b0.NonTerminal("ParentStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qparent()\\E");
        b0.Category("DELIMITER");
        b0.Literal("parent()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("AncestorStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qancestor()\\E");
        b0.Category("DELIMITER");
        b0.Literal("ancestor()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("AncestorOrSelfStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qancestor-or-self()\\E");
        b0.Category("DELIMITER");
        b0.Literal("ancestor-or-self()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("PrecedingSiblingStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qpreceding-sibling()\\E");
        b0.Category("DELIMITER");
        b0.Literal("preceding-sibling()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("PrecedingStep");
        b0.LiteralTerminal_();
        b0.RegExp("\\Qpreceding()\\E");
        b0.Category("DELIMITER");
        b0.Literal("preceding()");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Predicate");
        b0.Choose_(12);
        b0.Production_();
        b0.NonTerminal("KindTest");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Qkind()\\E");
        b0.Category("DELIMITER");
        b0.Literal("kind()");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("=");
        b0.Category("DELIMITER");
        b0.Literal("=");
        b0._LiteralTerminal();
        b0.Choose_(12);
        b0.LiteralTerminal_();
        b0.RegExp("SIMPLE");
        b0.Category("DELIMITER");
        b0.Literal("SIMPLE");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("COMPOSITE");
        b0.Category("DELIMITER");
        b0.Literal("COMPOSITE");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("DATA");
        b0.Category("DELIMITER");
        b0.Literal("DATA");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("RESOLVER");
        b0.Category("DELIMITER");
        b0.Literal("RESOLVER");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("PROXY");
        b0.Category("DELIMITER");
        b0.Literal("PROXY");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("ADAPTER");
        b0.Category("DELIMITER");
        b0.Literal("ADAPTER");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("IMPL");
        b0.Category("DELIMITER");
        b0.Literal("IMPL");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("VARIABLE");
        b0.Category("DELIMITER");
        b0.Literal("VARIABLE");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("FRAGMENT");
        b0.Category("DELIMITER");
        b0.Literal("FRAGMENT");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("SAME_STAGE_FRAGMENT");
        b0.Category("DELIMITER");
        b0.Literal("SAME_STAGE_FRAGMENT");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("STAGE_UP_FRAGMENT");
        b0.Category("DELIMITER");
        b0.Literal("STAGE_UP_FRAGMENT");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("STAGE_DOWN_FRAGMENT");
        b0.Category("DELIMITER");
        b0.Literal("STAGE_DOWN_FRAGMENT");
        b0._LiteralTerminal();
        b0._Choose();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("LanguageTest");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Qlanguage()\\E");
        b0.Category("DELIMITER");
        b0.Literal("language()");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("=");
        b0.Category("DELIMITER");
        b0.Literal("=");
        b0._LiteralTerminal();
        b0.NonTerminal("STRING");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("TypeTest");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Qtype()\\E");
        b0.Category("DELIMITER");
        b0.Literal("type()");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("=");
        b0.Category("DELIMITER");
        b0.Literal("=");
        b0._LiteralTerminal();
        b0.NonTerminal("STRING");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("SubtypeTest");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Qtype()\\E");
        b0.Category("DELIMITER");
        b0.Literal("type()");
        b0._LiteralTerminal();
        b0.LiteralTerminal_();
        b0.RegExp("<:");
        b0.Category("DELIMITER");
        b0.Literal("<:");
        b0._LiteralTerminal();
        b0.NonTerminal("STRING");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("VariableTest");
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("AS");
        b0.Category("DELIMITER");
        b0.Literal("AS");
        b0._LiteralTerminal();
        b0.NonTerminal("STRING");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("ExpressionTest");
        b0.As_();
        b0.NonTerminal("Expression");
        b0.Name("expression");
        b0._As();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("DistinctTest");
        b0.LiteralTerminal_();
        b0.RegExp("DISTINCT");
        b0.Category("DELIMITER");
        b0.Literal("DISTINCT");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("And");
        b0.Concatenate_(3);
        b0.As_();
        b0.NonTerminal("Predicate");
        b0.Name("predicate1");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("&");
        b0.Category("DELIMITER");
        b0.Literal("&");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("Predicate");
        b0.Name("predicate2");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Or");
        b0.Concatenate_(3);
        b0.As_();
        b0.NonTerminal("Predicate");
        b0.Name("predicate1");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp("\\Q|\\E");
        b0.Category("DELIMITER");
        b0.Literal("|");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("Predicate");
        b0.Name("predicate2");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Not");
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("!");
        b0.Category("DELIMITER");
        b0.Literal("!");
        b0._LiteralTerminal();
        b0.NonTerminal("Predicate");
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("QuantifiedPredicate");
        b0.Concatenate_(3);
        b0.Choose_(3);
        b0.Production_();
        b0.NonTerminal("One");
        b0.LiteralTerminal_();
        b0.RegExp("ONE");
        b0.Category("DELIMITER");
        b0.Literal("ONE");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Some");
        b0.LiteralTerminal_();
        b0.RegExp("SOME");
        b0.Category("DELIMITER");
        b0.Literal("SOME");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Every");
        b0.LiteralTerminal_();
        b0.RegExp("EVERY");
        b0.Category("DELIMITER");
        b0.Literal("EVERY");
        b0._LiteralTerminal();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b0.As_();
        b0.NonTerminal("PathExpression");
        b0.Name("fromClause");
        b0._As();
        b0.As_();
        b0.Optional_();
        b0.Concatenate_(2);
        b0.LiteralTerminal_();
        b0.RegExp("SATISFIES");
        b0.Category("DELIMITER");
        b0.Literal("SATISFIES");
        b0._LiteralTerminal();
        b0.NonTerminal("Predicate");
        b0._Concatenate();
        b0._Optional();
        b0.Name("whereClause");
        b0._As();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("ParenthesizedPredicate");
        b0.Concatenate_(3);
        b0.LiteralTerminal_();
        b0.RegExp("\\Q(\\E");
        b0.Category("DELIMITER");
        b0.Literal("(");
        b0._LiteralTerminal();
        b0.As_();
        b0.NonTerminal("Predicate");
        b0.Name("predicate");
        b0._As();
        b0.LiteralTerminal_();
        b0.RegExp(")");
        b0.Category("DELIMITER");
        b0.Literal(")");
        b0._LiteralTerminal();
        b0._Concatenate();
        b1.Resolver();
        b0._Production();
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("Index");
        b0.Choose_(2);
        b0.NonTerminal("INT");
        b0.NonTerminal("Last");
        b0._Choose();
        b1.Resolver();
        b0._Production();
        b0.Production_();
        b0.NonTerminal("SimpleName");
        b0.NonTerminal("STRING");
        b1.Resolver();
        b0._Production();
        b0._Productions();
        b0.URI("http://examples.whole.org/QueriesGrammar");
        b0.Namespace("org.whole.examples.queriesgrammar");
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b0._Grammar();
    }
}
