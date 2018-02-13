package org.whole.lang.queries.util;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.BehaviorUtils;

public class BindVariablesInPathTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testBindVariablesInPathOK1() throws Exception {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		IEntity compilationUnits = BindVariablesInPathTemplateManager.instance().create("compilationUnit");
		PathExpression findClassDeclarationsOK1 = (PathExpression) BindVariablesInPathTemplateManager.instance().create("findClassDeclarationsOK1");
		IEntityIterator<IEntity> iterator;
		iterator = BehaviorUtils.<IEntity>compileAndLazyEvaluate(findClassDeclarationsOK1, compilationUnits, bindings);
		while (iterator.hasNext()) {
			assertNotNull(iterator.next());
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
    @Test
    public void testBindVariablesInPathOK2() throws Exception {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		IEntity compilationUnits = BindVariablesInPathTemplateManager.instance().create("compilationUnit");
		PathExpression findClassDeclarationsOK2 = (PathExpression) BindVariablesInPathTemplateManager.instance().create("findClassDeclarationsOK2");
		IEntityIterator<IEntity> iterator;
		iterator = BehaviorUtils.<IEntity>compileAndLazyEvaluate(findClassDeclarationsOK2, compilationUnits, bindings);
		while (iterator.hasNext()) {
			assertNotNull(iterator.next());
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
    @Test
    public void testBindVariablesInPathBAD1() throws Exception {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		IEntity compilationUnits = BindVariablesInPathTemplateManager.instance().create("compilationUnit");
		PathExpression findClassDeclarationsBAD1 = (PathExpression) BindVariablesInPathTemplateManager.instance().create("findClassDeclarationsBAD1");
		IEntityIterator<IEntity> iterator;
		iterator = BehaviorUtils.<IEntity>compileAndLazyEvaluate(findClassDeclarationsBAD1, compilationUnits, bindings);
		while (iterator.hasNext()) {
			assertNotNull(iterator.next());
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
    @Test
    public void testBindVariablesInPathBAD2() throws Exception {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		IEntity compilationUnits = BindVariablesInPathTemplateManager.instance().create("compilationUnit");
		PathExpression findClassDeclarationsBAD2 = (PathExpression) BindVariablesInPathTemplateManager.instance().create("findClassDeclarationsBAD2");
		IEntityIterator<IEntity> iterator;
		iterator = BehaviorUtils.<IEntity>compileAndLazyEvaluate(findClassDeclarationsBAD2, compilationUnits, bindings);
		while (iterator.hasNext()) {
			assertNotNull(iterator.next());
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
}
