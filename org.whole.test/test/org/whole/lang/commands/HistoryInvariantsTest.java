/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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

import junit.framework.TestCase;

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

public class HistoryInvariantsTest extends TestCase {
	Model model;
    IHistoryManager history;

    protected void setUp() throws Exception {
        ReflectionFactory.deployWholePlatform();
//TODO        ReflectionFactory.deploy(TestLanguagesDeployer.class);

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

    public void testSameHistory() {
    	performChanges(model);
    	assertNotSame(history, ReflectionFactory.getHistoryManager(model));
    	assertTrue(history.equals(ReflectionFactory.getHistoryManager(model)));

    }

    public void testMergeHistory() {
    	performChanges(model);
    	int size1 = history.getUndoSize();
    	SimpleEntity se = createSimpleEntity();
    	assertEquals(size1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	assertEquals(size1+1, history.getUndoSize());

    	size1 = history.getUndoSize();
    	se = createSimpleEntity();
    	se.wGetModel().getCompoundModel().setHistoryManager(history, false);
    	assertEquals(size1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	assertEquals(size1+1, history.getUndoSize());

    	size1 = history.getUndoSize();
    	se = createSimpleEntity();
    	se.wGetModel().getCompoundModel().setHistoryManager(history, true);
    	assertEquals(size1+1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	assertEquals(size1+2, history.getUndoSize());

    	size1 = history.getUndoSize();
    	se = createSimpleEntity();
    	history.mergeHistory(ReflectionFactory.getHistoryManager(se));
    	assertEquals(size1+1, history.getUndoSize());
    	model.getDeclarations().wAdd(se);
    	assertEquals(size1+2, history.getUndoSize());

    }

    public void testHistoryDefaultHistoryEnablement() {
    	IEntity model = new XmlModel().create();
    	IHistoryManager history = ReflectionFactory.getHistoryManager(model);
        assertFalse(history.isHistoryEnabled());
        assertEquals(0, history.getUndoSize());
        assertTrue(history.getUndoCommands().isEmpty());
    }

    public void testModelNullCommands() {
        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	assertEquals(NullCommand.instance, ((InternalIEntity) e).wGetBindingCommand());
        	assertEquals(NullCommand.instance, ((InternalIEntity) e).wGetLastCommand());
        }
    }

    public void testAscendingChangeIndex() {
    	performChanges(model);
        List<ICommand> changes = history.getUndoCommands();

        int prevTime = 0;
        for (int i=0; i<changes.size(); i++) {
        	int execTime = changes.get(i).getExecutionTime();
        	assertTrue(prevTime <= execTime);
        	prevTime = execTime;
        }
    }

    public void testModelCommands() {
        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	assertTrue(cmd.getKind() == CommandKind.NULL);
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	assertTrue(cmd.getKind() == CommandKind.NULL);
        }

        performChanges(model);
        List<ICommand> changes = history.getUndoCommands();

        i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	if (cmd.getKind() != CommandKind.NULL)
        		assertTrue(changes.contains(cmd));
        	
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	if (cmd.getKind() != CommandKind.NULL)
        		assertTrue(changes.contains(cmd));
        }
    }

    public void testModelCloneHistory() {
        performChanges(model);
        IEntity model2 = EntityUtils.clone(model);

        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model2);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	assertTrue(cmd.getKind() == CommandKind.NULL);
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	if (cmd.getKind() != CommandKind.NULL)
        	assertTrue(cmd.getKind() == CommandKind.NULL);
        }

