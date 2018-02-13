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
package org.whole.lang.model;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.Assignment;
import org.whole.lang.java.model.Expression;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.ModelDeclaration;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.Filter;
import org.whole.lang.queries.model.Sequence;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.test.KnownFailingTests;

/**
 * @author Riccardo Solmi
 */
public class ResolversTest {
	public static final QueriesEntityFactory qf = QueriesEntityFactory.instance;
	public static final ModelsEntityFactory mf = ModelsEntityFactory.instance;
	public static final JavaEntityFactory jf = JavaEntityFactory.instance;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Test
	public void testSimpleEntitySetParent() {
		//TODO
	}

	@Test
	public void testCompositeEntitySetParent() {
		Sequence sequence = qf.createSequence(0);
		
		org.whole.lang.queries.model.Expression expression = createResolver(QueriesEntityDescriptorEnum.Expression);
		sequence.wAdd(expression);
		Assert.assertTrue(EntityUtils.isResolver(expression));
		
		expression.wAdd(qf.createChildStep());
		Assert.assertTrue(EntityUtils.isResolver(expression));

		Filter filter = qf.createFilter();
		filter.wSet(QueriesFeatureDescriptorEnum.expression, EntityUtils.clone(expression));
		
		Assert.assertTrue(Matcher.match(QueriesEntityDescriptorEnum.Expression, filter.getExpression()));
	}

	@Test
	public void testSimpleEntityResolverTighteningByFD() {
		ModelDeclaration modelDeclaration = createResolver(ModelsEntityDescriptorEnum.ModelDeclaration);
		ModelDeclarations modelDeclarations = mf.createModelDeclarations(modelDeclaration);

		modelDeclaration.wSet(ModelsFeatureDescriptorEnum.name, mf.createSimpleName("testName"));
		Assert.assertTrue(EntityUtils.isResolver(modelDeclaration));
		
		modelDeclaration.wSet(ModelsFeatureDescriptorEnum.componentType, mf.createSimpleName("testTypeName"));
		Assert.assertTrue(Matcher.matchImpl(ModelsEntityDescriptorEnum.CompositeEntity, modelDeclarations.wGet(0)));
	}

	@Test
	public void testSimpleEntityResolverTighteningByIndex() {
		ModelDeclaration modelDeclaration = createResolver(ModelsEntityDescriptorEnum.ModelDeclaration);
		ModelDeclarations modelDeclarations = mf.createModelDeclarations(modelDeclaration);

		int index = ModelsEntityDescriptorEnum.ModelDeclaration.indexOf(ModelsFeatureDescriptorEnum.name);
		
		try {
			modelDeclaration.wSet(index, mf.createSimpleName("testName"));
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testCompositeEntityResolverTightening() {
		org.whole.lang.queries.model.Expression expression = createResolver(QueriesEntityDescriptorEnum.Expression);
		Sequence sequence = qf.createSequence(expression);

		expression.wAdd(qf.createChildStep());
		Assert.assertTrue(EntityUtils.isResolver(expression));

		expression.wAdd(qf.createPath());
		Assert.assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testCompositeEntityResolverTighteningAddByIndex() {
		org.whole.lang.queries.model.Expression expression = createResolver(QueriesEntityDescriptorEnum.Expression);
		Sequence sequence = qf.createSequence(expression);

		expression.wAdd(0, qf.createChildStep());
		Assert.assertTrue(EntityUtils.isResolver(expression));

		expression.wAdd(1, qf.createPath());
		Assert.assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testCompositeEntityResolverTighteningAddByIndexSparse() {
		org.whole.lang.queries.model.Expression expression = createResolver(QueriesEntityDescriptorEnum.Expression);
		Sequence sequence = qf.createSequence(expression);

		expression.wAdd(2, qf.createChildStep());
		Assert.assertTrue(EntityUtils.isResolver(expression));

		expression.wAdd(6, qf.createPath());
		Assert.assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testCompositeEntityResolverTighteningSetByIndex() {
		org.whole.lang.queries.model.Expression expression = createResolver(QueriesEntityDescriptorEnum.Expression);
		Sequence sequence = qf.createSequence(expression);

		expression.wSet(0, qf.createChildStep());
		Assert.assertTrue(EntityUtils.isResolver(expression));

		expression.wSet(1, qf.createPath());
		Assert.assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testCompositeEntityResolverTighteningSetByIndexSparse() {
		org.whole.lang.queries.model.Expression expression = createResolver(QueriesEntityDescriptorEnum.Expression);
		Sequence sequence = qf.createSequence(expression);

		expression.wSet(2, qf.createChildStep());
		Assert.assertTrue(EntityUtils.isResolver(expression));

		expression.wSet(6, qf.createPath());
		Assert.assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	@Test
	public void testCompositeEntityResolverWithResolve() {
		org.whole.lang.queries.model.Expression expression = createResolver(QueriesEntityDescriptorEnum.Expression);
		Sequence sequence = qf.createSequence(expression);

		expression.wAdd(qf.createChildStep());
		Assert.assertTrue(EntityUtils.isResolver(expression));

		expression.wResolveWith(QueriesEntityDescriptorEnum.Sequence);
		Assert.assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}


	@Test
	public void testDataEntityResolverTightening() {
		Expression expression = createResolver(JavaEntityDescriptorEnum.Expression);
		Assignment assignment = jf.createAssignment();
		assignment.setRightHandSide(expression);

		expression.wSetValue(false);
		Assert.assertTrue(Matcher.matchImpl(JavaEntityDescriptorEnum.BooleanLiteral, assignment.getRightHandSide()));
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testAmbiguousDataEntityResolverTightening() {
		//workaround for JVM termination on StackOverflowError 
		Assert.fail();
		
		Expression expression = createResolver(JavaEntityDescriptorEnum.Expression);
		Assignment assignment = jf.createAssignment();
		assignment.setRightHandSide(expression);

		expression.wSetValue("stringLiteral");
		Assert.assertTrue(Matcher.matchImpl(JavaEntityDescriptorEnum.StringLiteral, assignment.getRightHandSide()));
	}
}
