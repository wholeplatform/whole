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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.factories.GenericEntityFactory;
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
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable<IEntity> variableExecutable = f.createFilter(f.createDescendantOrSelf(), f.createIsVariable());
		variableExecutable.reset(entity);
		IExecutable<IEntity> newVariableExecutable = f.createFilter(f.createDescendantOrSelf(), f.createIsVariable());
		newVariableExecutable.reset(newEntity);
		
		for (IEntity e1 = variableExecutable.evaluateNext(), e2 = newVariableExecutable.evaluateNext(); e1 != null;
				e1 = variableExecutable.evaluateNext(), e2 = newVariableExecutable.evaluateNext()) {
			assertTrue(e2 != null);

			Variable variable = (Variable) e1.wGetAdaptee(false);
			Variable newVariable = (Variable) e2.wGetAdaptee(false);

			EntityDescriptor<?> ed = variable.getVarType().getValue();
			EntityDescriptor<?> newEd = newVariable.getVarType().getValue();
			assertEquals(ed, newEd);

			String name = variable.getVarName().getValue();
			String newName = newVariable.getVarName().getValue();
			assertEquals(name, newName);

			IEntity replacement = GenericEntityFactory.instance.create(ed);
			variableExecutable.set(replacement);
			newVariableExecutable.set(EntityUtils.clone(replacement));
		}

		assertTrue(Matcher.match(entity, newEntity));
	}
}
