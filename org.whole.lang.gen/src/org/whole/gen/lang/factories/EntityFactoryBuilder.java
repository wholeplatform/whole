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
package org.whole.gen.lang.factories;

import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityFactoryBuilder extends CompilationUnitBuilder {
	public EntityFactoryBuilder(LanguageGenerator generator) {
		super(generator);
		
		addClassDeclaration(generator.entityFactoryName(), GenericEntityFactory.class.getName());
		addImportDeclaration(generator.modelPackage(), true);
//		addSuperInterface(generator.entityFactoryInterfaceName());

		FieldDeclaration instanceField = newFieldDeclaration(generator.entityFactoryName(), "instance",
				newMethodInvocation("instance", newFieldAccess(RegistryConfigurations.class.getName(), "DEFAULT")));
		instanceField.modifiers().remove(0);//assume ModifierKeyword.PRIVATE_KEYWORD
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		instanceField.modifiers().add(ast.newModifier(ModifierKeyword.FINAL_KEYWORD));
		addBodyDeclaration(0, instanceField);
		
		MethodDeclaration instanceMethod = newMethodDeclaration(generator.entityFactoryName(), "instance",
				newSingleVariableDeclaration(IEntityRegistryProvider.class.getName(), "provider"));
		instanceMethod.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		instanceMethod.getBody().statements().add(newReturnStatement(
				newClassInstanceCreation(generator.entityFactoryName(), ast.newSimpleName("provider"))));
		addBodyDeclaration(1, instanceMethod);

		MethodDeclaration constructor = newConstructorDeclaration(typeDec);
        constructor.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		constructor.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		constructor.parameters().add(newSingleVariableDeclaration(IEntityRegistryProvider.class.getName(), "provider"));
		constructor.getBody().statements().add(newSuperConstructorInvocation(ast.newSimpleName("provider")));
		addBodyDeclaration(2, constructor);
	}
	
	public MethodDeclaration addFactoryMethod(String entityType) {
		return addFactoryForwardMethod(entityType, "create");
	}

	public MethodDeclaration addFactoryForwardMethod(String entityType, String targetMethodName) {
		String factoryType = generator.entityInterfaceQName(entityType);
		String factoryName = entityType;
		String prefixFactoryName = "create"+StringUtils.toSimpleName(factoryName);
	    methodDec = newMethodDeclaration(factoryType, prefixFactoryName);

		if (!isInterface) {
			Block body = newBlock();
			body.statements().add(newReturnStatement(
					newMethodInvocation(targetMethodName,
							newFieldAccess(
									generator.specificEntityDescriptorEnumName(),
									entityType))));
			methodDec.setBody(body);			
		}
		
		addBodyDeclaration(methodDec);
		return methodDec;
	}
	public void addFactoryMethodCase(MethodDeclaration factoryMethod, Type fType, String fName) {
		factoryMethod.parameters().add(newSingleVariableDeclaration(fType, fName));
		if (!isInterface)
			((MethodInvocation)((ReturnStatement)factoryMethod.getBody().statements().get(0)).getExpression()).arguments().add(ast.newSimpleName(fName));
	}
	public void addFactoryMethodVarArgsCase(MethodDeclaration method, String componentType, String fName) {
		SingleVariableDeclaration varDecl = newSingleVariableDeclaration(componentType, fName);
		varDecl.setVarargs(true);

		method.parameters().add(varDecl);
		if (!isInterface)
			((MethodInvocation)((ReturnStatement)method.getBody().statements().get(0)).getExpression()).arguments().add(
					newCastExpression(newArrayType(IEntity.class.getName()), ast.newSimpleName(fName)));
	}

}
