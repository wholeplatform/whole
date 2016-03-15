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

import java.util.List;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.builders.BuilderConstants;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class VisitorContextBuilder extends AbstractVisitorCompilationUnitBuilder {
	protected List switchList;

	public VisitorContextBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.specificIdentityBuilderContextName(), generator.specificModelContextName());

		//costructor with param IEntity
		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.parameters().add(newSingleVariableDeclaration(IEntity.class.getName(), "root"));
		SuperConstructorInvocation superCall = newSuperConstructorInvocation();
		superCall.arguments().add(ast.newSimpleName("root"));
		constructor.getBody().statements().add(superCall);

		// generic to specific visit
		MethodDeclaration switchMethod = newMethodDeclaration("void", "visit");
		SwitchStatement switchStm = newSwitchStatement(newMethodInvocation("wGetEntityOrd"));
		switchMethod.getBody().statements().add(switchStm);
		addBodyDeclaration(switchMethod);
		switchList = switchStm.statements();
	}
	
	public MethodDeclaration addEntity(String type) {
		MethodDeclaration method;
		addBodyDeclaration(method = newMethodDeclaration("void", BuilderConstants.buildName(type)));		

		addVisitSwitchCase(type);
		
		return method;
	}
	public MethodDeclaration addSimpleEntity(String type) {
		MethodDeclaration method;
		addBodyDeclaration(method = newMethodDeclaration("void", BuilderConstants.buildName(type)));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.startBuildName(type)));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.startBuildName(type),
				newSingleVariableDeclaration(generator.featureDescriptorName(), "feature")));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.endBuildName(type)));		

		addVisitSwitchCase(type);

		return method;
	}
	public MethodDeclaration addCompositeEntity(String type, String componentType, boolean isOrdered, boolean isByReference) {
		MethodDeclaration method;
		addBodyDeclaration(method = newMethodDeclaration("void", BuilderConstants.buildName(type)));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.startBuildName(type),
				newSingleVariableDeclaration("int", "initialCapacity")));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.startBuildName(type),
				newSingleVariableDeclaration(generator.featureDescriptorName(), "feature"),
				newSingleVariableDeclaration("int", "initialCapacity")));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.endBuildName(type)));		
		
		addVisitSwitchCase(type);

		return method;
	}
	public MethodDeclaration addPrimitiveEntity(String type) {
		return null;
	}
	public void addPrimitiveFeature(String type, String primitiveType, String name) {
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.buildName(type)));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.buildName(type),
				newSingleVariableDeclaration(primitiveType, "value")));		
		addBodyDeclaration(newMethodDeclaration("void", BuilderConstants.buildName(type),
				newSingleVariableDeclaration(generator.featureDescriptorName(), "feature"),
				newSingleVariableDeclaration(primitiveType, "value")));		
		
		addVisitSwitchCase(type);
	}
	public MethodDeclaration addFragmentEntity(String type) {
	    return addEntity(type);
	}

	public void addVisitSwitchCase(String type) {
		switchList.add(newCaseStatement(newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), StringUtils.toSimpleName(type)+"_ord")));
		switchList.add(newExpressionStatement(newMethodInvocation(BuilderConstants.buildName(type))));
		switchList.add(ast.newBreakStatement());
	}
}
