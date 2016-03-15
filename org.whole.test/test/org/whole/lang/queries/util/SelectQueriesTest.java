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

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.util.TestXmlGrammar;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.Assignment;
import org.whole.lang.java.model.BodyDeclarations;
import org.whole.lang.java.model.ClassDeclaration;
import org.whole.lang.java.model.ExpressionStatement;
import org.whole.lang.java.model.FieldDeclaration;
import org.whole.lang.java.model.IfStatement;
import org.whole.lang.java.model.InfixOperatorEnum;
import org.whole.lang.java.model.MethodDeclaration;
import org.whole.lang.java.model.PrefixOperatorEnum;
import org.whole.lang.java.model.SingleVariableDeclaration;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.text.factories.TextEntityFactory;
import org.whole.lang.text.model.Document;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class SelectQueriesTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testSelectPathExpression1() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("selectPath1");

		StringBuilder names = new StringBuilder();
		for (NonTerminal nt : BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(pe1, g))
			names.append(nt.getValue());

		assertEquals("DocumentElementINameIContent", names.toString());
	}

    @Test
    public void testSelectPathExpression2() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Grammar model = new TestXmlGrammar().create();

		PathExpression query = (PathExpression) tm.create("selectPath2");

		StringBuilder names = new StringBuilder();
		for (NonTerminal nt : BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(query, model))
			names.append(nt.getValue());

		assertEquals("DocumentElementINameIContent", names.toString());
	}

    @Test
    public void testSelectDistinct() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("selectNonTerminalSet");

		Set<String> set = new HashSet<String>();
		for (NonTerminal nt : BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(pe1, g))
			if (!set.add(nt.getValue()))
				fail();

		assertEquals(22, set.size());
	}

    @Test
    public void testSelectTuple1() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTuple1");

		int count = 0;
		for (IEntity t : BehaviorUtils.compileAndLazyEvaluate(pe1, g)) {
			NonTerminal name = (NonTerminal) t.wGet(0);
			Rule rule = (Rule) t.wGet(1);
			Production prod = (Production) t.wGet(2);
			assertEquals(name, prod.getName());
			assertSame(rule, prod.getRule());
			assertEquals(g.getName(), t.wGet(3));
			count++;
		}

		assertEquals(g.getPhraseStructure().wSize(), count);
	}

    @Test
    public void testSelectTemplate1() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Grammar model = new TestXmlGrammar().create();
		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		PathExpression query = (PathExpression) tm.create("selectTemplate1");

		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			Feature f = (Feature) tuple.wGet(0);
			As e = (As) tuple.wGet(1);

			assertEquals(e.getName().getValue(), f.getName().wStringValue());
			assertEquals(e.getRule().wStringValue(), f.getType().wStringValue());
		}
	}

    @Test
    public void testSelectTupleWithTemplates() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Grammar model = new TestXmlGrammar().create();
		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		PathExpression query = (PathExpression) tm.create("selectTupleWithTemplates");

		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			FieldDeclaration fd = (FieldDeclaration) tuple.wGet(0);
			Feature f = (Feature) tuple.wGet(1);
			As e = (As) tuple.wGet(2);
			
			assertEquals(e.getName().getValue(), fd.getFragments().wGet(0).wGet(0).wStringValue());
			assertEquals(e.getRule().wStringValue(), fd.getType().wStringValue());

			assertEquals(e.getName().getValue(), f.getName().wStringValue());
			assertEquals(e.getRule().wStringValue(), f.getType().wStringValue());
		}
	}

    @Test
    public void testSelectTemplateWithNestedQuery() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateWithNestedQuery");

		for (ClassDeclaration t : BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe1, m)) {
			assertEquals(JavaEntityDescriptorEnum.ClassDeclaration, t.wGetEntityDescriptor());
			assertTrue(t.getBodyDeclarations().wSize() >= 2);
		}
	}

	@Test
    public void testSelectTemplateWithNestedRelativeQuery() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateWithNestedRelativeQuery");
		PathExpression pe2 = (PathExpression) tm.create("selectTemplateWithNestedQuery");

		IEntityIterator<ClassDeclaration> i2 = BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe2, m);
		for (ClassDeclaration t : BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe1, m)) {
			assertTrue(i2.hasNext());
			assertTrue(Matcher.match(i2.next(), t));
		}
	}

	@Test
    public void testSelectTemplateWithNestedEmptyQuery() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateWithNestedEmptyQuery");

		for (ClassDeclaration t : BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe1, m)) {
			assertEquals(JavaEntityDescriptorEnum.ClassDeclaration, t.wGetEntityDescriptor());
			assertEquals(2, t.getBodyDeclarations().wSize());
		}
	}

	@Test
    public void testSelectTemplateWithJavaHelpers() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateWithJavaHelpers");

		for (ClassDeclaration t : BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe1, m)) {
			assertEquals(JavaEntityDescriptorEnum.ClassDeclaration, t.wGetEntityDescriptor());
			String cname = t.getName().wStringValue();
			assertTrue(Character.isUpperCase(cname.charAt(0)) && cname.endsWith("Impl"));
			for (int i=0; i<t.getBodyDeclarations().wSize(); i++) {
				FieldDeclaration fd = (FieldDeclaration) t.getBodyDeclarations().wGet(i);
				assertTrue(Character.isUpperCase(fd.getType().wStringValue().charAt(0)));
			}
		}
	}

	@Test
    public void testSelectTemplateWithFreeVariable() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateWithFreeVariable");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		for (ClassDeclaration t : BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe1, m, bm)) {
			assertEquals(JavaEntityDescriptorEnum.ClassDeclaration, t.wGetEntityDescriptor());
			if (bm.wIsSet("freeVariable")) {
				assertEquals(bm.wStringValue("freeVariable"), t.getName().wStringValue());
				bm.wUnset("freeVariable");
			} else {
				assertTrue(t.getName().wIsAdapter());
				bm.wDefValue("freeVariable", "MyClassName");
			}
		}
	}

	@Test
    public void testSelectTemplateWithTwoNestedSimpleQueries() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateWithTwoNestedSimpleQueries");

		for (Feature f : BehaviorUtils.<Feature>compileAndLazyEvaluate(pe1, g)) {
			assertEquals(ModelsEntityDescriptorEnum.Feature, f.wGetEntityDescriptor());
		}
	}

	@Test
    public void testSelectTemplateWithTwoNestedSelectQueries() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateWithTwoNestedSelectQueries");

		for (ClassDeclaration t : BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe1, m)) {
			assertEquals(JavaEntityDescriptorEnum.ClassDeclaration, t.wGetEntityDescriptor());
			BodyDeclarations bodyDeclarations = t.getBodyDeclarations();
			MethodDeclaration md = (MethodDeclaration) bodyDeclarations.wGet(bodyDeclarations.wSize()-1);
			assertEquals(bodyDeclarations.wSize()-1, md.getBody().wSize());
		}
	}

	@Test
    public void testSelectHelperResultAs() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model model = new XmlModel().create();

		PathExpression query = (PathExpression) tm.create("selectHelperResultAs");
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			IEntity stringData = tuple.wGet(0);
			SimpleEntity e = (SimpleEntity) tuple.wGet(1);

			String entityName = e.getName().getValue();
			String className = bm.wStringValue("className");
			assertEquals(StringUtils.toUpperCap(entityName), className);
			assertEquals(className, stringData.wStringValue());
		}
	}

	@Test
    public void testSelectTemplateFromPattern() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		JavaEntityFactory ef = JavaEntityFactory.instance;
		IfStatement ifStm = ef.createIfStatement(
				ef.createPrefixExpression(ef.createPrefixOperator(PrefixOperatorEnum.not), 
						ef.createInfixExpression(
								ef.createSimpleName("x"),
								ef.createInfixOperator(InfixOperatorEnum.less),
								ef.createIntLiteral(3),
								ef.createExpressions(0)
						)
				),
				ef.createEmptyStatement(),
				ef.createBlock(
						ef.createExpressionStatement(ef.createAssignment()),
						ef.createExpressionStatement(ef.createAssignment())));

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateFromPattern");

		IfStatement t = BehaviorUtils.<IfStatement>evaluateFirstResult(pe1, ifStm);
		assertEquals(JavaEntityDescriptorEnum.PrefixExpression, t.getExpression().wGetEntityDescriptor());
		assertTrue(Matcher.match(ifStm.getElseStatement(), t.getThenStatement()));
		assertTrue(Matcher.match(ifStm.getThenStatement(), t.getElseStatement()));
	}

	@Test
    public void testSelectTemplateFromPathWithPattern() {
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression pe1 = (PathExpression) tm.create("selectTemplateFromPathWithPattern");

		IEntityIterator<Feature> featureIterator = IteratorFactory.<Feature>descendantOrSelfMatcherIterator().withPattern(ModelsEntityDescriptorEnum.Feature);
		featureIterator.reset(m);

		for (FieldDeclaration field : BehaviorUtils.<FieldDeclaration>compileAndLazyEvaluate(pe1, m)) {
			Feature feature = featureIterator.next();
			assertEquals(feature.getType().wStringValue(), field.getType().wStringValue());
			assertEquals(feature.getName().wStringValue(), field.getFragments().wGet(0).wGet(0).wStringValue());
		}
	}

	@Test
    public void testSelectTemplateFromPatternWithWhere() {
		Model m = new XmlModel().create();
		Feature feature = (Feature) ((SimpleEntity) m.getDeclarations().wGet(0)).getFeatures().wGet(0);

		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression pe1 = (PathExpression) tm.create("selectTemplateFromPatternWithWhere");

		for (FieldDeclaration field : BehaviorUtils.<FieldDeclaration>compileAndLazyEvaluate(pe1, feature)) {
			assertEquals(feature.getName().wStringValue(), field.getFragments().wGet(0).wGet(0).wStringValue());
			assertEquals(StringUtils.toUpperCap(feature.getType().wStringValue()), field.getType().wStringValue());
		}
	}

	@Test
    public void testSelectTemplateAs() {
		Model model = new XmlModel().create();

		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("selectTemplateAs");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			FieldDeclaration f = (FieldDeclaration) tuple.wGet(0);
			Feature e = (Feature) tuple.wGet(1);

			FieldDeclaration field = (FieldDeclaration) bm.wGet("field");
			assertSame(f, field);
			String ptype = e.getType().wStringValue();
			assertEquals(ptype, field.getType().wStringValue());
		}
	}

	@Test
    public void testSelectTupleOfTemplatesAs() {
		Model model = new XmlModel().create();

		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("selectTupleOfTemplatesAs");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			FieldDeclaration f = (FieldDeclaration) tuple.wGet(0);
			SingleVariableDeclaration p = (SingleVariableDeclaration) tuple.wGet(1);
			ExpressionStatement s = (ExpressionStatement) tuple.wGet(2);
			Feature e = (Feature) tuple.wGet(3);

			String ptype = e.getType().wStringValue();
			String pname = e.getName().wStringValue();

			assertSame(f, bm.wGet("field"));
			assertEquals(ptype, f.getType().wStringValue());

			assertSame(p, bm.wGet("param"));
			assertEquals(ptype, p.getType().wStringValue());
			assertEquals(pname, p.getName().wStringValue());
			
			assertSame(s, bm.wGet("init"));
			assertEquals(pname, ((Assignment) s.getExpression()).getRightHandSide().wStringValue());
		}
	}

	@Test
    public void testTemplateFromWhere() {
		Model m = new XmlModel().create();
		SimpleEntity simpleEntity = (SimpleEntity) m.getDeclarations().wGet(0);
		
		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression pe1 = (PathExpression) tm.create("selectTemplateFromWhere");

		for (ClassDeclaration classDecl : BehaviorUtils.<ClassDeclaration>compileAndLazyEvaluate(pe1, simpleEntity)) {
			assertEquals(
					StringUtils.toUpperCap(simpleEntity.getName().getValue()),
					classDecl.getName().wStringValue());
			int featuresSize = simpleEntity.getFeatures().wSize();
			assertEquals(featuresSize*2, classDecl.getBodyDeclarations().wSize());
		}
	}

	@Test
    public void testVariableScopes() {
		Model model = new XmlModel().create();

		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("selectVariableScopes");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			Document d = (Document) tuple.wGet(0);
			SimpleEntity se = (SimpleEntity) tuple.wGet(1);

			assertFalse(bm.wIsSet("fromName"));
			assertFalse(bm.wIsSet("oneTime"));
			assertFalse(bm.wIsSet("featuresTimes"));
			assertFalse(bm.wIsSet("featuresTimesInLine"));
			assertFalse(bm.wIsSet("fTimes"));
			assertFalse(bm.wIsSet("siblingTimes"));

			assertTrue(1 < d.wGet(0).wSize()-1); //changed semantics: from variables are substituted multiple times
			assertEquals(1, d.wGet(1).wSize()-1);
			assertEquals(se.getFeatures().wSize(), d.wGet(2).wSize()-1);
			assertEquals(se.getFeatures().wSize(), d.wGet(3).wSize()-1);
			assertEquals(model.getDeclarations().wSize()-1-model.getDeclarations().wIndexOf(se), d.wGet(4).wSize()-1);
		}
	}

	@Test
    public void testBindingScopes() {
		Model m = new XmlModel().create();

		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("selectBindingScopes");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		BindingsTester bt = new BindingsTester(bm);
		bm.wDefValue("bindingsTester", bt);
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, m, bm)) {
			Document d = (Document) tuple.wGet(0);
			SimpleEntity e = (SimpleEntity) tuple.wGet(1);
			String eName = e.getName().getValue();

			assertEquals(eName, d.wGet(0).wGet(1).wStringValue());
			assertEquals(eName+eName, d.wGet(1).wGet(1).wStringValue());
			assertEquals(eName+eName+eName+eName, d.wGet(2).wGet(1).wStringValue());
			for (int f=0; f<e.getFeatures().wSize(); f++) {
				assertEquals(eName+eName+eName+eName+eName+eName+eName+eName,
						d.wGet(3).wGet(1+f).wStringValue());
				assertEquals("true",
						d.wGet(4).wGet(1+f).wStringValue());
				assertEquals("true",
						d.wGet(5).wGet(1+f).wStringValue());
			}
			assertEquals(3, d.wGet(6).wSize());
			assertTrue(EntityUtils.isVariable(d.wGet(6).wGet(1)));
			assertTrue(EntityUtils.isVariable(d.wGet(6).wGet(2)));
		}
	}

	@Test
    public void testBindingScopes2() {
		Model model = new XmlModel().create();

		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("selectBindingScopes2");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			Document d = (Document) tuple.wGet(0);
			SimpleEntity e = (SimpleEntity) tuple.wGet(1);
			String eName = e.getName().getValue();

			assertEquals(eName, d.wGet(0).wGet(1).wStringValue());
			assertEquals(eName, d.wGet(0).wGet(2).wStringValue());
			assertEquals(eName+eName, d.wGet(1).wGet(1).wStringValue());
		}
	}

	@Test
    public void testBindingScopes3() {
		Model model = new XmlModel().create();

		ITemplateManager tm = SelectQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("selectBindingScopes3");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			Document d = (Document) tuple.wGet(0);
			IEntity nameData = tuple.wGet(1);

			String name = nameData.wStringValue();
			String entityName = bm.wStringValue("entityName");

			assertEquals(name, d.wGet(0).wGet(1).wStringValue());
			assertEquals(name, entityName);
			assertFalse(bm.wIsSet("fromName"));
		}
	}

	@Test
    public void testDeclaredNamesBinding() {
		IEntityIterator<IEntity> iterator = DynamicCompilerOperation.compile(
				SelectQueriesTemplateManager.instance().create("selectDeclaredNamesBinding"),
				BindingManagerFactory.instance.createArguments()).getResultIterator();
		
		assertTrue(iterator.hasNext());
		IEntity entity = iterator.next();

		assertFalse(iterator.hasNext());
		assertTrue(Matcher.match(TextEntityFactory.instance.createDocument(0), entity));
	}

	public static class BindingsTester {
		public IBindingManager bm;
		public BindingsTester(IBindingManager bm) {
			this.bm = bm;
		}

		public boolean assertUndef(String name0, String name1, String name2, String name3) {
			return isDef(name0, name1, name2, name3).indexOf('T') == -1;
		}
		public boolean assertDef(String name0, String name1, String name2, String name3) {
			return isDef(name0, name1, name2, name3).indexOf('F') == -1;
		}
		public boolean assertDef(String... names) {
			return isDef(names).indexOf('F') == -1;
		}
		public String isDef(String... names) {
			StringBuilder sb = new StringBuilder();
			for (String name : names)
				sb.append(bm.wIsSet(name) ? 'T' : 'F');
			sb.append('>');
			
			return sb.toString();
		}
	}
}
