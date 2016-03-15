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
package org.whole.gen.lang.visitors;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.GenericForwardStrategyVisitor;


/**
 * @author Riccardo Solmi
 */
public class ForwardStrategyVisitorBuilder extends AbstractVisitorCompilationUnitBuilder {
	public ForwardStrategyVisitorBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.forwardStrategyVisitorName());
		setSuperclass(newParameterizedType(
				GenericForwardStrategyVisitor.class.getName(),
				generator.specificVisitorInterfaceName()));
		addSuperInterface(generator.specificVisitorInterfaceName());
		addImportDeclaration(generator.modelPackage(), true);

		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.getBody().statements().add(
				newConstructorInvocation(newClassInstanceCreation(
						generator.identityVisitorName()))
		);

		constructor = addConstructorDeclaration();
		SingleVariableDeclaration varDecl = newSingleVariableDeclaration(generator.specificVisitorInterfaceName(), "initialStrategies");
		varDecl.setVarargs(true);
		constructor.parameters().add(varDecl);
		constructor.getBody().statements().add(
				newSuperConstructorInvocation(ast.newSimpleName("initialStrategies")));

		// generic to specific visit
		MethodDeclaration method = addVisitMethod("visit", IEntity.class.getName());
		MethodInvocation callExp = newMethodInvocation(newParenthesizedExpression(newCastExpression(generator.specificEntityInterfaceName(), ast.newSimpleName("entity"))), "accept");
		callExp.arguments().add(ast.newThisExpression());
		method.getBody().statements().add(ast.newExpressionStatement(callExp));
	}

    public MethodDeclaration addEntity(String type) {
        MethodDeclaration method = visitMethod(type);
	    addStatement(method, newVisitInvocation(newMethodInvocation("wGetStrategy"), ast.newSimpleName("entity")));
       return method;
	}
	public MethodDeclaration addFragmentEntity(String type) {
	    return addEntity(type);
	}
}

