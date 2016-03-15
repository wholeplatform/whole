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
package org.whole.lang.lifecycle;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.commands.ICommand;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.Model;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class LifecycleAPITest {
	Model model;
	IHistoryManager history;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
		model = new XmlModel().create();
		history = ReflectionFactory.getHistoryManager(model);
		history.setHistoryEnabled(true);
	}

    @Test
    public void testUndoSize() {
		assertEquals(0, history.getUndoSize());
		model.getName().wSetValue("newLangName");
		assertEquals(1, history.getUndoSize());
		model.getNamespace().wSetValue("org.whole.lang");
		assertEquals(2, history.getUndoSize());
		model.getName().wSetValue("newerLangName");
		assertEquals(3, history.getUndoSize());
		model.getDeclarations().wRemove(1);
		assertEquals(4, history.getUndoSize());
		model.setName(ModelsEntityFactory.instance.createSimpleName("new data"));
		assertEquals(5, history.getUndoSize());
		model.getDeclarations().wAdd(ModelsEntityFactory.instance.createDataEntity());
		assertEquals(6, history.getUndoSize());
		model.getDeclarations().wSet(2, ModelsEntityFactory.instance.createDataEntity());
		assertEquals(7, history.getUndoSize());
		model.getDeclarations().wAdd(3, ModelsEntityFactory.instance.createDataEntity());
		assertEquals(8, history.getUndoSize());
		model.wSet(model.getName(), ModelsEntityFactory.instance.createSimpleName("new name"));
		assertEquals(9, history.getUndoSize());
	}

    @Test
    public void testUndoCommands() {
		IEntity id = model.wGet(0);
		id.wSetValue("newLangName");

		ICommand lastCommand = ((InternalIEntity) id).wGetLastCommand();
		List<ICommand> changes = history.getUndoCommands();
		ICommand command = changes.get(changes.size()-1);
		assertSame(lastCommand, command);
		assertEquals(id, command.getSource());
		assertEquals("newLangName", command.getNewObject());
	}

    @Test
    public void testUndo() {
		IEntity id = model.wGet(0);
		String idVal = id.wStringValue();
		id.wSetValue("newLangName");

		assertEquals(1, history.getUndoSize());
		assertEquals("newLangName", model.wGet(0).wStringValue());

		history.undo();

		assertEquals(0, history.getUndoSize());
		assertEquals(idVal, model.wGet(0).wStringValue());
	}

    @Test
    public void testEnablement() {
		assertTrue(history.isHistoryEnabled());
		model.getName().setValue("value 1");
		history.setHistoryEnabled(true);
		model.getName().setValue("value 2");
		assertEquals(2, history.getUndoSize());

		history.setHistoryEnabled(false);
		model.getName().setValue("value 3");
		model.getName().setValue("value 4");
		assertEquals(2, history.getUndoSize());

		history.setHistoryEnabled(true);
		assertEquals(0, history.getUndoSize());
		model.getName().setValue("value 5");
		assertEquals(1, history.getUndoSize());

	}

    @Test
    public void testStatus() {
		ITransaction transaction = ReflectionFactory.getTransaction(model);
		assertEquals(transaction.getStatus(), Status.NO_TRANSACTION);
	}

    @Test
    public void testIllegalStates() {
		ITransaction transaction = ReflectionFactory.getTransaction(model);

		try {
			transaction.commit();
			fail();
		} catch (IllegalStateException e) {
		}

		try {
			transaction.rollback();
			fail();
		} catch (IllegalStateException e) {
		}

		try {
			transaction.setRollbackOnly();
			fail();
		} catch (IllegalStateException e) {
		}
	}

    @Test
    public void testCommit() {
		ITransaction transaction = ReflectionFactory.getTransaction(model);

		IEntity e1 = model.wGet(0);
		IEntity e2 = model.wGet(3);

		transaction.begin();

		e1.wSetValue("newLangName");
		ICommand c1 = ((InternalIEntity) e1).wGetLastCommand();
		e2.wSetValue("newNamespace");
		ICommand c2 = ((InternalIEntity) e2).wGetLastCommand();

		String langName = e1.wStringValue();
		int size = history.getUndoSize();

		assertTrue(c1.getExecutionTime() <= c2.getExecutionTime());

		transaction.commit();

		assertEquals(e1.wStringValue(), langName);
		assertTrue(history.getUndoSize() < size);
		assertEquals(c1.getExecutionTime(), c2.getExecutionTime());
	}

    @Test
    public void testRollback() {
		ITransaction transaction = ReflectionFactory.getTransaction(model);

		IEntity e1 = model.wGet(0);
		IEntity e2 = model.wGet(3);

		transaction.begin();

		String langName = e1.wStringValue();
		int size = history.getUndoSize();

		e1.wSetValue("newLangName");
		e2.wSetValue("newNamespace");

		transaction.rollback();

		assertEquals(e1.wStringValue(), langName);
		assertEquals(history.getUndoSize(), size);
	}

    @Test
    public void testSetRollbackOnly() {
		ITransaction transaction = ReflectionFactory.getTransaction(model);

		IEntity e1 = model.wGet(0);
		IEntity e2 = model.wGet(3);

		transaction.begin();

		String langName = e1.wStringValue();
		int size = history.getUndoSize();

		e1.wSetValue("newLangName");
		e2.wSetValue("newNamespace");

		int size1 = history.getUndoSize();

		transaction.setRollbackOnly();

		assertEquals(e1.wStringValue(), "newLangName");
		assertEquals(history.getUndoSize(), size1);

		try {
			transaction.commit();
			fail();
		} catch (RollbackException e) {
		}

		assertEquals(e1.wStringValue(), langName);
		assertEquals(history.getUndoSize(), size);
	}

    @Test
    public void testUndoRedoTransactionBoundary() {
		ITransaction transaction = ReflectionFactory.getTransaction(model);

		IEntity e1 = model.wGet(0);
		IEntity e2 = model.wGet(3);

		String langName1 = e1.wStringValue();
		String rootName1 = e2.wStringValue();
		int size = history.getUndoSize();

		transaction.begin();

		e1.wSetValue("newLangName");
		e2.wSetValue("newNamespace");

		transaction.commit();

		String langName2 = e1.wStringValue();
		String rootName2 = e2.wStringValue();
		int size2 = history.getUndoSize();

		assertEquals(e1.wStringValue(), langName2);
		assertEquals(e2.wStringValue(), rootName2);

		history.undo();

		assertEquals(e1.wStringValue(), langName1);
		assertEquals(e2.wStringValue(), rootName1);
		assertEquals(history.getUndoSize(), size);

		history.redo();

		assertEquals(e1.wStringValue(), langName2);
		assertEquals(e2.wStringValue(), rootName2);
		assertEquals(history.getUndoSize(), size2);
	}

    @Test
    public void testMultipleModelsUndoSingleTransactionBoundary() {
		IEntity tuple = BindingManagerFactory.instance.createTuple(true);
		tuple.wGetModel().getCompoundModel().setHistoryManager(history, false);

		ITransaction transaction = ReflectionFactory.getTransaction(model);
		transaction.begin();

		IEntity declarations = model.getDeclarations();
		int declarationsSize = declarations.wSize();
		IEntity declaration = declarations.wGet(0);
		declarations.wRemove(0);
		tuple.wAdd(declaration);

		transaction.commit();

		history.undo();
		assertEquals(declarationsSize, declarations.wSize());
		assertEquals(0, tuple.wSize());
	}

    @Test
    public void testMultipleModelsUndoCrossTransactionBoundary() {
		IEntity tuple = BindingManagerFactory.instance.createTuple(true);
		//with a different history manger
		
		ITransaction transaction = ReflectionFactory.getTransaction(model);
		transaction.begin();

		IEntity declarations = model.getDeclarations();
		IEntity declaration = declarations.wGet(0);
		declarations.wRemove(0);
		tuple.wAdd(declaration);

		transaction.commit();

		try {
			history.undo();
			fail();
		} catch (Exception e) {
		}
	}
}
