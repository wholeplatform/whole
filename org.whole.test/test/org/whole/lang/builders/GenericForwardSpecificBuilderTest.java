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
package org.whole.lang.builders;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Enrico Persiani
 */
public class GenericForwardSpecificBuilderTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testMultiLanguage() throws Exception {
		IEntity entity = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/queries/util/BindVariablesInPathTemplates.xwl"));
		ModelBuilderOperation mop = new ModelBuilderOperation();
		ModelTemplate template = new ModelTemplate(entity);
		template.apply(new GenericForwardSpecificBuilder(mop));
		IEntity newEntity = mop.wGetResult();

		// to match variables fill variables with defaults
		IEntityIterator<IEntity> variableIterator = IteratorFactory.<IEntity>descendantOrSelfMatcherIterator()
				.withPattern(GenericMatcherFactory.instance.isVariableMatcher());
		variableIterator.reset(entity);
		IEntityIterator<IEntity> newVariableIterator = IteratorFactory.<IEntity>descendantOrSelfMatcherIterator()
				.withPattern(GenericMatcherFactory.instance.isVariableMatcher());
		newVariableIterator.reset(newEntity);
		while (variableIterator.hasNext()) {
			assertTrue(newVariableIterator.hasNext());

			Variable variable = (Variable) variableIterator.next().wGetAdaptee(false);
			Variable newVariable = (Variable) newVariableIterator.next().wGetAdaptee(false);

			EntityDescriptor<?> ed = variable.getVarType().getValue();
			EntityDescriptor<?> newEd = newVariable.getVarType().getValue();
			assertEquals(ed, newEd);

			String name = variable.getVarName().getValue();
			String newName = newVariable.getVarName().getValue();
			assertEquals(name, newName);

			IEntity replacement = GenericEntityFactory.instance.create(ed);
			variableIterator.set(replacement);
			newVariableIterator.set(EntityUtils.clone(replacement));
		}

		assertTrue(Matcher.match(entity, newEntity));
	}
}
