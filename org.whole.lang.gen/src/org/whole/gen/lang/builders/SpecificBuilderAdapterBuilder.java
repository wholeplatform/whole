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

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.builders.BuilderConstants;
import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class SpecificBuilderAdapterBuilder extends AbstractBuilderBuilder {
	public SpecificBuilderAdapterBuilder(LanguageGenerator generator) {
		super(generator);

		addClassDeclaration(generator.specificBuilderAdapterName(), GenericBuilderContext.class.getName());
		addSuperInterface(generator.specificBuilderInterfaceName());

		//costructors
		MethodDeclaration constructor = addConstructorDeclaration();
		constructor.parameters().add(newSingleVariableDeclaration(IBuilder.class.getName(), "strategy"));
		SuperConstructorInvocation superCall = newSuperConstructorInvocation();
		superCall.arguments().add(ast.newSimpleName("strategy"));
		constructor.getBody().statements().add(superCall);

		constructor = addConstructorDeclaration();
		constructor.parameters().add(newSingleVariableDeclaration(IBuilder.class.getName(), "strategy"));
		constructor.parameters().add(newSingleVariableDeclaration(IEntityContext.class.getName(), "entityContext"));
		superCall = newSuperConstructorInvocation();
		superCall.arguments().add(ast.newSimpleName("strategy"));
		superCall.arguments().add(ast.newSimpleName("entityContext"));
		constructor.getBody().statements().add(superCall);

		// generic visit
		addBodyDeclaration(newMethodDeclaration("void", "visit"));
	}

    protected MethodDeclaration newSelectMethodDeclaration(String name) {
    	MethodDeclaration method = super.newMethodDeclaration(BuilderConstants.resultTypeName(), name);
		addStatement(newMethodInvocation(BuilderConstants.selectName(), newFeatureDescriptorExpression(name)));	
    	return method;
    }

    protected MethodDeclaration newBuildMethodDeclaration(String type) {
		MethodDeclaration method = super.newBuildMethodDeclaration(type);
		addStatement(newMethodInvocation(BuilderConstants.buildName(), newEntityDescriptorExpression(type)));	
		return method;
    }
    protected MethodDeclaration newBuildByNameMethodDeclaration(String type) {
		MethodDeclaration method = super.newBuildByNameMethodDeclaration(type);
		addStatement(newMethodInvocation(BuilderConstants.buildName(), ast.newSimpleName("featureDesc"), newEntityDescriptorExpression(type)));	
		return method;
    }
    protected MethodDeclaration newStartBuildMethodDeclaration(String type) {
		MethodDeclaration method = super.newStartBuildMethodDeclaration(type);
		addStatement(newMethodInvocation(BuilderConstants.startBuildName(), newEntityDescriptorExpression(type)));		
		return method;
    }
    protected MethodDeclaration newStartBuildByNameMethodDeclaration(String type) {
		MethodDeclaration method = super.newStartBuildByNameMethodDeclaration(type);
		addStatement(newMethodInvocation(BuilderConstants.startBuildName(), ast.newSimpleName("featureDesc"), newEntityDescriptorExpression(type)));
		return method;
    }
    protected MethodDeclaration newStartBuildCompositeMethodDeclaration(String type) {
		MethodDeclaration method = super.newStartBuildCompositeMethodDeclaration(type);
		addStatement(newMethodInvocation(BuilderConstants.startBuildName(), newEntityDescriptorExpression(type),
				ast.newSimpleName("initialCapacity")));		
		//TODO add emsureCapacity to body

		return method;
    }
    protected MethodDeclaration newStartBuildCompositeByNameMethodDeclaration(String type) {
		MethodDeclaration method = super.newStartBuildCompositeByNameMethodDeclaration(type);
		addStatement(newMethodInvocation(BuilderConstants.startBuildName(), ast.newSimpleName("featureDesc"),
				newEntityDescriptorExpression(type),
				ast.newSimpleName("initialCapacity")));
		//TODO add emsureCapacity to body
		
		return method;
    }
    protected MethodDeclaration newEndBuildMethodDeclaration(String type) {
		MethodDeclaration method = super.newEndBuildMethodDeclaration(type);
		addStatement(newMethodInvocation(BuilderConstants.endBuildName(), newEntityDescriptorExpression(type)));
		return method;
    }
    protected MethodDeclaration newBuildValueMethodDeclaration(String type, String primitiveType) {
		MethodDeclaration method = super.newBuildValueMethodDeclaration(type, primitiveType);
		addStatement(newMethodInvocation(BuilderConstants.buildName(), newEntityDescriptorExpression(type), ast.newSimpleName("value")));
		return method;
   }
    protected MethodDeclaration newBuildValueByNameMethodDeclaration(String type, String primitiveType) {
		MethodDeclaration method = super.newBuildValueByNameMethodDeclaration(type, primitiveType);
		addStatement(newMethodInvocation(BuilderConstants.buildName(), ast.newSimpleName("featureDesc"), newEntityDescriptorExpression(type), ast.newSimpleName("value")));		
		return method;
   }

	public void addPrimitiveFeature(String type, String primitiveType, String name) {
		addBodyDeclaration(newBuildMethodDeclaration(type));		
		if (primitiveType.endsWith("Enum.Value")) {
			//addBodyDeclaration(newBuildValueMethodDeclaration(type, newSimpleQualifiedType(primitiveType)));			
			addBodyDeclaration(super.newBuildValueMethodDeclaration(type, newSimpleQualifiedType(primitiveType)));
			addStatement(newMethodInvocation(BuilderConstants.buildName(), newEntityDescriptorExpression(type), ast.newSimpleName("value")));

			addBodyDeclaration(super.newBuildValueMethodDeclaration(type, "String"));
			addStatement(newMethodInvocation(BuilderConstants.buildName(), newEntityDescriptorExpression(type), ast.newSimpleName("value")));
		} else if (primitiveType.equals(EntityDescriptor.class.getName())) {
			addBodyDeclaration(super.newBuildValueMethodDeclaration(type, newType(primitiveType)));
			addStatement(newMethodInvocation(BuilderConstants.buildName(), newEntityDescriptorExpression(type), ast.newSimpleName("value")));

			addBodyDeclaration(super.newBuildValueMethodDeclaration(type, "String"));
			addStatement(newMethodInvocation(type, newMethodInvocation(newFieldAccess(generator.specificEntityDescriptorEnumName(), "instance"), "valueOf", ast.newSimpleName("value"))));
		} else {
			addBodyDeclaration(newBuildValueMethodDeclaration(type, primitiveType));
			if (!StringUtils.isPrimitiveOrString(primitiveType)) {
				addBodyDeclaration(super.newBuildValueMethodDeclaration(type, "String"));
				addStatement(newMethodInvocation(BuilderConstants.buildName(), newEntityDescriptorExpression(type), ast.newSimpleName("value")));				
			}
		}
	}
}
