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
package org.whole.gen.lang.model.impl;

import java.util.List;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class SimpleEntityImplBuilder extends CompilationUnitBuilder {
	public MethodDeclaration fieldsConstructor;
	private MethodDeclaration getByIndexMethod;
	private List getByIndexSwitchStatements;
	private MethodDeclaration setByIndexMethod;
	private List setByIndexSwitchStatements;
	private MethodDeclaration hashCodeMethod;
	private MethodDeclaration equalsMethod;
	private MethodDeclaration toStringMethod;
	private int featureIndex;
	private int children;
	private int references;

	public SimpleEntityImplBuilder(LanguageGenerator generator, String packageSuffix, String entityName) {
		super(generator, packageSuffix);

		addClassDeclaration(generator.entityImplName(entityName), AbstractSimpleEntity.class.getName());
		generator.putEntity(entityName);
//		addImportDeclaration(generator.modelPackage(), true);
		addSuperInterface(generator.entityInterfaceQName(entityName));
		addSerialVersionUID(1L);

		// add wGetEntityDescriptor method
		MethodDeclaration methodDecl = newMethodDeclaration(
				newParameterizedType(EntityDescriptor.class.getName(), generator.entityInterfaceQName(entityName)),
				"wGetEntityDescriptor");
		methodDecl.getBody().statements().add(newReturnStatement(newFieldAccess(generator.specificEntityDescriptorEnumName(), entityName)));
		addBodyDeclaration(methodDecl);

		// add wGetEntityOrd method
		methodDecl = newMethodDeclaration("int", "wGetEntityOrd");
		methodDecl.getBody().statements().add(newReturnStatement(newFieldAccess(generator.specificEntityDescriptorEnumName(), entityName+"_ord")));
		addBodyDeclaration(methodDecl);
		
		// add accept method
		addBodyDeclaration(newAcceptMethod(generator.specificVisitorInterfaceName()));
	}
	
	private MethodDeclaration getByIndexMethod() {
	    if (getByIndexMethod == null) {
	    	getByIndexMethod = newMethodDeclaration(IEntity.class.getName(), "wGet");
	    	getByIndexMethod.parameters().add(newSingleVariableDeclaration("int", "index"));
	    }
        return getByIndexMethod;
	}
	private void getByIndexMethodEnd() {
	    if (getByIndexMethod == null)
	        return;
		getByIndexSwitchStatements.add(newDefaultCaseStatement());
		getByIndexSwitchStatements.add(newThrowStatement(newClassInstanceCreation("IllegalArgumentException")));
		addBodyDeclaration(getByIndexMethod);
	}

	private MethodDeclaration setByIndexMethod() {
	    if (setByIndexMethod == null) {
	    	setByIndexMethod = newMethodDeclaration("void", "wSet");
	    	setByIndexMethod.parameters().add(newSingleVariableDeclaration("int", "index"));
	    	setByIndexMethod.parameters().add(newSingleVariableDeclaration(IEntity.class.getName(), "value"));
	    }
        return setByIndexMethod;
	}
	private void setByIndexMethodEnd() {
	    if (setByIndexMethod == null)
	        return;
		setByIndexSwitchStatements.add(newDefaultCaseStatement());
		setByIndexSwitchStatements.add(newThrowStatement(newClassInstanceCreation("IllegalArgumentException")));
		addBodyDeclaration(setByIndexMethod);
	}

	private MethodDeclaration hashCodeMethod(Expression exp) {
	    if (hashCodeMethod == null) {
	    	hashCodeMethod = newMethodDeclaration("int", "wHashCode");
	    	hashCodeMethod.getBody().statements().add(newReturnStatement(exp));
	    	addBodyDeclaration(hashCodeMethod);
	    } else {
	    	ReturnStatement stm = (ReturnStatement) hashCodeMethod.getBody().statements().get(0);
	    	Expression oldExp = stm.getExpression();
	    	stm.setExpression(null);
	    	stm.setExpression(newInfixExpression(oldExp, "+", newInfixExpression(newLiteral(29), "*", exp)));
	    }
        return hashCodeMethod;
	}
	private void hashCodeMethodAddId(String fType, String fName) {
		hashCodeMethod(
				newMethodInvocation(
						newMethodInvocation(StringUtils.getterName(fName)),
						"wHashCode"));
	}

	private MethodDeclaration equalsMethod(Expression exp) {
	    if (equalsMethod == null) {
	    	equalsMethod = newMethodDeclaration("boolean", "wEquals", newSingleVariableDeclaration(IEntity.class.getName(), "entity"));
	    	equalsMethod.getBody().statements().add(
	    			newIfStatement(newInfixExpression(ast.newThisExpression(), "==", ast.newSimpleName("entity")),
	    					newReturnStatement(newLiteral(true))));
	    	equalsMethod.getBody().statements().add(
	    			newIfStatement(newPrefixExpression(
	    					newMethodInvocation(
	    							newMethodInvocation("wGetEntityDescriptor"), "equals",
	    							newMethodInvocation("entity", "wGetEntityDescriptor")), "!"),
	    					newReturnStatement(newLiteral(false))));
	    	equalsMethod.getBody().statements().add(
	    			newTryStatement(newReturnStatement(exp),
	    					newSingleVariableDeclaration("Exception", "e"),
	    					newReturnStatement(newLiteral(false))));
	    	addBodyDeclaration(equalsMethod);
	    } else {
	    	TryStatement tryStm = (TryStatement) equalsMethod.getBody().statements().get(2);
	    	ReturnStatement stm = (ReturnStatement) tryStm.getBody().statements().get(0);
	    	Expression oldExp = stm.getExpression();
	    	stm.setExpression(null);
	    	stm.setExpression(newInfixExpression(oldExp, "&&", exp));
	    }
        return equalsMethod;
	}
	private void equalsMethodAddId(String fType, String fName) {
		equalsMethod(
				newMethodInvocation(
						newMethodInvocation(StringUtils.getterName(fType, fName)),
						"wEquals", 
						newMethodInvocation("entity", "wGet",
								newFieldAccess(((LanguageGenerator) generator).specificFeatureDescriptorEnumName(), fName))));
	}

	private MethodDeclaration toStringMethod() {
	    if (toStringMethod == null) {
	    	toStringMethod = newMethodDeclaration("void", "toString", newSingleVariableDeclaration(StringBuffer.class.getName(), "buffer"));
	    	toStringMethod.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
	    	toStringMethod.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
	    	addBodyDeclaration(toStringMethod);
	    }
        return toStringMethod;
	}
	private void toStringMethodAddField(String fType, String fName) {
		List body = toStringMethod().getBody().statements();
		body.add(newExpressionStatement(newMethodInvocation(
				"buffer",
				"append", 
				newLiteral(fName+"="))));
		body.add(newExpressionStatement(newMethodInvocation(
				"buffer",
				"append", 
				ast.newSimpleName(fName))));
	}

	public void endBody() {
		if (children > 0 || references > 0) {
			getByIndexMethodEnd();
			setByIndexMethodEnd();
		}

		// add byIndex and size methods
		if (children > 0) {			
			MethodDeclaration method = newMethodDeclaration("int", "wSize");
			method.getBody().statements().add(newReturnStatement(newLiteral(children)));
			addBodyDeclaration(method);
		}

		// add outAdjacentSize method
		if (references > 0) {
			MethodDeclaration method = newMethodDeclaration("int", "wAdjacentSize");
			method.getBody().statements().add(newReturnStatement(newLiteral(references)));
			addBodyDeclaration(method);
		}
		
	}

	public void addField(String fType, String fName, String name, boolean isId, boolean isOptional, boolean isReference, boolean isShared, boolean isDerived) {
//		if (StringUtils.isAmbiguous(fType))
		if (!StringUtils.isPrimitiveOrString(fType))
			addImportDeclaration(generator.modelPackage()+"."+fType);
		
		if (isId) {
			hashCodeMethodAddId(fType, fName);
			equalsMethodAddId(fType, fName);
			toStringMethodAddField(fType, fName);
		}

		// add field, getter and setter methods
		addBodyDeclaration(newFieldDeclaration(fType, fName));
		addBodyDeclaration(newGetterMethodWithNotification(((LanguageGenerator) generator).specificFeatureDescriptorEnumName(), fType, fName, name));
		addBodyDeclaration(newSetterMethodWithNotification(((LanguageGenerator) generator).specificFeatureDescriptorEnumName(), fType, fName, name, isReference));
		
//		if (fieldsConstructor == null)
//			addBodyDeclaration(1, fieldsConstructor = newConstructorDeclaration(typeDec));
//		addConstructorCase(fieldsConstructor, fType, fName);

		if (StringUtils.isPrimitiveOrString(fType))
			return;

		// add get(int index) case
		if (getByIndexMethod().getBody().statements().size() == 0) {
			SwitchStatement switchStm = newSwitchStatement(ast.newSimpleName("index"));
			getByIndexMethod().getBody().statements().add(switchStm);
			getByIndexSwitchStatements = switchStm.statements();
		}
		getByIndexSwitchStatements.add(newCaseStatement(newLiteral(featureIndex)));
		getByIndexSwitchStatements.add(newReturnStatement(newMethodInvocation(
				newMethodInvocation(StringUtils.getterName(StringUtils.isJavaKeyword(name) ? name : fName)), "wGetAdaptee", newLiteral(false))));

		// add set(int index, IEntity value) case
		if (setByIndexMethod().getBody().statements().size() == 0) {
			SwitchStatement switchStm = newSwitchStatement(ast.newSimpleName("index"));
			setByIndexMethod().getBody().statements().add(switchStm);
			setByIndexSwitchStatements = switchStm.statements();
		}
		setByIndexSwitchStatements.add(newCaseStatement(newLiteral(featureIndex)));
		MethodInvocation callExp = newMethodInvocation(StringUtils.setterName(StringUtils.isJavaKeyword(name) ? name : fName),
				newMethodInvocation(ast.newSimpleName("value"), "wGetAdapter",
						newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), fType)));
		setByIndexSwitchStatements.add(newExpressionStatement(callExp));
		setByIndexSwitchStatements.add(ast.newBreakStatement());

		featureIndex++;
		if (isReference)
			references++;
		else
			children++;
	}
}
