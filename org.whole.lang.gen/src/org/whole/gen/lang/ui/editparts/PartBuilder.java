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
package org.whole.gen.lang.ui.editparts;

import java.util.List;

import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.util.StringUtils;
import static org.whole.gen.lang.ClassNames.*;


/**
 * @author Riccardo Solmi
 */
public class PartBuilder extends CompilationUnitBuilder {
	private final List getModelChildrenStatements;
	private final String entityGetterName;

	public PartBuilder(LanguageGenerator generator, String packageSuffix, String partName, String entityName, String figureName) {
		super(generator, packageSuffix);
		
		entityGetterName = StringUtils.getterName(entityName, StringUtils.toSimpleName(entityName));

		addClassDeclaration(partName, AbstractPartName);
		
		addImportDeclaration(generator.modelPackage()+"."+entityName);
		addImportDeclaration(generator.figuresPackage()+"."+figureName);
				
		// add createFigure method
		methodDec = newMethodDeclaration("org.eclipse.draw2d.IFigure", "createFigure");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));

		methodDec.getBody().statements().add(newReturnStatement(newClassInstanceCreation(figureName)));
		addBodyDeclaration(methodDec);

		// add get<Model> method
		methodDec = newMethodDeclaration(entityName, entityGetterName);
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));

		CastExpression castExp = newCastExpression(entityName, newMethodInvocation("getModel"));
		methodDec.getBody().statements().add(newReturnStatement(castExp));
		addBodyDeclaration(methodDec);

		// add getModelChildren method
		methodDec = newMethodDeclaration("java.util.List", "getModelChildren");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		addBodyDeclaration(methodDec);
		getModelChildrenStatements = methodDec.getBody().statements();
	}

	public void addChildrenFeature(String fType, String fName) {
		MethodInvocation callExp = newMethodInvocation("list", "add");
		callExp.arguments().add(newMethodInvocation(
				newMethodInvocation(entityGetterName),
				StringUtils.getterName(fType, fName)
		));
		getModelChildrenStatements.add(ast.newExpressionStatement(callExp));
	}
	
	public void endChildrenFeatures() {
		ClassInstanceCreation newExp = newClassInstanceCreation("java.util.ArrayList");
		newExp.arguments().add(newLiteral(getModelChildrenStatements.size()));
		getModelChildrenStatements.add(0, newVariableDeclarationStatement("java.util.List", "list", newExp));

		getModelChildrenStatements.add(newReturnStatement(ast.newSimpleName("list")));		
	}
}
