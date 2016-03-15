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
package org.whole.lang.models.visitors;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.models.model.AnyType;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.ComponentModifierEnum;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.EntityType;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifier;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.SubtypesOf;
import org.whole.lang.models.model.SupertypesOf;
import org.whole.lang.models.model.TypeAliasOf;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.util.ModelInfo;
import org.whole.lang.reflect.DynamicLanguageKit;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class ModelsInterpreterVisitor extends ModelsIdentityDefaultVisitor {
	private EntityDescriptorEnum entityDescriptorEnum;
	private FeatureDescriptorEnum featureDescriptorEnum;
	private ModelInfo modelInfo;

    protected ClassLoader getClassLoader() {
		return ReflectionFactory.getClassLoader(getBindings());
	}

	@Override
	public void visit(IModelsEntity entity) {
		Model m = Matcher.findAncestor(ModelsEntityDescriptorEnum.Model, entity);
		if (m != null)
			visit(m);
		
		throw new VisitException();
	}

	@Override
	public void visit(Model entity) {
		boolean hasArgLanguageKit = getBindings().wIsSet("languageKit");
		DynamicLanguageKit argLanguageKit = hasArgLanguageKit ? (DynamicLanguageKit) getBindings().wGetValue("languageKit") : null;
		boolean useArgLanguageKit = hasArgLanguageKit && argLanguageKit.getURI().equals(entity.getUri().getValue());
				
		DynamicLanguageKit languageKit;
		if (useArgLanguageKit)
			languageKit = argLanguageKit;
		else {
			languageKit = new DynamicLanguageKit();
			languageKit.setURI(entity.getUri().getValue());
			languageKit.setNamespace(entity.getNamespace().getValue());
			languageKit.setName(entity.getName().getValue());
			languageKit.setVersion(EntityUtils.isResolver(entity.getVersion()) ? "" : entity.getVersion().getValue());
		}
		entity = EntityUtils.cloneIfParented(entity);
		languageKit.setEntity(entity);
		configureLanguageKit(languageKit, entity);
		ReflectionFactory.updatePersistenceAndEditorKits(languageKit);

		if (!useArgLanguageKit) {
			ReflectionFactory.deploy(DynamicLanguageKit.getDeployer(languageKit));
			if (hasArgLanguageKit)
				getBindings().wSetValue("languageKit", argLanguageKit);
		}
		setResult(BindingManagerFactory.instance.createValue(languageKit));
	}
	public void configureLanguageKit(DynamicLanguageKit languageKit, Model model) {
		modelInfo = new ModelInfo(model);
		modelInfo.addInheritedFeatures(model);
		modelInfo.addUndeclaredTypes(model);
		modelInfo.sortFeatures(model);

		entityDescriptorEnum = languageKit.getEntityDescriptorEnum();
		featureDescriptorEnum = languageKit.getFeatureDescriptorEnum();

		model.getDeclarations().accept(new EntityDescriptorDefinitionVisitor());
		model.getDeclarations().accept(new EntityDescriptorCompletionVisitor());
		model.getTypeRelations().accept(new TypeRelationsVisitor());
	}
	
	private class TypeRelationsVisitor extends ModelsTraverseAllChildrenVisitor {
		protected String foreignEdUri;
		protected int[] edOrdinals;
		protected int edOrdinal;

		@Override
		public void visit(SupertypesOf entity) {
			super.visit(entity);
			if (foreignEdUri != null)
				entityDescriptorEnum.setAssignableFromForeignType(true, foreignEdUri, edOrdinals);
			else
				entityDescriptorEnum.setAssignableFromAll(true, edOrdinals);
		}
		@Override
		public void visit(SubtypesOf entity) {
			super.visit(entity);
			if (foreignEdUri != null)
				entityDescriptorEnum.setAssignableToForeignType(true, foreignEdUri, edOrdinals);
			else
				entityDescriptorEnum.setAssignableToAll(true, edOrdinals);
		}
		@Override
		public void visit(TypeAliasOf entity) {
			super.visit(entity);
			entityDescriptorEnum.setAliasOf(true, foreignEdUri, edOrdinal);
		}
		@Override
		public void visit(AnyType entity) {
			foreignEdUri = null;
		}
		@Override
		public void visit(EntityType entity) {
			foreignEdUri = entity.getValue();
		}
		@Override
		public void visit(Types entity) {
			int size = entity.size();
			edOrdinals = new int[size];
			for (int i=0; i<size; i++) {
				entity.get(i).accept(TypeRelationsVisitor.this);
				edOrdinals[i] = edOrdinal;
			}
		}
		@Override
		public void visit(SimpleName entity) {
			edOrdinal = entityDescriptorEnum.valueOf(entity.getValue()).getOrdinal();
		}
	}

	private class EntityDescriptorDefinitionVisitor extends ModelsTraverseAllChildrenVisitor {
		@Override
		public void visit(DataEntity entity) {
			String name = entity.getName().wStringValue();
			String dataTypeName = entity.getDataType().wStringValue();
			Class<?> dataType;

			if (StringUtils.isPrimitiveOrString(dataTypeName))
				dataType = StringUtils.primitiveOrStringClass(dataTypeName);
			else
				try {
					dataType = Class.forName(StringUtils.isAmbiguous(dataTypeName) ?
							"java.lang."+ dataTypeName : dataTypeName, true, getClassLoader());
				} catch (ClassNotFoundException e) {
					throw new IllegalArgumentException("Cannot find class: "+dataTypeName, e);
				}

			org.whole.lang.models.model.EntityModifiers modifiers = entity.getModifiers();
			entityDescriptorEnum.addDataEntity(name, modelInfo.entityImplName(name),
					modifiers.wContainsValue(EntityModifierEnum.relationship), dataType);
		}

		@Override
		public void visit(EnumEntity entity) {
			String name = entity.getName().wStringValue();
			EnumValues evalues = entity.getValues();
			int evaluesSize = evalues.wSize();
			String[] values = new String[evaluesSize];
			
			for (int i=0; i<evaluesSize; i++)
				values[i] = evalues.wGet(i).wStringValue();
			
			entityDescriptorEnum.addEnumEntity(name, modelInfo.entityImplName(name), values);
		}

		@Override
		public void visit(CompositeEntity entity) {
			String name = entity.getName().wStringValue();

			boolean isOrdered = false, isUnique = false;
			IEntityIterator<ComponentModifier> i = IteratorFactory.<ComponentModifier>childIterator();
			i.reset(entity.getComponentModifiers());
			for (ComponentModifier modifier : i)
				switch (modifier.getValue().getOrdinal()) {
				case ComponentModifierEnum.ordered_ord:
					isOrdered = true;
					break;
				case ComponentModifierEnum.unique_ord:
					isUnique = true;
					break;
				}

			org.whole.lang.models.model.EntityModifiers modifiers = entity.getModifiers();
			entityDescriptorEnum.addCompositeEntity(name, modelInfo.entityImplName(name),
					modifiers.wContainsValue(EntityModifierEnum.relationship),
					isOrdered, isUnique);
		}

		@Override
		public void visit(SimpleEntity entity) {
			String name = entity.getName().wStringValue();
			org.whole.lang.models.model.EntityModifiers modifiers = entity.getModifiers();
			entityDescriptorEnum.addSimpleEntity(name, modelInfo.entityImplName(name),
						modifiers.wContainsValue(EntityModifierEnum._abstract));
		}
	}

	private class EntityDescriptorCompletionVisitor extends ModelsTraverseAllChildrenVisitor {

		@Override
		public void visit(DataEntity entity) {
		}

		@Override
		public void visit(EnumEntity entity) {
		}

		@Override
		public void visit(CompositeEntity entity) {
			String name = entity.getName().wStringValue();
			String componentName = entity.getComponentType().wStringValue();

			boolean isReference = false, isDerived = false, isShared = false;
			IEntityIterator<ComponentModifier> i = IteratorFactory.<ComponentModifier>childIterator();
			i.reset(entity.getComponentModifiers());
			for (ComponentModifier modifier : i)
				switch (modifier.getValue().getOrdinal()) {
				case ComponentModifierEnum.reference_ord:
					isReference = true;
					break;
				case ComponentModifierEnum.derived_ord:
					isDerived = true;
					break;
				case ComponentModifierEnum.shared_ord:
					isShared = true;
					break;
				}

			entityDescriptorEnum.valueOf(name).withFeature(
					CommonsFeatureDescriptorEnum.composite_element,
					entityDescriptorEnum.valueOf(componentName).getOrdinal(),
					false, false, isReference, isDerived, isShared);
		}

		@Override
		public void visit(SimpleEntity entity) {
			String name = entity.getName().wStringValue();
			Features features = entity.getFeatures();
			int featureNumber = features.wSize();

			EntityDescriptor<?> ed = entityDescriptorEnum.valueOf(name);
			for (int i=0; i<featureNumber; i++) {
				Feature feature = features.get(i);

				String featureName = feature.getName().getValue();
				FeatureDescriptor fd = featureDescriptorEnum.addFeatureDescriptor(
						featureName, modelInfo.featureImplName(featureName));

				FeatureDescriptor oppositeFd = null;
				String oppositeFeatureName = EntityUtils.safeStringValue(feature.getOppositeName(), null);
				if (oppositeFeatureName != null)
					oppositeFd = featureDescriptorEnum.addFeatureDescriptor(
							oppositeFeatureName, modelInfo.featureImplName(oppositeFeatureName));

				boolean isOptional = false, isId = false, isReference = false, isDerived = false, isShared = false;
				IEntityIterator<FeatureModifier> i2 = IteratorFactory.<FeatureModifier>childIterator();
				i2.reset(feature.getModifiers());
				for (FeatureModifier modifier : i2)
					switch (modifier.getValue().getOrdinal()) {
					case FeatureModifierEnum.optional_ord:
						isOptional = true;
						break;
					case FeatureModifierEnum.id_ord:
						isId = true;
						break;
					case FeatureModifierEnum.reference_ord:
						isReference = true;
						break;
					case FeatureModifierEnum.derived_ord:
						isDerived = true;
						break;
					case FeatureModifierEnum.shared_ord:
						isShared = true;
						break;
					}

				ed.withFeature(fd, entityDescriptorEnum.valueOf(feature.getType().wStringValue()).getOrdinal(),
						oppositeFd,
						isOptional, isId, isReference, isDerived, isShared);
			}

			for (String ename : modelInfo.allSubTypes(name))
				ed.setLanguageSubtypes(true, entityDescriptorEnum.valueOf(ename).getOrdinal());
		}
	}
}
