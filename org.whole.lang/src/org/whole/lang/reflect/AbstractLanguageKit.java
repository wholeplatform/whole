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
package org.whole.lang.reflect;

import java.util.Collections;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.ResolverEntityRegistryConfiguration;
import org.whole.lang.model.FragmentModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.IFragmentModel;
import org.whole.lang.model.impl.DynamicImplEntityRegistry;
import org.whole.lang.model.impl.DynamicStrictImplEntityRegistry;
import org.whole.lang.operations.IOperation;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.resources.Resource;
import org.whole.lang.templates.ITemplateFactory;
import org.whole.lang.templates.ModelTemplateFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractLanguageKit extends Resource implements InternalILanguageKit {
	private ITemplateFactory<?> metaModelTemplate;
	private SortedSet<IEditorKit> editorKitsSet = new TreeSet<IEditorKit>();
	private SortedSet<IPersistenceKit> persistenceKitsSet = new TreeSet<IPersistenceKit>();
	private Map<String, IBuilderFactory> builderMap = new TreeMap<String, IBuilderFactory>();
    private Map<String, IVisitorFactory> visitorMap = new TreeMap<String, IVisitorFactory>();
    private IChangeEventHandler reactionsHandler = IdentityChangeEventHandler.instance;
    private IEditorKit defaultEditorKit;
    private String defaultExtension;
    transient private IEntityRegistry[] entityRegistry;

	public AbstractLanguageKit() {
		getEntityDescriptorEnum().setLanguageKit(this);
		getFeatureDescriptorEnum().setLanguageKit(this);

		entityRegistry = new IEntityRegistry[RegistryConfigurations.values().length];
	}

	public boolean isDynamic() {
		return false;
	}
	public boolean isCurrent() {
		return ReflectionFactory.getLanguageKit(getURI(), false, null) == this;
	}

	public IEntity getMetaModel() {
		if (getMetaModelTemplate() == null)
			throw new IllegalArgumentException("The meta model of "+getName()+" language is not available.");
		return getMetaModelTemplate().share();
	}

	public ITemplateFactory<?> getMetaModelTemplate() {
		if (metaModelTemplate == null && getEntity() != null)
			metaModelTemplate = new ModelTemplateFactory<IEntity>(getEntity());
		return metaModelTemplate;
	}
	public void setMetaModelTemplate(ITemplateFactory<?> metaModelTemplate) {
		this.metaModelTemplate = metaModelTemplate;
	}

	public String getDefaultFileExtension() {
		if (defaultExtension == null)
			return getDefaultPersistenceKit().getFileExtension();
		else
			return defaultExtension;
	}
	public void setDefaultFileExtension(String defaultExtension) {
		this.defaultExtension = defaultExtension;
	}

	public SortedSet<IEditorKit> getEditorKits() {
		return Collections.unmodifiableSortedSet(editorKitsSet);
	}
	public IEditorKit getDefaultEditorKit() {
		return defaultEditorKit;
	}
	public void addEditorKit(IEditorKit editorKit) {
		if (editorKitsSet.isEmpty() || editorKit.getDefaultLevel() > defaultEditorKit.getDefaultLevel())
			defaultEditorKit = editorKit;

		editorKitsSet.add(editorKit);
	}
	public void removeEditorKit(IEditorKit removedEditorKit) {
		editorKitsSet.remove(removedEditorKit);
		if (removedEditorKit == defaultEditorKit) {
			defaultEditorKit = editorKitsSet.isEmpty() ? null : editorKitsSet.first();
			for (IEditorKit editorKit : editorKitsSet)
				if (editorKit.getDefaultLevel() > defaultEditorKit.getDefaultLevel())
					defaultEditorKit = editorKit;
		}
	}

	public SortedSet<IPersistenceKit> getPersistenceKits() {
		return Collections.unmodifiableSortedSet(persistenceKitsSet);
	}
	public IPersistenceKit getDefaultPersistenceKit() {
		return ReflectionFactory.getDefaultPersistenceKit();
	}
	public void addPersistenceKit(IPersistenceKit persistenceKit) {
		persistenceKitsSet.add(persistenceKit);
	}
	public void removePersistenceKit(IPersistenceKit removedPersistenceKit) {
		persistenceKitsSet.remove(removedPersistenceKit);
	}

	public IFragmentModel createFragmentModel() {
		return new FragmentModel(this, editorKitsSet.isEmpty() ? null : getDefaultEditorKit());
	}

	public final IEntityRegistry getEntityRegistry(RegistryConfigurations registryConfig) {
		IEntityRegistry registry = entityRegistry[registryConfig.ordinal()];
		if (registry == null) {
			switch (registryConfig) {
			case ADAPTER:
				registry = createAdaptersEntityRegistry();
				break;
			case RESOLVER:
				registry = createResolverEntityRegistry();
				break;
			case STRICT:
				registry = createStrictEntityRegistry();
				break;
			case CUSTOM:
				registry = createCustomEntityRegistry();
				break;
			case DEFAULT:
			default:
				registry = createDefaultEntityRegistry();
			}

			registry.finalizeRegistryConfiguration();
			entityRegistry[registryConfig.ordinal()] = registry;
		}
    	return registry;
    }

    protected abstract IEntityRegistry createAdaptersEntityRegistry();

    protected IEntityRegistry createResolverEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	ResolverEntityRegistryConfiguration.instance.apply(er);
    	return er;
    }
    protected IEntityRegistry createStrictEntityRegistry() {
    	IEntityRegistry er = createStrictImplEntityRegistry();
    	DefaultEntityRegistryConfiguration.instance.apply(er);
    	return er;
    }
    protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	DefaultEntityRegistryConfiguration.instance.apply(er);
    	return er;
    }

    protected IEntityRegistry createCustomEntityRegistry() {
    	return createDefaultEntityRegistry();
    }

    protected IEntityRegistry createDynamicEntityRegistry() {
    	return new DynamicImplEntityRegistry(getEntityDescriptorEnum());
    }
    protected IEntityRegistry createStrictDynamicEntityRegistry() {
    	return new DynamicStrictImplEntityRegistry(getEntityDescriptorEnum());
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
    	return createImplEntityRegistry();
    }
    protected abstract IEntityRegistry createImplEntityRegistry();

    public IDataTypeParser getDataTypeParser(DataTypeParsers kind) {
    	switch (kind) {
    	case PERSISTENCE:
    		return getDataTypePersistenceParser();
    	case PRESENTATION:
    	default:
    		return getDataTypePresentationParser();    		
    	}
    }
    protected IDataTypeParser getDataTypePersistenceParser() {
    	return DefaultDataTypePersistenceParser.instance;
    }
    protected IDataTypeParser getDataTypePresentationParser() {
    	return DefaultDataTypePresentationParser.instance;
    }

	public void addReactionsHandler(IChangeEventHandler eventHandler) {
		this.reactionsHandler = this.reactionsHandler.addChangeEventHandler(eventHandler);
	}
	public void removeReactionsHandler(IChangeEventHandler eventHandler) {
		this.reactionsHandler = this.reactionsHandler.removeChangeEventHandler(eventHandler);
	}
	public IChangeEventHandler getReactionsHandler() {
		return reactionsHandler;
	}

    public void addBuilderFactory(String operationId, IBuilderFactory builderFactory) {
        builderMap.put(operationId, builderFactory);
    }
    public boolean hasBuilder(String operationId) {
      return builderMap.containsKey(operationId);
    }
    public IBuilderFactory getBuilder(String operationId) {
    	IBuilderFactory builderFactory = builderMap.get(operationId);
		if (builderFactory == null)
			throw new IllegalArgumentException("The "+getName()+" language does not support the (builder) operation "+operationId+".");
        return builderFactory;
    }
    public String getBuilderType() {
    	String builderName = getClass().getName();
    	int i = builderName.lastIndexOf("reflect");
    	return builderName.substring(0, i)+"contexts.I"+getName()+"Builder";
    }

    public void addVisitorFactory(String operationId, IVisitorFactory visitorFactory) {
    	visitorMap.put(operationId, visitorFactory);
    }
	public boolean hasVisitor(String operationId) {
		return visitorMap.containsKey(operationId);
	}
	public boolean hasVisitor(IOperation operation) {
		return hasVisitor(operation.getOperationId());
	}
	public IVisitor getVisitor(IOperation operation, int stage) {
		IVisitorFactory visitorFactory = visitorMap.get(operation.getOperationId());
		if (visitorFactory == null)
			throw new IllegalArgumentException("The "+getName()+" language does not support the (visitor) operation "+operation.getOperationId()+".");

		return visitorFactory.create(operation, stage);
	}

	public static String defaultPackagePrefix() {
		return "org.whole.lang";
	}
	public static String defaultNamespace(String languageName) {
		return calculateNamespace(defaultPackagePrefix(), languageName);
	}
	public static String calculateNamespace(String packagePrefix, String languageName) {
		return packagePrefix+"."+languageName.toLowerCase();
	}
	public static String defaultURI(String languageName) {
		return calculateURI(defaultNamespace(languageName), languageName);
	}
	public static String calculateURI(String namespace, String languageName) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		String[] classArray = namespace.split("\\.");
		for (int i=classArray.length-2; i>=0; i--) {
			if (i==0)
				sb.append(classArray[i]);
			else
				sb.append(classArray[i]+".");
		}
		sb.append("/");
		sb.append(languageName);
		return sb.toString();
	}
}
