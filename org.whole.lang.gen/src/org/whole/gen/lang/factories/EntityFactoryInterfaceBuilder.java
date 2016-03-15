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

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.factories.IEntityFactory;

/**
 * @author Riccardo Solmi
 */
public class EntityFactoryInterfaceBuilder extends CompilationUnitBuilder {
	public EntityFactoryInterfaceBuilder(LanguageGenerator generator) {
		super(generator);
		
		addInterfaceDeclaration(generator.entityFactoryInterfaceName(), IEntityFactory.class.getName());
		addImportDeclaration(generator.modelPackage(), true);
//		addSingletonField(generator.entityFactoryName());
	}
	
	public MethodDeclaration addFactoryMethod(String entityType) {
		return super.addFactoryMethod(entityType, generator.entityImplName(entityType));
	}
}
