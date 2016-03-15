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

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.gen.lang.visitors.AbstractVisitorCompilationUnitBuilder;
import org.whole.lang.builders.BuilderConstants;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractBuilderBuilder extends AbstractVisitorCompilationUnitBuilder {
	public AbstractBuilderBuilder(LanguageGenerator generator) {
		super(generator);
	}
	
	protected Expression newEntityDescriptorExpression(String type) {
		return newFieldAccess(generator.specificEntityDescriptorEnumName(), type);
	}
	protected Expression newFeatureDescriptorExpression(FeatureDescriptor featureDesc) {
		return newFeatureDescriptorExpression(featureDesc.getName());
	}
	protected Expression newFeatureDescriptorExpression(String name) {
		return newFieldAccess(generator.specificFeatureDescriptorEnumName(), name);
	}

    protected MethodDeclaration newSelectMethodDeclaration(String name) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), name);
    }

    protected MethodDeclaration newBuildMethodDeclaration(String type) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.buildName(type));
    }
    protected MethodDeclaration newBuildByNameMethodDeclaration(String type) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.buildName(type),
		        newSingleVariableDeclaration(generator.featureDescriptorName(), "featureDesc"));
    }
    protected MethodDeclaration newStartBuildMethodDeclaration(String type) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.startBuildName(type));
    }
    protected MethodDeclaration newStartBuildByNameMethodDeclaration(String type) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.startBuildName(type),
		        newSingleVariableDeclaration(generator.featureDescriptorName(), "featureDesc"));
    }
    protected MethodDeclaration newStartBuildCompositeMethodDeclaration(String type) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.startBuildName(type),
				newSingleVariableDeclaration("int", "initialCapacity"));
    }
    protected MethodDeclaration newStartBuildCompositeByNameMethodDeclaration(String type) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.startBuildName(type),
		        newSingleVariableDeclaration(generator.featureDescriptorName(), "featureDesc"),
				newSingleVariableDeclaration("int", "initialCapacity"));
    }
    protected MethodDeclaration newEndBuildMethodDeclaration(String type) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.endBuildName(type));
    }
    protected MethodDeclaration newBuildValueMethodDeclaration(String type, String primitiveType) {
		return newBuildValueMethodDeclaration(type, newType(primitiveType));
   }
    protected MethodDeclaration newBuildValueMethodDeclaration(String type, Type primitiveType) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.buildName(type),
				newSingleVariableDeclaration(primitiveType, "value"));
   }
    protected MethodDeclaration newBuildValueByNameMethodDeclaration(String type, String primitiveType) {
		return newMethodDeclaration(BuilderConstants.resultTypeName(), BuilderConstants.buildName(type),
		        newSingleVariableDeclaration(generator.featureDescriptorName(), "featureDesc"),
		        newSingleVariableDeclaration(primitiveType, "value"));
   }

	
	// TODO test never called
	public MethodDeclaration addEntity(String type) {
		MethodDeclaration method;
		addBodyDeclaration(method = newBuildMethodDeclaration(StringUtils.toSimpleName(type)));		
		return method;
	}
	public MethodDeclaration addSimpleEntity(String type) {
		MethodDeclaration method;
		addBodyDeclaration(method = newBuildMethodDeclaration(type));	
//		addBodyDeclaration(newBuildByNameMethodDeclaration(type));		
		addBodyDeclaration(newStartBuildMethodDeclaration(type));		
//		addBodyDeclaration(newStartBuildByNameMethodDeclaration(type));		
		addBodyDeclaration(newEndBuildMethodDeclaration(type));		
		return method;
	}
	public MethodDeclaration addCompositeEntity(String type, String componentType, boolean isOrdered, boolean isByReference) {
		MethodDeclaration method;
		addBodyDeclaration(method = newBuildMethodDeclaration(type));		
//		addBodyDeclaration(newBuildByNameMethodDeclaration(type));		
		addBodyDeclaration(newStartBuildMethodDeclaration(type));		
//		addBodyDeclaration(newStartBuildByNameMethodDeclaration(type));		

		addBodyDeclaration(newStartBuildCompositeMethodDeclaration(type));		
//		addBodyDeclaration(newStartBuildCompositeByNameMethodDeclaration(type));		
		
		addBodyDeclaration(newEndBuildMethodDeclaration(type));		
		return method;
	}

	public MethodDeclaration addFragmentEntity(String type) {
		return addSimpleEntity(StringUtils.toSimpleName(type));
	}
	public MethodDeclaration addResolverEntity(String type) {
		MethodDeclaration method;
		addBodyDeclaration(method = newBuildMethodDeclaration(StringUtils.toSimpleName(type)));	
	    return method;
	}

	public MethodDeclaration addPrimitiveEntity(String type) {
		return null;
	}
	public void addPrimitiveFeature(String type, String primitiveType, String name) {
		addBodyDeclaration(newBuildMethodDeclaration(type));		
		if (primitiveType.endsWith("Enum.Value")) {
			addBodyDeclaration(newBuildValueMethodDeclaration(type, newSimpleQualifiedType(primitiveType)));			
			addBodyDeclaration(newBuildValueMethodDeclaration(type, "String"));			
		} else if (primitiveType.equals(EntityDescriptor.class.getName())) {
			addBodyDeclaration(newBuildValueMethodDeclaration(type, newQualifiedType(primitiveType)));			
			addBodyDeclaration(newBuildValueMethodDeclaration(type, "String"));			
		} else {
			addBodyDeclaration(newBuildValueMethodDeclaration(type, primitiveType));	
			if (!StringUtils.isPrimitiveOrString(primitiveType)) {
				addBodyDeclaration(newBuildValueMethodDeclaration(type, "String"));			
			}
		}
	}
	
	protected int featuresStartIndex = 2;
	protected Set features = new HashSet();
	public void addStructuralFeature(String eName, String fType, String fName, String name, boolean isByReference) {
		if (features.add(fName))
			addBodyDeclaration(featuresStartIndex, newSelectMethodDeclaration(fName));		
	}
}
