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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.gen.lang.visitors.AbstractVisitorCompilationUnitBuilder;
import org.whole.lang.builders.BuilderConstants;
import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class GenericBuilderAdapterBuilder extends AbstractVisitorCompilationUnitBuilder {
	public GenericBuilderAdapterBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.genericBuilderAdapterName(), GenericIdentityBuilder.class.getName());

		addBodyDeclaration(newFieldDeclaration(generator.specificBuilderInterfaceName(), "specificBuilder"));
		
		//costructors
		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.parameters().add(newSingleVariableDeclaration(generator.specificBuilderInterfaceName(), "specificBuilder"));
		addStatement(constructor, newAssignment(newFieldAccess(ast.newThisExpression(), "specificBuilder"), ast.newSimpleName("specificBuilder")));

		constructor = addConstructorDeclaration();
		constructor.parameters().add(newSingleVariableDeclaration(generator.specificBuilderInterfaceName(), "specificBuilder"));
		constructor.parameters().add(newSingleVariableDeclaration(IEntityContext.class.getName(), "entityContext"));
		addStatement(constructor, newConstructorInvocation(ast.newSimpleName("specificBuilder")));
		addStatement(constructor, newMethodInvocation("wSetEntityContext", ast.newSimpleName("entityContext")));

		// generic visit
		addBodyDeclaration(newMethodDeclaration("void", "visit"));
	}

	public MethodDeclaration addSimpleEntity(String type) {
		addSwitchCase(getMethodSwitch("wEntity"), type, BuilderConstants.buildName(type));
		addSwitchCase(getMethodSwitch("wEntity_"), type, BuilderConstants.startBuildName(type));
		addSwitchCase(getMethodSwitch("_wEntity"), type, BuilderConstants.endBuildName(type));		
		return null;
	}

	public MethodDeclaration addCompositeEntity(String type, String componentType, boolean isOrdered, boolean isByReference) {
		addSwitchCase(getMethodSwitch("wEntity"), type, BuilderConstants.buildName(type));
		addSwitchCase(getMethodSwitch("wEntity_"), type, BuilderConstants.startBuildName(type));
		addSwitchCase(getCompositeMethodSwitch("wEntity_"), type, BuilderConstants.startBuildName(type), "initialCapacity");
		addSwitchCase(getMethodSwitch("_wEntity"), type, BuilderConstants.endBuildName(type));
		return null;
	}

	public void addStructuralFeature(String eName, String fType, String fName, String name, boolean isByReference) {
		addFeatureSwitchCase(getFeatureMethodSwitch("wFeature"), fName, fName);
	}
	public MethodDeclaration addPrimitiveEntity(String type) {
		return null;
	}
	public void addPrimitiveFeature(String type, String primitiveType, String name) {
		addDataSwitchCase(getDataMethodSwitch(type, primitiveType), type);
	}

	public void addEnumEntity(String type, String primitiveType, String name) {
		addEnumSwitchCase(getEnumMethodSwitch(type), type, primitiveType);
	}

	public MethodDeclaration addResolverEntity(String type) {
		return null;
	}

	List enumCases;
	protected List getEnumMethodSwitch(String type) {
		if (enumCases == null) {
			MethodDeclaration method = newMethodDeclaration("void", "wEntity",
					newSingleVariableDeclaration(
							newParameterizedType(EntityDescriptor.class.getName(), ast.newWildcardType()), "entityDesc"),
					newSingleVariableDeclaration(EnumValue.class.getName(), "value"));
			SwitchStatement switchStm = newSwitchStatement(newMethodInvocation("entityDesc", "getOrdinal"));
			method.getBody().statements().add(switchStm);
			addBodyDeclaration(method);
			
			enumCases = switchStm.statements();
		}
		return enumCases;
	}
	public void addEnumSwitchCase(List switchList, String type, String valueType) {
		switchList.add(newCaseStatement(newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), StringUtils.toSimpleName(type)+"_ord")));
		switchList.add(newExpressionStatement(newMethodInvocation(
				ast.newSimpleName("specificBuilder"),
				type, newCastExpression(valueType, ast.newSimpleName("value")))));
		switchList.add(ast.newBreakStatement());
	}

	private Map/*<String, List>*/ dataSwitchMap = new HashMap();
	protected List getDataMethodSwitch(String type, String valueType) {
		List cases = (List) dataSwitchMap.get(valueType);
		if (cases == null) {
			MethodDeclaration method = newMethodDeclaration("void", "wEntity",
					newSingleVariableDeclaration(
							newParameterizedType(EntityDescriptor.class.getName(), ast.newWildcardType()), "entityDesc"),
					newSingleVariableDeclaration(valueType, "value"));
			SwitchStatement switchStm = newSwitchStatement(newMethodInvocation("entityDesc", "getOrdinal"));
			method.getBody().statements().add(switchStm);
			addBodyDeclaration(method);
			
			dataSwitchMap.put(valueType, cases = switchStm.statements());
		}
		return cases;
	}
	public void addDataSwitchCase(List switchList, String type) {
		switchList.add(newCaseStatement(newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), StringUtils.toSimpleName(type)+"_ord")));
		switchList.add(newExpressionStatement(newMethodInvocation(
				ast.newSimpleName("specificBuilder"),
				type, ast.newSimpleName("value"))));
		switchList.add(ast.newBreakStatement());
	}

	private Map<String, List> switchMap = new HashMap<String, List>();
	protected List getMethodSwitch(String type) {
		List cases = switchMap.get(type);
		if (cases == null) {
			MethodDeclaration method = newMethodDeclaration("void", type,
					newSingleVariableDeclaration(
							newParameterizedType(EntityDescriptor.class.getName(), ast.newWildcardType()), "entityDesc"));
			SwitchStatement switchStm = newSwitchStatement(newMethodInvocation("entityDesc", "getOrdinal"));
			method.getBody().statements().add(switchStm);
			addBodyDeclaration(method);
			
			switchMap.put(type, cases = switchStm.statements());
		}
		return cases;
	}
	private Map<String, List> compositeSwitchMap = new HashMap<String, List>();
	protected List getCompositeMethodSwitch(String type) {
		List cases = compositeSwitchMap.get(type);
		if (cases == null) {
			MethodDeclaration method = newMethodDeclaration("void", type,
					newSingleVariableDeclaration(
							newParameterizedType(EntityDescriptor.class.getName(), ast.newWildcardType()), "entityDesc"),
					newSingleVariableDeclaration("int", "initialCapacity"));
			SwitchStatement switchStm = newSwitchStatement(newMethodInvocation("entityDesc", "getOrdinal"));
			method.getBody().statements().add(switchStm);
			addBodyDeclaration(method);
			
			compositeSwitchMap.put(type, cases = switchStm.statements());
		}
		return cases;
	}
	private Map<String, List> featureSwitchMap = new HashMap<String, List>();
	protected List getFeatureMethodSwitch(String type) {
		List cases = featureSwitchMap.get(type);
		if (cases == null) {
			MethodDeclaration method = newMethodDeclaration("void", type,
					newSingleVariableDeclaration(FeatureDescriptor.class.getName(), "featureDesc"));
			SwitchStatement switchStm = newSwitchStatement(newMethodInvocation("featureDesc", "getOrdinal"));
			method.getBody().statements().add(switchStm);
			addBodyDeclaration(method);
			
			featureSwitchMap.put(type, cases = switchStm.statements());
		}
		return cases;
	}
	public void addSwitchCase(List switchList, String type, String buildMethod) {
		switchList.add(newCaseStatement(newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), StringUtils.toSimpleName(type)+"_ord")));
		switchList.add(newExpressionStatement(newMethodInvocation(
				ast.newSimpleName("specificBuilder"),
				buildMethod)));
		switchList.add(ast.newBreakStatement());
	}
	public void addSwitchCase(List switchList, String type, String buildMethod, String arg) {
		switchList.add(newCaseStatement(newFieldAccess(((LanguageGenerator) generator).specificEntityDescriptorEnumName(), StringUtils.toSimpleName(type)+"_ord")));
		switchList.add(newExpressionStatement(newMethodInvocation(
				ast.newSimpleName("specificBuilder"),
				buildMethod,
				ast.newSimpleName(arg))));
		switchList.add(ast.newBreakStatement());
	}
	private Set<String> features = new HashSet<String>();
	public void addFeatureSwitchCase(List switchList, String type, String buildMethod) {
		if (!features.add(type))
			return;
		switchList.add(newCaseStatement(newFieldAccess(((LanguageGenerator) generator).specificFeatureDescriptorEnumName(), StringUtils.toSimpleName(type)+"_ord")));
		switchList.add(newExpressionStatement(newMethodInvocation(
				ast.newSimpleName("specificBuilder"),
				buildMethod)));
		switchList.add(ast.newBreakStatement());
	}
}
