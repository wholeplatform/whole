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
package org.whole.lang.commands;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.test.SlowTests;

public class HistoryInvariantsTest {
	Model model;
    IHistoryManager history;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }
    @Before
    public void setUp() throws Exception {
        model = new XmlModel().create();
        history = ReflectionFactory.getHistoryManager(model);
        history.setHistoryEnabled(true);
    }

    private void performChanges(Model model) {
		model.getName().setValue("my new model name");
		model.getDeclarations().wRemove(0);
		SimpleEntity se = ModelsEntityFactory.instance.createSimpleEntity();
		model.getDeclarations().wAdd(se);
		se.getName().setValue("my new simple name");
	}

    private SimpleEntity createSimpleEntity() {
		SimpleEntity se = ModelsEntityFactory.instance.createSimpleEntity();
		ReflectionFactory.getHistoryManager(se).setHistoryEnabled(true);
		se.getName().setValue("my new simple name");
		se.getTypes().wAdd(ModelsEntityFactory.instance.createSimpleName("T1"));
		se.getFeatures().wAdd(ModelsEntityFactory.instance.createFeature());
		return se;
	}

    @Test
	public void testSameHistory() {
    	performChanges(model);
    	Assert.assertNotSame(history, ReflectionFactory.getHistoryManager(model));
    	Assert.assertTrue(history.equals(ReflectionFactory.getHistoryManager(model)));

    }

    @Test
	public void testMergeHistory() {
    	performChanges(model);
    	int size1 = history.getUndoSize();
    	SimpleEntity se = createSimpleEntity();
    	Assert.assertEquals(size1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	Assert.assertEquals(size1+1, history.getUndoSize());

    	size1 = history.getUndoSize();
    	se = createSimpleEntity();
    	se.wGetModel().getCompoundModel().setHistoryManager(history, false);
    	Assert.assertEquals(size1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	Assert.assertEquals(size1+1, history.getUndoSize());

    	size1 = history.getUndoSize();
    	se = createSimpleEntity();
    	se.wGetModel().getCompoundModel().setHistoryManager(history, true);
    	Assert.assertEquals(size1+1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	Assert.assertEquals(size1+2, history.getUndoSize());

    	size1 = history.getUndoSize();
    	se = createSimpleEntity();
    	history.mergeHistory(ReflectionFactory.getHistoryManager(se));
    	Assert.assertEquals(size1+1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	Assert.assertEquals(size1+2, history.getUndoSize());

    }

    @Test
	public void testHistoryDefaultHistoryEnablement() {
    	IEntity model = new XmlModel().create();
    	IHistoryManager history = ReflectionFactory.getHistoryManager(model);
        Assert.assertFalse(history.isHistoryEnabled());
        Assert.assertEquals(0, history.getUndoSize());
        Assert.assertTrue(history.getUndoCommands().isEmpty());
    }

    @Test
	public void testModelNullCommands() {
        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	Assert.assertEquals(NullCommand.instance, ((InternalIEntity) e).wGetBindingCommand());
        	Assert.assertEquals(NullCommand.instance, ((InternalIEntity) e).wGetLastCommand());
        }
    }

    @Test
	public void testAscendingChangeIndex() {
    	performChanges(model);
        List<ICommand> changes = history.getUndoCommands();

        int prevTime = 0;
        for (int i=0; i<changes.size(); i++) {
        	int execTime = changes.get(i).getExecutionTime();
        	Assert.assertTrue(prevTime <= execTime);
        	prevTime = execTime;
        }
    }

    @Test
	public void testModelCommands() {
        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	Assert.assertTrue(cmd.getKind() == CommandKind.NULL);
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	Assert.assertTrue(cmd.getKind() == CommandKind.NULL);
        }

        performChanges(model);
        List<ICommand> changes = history.getUndoCommands();

        i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	if (cmd.getKind() != CommandKind.NULL)
        		Assert.assertTrue(changes.contains(cmd));
        	
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	if (cmd.getKind() != CommandKind.NULL)
        		Assert.assertTrue(changes.contains(cmd));
        }
    }

    @Category(SlowTests.class)
    @Test
	public void testModelCloneHistory() {
        performChanges(model);
        IEntity model2 = EntityUtils.clone(model);

        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model2);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	Assert.assertTrue(cmd.getKind() == CommandKind.NULL);
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	if (cmd.getKind() != CommandKind.NULL)
        	Assert.assertTrue(cmd.getKind() == CommandKind.NULL);
        }

        Assert.assertTrue(Matcher.match(model2, model));
    }

    @Test
	public void testClearHistory() {
        performChanges(model);
        IEntity model2 = EntityUtils.clone(model);

        history.clearHistory();
        Assert.assertTrue(history.getUndoCommands().isEmpty());

        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	Assert.assertTrue(cmd.getKind() == CommandKind.NULL);
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	Assert.assertTrue(cmd.getKind() == CommandKind.NULL);
        }

        Assert.assertTrue(Matcher.match(model2, model));
    }

    @Test
	public void testTrimHistory() {
        performChanges(model);
        String oldValue = model.getName().getValue();
        model.getName().setValue("new name");
    	Assert.assertTrue(history.getUndoSize() > 1);
    	
    	history.trimHistory(1);
    	Assert.assertEquals(1, history.getUndoSize());
    	history.undo();
    	Assert.assertEquals(oldValue, model.getName().getValue());
    	Assert.assertEquals(0, history.getUndoSize());
    }

    @Test
	public void testHistoryCapacity() {
        performChanges(model);
        model.getName().setValue("new name");
        
    	Assert.assertTrue(history.getUndoSize() > 2);
    	history.setHistoryCapacity(2);
    	Assert.assertEquals(2, history.getUndoSize());
    	
        performChanges(model);
        model.getName().setValue("new name 3");
    	Assert.assertEquals(2, history.getUndoSize());

    	history.setHistoryCapacity(3);
    	Assert.assertEquals(2, history.getUndoSize());
        model.getName().setValue("new name 4");
    	Assert.assertEquals(3, history.getUndoSize());
    }

    // The entity local history of binding commands is ordered
    // invariant: for each cmd, cmd.prevCommand.executionTime <= cmd.executionTime
    @Test
	public void testPrevCommandExecutionTimeOrder() {
    	performChanges(model);

        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	while (cmd.getKind() != CommandKind.NULL) {
            	ICommand cmd1 = cmd.getPrevCommand();
        		Assert.assertTrue(cmd1.getExecutionTime() <= cmd.getExecutionTime());
        		cmd = cmd1;
        	}
        }
    }

    @Test
	public void testLastCommand() {
    	IEntity e1 = model.getName();
    	e1.wSetValue("newLangName");    	
    	ICommand c1 = ((InternalIEntity) e1).wGetLastCommand();

        List<ICommand> changes = history.getUndoCommands();
        ICommand lastCmd = (ICommand) changes.get(changes.size()-1);

        Assert.assertSame(lastCmd, c1);
    }

    @Test
	public void testChangeOrder() {
    	IEntity e1 = model.getName();
    	IEntity e2 = model.getNamespace();
    	
    	e1.wSetValue("newLangName");
    	e2.wSetValue("newNamespace");
    	
    	Assert.assertTrue(((InternalIEntity) e1).wGetLastCommand().getExecutionTime() <= ((InternalIEntity) e2).wGetLastCommand().getExecutionTime());
    }

    @Test
	public void testUndo() {
        InternalIEntity e1 = (InternalIEntity) model.getName();

    	e1.wSetValue("newLangName1");
    	ICommand c1 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName2");
    	ICommand c2 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName3");
    	
    	Assert.assertNotSame(c1, e1.wGetLastCommand());
    	
    	history.undo();
    	Assert.assertEquals(e1.wStringValue(), "newLangName2");
    	Assert.assertEquals(e1.wGetLastCommand(), c2);

    	history.undo();
    	Assert.assertEquals(e1.wStringValue(), "newLangName1");
    	Assert.assertEquals(e1.wGetLastCommand(), c1);
    }

    @Test
	public void testUndoRedo() {
        InternalIEntity e1 = (InternalIEntity) model.getName();

    	e1.wSetValue("newLangName1");
    	ICommand c1 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName2");
    	ICommand c2 = e1.wGetLastCommand();

    	history.undo();
    	Assert.assertEquals(e1.wStringValue(), "newLangName1");
    	Assert.assertEquals(e1.wGetLastCommand(), c1);
    	history.redo();
    	Assert.assertEquals(e1.wStringValue(), "newLangName2");
    	Assert.assertEquals(e1.wGetLastCommand(), c2);
    }

    @Test
	public void testUndoSet() {
        InternalIEntity e1 = (InternalIEntity) model.getName();

    	e1.wSetValue("newLangName1");
    	ICommand c1 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName2");
    	ICommand c2 = e1.wGetLastCommand();
    	Assert.assertNotSame(c2, c1);

    	history.undo();
    	e1.wSetValue("newLangName3");
    	Assert.assertSame(e1.wGetLastCommand().getPrevCommand(), c1);
    }

    @Test
	public void testUndoRedoAll() {
    	IEntity model2 = EntityUtils.clone(model);
        performChanges(model);
    	IEntity model3 = EntityUtils.clone(model);

        while (history.getUndoSize() > 0)
        	history.undo();
        Assert.assertTrue(history.getUndoCommands().isEmpty());

        Assert.assertTrue(Matcher.match(model2, model));

        while (history.getRedoSize() > 0)
        	history.redo();
        Assert.assertTrue(history.getRedoCommands().isEmpty());

        Assert.assertTrue(Matcher.match(model3, model));
    }
}
