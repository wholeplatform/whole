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
package org.whole.gen.lang.model.impl;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class CompositeEntityImplBuilder extends CompilationUnitBuilder {
	public CompositeEntityImplBuilder(LanguageGenerator generator, String packageSuffix, String entityName, String componentType, String compositeType, boolean isReference, boolean isStrict) {
		super(generator, packageSuffix);

		String className = isStrict ? generator.entityStrictImplName(entityName) : generator.entityImplName(entityName);
		addClassDeclaration(className,
				newParameterizedType(compositeType, componentType));
		generator.putEntity(entityName);
		addImportDeclaration(generator.modelPackage(), true);
		if (StringUtils.isAmbiguous(componentType))
			addImportDeclaration(generator.modelPackage()+"."+componentType);
		
		addSuperInterface(generator.entityInterfaceQName(entityName));
		addSerialVersionUID(1L);

//		addBodyDeclaration(newConstructorDeclaration(typeDec));
		
//		methodDec = newConstructorDeclaration(typeDec);
//		SingleVariableDeclaration param = ast.newSingleVariableDeclaration();
//		param.setType(ast.newArrayType(ast.newSimpleType(newSimpleName(componentType))));
//		param.setName(ast.newSimpleName("entities"));
//		methodDec.parameters().add(param);
//		SuperConstructorInvocation superCall = ast.newSuperConstructorInvocation();
//		superCall.arguments().add(ast.newSimpleName("entities"));
//		methodDec.getBody().statements().add(superCall);
//		addBodyDeclaration(methodDec);
		
		// add wGetType method
//		methodDec = newMethodDeclaration("Class", "wGetType");
//		methodDec.parameters().add(newSingleVariableDeclaration(IEntity.class.getName(), "child"));
//		methodDec.getBody().statements().add(newReturnStatement(newTypeLiteral(componentType)));
//		addBodyDeclaration(methodDec);

		addBodyDeclaration(newAcceptMethod(generator.specificVisitorInterfaceName()));
		
		
		// add wGetEntityOrd method
		MethodDeclaration methodDecl = newMethodDeclaration("int", "wGetEntityOrd");
		methodDecl.getBody().statements().add(newReturnStatement(newFieldAccess(generator.specificEntityDescriptorEnumName(), entityName+"_ord")));
		addBodyDeclaration(methodDecl);
		
		// add wGetEntityDescriptor method
		methodDecl = newMethodDeclaration(
				newParameterizedType(EntityDescriptor.class.getName(), generator.entityInterfaceQName(entityName)),
				"wGetEntityDescriptor");
		methodDecl.getBody().statements().add(newReturnStatement(newFieldAccess(generator.specificEntityDescriptorEnumName(), entityName)));
		addBodyDeclaration(methodDecl);
		
		// add isContainment method
		if (isReference) {
			methodDecl = newMethodDeclaration("boolean", "isContainment");
			methodDecl.getBody().statements().add(newReturnStatement(newLiteral(false)));
			addBodyDeclaration(methodDecl);	
		}		
	}
}
