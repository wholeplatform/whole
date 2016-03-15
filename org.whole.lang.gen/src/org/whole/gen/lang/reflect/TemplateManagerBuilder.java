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
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class TemplateManagerBuilder extends CompilationUnitBuilder {

	public TemplateManagerBuilder(LanguageGenerator generator) {
		super(generator);

		String entityName = generator.getTopEntityImplName();
		String entityClassName = generator.modelPackage()+'.'+entityName;

		addClassDeclaration(generator.templateManagerName(), AbstractTemplateManager.class.getName());

		MethodDeclaration constructor = addSingletonHolderMethod();

		MethodInvocation callExp = newMethodInvocation("put");
		callExp.arguments().add(newLiteral("empty"));
		ClassInstanceCreation newClassExp = newClassInstanceCreation(newParameterizedType(AbstractTemplateFactory.class.getName(), entityClassName));


		AnonymousClassDeclaration anonClassDec = ast.newAnonymousClassDeclaration();
		methodDec = newMethodDeclaration(entityClassName, "create");
		MethodInvocation cloneExp = newMethodInvocation(
				newFieldAccess(GenericEntityFactory.class.getName(), "instance"), "create");
		cloneExp.arguments().add(newFieldAccess(
				generator.specificEntityDescriptorEnumName(), entityName));
		methodDec.getBody().statements().add(newReturnStatement(cloneExp));
		anonClassDec.bodyDeclarations().add(methodDec);
		newClassExp.setAnonymousClassDeclaration(anonClassDec);
		callExp.arguments().add(newClassExp);
		constructor.getBody().statements().add(newExpressionStatement(callExp));
	}
}
