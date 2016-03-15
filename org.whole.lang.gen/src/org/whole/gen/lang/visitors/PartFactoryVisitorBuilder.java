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

import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.adapters.IEntityAdapter;

import static org.whole.gen.lang.ClassNames.*;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public class PartFactoryVisitorBuilder extends CompilationUnitBuilder {
	public PartFactoryVisitorBuilder(LanguageGenerator generator) {
		this(generator, null);
	}
	public PartFactoryVisitorBuilder(LanguageGenerator generator, String superEditorName) {
		super(generator);

		if (superEditorName == null) {
			addClassDeclaration(
					generator.partFactoryVisitorName(),
					generator.identityDefaultVisitorName());
			addSuperInterface(IEditPartFactoryName);
		} else
			addClassDeclaration(
					generator.partFactoryVisitorName(),
					generator.partFactoryVisitorName(superEditorName));

		addImportDeclaration(generator.modelPackage(), true);

		FieldDeclaration fieldDecl = newFieldDeclaration(EditPartName, "part");
		fieldDecl.fragments().add(newVariableDeclarationFragment("context", null));
		fieldDecl.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
		fieldDecl.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		addBodyDeclaration(fieldDecl);

		addBodyDeclaration(createCreateEditPartMethod(generator));
		addBodyDeclaration(createVisitAdapterMethod(generator));		
		addBodyDeclaration(createDefaultVisitMethod(generator));
	}

	protected MethodDeclaration createCreateEditPartMethod(LanguageGenerator generator) {
		MethodDeclaration methodDec = newMethodDeclaration(EditPartName, "createEditPart",
				newSingleVariableDeclaration(EditPartName, "context"),
				newSingleVariableDeclaration("Object", "modelEntity"));		
		
		Block body = methodDec.getBody();
		
		body.statements().add(newExpressionStatement(newAssignment(newFieldAccess(ast.newThisExpression(), "context"), ast.newSimpleName("context"))));
		
		CastExpression castExp = newCastExpression(generator.specificEntityInterfaceName(), ast.newSimpleName("modelEntity"));
		MethodInvocation callExp = newMethodInvocation(newParenthesizedExpression(castExp), "accept");
		callExp.arguments().add(ast.newThisExpression());
		body.statements().add(ast.newExpressionStatement(callExp));

		body.statements().add(newReturnStatement(ast.newSimpleName("part")));
		return methodDec;
	}

	protected MethodDeclaration createVisitAdapterMethod(LanguageGenerator generator) {
		MethodDeclaration methodDec = newMethodDeclaration("boolean", "visitAdapter",
				newSingleVariableDeclaration(IEntityAdapter.class.getName(), "entity"));		
		
		Block body = methodDec.getBody();
		
		body.statements().add(newExpressionStatement(
				newAssignment(ast.newSimpleName("part"), newClassInstanceCreation(PlaceHolderPartName))));

		body.statements().add(newReturnStatement(
				newSuperMethodInvocation("visitAdapter", ast.newSimpleName("entity"))));
		return methodDec;
	}

	protected MethodDeclaration createDefaultVisitMethod(LanguageGenerator generator) {
		MethodDeclaration methodDec = newMethodDeclaration("void", "visit",
				newSingleVariableDeclaration(generator.specificEntityInterfaceName(), "entity"));		
		
		Block body = methodDec.getBody();
		
		body.statements().add(newExpressionStatement(
				newAssignment(ast.newSimpleName("part"),
						newMethodInvocation(
								newMethodInvocation(TextualASTPartFactoryName, "instance"),
								"createEditPart",
								ast.newSimpleName("context"),
								ast.newSimpleName("entity")))));

		return methodDec;
	}

	public MethodDeclaration addPartFactoryVisitMethod(String typeName) {
		return addPartFactoryVisitMethod(typeName, ((LanguageGenerator) generator).partName(typeName));
	}
	public MethodDeclaration addPartFactoryVisitMethod(String typeName, String partName) {
		MethodDeclaration method = addVisitMethod(typeName);
		if (!isInterface) {
			Assignment eq = newAssignment(ast.newSimpleName("part"), newClassInstanceCreation(partName));
			method.getBody().statements().add(newExpressionStatement(eq));
		}
		
		return method;
	}
	public MethodDeclaration addPartFactoryVisitMethod(String typeName, int size) {
		MethodDeclaration method = addVisitMethod(typeName);
		if (!isInterface) {
			ClassInstanceCreation partInstance;
			if (typeName.equals(((LanguageGenerator) generator).entityVariableName()))
				partInstance = newClassInstanceCreation(
						 VariablePartName);
			else
				partInstance = newClassInstanceCreation(
						size < 5 ? SimplePartName : SimpleFoldablePartName,
						newMethodInvocation("entity", "wGetEntityDescriptor"));

			Assignment eq = newAssignment(ast.newSimpleName("part"), partInstance);
			method.getBody().statements().add(newExpressionStatement(eq));
		}
		
		return method;
	}
}
