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
package org.whole.gen.lang.reflect;

import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;


/**
 * @author Riccardo Solmi
 */
public class LanguageDeployerBuilder extends CompilationUnitBuilder {
	public LanguageDeployerBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.languageDeployerName(), AbstractLanguageDeployer.class.getName());

		methodDec = newMethodDeclaration("void", "deploy", newSingleVariableDeclaration(ReflectionFactory.class.getName(), "platform"));
		addStatement(methodDec,
				newMethodInvocation("platform", "addLanguageKit", newClassInstanceCreation(generator.languageKitName())));
		
		addBuilderOperationFactory(generator.languageKitName(), GenericBuilderAdapterOperation.class.getName(), generator.genericBuilderAdapterName(), true);
		addBuilderOperationFactory(generator.languageKitName(), SpecificBuilderAdapterOperation.class.getName(), generator.specificBuilderAdapterName(), false);
		
//		addStatement(methodDec,
//				newMethodInvocation("platform", "addEditorKit", newFieldAccess(generator.languageKitName(), "ID"), newFieldAccess(generator.editorKitName(), "ID")));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration("void", "undeploy", newSingleVariableDeclaration(ReflectionFactory.class.getName(), "platform"));
		addStatement(methodDec,
				newMethodInvocation("platform", "removeLanguageKit", newFieldAccess(generator.languageKitName(), "URI")));
		addBodyDeclaration(methodDec);
	}

	private void addBuilderOperationFactory(String languageKitName, String operationName, String builderClassName, boolean withCast) {
		ClassInstanceCreation newClassExp = newClassInstanceCreation(IBuilderFactory.class.getName());
		AnonymousClassDeclaration anonClassDec = ast.newAnonymousClassDeclaration();
		MethodDeclaration methodDec2 = newMethodDeclaration(IBuilder.class.getName(), "create", 
				newSingleVariableDeclaration(IBuilder.class.getName(), "strategy"), 
				newSingleVariableDeclaration(IEntityContext.class.getName(), "entityContext"));
		if (withCast)
			addStatement(methodDec2,
					newReturnStatement(
					newClassInstanceCreation(builderClassName,
							newCastExpression(((LanguageGenerator) generator).specificBuilderInterfaceName(), ast.newSimpleName("strategy")),
							ast.newSimpleName("entityContext"))));
		else
			addStatement(methodDec2,
					newReturnStatement(
					newClassInstanceCreation(builderClassName,
							ast.newSimpleName("strategy"),
							ast.newSimpleName("entityContext"))));
		anonClassDec.bodyDeclarations().add(methodDec2);
		newClassExp.setAnonymousClassDeclaration(anonClassDec);
		addStatement(methodDec,
				newMethodInvocation("platform", "addOperationFactory",
						newFieldAccess(languageKitName, "URI"),
						newFieldAccess(operationName, "ID"),
						newClassExp));
	}
}
