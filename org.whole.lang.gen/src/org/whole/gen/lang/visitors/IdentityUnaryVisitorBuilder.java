/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.IVisitor;


/**
 * @author Riccardo Solmi
 */
public class IdentityUnaryVisitorBuilder extends AbstractVisitorCompilationUnitBuilder {
	public IdentityUnaryVisitorBuilder(LanguageGenerator generator) {
		super(generator);

		TypeParameter tp = ast.newTypeParameter();
		tp.setName(ast.newSimpleName("V"));
		tp.typeBounds().add(newType(generator.visitorInterfaceName()));
		addClassDeclaration(
				generator.identityUnaryVisitorName(),
				newParameterizedType(
						generator.abstractUnaryVisitorName(),"V")).typeParameters().add(tp);
		addSuperInterface(generator.specificVisitorInterfaceName());
		addImportDeclaration(generator.modelPackage(), true);

		MethodDeclaration constructor = addConstructorDeclaration();
		SuperConstructorInvocation superCall = newSuperConstructorInvocation();
		superCall.arguments().add(newNullLiteral());
		constructor.getBody().statements().add(superCall);

		String[][] params = {{generator.specificVisitorInterfaceName(), "visitor1"}};
		addConstructorWithSuper(params);

		// generic to specific visit
		MethodDeclaration method = addVisitMethod("visit", IEntity.class.getName());
		MethodInvocation callExp = newMethodInvocation(newParenthesizedExpression(newCastExpression(generator.specificEntityInterfaceName(), ast.newSimpleName("entity"))), "accept");
		callExp.arguments().add(ast.newThisExpression());
		method.getBody().statements().add(ast.newExpressionStatement(callExp));
	}

	public MethodDeclaration addFragmentEntity(String type) {
	    return null;
	}
	public MethodDeclaration addPrimitiveEntity(String type) {
	    return addEntity(type);
	}
}
