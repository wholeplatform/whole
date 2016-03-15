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
package org.whole.lang.workflow.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commands.NullCommand;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.workflows.builders.IWorkflowsBuilder;
import org.whole.lang.workflows.reflect.WorkflowsLanguageKit;
import org.whole.test.SlowTests;

/**
 * @author Riccardo Solmi
 */
@Category(SlowTests.class)
public class BindingCommandTest {

	@BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Test
	public void testBindingCommand() {
		IEntity program = new ExampleTest().create();

		IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
		i.reset(program);
		for (IEntity e : i)
			if (((InternalIEntity) e).wGetBindingCommand() != NullCommand.instance)
				Assert.fail();

		program = EntityUtils.clone(program);
		i = IteratorFactory.<IEntity>descendantOrSelfIterator();
		i.reset(program);
		for (IEntity e : i)
			if (((InternalIEntity) e).wGetBindingCommand() != NullCommand.instance)
				Assert.fail();
	}

	public static class ExampleTest extends AbstractTemplateFactory<IEntity> {
		public void apply(IBuilderOperation op) {
			IWorkflowsBuilder b0 = (IWorkflowsBuilder) op.wGetBuilder(WorkflowsLanguageKit.URI);
			ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
			b0.Workflow_();
			b0.Name("Workflow");
			b0.Text("Workflow");
			cb.Resolver();
			cb.Resolver();
			b0.Sequence_();
			b0.Text("Sequence");
			b0.FlowObjects_(3);
			b0.Task_();
			b0.Text("primo task");
			b0._Task();
			b0.Task_();
			b0.Text("second task");
			b0._Task();
			b0.Task_();
			b0.Text("third task");
			b0._Task();
			b0._FlowObjects();
			b0._Sequence();
			b0._Workflow();
		}
	}
}
