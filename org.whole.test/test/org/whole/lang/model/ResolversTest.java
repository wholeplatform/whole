/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
import junit.framework.TestCase;

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
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.queries.model.Sequence;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ResolversTest extends TestCase {
	public static final QueriesEntityFactory qf = QueriesEntityFactory.instance;
	public static final ModelsEntityFactory mf = ModelsEntityFactory.instance;
	public static final JavaEntityFactory jf = JavaEntityFactory.instance;

	protected void setUp() throws Exception {
		super.setUp();

		ReflectionFactory.deployWholePlatform();
		}

	public void testSimpleEntitySetParent() {
		//TODO
	}

	//FIXME
	public void testCompositeEntitySetParent() {
		Sequence sequence = qf.createSequence(0);
		
		PathExpression pathExpression = createResolver(QueriesEntityDescriptorEnum.PathExpression);
		sequence.wAdd(pathExpression);
		assertTrue(EntityUtils.isResolver(pathExpression));
		
		pathExpression.wAdd(qf.createChildStep());
		assertTrue(EntityUtils.isResolver(pathExpression));

		Filter filter = qf.createFilter();
		filter.wSet(QueriesFeatureDescriptorEnum.expression, EntityUtils.clone(pathExpression));
		
		assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, filter.getExpression()));
	}

	public void testSimpleEntityResolverTighteningByFD() {
		ModelDeclaration modelDeclaration = createResolver(ModelsEntityDescriptorEnum.ModelDeclaration);
		ModelDeclarations modelDeclarations = mf.createModelDeclarations(modelDeclaration);

		modelDeclaration.wSet(ModelsFeatureDescriptorEnum.name, mf.createSimpleName("testName"));
		assertTrue(EntityUtils.isResolver(modelDeclaration));
		
		modelDeclaration.wSet(ModelsFeatureDescriptorEnum.componentType, mf.createSimpleName("testTypeName"));
		assertTrue(Matcher.matchImpl(ModelsEntityDescriptorEnum.CompositeEntity, modelDeclarations.wGet(0)));
	}

	public void testSimpleEntityResolverTighteningByIndex() {
		ModelDeclaration modelDeclaration = createResolver(ModelsEntityDescriptorEnum.ModelDeclaration);
		ModelDeclarations modelDeclarations = mf.createModelDeclarations(modelDeclaration);

		int index = ModelsEntityDescriptorEnum.ModelDeclaration.indexOf(ModelsFeatureDescriptorEnum.name);
		
		try {
			modelDeclaration.wSet(index, mf.createSimpleName("testName"));
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	//FIXME
	public void testCompositeEntityResolverTightening() {
		PathExpression pathExpression = createResolver(QueriesEntityDescriptorEnum.PathExpression);
		Sequence sequence = qf.createSequence(pathExpression);

		pathExpression.wAdd(qf.createChildStep());
		assertTrue(EntityUtils.isResolver(pathExpression));

		pathExpression.wAdd(qf.createPath());
		assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	//FIXME
	public void testCompositeEntityResolverTighteningAddByIndex() {
		PathExpression pathExpression = createResolver(QueriesEntityDescriptorEnum.PathExpression);
		Sequence sequence = qf.createSequence(pathExpression);

		pathExpression.wAdd(0, qf.createChildStep());
		assertTrue(EntityUtils.isResolver(pathExpression));

		pathExpression.wAdd(1, qf.createPath());
		assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	//FIXME
	public void testCompositeEntityResolverTighteningAddByIndexSparse() {
		PathExpression pathExpression = createResolver(QueriesEntityDescriptorEnum.PathExpression);
		Sequence sequence = qf.createSequence(pathExpression);

		pathExpression.wAdd(2, qf.createChildStep());
		assertTrue(EntityUtils.isResolver(pathExpression));

		pathExpression.wAdd(6, qf.createPath());
		assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	//FIXME
	public void testCompositeEntityResolverTighteningSetByIndex() {
		PathExpression pathExpression = createResolver(QueriesEntityDescriptorEnum.PathExpression);
		Sequence sequence = qf.createSequence(pathExpression);

		pathExpression.wSet(0, qf.createChildStep());
		assertTrue(EntityUtils.isResolver(pathExpression));

		pathExpression.wSet(1, qf.createPath());
		assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	//FIXME
	public void testCompositeEntityResolverTighteningSetByIndexSparse() {
		PathExpression pathExpression = createResolver(QueriesEntityDescriptorEnum.PathExpression);
		Sequence sequence = qf.createSequence(pathExpression);

		pathExpression.wSet(2, qf.createChildStep());
		assertTrue(EntityUtils.isResolver(pathExpression));

		pathExpression.wSet(6, qf.createPath());
		assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}

	public void testCompositeEntityResolverWithResolve() {
		PathExpression pathExpression = createResolver(QueriesEntityDescriptorEnum.PathExpression);
		Sequence sequence = qf.createSequence(pathExpression);

		pathExpression.wAdd(qf.createChildStep());
		assertTrue(EntityUtils.isResolver(pathExpression));

		pathExpression.wResolveWith(QueriesEntityDescriptorEnum.Sequence);
		assertTrue(Matcher.matchImpl(QueriesEntityDescriptorEnum.Sequence, sequence.wGet(0)));
	}


	public void testDataEntityResolverTightening() {
		Expression expression = createResolver(JavaEntityDescriptorEnum.Expression);
		Assignment assignment = jf.createAssignment();
		assignment.setRightHandSide(expression);

		expression.wSetValue(false);
		assertTrue(Matcher.matchImpl(JavaEntityDescriptorEnum.BooleanLiteral, assignment.getRightHandSide()));
	}

	//FIXME
	public void testAmbiguousDataEntityResolverTightening() {
		//workaround for JVM termination on StackOverflowError 
		fail();
		
		Expression expression = createResolver(JavaEntityDescriptorEnum.Expression);
		Assignment assignment = jf.createAssignment();
		assignment.setRightHandSide(expression);

		expression.wSetValue("stringLiteral");
		assertTrue(Matcher.matchImpl(JavaEntityDescriptorEnum.StringLiteral, assignment.getRightHandSide()));
	}
}
