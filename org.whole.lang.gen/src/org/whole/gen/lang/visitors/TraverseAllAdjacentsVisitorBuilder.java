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
import org.whole.gen.lang.LanguageGenerator;


/**
 * @author Riccardo Solmi
 */
public class TraverseAllAdjacentsVisitorBuilder extends AbstractVisitorCompilationUnitBuilder {
	public TraverseAllAdjacentsVisitorBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.traverseAllAdjacentsVisitorName(),
				newParameterizedType(
						generator.identityUnaryVisitorName(),
						generator.specificVisitorInterfaceName()));
		addImportDeclaration(generator.modelPackage(), true);

		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.getBody().statements().add(
				newExpressionStatement(newMethodInvocation("wSetVisitor1", ast.newThisExpression()))
		);

		String[][] params = {{generator.specificVisitorInterfaceName(), "visitor1"}};
		addConstructorWithSuper(params);
		addFactoryMethod("traverseAllAdjacents", params);
	}

    public MethodDeclaration addEntity(String type) {
        return null;
	}

	public void addStructuralFeature(String eName, String fType, String fName, String name, boolean isByReference) {
		if (isByReference)
			addStatement(visitMethod(eName), newAcceptInvocation(fType, fName, name, "visitor1"));
	}
	public MethodDeclaration addCompositeEntity(String eName, String componentType, boolean isOrdered, boolean isByReference) {
		if (!isByReference)
			return null;

		MethodDeclaration eMethod = visitMethod(eName);

	    if (isOrdered) {
		    //for (int i=0; i<entity.size(); i++)
		    //  entity.get(i).accept(visitor);
		    addStatement(eMethod, newForStatement(
		            newVariableDeclarationExpression("int", "i", newLiteral(0)),
		            newInfixExpression(ast.newSimpleName("i"), "<", newMethodInvocation("entity", "size")),
		            newPostfixExpression(ast.newSimpleName("i"), "++"),
		            newExpressionStatement(
		                    newAcceptInvocation(newMethodInvocation("entity", "get", ast.newSimpleName("i")), "visitor1"))));
	    } else {
		    //for (ComponentType child : entity)
		    //  child.accept(visitor);
		    addStatement(eMethod, newEnhancedForStatement(
		            newSingleVariableDeclaration(componentType, "child"),
		            ast.newSimpleName("entity"),
		            newExpressionStatement(
		                    newAcceptInvocation(ast.newSimpleName("child"), "visitor1"))));
	    }
	    return eMethod;
	}
}
