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
package org.whole.lang.frames.visitors;

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Icon;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.SubgroupAction;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;
import static org.whole.lang.frames.reflect.FramesEntityDescriptorEnum.EntityType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.Actions;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.actions.ui.factories.ActionsUIEntityFactory;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.frames.factories.FramesEntityFactory;
import org.whole.lang.frames.model.EntityType;
import org.whole.lang.frames.visitors.FramesIdentityVisitor;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.actions.IActionConstants;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class FramesContentAssistVisitor extends FramesIdentityVisitor {
	@Override
	public ContentAssistOperation getOperation() {
		return (ContentAssistOperation) super.getOperation();
	}

	protected void addResult(Action action) {
		IEntity[] result = getOperation().getResult();
		if (result.length == 0) {
			result = new IEntity[] { ActionsEntityFactory.instance.createActions(0) };
			getOperation().setResult(result);
		}
		
		result[0].wAdd(Matcher.match(SubgroupAction, action) ? action :
				ActionsEntityFactory.instance.createSeparatedAction(action));
	}
	protected boolean mergeResult(EntityDescriptor<?> subgroupED, Action action) {
		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		return mergeResult(aef.createSubgroupAction(createResolver(Icon),
				aef.createText(subgroupED.getName()), aef.createFlat(),
				aef.createActions(action)));
	}
	protected boolean mergeResult(Action action) {
		IEntity[] result = getOperation().getResult();
		if (result == null || result.length == 0)
			result = new IEntity[] { ActionsEntityFactory.instance.createActions(0)};
		
		result[0].wAdd(Matcher.match(SubgroupAction, action) ? action :
				ActionsEntityFactory.instance.createSeparatedAction(action));

		getOperation().setResult(result);
		return true;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		allEntityTypes(entity, EntityType);
		return false;
	}

	@Override
	public void visit(EntityType entity) {
		allEntityTypes(entity, EntityType);
	}

	private boolean allEntityTypes(IEntity entity, EntityDescriptor<?> type) {
		if (!EntityUtils.hasParent(entity))
			return false;

		boolean subtypeTest = false;

		ActionsUIEntityFactory aef = ActionsUIEntityFactory.instance;
		GroupAction languagesGroup = aef.createGroupAction();
		languagesGroup.setFillStrategy(aef.createHierarchical(
				aef.createDistinctPrefix(), aef.createSize(10)));
		languagesGroup.getText().setValue("frames.languages");

		Actions actions = aef.createActions(0);
		FramesEntityFactory fef = FramesEntityFactory.instance;

		String actualLanguageURI = "";
		String actualEntityName = "";
		EntityDescriptor<?> actualED = null;
		EntityDescriptor<?> targetED = type;
		try {
			actualED = CommonsDataTypePersistenceParser.parseEntityDescriptor(
					entity.wStringValue());
			actualLanguageURI = actualED.getLanguageKit().getURI();
			actualEntityName = actualED.getName();
		} catch (Exception e) {
			if (DataTypeUtils.getDataKind(entity).isString())
				actualEntityName = entity.wStringValue();
		}

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			if (languageKit.getURI().equals(actualLanguageURI))
				continue;

			EntityDescriptorEnum edEnum = languageKit.getEntityDescriptorEnum();
			EntityDescriptor<?> ed = null;
			if (actualEntityName.length() > 0)
				ed = edEnum.valueOf(actualEntityName);
			if (ed == null) {
				if (subtypeTest)
					ed = edEnum.valueOf(0);
				else {
					Iterator<EntityDescriptor<?>> iterator = edEnum.values().iterator();
					EntityDescriptor<?> nextED;
					while (ed == null && iterator.hasNext())
						if (!(nextED = iterator.next()).isAbstract())
							ed = nextED;
					if (ed == null)
						continue;
				}
			}

			IEntity prototype = fef.create(targetED,
				CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed));
			actions.wAdd(aef.createReplaceDifferentTemplateAction(
					prototype,
					ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit),
					IActionConstants.SELECT_LANGUAGE_ICON));
		}
		languagesGroup.setActions(actions);
		boolean addedLanguages = EntityUtils.isResolver(entity) ?
				mergeResult(targetED, languagesGroup) :
					mergeResult(languagesGroup);

		if (actualED != null) {
			GroupAction typenamesGroup = aef.createGroupAction();
			typenamesGroup.setFillStrategy(aef.createHierarchical(
					aef.createDistinctPrefix(), aef.createSize(10)));
			typenamesGroup.getText().setValue(subtypeTest ? "frames.subtypenames" :
				"frames.typenames");

			actions = aef.createActions(0);
			EntityDescriptorEnum edEnum = actualED.getEntityDescriptorEnum();
			List<EntityDescriptor<?>> eds = new ArrayList<EntityDescriptor<?>>(edEnum.values());
			Collections.sort(eds, EnumValueImpl.getByNameComparator());
			for (EntityDescriptor<?> ed : eds) {
				if (ed.equals(actualED) || (!subtypeTest && ed.isAbstract()))
					continue;
				IEntity prototype = fef.create(targetED,
						CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed));
				actions.wAdd(aef.createReplaceDifferentTemplateAction(prototype, ed.getName()));
			}

			typenamesGroup.setActions(actions);
			addedLanguages |= EntityUtils.isResolver(entity) ?
					mergeResult(targetED, typenamesGroup) :
						mergeResult(typenamesGroup);
		}

		return addedLanguages;
	}
}
