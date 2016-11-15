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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.DataTypePersistenceKit;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.ObjectPersistenceKit;
import org.whole.lang.codebase.PrettyPrintPersistenceKit;
import org.whole.lang.contexts.EntityContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.lifecycle.ITransaction;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.IFragmentModel;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.model.NullFragmentModel;
import org.whole.lang.operations.MetaModelMapperOperation;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.LanguageKitResourceFactory;
import org.whole.lang.resources.ResourceRegistry;
import org.whole.lang.templates.ITemplateFactory;
import org.whole.lang.templates.ResourceTemplateFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @author Riccardo Solmi
 */
public class ReflectionFactory {
	private static ClassLoader platformClassLoader;

	private static IResourceRegistry<ILanguageKit> languageKitRegistry;
	static {
		languageKitRegistry = ResourceRegistry.getRegistry(ILanguageKit.class.getName());
		languageKitRegistry.getResourceFactoryRegistry().setDefaultResourceFactory(
				new LanguageKitResourceFactory(languageKitRegistry.getResourceFactoryRegistry()));
	}

    private static SortedSet<IEditorKit> editorKitsSet = new TreeSet<IEditorKit>();
	private static Map<String, IEditorKit> editorKitsMap = new TreeMap<String, IEditorKit>();

    private static IPersistenceKit defaultPersistenceKit;
    private static Map<String, IPersistenceKit> editorIdPersistenceKitMap = new HashMap<String, IPersistenceKit>();
    private static Map<IPersistenceKit, List<String>> persistenceKitEditorIdMap = new HashMap<IPersistenceKit, List<String>>();
	private static Map<String, IPersistenceKit> persistenceKitsMap = new TreeMap<String, IPersistenceKit>();
    private static SortedSet<IPersistenceKit> persistenceKits = new TreeSet<IPersistenceKit>();

	private static final ReflectionFactory instance = new ReflectionFactory();
	protected ReflectionFactory() {
//workaround for Android compatibility
//was		addPersistenceKit("org.whole.lang.XmlBeansEditor", BeansPersistenceKit.instance());
		try {
			Class<?> clazz = Class.forName("org.whole.lang.codebase.BeansPersistenceKit", true, getClass().getClassLoader());
			Method method = clazz.getMethod("instance", new Class[0]);
			addPersistenceKit("org.whole.lang.XmlBeansEditor", (IPersistenceKit) method.invoke(null, new Object[0]));
		} catch (Exception e) {
		}
		addPersistenceKit("org.whole.lang.ObjectEditor", ObjectPersistenceKit.instance());	
		addPersistenceKit("org.whole.lang.DataTypeEditor", DataTypePersistenceKit.instance());	
		persistenceKitsMap.put(PrettyPrintPersistenceKit.instance().getId(), PrettyPrintPersistenceKit.instance());
	}

	public static void deploy(String deployerClassName) {
		deploy(ReflectionFactory.<IDeployer> instantiateClass(deployerClassName));
    }
    public static void deploy(Class<? extends IDeployer> deployerClass) {
    	deploy(instantiateClass(deployerClass));
    }
    public static void deploy(IDeployer deployer) {
		deployer.deploy(ReflectionFactory.instance);
    }
	public static void undeploy(String deployerClassName) {
		undeploy(ReflectionFactory.<IDeployer> instantiateClass(deployerClassName));
    }
    public static void undeploy(Class<? extends IDeployer> deployerClass) {
    	undeploy(instantiateClass(deployerClass));
    }
    public static void undeploy(IDeployer deployer) {
		deployer.undeploy(ReflectionFactory.instance);
    }

    private static WholePlatformDeployer wholePlatformDeployer = null;
    public static synchronized void deployWholePlatform() {
    	if (wholePlatformDeployer == null) {
    		WholePlatformDeployer newWholePlatformDeployer = new WholePlatformDeployer();
    		deploy(newWholePlatformDeployer);
    		wholePlatformDeployer = newWholePlatformDeployer;
    	}
    }
    public static synchronized void undeployWholePlatform() {
    	if (wholePlatformDeployer != null) {
    		undeploy(wholePlatformDeployer);
    		wholePlatformDeployer = null;
    	}
    }
    private static synchronized void resetWholePlatformDeployer() {
    	wholePlatformDeployer = null;
    }
    public static class WholePlatformDeployer extends AbstractSafeSuiteDeployer {
    	public int getDeployLevel() {
    		return IDeployer.LEVEL_LANGUAGE;
    	}

