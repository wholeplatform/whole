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
public class TraverseAllSwitchVisitorBuilder extends AbstractVisitorCompilationUnitBuilder {
	public TraverseAllSwitchVisitorBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.traverseAllSwitchVisitorName(),
				newParameterizedType(
						generator.identityUnaryVisitorName(),
						generator.visitorInterfaceName()));
		addImportDeclaration(generator.modelPackage(), true);

		String[][] params = {{generator.visitorInterfaceName(), "visitor1"}};
		addConstructorWithSuper(params);
//		addFactoryMethod(params);
	}

    public MethodDeclaration addEntity(String type) {
        return null;
	}

	public void addStructuralFeature(String eName, String fType, String fName, String name, boolean isByReference) {
	    addStatement(visitMethod(eName), newVisitInvocation("visitor1", fType, fName, name));
	}
	public MethodDeclaration addCompositeEntity(String eName, String componentType, boolean isOrdered, boolean isByReference) {
	    MethodDeclaration eMethod = visitMethod(eName);

	    if (isOrdered) {
		    //for (int i=0; i<entity.size(); i++)
		    //  entity.get(i).accept(visitor);
		    addStatement(eMethod, newForStatement(
		            newVariableDeclarationExpression("int", "i", newLiteral(0)),
		            newInfixExpression(ast.newSimpleName("i"), "<", newMethodInvocation("entity", "size")),
		            newPostfixExpression(ast.newSimpleName("i"), "++"),
		            newExpressionStatement(
		            		newVisitInvocation("visitor1", newMethodInvocation("entity", "get", ast.newSimpleName("i"))))));
	    } else {
		    //for (ComponentType child : entity)
		    //  child.accept(visitor);
		    addStatement(eMethod, newEnhancedForStatement(
		            newSingleVariableDeclaration(componentType, "child"),
		            ast.newSimpleName("entity"),
		            newExpressionStatement(
		            		newVisitInvocation("visitor1", ast.newSimpleName("child")))));
	    }

	    return eMethod;
	}
}
