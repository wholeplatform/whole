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
package org.whole.gen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.model.SameStageFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.operations.AbstractOperation;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.util.StringUtils;
import org.whole.lang.util.UniqueIdGenerator;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class JavaStoreBuilder extends CompilationUnitBuilder {
    public JavaStoreBuilder(JavaModelGenerator generator) {
        super(generator);
        cuList.remove(cu);
    }

    public void endStore(IVisitor v) {
	    MethodInvocation callExp = newFactoryInvocation(v, "makeRootEntity");
	    callExp.arguments().add(getExpression());
        builder().addStatement(builder().newReturnStatement(callExp));        
    }
    
    private final CompilationUnitBuilder builder() {
        return generator.getCurrentBuilder();
    }
    public Expression getExpression() {
        return builder().exp;
    }
    public Expression setExpression(Expression exp) {
        return builder().exp = exp;
    }

	private UniqueIdGenerator uidGen = UniqueIdGenerator.newUniqueIdGenerator("e");
    public String nextUniqueId() {
        return uidGen.next();
    }

	private final int MAX_NESTING = 5;
	private int nestingSize = 0;
	public int initNestingSize() {
	    int result = nestingSize;
	    nestingSize = 1;
	    return result;
	}
	private boolean checkNestingSize(int parentNestingSize) {
	    if (nestingSize >= MAX_NESTING) {
	        nestingSize = parentNestingSize;
	        return true;
	    } else {
	        nestingSize += parentNestingSize;
	        return false;
	    }
	}

	public void addCodeBase(String name) {
	    builder().addClassDeclaration(name, AbstractTemplateFactory.class.getName());
	    
	    // public void apply(IBuilderOperation op)
		MethodDeclaration method = builder().newMethodDeclaration("void", "apply", builder().newSingleVariableDeclaration(IBuilderOperation.class.getName(), "op"));
		builder().addBodyDeclaration(method);
	}

	private Map factoryMap = new HashMap(); //IVisitor -> String factoryVar
	private int i=1;
	public String getFactoryVar(IVisitor v) {
	    return (String)factoryMap.get(v);
	}
    public void addLanguageFactory(IVisitor visitor, String factoryName) {
        String factoryVar = "lf"+i++;
        factoryMap.put(visitor, factoryVar);
        
		//FIXME senza .impl addImportDeclaration(StringUtils.toPackageName(factoryName), true);
        builder().addImportDeclaration(StringUtils.toPackageName(factoryName), true);
        //FIXME potrei non essere in un blocco!!
        builder().addVariableDeclarationStatement(factoryName, factoryVar, builder().newFieldAccess(factoryName, "instance"));
    }

	public MethodInvocation newFactoryInvocation(IVisitor visitor, String method) {
	    return builder().newMethodInvocation(getFactoryVar(visitor), method);
	}

	public ArrayCreation newArrayCreation(String type, ArrayInitializer initializer) {
	    return builder().newArrayCreation(type, initializer);
	}

	//NB devono essere 3 addSubtree
	public Expression addSubtree(IVisitor visitor, SameStageFragment fragment, String type) {
	    int parentNestingSize = initNestingSize();
	    IVisitor v = ((AbstractOperation) visitor.getOperation()).getVisitor(fragment.wGetRoot(),
	    		visitor.getOperation().getStage());
	    v.visit(fragment.wGetRoot());
	    MethodInvocation callExp2 = newFactoryInvocation(v, "makeRootEntity");
	    callExp2.arguments().add(getExpression());
	    MethodInvocation callExp = newFactoryInvocation(visitor, "create"+type);
	    callExp.arguments().add(callExp2);
	    
	    return addSubtree(parentNestingSize, type, callExp);
	}
	public Expression addSubtree(IVisitor visitor, StageDownFragment fragment, String type) {
	    int parentNestingSize = initNestingSize();
	    IVisitor v = ((AbstractOperation) visitor.getOperation()).getVisitor(fragment.wGetRoot(), 0);
	    v.visit(fragment.wGetRoot());
	    MethodInvocation callExp2 = newFactoryInvocation(v, "makeRootEntity");
	    callExp2.arguments().add(getExpression());
	    MethodInvocation callExp = newFactoryInvocation(visitor, "create"+type);
	    callExp.arguments().add(callExp2);
	    
	    return addSubtree(parentNestingSize, type, callExp);
	}
	public Expression addSubtree(IVisitor visitor, StageUpFragment fragment, String type) {
	    int parentNestingSize = initNestingSize();
	    IVisitor v = ((AbstractOperation) visitor.getOperation()).getVisitor(fragment.wGetRoot(), 1);
	    v.visit(fragment.wGetRoot());
		MethodInvocation callExp2 = newFactoryInvocation(v, "makeRootEntity");
	    callExp2.arguments().add(getExpression());
	    MethodInvocation callExp = newFactoryInvocation(visitor, "create"+type);
	    callExp.arguments().add(callExp2);
	    
	    return addSubtree(parentNestingSize, type, callExp);
	}

	public Expression addSubtree(int parentNestingSize, String type, MethodInvocation subtree) {
	    if (nestingSize >= MAX_NESTING) {
	        nestingSize = parentNestingSize;
	        return setExpression(addSubtree(type, subtree));
	    } else {
	        nestingSize += parentNestingSize;
	        return setExpression(subtree);
	    }
	}
	protected Expression addSubtree(String type, MethodInvocation subtree) {
	    String tempEntity = nextUniqueId();
	    builder().addVariableDeclarationStatement(type, tempEntity, subtree);
	    return ast.newSimpleName(tempEntity);
	}
	
	// TODO soluzione alternativa basata su stack
	private Stack/*<Expression>*/ argStack = new Stack();
	public void pushLiteral(String text) {
	    argStack.push(newLiteral(text));
	}
    public void pushLiteral(boolean value) {
        argStack.push(newLiteral(value));
    }
    public void pushLiteral(byte value) {
        argStack.push(newLiteral(value));
    }
    public void pushLiteral(char value) {
        argStack.push(newLiteral(value));
    }
    public void pushLiteral(double value) {
        argStack.push(newLiteral(value));
    }
    public void pushLiteral(float value) {
        argStack.push(newLiteral(value));
    }
    public void pushLiteral(int value) {
        argStack.push(newLiteral(value));
    }
    public void pushLiteral(long value) {
        argStack.push(newLiteral(value));
    }

	public void addSubtree(IVisitor visitor, int parentNestingSize, String type, int args) {
	    MethodInvocation callExp = newFactoryInvocation(visitor, "create"+type);
	    for (int i=0; i<args; i++)
	        callExp.arguments().add(0, argStack.pop());
	    argStack.push(addSubtree(parentNestingSize, type, callExp));
	}
	public void addSubtree(IVisitor visitor, int parentNestingSize, String compositeType, String componentType, int args) {
	    MethodInvocation callExp = newFactoryInvocation(visitor, "create"+compositeType);
	    ArrayInitializer initArrayExp = newArrayInitializer();
	    callExp.arguments().add(builder().newArrayCreation(componentType, initArrayExp));
	    List expressions = initArrayExp.expressions();
	    for (int i=0; i<args; i++)
	        expressions.add(0, argStack.pop());
	    argStack.push(addSubtree(parentNestingSize, compositeType, callExp));
	}
}
