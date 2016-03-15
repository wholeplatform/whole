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

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.TestXmlGrammar;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.ClassDeclaration;
import org.whole.lang.java.model.InfixOperatorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.ModelsModel;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.FeatureModifiers;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class ControlQueriesTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testIf1() {
		Model model = new XmlModel().create();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("if1");

		assertFalse(BehaviorUtils.compileAndLazyEvaluate(query, model.getDeclarations()).hasNext());

		IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(query, model);
		assertTrue(iterator.hasNext());
		assertEquals(model.getName().getValue(), iterator.next().wStringValue());
		assertFalse(iterator.hasNext());
	}

    @Test
    public void testIf2() {
		Model model = new XmlModel().create();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("if2");

		IEntity result = BehaviorUtils.evaluateFirstResult(query, model);
		assertTrue(result instanceof ClassDeclaration);
		assertEquals(model.getName().getValue(), ((ClassDeclaration) result).getName().getValue());
	}

    @Test
    public void testIf3() {
		Model model = new XmlModel().create();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("if3");

		IEntity result = BehaviorUtils.evaluateFirstResult(query, model);
		assertTrue(result instanceof ClassDeclaration);
		assertEquals(StringUtils.toUpperCap(model.getName().getValue()), ((ClassDeclaration) result).getName().getValue());
	}

    @Test
    public void testIf4() {
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("if4");

		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		IEntity queryExp1 = qef.createDivision(qef.createIntLiteral(10), qef.createIntLiteral(8));

		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(query, queryExp1, bm);
		
		assertTrue(iterator.hasNext());
		IEntity exp1 = iterator.next();
		assertSame(queryExp1.wGet(0), exp1);
		assertTrue(bm.wIsSet("a"));
		assertFalse(bm.wIsSet("b"));
		assertFalse(bm.wIsSet("exp1"));
		assertFalse(bm.wIsSet("exp2"));

		assertTrue(iterator.hasNext());
		IEntity exp2 = iterator.next();
		assertSame(queryExp1.wGet(1), exp2);
		assertFalse(bm.wIsSet("a"));		
		assertTrue(bm.wIsSet("b"));
		assertFalse(bm.wIsSet("exp1"));
		assertFalse(bm.wIsSet("exp2"));

		assertFalse(iterator.hasNext());
	}

    @Test
    public void testIf5() {
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("if5");

		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		IEntity queryExp1 = qef.createDivision(qef.createIntLiteral(10), qef.createIntLiteral(8));

		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		IEntity queryRes1 = BehaviorUtils.evaluateFirstResult(query, queryExp1, bm);
		
		assertNotSame(queryExp1.wGet(0), queryRes1.wGet(0));
		assertTrue(Matcher.match(queryExp1.wGet(0), queryRes1.wGet(0)));
		assertNotSame(queryExp1.wGet(1), queryRes1.wGet(1));
		assertTrue(Matcher.match(queryExp1.wGet(1), queryRes1.wGet(1)));
		assertTrue(bm.wIsSet("a"));
		assertTrue(bm.wIsSet("b"));
		assertFalse(bm.wIsSet("exp1"));
		assertFalse(bm.wIsSet("exp2"));
	}

    @Test
    public void testDo1() {
		Model model = new XmlModel().create();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("do1");

		IEntity result = BehaviorUtils.evaluateFirstResult(query, model);
		assertTrue(result instanceof ClassDeclaration);
		assertEquals("HelloWorld", ((ClassDeclaration) result).getName().getValue());
	}

    @Test
    public void testFor1() {
		Model model = new XmlModel().create();
		ModelDeclarations decls = model.getDeclarations();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("for1");

		int i=0;
		for (IEntity name : BehaviorUtils.compileAndLazyEvaluate(query, model)) {
			while (!Matcher.match(ModelsEntityDescriptorEnum.SimpleEntity, decls.wGet(i)))
				i++;
			assertEquals(((SimpleEntity) decls.wGet(i++)).getName().wStringValue(), name.wStringValue());
		}
		assertTrue(i>0);
	}

    @Test
    public void testChoose1() {
		Model model = new ModelsModel().create();
		ModelDeclarations decls = model.getDeclarations();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("choose1");

		assertFalse(BehaviorUtils.compileAndLazyEvaluate(query, model).hasNext());

		int i=0;
		while (!Matcher.match(ModelsEntityDescriptorEnum.SimpleEntity, decls.wGet(i)))
			i++;
		SimpleEntity simpleEntity = (SimpleEntity) decls.wGet(i);
		
		int j=0;
		for (IEntity name : BehaviorUtils.compileAndLazyEvaluate(query, simpleEntity)) {
			assertEquals(
					((Feature) simpleEntity.getFeatures().wGet(j++)).getName().wStringValue()
					, name.wStringValue());
		}
		assertEquals(simpleEntity.getFeatures().wSize(), j);

		
		while (!Matcher.match(ModelsEntityDescriptorEnum.CompositeEntity, decls.wGet(i)))
			i++;
		CompositeEntity compositeEntity = (CompositeEntity) decls.wGet(i);
		
		IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(query, compositeEntity);
		assertTrue(iterator.hasNext());
		assertEquals(compositeEntity.getComponentType().wStringValue(), iterator.next().wStringValue());
		assertFalse(iterator.hasNext());

		while (!Matcher.match(ModelsEntityDescriptorEnum.EnumEntity, decls.wGet(i)))
			i++;
		EnumEntity enumEntity = (EnumEntity) decls.wGet(i);
		
		iterator = BehaviorUtils.compileAndLazyEvaluate(query, enumEntity);
		assertTrue(iterator.hasNext());
		assertTrue(iterator.next() instanceof EnumValues);
		assertFalse(iterator.hasNext());
	}

    @Test
    public void testChoose2() {
		Model model = new ModelsModel().create();
		ModelDeclarations decls = model.getDeclarations();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("choose2");

		int i=0;
		IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(query, model);
		while (iterator.hasNext()) {
			IEntity result;

			IEntity decl = decls.wGet(i++);
			switch (decl.wGetEntityOrd()) {
			case ModelsEntityDescriptorEnum.SimpleEntity_ord:
				IEntity features = ((SimpleEntity) decl).getFeatures();
				for (int j=0; j<features.wSize(); j++) {
					result = iterator.next();
					assertEquals(
							((Feature) features.wGet(j)).getName().wStringValue(),
							result.wStringValue());
				}
				break;
			case ModelsEntityDescriptorEnum.CompositeEntity_ord:
				result = iterator.next();
				CompositeEntity compositeEntity = (CompositeEntity) decl;
				assertEquals(
						compositeEntity.getComponentType().wStringValue(),
						result.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.DataEntity_ord:
				result = iterator.next();
				DataEntity dataEntity = (DataEntity) decl;
				assertEquals(
						dataEntity.getDataType().wStringValue(),
						result.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.EnumEntity_ord:
				EnumValues enumValues = ((EnumEntity) decl).getValues();
				if (enumValues.wIsEmpty())
					iterator.next();
				else
					for (int j=0; j<enumValues.wSize(); j++) {
						result = iterator.next();
						assertEquals(enumValues.wGet(j).wStringValue(),
								result.wStringValue());
					}
				break;
			}
		}
	}

    @Test
    public void testChoose3() {
		Model model = new ModelsModel().create();
		ModelDeclarations decls = model.getDeclarations();

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("choose3");

		int i=0;
		IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(query, model);
		while (iterator.hasNext()) {
			IEntity result = iterator.next();

			IEntity decl = decls.wGet(i++);
			switch (decl.wGetEntityOrd()) {
			case ModelsEntityDescriptorEnum.SimpleEntity_ord:
				Features features = ((SimpleEntity) decl).getFeatures();
				if (!features.isEmpty())
					assertEquals(
							features.get(0).getName().wStringValue(),
							result.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.CompositeEntity_ord:
				CompositeEntity compositeEntity = (CompositeEntity) decl;
				assertEquals(
						compositeEntity.getComponentType().wStringValue(),
						result.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.DataEntity_ord:
				DataEntity dataEntity = (DataEntity) decl;
				assertEquals(
						dataEntity.getDataType().wStringValue(),
						result.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.EnumEntity_ord:
				EnumEntity enumEntity = (EnumEntity) decl;
				assertEquals(enumEntity.getValues().wGet(0).wStringValue(),
						result.wStringValue());						
				break;
			}
		}
	}

    @Test
    public void testChoose4() {
		Model model = new ModelsModel().create();
		ModelDeclarations decls = model.getDeclarations();

		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("choose4");

		int i=0;
		IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(query, model, bm);
		while (iterator.hasNext()) {
			IEntity result = iterator.next();
			assertSame(result, bm.wGet("type"));
			assertTrue(result instanceof ClassDeclaration);
			ClassDeclaration classDecl = (ClassDeclaration) result;			

			IEntity decl = decls.wGet(i++);
			String name="", superClassName="";
			switch (decl.wGetEntityOrd()) {
			case ModelsEntityDescriptorEnum.SimpleEntity_ord:
				SimpleEntity simpleEntity = (SimpleEntity) decl;
				name = simpleEntity.getName().wStringValue();
				superClassName = "AbstractSimpleEntity";
				break;
			case ModelsEntityDescriptorEnum.CompositeEntity_ord:
				CompositeEntity compositeEntity = (CompositeEntity) decl;
				name = compositeEntity.getName().wStringValue();
				superClassName = "AbstractCompositeEntity";
				break;
			case ModelsEntityDescriptorEnum.DataEntity_ord:
				DataEntity dataEntity = (DataEntity) decl;
				name = dataEntity.getName().wStringValue();
				superClassName = "AbstractDataEntity";
				break;
			case ModelsEntityDescriptorEnum.EnumEntity_ord:
				EnumEntity enumEntity = (EnumEntity) decl;
				name = enumEntity.getName().wStringValue();
				superClassName = "AbstractEnumEntity";
				break;
			}
			assertEquals(name, classDecl.getName().wStringValue());
			assertEquals(superClassName, classDecl.getSuperclassType().wStringValue());
		}
	}

	//TODO choose5
	
    @Test
    public void testCall1() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("call1");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			count++;
		}
		
		assertEquals(16, count);
	}

    @Test
    public void testCall2() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("call2");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.NonTerminal, p));
			count++;
		}
		
		assertEquals(16, count);
	}

    @Test
    public void testCall3() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("call3");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			assertEquals("IContent", ((Production) p).getName().getValue());
			count++;
		}
		
		assertEquals(1, count);
	}
    @Test
    public void testQueryDecl1() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl1");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			assertEquals("IContent", ((Production) p).getName().getValue());
			count++;
		}
		
		assertEquals(1, count);
	}

    @Test
    public void testCall4() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("call4");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			assertEquals("IContent", ((Production) p).getName().getValue());
			count++;
		}
		
		assertEquals(1, count);
	}
    @Test
    public void testQueryDecl2() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl2");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			assertEquals("IContent", ((Production) p).getName().getValue());
			count++;
		}
		
		assertEquals(1, count);
	}

    @Test
    public void testCall5() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("call5");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			count++;
		}
		
		assertEquals(4, count);
	}

    @Test
    public void testCall6() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("call6");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			assertEquals("IContent", ((Production) p).getName().getValue());
			count++;
		}
		
		assertEquals(1, count);
	}
    @Test
    public void testQueryDecl3() {
		Grammar grammar = new TestXmlGrammar().create();
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl3");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			assertEquals("IContent", ((Production) p).getName().getValue());
			count++;
		}
		
		assertEquals(1, count);
	}

    @Test
    public void testCall7() {
		Grammar grammar = new TestXmlGrammar().create();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("call7");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(EntityUtils.isData(p));
			assertEquals("myNameImpl", p.wStringValue());
			count++;
		}

		assertEquals(1, count);
	}

	@Test
    public void testQueryDecl4() {
		Grammar grammar = new TestXmlGrammar().create();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl4");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Production, p));
			assertEquals("IContent", ((Production) p).getName().getValue());
			count++;
		}

		assertEquals(1, count);
	}

	@Test
    public void testQueryDecl5() {
		Model model = new ModelsModel().create();
		ModelDeclarations decls = model.getDeclarations();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl5");

		int count = 0;
		int index = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, model, bm)) {
			IEntity decl = decls.wGet(index++);
			switch (decl.wGetEntityOrd()) {
			case ModelsEntityDescriptorEnum.SimpleEntity_ord:
				Features features = ((SimpleEntity) decl).getFeatures();
				if (!features.isEmpty())
					assertEquals(features.get(0).getName().wStringValue(), p.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.CompositeEntity_ord:
				assertEquals(((CompositeEntity) decl).getComponentType().wStringValue(), p.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.DataEntity_ord:
				assertEquals(((DataEntity) decl).getName().wStringValue(), p.wStringValue());
				break;
			case ModelsEntityDescriptorEnum.EnumEntity_ord:
				assertTrue(Matcher.matchImpl(ModelsEntityDescriptorEnum.EnumEntity, p));
				break;
			}
			count++;
		}

		assertEquals(33, count);
	}

	@Test
    public void testQueryDecl6() {
		Grammar grammar = new TestXmlGrammar().create(); //not used

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl6");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, grammar, bm)) {
			if (++count == 1)
				assertEquals(5, p.wIntValue());
			else if (count == 2)
				assertEquals(10, p.wIntValue());
			else if (count == 3)
				assertEquals(8, p.wIntValue());
		}

		assertEquals(3, count);
	}

	@Test
    public void testQueryDecl7() {
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		JavaEntityFactory jef = JavaEntityFactory.instance;

		IEntity queryExp1 = qef.createDivision(
				qef.createMultiplication(qef.createIntLiteral(10),qef.createIntLiteral(8)), 
				qef.createAddition(qef.createIntLiteral(2), qef.createIntLiteral(1))
		);

		IEntity queryExp2 = qef.createDivision(
				qef.createIntLiteral(10), 
				qef.createAddition(qef.createIntLiteral(2), qef.createIntLiteral(1))
		);

		IEntity javaExp1 = jef.createInfixExpression(
				jef.createInfixExpression(
						jef.createIntLiteral(10),
						jef.createInfixOperator(InfixOperatorEnum.times),
						jef.createIntLiteral(8),
						jef.createExpressions(0)
				),
				jef.createInfixOperator(InfixOperatorEnum.divide),
				jef.createInfixExpression(
						jef.createIntLiteral(2),
						jef.createInfixOperator(InfixOperatorEnum.plus),
						jef.createIntLiteral(1),
						jef.createExpressions(0)
				),
				jef.createExpressions(0)
		);

		IEntity javaExp2 = EntityUtils.clone(javaExp1);
		javaExp2.wSet(JavaFeatureDescriptorEnum.leftOperand, jef.createIntLiteral(10));

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl7");

		assertTrue(Matcher.match(javaExp2, BehaviorUtils.evaluateFirstResult(query, queryExp2)));
		assertTrue(Matcher.match(javaExp1, BehaviorUtils.evaluateFirstResult(query, queryExp1)));
	}

	@Test
    public void testQueryDecl8() {
		ModelsEntityFactory mef = ModelsEntityFactory.instance;
		FeatureModifiers modifiers = mef.createFeatureModifiers(
				mef.createFeatureModifier(FeatureModifierEnum.optional),
				mef.createFeatureModifier(FeatureModifierEnum.derived),
				mef.createFeatureModifier(FeatureModifierEnum.id));

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl8");

		int count = 0;
		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate(query, modifiers)) {
			IEntity modifier = modifiers.wGet(count++);
			assertTrue(Matcher.match(modifier, p));
		}

		assertEquals(modifiers.wSize(), count);
	}

	@Test
    public void testQueryDecl9() {
		QueriesEntityFactory qef = QueriesEntityFactory.instance;

		IEntity queryExp1 = qef.createAddition(
				qef.createAddition(qef.createIntLiteral(10),qef.createIntLiteral(8)), 
				qef.createAddition(qef.createIntLiteral(2), qef.createIntLiteral(1))
		);

		ITemplateManager tm = ControlQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("queryDecl9");

		assertTrue(Matcher.match(queryExp1, BehaviorUtils.evaluateFirstResult(query, queryExp1)));
	}
}
