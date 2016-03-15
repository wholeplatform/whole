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
package org.whole.lang.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Riccardo Solmi
 */
public class DynamicModelDefinitionTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
	public void testFeatureDescriptorEnumDefinition() {
		DynamicLanguageKit lk = new DynamicLanguageKit();
		lk.setURI("http://lang.whole.org/DynamicImpl");
		lk.setNamespace("org.whole.lang.reflect");
		lk.setName("DynamicImp");
		FeatureDescriptorEnum fds = lk.getFeatureDescriptorEnum();

		fds.addFeatureDescriptors("one", "two", "tree");
		assertEquals(3, fds.size());
		
		fds.addFeatureDescriptor("four");
		assertEquals(4, fds.size());
		
		fds.addFeatureDescriptor("one"); //duplicate
		assertEquals(4, fds.size());
		
		fds.addFeatureDescriptors("one", "five", "six", "five"); //two duplicates
		assertEquals(6, fds.size());
	}

    @Test
	public void testEntityDescriptorEnumDefinition() {
		DynamicLanguageKit lk = new DynamicLanguageKit();
		lk.setURI("http://lang.whole.org/DynamicImpl");
		lk.setNamespace("org.whole.lang.reflect");
		lk.setName("DynamicImp");
		EntityDescriptorEnum eds = lk.getEntityDescriptorEnum();
		FeatureDescriptorEnum fds = lk.getFeatureDescriptorEnum();
		
		EntityDescriptor<?> e1 = eds.addSimpleEntity("zero", "zero", false);
		assertEquals("zero", e1.getName());
		assertEquals(0, e1.getOrdinal());

		EntityDescriptor<?> e2 = eds.addSimpleEntity("one", "one", false)
				.withFeature(fds.addFeatureDescriptor("f1"), e1.getOrdinal());
		assertEquals("one", e2.getName());
		assertEquals(1, e2.getOrdinal());

		EntityDescriptor<?> e3 = eds.addSimpleEntity("two", "two", false)
				.withFeature(fds.addFeatureDescriptor("f1"), e2.getOrdinal());
		e3.withFeature(fds.addFeatureDescriptor("f2"), e3.getOrdinal());
		assertEquals("two", e3.getName());
		assertEquals(2, e3.getOrdinal());
		
		EntityDescriptor<?> e4 = eds.addCompositeEntity("list", "list", false, true, false);
		e4.withFeature(CommonsFeatureDescriptorEnum.composite_element, e2.getOrdinal());
		assertEquals("list", e4.getName());
		assertEquals(3, e4.getOrdinal());
		assertEquals(CompositeKinds.LIST, e4.getCompositeKind());
		
		EntityDescriptor<?> e5 = eds.addDataEntity("intData", "intData", false, int.class);
		assertEquals("intData", e5.getName());
		assertEquals(4, e5.getOrdinal());
		assertTrue(e5.getDataKind().isInt());

		EntityDescriptor<?> e6 = eds.addEnumEntity("enumData", "enumData", "a", "b", "c");
		assertEquals("enumData", e6.getName());
		assertEquals(5, e6.getOrdinal());
		assertTrue(e6.getDataKind().isEnumValue());
		assertEquals(3, e6.getDataEnumType().size());

		//TODO test map
		
	}

    @Test
	public void testLanguageKitDefinition() {
		DynamicLanguageKit lk = new DynamicLanguageKit();
		lk.setURI("http://lang.whole.org/DynamicImpl");
		lk.setNamespace("org.whole.lang.reflect");
		lk.setName("DynamicImp");
		FeatureDescriptorEnum fds = lk.getFeatureDescriptorEnum();
		fds.addFeatureDescriptors(
				"value", "type", "name", "parameters", "body", "initializer",
				"exp", "exp1", "exp2", "condition", "trueBody", "falseBody",
				"arguments", "updater");

		EntityDescriptorEnum eds = lk.getEntityDescriptorEnum();

		final EntityDescriptor<?> ExpressionDesc = eds.addSimpleEntity("Expression", "Expression", true);
		final EntityDescriptor<?> StatementDesc = eds.addSimpleEntity("Statement", "Statement", true);

		EntityDescriptor<?> bs = eds.addCompositeEntity("BlockStatement", "BlockStatement", false, true, false);
		bs.withFeature(CommonsFeatureDescriptorEnum.composite_element, StatementDesc.getOrdinal());

		EntityDescriptor<?> ifs = eds.addSimpleEntity("IfStatement", "IfStatement", false)
			.withFeature(fds.valueOf("condition"), ExpressionDesc.getOrdinal())
			.withFeature(fds.valueOf("trueBody"), StatementDesc.getOrdinal());
		
		EntityDescriptor<?> ifes = eds.addSimpleEntity("IfElseStatement", "IfElseStatement", false)
			.withFeature(fds.valueOf("condition"), ExpressionDesc.getOrdinal())
			.withFeature(fds.valueOf("trueBody"), StatementDesc.getOrdinal())
			.withFeature(fds.valueOf("falseBody"), StatementDesc.getOrdinal());
		
		EntityDescriptor<?> ws = eds.addSimpleEntity("WhileStatement", "WhileStatement", false)
			.withFeature(fds.valueOf("condition"), ExpressionDesc.getOrdinal())
			.withFeature(fds.valueOf("body"), StatementDesc.getOrdinal());
		
		EntityDescriptor<?> es = eds.addSimpleEntity("ExpressionStatement", "ExpressionStatement", false)
			.withFeature(fds.valueOf("exp"), ExpressionDesc.getOrdinal());

		StatementDesc.setLanguageSubtypes(true,
				bs.getOrdinal(), ifs.getOrdinal(), ifes.getOrdinal(), ws.getOrdinal(), es.getOrdinal());

		final EntityDescriptor<?> LiteralDesc = eds.addSimpleEntity("Literal", "Literal", true);
		LiteralDesc.setLanguageSubtypes(true,
				eds.addDataEntity("BooleanLiteral", "BooleanLiteral", false, Boolean.TYPE).getOrdinal(),
				eds.addDataEntity("IntLiteral", "IntLiteral", false, Integer.TYPE).getOrdinal(),
				eds.addDataEntity("StringLiteral", "StringLiteral", false, String.class).getOrdinal());

		EntityDescriptor<?> ne = eds.addDataEntity("Name", "Name", false, String.class);
		eds.addSimpleEntity("AssignmentExpression", "AssignmentExpression", false)
			.withFeature(fds.valueOf("name"), ne.getOrdinal())
			.withFeature(fds.valueOf("exp"), ExpressionDesc.getOrdinal());

		for (String edName : new String[] {
				"And", "Or",
				"Addition", "Division", "Multiplication", "Remainder", "Subtraction",
				"Equals", "GreaterOrEquals", "GreaterThan", "LessOrEquals", "LessThan", "NotEquals"}) {
			eds.addSimpleEntity(edName, edName, false)
				.withFeature(fds.valueOf("exp1"), ExpressionDesc.getOrdinal())
				.withFeature(fds.valueOf("exp1"), ExpressionDesc.getOrdinal());
		}

		//TODO configure entity registry

		ReflectionFactory.deploy(DynamicLanguageKit.getDeployer(lk));
		
		assertEquals(lk, ReflectionFactory.getLanguageKit(lk.getURI()));

		
		IEntityFactory ef = GenericEntityFactory.instance;
		IEntity p = ef.create(
				eds.valueOf("WhileStatement"),
				ef.create(eds.valueOf("GreaterThan"),
						ef.create(eds.valueOf("Name"), "n"),
						ef.create(eds.valueOf("IntLiteral"), 0)),
						ef.create(eds.valueOf("ExpressionStatement"),
						ef.create(eds.valueOf("AssignmentExpression"),
								ef.create(eds.valueOf("Name"), "n"),
								ef.create(eds.valueOf("Subtraction"),
										ef.create(eds.valueOf("Name"), "n"),
										ef.create(eds.valueOf("IntLiteral"), 1)))));

		assertEquals(lk, p.wGetLanguageKit());
	}

    @Test
	public void testTupleDefinition() {
		DynamicLanguageKit lk = new DynamicLanguageKit();
		lk.setURI("http://lang.whole.org/QueriesTupleResultLanguage");
		lk.setNamespace("org.whole.lang.reflect");
		lk.setName("QueriesTupleResultLanguage");
		EntityDescriptorEnum eds = lk.getEntityDescriptorEnum();
		EntityDescriptor<?> any = eds.addSimpleEntity("Any", "Any", true);
		EntityDescriptor<?> gtd = eds.addCompositeEntity("GenericTuple", "GenericTuple", false, true, false);
		gtd.withFeature(CommonsFeatureDescriptorEnum.composite_element, any.getOrdinal());
		eds.setAssignableFromAll(true, any.getOrdinal());
		
		ReflectionFactory.deploy(DynamicLanguageKit.getDeployer(lk));
		assertEquals(lk, ReflectionFactory.getLanguageKit(lk.getURI()));

		IEntityFactory ef = GenericEntityFactory.instance;
		IEntity p = ef.create(eds.valueOf("GenericTuple"));

		IEntity[] e = new IEntity[2];

		p.wAdd(e[0] = QueriesEntityFactory.instance.createSelfStep());
		p.wAdd(e[1] = GrammarsEntityFactory.instance.createNonTerminal("myNt"));

		assertEquals(2, p.wSize());
		assertSame(e[0], p.wGet(0));
		assertSame(e[1], p.wGet(1));
	}

    @Test
	public void testModelsInterpreter() {
		Model model;
		try {
			model = (Model) XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/queries/QueriesModel.xwl"));
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

		String URI = "http://my/uri/for/queries/lang";
		
		model.getUri().setValue(URI);

		ILanguageKit qlk = ReflectionFactory.getLanguageKit("http://lang.whole.org/Queries");
		EntityDescriptorEnum qedenum = qlk.getEntityDescriptorEnum();
		FeatureDescriptorEnum qfdenum = qlk.getFeatureDescriptorEnum();

		InterpreterOperation.interpret(model);
		
		ILanguageKit lk = ReflectionFactory.getLanguageKit(URI);
		assertNotNull(lk);
		assertNotSame(qlk, lk);

		assertNotNull(lk.getMetaModelTemplate());
		IEntity metaModel = lk.getMetaModel();
		IEntity normalizedModel = NormalizerOperation.normalize(model);
		assertTrue(Matcher.match(normalizedModel, metaModel));
		metaModel = lk.getMetaModelTemplate().create();
		assertTrue(Matcher.match(normalizedModel, metaModel));

		EntityDescriptorEnum edenum = lk.getEntityDescriptorEnum();
		FeatureDescriptorEnum fdenum = lk.getFeatureDescriptorEnum();

		assertFalse(qfdenum.equals(fdenum));
		assertEquals(qfdenum.size(), fdenum.size());
		for (FeatureDescriptor qfd : qfdenum) {
			assertEquals(qfd.getOrdinal(), fdenum.valueOf(qfd.getName()).getOrdinal());
		}

		assertFalse(qedenum.equals(edenum));
		assertEquals(qedenum.size(), edenum.size());
		for (EntityDescriptor<?> qed : qedenum) {
			EntityDescriptor<?> ed = edenum.valueOf(qed.getName());
			
			assertEquals(qed.getOrdinal(), ed.getOrdinal());
			assertEquals(qed.getEntityKind(), ed.getEntityKind());
			assertEquals(qed.isAbstract(), ed.isAbstract());
			assertEquals(qed.isRelationship(), ed.isRelationship());

			switch (qed.getEntityKind()) {
			case SIMPLE:
				assertEquals(qed.featureSize(), ed.featureSize());
				for (int i=0, size=qed.featureSize(); i<size; i++) {
					FeatureDescriptor qfd = qed.getEntityFeatureDescriptor(i);
					FeatureDescriptor fd = ed.getEntityFeatureDescriptor(i);
					assertEquals(qfd.getName(), fd.getName());
					assertEquals(qfd.getImplName(), fd.getImplName());
					assertEquals(qfd.getOrdinal(), fd.getOrdinal());
					assertEquals(qfd.isDerived(), fd.isDerived());
					assertEquals(qfd.isId(), fd.isId());
					assertEquals(qfd.isOptional(), fd.isOptional());
					assertEquals(qfd.isReference(), fd.isReference());
					assertEquals(qfd.isShared(), fd.isShared());
					assertEquals(qfd.isToMany(), fd.isToMany());
					if (qfd.getOppositeFeatureDescriptor() != null)
						assertEquals(
								qfd.getOppositeFeatureDescriptor().getName(),
								fd.getOppositeFeatureDescriptor().getName());
				}
				break;
			case COMPOSITE:
				assertEquals(qed.getCompositeKind(), ed.getCompositeKind());
				FeatureDescriptor qfd = qed.getEntityFeatureDescriptor(0);
				FeatureDescriptor fd = ed.getEntityFeatureDescriptor(0);
				assertEquals(qfd.isDerived(), fd.isDerived());
				assertEquals(qfd.isReference(), fd.isReference());
				assertEquals(qfd.isShared(), fd.isShared());
				break;
			case DATA:
				assertEquals(qed.getDataKind(), ed.getDataKind());
				if (qed.getDataKind().isEnumValue()) {
					assertEquals(qed.getDataEnumType().size(), ed.getDataEnumType().size());
					for (int i=0; i<qed.getDataEnumType().size(); i++)
						assertEquals(qed.getDataEnumType().valueOf(i).getName(), ed.getDataEnumType().valueOf(i).getName());
				} else
					assertEquals(qed.getDataType(), ed.getDataType());
				break;
			}
		}
	}
}
