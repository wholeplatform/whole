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

import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.Type;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityAdapterBuilder extends CompilationUnitBuilder {
	public EntityAdapterBuilder(LanguageGenerator generator, String entityName) {
		this(generator, entityName, AbstractEntityAdapter.class.getName(), null, null);
	}
	public EntityAdapterBuilder(LanguageGenerator generator, String entityName, String abstractAdapterName, String optComponentType, String optValueType) {
		super(generator);
	
		Type abstractAdapterType = optComponentType != null ? 
				(optValueType != null ? 
						newParameterizedType(abstractAdapterName, optComponentType, optValueType) :
							newParameterizedType(abstractAdapterName, optComponentType)) :
				newType(abstractAdapterName);
		addClassDeclaration(generator.entityAdapterQName(entityName), abstractAdapterType);
		addImportDeclaration(generator.modelPackage(), true);
		if (optComponentType != null && StringUtils.isAmbiguous(optComponentType))
			addImportDeclaration(generator.modelPackage()+"."+optComponentType);
		addSuperInterface(generator.entityInterfaceQName(entityName));
		addSerialVersionUID(1L);

		//costructor with param IEntity
		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.parameters().add(newSingleVariableDeclaration(IEntity.class.getName(), "implementor"));
		SuperConstructorInvocation superCall = newSuperConstructorInvocation();
		superCall.arguments().add(ast.newSimpleName("implementor"));
		constructor.getBody().statements().add(superCall);

		// add default constructor
		addBodyDeclaration(newConstructorDeclaration(typeDec));

		//add accept method
		addBodyDeclaration(newAcceptMethod(generator.specificVisitorInterfaceName()));	

		// add wGetEntityDescriptor method
		MethodDeclaration methodDecl = newMethodDeclaration(
				newParameterizedType(EntityDescriptor.class.getName(), generator.entityInterfaceQName(entityName)),
				"wGetEntityDescriptor");
		methodDecl.getBody().statements().add(newReturnStatement(newFieldAccess(generator.specificEntityDescriptorEnumName(), entityName)));
		addBodyDeclaration(methodDecl);
	}

    public void addFeature(String fType, String fName, String name) {
		if (StringUtils.isAmbiguous(fType))
			addImportDeclaration(generator.modelPackage()+"."+fType);

		String featuresEnum = ((LanguageGenerator) generator).specificFeatureDescriptorEnumName();
		addBodyDeclaration(newGetterMethodWithGenericForward(featuresEnum, fType, fName, name));
		addBodyDeclaration(newSetterMethodWithGenericForward(featuresEnum, fType, fName, name));
    }
    public void addDataFeature(String fType, String fName) {
		addBodyDeclaration(newDataGetterMethodWithGenericForward(fType, fName));
		addBodyDeclaration(newDataSetterMethodWithGenericForward(fType, fName));
    }

	public MethodDeclaration newAcceptMethod(String visitorInterfaceName) {
		MethodDeclaration method = newMethodDeclaration("void", "accept", newSingleVariableDeclaration(visitorInterfaceName, "visitor"));

		if (!isInterface) {
			Block body = newBlock();
			body.statements().add(newIfStatement(
					newMethodInvocation("visitor", "visitAdapter", ast.newThisExpression()),
					newExpressionStatement(
							newMethodInvocation("visitor", "visit", ast.newThisExpression()))));
			method.setBody(body);
		}
		return method;
	}

}
