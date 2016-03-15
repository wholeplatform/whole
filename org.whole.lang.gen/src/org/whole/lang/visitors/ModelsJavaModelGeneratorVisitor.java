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
package org.whole.lang.visitors;

import static org.whole.gen.lang.ClassNames.CompositeColumnPartName;
import static org.whole.gen.lang.ClassNames.PlaceHolderPartName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.gen.lang.model.AbstractEntityBuilder;
import org.whole.gen.lang.model.SimpleEntityInterfaceBuilder;
import org.whole.gen.lang.model.adapters.EntityAdapterBuilder;
import org.whole.gen.lang.model.impl.SimpleEntityImplBuilder;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.model.AbstractUniqueListCompositeEntity;
import org.whole.lang.model.adapters.AbstractCollectionEntityAdapter;
import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.ComponentModifierEnum;
import org.whole.lang.models.model.ComponentModifiers;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.EntityModifier;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.EntityModifiers;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifier;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.FeatureModifiers;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.ForeignType;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.models.model.MapEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclaration;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.SubtypesOf;
import org.whole.lang.models.model.SupertypesOf;
import org.whole.lang.models.model.TypeAliasOf;
import org.whole.lang.models.model.TypeRelations;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.util.ModelInfo;
import org.whole.lang.models.visitors.ModelsIdentityVisitor;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class ModelsJavaModelGeneratorVisitor extends ModelsIdentityVisitor {
	private LanguageGenerator modelsGen;
	private ModelInfo modelInfo;
	private AbstractEntityBuilder anyEntityBuilder;
	private EntityAdapterBuilder entityAdapterBuilder;
	private SimpleEntityImplBuilder simpleEntityBuilder;
	private SimpleEntityInterfaceBuilder simpleEntityInterfaceBuilder;
	private Set<String> entityModifiers = new HashSet<String>();
	private Set<String> featureModifiers = new HashSet<String>();
	private Set<String> compositeModifiers = new HashSet<String>();

	private String metaName;
	private String entityName;
	private String qEntityName;
	private boolean isConcrete;
	private boolean hasUI = false;
	
	
	public void setTestCU(CompilationUnit cu) {
	    modelsGen.cuList.remove(cu);
	    modelsGen.cuList.add(0, cu);
	}

	private String findFirstConcreteEntity(ModelDeclarations declarations) {
		IEntityIterator<ModelDeclaration> i = IteratorFactory.<ModelDeclaration>childIterator();
		i.reset(declarations);
		for (ModelDeclaration declaration : i) {
			String name = declaration.getName().wStringValue();
			if (!modelInfo.abstractTypes.contains(name))
				return name;
		}
		ModelDeclaration firstModelDeclaration = (ModelDeclaration) declarations.wGet(0);
		return firstModelDeclaration.getName().wStringValue();
	}
	private void beforeModel(Model model) {
		String modelName = model.getName().wStringValue();
		String rootEntityName = findFirstConcreteEntity(model.getDeclarations());

		modelsGen = (LanguageGenerator) ((JavaCompilerOperation) getOperation()).getGenerator();

		if (!EntityUtils.isResolver(model.getUri()))
			modelsGen.setURI(model.getUri().getValue());

		if (!EntityUtils.isResolver(model.getVersion()))
			modelsGen.setVersion(model.getVersion().getValue());

		String packagePrefix = EntityUtils.isResolver(model.getNamespace()) ?
				modelsGen.getBasePackagePrefix()+"."+modelName.toLowerCase() :
				model.getNamespace().getValue();
		modelsGen.setPackagePrefix(packagePrefix);

		modelsGen.setModelName(modelName);
		modelsGen.setTopEntityName(rootEntityName, modelInfo.entityImplName(rootEntityName));

		modelsGen.languageDeployerBuilder();
		modelsGen.languageKitBuilder();
		if (hasUI)
			modelsGen.editorKitBuilder();
	}
	private void afterModel() {
		modelsGen.strictImplRegistryBuilder();//FIXME workaround
		modelsGen.featureDescriptorEnumBuilder();

//		modelsGen.prototypeManagerBuilder().addPrototypesUsingLanguageFactory();		
		modelsGen.templateManagerBuilder();
		if (hasUI) {
			modelsGen.actionFactoryBuilder();
			modelsGen.commandFactoryBuilder();

			Set<String> allTypes = new HashSet<String>(modelsGen.getAllTypes());
			for (String type : allTypes) {
				Set<String> implementations = modelInfo.allConcreteSubTypes(type);
				
				for (String concreteType : implementations)
					modelsGen.commandFactoryBuilder().addOverSimpleConstraint(concreteType, type);
			}

			Set<String> componentTypes = new HashSet<String>();
			for (Map.Entry<String, String> e : modelsGen.getCompositesEntrySet()) {
				String compositeType = e.getKey();
				Set<String> implementations = modelInfo.allConcreteSubTypes(e.getValue());
	
				for (String componentType : implementations) {
					if (componentTypes.add(componentType))
						modelsGen.actionFactoryBuilder().addAction(componentType);
					modelsGen.commandFactoryBuilder().addOverCompositeConstraint(componentType, compositeType);
				}
			}
	
			modelsGen.actionFactoryBuilder().assertAllEntities();
		}
	}

	public void visit(Model modelOrig) {
		Model model = EntityUtils.clone(modelOrig);		
		modelInfo = new ModelInfo(model);
		modelInfo.addInheritedFeatures(model);
		modelInfo.addUndeclaredTypes(model);
		modelInfo.sortFeatures(model);

		beforeModel(model);

		modelsGen.visitorsBuilder();
		modelsGen.entityInterfaceBuilder();
		modelsGen.entityFactoryBuilder();
		if (hasUI)
			modelsGen.partFactoryVisitorBuilder();

		model.getDeclarations().accept(this);
		model.getTypeRelations().accept(this);
	
//		modelsGen.applyTypeDeclarations();

		afterModel();
	}

	public void visit(ModelDeclarations modelBody) {		
		IOperationProgressMonitor progressMonitor = getOperation().getProgressMonitor();
		progressMonitor.beginTask("Building entities",
				IOperationProgressMonitor.TOTAL_WORK, modelBody.wSize());
		for (int i=0, size=modelBody.wSize(); i<size; i++) {
			((IModelsEntity) modelBody.wGet(i)).accept(this);
			progressMonitor.worked(1);
			handleCancelRequest();
		}
		progressMonitor.endTask();
	}

	public void visit(EntityModifiers entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((EntityModifier) entity.wGet(i)).accept(this);
	}
	public void visit(EntityModifier entity) {
		entityModifiers.add(entity.getValue().getName().toUpperCase());
		if (EntityModifierEnum._abstract.equals(entity.getValue()))
			isConcrete = false;
	}

	public void visit(FeatureModifiers entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((FeatureModifier) entity.wGet(i)).accept(this);
	}
	public void visit(FeatureModifier entity) {
		featureModifiers.add(entity.getValue().getName().toUpperCase());
	}

	public void visit(ComponentModifiers entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((ComponentModifier) entity.wGet(i)).accept(this);
	}
	public void visit(ComponentModifier entity) {
		compositeModifiers.add(entity.getValue().getName().toUpperCase());
	}

	public void visit(Types types) {
		AbstractPatternFilterIterator<SimpleName> i = IteratorFactory.<SimpleName>childMatcherIterator()
				.withPattern(ModelsEntityDescriptorEnum.SimpleName);
		i.reset(types);
		for (SimpleName name : i) {
			String typeName = name.wStringValue();
			
		    anyEntityBuilder.addTypeDeclaration(typeName);
		    modelsGen.visitorsBuilder().addType(entityName, typeName);
		}
	}

	public void visit(SimpleEntity entity) {
		entityModifiers.clear();
		isConcrete = true;
		entity.getModifiers().accept(this);

		metaName = entity.getName().wStringValue();
		entityName = modelInfo.entityImplName(metaName);//was entity.getName().wStringValue();
		qEntityName = modelsGen.entityInterfaceQName(entityName);

	    if (isConcrete)
	    	simpleEntityBuilder = modelsGen.simpleEntityBuilder(entityName);
	    anyEntityBuilder = simpleEntityInterfaceBuilder = modelsGen.simpleEntityInterfaceBuilder(entityName);

	    //before factoryBuilder
	    if (!entityName.equals(modelsGen.entityVariableName())) {
	    	entityAdapterBuilder = modelsGen.entityAdapterBuilder(entityName);
	    	modelsGen.adapterRegistryBuilder().addFactoryProduct(entityName);
		    if (isConcrete)
		    	modelsGen.implRegistryBuilder().addFactoryProduct(entityName);
	    }

	    Features features = entity.getFeatures();
		if (isConcrete)
	    	modelsGen.entityFactoryBuilder().addFactoryMethodWithBuild(entityName, features.wIsEmpty() ? 0 : features.wSize());

		modelsGen.entityDescriptorEnumBuilder().addSimpleEntity(
				entityName, metaName, qEntityName, entityModifiers, modelInfo.entityImplNames(modelInfo.allSubTypes(metaName)));
//		modelsGen.entityDescriptorEnumBuilder().addSupertypes(qEntityName, metaName, modelInfo.allSuperTypes(metaName));

		entity.getTypes().accept(this);
		features.accept(this);

	    if (isConcrete) {
	    	simpleEntityBuilder.endBody();
	    	modelsGen.visitorsBuilder().addSimpleEntity(entityName);
			if (hasUI)
				modelsGen.partFactoryVisitorBuilder().addPartFactoryVisitMethod(entityName, features.wSize());
	    }
	}

	public void visit(Features entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((Feature) entity.wGet(i)).accept(this);
	}

	public void visit(Feature feature) {
		String name = feature.getName().wStringValue();
		String fName = modelInfo.featureImplName(name);//was StringUtils.javaKeywordFilter(name);
		String type = feature.getType().wStringValue();
		String fType = modelInfo.entityImplName(type);
		String fQType = modelsGen.entityInterfaceQName(fType);
		
		String oName = null;
		String ofName = null;
		SimpleName oppositeName = feature.getOppositeName();
		if (DataTypeUtils.getDataKind(oppositeName).isString()) {
			oName = oppositeName.getValue();
			ofName = modelInfo.featureImplName(oName);//was StringUtils.javaKeywordFilter(oName);
		}

		FeatureModifiers mods = feature.getModifiers();
		featureModifiers.clear();
		mods.accept(this);
		boolean isByReference = mods.wContainsValue(FeatureModifierEnum.reference);
	    if (isConcrete)
			simpleEntityBuilder.addField(fType, fName, name,
					mods.wContainsValue(FeatureModifierEnum.id),
					mods.wContainsValue(FeatureModifierEnum.optional),
					isByReference,
					mods.wContainsValue(FeatureModifierEnum.shared),
					mods.wContainsValue(FeatureModifierEnum.derived));
	    if (modelInfo.isNotInherited(metaName, name))
	    	simpleEntityInterfaceBuilder.addField(fType, fName, name);

	    modelsGen.modelContextBuilder().addFeature(fType, fName);
		modelsGen.visitorsBuilder().addFeature(entityName, fType, fName, name, isByReference);
		modelsGen.entityDescriptorEnumBuilder().addFeature(qEntityName, fType, fName, ofName, featureModifiers);
		modelsGen.featureDescriptorEnumBuilder().addFeature(fType, fName, name);
		if (oName != null)
			modelsGen.featureDescriptorEnumBuilder().addFeature(entityName, ofName, oName);
	    if (isConcrete)
	    	modelsGen.entityFactoryBuilder().addFactoryMethodCase(fQType, fName);
		
		entityAdapterBuilder.addFeature(fType, fName, name);
	}

	public void visit(CompositeEntity entity) {
		entityModifiers.clear();
		isConcrete = true;
		entity.getModifiers().accept(this);
		
		metaName = entity.getName().wStringValue();
		entityName = modelInfo.entityImplName(metaName);//was entity.getName().wStringValue();
		qEntityName = modelsGen.entityInterfaceQName(entityName);
		String specificComponentType = entity.getComponentType().wStringValue();
		String componentType = specificComponentType;
		String componentQType = modelsGen.entityInterfaceQName(componentType);


//		if (singleFeature.getCardinality().isOptional())
		    modelsGen.putOptionalEntity(componentType);

		String compositeType, javaCompositeType, abstractAdapterType;
		ComponentModifiers modifiers = entity.getComponentModifiers();
		compositeModifiers.clear();
		modifiers.accept(this);

		modelsGen.putComposite(entityName, componentType);
		simpleEntityBuilder = null;

		boolean isByReference = modifiers.wContainsValue(ComponentModifierEnum.reference);
		boolean isUnique = modifiers.wContainsValue(ComponentModifierEnum.unique);
		boolean isOrdered = modifiers.wContainsValue(ComponentModifierEnum.ordered);
		boolean hasStrict = isUnique || !isOrdered;
		if (hasStrict) {
			if (isUnique) {
				if (isOrdered) {
					compositeType = AbstractUniqueListCompositeEntity.class.getName();
					javaCompositeType = List.class.getName();
					abstractAdapterType = AbstractListEntityAdapter.class.getName();
				} else {
					compositeType = AbstractSetCompositeEntity.class.getName();
					javaCompositeType = Set.class.getName();
					abstractAdapterType = AbstractSetEntityAdapter.class.getName();
				}
			} else {
				compositeType = AbstractBagCompositeEntity.class.getName();
				javaCompositeType = Collection.class.getName();
				abstractAdapterType = AbstractCollectionEntityAdapter.class.getName();
			}
			modelsGen.compositeEntityBuilder(entityName, componentType, compositeType,
					isByReference, true);
			compositeType = AbstractCollectionCompositeEntity.class.getName();				
		} else {
			compositeType = AbstractListCompositeEntity.class.getName();				
			javaCompositeType = List.class.getName();
			abstractAdapterType = AbstractListEntityAdapter.class.getName();
		}

    	modelsGen.compositeEntityBuilder(entityName, componentType, compositeType,
    			isByReference, false);

		anyEntityBuilder = modelsGen.compositeEntityInterfaceBuilder(entityName, componentType, javaCompositeType);

    	entityAdapterBuilder = modelsGen.compositeEntityAdapterBuilder(entityName, abstractAdapterType, componentType);
    	modelsGen.adapterRegistryBuilder().addFactoryProduct(entityName);
    	modelsGen.implRegistryBuilder().addFactoryProduct(entityName);
    	if (hasStrict)
    		modelsGen.strictImplRegistryBuilder().addFactoryProduct(entityName);

		entity.getTypes().accept(this);

		modelsGen.visitorsBuilder().addCompositeEntity(entityName, componentType, isOrdered, isByReference);
		if (hasUI)
			modelsGen.partFactoryVisitorBuilder().addPartFactoryVisitMethod(entityName, CompositeColumnPartName);
		modelsGen.entityFactoryBuilder().addFactoryMethodWithVarArgsCase(
				entityName, componentQType, "entities");

		modelsGen.entityDescriptorEnumBuilder().addCompositeEntity(entityName, metaName, qEntityName, entityModifiers, specificComponentType, compositeModifiers);
//		modelsGen.entityDescriptorEnumBuilder().addSupertypes(qEntityName, metaName, modelInfo.allSuperTypes(metaName));
	}
	
	public void visit(MapEntity entity) {
		entityModifiers.clear();
		isConcrete = true;
		entity.getModifiers().accept(this);
		
		metaName = entity.getName().wStringValue();
		entityName = modelInfo.entityImplName(metaName);//was entity.getName().wStringValue();
		qEntityName = modelsGen.entityInterfaceQName(entityName);
		String specificKeyType = entity.getKeyType().wStringValue();
		String keyType = specificKeyType;
		String specificValueType = entity.getValueType().wStringValue();
		String valueType = specificValueType;

	    modelsGen.putOptionalEntity(keyType);
	    modelsGen.putOptionalEntity(valueType);

		simpleEntityBuilder = null;
    	modelsGen.mapEntityBuilder(entityName, keyType, valueType, true);
		anyEntityBuilder = modelsGen.mapEntityInterfaceBuilder(entityName, keyType, valueType);

    	entityAdapterBuilder = modelsGen.mapEntityAdapterBuilder(entityName, keyType, valueType);
    	modelsGen.adapterRegistryBuilder().addFactoryProduct(entityName);
    	modelsGen.implRegistryBuilder().addFactoryProduct(entityName);

		entity.getTypes().accept(this);

		modelsGen.visitorsBuilder().addMapEntity(entityName, keyType, valueType);
		if (hasUI)
			modelsGen.partFactoryVisitorBuilder().addPartFactoryVisitMethod(entityName, CompositeColumnPartName);
		modelsGen.entityFactoryBuilder().addFactoryMethodWithMapCase(entityName, keyType, valueType);

		modelsGen.entityDescriptorEnumBuilder().addMapEntity(entityName, metaName, entityModifiers, specificKeyType, specificValueType);
//		modelsGen.entityDescriptorEnumBuilder().addSupertypes(qEntityName, metaName, modelInfo.allSuperTypes(metaName));
	}

	public void visit(DataEntity entity) {
		entityModifiers.clear();
		isConcrete = true;
		entity.getModifiers().accept(this);
		
		metaName = entity.getName().wStringValue();
		entityName = modelInfo.entityImplName(metaName);//was entity.getName().wStringValue();
		qEntityName = modelsGen.entityInterfaceQName(entityName);
		String valueType = entity.getDataType().wStringValue();		
		String valueName = "value";

		simpleEntityBuilder = null;
		modelsGen.primitiveEntityBuilder(entityName, valueType, valueName);
		anyEntityBuilder = modelsGen.primitiveEntityInterfaceBuilder(entityName, valueType, valueName);
		
		modelsGen.entityDescriptorEnumBuilder().addDataEntity(
				entityName, metaName, qEntityName,
				entityModifiers, valueType, valueName);
//		modelsGen.entityDescriptorEnumBuilder().addSupertypes(qEntityName, metaName, modelInfo.allSuperTypes(metaName));

//		modelsGen.featureDescriptorEnumBuilder().addFeature(entityName, valueType, valueName);

    	entityAdapterBuilder = modelsGen.entityAdapterBuilder(entityName);
    	entityAdapterBuilder.addDataFeature(valueType, "value");
    	modelsGen.adapterRegistryBuilder().addFactoryProduct(entityName);
    	modelsGen.implRegistryBuilder().addFactoryProduct(entityName);

		entity.getTypes().accept(this);

		modelsGen.visitorsBuilder().addPrimitiveEntity(entityName);
		modelsGen.visitorsBuilder().addPrimitiveFeature(entityName, valueType, valueName);
		
		modelsGen.entityFactoryBuilder().addFactoryMethodWithCase(
				entityName, valueType, valueName, true);

		if (hasUI) {
			modelsGen.newDataCommandBuilder(entityName, valueType, valueName);

			if (StringUtils.isPrimitiveOrString(valueType)) {
				modelsGen.partFactoryVisitorBuilder().addPartFactoryVisitMethod(entityName);
				modelsGen.newDataDirectEditPolicyBuilder(entityName, valueType, valueName);
				modelsGen.newDataPartBuilder(entityName, valueType, valueName);
			} else {
				modelsGen.partFactoryVisitorBuilder().addPartFactoryVisitMethod(entityName, PlaceHolderPartName);			
			}
		}
	}

	public void visit(EnumEntity entity) {
		entityModifiers.clear();
		isConcrete = true;
		entity.getModifiers().accept(this);
		
		metaName = entity.getName().wStringValue();
		entityName = modelInfo.entityImplName(metaName);//was entity.getName().wStringValue();
		qEntityName = modelsGen.entityInterfaceQName(entityName);
		String enumTypeName = entityName+"Enum";
		String valueDataType = enumTypeName+".Value";		
		String valueQDataType = modelsGen.modelPackage()+"."+valueDataType;		

		org.whole.gen.lang.model.EnumTypeBuilder enumBuilder = modelsGen.enumTypeBuilder(enumTypeName, valueQDataType);
		EnumValues values = entity.getValues();

		FreshNameGenerator enumValueGen = new FreshNameGenerator();
		for (int i=0, size=values.wSize(); i<size; i++) {
			String value = values.wGet(i).wStringValue();
			if (StringUtils.isValidEnumLiteralName(value))
				enumValueGen.putBoundName(value);
		}
		
		for (int i=0, size=values.wSize(); i<size; i++) {
			if (EntityUtils.isData(values.wGet(i))) {
				String value = values.wGet(i).wStringValue();

				enumBuilder.addValue(value, enumValueGen.isBoundOnlyName(value) ? value : enumValueGen.nextFreshName(StringUtils.toEnumLiteralName(value)));
			}
		}

    	entityAdapterBuilder = modelsGen.entityAdapterBuilder(entityName);
    	entityAdapterBuilder.addDataFeature(valueQDataType, "value");
    	modelsGen.adapterRegistryBuilder().addFactoryProduct(entityName);
    	modelsGen.implRegistryBuilder().addFactoryProduct(entityName);

		buildEnumEntity(entityName, metaName, valueQDataType, valueDataType);
		
		entity.getTypes().accept(this);
	}

	private void buildEnumEntity(String entityName, String metaName, String valueQDataType, String valueDataType) {
		qEntityName = modelsGen.entityInterfaceQName(entityName);
		simpleEntityBuilder = null;
		String valueName = "value";

		modelsGen.primitiveEntityBuilder(entityName, valueQDataType, valueName);
		anyEntityBuilder = modelsGen.primitiveEntityInterfaceBuilder(entityName, valueQDataType, valueName);

		modelsGen.entityDescriptorEnumBuilder().addDataEntity(entityName, metaName, qEntityName, entityModifiers, valueDataType, valueName);
//		modelsGen.entityDescriptorEnumBuilder().addSupertypes(qEntityName, metaName, modelInfo.allSuperTypes(metaName));

//		modelsGen.featureDescriptorEnumBuilder().addFeature(qEntityName, valueQDataType, valueName);

		modelsGen.visitorsBuilder().addEnumEntity(entityName, valueQDataType, valueName);
		
		modelsGen.entityFactoryBuilder().addFactoryMethodWithCase(
				entityName, valueQDataType, valueName);

		if (hasUI) {
			modelsGen.newDataCommandBuilder(entityName, valueQDataType, valueName);
	
			modelsGen.partFactoryVisitorBuilder().addPartFactoryVisitMethod(entityName);
			modelsGen.newDataPartBuilder(entityName, valueQDataType, valueName);
	
			modelsGen.newEnumDirectEditPolicyBuilder(entityName, valueQDataType, valueName);
		}
	}

    public void visit(TypeRelations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(this);
    }

    public void visit(SupertypesOf entity) {
    	List<String> types = new ArrayList<String>();
		AbstractPatternFilterIterator<SimpleName> i = IteratorFactory.<SimpleName>childMatcherIterator()
				.withPattern(ModelsEntityDescriptorEnum.SimpleName);
		i.reset(entity.getTypes());
		for (SimpleName name : i)
			types.add(name.wStringValue());

    	ForeignType foreignType = entity.getForeignType();
		if (Matcher.matchImpl(ModelsEntityDescriptorEnum.AnyType, foreignType))
	    	modelsGen.entityDescriptorEnumBuilder().addSetAssignableFromAll(types.toArray(new String[types.size()]));			
		else
	    	modelsGen.entityDescriptorEnumBuilder().addSetAssignableFromForeignType(foreignType.wStringValue(), types.toArray(new String[types.size()]));			
    };

    public void visit(SubtypesOf entity) {
    	List<String> types = new ArrayList<String>();
		AbstractPatternFilterIterator<SimpleName> i = IteratorFactory.<SimpleName>childMatcherIterator()
				.withPattern(ModelsEntityDescriptorEnum.SimpleName);
		i.reset(entity.getTypes());
		for (SimpleName name : i)
			types.add(name.wStringValue());

    	ForeignType foreignType = entity.getForeignType();
		if (Matcher.matchImpl(ModelsEntityDescriptorEnum.AnyType, foreignType))
	    	modelsGen.entityDescriptorEnumBuilder().addSetAssignableToAll(types.toArray(new String[types.size()]));			
		else
	    	modelsGen.entityDescriptorEnumBuilder().addSetAssignableToForeignType(foreignType.wStringValue(), types.toArray(new String[types.size()]));			
    };

    @Override
    public void visit(TypeAliasOf entity) {
    	modelsGen.entityDescriptorEnumBuilder().addSetAliasOf(entity.getForeignType().getValue(), entity.getType().wStringValue());
    }
}
