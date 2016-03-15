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
package org.whole.lang.commons.visitors;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.VarType;
import org.whole.lang.commons.parsers.CommonsDataTypePresentationParser;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class CommonsContentAssistVisitor extends CommonsIdentityVisitor {
	public ContentAssistOperation getOperation() {
		return (ContentAssistOperation) super.getOperation();
	}
	protected IEntity getSelectedEntity() {
		return getOperation().getSelectedEntity();
	}

	public Set<EntityDescriptor<?>> getAllAssignableTo(EntityDescriptor<?> ed) {
		Set<EntityDescriptor<?>> assignableSet = ed.getLanguageConcreteSubtypes();
		for (ILanguageKit languageKit : ReflectionFactory.getLanguageKits(true)) {
			for (EntityDescriptor<?> candidateEd : languageKit.getEntityDescriptorEnum())
				if (ed.isPlatformSupertypeOf(candidateEd))
					assignableSet.add(candidateEd);
		}
		return assignableSet;
	}

	public void visit(VarType entity) {
		try {
			IEntity variableEntity = entity.wGetParent();
			IEntity variableEntityParent = variableEntity.wGetParent();

			Set<EntityDescriptor<?>> assignableSet = getAllAssignableTo(
					variableEntityParent.wGetEntityDescriptor(variableEntity));
			assignableSet.remove(entity.getValue());

			List<VarType> assignableEntities = new ArrayList<VarType>(assignableSet.size());
			for (EntityDescriptor<?> ed : assignableSet)
				assignableEntities.add(CommonsEntityFactory.instance.createVarType(ed));

			Collections.sort(assignableEntities, new Comparator<VarType>() {
				public int compare(VarType e1, VarType e2) {
					return CommonsDataTypePresentationParser.unparseEntityDescriptor(e1.getValue()).compareToIgnoreCase(CommonsDataTypePresentationParser.unparseEntityDescriptor(e2.getValue()));
				}
			});

			getOperation().setResult(assignableEntities.toArray(new IEntity[0]));
		} catch (Exception e) {
			// do nothing on error
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void visit(Resolver entity) {
		IEntity parent = entity.wGetParent();

		//FIXME StackOverflow WAS if (EntityUtils.isResolver(parent))
		if (parent.wGetLanguageKit().equals(entity.wGetLanguageKit()))
			return;

		IEntityAdapter adapter = null;

		//FIXME workaround to get the entity's adapter
		if (parent instanceof Collection) {
			for (Object child : (Collection) parent)
				if (child instanceof IEntityAdapter && entity.equals(((IEntityAdapter) child).wGetAdaptee(false))) {
					adapter = (IEntityAdapter) child;
					break;
				}
		} else {
			for (Method method : parent.getClass().getMethods())
				if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
					try {
						Object child = method.invoke(parent, new Object[0]);
						if (child instanceof IEntityAdapter && entity.equals(((IEntityAdapter) child).wGetAdaptee(false))) {
							adapter = (IEntityAdapter) child;
							break;
						}
					} catch (Exception e) {
					}
				}
		}
		//FIXME end workaround

		if (adapter != null)
			getOperation().stagedVisit(adapter);
		else if (parent.wGetLanguageKit().isDynamic())
			getOperation().getVisitor(parent, getOperation().getStage()).visit(entity);
	}
}
