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
package org.whole.gen.lang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.JavaModelGenerator;
import org.whole.gen.JavaStoreGeneratorVisitorBuilder;
import org.whole.gen.lang.builders.ModelContextBuilder;
import org.whole.gen.lang.factories.EntityFactoriesBuilder;
import org.whole.gen.lang.model.AbstractEntityBuilder;
import org.whole.gen.lang.model.CompositeEntityInterfaceBuilder;
import org.whole.gen.lang.model.DataEntityInterfaceBuilder;
import org.whole.gen.lang.model.EntityInterfaceBuilder;
import org.whole.gen.lang.model.EnumTypeBuilder;
import org.whole.gen.lang.model.InterfaceEntityBuilder;
import org.whole.gen.lang.model.MapEntityInterfaceBuilder;
import org.whole.gen.lang.model.SimpleEntityInterfaceBuilder;
import org.whole.gen.lang.model.adapters.AdapterRegistryBuilder;
import org.whole.gen.lang.model.adapters.EntityAdapterBuilder;
import org.whole.gen.lang.model.impl.CompositeEntityImplBuilder;
import org.whole.gen.lang.model.impl.DataEntityImplBuilder;
import org.whole.gen.lang.model.impl.ImplRegistryBuilder;
import org.whole.gen.lang.model.impl.MapEntityImplBuilder;
import org.whole.gen.lang.model.impl.SimpleEntityImplBuilder;
import org.whole.gen.lang.model.impl.StrictImplRegistryBuilder;
import org.whole.gen.lang.reflect.EntityDescriptorEnumBuilder;
import org.whole.gen.lang.reflect.FeatureDescriptorEnumBuilder;
import org.whole.gen.lang.reflect.LanguageDeployerBuilder;
import org.whole.gen.lang.reflect.LanguageKitBuilder;
import org.whole.gen.lang.reflect.TemplateManagerBuilder;
import org.whole.gen.lang.ui.EditorKitBuilder;
import org.whole.gen.lang.ui.actions.ActionFactoryBuilder;
import org.whole.gen.lang.ui.actions.CommandFactoryBuilder;
import org.whole.gen.lang.ui.commands.DataCommandBuilder;
import org.whole.gen.lang.ui.editparts.DataPartBuilder;
import org.whole.gen.lang.ui.editparts.PartBuilder;
import org.whole.gen.lang.ui.editpolicies.DataDirectEditPolicyBuilder;
import org.whole.gen.lang.ui.editpolicies.EnumDirectEditPolicyBuilder;
import org.whole.gen.lang.ui.figures.FigureBuilder;
import org.whole.gen.lang.visitors.PartFactoryVisitorBuilder;
import org.whole.gen.lang.visitors.TraversalFactoryBuilder;
import org.whole.gen.lang.visitors.VisitorsBuilder;
import org.whole.lang.model.adapters.AbstractMapEntityAdapter;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class LanguageGenerator extends JavaModelGenerator {
	private String modelName;
	private String editorName;
	private String topEntityName;
	private String topEntityImplName;

	public LanguageGenerator() {
		super();
	}	
	public LanguageGenerator(String packagePrefix) {
		super(packagePrefix);
	}	
	public LanguageGenerator(String packagePrefix, String modelName) {
		super(packagePrefix);
		setModelName(modelName);
	}

	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = StringUtils.toUpperCap(modelName);
	}

	public String getEditorName() {
		if (editorName == null)
			editorName = getModelName();
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = StringUtils.toUpperCap(editorName);
	}


	public void setTopEntityName(String topEntityName, String topEntityImplName) {
		this.topEntityName = topEntityName;
		this.topEntityImplName = topEntityImplName;
	}
	public String getTopEntityName() {
		return topEntityName;
	}
	public String getTopEntityImplName() {
		return topEntityImplName;
	}

	private LanguageDeployerBuilder languageDeployerBuilder;
	public LanguageDeployerBuilder languageDeployerBuilder() {
	    if (languageDeployerBuilder == null)
	    	languageDeployerBuilder = new LanguageDeployerBuilder(this);
	    return languageDeployerBuilder;
	}

	private LanguageKitBuilder languageKitBuilder;
	public LanguageKitBuilder languageKitBuilder() {
	    if (languageKitBuilder == null)
	    	languageKitBuilder = new LanguageKitBuilder(this);
	    return languageKitBuilder;
	}

	private EditorKitBuilder editorKitBuilder;
	public EditorKitBuilder editorKitBuilder() {
	    if (editorKitBuilder == null)
	        editorKitBuilder = new EditorKitBuilder(this);
	    return editorKitBuilder;
	}

	private ModelContextBuilder modelContextBuilder;
	public ModelContextBuilder modelContextBuilder() {
	    if (modelContextBuilder == null)
	    	modelContextBuilder = new ModelContextBuilder(this);
	    return modelContextBuilder;
	}

	private EntityDescriptorEnumBuilder entityDescriptorEnumBuilder;
	public EntityDescriptorEnumBuilder entityDescriptorEnumBuilder() {
	    if (entityDescriptorEnumBuilder == null)
	    	entityDescriptorEnumBuilder = new EntityDescriptorEnumBuilder(this);
	    return entityDescriptorEnumBuilder;
	}
	private FeatureDescriptorEnumBuilder featureDescriptorEnumBuilder;
	public FeatureDescriptorEnumBuilder featureDescriptorEnumBuilder() {
	    if (featureDescriptorEnumBuilder == null)
	        featureDescriptorEnumBuilder = new FeatureDescriptorEnumBuilder(this);
	    return featureDescriptorEnumBuilder;
	}

	private SimpleEntityImplBuilder variableBuilder;
	public SimpleEntityImplBuilder variableBuilder() {
	    if (variableBuilder == null)
	    	variableBuilder = new SimpleEntityImplBuilder(this, modelImplSuffix(), entityVariableName());
	    return variableBuilder;
	}

	private EntityFactoriesBuilder entityFactoryBuilder;
	public EntityFactoriesBuilder entityFactoryBuilder() {
	    if (entityFactoryBuilder == null)
	        entityFactoryBuilder = new EntityFactoriesBuilder(this);
	    return entityFactoryBuilder;
	}

	private ImplRegistryBuilder implRegistryBuilder;
	public ImplRegistryBuilder implRegistryBuilder() {
	    if (implRegistryBuilder == null)
	    	implRegistryBuilder = new ImplRegistryBuilder(this);
	    return implRegistryBuilder;
	}

	private StrictImplRegistryBuilder strictImplRegistryBuilder;
	public StrictImplRegistryBuilder strictImplRegistryBuilder() {
	    if (strictImplRegistryBuilder == null)
	    	strictImplRegistryBuilder = new StrictImplRegistryBuilder(this);
	    return strictImplRegistryBuilder;
	}
	public boolean hasStrictImplRegistry() {
		return strictImplRegistryBuilder != null;
	}

	private AdapterRegistryBuilder adapterRegistryBuilder;
	public AdapterRegistryBuilder adapterRegistryBuilder() {
	    if (adapterRegistryBuilder == null)
	    	adapterRegistryBuilder = new AdapterRegistryBuilder(this);
	    return adapterRegistryBuilder;
	}

	private TemplateManagerBuilder templateManagerBuilder;
	public TemplateManagerBuilder templateManagerBuilder() {
	    if (templateManagerBuilder == null)
	        templateManagerBuilder = new TemplateManagerBuilder(this);
	    return templateManagerBuilder;
	}

	private ActionFactoryBuilder actionFactoryBuilder;
	public ActionFactoryBuilder actionFactoryBuilder() {
	    if (actionFactoryBuilder == null)
	        actionFactoryBuilder = new ActionFactoryBuilder(this);
	    return actionFactoryBuilder;
	}

	private CommandFactoryBuilder commandFactoryBuilder;
	public CommandFactoryBuilder commandFactoryBuilder() {
	    if (commandFactoryBuilder == null)
	        commandFactoryBuilder = new CommandFactoryBuilder(this);
	    return commandFactoryBuilder;
	}
	
	private VisitorsBuilder visitorsBuilder;
	public VisitorsBuilder visitorsBuilder() {
	    if (visitorsBuilder == null)
	        visitorsBuilder = new VisitorsBuilder(this);
	    return visitorsBuilder;
	}

	private TraversalFactoryBuilder visitorFactoryBuilder;
	public TraversalFactoryBuilder visitorFactoryBuilder() {
	    if (visitorFactoryBuilder == null)
	        visitorFactoryBuilder = new TraversalFactoryBuilder(this);
	    return visitorFactoryBuilder;
	}

	private EntityInterfaceBuilder entityInterfaceBuilder;
	public EntityInterfaceBuilder entityInterfaceBuilder() {
	    if (entityInterfaceBuilder == null)
	        entityInterfaceBuilder = new EntityInterfaceBuilder(this);
	    return entityInterfaceBuilder;
	}

	private PartFactoryVisitorBuilder partFactoryVisitorBuilder;
	public PartFactoryVisitorBuilder partFactoryVisitorBuilder() {
	    if (partFactoryVisitorBuilder == null)
	        partFactoryVisitorBuilder = new PartFactoryVisitorBuilder(this);
	    return partFactoryVisitorBuilder;
	}
	public PartFactoryVisitorBuilder addPartFactoryVisitorBuilder(String superEditorName) {
		return new PartFactoryVisitorBuilder(this, superEditorName != null ? StringUtils.toUpperCap(superEditorName) : null);
	}

	private JavaStoreGeneratorVisitorBuilder javaStoreGeneratorVisitorBuilder;
	public JavaStoreGeneratorVisitorBuilder javaStoreGeneratorVisitorBuilder() {
	    if (javaStoreGeneratorVisitorBuilder == null)
	        javaStoreGeneratorVisitorBuilder = new JavaStoreGeneratorVisitorBuilder(
	                this, "visitors",
	                specificEntityInterfaceName(),
	                visitorsBuilder().getVisitorInterface(),
	                entityFactoryBuilder().getType());
	    return javaStoreGeneratorVisitorBuilder;
	}

