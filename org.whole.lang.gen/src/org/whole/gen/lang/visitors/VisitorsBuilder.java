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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.gen.lang.builders.BuilderInterfaceBuilder;
import org.whole.gen.lang.builders.GenericBuilderAdapterBuilder;
import org.whole.gen.lang.builders.SpecificBuilderAdapterBuilder;
import org.whole.lang.model.AbstractEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class VisitorsBuilder extends AbstractEntity {
	private List<AbstractVisitorCompilationUnitBuilder> visitors = new ArrayList<AbstractVisitorCompilationUnitBuilder>();

	private VisitorInterfaceBuilder visitorInterfaceBuilder;

	public VisitorsBuilder(LanguageGenerator generator) {
		visitors.add(visitorInterfaceBuilder = new VisitorInterfaceBuilder(
				generator));
		visitors.add(new FailureVisitorBuilder(generator));
		visitors.add(new IdentityVisitorBuilder(generator));
		visitors.add(new IdentityUnaryVisitorBuilder(generator));
		visitors.add(new IdentityDefaultVisitorBuilder(generator));
		visitors.add(new IdentitySwitchVisitorBuilder(generator));

		visitors.add(new ForwardStagedVisitorBuilder(generator));
		visitors.add(new ForwardGenericVisitorBuilder(generator));
		visitors.add(new ForwardStrategyVisitorBuilder(generator));

		visitors.add(new SequenceVisitorBuilder(generator));
		visitors.add(new TraverseAllVisitorBuilder(generator));
		visitors.add(new TraverseAllChildrenVisitorBuilder(generator));
		visitors.add(new TraverseAllAdjacentsVisitorBuilder(generator));
		visitors.add(new TraverseAllSwitchVisitorBuilder(generator));

		visitors.add(new BuilderInterfaceBuilder(generator));
		// visitors.add(new IdentityBuilderContextBuilder(generator));
		visitors.add(new GenericBuilderAdapterBuilder(generator));
		visitors.add(new SpecificBuilderAdapterBuilder(generator));
		// visitors.add(new CodebaseBuilderBuilder(generator));
	}

	public CompilationUnit getVisitorInterface() {
		return visitorInterfaceBuilder.getCompilationUnit();
	}

	public void addType(String eName, String eType) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next()).addType(eName,
					eType);
	}

	public void addSimpleEntity(String name) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addSimpleEntity(name);
	}

	public void addCompositeEntity(String name, String componentType, boolean isOrdered, boolean isByReference) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addCompositeEntity(name, componentType, isOrdered, isByReference);
	}

	public void addMapEntity(String name, String keyType, String valueType) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next()).addMapEntity(
					name, keyType, valueType);
	}

	public void addFragmentEntity(String name) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addFragmentEntity(name);
	}

	public void addPrimitiveEntity(String name) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addPrimitiveEntity(name);
	}
	public void addEnumEntity(String eName, String fType, String fName) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addEnumEntity(eName, fType, fName);
	}
	public void addResolverEntity(String name) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addResolverEntity(name);
	}

	public void addFeature(String eName, String fType, String fName, String name, boolean isByReference) {
		if (StringUtils.isPrimitiveOrString(fType))
			addPrimitiveFeature(eName, fType, fName);
		else
			addStructuralFeature(eName, fType, fName, name, isByReference);
	}

	public void addStructuralFeature(String eName, String fType, String fName, String name, boolean isByReference) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addStructuralFeature(eName, fType, fName, name, isByReference);
	}

	public void addPrimitiveFeature(String eName, String fType, String fName) {
		Iterator i = visitors.iterator();
		while (i.hasNext())
			((AbstractVisitorCompilationUnitBuilder) i.next())
					.addPrimitiveFeature(eName, fType, fName);
	}

	@Override
	public EntityDescriptor<?> wGetEntityDescriptor() {
		throw new UnsupportedOperationException();
	}
}
