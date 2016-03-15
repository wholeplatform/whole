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
package org.whole.gen.lang.builders;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class ModelContextBuilder extends CompilationUnitBuilder {
	private Set features = new HashSet();
	
	public ModelContextBuilder(LanguageGenerator generator) {
		super(generator);
		
		addClassDeclaration(generator.specificModelContextName(), EntityContext.class.getName());

		//costructor with param IEntity
		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.parameters().add(newSingleVariableDeclaration(IEntity.class.getName(), "root"));
		SuperConstructorInvocation superCall = newSuperConstructorInvocation();
		superCall.arguments().add(ast.newSimpleName("root"));
		constructor.getBody().statements().add(superCall);
	}

    public void addFeature(String fType, String fName) {
    	if (features.add(fName)) {
    		// add getter
    		MethodDeclaration method = newMethodDeclaration(generator.specificModelContextName(), StringUtils.getterName(fType, fName));
			MethodInvocation callExp = newMethodInvocation("wGet");
			callExp.arguments().add(newFieldAccess(((LanguageGenerator) generator).specificFeatureDescriptorEnumName(), fName));
    		method.getBody().statements().add(newReturnStatement(newCastExpression(generator.specificModelContextName(), callExp)));
			addBodyDeclaration(method);

    		// add setter
    		method = newMethodDeclaration("void", StringUtils.setterName(fName));
    		method.parameters().add(newSingleVariableDeclaration(generator.specificModelContextName(), fName));
    		callExp = newMethodInvocation("wSet");
			callExp.arguments().add(newFieldAccess(((LanguageGenerator) generator).specificFeatureDescriptorEnumName(), fName));
			callExp.arguments().add(ast.newSimpleName(fName));
			method.getBody().statements().add(newExpressionStatement(callExp));
			addBodyDeclaration(method);

    	}
    }
}
