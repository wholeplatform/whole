/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.queries.util;

import static org.whole.lang.operations.PrettyPrinterOperation.toPrettyPrintString;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.IExecutableClient;
import org.whole.lang.grammars.codebase.QueriesGrammar;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.TestXmlGrammar;
import org.whole.lang.java.model.FieldDeclaration;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.KindTestEnum;
import org.whole.lang.queries.model.Path;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Riccardo Solmi
 */
public class PathExpressionsQueriesTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	private Path buildPath9(QueriesEntityFactory ef) {
		return ef.createPath(
				ef.createFeatureStep("phraseStructure"),
				ef.createFilter(
						ef.createChildStep(),
						ef.createAnd(
								ef.createTypeTest("Production"),
								ef.createSome(
										ef.createFeatureStep("name"),
										ef.createVisitorTest(new GenericIdentityVisitor() {
											public void visit(IEntity entity) {
												if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.NonTerminal, entity) && entity.wStringValue().startsWith("I"))
													return;
												throw new VisitException();
											}
											public String toString() {
												return "startsWith(\"I\")";
											}
										})
								))));
	}

	private Path buildPath10(QueriesEntityFactory ef) {
		return ef.createPath(
				ef.createFilter(
						ef.createChildStep(), ef.createTypeTest("As")),
						ef.createFilter(
								ef.createFollowingSiblingStep(),
								ef.createAnd(
										ef.createIndexTest(ef.createIntLiteral(0)),
										ef.createTypeTest("As"))));
	}

	@Test
	public void testPrettyPrint() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		Assert.assertEquals("phraseStructure/child()[0]/rule/child()[0]/name", toPrettyPrintString(
				(PathExpression) tm.create("path1")));
		Assert.assertEquals("phraseStructure/child()[2]", toPrettyPrintString(
				(PathExpression) tm.create("path1a")));
		Assert.assertEquals("phraseStructure/child()[2][type() = Production]", toPrettyPrintString(
				(PathExpression) tm.create("path1b")));
		Assert.assertEquals("phraseStructure/child()[0]/following-sibling()[2]", toPrettyPrintString(
				(PathExpression) tm.create("path1c")));
		Assert.assertEquals("phraseStructure/child()[0]/following-sibling()[2][type() = Production]", toPrettyPrintString(
				(PathExpression) tm.create("path1d")));
		Assert.assertEquals("phraseStructure/child()[0]/rule/descendant()[kind() = SIMPLE]|[kind() = DATA]", toPrettyPrintString(
				(PathExpression) tm.create("path2")));		
		Assert.assertEquals("phraseStructure/child()[0]/rule/descendant()![kind() = COMPOSITE]", toPrettyPrintString(
				(PathExpression) tm.create("path3")));		
		Assert.assertEquals("phraseStructure/child()[type() <: Production]/rule/descendant()[type() <: Production]", toPrettyPrintString(
				(PathExpression) tm.create("path4")));		
		Assert.assertEquals("(phraseStructure, lexicalStructure)/child()[type() <: Production][exists rule[type() = Choose]]", toPrettyPrintString(
				(PathExpression) tm.create("path5")));		
		Assert.assertEquals("phraseStructure/child()[type() = Production][some name satisfies [visitor: startsWith(\"I\")]]", toPrettyPrintString(buildPath9(ef)));		
	}

	@Test
	public void testLanguageTest() throws Exception {
		IEntity model = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/templates/codebase/TemplateManagerArtifactsTemplates.xwl"));

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createLanguageTest("http://lang.whole.org/Java")), model))
			Assert.assertEquals("http://lang.whole.org/Java", e.wGetLanguageKit().getURI());
	}

	@Test
	public void testKindTest() throws Exception {
		IEntity model = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/templates/codebase/TemplateManagerArtifactsTemplates.xwl"));

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createKindTest(KindTestEnum.RESOLVER)), model))
			Assert.assertTrue(EntityUtils.isResolver(e));

		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createKindTest(KindTestEnum.DATA)), model))
			Assert.assertTrue(EntityUtils.isData(e));

		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createKindTest(KindTestEnum.FRAGMENT)), model))
			Assert.assertTrue(EntityUtils.isFragment(e));
	}

	@Test
	public void testVisitorTest() {
		Grammar g = new TestXmlGrammar().create();

		for (Production p : BehaviorUtils.compileAndLazyEvaluate(buildPath9(QueriesEntityFactory.instance), g).<Production>client())
			Assert.assertTrue(p.getName().getValue().startsWith("I"));
	}

	@Test
	public void testPathByNameAndByIndexSteps() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		IExecutableClient<NonTerminal> nti = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1"), g).client();

		IEntity e = nti.evaluateNext();
		Assert.assertNotNull(e);
		Assert.assertSame(prologNt, e);

		nti.reset(g.getPhraseStructure());
		Assert.assertNull(nti.evaluateNext());

		nti.reset(g);
		e = nti.evaluateNext();
		Assert.assertNotNull(e);
		Assert.assertSame(prologNt, e);		
	} 

	@Test
	public void testIndexTest() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		IExecutableClient<Production> pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1a"), g).client();
		IEntity e = pi.evaluateNext();
		Assert.assertNotNull(e);
		Assert.assertSame(g.getPhraseStructure().wGet(2), e);
		Assert.assertNull(pi.evaluateNext());

		pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1b"), g).client();
		e = pi.evaluateNext();
		Assert.assertNotNull(e);
		Assert.assertSame(g.getPhraseStructure().wGet(2), e);
		Assert.assertNull(pi.evaluateNext());

		pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1c"), g).client();
		e = pi.evaluateNext();
		Assert.assertNotNull(e);
		Assert.assertSame(g.getPhraseStructure().wGet(3), e);
		Assert.assertNull(pi.evaluateNext());

		pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1d"), g).client();
		e = pi.evaluateNext();
		Assert.assertNotNull(e);
		Assert.assertSame(g.getPhraseStructure().wGet(3), e);
		Assert.assertNull(pi.evaluateNext());
	}

	@Test
	public void testPathWithKindAndLogicFiltersIterator() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();

		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path2"), new TestXmlGrammar().create()))
			Assert.assertTrue(p.wGetEntityKind().equals(EntityKinds.SIMPLE) || p.wGetEntityKind().equals(EntityKinds.DATA));

		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path3"), new TestXmlGrammar().create()))
			Assert.assertFalse(p.wGetEntityKind().equals(EntityKinds.COMPOSITE));
	}

	@Test
	public void testPathWithFiltersIterator() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Set<String> l = new HashSet<String>();
		for (Production p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path4"), g).<Production>client())
			l.add(p.getName().getValue());

		Assert.assertEquals(16, l.size());
	}

	@Test
	public void testPathWithPatternFiltersIterator() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Set<String> l = new HashSet<String>();
		for (Production p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path5"), g).<Production>client())
			l.add(p.getName().getValue());

		Assert.assertEquals(2, l.size());
	}

	@Test
	public void testDistinct() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("nonTerminalSet");

		Set<String> set = new HashSet<String>();
		for (NonTerminal nt : BehaviorUtils.compileAndLazyEvaluate(pe1, g).<NonTerminal>client())
			if (!set.add(nt.getValue()))
				Assert.fail();

		Assert.assertEquals(22, set.size());
	}

	@Test
	public void testPathWithTuple() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		IExecutable i = DynamicCompilerOperation.compile(
				tm.create("pathWithTuple"),
				BindingManagerFactory.instance.createArguments()).getExecutableResult();
		
		i.reset(BindingManagerFactory.instance.createNull());
		IEntity e0 = i.evaluateNext();
		Assert.assertNotNull(e0);
		Assert.assertNull(i.evaluateNext());
	}

	@Test
	public void testProduct1() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("testProduct1");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			String vname = ((Production) bm.wGet("pp")).getName().getValue()+"x"+((Production) bm.wGet("lp")).getName().getValue();
			String tname = ((Production) tuple.wGet(0)).getName().getValue()+"x"+((Production) tuple.wGet(1)).getName().getValue();
			Assert.assertEquals(vname, tname);
			count++;
		}

		Assert.assertEquals(g.getPhraseStructure().wSize()*g.getLexicalStructure().wSize(), count);
	}

	@Test
	public void testProduct2() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("testProduct2");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			String prodname = ((Production) bm.wGet("prod")).getName().getValue();
			Assert.assertEquals(prodname, tuple.wGet(0).wStringValue());
			count++;
		}

		Assert.assertEquals(g.getPhraseStructure().wSize(), count);
	}

	@Test
	public void testProduct3() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("testProduct3");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			String vname = ((NonTerminal) bm.wGet("name1")).getValue()+"x"+((NonTerminal) bm.wGet("name2")).getValue();
			String tname = tuple.wGet(0).wStringValue()+"x"+tuple.wGet(1).wStringValue();
			Assert.assertEquals(vname, tname);
			count++;
		}

		Assert.assertEquals(g.getPhraseStructure().wSize()*g.getPhraseStructure().wSize(), count);
	}

	@Test
	public void testProduct4() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		PathExpression pe1 = (PathExpression) tm.create("testProduct4");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			Production p = (Production) productions.wGet(count++);

			Assert.assertSame(p.getName(), bm.wGet("name"));
			Assert.assertSame(p.getRule(), bm.wGet("rule"));
			Assert.assertSame(p.getName(), tuple.wGet(0));
			Assert.assertSame(p.getRule(), tuple.wGet(1));
		}

		Assert.assertEquals(g.getPhraseStructure().wSize(), count);
	}

	@Test
	public void testSingleVariableTestInPathExpPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Production p = (Production) g.getPhraseStructure().wGet(1);

		PathExpression pe1 = (PathExpression) tm.create("findProduction");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		//FIXME bm.wDefValue("pname", "Element");
		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("Element"));
		IEntity p1 = BehaviorUtils.evaluateFirstResult(pe1, g, bm);
		Assert.assertSame(p, p1);

		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("invented"));
		p1 = BehaviorUtils.evaluateFirstResult(pe1, g, bm);
		Assert.assertNull(p1);
	}

	@Test
	public void testSingleVariableTestInPathExpPredicateOfPathInternalStep() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("findAllNonTerminalsUsed");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		//FIXME bm.wDefValue("pname", "Element");
		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("IName"));
		int count = 0;
		for (NonTerminal nt : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm).<NonTerminal>client())
			count++;
		Assert.assertEquals(4, count);
	}

	@Test
	public void testSingleVariableTestInPathLastStep() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("findNonTerminalOccurrences");
		PathExpression pe2 = (PathExpression) tm.create("bindNonTerminalOccurrences");
		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		IExecutableClient<NonTerminal> i1 = BehaviorUtils.compileAndLazyEvaluate(pe1, g).client();
		for (NonTerminal nt : BehaviorUtils.compileAndLazyEvaluate(pe2, g, bm).<NonTerminal>client()) {
			Assert.assertSame(nt, i1.evaluateNext());
			Assert.assertEquals(nt.getValue(), bm.wStringValue("nt"));
		}
		Assert.assertNull(i1.evaluateNext());
	}

	@Test
	public void testVariableJoinTest2() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction2");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.compileAndLazyEvaluate(pe1, g).<Production>client())
			names.append(p.getName().getValue());

		Assert.assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}
	@Test
	public void testVariableJoinTest3() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction3");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.compileAndLazyEvaluate(pe1, g).<Production>client())
			names.append(p.getName().getValue());

		Assert.assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}
	@Test
	public void testVariableJoinTest4() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction4");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.compileAndLazyEvaluate(pe1, g).<Production>client())
			names.append(p.getName().getValue());

		Assert.assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}
	@Test
	public void testVariableJoinTest5() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction5");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.compileAndLazyEvaluate(pe1, g).<Production>client())
			names.append(p.getName().getValue());

		Assert.assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}

	@Test
	public void testSomePredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction6");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.compileAndLazyEvaluate(pe1, g).<Production>client())
			names.append(p.getName().getValue());

		Assert.assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}

	@Test
	public void testEveryPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("unusedProduction");

		IExecutableClient<Production> executable = BehaviorUtils.compileAndLazyEvaluate(pe1, g).client();
		Production p = executable.evaluateNext();
		Assert.assertNotNull(p);
		Assert.assertEquals("Statement", p.getName().getValue());
		p = executable.evaluateNext();
		Assert.assertNotNull(p);
		Assert.assertEquals("Declaration", p.getName().getValue());
		p = executable.evaluateNext();
		Assert.assertNotNull(p);
		Assert.assertEquals("Index", p.getName().getValue());
		Assert.assertNull(executable.evaluateNext());
	}

	@Test
	public void testOnePredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("exactlyOneDefUse");
		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		IExecutableClient<Production> executable = BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm).client();
		Production p = executable.evaluateNext();
		Assert.assertNotNull(p);
		Assert.assertEquals("IName", p.getName().getValue());
		Assert.assertNull(executable.evaluateNext());
	}

	@Test
	public void testVariablesInQuantifiedPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction6");
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		IExecutableClient<Production> executable = BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm).client();
		executable.evaluateNext();
		Assert.assertTrue(bm.wIsSet("pname"));
		Assert.assertTrue(bm.wIsSet("nt"));

		pe1 = (PathExpression) tm.create("exactlyOneDefUse");
		bm = BindingManagerFactory.instance.createArguments();
		executable = BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm).client();
		executable.evaluateNext();
		Assert.assertTrue(bm.wIsSet("pname"));
		Assert.assertTrue(bm.wIsSet("nt"));

		pe1 = (PathExpression) tm.create("unusedProduction");
		bm = BindingManagerFactory.instance.createArguments();
		executable = BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm).client();
		executable.evaluateNext();
		Assert.assertTrue(bm.wIsSet("pname"));
		Assert.assertTrue(bm.wIsSet("nt"));
	}

	@Test
	public void testRebindVariable() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("Element"));

		int count = 0;
		for (Production p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("findProduction"), g, bm).<Production>client())
			count++;
		Assert.assertEquals(1, count);

		count = 0;
		for (Production p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("findProduction"), g).<Production>client())
			count++;
		Assert.assertEquals(6, count);		
	}

	@Test
	public void testPatternPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		int count = 0;
		for (As as : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path7"), g).<As>client()) {
			Assert.assertEquals("tag", as.getName().wStringValue());
			count++;
		}

		Assert.assertEquals(2, count);
	}

	@Test
	public void testPatternWithVariablePredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		StringBuilder names = new StringBuilder();
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		for (Production p :  BehaviorUtils.compileAndLazyEvaluate(
				(PathExpression) tm.create("path8"), g, bm).<Production>client()) {
			Assert.assertEquals(bm.wStringValue("name"), p.getName().getValue());
			names.append(p.getName().getValue());
		}

		Assert.assertEquals("VersionEncodingValueNameNameSpaceCharDataCDataSectDataCommentText", names.toString());
	}

	@Test
	public void testBindingOfSelfIndex() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		int count = 0;
		for (Production p : BehaviorUtils.compileAndLazyEvaluate(
				(PathExpression) tm.create("path6"), g).<Production>client()) {
			Assert.assertTrue(g.getPhraseStructure().wIndexOf(p) >= 2);
			count++;
		}

		Assert.assertEquals(2, count);
	}

	@Test
	public void testChildStepByName() {
		Model model = new XmlModel().create();

		SimpleName name = model.getName();

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		IEntity result = BehaviorUtils.evaluateFirstResult(
				ef.createFeatureStep("name"), model);

		Assert.assertSame(name, result);
	}

	@Test
	public void testChildStepByIndex() {
		Model model = new XmlModel().create();
		ModelDeclarations decls = model.getDeclarations();

		IEntity decl3 = decls.wGet(3);

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		IEntity result = BehaviorUtils.evaluateFirstResult(
				ef.createFilter(ef.createChildStep(), ef.createIndexTest(ef.createIntLiteral(3))), decls);

		Assert.assertSame(decl3, result);
	}

	@Test
	public void testPathOfChildSteps() {
		Model model = new XmlModel().create();

		IEntity decl3 = model.getDeclarations().wGet(3);

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		PathExpression pe = ef.createPath(
				ef.createFeatureStep("declarations"),
				ef.createFilter(ef.createChildStep(), ef.createIndexTest(ef.createIntLiteral(3))));
		IEntity result = BehaviorUtils.evaluateFirstResult(pe, model);

		Assert.assertSame(decl3, result);
	}

	@Test
	public void testHelperResultAs() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression query = (PathExpression) tm.create("helperResultAs");
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("ftype", "firstName");

		IExecutableClient<FieldDeclaration> executable = BehaviorUtils.compileAndLazyEvaluate(query, m, bm).client();
		IEntity result = executable.evaluateNext();
		Assert.assertNotNull(result);
		IEntity as = bm.wGet("jtype");
		Assert.assertEquals("FirstName", result.wStringValue());
		Assert.assertEquals("FirstName", as.wStringValue());

		Assert.assertNull(executable.evaluateNext());
		executable.reset(m);

		bm.wDefValue("ftype", "secondName");
		IEntity result2 = executable.evaluateNext();
		Assert.assertNotNull(result2);
		IEntity as2 = bm.wGet("jtype");
		Assert.assertEquals("SecondName", result2.wStringValue());
		Assert.assertEquals("SecondName", as2.wStringValue());
	}
}