    	public WholePlatformDeployer() {
    		super(
    				"org.whole.lang.commons.reflect.CommonsLanguageDeployer",
        			"org.whole.langs.core.CoreLanguagesDeployer",
        			"org.whole.langs.legacy.LegacyLanguagesDeployer",
        			"org.whole.langs.db.DBLanguagesDeployer",
        			"org.whole.langs.core.CoreDynamicLanguagesDeployer",
        			"org.whole.langs.legacy.LegacyDynamicLanguagesDeployer",
        			"org.whole.langs.core.op.WorkflowsInterpreterDeployer",
        			"org.whole.langs.core.op.CoreOperationsDeployer",
        			"org.whole.langs.legacy.op.LegacyOperationsDeployer",
        			"org.whole.langs.core.CoreMetaModelsDeployer",
        			"org.whole.langs.legacy.LegacyMetaModelsDeployer",
        			"org.whole.langs.db.op.DBContributionsDeployer",
        			"org.whole.langs.core.op.CoreContributionsDeployer"
        	);
    	}
    }

    public static final String CLASS_LOADER_VAR = "classLoader";
    public static ClassLoader getClassLoader(IBindingManager bm) {
    	return bm.wIsSet(CLASS_LOADER_VAR) ? (ClassLoader) bm.wGetValue(CLASS_LOADER_VAR) : getPlatformClassLoader();
    }
    public static ClassLoader setClassLoader(IBindingManager bm, ClassLoader cl) {
    	ClassLoader oldCL = getClassLoader(bm);
    	bm.wDefValue(CLASS_LOADER_VAR, cl);
    	return oldCL;
    }

	public static ClassLoader getPlatformClassLoader() {
		if (platformClassLoader == null)
			platformClassLoader = ReflectionFactory.instance.getClass().getClassLoader();
		return platformClassLoader;
	}
	public static void setUserClassLoader(ClassLoader classLoader) {
    	try {
    		Class<?> rfClass = Class.forName(ReflectionFactory.instance.getClass().getName(), true, classLoader);
    		if (rfClass != ReflectionFactory.instance.getClass()) 
        		throw new IllegalArgumentException("Inconsistent class loaders hierarchy");
    		platformClassLoader = classLoader;
    	} catch (ClassNotFoundException e) {
    		platformClassLoader = new OrderedClassLoader(getPlatformClassLoader(), classLoader);
		}
	}
	public static class OrderedClassLoader extends ClassLoader {
		private ClassLoader userClassLoader;
		
		public OrderedClassLoader(ClassLoader platformClassLoader, ClassLoader userClassLoader) {
			super(platformClassLoader);
			setUserClassLoader(userClassLoader);
		}

