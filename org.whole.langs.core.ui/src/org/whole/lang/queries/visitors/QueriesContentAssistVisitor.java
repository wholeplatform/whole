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
package org.whole.lang.queries.visitors;

import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.Icon;
import static org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum.SubgroupAction;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.AtFeatureTest;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.AtTypeTest;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.Bind;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.Bindings;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.EntityCall_ord;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.EntityTemplate_ord;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.EntityType;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.ExtendedSubtypeTest;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.ExtendedSupertypeTest;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.FeatureStep;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.LanguageTest;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.SubtypeTest;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.SupertypeTest;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.TypeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKindEnum;
import org.whole.lang.actions.model.Actions;
import org.whole.lang.actions.model.GroupAction;
import org.whole.lang.actions.ui.factories.ActionsUIEntityFactory;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.AtFeatureTest;
import org.whole.lang.queries.model.AtTypeTest;
import org.whole.lang.queries.model.EntityCall;
import org.whole.lang.queries.model.EntityTemplate;
import org.whole.lang.queries.model.EntityType;
import org.whole.lang.queries.model.ExtendedSubtypeTest;
import org.whole.lang.queries.model.ExtendedSupertypeTest;
import org.whole.lang.queries.model.FeatureStep;
import org.whole.lang.queries.model.LanguageTest;
import org.whole.lang.queries.model.Name;
import org.whole.lang.queries.model.SubtypeTest;
import org.whole.lang.queries.model.SupertypeTest;
import org.whole.lang.queries.model.TypeTest;
import org.whole.lang.queries.model.VariableRefStep;
import org.whole.lang.queries.model.VariableTest;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.actions.IActionConstants;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class QueriesContentAssistVisitor extends QueriesIdentityVisitor {

	public ContentAssistOperation getOperation() {
		return (ContentAssistOperation) super.getOperation();
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
		allFeatureTypes(entity, FeatureStep);
		allFeatureTypes(entity, AtFeatureTest);
		allEntityTypes(entity, AtTypeTest);
		allEntityTypes(entity, EntityType);
		allEntityTypes(entity, TypeTest);
		allEntityTypes(entity, SubtypeTest);
		allEntityTypes(entity, SupertypeTest);
		allEntityTypes(entity, ExtendedSubtypeTest);
		allEntityTypes(entity, ExtendedSupertypeTest);
		return false;
	}

	@Override
	public void visit(Name entity) {
		IEntity bindEntity = entity.wGetParent();
		if (!Matcher.match(Bind, bindEntity))
			return;
		IEntity bindingsEntity = bindEntity.wGetParent();
		if (!Matcher.match(Bindings, bindingsEntity))
			return;
		
		EntityType entityType;
		boolean allLanguageFeatures;
		IEntity entityCallOrTemplateEntity = bindingsEntity.wGetParent();
		switch (entityCallOrTemplateEntity.wGetEntityDescriptor().getOrdinal()) {
		case EntityCall_ord: 
			entityType = ((EntityCall) entityCallOrTemplateEntity).getName();
			allLanguageFeatures = true;
			break;
		case EntityTemplate_ord: 
			entityType = ((EntityTemplate) entityCallOrTemplateEntity).getName();
			allLanguageFeatures = false;
			break;
		default:
			return;
		}
		if (!DataTypeUtils.getDataKind(entityType).isString())
			return;
		String edUri = entityType.wStringValue();

		TreeSet<String> sortedNames = new TreeSet<String>();
		EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, false, null);
		if (allLanguageFeatures || ed == null) {
			ILanguageKit lk = CommonsDataTypePersistenceParser.getLanguageKitPart(edUri);
			if (lk == null)
				return;

			Set<String> fNames = lk.getFeatureDescriptorEnum().names();
			sortedNames.addAll(fNames);
		} else
			for (FeatureDescriptor fd : ed.getEntityFeatureDescriptors())
				sortedNames.add(fd.getName());
		allFeatureNames(sortedNames, entity.getValue());
	}

	@Override
	public void visit(FeatureStep entity) {
		allFeatureTypes(entity, FeatureStep);
	}

	@Override
	public void visit(AtFeatureTest entity) {
		allFeatureTypes(entity, AtFeatureTest);
	}

	@Override
	public void visit(AtTypeTest entity) {
		allEntityTypes(entity, AtTypeTest);
	}

	@Override
	public void visit(EntityType entity) {
		allEntityTypes(entity, EntityType);
	}

	@Override
	public void visit(TypeTest entity) {
		allEntityTypes(entity, TypeTest);
	}

	@Override
	public void visit(SubtypeTest entity) {
		allEntityTypes(entity, SubtypeTest);
	}

	@Override
	public void visit(SupertypeTest entity) {
		allEntityTypes(entity, SupertypeTest);
	}

	@Override
	public void visit(ExtendedSubtypeTest entity) {
		allEntityTypes(entity, ExtendedSubtypeTest);
	}

	@Override
	public void visit(ExtendedSupertypeTest entity) {
		allEntityTypes(entity, ExtendedSupertypeTest);
	}

	@Override
	public void visit(LanguageTest entity) {
		String actualLanguageURI = entity.getValue();

		ActionsUIEntityFactory aef = ActionsUIEntityFactory.instance;
		GroupAction languagesGroup = aef.createGroupAction();
		languagesGroup.setFillStrategy(aef.createHierarchical(
				aef.createDistinctPrefix(), aef.createSize(10)));
		languagesGroup.getText().setValue("queries.languages");

		Actions actions = aef.createActions(0);
		QueriesEntityFactory qef = QueriesEntityFactory.instance;

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			String languageURI = languageKit.getURI();
			if (languageURI.equals(actualLanguageURI))
				continue;

			actions.wAdd(aef.createReplaceDifferentTemplateAction(
					qef.create(LanguageTest, languageURI),
					ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit),
					IActionConstants.SELECT_LANGUAGE_ICON));
		}
		languagesGroup.setActions(actions);
		mergeResult(languagesGroup);
	}

	private boolean allEntityTypes(IEntity entity, EntityDescriptor<?> type) {
		if (!EntityUtils.hasParent(entity))
			return false;

		EntityDescriptor<?> featureED = entity.wGetParent().wGetEntityDescriptor(entity);
		if (!featureED.isPlatformSupertypeOf(EntityType) && !featureED.isPlatformSupertypeOf(TypeTest) &&
				!featureED.isPlatformSupertypeOf(SubtypeTest) && !featureED.isPlatformSupertypeOf(SupertypeTest) &&
				!featureED.isPlatformSupertypeOf(ExtendedSubtypeTest) && !featureED.isPlatformSupertypeOf(ExtendedSupertypeTest))
			return false;

		boolean alltypesTest = (type == SubtypeTest || type == SupertypeTest ||
				type == ExtendedSubtypeTest || type == ExtendedSupertypeTest || type == AtTypeTest);

		ActionsUIEntityFactory aef = ActionsUIEntityFactory.instance;
		GroupAction languagesGroup = aef.createGroupAction();
		languagesGroup.setFillStrategy(aef.createHierarchical(
				aef.createDistinctPrefix(), aef.createSize(10)));
		languagesGroup.getText().setValue("queries.languages");

		Actions actions = aef.createActions(0);
		QueriesEntityFactory qef = QueriesEntityFactory.instance;

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
				if (alltypesTest)
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

			IEntity prototype = qef.create(targetED,
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
			typenamesGroup.getText().setValue(alltypesTest ? "queries.alltypenames" :
				"queries.typenames");

			actions = aef.createActions(0);
			EntityDescriptorEnum edEnum = actualED.getEntityDescriptorEnum();
			List<EntityDescriptor<?>> eds = new ArrayList<EntityDescriptor<?>>(edEnum.values());
			Collections.sort(eds, EnumValueImpl.getByNameComparator());
			for (EntityDescriptor<?> ed : eds) {
				if (ed.equals(actualED) || (!alltypesTest && ed.isAbstract()))
					continue;
				IEntity prototype = qef.create(targetED,
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

	private boolean allFeatureNames(SortedSet<String> fNames, String actualFName) {
		ActionsUIEntityFactory aef = ActionsUIEntityFactory.instance;
		QueriesEntityFactory qef = QueriesEntityFactory.instance;

		GroupAction featurenamesGroup = aef.createGroupAction();
		featurenamesGroup.setFillStrategy(aef.createHierarchical(
				aef.createDistinctPrefix(), aef.createSize(10)));
		featurenamesGroup.getText().setValue("queries.featurenames");

		Actions actions = aef.createActions(0);
		for (String fName : fNames) {
			if (fName.equals(actualFName))
				continue;
			Name prototype = qef.createName(fName);
			actions.wAdd(aef.createReplaceDifferentTemplateAction(prototype, fName));
		}

		featurenamesGroup.setActions(actions);
		return mergeResult(featurenamesGroup);
	}

	private boolean allFeatureTypes(IEntity entity, EntityDescriptor<?> targetEd) {
		if (!EntityUtils.hasParent(entity) ||
				!entity.wGetParent().wGetEntityDescriptor(entity)
				.isPlatformSupertypeOf(targetEd))
			return false;
		
		ActionsUIEntityFactory aef = ActionsUIEntityFactory.instance;
		GroupAction languagesGroup = aef.createGroupAction();
		languagesGroup.setFillStrategy(aef.createHierarchical(
				aef.createDistinctPrefix(), aef.createSize(10)));
		languagesGroup.getText().setValue("queries.languages");

		Actions actions = aef.createActions(0);
		QueriesEntityFactory qef = QueriesEntityFactory.instance;

		String actualLanguageURI = "";
		String actualFeatureName = "";
		FeatureDescriptor actualFD = null;
		try {
			actualFD = CommonsDataTypePersistenceParser
					.parseFeatureDescriptor(entity.wStringValue());
			actualLanguageURI = actualFD.getLanguageKit().getURI();
			actualFeatureName = actualFD.getName();
		} catch (Exception e) {
			if (DataTypeUtils.getDataKind(entity).isString())
				actualFeatureName = entity.wStringValue();
		}

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			if (languageKit.getURI().equals(actualLanguageURI))
				continue;

			FeatureDescriptorEnum fdEnum = languageKit.getFeatureDescriptorEnum();
			if (fdEnum.values().isEmpty())
				continue;

			FeatureDescriptor fd = null;
			if (actualFeatureName.length() > 0)
				fd = fdEnum.valueOf(actualFeatureName);
			if (fd == null)
				fd = fdEnum.valueOf(0);

			IEntity prototype = qef.create(targetEd,
				CommonsDataTypePersistenceParser.unparseFeatureDescriptor(fd));
			actions.wAdd(aef.createReplaceDifferentTemplateAction(
					prototype,
					ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit),
					IActionConstants.SELECT_LANGUAGE_ICON));
		}
		languagesGroup.setActions(actions);
		boolean addedLanguages = EntityUtils.isResolver(entity) ?
				mergeResult(targetEd, languagesGroup) :
					mergeResult(languagesGroup);

		if (actualFD != null) {
			GroupAction featurenamesGroup = aef.createGroupAction();
			featurenamesGroup.setFillStrategy(aef.createHierarchical(
					aef.createDistinctPrefix(), aef.createSize(10)));
			featurenamesGroup.getText().setValue("queries.featurenames");

			actions = aef.createActions(0);
			FeatureDescriptorEnum fdEnum = actualFD.getFeatureDescriptorEnum();
			List<FeatureDescriptor> fds = new ArrayList<FeatureDescriptor>(fdEnum.values());
			Collections.sort(fds, EnumValueImpl.getByNameComparator());
			for (FeatureDescriptor fd : fds) {
				if (fd.equals(actualFD))
					continue;
				IEntity prototype = qef.create(targetEd,
						CommonsDataTypePersistenceParser.unparseFeatureDescriptor(fd));
				actions.wAdd(aef.createReplaceDifferentTemplateAction(prototype, fd.getName()));
			}

			featurenamesGroup.setActions(actions);
			addedLanguages |= EntityUtils.isResolver(entity) ?
					mergeResult(targetEd, languagesGroup) :
						mergeResult(featurenamesGroup);
		}

		return addedLanguages;
	}

	@Override
	public void visit(VariableRefStep entity) {
		mergeResult(ActionsUIEntityFactory.instance.createAllVariablesGroupAction(
				ActionKindEnum.REPLACE, Collections.<String>emptySet(),
				QueriesEntityDescriptorEnum.VariableRefStep, entity));
	}

	@Override
	public void visit(VariableTest entity) {
		mergeResult(ActionsUIEntityFactory.instance.createAllVariablesGroupAction(
				ActionKindEnum.REPLACE, Collections.<String>emptySet(),
				QueriesEntityDescriptorEnum.VariableTest, entity));
	}
}
