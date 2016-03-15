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

import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.visitors.GenericTraversalFactory;

/**
 * @author Riccardo Solmi
 */
public class TraversalFactoryBuilder extends CompilationUnitBuilder {
	public TraversalFactoryBuilder(LanguageGenerator generator) {
		super(generator);
		
		addClassDeclaration(generator.specificVisitorFactoryName(), GenericTraversalFactory.class.getName());
		addSingletonField();
		
		//add ensureSpecific method
		MethodDeclaration method = newMethodDeclaration(generator.visitorInterfaceName(), "ensureSpecific");
	    method.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		method.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		method.parameters().add(newSingleVariableDeclaration(generator.visitorInterfaceName(), "visitor"));
		ClassInstanceCreation newExp = newClassInstanceCreation(generator.forwardGenericVisitorName());
		newExp.arguments().add(ast.newSimpleName("visitor"));
		addStatement(method, newIfStatement(newInstanceofExpression("visitor", generator.specificVisitorInterfaceName()), newReturnStatement(ast.newSimpleName("visitor")), newReturnStatement(newExp)));
		addBodyDeclaration(method);
	}
}