//	private Map<String, String> pendingTypeDeclarations = new HashMap<String, String>(256);// maps entityName to InterfaceName
//	public void addTypeDeclaration(String entityName, String interfaceName) {
//		pendingTypeDeclarations.put(entityName, interfaceName);
//	}
//	public void applyTypeDeclarations() {
//		Iterator i = pendingTypeDeclarations.entrySet().iterator();
//		while (i.hasNext()) {
//			Map.Entry entry = (Map.Entry) i.next();
//			entityInterfaceBuilders.get(entry.getKey()).addTypeDeclaration((String) entry.getValue());
//		}
//		pendingTypeDeclarations.clear();
//	}
	

	private Map<String, AbstractEntityBuilder> entityInterfaceBuilders = new HashMap<String, AbstractEntityBuilder>(256); // maps entityName to EntityInterfaceBuilder
	public SimpleEntityInterfaceBuilder simpleEntityInterfaceBuilder(String entityName) {
		SimpleEntityInterfaceBuilder builder = (SimpleEntityInterfaceBuilder) entityInterfaceBuilders.get(entityName);
	    if (builder == null) {
	    	entityInterfaceBuilders.put(entityName, builder = new SimpleEntityInterfaceBuilder(this, modelSuffix(), entityName));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public CompositeEntityInterfaceBuilder compositeEntityInterfaceBuilder(String entityName, String componentType, String javaCompositeType) {
		CompositeEntityInterfaceBuilder builder = (CompositeEntityInterfaceBuilder) entityInterfaceBuilders.get(entityName);
	    if (builder == null) {
	    	entityInterfaceBuilders.put(entityName, builder = newCompositeEntityInterfaceBuilder(entityName, componentType, javaCompositeType));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public MapEntityInterfaceBuilder mapEntityInterfaceBuilder(String entityName, String keyType, String valueType) {
		MapEntityInterfaceBuilder builder = (MapEntityInterfaceBuilder) entityInterfaceBuilders.get(entityName);
	    if (builder == null) {
	    	entityInterfaceBuilders.put(entityName, builder = newMapEntityInterfaceBuilder(entityName, keyType, valueType));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public DataEntityInterfaceBuilder primitiveEntityInterfaceBuilder(String entityName, String primitiveType, String fName) {
		DataEntityInterfaceBuilder builder = (DataEntityInterfaceBuilder) entityInterfaceBuilders.get(entityName);
	    if (builder == null) {
	    	entityInterfaceBuilders.put(entityName, builder = newDataEntityInterfaceBuilder(entityName, primitiveType, fName));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}


	private Map<String, CompilationUnitBuilder> adapterBuilders = new HashMap<String, CompilationUnitBuilder>(256); // maps entityName to EntityAdapterBuilder
	public EntityAdapterBuilder entityAdapterBuilder(String entityName) {
		EntityAdapterBuilder builder = (EntityAdapterBuilder) adapterBuilders.get(entityName);
	    if (builder == null) {
	    	adapterBuilders.put(entityName, builder = new EntityAdapterBuilder(this, entityName));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public EntityAdapterBuilder compositeEntityAdapterBuilder(String entityName, String abstractAdapterName, String componentType) {
		EntityAdapterBuilder builder = (EntityAdapterBuilder) adapterBuilders.get(entityName);
	    if (builder == null) {
	    	adapterBuilders.put(entityName, builder = new EntityAdapterBuilder(this, entityName, abstractAdapterName, componentType, null));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public EntityAdapterBuilder mapEntityAdapterBuilder(String entityName, String keyType, String valueType) {
		EntityAdapterBuilder builder = (EntityAdapterBuilder) adapterBuilders.get(entityName);
	    if (builder == null) {
	    	adapterBuilders.put(entityName, builder = new EntityAdapterBuilder(this, entityName, AbstractMapEntityAdapter.class.getName(), keyType, valueType));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}

	private Map<String, CompilationUnitBuilder> entityBuilders = new HashMap<String, CompilationUnitBuilder>(256); // maps entityName to EntityBuilder
	public SimpleEntityImplBuilder simpleEntityBuilder(String entityName) {
	    SimpleEntityImplBuilder builder = (SimpleEntityImplBuilder) entityBuilders.get(entityName);
	    if (builder == null) {
	        entityBuilders.put(entityName, builder = new SimpleEntityImplBuilder(this, modelImplSuffix(), entityName));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public CompositeEntityImplBuilder compositeEntityBuilder(String entityName, String componentType, String compositeType, boolean isReference, boolean isStrict) {
		CompositeEntityImplBuilder builder = (CompositeEntityImplBuilder) entityBuilders.get(entityName);
	    if (builder == null) {
	        entityBuilders.put(entityName, builder = newCompositeEntityBuilder(entityName, componentType, compositeType, isReference, isStrict));
	        if (isStrict)
	        	entityBuilders.put(entityName, null);//FIXME workaround
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public MapEntityImplBuilder mapEntityBuilder(String entityName, String keyType, String valueType, boolean isReference) {
		MapEntityImplBuilder builder = (MapEntityImplBuilder) entityBuilders.get(entityName);
	    if (builder == null) {
	        entityBuilders.put(entityName, builder = newMapEntityBuilder(entityName, keyType, valueType, isReference));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public DataEntityImplBuilder primitiveEntityBuilder(String entityName, String primitiveType, String fName) {
		DataEntityImplBuilder builder = (DataEntityImplBuilder) entityBuilders.get(entityName);
	    if (builder == null) {
	        entityBuilders.put(entityName, builder = newDataEntityBuilder(entityName, primitiveType, fName));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public EnumTypeBuilder enumTypeBuilder(String enumName, String valueType) {
		EnumTypeBuilder builder = (EnumTypeBuilder) entityBuilders.get(enumName);
	    if (builder == null) {
	        entityBuilders.put(enumName, builder = newEnumTypeBuilder(enumName, valueType));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}
	public InterfaceEntityBuilder interfaceEntityBuilder(String name) {
		InterfaceEntityBuilder builder = (InterfaceEntityBuilder) entityBuilders.get(name);
	    if (builder == null) {
	        entityBuilders.put(name, builder = newInterfaceEntityBuilder(name));
	        //notifyAdded("entityBuilder", builder);
	    }
	    return builder;
	}

	public CompositeEntityInterfaceBuilder newCompositeEntityInterfaceBuilder(String fType, String componentType, String javaCompositeType) {
	    return new CompositeEntityInterfaceBuilder(this, modelSuffix(), fType, componentType, javaCompositeType);
	}
	public MapEntityInterfaceBuilder newMapEntityInterfaceBuilder(String fType, String keyType, String valueType) {
	    return new MapEntityInterfaceBuilder(this, modelSuffix(), fType, keyType, valueType);
	}
	public DataEntityInterfaceBuilder newDataEntityInterfaceBuilder(String fType, String dataType, String fName) {
	    return new DataEntityInterfaceBuilder(this, modelSuffix(), fType, dataType, fName);
	}

	public DataCommandBuilder newDataCommandBuilder(String fType, String dataType, String fName) {
	    return new DataCommandBuilder(this, "ui.commands", fType, dataType, fName);
	}
	public DataDirectEditPolicyBuilder newDataDirectEditPolicyBuilder(String fType, String dataType, String fName) {
	    return new DataDirectEditPolicyBuilder(this, "ui.editpolicies", fType, dataType, fName);
	}
	public DataPartBuilder newDataPartBuilder(String fType, String dataType, String fName) {
	    return new DataPartBuilder(this, "ui.editparts", fType, dataType, fName);
	}
	public DataEntityImplBuilder newDataEntityBuilder(String fType, String dataType, String fName) {
	    return new DataEntityImplBuilder(this, modelImplSuffix(), fType, dataType, fName);
	}
	public EnumTypeBuilder newEnumTypeBuilder(String enumType, String valueType) {
	    return new EnumTypeBuilder(this, enumType, valueType);
	}
	public EnumDirectEditPolicyBuilder newEnumDirectEditPolicyBuilder(String fType, String primitiveType, String fName) {
	    return new EnumDirectEditPolicyBuilder(this, "ui.editpolicies", fType, primitiveType, fName);
	}
	public CompositeEntityImplBuilder newCompositeEntityBuilder(String fType, String componentType, String compositeType, boolean isReference, boolean isStrict) {
	    return new CompositeEntityImplBuilder(this, modelImplSuffix(), fType, componentType, compositeType, isReference, isStrict);
	}
	public MapEntityImplBuilder newMapEntityBuilder(String fType, String keyType, String valueType, boolean isReference) {
	    return new MapEntityImplBuilder(this, modelImplSuffix(), fType, keyType, valueType, isReference);
	}
	public InterfaceEntityBuilder newInterfaceEntityBuilder(String name) {
	    return new InterfaceEntityBuilder(this, modelSuffix(), name);
	}

	public FigureBuilder newFigureBuilder(String name) {
	    return new FigureBuilder(this, "ui.figures", name);
	}

	public PartBuilder newPartBuilder(String partName, String entityName, String figureName) {
	    return new PartBuilder(this, "ui.editparts", partName, entityName, figureName);
	}

	public final String figuresPackage() {
	    return packagePrefix+".ui.figures";
	}
	public final String partsPackage() {
	    return packagePrefix+".ui.editparts";
	}
	public final String actionsPackage() {
	    return packagePrefix+".ui.actions";
	}
	public final String commandsPackage() {
	    return packagePrefix+".ui.commands";
	}
	public final String policiesPackage() {
	    return packagePrefix+".ui.editpolicies";
	}
	
	@Override
    public String getURI() {
    	if (uri == null)
    		uri = AbstractLanguageKit.calculateURI(packagePrefix, getModelName());
		return uri;
	}
	public final String languageDeployerName() {
		return packagePrefix+".reflect."+getModelName()+"LanguageDeployer";
	}
	public final String languageKitName() {
		return packagePrefix+".reflect."+getModelName()+"LanguageKit";
	}
	public final String editorKitName() {
		return editorKitName(getEditorName());
	}
	public final String editorKitName(String editorName) {
		return packagePrefix+".ui."+editorName+"EditorKit";
	}

	public final String specificModelContextName() {
		return specificBuildersPackage()+"."+getModelName()+"ModelContext";
	}
	public final String specificBuilderInterfaceName() {
		return specificBuildersPackage()+".I"+getModelName()+"Builder";
	}
	public final String specificIdentityBuilderContextName() {
		return specificBuildersPackage()+"."+getModelName()+"IdentityBuilderContext";
	}
	public final String genericBuilderAdapterName() {
		return specificBuildersPackage()+"."+getModelName()+"GenericBuilderAdapter";
	}
	public final String specificBuilderAdapterName() {
		return specificBuildersPackage()+"."+getModelName()+"SpecificBuilderAdapter";
	}
	public final String specificCodebaseBuilderName() {
		return specificBuildersPackage()+"."+getModelName()+"CodebaseBuilder";
	}

	public final String specificEntityDescriptorEnumName() {
		return specificReflectionPackage()+"."+getModelName()+"EntityDescriptorEnum";
	}
	public final String specificFeatureDescriptorEnumName() {
		return specificReflectionPackage()+"."+getModelName()+"FeatureDescriptorEnum";
	}

	public final String specificEntityInterfaceName() {
		return modelPackage()+".I"+getModelName()+"Entity";
	}

	public final String specificVisitorInterfaceName() {
		return specificVisitorsPackage()+".I"+getModelName()+"Visitor";
	}
	public final String specificVisitorFactoryName() {
		return specificVisitorsPackage()+"."+getModelName()+"TraversalFactory";
	}
	
	public final String visitorNameSuffix() {
		return "Visitor";
	}
	public final String strategyVisitorName(String strategy) {
		return specificVisitorsPackage()+"."+getModelName()+strategy+visitorNameSuffix();
	}
	public final String failureVisitorName() {
		return strategyVisitorName("Failure");
	}
	public final String identityVisitorName() {
		return strategyVisitorName("Identity");
	}
	public final String identityUnaryVisitorName() {
		return strategyVisitorName("IdentityUnary");
	}
	public final String identityDefaultVisitorName() {
		return strategyVisitorName("IdentityDefault");
	}
	public final String identitySwitchVisitorName() {
		return strategyVisitorName("IdentitySwitch");
	}
	public final String traverseOneVisitorName() {
		return strategyVisitorName("TraverseOne");
	}
	public final String traverseSomeVisitorName() {
		return strategyVisitorName("TraverseSome");
	}
	public final String traverseAllVisitorName() {
		return strategyVisitorName("TraverseAll");
	}
	public final String traverseAllChildrenVisitorName() {
		return strategyVisitorName("TraverseAllChildren");
	}
	public final String traverseAllAdjacentsVisitorName() {
		return strategyVisitorName("TraverseAllAdjacents");
	}
	public final String traverseAllSwitchVisitorName() {
		return strategyVisitorName("TraverseAllSwitch");
	}
	public final String forwardGenericVisitorName() {
		return strategyVisitorName("ForwardGeneric");
	}
	public final String forwardStagedVisitorName() {
		return strategyVisitorName("ForwardStaged");
	}
	public final String forwardStrategyVisitorName() {
		return strategyVisitorName("ForwardStrategy");
	}
	public final String sequenceVisitorName() {
		return strategyVisitorName("Sequence");
	}
	public final String resolverFactoryVisitorName() {
		return strategyVisitorName("ResolverFactory");
	}
	public final String partFactoryVisitorName() {
		return partFactoryVisitorName(getEditorName());
	}
	public final String partFactoryVisitorName(String editorName) {
		return partsPackage()+"."+editorName+"PartFactoryVisitor";
	}

	public final String entityFactoryInterfaceName() {
		return factoriesPackage()+".I"+getModelName()+"EntityFactory";
	}
	public final String entityFactoryName() {
		return factoriesPackage()+"."+getModelName()+"EntityFactory";
	}
	public final String adapterRegistryName() {
		return modelAdaptersPackage()+"."+getModelName()+"AdaptersEntityRegistry";
	}
	public final String implRegistryName() {
		return modelImplPackage()+"."+getModelName()+"ImplEntityRegistry";
	}
	public final String strictImplRegistryName() {
		return modelImplPackage()+"."+getModelName()+"StrictImplEntityRegistry";
	}
	public final String prototypeManagerName() {
		return specificReflectionPackage()+"."+getModelName()+"PrototypeManager";
	}
	public final String templateManagerName() {
		return specificReflectionPackage()+"."+getModelName()+"TemplateManager";
	}

	public final String entityDescriptorEntityName() {
		return /*modelImplPackage()+"."+*/getModelName()+"EntityDescriptor";
	}
	public final String booleanDataEntityName() {
		return /*modelImplPackage()+"."+*/getModelName()+"BooleanData";
	}
	public final String stringDataEntityName() {
		return /*modelImplPackage()+"."+*/getModelName()+"StringData";
	}

	public final String entityVariableName() {
		return /*modelImplPackage()+"."+*/getModelName()+"Variable";
	}

	public final String adapterFragmentName() {
		return /*modelImplPackage()+"."+*/getModelName()+"AdapterFragment";
	}
	public final String baseFragmentName() {
		return /*modelImplPackage()+"."+*/getModelName()+"BaseFragment";
	}
	public final String metaFragmentName() {
		return /*modelImplPackage()+"."+*/getModelName()+"MetaFragment";
	}
//	public final String topEntityName() {
//		return modelImplPackage()+"."+StringUtils.toSimpleName(getTopEntityName());
//	}
//	public final String topEntityImplName() {
//		return modelImplPackage()+"."+StringUtils.toSimpleName(getTopEntityImplName());
//	}
	public final String entityResolverName(String abstractEntityName) {
		return modelPackage()+"."+entityResolverSimpleName(abstractEntityName);
	}
	
	public final String partName(String entityName) {
		return partsPackage()+"."+StringUtils.toSimpleName(entityName)+"Part";
	}


	public final String actionFactoryName() {
		return actionsPackage()+"."+getEditorName()+"ActionFactory";
	}
	public final String commandFactoryName() {
		return actionsPackage()+"."+getEditorName()+"CommandFactory";
	}
}
