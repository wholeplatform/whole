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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.util.StringUtils;
import static org.whole.gen.lang.ClassNames.*;

/**
 * @author Riccardo Solmi
 */
public class ActionFactoryBuilder extends CompilationUnitBuilder {
	private List addActionsList;
	private List replaceActionsList;

	public ActionFactoryBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.actionFactoryName(), ActionFactoryName);

		addSingletonMethod();
		
		methodDec = newMethodDeclaration(ast.newArrayType(newType("Object"), 2), "addActions");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.getBody().statements().add(newVariableDeclarationStatement(EnablerPredicateFactoryName, "pf", newFieldAccess(newSimpleName(EnablerPredicateFactoryName), "instance")));

		ArrayInitializer initArrayExp = ast.newArrayInitializer();
		addActionsList = initArrayExp.expressions();

		// addActions

		ArrayCreation newExp = newArrayCreation("Object", 2);
		newExp.setInitializer(initArrayExp);
		methodDec.getBody().statements().add(newReturnStatement(newExp));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(ast.newArrayType(newType("Object"), 2), "replaceActions");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.getBody().statements().add(newVariableDeclarationStatement(EnablerPredicateFactoryName, "pf", newFieldAccess(newSimpleName(EnablerPredicateFactoryName), "instance")));

		newExp = newArrayCreation("Object", 2);
		initArrayExp = ast.newArrayInitializer();
		replaceActionsList = initArrayExp.expressions();

		// replaceActions

		newExp.setInitializer(initArrayExp);
		methodDec.getBody().statements().add(newReturnStatement(newExp));
		addBodyDeclaration(methodDec);
	}

	private Set componentTypes = new HashSet();
	public void addAction(String componentType) {
	    if (!componentTypes.add(componentType))
	        return;

		ArrayInitializer arrayInitializer = ast.newArrayInitializer();
		arrayInitializer.expressions().add(newMethodInvocation("pf", "insertFeatureType"));
		arrayInitializer.expressions().add(newLiteral(componentType));
		arrayInitializer.expressions().add(newLiteral(componentType));
		addActionsList.add(arrayInitializer);
	}
	
	public void assertAllEntities() {
		Iterator entities = generator.getEntitySet().iterator();
		while (entities.hasNext()) {
		    replaceAction((String)entities.next());
		}
	}

	private void replaceAction(String concreteType) {
	    String transformer;
	    if (StringUtils.toSimpleName(generator.baseFragmentName()).equals(concreteType)) {
	        transformer = "fragment";
	    } else if (StringUtils.toSimpleName(generator.metaFragmentName()).equals(concreteType)) {
	        transformer = "fragment";
	    } else {
	        transformer = "copy";
	    }
		ArrayInitializer arrayInitializer = ast.newArrayInitializer();
		arrayInitializer.expressions().add(newMethodInvocation("pf", "replaceFeatureType"));
		arrayInitializer.expressions().add(newLiteral(concreteType));
		arrayInitializer.expressions().add(newLiteral(concreteType));
		arrayInitializer.expressions().add(ast.newSimpleName(transformer));
		replaceActionsList.add(arrayInitializer);
	}
}
