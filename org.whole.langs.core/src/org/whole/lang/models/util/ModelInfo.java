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
package org.whole.lang.models.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.ScannerIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclaration;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.Type;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class ModelInfo {
	public final Map<String, String> entityNameImplNameMap = new HashMap<String, String>();
	public final Map<String, String> featureNameImplNameMap = new HashMap<String, String>();
	public final List<String> entityNameList = new ArrayList<String>();
	public final List<String> featureNameList = new ArrayList<String>();
	public final Set<String> featureNames = new HashSet<String>();

	public final Map<String, IEntity> nameEntityMap = new HashMap<String, IEntity>();

	public final Set<String> definedTypes = new HashSet<String>();
	public final Set<String> referencedTypes = new HashSet<String>();
	public final Set<String> undefinedTypes = new HashSet<String>();
	public final Set<String> unreferencedTypes = new HashSet<String>();

	public final Map<String, Set<String>> superTypes = new HashMap<String, Set<String>>(); //without self
	public final Map<String, Set<String>> subTypes = new HashMap<String, Set<String>>(); //without self
	public final Map<String, Set<String>> allSuperTypes = new HashMap<String, Set<String>>();
	public final Map<String, Set<String>> allSubTypes = new HashMap<String, Set<String>>();

	public final Set<String> markerTypes = new HashSet<String>();
	public final Set<String> abstractTypes = new HashSet<String>();
	
	public final Set<String> simpleEntityTypes = new HashSet<String>();
	public final Map<String, Set<String>> simpleEntityOrigFeatures = new HashMap<String, Set<String>>();
	public final Map<String, Set<String>> simpleEntityFeatures = new HashMap<String, Set<String>>();

	public ModelInfo(Model model) {
		FreshNameGenerator entityNameGen = new FreshNameGenerator();
		FreshNameGenerator featureNameGen = new FreshNameGenerator();

		ScannerIterator<ModelDeclaration> i = IteratorFactory.<ModelDeclaration>childScannerIterator();
		i.reset(model.getDeclarations());
		for (ModelDeclaration md : i) {
			SimpleName simpleName;
			if (!DataTypeUtils.getDataKind(simpleName = md.getName()).isString())
				continue;

			String entityName = simpleName.wStringValue();
			nameEntityMap.put(entityName, md);
			definedTypes.add(entityName);
			entityNameList.add(entityName);
			if (StringUtils.isValidEntityName(entityName))
				entityNameGen.putBoundName(entityName);

			if (md.getModifiers().wContainsValue(EntityModifierEnum._abstract))
				abstractTypes.add(entityName);

			AbstractPatternFilterIterator<Type> i3 = IteratorFactory.<Type>childMatcherIterator()
					.withPattern(ModelsEntityDescriptorEnum.SimpleName);
			i3.reset(md.getTypes());
			for (Type type : i3) {
				String typeName = type.wStringValue();
				referencedTypes.add(typeName);
				superTypes(entityName).add(typeName);
				subTypes(typeName).add(entityName);
			}

			if (Matcher.match(ModelsEntityDescriptorEnum.SimpleEntity, md)) {
				SimpleEntity se = (SimpleEntity) md;
				simpleEntityTypes.add(entityName);
				
				if (se.getFeatures().wIsEmpty())
					markerTypes.add(entityName);

				Set<String> featureNameSet = new HashSet<String>();
				ScannerIterator<Feature> i2 = IteratorFactory.<Feature>childScannerIterator();
				i2.reset(se.getFeatures());
				for (Feature feature : i2) {
					SimpleName featureName = feature.getName();
					if (!Matcher.match(ModelsEntityDescriptorEnum.SimpleName, featureName))
						continue;
					
					String fName = featureName.wStringValue();
					featureNameSet.add(fName);
					if (featureNames.add(fName))
						featureNameList.add(fName);
					if (StringUtils.isValidFeatureName(fName))
						featureNameGen.putBoundName(fName);

					Type featureType = feature.getType();
					if (Matcher.match(ModelsEntityDescriptorEnum.SimpleName, featureType))
						referencedTypes.add(featureType.wStringValue());
				}
				simpleEntityOrigFeatures.put(entityName, featureNameSet);
				simpleEntityFeatures.put(entityName, new HashSet<String>(featureNameSet));

			} else if (Matcher.match(ModelsEntityDescriptorEnum.CompositeEntity, md)) {
				CompositeEntity ce = (CompositeEntity) md;

				Type componentType = ce.getComponentType();
				if (Matcher.match(ModelsEntityDescriptorEnum.SimpleName, componentType))
					referencedTypes.add(componentType.wStringValue());
			}
		}

		undefinedTypes.addAll(referencedTypes);
		undefinedTypes.removeAll(definedTypes);

		unreferencedTypes.addAll(definedTypes);
		unreferencedTypes.removeAll(referencedTypes);

		for (String entityName : undefinedTypes) {
			entityNameList.add(entityName);
			if (StringUtils.isValidEntityName(entityName))
				entityNameGen.putBoundName(entityName);
		}

		for (String name : entityNameList())
			entityNameImplNameMap.put(name,
					entityNameGen.isBoundOnlyName(name) ? name : entityNameGen.nextFreshName(StringUtils.toEntityName(name)));
		for (String name : featureNameList())
			featureNameImplNameMap.put(name,
					featureNameGen.isBoundOnlyName(name) ? name : featureNameGen.nextFreshName(StringUtils.toFeatureName(name)));
	}

	public List<String> entityNameList() {
		return entityNameList;
	}
	public List<String> featureNameList() {
		return featureNameList;
	}
	
	public Set<String> entityImplNames(Set<String> names) {
		Set<String> implNames = new HashSet<String>(names.size());
		for (String name : names)
			implNames.add(entityImplName(name));
		return implNames;
	}

	public String entityImplName(String name) {
		return entityNameImplNameMap.get(name);
	}
	public String featureImplName(String name) {
		return featureNameImplNameMap.get(name);
	}
	
	public Set<String> superTypes(String entityName) {
		Set<String> result = superTypes.get(entityName);
		if (result == null)
			superTypes.put(entityName, result = new HashSet<String>());
		return result;
	}
	public Set<String> subTypes(String entityName) {
		Set<String> result = subTypes.get(entityName);
		if (result == null)
			subTypes.put(entityName, result = new HashSet<String>());
		return result;
	}

	public Set<String> allSuperTypes(String entityName) {
		Set<String> allTypes = allSuperTypes.get(entityName);
		if (allTypes == null) {
			allSuperTypes.put(entityName, allTypes = new HashSet<String>());
			
			allTypes.add(entityName);
			List<String> pendingTypes = new ArrayList<String>(allTypes);
			for (int i=0; i<pendingTypes.size(); i++) {
				Set<String> newTypes = new HashSet<String>(superTypes(pendingTypes.get(i)));
				newTypes.removeAll(allTypes);

				allTypes.addAll(newTypes);
				pendingTypes.addAll(newTypes);
			}			
		}
		return allTypes;
	}
	public Set<String> allSubTypes(String entityName) {
		Set<String> allTypes = allSubTypes.get(entityName);
		if (allTypes == null) {
			allSubTypes.put(entityName, allTypes = new HashSet<String>());
			
			allTypes.add(entityName);
			List<String> pendingTypes = new ArrayList<String>(allTypes);
			for (int i=0; i<pendingTypes.size(); i++) {
				Set<String> newTypes = new HashSet<String>(subTypes(pendingTypes.get(i)));
				newTypes.removeAll(allTypes);
	
				allTypes.addAll(newTypes);
				pendingTypes.addAll(newTypes);
			}
			allTypes.remove(entityName);
		}
		return allTypes;
	}
	public Set<String> allConcreteSubTypes(String entityName) {
		Set<String> allImplementations = new HashSet<String>(allSubTypes(entityName));
		allImplementations.removeAll(abstractTypes);
		return allImplementations;
	}
	
	public boolean hasMarkerInterface(String entityName) {
		return referencedTypes.contains(entityName);
	}

	public boolean isNotInherited(String entityName, String featureName) {
		return simpleEntityOrigFeatures.get(entityName) == null
			|| simpleEntityOrigFeatures.get(entityName).contains(featureName);
	}

	public Set<String> simpleEntityOrigFeatures(String name) {
		return simpleEntityOrigFeatures.get(name);
	}
	public Set<String> simpleEntityFeatures(String name) {
		return simpleEntityFeatures.get(name);
	}

	public void addUndeclaredTypes(Model model) {
		ModelDeclarations decls = model.getDeclarations();
		ModelsEntityFactory lf = ModelsEntityFactory.instance;
		for (String name : undefinedTypes) {
			decls.wAdd(lf.createSimpleEntity(
					lf.createEntityModifiers(lf.createEntityModifier(EntityModifierEnum._abstract)),
					lf.createSimpleName(name), lf.createTypes(), lf.createFeatures()));
		}

		markerTypes.addAll(undefinedTypes);
		abstractTypes.addAll(undefinedTypes);
		undefinedTypes.clear();
	}
	
	public void addInheritedFeatures(Model model) {
		for (String entityName : simpleEntityTypes) {
			SimpleEntity e = (SimpleEntity) nameEntityMap.get(entityName);
			addInheritedFeatures(e, e.getTypes(), new HashSet<String>(simpleEntityTypes), simpleEntityFeatures);
		}
	}
	protected void addInheritedFeatures(SimpleEntity entity, Types types, Set<String> entityTypes, Map<String, Set<String>> entityFeatures) {
		ScannerIterator<IEntity> i = IteratorFactory.childReverseScannerIterator();
		i.reset(types);
		for (IEntity type : i) {
			String typeName = type.wStringValue();
			entityTypes.remove(typeName);
			SimpleEntity declaration = (SimpleEntity) nameEntityMap.get(typeName);
			if (declaration != null) {
				ScannerIterator<Feature> i2 = IteratorFactory.<Feature>childReverseScannerIterator();
				i2.reset(declaration.getFeatures());
				for (Feature feature : i2) {
					if (entityFeatures.get(entity.getName().wStringValue()).add(feature.getName().wStringValue()))
						entity.getFeatures().wAdd(0, EntityUtils.clone(feature));
				}
				addInheritedFeatures(entity, declaration.getTypes(), entityTypes, entityFeatures);
			}
		}
	}

	public void sortFeatures(Model model) {
		for (String entityName : simpleEntityTypes) {
			SimpleEntity e = (SimpleEntity) nameEntityMap.get(entityName);
			Features features = e.getFeatures();
			Collections.sort(features, new Comparator<Feature>() {
				public int compare(Feature f1, Feature f2) {
					boolean f1IsReference = f1.getModifiers().wContainsValue(FeatureModifierEnum.reference);
					boolean f2IsReference = f2.getModifiers().wContainsValue(FeatureModifierEnum.reference);
					if (f2IsReference)
						return f1IsReference ? 0 : -1;
					else
						return !f1IsReference ? 0 : +1;
				}
			});
		}
	}

}
