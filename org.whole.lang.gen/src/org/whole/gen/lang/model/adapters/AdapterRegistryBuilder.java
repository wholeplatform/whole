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
package org.whole.gen.lang.model.adapters;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.factories.AbstractEntityRegistry;

/**
 * @author Riccardo Solmi
 */
public class AdapterRegistryBuilder extends CompilationUnitBuilder {
	public final MethodDeclaration createPrototypesMethod;

	public AdapterRegistryBuilder(LanguageGenerator generator) {
		super(generator);
		
		addClassDeclaration(generator.adapterRegistryName(), AbstractEntityRegistry.class.getName());
//		addImportDeclaration(generator.modelPackage(), true);
		
		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.getBody().statements().add(
				newSuperConstructorInvocation(
						newFieldAccess(generator.specificEntityDescriptorEnumName(), "instance")));
		
		createPrototypesMethod = newMethodDeclaration("void", "createPrototypes");
			//,newSingleVariableDeclaration(EntityDescriptorEnum.class.getName(), "edNum"));
		createPrototypesMethod.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		createPrototypesMethod.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		addBodyDeclaration(createPrototypesMethod);
	}
	
	public void addFactoryProduct(String entityName) {
		createPrototypesMethod.getBody().statements().add(
				newExpressionStatement(
						newMethodInvocation("put", newClassInstanceCreation(
								generator.entityAdapterName(entityName)))));
	}

//	public MethodDeclaration addFactoryMethod(String entityName) {
//		return super.addFactoryMethod(generator.entityInterfaceQName(entityName), entityName, generator.entityAdapterName(entityName));
//	}
}
