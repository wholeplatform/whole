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
package org.whole.gen.lang.ui.actions;

import java.util.List;

import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import static org.whole.gen.lang.ClassNames.*;

/**
 * @author Riccardo Solmi
 */
public class CommandFactoryBuilder extends CompilationUnitBuilder {
	private List addOverCompositeConstraintsList;
	private List addOverSimpleConstraintsList;

	public CommandFactoryBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.commandFactoryName(), CommandFactoryName);
		addImportDeclaration(generator.modelPackage(), true);

		methodDec = addSingletonMethod();

		MethodInvocation callExp = newMethodInvocation("addOverCompositeConstraints");
		ArrayCreation newExp = newArrayCreation("Class", 2);

		ArrayInitializer initArrayExp = ast.newArrayInitializer();
		newExp.setInitializer(initArrayExp);
		callExp.arguments().add(newExp);
		methodDec.getBody().statements().add(ast.newExpressionStatement(callExp));

		addOverCompositeConstraintsList = initArrayExp.expressions();


		callExp = newMethodInvocation("addOverSimpleConstraints");
		newExp = newArrayCreation("Class", 2);

		initArrayExp = ast.newArrayInitializer();
		newExp.setInitializer(initArrayExp);
		callExp.arguments().add(newExp);
		methodDec.getBody().statements().add(ast.newExpressionStatement(callExp));

		addOverSimpleConstraintsList = initArrayExp.expressions();

		
		methodDec = newMethodDeclaration(EnablerPredicateFactoryName, "createEnablerPredicateFactory");
		methodDec.getBody().statements().add(newReturnStatement(newFieldAccess(newSimpleName(EnablerPredicateFactoryName), "instance")));
		addBodyDeclaration(methodDec);
	}

	public void addOverSimpleConstraint(String dndType, String simpleType) {
		ArrayInitializer arrayInitializer = ast.newArrayInitializer();
		arrayInitializer.expressions().add(newTypeLiteral(dndType));
		arrayInitializer.expressions().add(newTypeLiteral(simpleType));
		addOverSimpleConstraintsList.add(arrayInitializer);
	}

	public void addOverCompositeConstraint(String componentType, String compositeType) {
		ArrayInitializer arrayInitializer = ast.newArrayInitializer();
		arrayInitializer.expressions().add(newTypeLiteral(componentType));
		arrayInitializer.expressions().add(newTypeLiteral(compositeType));
		addOverCompositeConstraintsList.add(arrayInitializer);
	}
}
