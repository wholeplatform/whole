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
package org.whole.gen.lang.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.AbstractEntity;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class EntityFactoriesBuilder extends AbstractEntity {
	private List<CompilationUnitBuilder> factories = new ArrayList<CompilationUnitBuilder>();
	private CompilationUnitBuilder abstractFactory;
	private MethodDeclaration[] factoryMethod;
	
	public EntityFactoriesBuilder(LanguageGenerator generator) {
//		factories.add(abstractFactory = new EntityFactoryInterfaceBuilder(generator));
		factories.add(abstractFactory = new EntityFactoryBuilder(generator));
	}

	public TypeDeclaration getType() {
		return abstractFactory.getType();
	}

	protected MethodDeclaration[] addFactoryMethod(String entityType, boolean hasDefault) {
		factoryMethod = new MethodDeclaration[factories.size()];
		for (int i=0; i<factories.size(); i++) {
			CompilationUnitBuilder factory = factories.get(i);
			
			if (hasDefault)
				factory.addFactoryMethod(entityType); //defaultFactoryMethod
			factoryMethod[i] = factory.addFactoryMethod(entityType);
		}

		return factoryMethod;
	}

	// SimpleEntity
	public MethodDeclaration[] addFactoryMethodWithBuild(String entityType, int featuresSize) {
		addFactoryMethod(entityType, featuresSize > 0);
		if (featuresSize > 1)
			addBuildMethod(entityType);
		return factoryMethod;
	}

	// DataEntity, EnumEntity
	public MethodDeclaration[] addFactoryMethodWithCase(String entityType, String fType, String fName) {
		return addFactoryMethodWithCase(entityType, fType, fName, false);
	}
	public MethodDeclaration[] addFactoryMethodWithCase(String entityType, String fType, String fName, boolean useQualifiedType) {
		addFactoryMethod(entityType, true);
		addFactoryMethodCase(fType, fName, useQualifiedType);
		return factoryMethod;
	}
	// CompositeEntity
	public MethodDeclaration[] addFactoryMethodWithVarArgsCase(String entityType, String fType, String fName) {
		addFactoryMethod(entityType, true);
		addFactoryMethodVarArgsCase(fType, fName);
		addFactoryMethodWithInitialSize(entityType);
		return factoryMethod;
	}
	// MapEntity
	public MethodDeclaration[] addFactoryMethodWithMapCase(String entityType, String keyType, String valueType) {
		addFactoryMethod(entityType, true);
		addFactoryMethodVarArgsCase(keyType, valueType);//FIXME map
		return factoryMethod;
	}

	public void addFactoryMethodWithInitialSize(String eType) {
		for (int i=0; i<factories.size(); i++) {
			CompilationUnitBuilder factory = factories.get(i);

			MethodDeclaration fm = factory.addFactoryForwardMethod(eType, "clone");
			factory.addFactoryMethodCase(fm, "int", "initialSize", false);
		}
	}

	public void addBuildMethod(String eType) {
		for (int i=0; i<factories.size(); i++) {
			CompilationUnitBuilder factory = factories.get(i);
			
			factory.addBuildMethod(eType);
		}
	}

	public void addFactoryMethodCase(String fType, String fName) {
		for (int i=0; i<factories.size(); i++) {
			CompilationUnitBuilder factory = factories.get(i);

			factory.addFactoryMethodCase(factoryMethod[i], fType, fName, false);
		}
	}
	public void addFactoryMethodCase(String fType, String fName, boolean useQualifiedType) {
		for (int i=0; i<factories.size(); i++) {
			CompilationUnitBuilder factory = factories.get(i);

			factory.addDataFactoryMethodCase(factoryMethod[i], fType, fName, useQualifiedType);
		}
	}

	public void addFactoryMethodVarArgsCase(String componentType, String fName) {
		for (int i=0; i<factories.size(); i++) {
			CompilationUnitBuilder factory = factories.get(i);
			
			factory.addFactoryMethodVarArgsCase(factoryMethod[i], componentType, fName);
		}
	}

	@Override
	public EntityDescriptor<?> wGetEntityDescriptor() {
		throw new UnsupportedOperationException();
	}
}
