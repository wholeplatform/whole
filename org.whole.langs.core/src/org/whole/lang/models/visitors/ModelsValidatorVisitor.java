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

import java.util.HashSet;
import java.util.Set;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.ComponentModifierEnum;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.DataType;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifier;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.MapEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclaration;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.models.util.ModelInfo;
import org.whole.lang.operations.IDecorationManager;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class ModelsValidatorVisitor extends ModelsTraverseAllVisitor {	
	private ModelInfo modelInfo;
	private IEntity currentEntity;

	public ModelsValidatorVisitor() {
	}

	private IDecorationManager decorationManager;
	public IDecorationManager getDecorationManager() {
		if (decorationManager == null)
			decorationManager = ((ValidatorOperation) getOperation()).getDecorationManager();
		return decorationManager;
	}

	@Override
	public void visit(Model entity) {
		modelInfo = new ModelInfo(entity);

		super.visit(entity);
	}

	@Override
	public void visit(ModelDeclarations entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			ModelDeclaration decl = (ModelDeclaration) entity.wGet(i);
			currentEntity = decl;
			decl.accept(this);
		}
	}

	@Override
	public void visit(SimpleEntity entity) {
		validateEntityDeclarationName(entity.getName());
		
		super.visit(entity);
	}


	@Override
	public void visit(CompositeEntity entity) {
		validateEntityDeclarationName(entity.getName());
		validateDeclaredType(entity.getComponentType());
		
		super.visit(entity);
	}

	@Override
	public void visit(MapEntity entity) {
		validateEntityDeclarationName(entity.getName());
		validateDeclaredType(entity.getKeyType());
		validateDeclaredType(entity.getValueType());
		
		super.visit(entity);
	}

	@Override
	public void visit(DataEntity entity) {
		validateEntityDeclarationName(entity.getName());
		validateNoResolver(entity.getDataType());
		
		super.visit(entity);
	}

	@Override
	public void visit(EnumEntity entity) {
		validateEntityDeclarationName(entity.getName());
		
		if (entity.getValues().wIsEmpty())
			getDecorationManager().addError(
					entity.getValues(), "At least one enum value must be defined.", location(entity));
			
		super.visit(entity);
	}

	@Override
	public void visit(Feature entity) {
		validateFeatureDeclarationName(entity.getName());
		validateDeclaredType(entity.getType());

		super.visit(entity);
	}

	@Override
	public void visit(DataType entity) {
		if (StringUtils.isWrapper(entity.getValue()))
			getDecorationManager().addWarning(
					entity, "A data entity is already a wrapper.", location(entity));
	}

	@Override
	public void visit(ComponentModifier entity) {
		switch (entity.wEnumValue().getOrdinal()) {
		case ComponentModifierEnum.derived_ord:
		case ComponentModifierEnum.shared_ord:
			getDecorationManager().addWarning(
					entity, "Unsupported component modifier: "+entity.wEnumValue().getName(), location(entity));
		}
	}
	@Override
	public void visit(FeatureModifier entity) {
		switch (entity.wEnumValue().getOrdinal()) {
		case FeatureModifierEnum.derived_ord:
		case FeatureModifierEnum.shared_ord:
			getDecorationManager().addWarning(
					entity, "Unsupported feature modifier: "+entity.wEnumValue().getName(), location(entity));
		}
	}

	@Override
	public void visit(Types entity) {
		AbstractPatternFilterIterator<SimpleName> i = IteratorFactory.<SimpleName>childMatcherIterator()
				.withPattern(ModelsEntityDescriptorEnum.SimpleName);
		i.reset(entity);
		for (SimpleName t : i) {
			String typeName = t.getValue();
			if (modelInfo.undefinedTypes.contains(typeName))
				getDecorationManager().addWarning(
						t, "Reference to the undeclared type: "+typeName, location(entity));

			if (!modelInfo.simpleEntityTypes.contains(typeName)
					&& !modelInfo.markerTypes.contains(typeName)
					&& !modelInfo.undefinedTypes.contains(typeName))
				getDecorationManager().addError(
						t, "Only Simple entities can be extended", location(entity));
			
			//TODO in entity visit
			if (currentEntity != null && !currentEntity.wGetEntityDescriptor().equals(ModelsEntityDescriptorEnum.SimpleEntity)) {
				for (String name : modelInfo.allSuperTypes(typeName))
					if (!modelInfo.markerTypes.contains(name)
							&& !modelInfo.undefinedTypes.contains(name))
						getDecorationManager().addError(
								t, "The supertypes of a "+currentEntity.wGetEntityDescriptor().getName()+" must be marker types (SimpleEntities without features)", location(entity));
			}
			isSimpleNameEmpty(t, "Reference type name is empty.");
		}
	}

	protected boolean isSimpleNameEmpty(SimpleName entity, String errorMessage) {
		boolean isEmpty = entity.getValue().length() == 0;
		if (isEmpty)
			getDecorationManager().addError(
					entity, errorMessage, location(entity));
		return isEmpty;
	}

	private Set<String> declaredEntityNames = new HashSet<String>();
	protected void validateEntityDeclarationName(IEntity entity) {
		if (!Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity)) {
			getDecorationManager().addError(
					entity, "The entity name is mandatory.", location(entity));	
			return;
		} else if (isSimpleNameEmpty((SimpleName) entity, "Entity name is empty."))
			return;

		String name = entity.wStringValue();

		if (!declaredEntityNames.add(name))
			getDecorationManager().addError(
					entity, "Duplicate entity name: "+name, location(entity));	

		if (StringUtils.isAmbiguous(name))
			getDecorationManager().addWarning(
					entity, "The entity name is ambiguous (see java.lang): "+name, location(entity));	

		if (name.length() == 0)
			getDecorationManager().addError(
					entity, "The entity name is empty", location(entity));	
		else
			if (Character.isLowerCase(name.charAt(0)))
				getDecorationManager().addWarning(
						entity, "The entity name will be replaced by: "+StringUtils.toUpperCap(name), location(entity));	
	}

	protected void validateFeatureDeclarationName(IEntity entity) {
		if (!Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity)) {
			getDecorationManager().addError(
					entity, "The feature name is mandatory.", location(entity));	
			return;
		}

		String name = entity.wStringValue();

		if (StringUtils.isJavaKeyword(name))
			getDecorationManager().addWarning(
					entity, "The feature name will be replaced by: _"+name, location(entity));	

		if (name.length() == 0)
			getDecorationManager().addError(
					entity, "The feature name is empty", location(entity));	
		else
			if (Character.isUpperCase(name.charAt(0)))
				getDecorationManager().addWarning(
						entity, "The feature name will be replaced by: "+StringUtils.toLowerCap(name), location(entity));	
	}

	protected boolean validateNoResolver(IEntity entity) {
		if (EntityUtils.isResolver(entity)
					&& !(CommonsEntityDescriptorEnum.StageUpFragment.equals(entity.wGetModel().getFragment().wGetEntityDescriptor()))) {
				getDecorationManager().addError(
						entity, "Missed mandatory feature: " + entity.wGetParent().wGetFeatureDescriptor(entity).getName(), location(entity));
				return false;
		}
		return true;
	}
	protected void validateDeclaredType(IEntity entity) {
		if (!validateNoResolver(entity) || !Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity))
			return;

		String typeName = entity.wStringValue();
		if (modelInfo.undefinedTypes.contains(typeName))
			getDecorationManager().addWarning(
					entity, "Reference to the undeclared type: "+typeName, location(entity));

		if (typeName.length() == 0)
			getDecorationManager().addError(
					entity, "The feature type is empty", location(entity));	

	}

	protected String location(IEntity entity) {
		String result = "";
		
		IEntityIterator<IEntity> i = IteratorFactory.ancestorReverseIterator();
		i.reset(entity);
		for (IEntity e : i) {
			if (e.wContains(ModelsFeatureDescriptorEnum.name)
					&& !e.wGetEntityDescriptor().equals(ModelsEntityDescriptorEnum.Model)) {
				if (result.length() > 0)
					result += ".";
				result += e.wGet(ModelsFeatureDescriptorEnum.name).toString();
			}
		}
		return result;
	}
}