        assertTrue(Matcher.match(model2, model));
    }

    public void testClearHistory() {
        performChanges(model);
        IEntity model2 = EntityUtils.clone(model);

        history.clearHistory();
        assertTrue(history.getUndoCommands().isEmpty());

        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	assertTrue(cmd.getKind() == CommandKind.NULL);
        	cmd = ((InternalIEntity) e).wGetLastCommand();
        	assertTrue(cmd.getKind() == CommandKind.NULL);
        }

        assertTrue(Matcher.match(model2, model));
    }

    public void testTrimHistory() {
        performChanges(model);
        String oldValue = model.getName().getValue();
        model.getName().setValue("new name");
    	assertTrue(history.getUndoSize() > 1);
    	
    	history.trimHistory(1);
    	assertEquals(1, history.getUndoSize());
    	history.undo();
    	assertEquals(oldValue, model.getName().getValue());
    	assertEquals(0, history.getUndoSize());
    }

    public void testHistoryCapacity() {
        performChanges(model);
        model.getName().setValue("new name");
        
    	assertTrue(history.getUndoSize() > 2);
    	history.setHistoryCapacity(2);
    	assertEquals(2, history.getUndoSize());
    	
        performChanges(model);
        model.getName().setValue("new name 3");
    	assertEquals(2, history.getUndoSize());

    	history.setHistoryCapacity(3);
    	assertEquals(2, history.getUndoSize());
        model.getName().setValue("new name 4");
    	assertEquals(3, history.getUndoSize());
    }

    // The entity local history of binding commands is ordered
    // invariant: for each cmd, cmd.prevCommand.executionTime <= cmd.executionTime
    public void testPrevCommandExecutionTimeOrder() {
    	performChanges(model);

        IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
        i.reset(model);
		for (IEntity e : i) {
        	ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
        	while (cmd.getKind() != CommandKind.NULL) {
            	ICommand cmd1 = cmd.getPrevCommand();
        		assertTrue(cmd1.getExecutionTime() <= cmd.getExecutionTime());
        		cmd = cmd1;
        	}
        }
    }

    public void testLastCommand() {
    	IEntity e1 = model.getName();
    	e1.wSetValue("newLangName");    	
    	ICommand c1 = ((InternalIEntity) e1).wGetLastCommand();

        List<ICommand> changes = history.getUndoCommands();
        ICommand lastCmd = (ICommand) changes.get(changes.size()-1);

        assertSame(lastCmd, c1);
    }

    public void testChangeOrder() {
    	IEntity e1 = model.getName();
    	IEntity e2 = model.getNamespace();
    	
    	e1.wSetValue("newLangName");
    	e2.wSetValue("newNamespace");
    	
    	assertTrue(((InternalIEntity) e1).wGetLastCommand().getExecutionTime() <= ((InternalIEntity) e2).wGetLastCommand().getExecutionTime());
    }

    public void testUndo() {
        InternalIEntity e1 = (InternalIEntity) model.getName();

    	e1.wSetValue("newLangName1");
    	ICommand c1 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName2");
    	ICommand c2 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName3");
    	
    	assertNotSame(c1, e1.wGetLastCommand());
    	
    	history.undo();
    	assertEquals(e1.wStringValue(), "newLangName2");
    	assertEquals(e1.wGetLastCommand(), c2);

    	history.undo();
    	assertEquals(e1.wStringValue(), "newLangName1");
    	assertEquals(e1.wGetLastCommand(), c1);
    }

    public void testUndoRedo() {
        InternalIEntity e1 = (InternalIEntity) model.getName();

    	e1.wSetValue("newLangName1");
    	ICommand c1 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName2");
    	ICommand c2 = e1.wGetLastCommand();

    	history.undo();
    	assertEquals(e1.wStringValue(), "newLangName1");
    	assertEquals(e1.wGetLastCommand(), c1);
    	history.redo();
    	assertEquals(e1.wStringValue(), "newLangName2");
    	assertEquals(e1.wGetLastCommand(), c2);
    }

    public void testUndoSet() {
        InternalIEntity e1 = (InternalIEntity) model.getName();

    	e1.wSetValue("newLangName1");
    	ICommand c1 = e1.wGetLastCommand();
    	e1.wSetValue("newLangName2");
    	ICommand c2 = e1.wGetLastCommand();
    	assertNotSame(c2, c1);

    	history.undo();
    	e1.wSetValue("newLangName3");
    	assertSame(e1.wGetLastCommand().getPrevCommand(), c1);
    }

    public void testUndoRedoAll() {
    	IEntity model2 = EntityUtils.clone(model);
        performChanges(model);
    	IEntity model3 = EntityUtils.clone(model);

        while (history.getUndoSize() > 0)
        	history.undo();
        assertTrue(history.getUndoCommands().isEmpty());

        assertTrue(Matcher.match(model2, model));

        while (history.getRedoSize() > 0)
        	history.redo();
        assertTrue(history.getRedoCommands().isEmpty());

        assertTrue(Matcher.match(model3, model));
    }
}
