package org.whole.lang.queries.util;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.executables.IExecutableClient;
import org.whole.lang.java.model.FieldDeclaration;
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
		IExecutableClient<IEntity> executable = BehaviorUtils.compileAndLazyEvaluate(findClassDeclarationsOK1, compilationUnits, bindings).client();
		while (executable.evaluateNext() != null) {
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
    @Test
    public void testBindVariablesInPathOK2() throws Exception {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		IEntity compilationUnits = BindVariablesInPathTemplateManager.instance().create("compilationUnit");
		PathExpression findClassDeclarationsOK2 = (PathExpression) BindVariablesInPathTemplateManager.instance().create("findClassDeclarationsOK2");
		IExecutableClient<FieldDeclaration> executable = BehaviorUtils.compileAndLazyEvaluate(findClassDeclarationsOK2, compilationUnits, bindings).client();
		while (executable.evaluateNext() != null) {
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
    @Test
    public void testBindVariablesInPathBAD1() throws Exception {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		IEntity compilationUnits = BindVariablesInPathTemplateManager.instance().create("compilationUnit");
		PathExpression findClassDeclarationsBAD1 = (PathExpression) BindVariablesInPathTemplateManager.instance().create("findClassDeclarationsBAD1");
		IExecutableClient<FieldDeclaration> executable = BehaviorUtils.compileAndLazyEvaluate(findClassDeclarationsBAD1, compilationUnits, bindings).client();
		while (executable.evaluateNext() != null) {
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
    @Test
    public void testBindVariablesInPathBAD2() throws Exception {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		IEntity compilationUnits = BindVariablesInPathTemplateManager.instance().create("compilationUnit");
		PathExpression findClassDeclarationsBAD2 = (PathExpression) BindVariablesInPathTemplateManager.instance().create("findClassDeclarationsBAD2");
		IExecutableClient<FieldDeclaration> executable = BehaviorUtils.compileAndLazyEvaluate(findClassDeclarationsBAD2, compilationUnits, bindings).client();
		while (executable.evaluateNext() != null) {
			assertTrue(bindings.wIsSet("methodDeclaration"));
		}
	}
}
