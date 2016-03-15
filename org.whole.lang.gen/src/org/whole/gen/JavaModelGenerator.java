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
package org.whole.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.whole.lang.model.AbstractEntity;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class JavaModelGenerator extends AbstractEntity {
	public final AST ast;
	public final List<CompilationUnit> cuList = new ArrayList<CompilationUnit>();
    private CompilationUnitBuilder currentBuilder;
    private String copyright = null;
    private String license = null;
    private String author = null;
	public String basePackagePrefix = null;
	public String packagePrefix = null;
	public String uri = null;
	public String version = "";

	public JavaModelGenerator() {
		this(AST.newAST(AST.JLS8), null);
	}
	public JavaModelGenerator(String packagePrefix) {
		this(AST.newAST(AST.JLS8), packagePrefix);
	}
	public JavaModelGenerator(AST ast, String packagePrefix) {
		this.ast = ast;
		setPackagePrefix(packagePrefix);
	}

    public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }

	public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
    	return version;
    }
    public void setVersion(String version) {
    	this.version = version;
    }

    public String getURI() {
    	if (uri == null)
    		uri = AbstractLanguageKit.defaultURI("");
		return uri;
	}
	public void setURI(String uri) {
		this.uri = uri;
	}

    public String getBasePackagePrefix() {
    	if (basePackagePrefix == null)
    		basePackagePrefix = AbstractLanguageKit.defaultPackagePrefix();
		return basePackagePrefix;
	}
	public void setBasePackagePrefix(String basePackagePrefix) {
		this.basePackagePrefix = basePackagePrefix;
	}
    public String getPackagePrefix() {
    	if (packagePrefix == null)
    		packagePrefix = getBasePackagePrefix();
		return packagePrefix;
	}
	public void setPackagePrefix(String packagePrefix) {
		this.packagePrefix = packagePrefix;
	}

    public String factoriesSuffix() {
    	return "factories";
    }
    public String modelSuffix() {
    	return "model";
    }
    public String modelImplSuffix() {
    	return "model.impl";
    }
    public String entityImplName(String entityName) {
    	return entityName+"Impl";
    }
    public String entityStrictImplName(String entityName) {
    	return entityName+"StrictImpl";
    }
    public String modelAdaptersSuffix() {
    	return "model.adapters";
    }
    public String entityAdapterName(String entityName) {
    	return entityName+"Adapter";
    }
    public String entityAdapterQName(String entityName) {
    	return modelAdaptersPackage()+"."+entityAdapterName(entityName);
    }
    public String entityInterfaceQName(String entityName) {
    	return modelPackage()+"."+StringUtils.toSimpleName(entityName);
    }

	public String codebasePackage() {
		return getPackagePrefix()+".codebase";
	}
	public final String factoriesPackage() {
	    return getPackagePrefix()+"."+factoriesSuffix();
	}
	public final String modelPackage() {
	    return getPackagePrefix()+"."+modelSuffix();
	}
	public final String modelImplPackage() {
	    return getPackagePrefix()+"."+modelImplSuffix();
	}
	public final String modelAdaptersPackage() {
	    return getPackagePrefix()+"."+modelAdaptersSuffix();
	}
	public String visitorsPackage() {
	    return CompilationUnitBuilder.LANG_PACKAGE+".visitors";
	}
	public String specificVisitorsPackage() {
	    return getPackagePrefix()+".visitors";
	}
	public String buildersPackage() {
	    return CompilationUnitBuilder.LANG_PACKAGE+".builders";
	}
	public String specificBuildersPackage() {
	    return getPackagePrefix()+".builders";
	}
	public String reflectionPackage() {
	    return CompilationUnitBuilder.LANG_PACKAGE+".reflect";
	}
	public String specificReflectionPackage() {
	    return getPackagePrefix()+".reflect";
	}

	public String entityDescriptorName() {
		return reflectionPackage()+".EntityDescriptor";
	}
	public String featureDescriptorName() {
		return reflectionPackage()+".FeatureDescriptor";
	}
	public String entityDescriptorEnumName() {
		return reflectionPackage()+".EntityDescriptorEnum";
	}
	public String featureDescriptorEnumName() {
		return reflectionPackage()+".FeatureDescriptorEnum";
	}
	public String specificEntityDescriptorEnumName() {
		return entityDescriptorEnumName();
	}
	public String specificFeatureDescriptorEnumName() {
		return featureDescriptorEnumName();
	}

	public String specificEntityInterfaceName() {
		return IEntity.class.getName();
	}
	public String abstractVisitorName() {
		return visitorsPackage()+".AbstractVisitor";
	}
	public String abstractUnaryVisitorName() {
		return visitorsPackage()+".AbstractUnaryVisitor";
	}
	public String abstractBinaryVisitorName() {
		return visitorsPackage()+".AbstractBinaryVisitor";
	}
	public String identityVisitorName() {
		return visitorsPackage()+".GenericVisitor";
	}
	public String visitorInterfaceName() {
		return visitorsPackage()+".IVisitor";
	}
	public String unaryVisitorName() {
		return visitorsPackage()+".IUnaryVisitor";
	}
	public String binaryVisitorName() {
		return visitorsPackage()+".IBinaryVisitor";
	}
	public String ternaryVisitorName() {
		return visitorsPackage()+".ITernaryVisitor";
	}
	public String javaStoreVisitorName() {
		return specificVisitorsPackage()+".JavaStoreGeneratorVisitor";
	}
	public String modelContextName() {
		return buildersPackage()+".ModelContext";
	}
	public String specificModelContextName() {
		return modelContextName();
	}

	public String adapterFragmentName() {
		return modelImplPackage()+".AdapterFragment";
	}
	public String baseFragmentName() {
		return modelImplPackage()+".BaseFragment";
	}
	public String metaFragmentName() {
		return modelImplPackage()+".MetaFragment";
	}

	public void addBuilder(CompilationUnitBuilder builder) {
		cuList.add(builder.getCompilationUnit());
	}
	public final CompilationUnitBuilder getCurrentBuilder() {
	    if (currentBuilder == null)
	        currentBuilder = new CompilationUnitBuilder(this);
	    return currentBuilder;
	}
	public final void setCurrentBuilder(CompilationUnitBuilder builder) {
	    this.currentBuilder = builder;
	}

	private JavaStoreBuilder javaStoreBuilder;
	public JavaStoreBuilder javaStoreBuilder() {
	    if (javaStoreBuilder == null)
	        javaStoreBuilder = new JavaStoreBuilder(this);
	    return javaStoreBuilder;
	}

	private SortedSet<String> entitySet = new TreeSet<String>(); // all entities types (empty and composite included) 
	public void putEntity(String entity) {
	    entitySet.add(StringUtils.toSimpleName(entity));
	}
	public Set<String> getEntitySet() {
	    return entitySet;
	}

	private Set<String> entityResolverSet = new HashSet<String>(); // types of optional features 
	public void putEntityResolver(String entity) {
	    entityResolverSet.add(entity);
	}
	public Set<String> getEntityResolverSet() {
	    return entityResolverSet;
	}
	public String entityResolverSimpleName(String typeName) {
		return StringUtils.toSimpleName(typeName);//+"Resolver";
	}

	private Set<String> optionalEntitySet = new HashSet<String>(); // types of optional features 
	public void putOptionalEntity(String entity) {
	    optionalEntitySet.add(entity);
	}
	public Set<String> getOptionalEntitySet() {
	    return optionalEntitySet;
	}
	
	private Map<String, String> compositeComponentMap = new HashMap<String, String>(); // composite to componentType
	public void putComposite(String compositeType, String componentType) {
		compositeComponentMap.put(compositeType, componentType);
	}
	public Set<Entry<String, String>> getCompositesEntrySet() {
		return compositeComponentMap.entrySet();
	}
	public Set<String> getAllComposites() {
		return compositeComponentMap.keySet();
	}
	public String getComponentType(String compositeType) {
	    return compositeComponentMap.get(compositeType);
	}
	    

	private Map<String, Set<String>> typeImplementationsMap = new HashMap<String, Set<String>>(); // type to set of implementations
	public void putPlaceHolderTypes(Set<String> markerTypes) {
		Set<String> placeHolderTypes = new HashSet<String>(markerTypes);
		placeHolderTypes.removeAll(getAllTypes());
		for (String placeHolderType : placeHolderTypes)
			putPlaceHolderType(placeHolderType);
	}
	public void putPlaceHolderType(String type) {
		Set<String> implementationSet = typeImplementationsMap.get(type);
		if (implementationSet == null)
			typeImplementationsMap.put(type, implementationSet = new HashSet<String>());
	}
	public void putImplementation(String type, String implementation) {
		Set<String> implementationSet = typeImplementationsMap.get(type);
		if (implementationSet == null)
			typeImplementationsMap.put(type, implementationSet = new HashSet<String>());
		
		implementationSet.add(implementation);
	}
	public Set<Entry<String, Set<String>>> getTypesEntrySet() {
		return typeImplementationsMap.entrySet();
	}
	public Set<String> getAllTypes() {
		return typeImplementationsMap.keySet();
	}
	public Set<String> getAllImplementations(String type) {
		Set<String> implementationSet = typeImplementationsMap.get(type);
		if (implementationSet == null) {
			implementationSet = new HashSet<String>();
			implementationSet.add(type);
		}
		return implementationSet;
	}

	private Map<String, Set<String>> typeSubtypesMap = new HashMap<String, Set<String>>(); // type to set of subtypes
	public void putSubtype(String type, String subtype) {
		Set<String> typesSet = typeSubtypesMap.get(type);
		if (typesSet == null)
			typeSubtypesMap.put(type, typesSet = new HashSet<String>());
		
		typesSet.add(subtype);
	}
	public Set<String> getAllSubtypes(String type) {
		Set<String> subtypesSet = typeSubtypesMap.get(type);
		if (subtypesSet == null) {
			subtypesSet = new HashSet<String>();
			subtypesSet.add(type);
		}
		return subtypesSet;
	}
	
//TODO deprecated
	public Set<String> getAllImplementationsClosure(String type) {
		Set<String> allImplementations = new HashSet<String>(getAllImplementations(type));
		Set<String> allTypes = new HashSet<String>(getAllSubtypes(type));
		Set<String> subtypes = new HashSet<String>(allTypes);
		getAllImplementationsClosure(allImplementations, allTypes, subtypes);
		return allImplementations;
	}
	public void getAllImplementationsClosure(Set<String> allImplementations, Set<String> allTypes, Set<String> subtypes) {
		for (String subtype : subtypes) {
			Set<String> newImplementations = getAllImplementations(subtype);
			allImplementations.addAll(newImplementations);
			
			Set<String> newSubtypes = getAllSubtypes(subtype);
			newSubtypes.removeAll(allTypes);
			if (!newSubtypes.isEmpty()) {
				allTypes.addAll(newSubtypes);
				getAllImplementationsClosure(allImplementations, allTypes, newSubtypes);
			}
		}
	}

	@Override
	public EntityDescriptor<?> wGetEntityDescriptor() {
		throw new UnsupportedOperationException();
	}
}