		public void setUserClassLoader(ClassLoader userClassLoader) {
			this.userClassLoader = userClassLoader;
		}
		
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			try {
				return super.findClass(name);
			} catch (ClassNotFoundException e) {
				return userClassLoader.loadClass(name);
			}
		}
	}

	@SuppressWarnings("unchecked")
    public static <T> T instantiateClass(String className) {
    	try {
    		return instantiateClass((Class<T>) Class.forName(className, true, getPlatformClassLoader()));
    	} catch (ClassNotFoundException e) {
    		throw new DeployerException(e);
		}
    }
    public static <T> T instantiateClass(Class<T> clazz) {
    	try {
    		return clazz.newInstance();
    	} catch (Exception e) {
    		throw new DeployerException(e);
    	}
    }

    public synchronized void addLanguageKit(ILanguageKit languageKit) {
    	if (!languageKitRegistry.addResource(languageKit, false))
            resetWholePlatformDeployer();

		updatePersistenceAndEditorKits(languageKit);
    }
    public static void updatePersistenceAndEditorKits(ILanguageKit languageKit) {
		InternalILanguageKit internalILanguageKit = (InternalILanguageKit) languageKit;

		for (IPersistenceKit persistenceKit : getPersistenceKits())
			if (persistenceKit.canApply(languageKit))
				internalILanguageKit.addPersistenceKit(persistenceKit);
			else
				internalILanguageKit.removePersistenceKit(persistenceKit);

		for (IEditorKit editorKit : getEditorKits())
			if (editorKit.canApply(languageKit))
				internalILanguageKit.addEditorKit(editorKit);
			else
				internalILanguageKit.removeEditorKit(editorKit);
    }

    public synchronized void removeLanguageKit(String languageURI) {
    	if (languageKitRegistry.removeResource(languageURI))
            resetWholePlatformDeployer();
    }

    public static IResourceRegistry<ILanguageKit> getLanguageKitRegistry() {
    	return languageKitRegistry;
    }
    public static Collection<ILanguageKit> getLanguageKits(boolean includeHidden) {
    	return languageKitRegistry.getResources(includeHidden);
    }
    public static SortedSet<ILanguageKit> getLanguageKits(boolean includeHidden, Comparator<? super ILanguageKit> comparator) {
    	return languageKitRegistry.getResources(includeHidden, comparator);
    }
	public static IEntityIterator<IEntity> languageKitsIterator() {
		return IteratorFactory.javaCollectionIterator(getLanguageKits(false, ResourceUtils.SIMPLE_COMPARATOR));
	}
	public static IEntityIterator<IEntity> entityDescriptorIterator(ILanguageKit languageKit) {
		if (languageKit == null)
			return IteratorFactory.emptyIterator();
		else
			return IteratorFactory.javaCollectionIterator(languageKit.getEntityDescriptorEnum());
	}
	public static EntityDescriptor<?> firstEntityDescriptor(ILanguageKit languageKit, String optName, boolean excludeAbstract) {
		EntityDescriptorEnum edEnum = languageKit.getEntityDescriptorEnum();
		EntityDescriptor<?> ed = null;
		if (optName != null && optName.length() > 0)
			ed = edEnum.valueOf(optName);
		if (ed == null || (ed.isAbstract() && excludeAbstract)) {
			if (excludeAbstract) {
				Iterator<EntityDescriptor<?>> iterator = edEnum.values().iterator();
				EntityDescriptor<?> nextED;
				while (ed == null && iterator.hasNext())
					if (!(nextED = iterator.next()).isAbstract())
						ed = nextED;
			} else
				ed = edEnum.valueOf(0);
		}
		return ed;
	}

	@Deprecated
    public static boolean hasLanguageKit(String languageURI) {
    	return hasLanguageKit(languageURI, true, null);
    }
    public static boolean hasLanguageKit(String languageURI, boolean loadOnDemand, String contextURI) {
		return languageKitRegistry.containsResource(languageURI, loadOnDemand, contextURI) ||
			languageRequestHandler.containsLanguage(languageURI);
    }
	@Deprecated
    public static ILanguageKit getLanguageKit(String languageURI) {
    	return getLanguageKit(languageURI, true, null);
    }
    public static ILanguageKit getLanguageKit(String languageURI, boolean loadOnDemand, String contextURI) {
    	ILanguageKit languageKit = languageKitRegistry.getResource(languageURI, loadOnDemand, contextURI);
		if (languageKit == null)
			try {
				if (languageRequestHandler.deployLanguage(languageURI))
					languageKit = languageKitRegistry.getResource(languageURI, false, contextURI);
			} catch (Exception e) {
				throw new IllegalArgumentException("The Language: "+languageURI+" is not deployed.", e);
			}
		if (languageKit == null)
			throw new IllegalArgumentException("The Language: "+languageURI+" is not deployed.");
		return languageKit;
    }
	public static ILanguageKit safeGetLanguageKit(String languageURI, boolean loadOnDemand, String contextURI) {
		return languageURI != null && hasLanguageKit(languageURI, loadOnDemand, contextURI) ?
				getLanguageKit(languageURI, loadOnDemand, contextURI) : null;
	}


    public static ILanguageKit getLanguageKit(IEntity entity) {
        return entity.wGetEntityDescriptor().getLanguageKit();
    }
    public static IEditorKit getEditorKit(IEntity entity) {
    	if (entity.wIsAdapter() && EntityUtils.hasParent(entity))
    		return entity.wGetParent().wGetEditorKit();
    	else
    		return entity.wGetEditorKit();
    }

    private static ILanguageRequestHandler languageRequestHandler = NullLanguageRequestHandler.instance;
    public static ILanguageRequestHandler getLanguageRequestHandler() {
    	return languageRequestHandler;
	}
    public static void addLanguageRequestHandler(ILanguageRequestHandler handler) {
    	if (languageRequestHandler.getPriority() < handler.getPriority()) {
    		handler.addLanguageRequestHandler(languageRequestHandler);
    		languageRequestHandler = handler;
    	} else if (languageRequestHandler != handler)
    		languageRequestHandler.addLanguageRequestHandler(handler);
    }
    public static void removeLanguageRequestHandler(ILanguageRequestHandler handler) {
    	if (handler != languageRequestHandler)
    		languageRequestHandler.removeLanguageRequestHandler(handler);
    	else
    		languageRequestHandler = languageRequestHandler.removeLanguageRequestHandler(handler);
    }

    public void addReactionsHandler(String languageURI, IChangeEventHandler reactionsHandler) {
    	ILanguageKit languageKit = getLanguageKit(languageURI, false, null);
    	languageKit.addReactionsHandler(reactionsHandler);
    }
    public void addOperationFactory(String languageURI, String operationId, IVisitorFactory visitorFactory) {
    	ILanguageKit languageKit = getLanguageKit(languageURI, false, null);
    	languageKit.addVisitorFactory(operationId, visitorFactory);
    }
    public void addOperationFactory(String languageURI, String operationId, IBuilderFactory builderFactory) {
    	ILanguageKit languageKit = getLanguageKit(languageURI, false, null);
    	languageKit.addBuilderFactory(operationId, builderFactory);
    }

    public void addEditorKit(String editorId) {
			IEditorKit editorKit = instantiateClass(editorId);
			addEditorKit(editorKit);
	}
	public void addEditorKit(IEditorKit editorKit) {
    	if (editorKitsMap.containsKey(editorKit.getId()))
    		removeEditorKit(editorKit.getId());
		
		editorKitsMap.put(editorKit.getId(), editorKit);
		editorKitsSet.add(editorKit);
		// update language kits
		for (ILanguageKit languageKit : getLanguageKits(true))
			if (editorKit.canApply(languageKit))
				((InternalILanguageKit) languageKit).addEditorKit(editorKit);
	}

	public synchronized void removeEditorKit(String id) {
        IEditorKit old = editorKitsMap.remove(id);
        if (old != null) {
//            fileExtensionEditorKitMap.remove(old.getFileExtension());
            editorKitsSet.remove(old);
            // update language kits
			for (ILanguageKit languageKit : getLanguageKits(true))
				if (old.canApply(languageKit))
					((InternalILanguageKit) languageKit).removeEditorKit(old);
        }
    }


    public static Collection<IEditorKit> getEditorKits() {
    	return Collections.unmodifiableCollection(editorKitsSet);
    }
    public static Collection<IEditorKit> getEditorKits(String languageURI) {
    	return getLanguageKit(languageURI).getEditorKits();
    }
    public static boolean hasEditorKit(String editorId) {
        return editorKitsMap.containsKey(editorId);
    }
    public static IEditorKit getEditorKit(String editorId) {
        IEditorKit editorKit = editorKitsMap.get(editorId);
        if (editorKit == null)
        	throw new IllegalArgumentException("The Notation requested is not deployed: "+editorId);
		return editorKit;
    }

    public static void addPersistenceKit(IPersistenceKit persistenceKit) {
		if (persistenceKits.contains(persistenceKit))
			persistenceKitEditorIdMap.put(persistenceKit, removePersistenceKit(persistenceKit));
    	if (persistenceKits.add(persistenceKit)) {
        	persistenceKitsMap.put(persistenceKit.getId(), persistenceKit);
			// update language kits
			for (ILanguageKit languageKit : getLanguageKits(true))
				if (persistenceKit.canApply(languageKit))
					((InternalILanguageKit) languageKit).addPersistenceKit(persistenceKit);
    	}
    }
    public static List<String> removePersistenceKit(IPersistenceKit persistenceKit) {
    	List<String> editorIds = null;
    	if (persistenceKits.remove(persistenceKit)) {
        	persistenceKitsMap.remove(persistenceKit.getId());
	    	editorIds = persistenceKitEditorIdMap.remove(persistenceKit);
	    	if (editorIds != null)
	    		for (String editorId : editorIds)
	    			editorIdPersistenceKitMap.remove(editorId);
			// update language kits
			for (ILanguageKit languageKit : getLanguageKits(true))
				if (persistenceKit.canApply(languageKit))
					((InternalILanguageKit) languageKit).removePersistenceKit(persistenceKit);
    	}
		return editorIds;
    }    
    public static SortedSet<IPersistenceKit> getPersistenceKits() {
    	return Collections.unmodifiableSortedSet(persistenceKits);
    }
    public void addPersistenceKit(String editorId, IPersistenceKit persistenceKit) {
    	addPersistenceKit(persistenceKit);
    	editorIdPersistenceKitMap.put(editorId, persistenceKit);
    	List<String> editorIds = persistenceKitEditorIdMap.get(persistenceKit);
    	if (editorIds == null)
    		persistenceKitEditorIdMap.put(persistenceKit, editorIds = new ArrayList<String>());
    	editorIds.add(editorId);
    }

    public static boolean hasPersistenceKit(String persistenceKitId) {
		return persistenceKitsMap.containsKey(persistenceKitId);
	}
    public static IPersistenceKit getPersistenceKit(String persistenceKitId) {
    	IPersistenceKit persistenceKit = persistenceKitsMap.get(persistenceKitId);
    	if (persistenceKit == null)
    		throw new IllegalArgumentException("The Persistence requested is not deployed: "+persistenceKitId);
		return persistenceKit;
    }

    public static List<String> getEditorIdsFromPersistenceKit(IPersistenceKit persistenceKit) {
    	return persistenceKitEditorIdMap.get(persistenceKit);
    }
    public static String getEditorIdFromPersistenceKit(IPersistenceKit persistenceKit) {
    	List<String> editorIds = getEditorIdsFromPersistenceKit(persistenceKit);
    	return editorIds.get(editorIds.size()-1);
    }
    public static boolean hasAssociatedPersistenceKit(String editorId) {
		return editorIdPersistenceKitMap.containsKey(editorId);
	}
    public static IPersistenceKit getPersistenceKitFromEditorId(String editorId) {
    	IPersistenceKit kit = (IPersistenceKit) editorIdPersistenceKitMap.get(editorId);
    	if (kit == null)
    		return getDefaultPersistenceKit();
    	else
    		return kit;
    }
    public static IPersistenceKit getDefaultPersistenceKit() {
    	if (defaultPersistenceKit == null)
    		defaultPersistenceKit = ObjectPersistenceKit.instance();//BeansPersistenceKit.instance();//
    	return defaultPersistenceKit;
    }
    public static void setDefaultPersistenceKit(IPersistenceKit persistenceKit) {
    	defaultPersistenceKit = persistenceKit;
    }

    public static <E extends IEntity> E makeRootEntity(E entity) {
    	return makeRootEntity(entity, NullFragmentModel.instance);
    }
    public static <E extends IEntity> E makeRootEntity(E entity, IFragmentModel parentFragmentModel) {
    	IFragmentModel fragmentModel = getLanguageKit(entity).createFragmentModel();
    	if (parentFragmentModel != NullFragmentModel.instance)
    		fragmentModel.setCompoundModel(parentFragmentModel.getCompoundModel());
    	((InternalIEntity) entity).wSetModel(fragmentModel);
    	return entity;
    }

    public static IEntityContext newModelContext(IEntity entity) {
        return new EntityContext(entity);
    }

    public void setMetaModelTemplate(String languageURI, String templateName, String resourceClasspath) {
    	setMetaModelTemplate(languageURI, templateName, new ClasspathPersistenceProvider(resourceClasspath));
    }
    public void setMetaModelTemplate(String languageURI, String templateName, IPersistenceProvider pp) {
    	ITemplateFactory<?> templateFactory = new ResourceTemplateFactory<IEntity>(pp);

    	setMetaModelTemplate(languageURI, templateFactory);
    	if (templateName != null)
    		getLanguageKit("http://lang.whole.org/Models", false, null).getTemplateManager().put(templateName, templateFactory);
    }
    
    public void setMetaModelTemplate(String languageURI, ITemplateFactory<?> metaModelTemplate) {
    	getLanguageKit(languageURI).setMetaModelTemplate(metaModelTemplate);
    }
    public void unsetMetaModelTemplate(String languageURI) {
    	setMetaModelTemplate(languageURI, (ITemplateFactory<?>) null);
    }
    public void setMetaModelTemplate(String languageURI, String metaModelTemplateClassName) {
    	setMetaModelTemplate(languageURI, ReflectionFactory.<ITemplateFactory<?>> instantiateClass(metaModelTemplateClassName));
    }

    public static IEntity getMetaModel(String languageURI) {
    	return getLanguageKit(languageURI).getMetaModel();
    }
    public static IEntity getMetaModel(IEntity entity) {
    	return getLanguageKit(entity).getMetaModel();
    }

    public static IEntity getMetaEntity(IEntity entity) {
        return MetaModelMapperOperation.getMetaEntity(entity);
    }

    public static IHistoryManager getHistoryManager(IEntity entity) {
    	return entity.wGetModel().getCompoundModel().getHistoryManager();
    }
    public static ITransaction getTransaction(IEntity entity) {
    	return entity.wGetModel().getCompoundModel().getHistoryManager();
    }
}
