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
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class IdentitySwitchVisitorBuilder extends AbstractVisitorCompilationUnitBuilder {
	protected List switchList;

	public IdentitySwitchVisitorBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.identitySwitchVisitorName(), generator.abstractVisitorName());
		typeDec.modifiers().add(ast.newModifier(ModifierKeyword.ABSTRACT_KEYWORD));
		addImportDeclaration(generator.modelPackage(), true);
		addSuperInterface(generator.specificVisitorInterfaceName());

		// switch by entity ordinal method
		MethodDeclaration switchMethod = newMethodDeclaration("void", "visit");
		switchMethod.parameters().add(newSingleVariableDeclaration(IEntity.class.getName(), "entity"));	
		SwitchStatement switchStm = newSwitchStatement(newMethodInvocation("entity", "wGetEntityOrd"));
		switchMethod.getBody().statements().add(switchStm);
		addBodyDeclaration(switchMethod);
		switchList = switchStm.statements();
		
//		addFragmentVisitMethod("AdapterFragmentEntity", generator.adapterFragmentName());
//		addFragmentVisitMethod("BaseFragmentEntity", generator.baseFragmentName());
//		addFragmentVisitMethod("MetaFragmentEntity", generator.metaFragmentName());
	}

	public MethodDeclaration addFragmentVisitMethod(String visitSuffix, String typeName) {
		addVisitSwitchCase(typeName);
		return super.addFragmentVisitMethod(visitSuffix, typeName);
//		
//		MethodDeclaration method = addVisitMethod(typeName);
//		SuperMethodInvocation callExp = newSuperMethodInvocation("visit");
//		callExp.arguments().add(ast.newSimpleName("entity"));
//		method.getBody().statements().add(ast.newExpressionStatement(callExp));
//		return method;
	}
	
	public MethodDeclaration addEntity(String type) {
		addVisitSwitchCase(type);
		return null;
	}

	public void addVisitSwitchCase(String typeName) {
		typeName = generator.entityInterfaceQName(typeName);
		switchList.add(newCaseStatement(newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), StringUtils.toSimpleName(typeName)+"_ord")));
		MethodInvocation callExp = newMethodInvocation("visit");
		callExp.arguments().add(newCastExpression(typeName, ast.newSimpleName("entity")));
		switchList.add(newExpressionStatement(callExp));
		switchList.add(ast.newBreakStatement());
	}
}
