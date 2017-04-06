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
package org.whole.lang.reusables.visitors;

import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.PathExpression_ord;
import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.Reusable;
import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.Reusable_ord;
import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.Reusables;

import java.io.File;
import java.io.FileNotFoundException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.ResourceRegistry;
import org.whole.lang.reusables.factories.ReusablesEntityFactory;
import org.whole.lang.reusables.model.Adapt;
import org.whole.lang.reusables.model.Classpath;
import org.whole.lang.reusables.model.Contents;
import org.whole.lang.reusables.model.FileSystem;
import org.whole.lang.reusables.model.Folder;
import org.whole.lang.reusables.model.IReusablesEntity;
import org.whole.lang.reusables.model.Include;
import org.whole.lang.reusables.model.Load;
import org.whole.lang.reusables.model.Path;
import org.whole.lang.reusables.model.PathName;
import org.whole.lang.reusables.model.PathSegments;
import org.whole.lang.reusables.model.PathWithExtension;
import org.whole.lang.reusables.model.Persistence;
import org.whole.lang.reusables.model.PersistenceId;
import org.whole.lang.reusables.model.Registry;
import org.whole.lang.reusables.model.Resource;
import org.whole.lang.reusables.model.Reusable;
import org.whole.lang.reusables.model.Reuse;
import org.whole.lang.reusables.model.Save;
import org.whole.lang.reusables.model.Sync;
import org.whole.lang.reusables.model.URI;
import org.whole.lang.reusables.model.Workspace;
import org.whole.lang.reusables.operations.EvaluateCloneOperation;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Enrico Persiani
 */
public class ReusablesInterpreterVisitor extends ReusablesIdentityDefaultVisitor {
    @Override
	public void setResultIterator(IEntityIterator<?> iterator) {
		if (iterator != null)
			iterator.setBindings(getBindings());
		super.setResultIterator(iterator);
	}

    protected EvaluateCloneOperation evaluateCloneOperation;
    protected EvaluateCloneOperation getEvaluateCloneOperation() {
		if (evaluateCloneOperation == null) {
			evaluateCloneOperation = new EvaluateCloneOperation(getOperation(), entity -> Matcher.matchAnyImpl(entity,
					ReusablesEntityDescriptorEnum.Adapt, ReusablesEntityDescriptorEnum.Resource,
					ReusablesEntityDescriptorEnum.Include, ReusablesEntityDescriptorEnum.Reuse,
					ReusablesEntityDescriptorEnum.Sync));
		}
		return evaluateCloneOperation;
    }
   
    protected boolean isEvaluateCloneOperation() {
    	return getBindings().wIsSet("evaluateCloneOperation");
    }

    protected void evaluateAndClone(IEntity entity, IBindingManager bm) {
    	bm.setResult(getEvaluateCloneOperation().clone(entity));
    }
    protected void evaluateAndClone(IEntity entity) {
    	evaluateAndClone(entity, getBindings());
    }

    @Override
    public boolean visitAdapter(IEntityAdapter entity) {
    	setResult(null);

    	switch (entity.wGetEntityDescriptor().getOrdinal()) {

    	case Reusable_ord:
    		if (isEvaluateCloneOperation())
    			evaluateAndClone(entity.wGetAdaptee(false));
    		else
    			return super.visitAdapter(entity);
			return false;

		case PathExpression_ord:
//			setResultIterator(DynamicCompilerOperation.compile(entity.wGetAdaptee(false), getBindings()).getResultIterator());
			try {
				getBindings().wEnterScope();
				getBindings().wDef("self", entity.wGetAdaptee(false));
				setResultIterator(BehaviorUtils.lazyEvaluate(entity.wGetAdaptee(false), 0, getBindings()));
			} finally {
				getBindings().wExitScope();
			}
			return false;

		default:
			return super.visitAdapter(entity);
		}
    }

    @Override
    public void visit(IReusablesEntity entity) {
		if (isEvaluateCloneOperation())
			evaluateAndClone(entity);
    }

	@Override
	public void visit(Adapt entity) {
		Reusable reusable = entity.getAdapted();

		IEntityIterator<?> contentIterator = null;
		IEntityIterator<?> adapterIterator = null;
		if (EntityUtils.isResolver(reusable)) {
			contentIterator = IteratorFactory.constantIterator(entity.getOriginal(), false);

			if (EntityUtils.isNotResolver(entity.getAdapter())) {
				entity.getAdapter().accept(this);
				adapterIterator = getResultIterator();
			}
		}

		if (contentIterator == null)
			contentIterator = IteratorFactory.constantIterator(reusable, false);

		boolean updateAdapted = EntityUtils.isResolver(entity.getAdapted());
		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
			(selfEntity, bm, arguments) -> {
				try {
					getBindings().wEnterScope();
					getBindings().wDefValue("evaluateCloneOperation", true);
					evaluateAndClone(selfEntity, bm);
				} finally {
					getBindings().wExitScope();
				}
				if (updateAdapted) {
					Reusable adapted = EntityUtils.clone(bm.getResult()).wGetAdapter(Reusable);
					if (EntityUtils.isResolver(entity.getAdapted()))
						entity.setAdapted(adapted);
					else {
						if (!Matcher.matchImpl(Reusables, entity.getAdapted()))
							entity.setAdapted(ReusablesEntityFactory.instance.createReusables(EntityUtils.clone(entity.getAdapted())));
						entity.getAdapted().wAdd(adapted);
					}
				}
			}
		);

		IEntityIterator<? extends IEntity> expandIterator = adapterIterator != null ? 
				IteratorFactory.composeIterator(evaluateIterator, adapterIterator, contentIterator) :
					IteratorFactory.composeIterator(evaluateIterator, contentIterator);

		for (IEntity result : expandIterator) {
			stagedVisit(result.wGetAdaptee(false));
			setResult(result);
		}
	}

	@Override
	public void visit(Load entity) {
		setResultIterator(readResource(entity.getResource()));
	}

	@Override
	public void visit(Save entity) {
		setResultIterator(saveResource(entity.getResource()));
	}

	@Override
	public void visit(Include entity) {
		IEntityIterator<?> contentIterator = readResource(entity.getResource());

		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
				(selfEntity, bm, arguments) -> evaluateAndClone(selfEntity, bm));
		setResultIterator(IteratorFactory.composeIterator(evaluateIterator, contentIterator));
	}

	@Override
	public void visit(Reuse entity) {
		Reusable reusable = entity.getAdapted();

		Reusable original = CommonsEntityAdapterFactory.createResolver(Reusable);

		IEntityIterator<?> contentIterator = null;
		IEntityIterator<?> adapterIterator = null;
		if (EntityUtils.isResolver(reusable)) {
			try {
				getBindings().wEnterScope();
				getBindings().wDefValue("evaluateCloneOperation", true);

				reusable =  entity.getOriginal();
	
				if (EntityUtils.isResolver(reusable)) {
					contentIterator = readResource(entity.getResource());
					contentIterator.setBindings(getBindings());
					contentIterator.reset(entity);
					if (contentIterator.hasNext())
						original = EntityUtils.clone(contentIterator.next()).wGetAdapter(Reusable);
					if (contentIterator.hasNext()) {
						original = ReusablesEntityFactory.instance.createReusables(original);
						do {
							original.wAdd(EntityUtils.clone(contentIterator.next()).wGetAdapter(Reusable));
						} while (contentIterator.hasNext());
					}
					entity.setOriginal(original);
				}
				if (EntityUtils.isNotResolver(entity.getAdapter())) {
					entity.getAdapter().accept(this);
					adapterIterator = getResultIterator();
				}
			} finally {
				getBindings().wExitScope();
			}
		}

		if (contentIterator == null)
			contentIterator = IteratorFactory.constantIterator(reusable, false);

		boolean updateAdapted = EntityUtils.isResolver(entity.getAdapted());
		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
			(selfEntity, bm, arguments) -> {
				try {
					getBindings().wEnterScope();
					getBindings().wDefValue("evaluateCloneOperation", true);
					evaluateAndClone(selfEntity, bm);
				} finally {
					getBindings().wExitScope();
				}
				if (updateAdapted) {
					Reusable adapted = EntityUtils.clone(bm.getResult()).wGetAdapter(Reusable);
					if (EntityUtils.isResolver(entity.getAdapted()))
						entity.setAdapted(adapted);
					else {
						if (!Matcher.matchImpl(Reusables, entity.getAdapted()))
							entity.setAdapted(ReusablesEntityFactory.instance.createReusables(EntityUtils.clone(entity.getAdapted())));
						entity.getAdapted().wAdd(adapted);
					}
				}
			}
		);

		setResultIterator(adapterIterator != null ? 
				IteratorFactory.composeIterator(evaluateIterator, adapterIterator, contentIterator) :
					IteratorFactory.composeIterator(evaluateIterator, contentIterator));
	}

	@Override
	public void visit(Sync entity) {
		Reusable reusable = entity.getVariant();

		if (EntityUtils.isResolver(reusable))
			visit((Reuse) entity);
		else {
			setResultIterator(IteratorFactory.constantComposeIterator(reusable,
					IteratorFactory.singleValuedRunnableIterator(
							(selfEntity, bm, arguments) -> evaluateAndClone(selfEntity, bm)
			)));
		}
	}

	@Override
	public void visit(Registry entity) {
		entity.getRegistryUri().accept(this);
		String registryId = getResult().wStringValue();
		if (!ResourceRegistry.hasRegistry(registryId))
			throw new WholeIllegalArgumentException("Undefined registry "+registryId).withSourceEntity(entity).withBindings(getBindings());

		IResourceRegistry<IResource> registry = ResourceRegistry.getRegistry(registryId);

		entity.getUri().accept(this);
		String uri = getResult().wStringValue();

		String contextUri = getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;
		if (ResourceUtils.hasFragmentPart(uri) && registry instanceof CompoundResourceRegistry) {
			CompoundResourceRegistry<IResource> compoundRegistry = (CompoundResourceRegistry<IResource>) registry;
			setResult(compoundRegistry.getFunctionModel(uri, true, contextUri));
		} else
			setResult(registry.getResourceModel(uri, true, contextUri));
	}

	@Override
	public void visit(URI entity) {
//		if (EntityUtils.hasParent(entity) && EntityUtils.getParentFormalType(entity).equals(ReusablesEntityDescriptorEnum.Locator))
//			try {
//				setResult(BindingManagerFactory.instance.createValue(
//						new URLPersistenceProvider(new URL(entity.getValue()), getBindings())));
//			} catch (MalformedURLException e) {
//				throw new WholeIllegalArgumentException(e).withSourceEntity(entity).withBindings(getBindings());
//			}
//		else
			setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
	}

	@Override
	public void visit(Workspace entity) {
		throw new UnsupportedOperationException(WholeMessages.no_workspace);
	}

	@Override
	public void visit(Classpath entity) {
		IPersistenceKit persistenceKit = evaluatePersistence(entity.getPersistence());

		entity.getContent().accept(this);

		setResultIterator(IteratorFactory.composeIterator(
					IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
							IPersistenceProvider pp = new ClasspathPersistenceProvider(selfEntity.wStringValue(), bm);
	
							//TODO replace Object[] with IResource impl
							bm.setResult(BindingManagerFactory.instance.createValue(new Object[] {persistenceKit, pp}));
						}
					}).withSourceEntity(entity), getResultIterator()));
	}
	@Override
	public void visit(FileSystem entity) {
		IPersistenceKit persistenceKit = evaluatePersistence(entity.getPersistence());

		entity.getContent().accept(this);

		setResultIterator(IteratorFactory.composeIterator(
					IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
							IPersistenceProvider pp = new FilePersistenceProvider(new File(selfEntity.wStringValue()), bm);
	
							//TODO replace Object[] with IResource impl
							bm.setResult(BindingManagerFactory.instance.createValue(new Object[] {persistenceKit, pp}));
						}
					}).withSourceEntity(entity), getResultIterator()));
	}

	@Override
	public void visit(Contents entity) {
	   	int size = entity.wSize();
    	if (size == 1)
    		entity.get(0).accept(this);
    	else {
			IEntityIterator<? extends IEntity>[] iteratorChain = new IEntityIterator<?>[size];
			
	    	for (int i=0; i<size; i++) {
				entity.get(i).accept(this);
				iteratorChain[i] = getResultIterator();
			}
	
	    	setResultIterator(IteratorFactory.sequenceIterator(iteratorChain).withSourceEntity(entity));
    	}
	}

	@Override
	public void visit(Folder entity) {
		entity.getPath().accept(this);
		String path = getResult().wStringValue();

//TODO		entity.getPersistence();

		entity.getContent().accept(this);

		setResultIterator(IteratorFactory.composeIterator(
				IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
						bm.setResult(BindingManagerFactory.instance.createValue(
								appendSegment(path, selfEntity.wStringValue())));
					}
				}).withSourceEntity(entity), getResultIterator()));
	}

	@Override
	public void visit(org.whole.lang.reusables.model.File entity) {
		entity.getPath().accept(this);
		String path = getResult().wStringValue();

//TODO		entity.getPersistence();

		setResult(BindingManagerFactory.instance.createValue(path));
	}
	
	@Override
	public void visit(PathName entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
	}

	@Override
	public void visit(PathWithExtension entity) {
		entity.getPath().accept(this);
		String path = getResult().wStringValue();

		entity.getExtension().accept(this);
		String extension = getResult().wStringValue();

		setResult(BindingManagerFactory.instance.createValue(path + '.' + extension));
	}

	@Override
	public void visit(PathSegments entity) {
		StringBuilder sb = new StringBuilder();
		
		for (Path pathSegment : entity) {
			pathSegment.accept(this);
			appendSegment(sb, getResult().wStringValue());
		}
		setResult(BindingManagerFactory.instance.createValue(sb.toString()));
	}

	public static String appendSegment(String path, String segment) {
		StringBuilder sb = new StringBuilder(path);
		appendSegment(sb, segment);
		return sb.toString();
	}
	public static void appendSegment(StringBuilder sb, String segment) {
		int length = sb.length();
		if (length == 0)
			sb.append(segment);
		else if (sb.charAt(length-1) == '/')
			sb.append(segment.startsWith("/") ? segment.substring(1) : segment);
		else {
			if (!segment.startsWith("/"))
				sb.append('/');
			sb.append(segment);
		}
	}
	
	@Override
	public void visit(PersistenceId entity) {
		String persistenceKitId = entity.getValue();
		if (!ReflectionFactory.hasPersistenceKit(persistenceKitId))
			throw new WholeIllegalArgumentException("The Persistence requested is not deployed: "+persistenceKitId)
			.withSourceEntity(entity).withBindings(getBindings());

		setResult(BindingManagerFactory.instance.createValue(ReflectionFactory.getPersistenceKit(persistenceKitId)));			
	}

	public IPersistenceKit evaluatePersistence(Persistence persistence) {
		persistence.accept(this);
		IEntity result = getResult();
		IPersistenceKit persistenceKit = result != null ?
				EntityUtils.safeGetValue(result, ReflectionFactory.getDefaultPersistenceKit(), IPersistenceKit.class) :
				ReflectionFactory.getDefaultPersistenceKit();
		return persistenceKit;
	}

	protected IEntityIterator<?> readResource(Resource resource) {
		resource.accept(this);
		return Matcher.isAssignableAsIsFrom(
				QueriesEntityDescriptorEnum.PathExpression, resource.wGetAdaptee(false)) ?
						IteratorFactory.constantComposeIterator(resource.wGetParent(), getResultIterator()) :
							IteratorFactory.composeIterator(
									IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
										if (!BindingManagerFactory.instance.isVoid(selfEntity))
											bm.setResult(readModel(selfEntity));
									}).withSourceEntity(resource), getResultIterator());
	}

	public static IEntity readModel(IEntity resource) {
		Object[] pkpp = (Object[]) resource.wGetValue();
		IPersistenceKit pk = (IPersistenceKit) pkpp[0];
		IPersistenceProvider pp = (IPersistenceProvider) pkpp[1];

		try {
			return pk.readModel(pp);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(
					"Resource not found with the " + pk.getId() + " persistence at " + e.getMessage(), e);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Failed to load the resource with the given persistence: " + pk.getId(), e);
		}
	}

	protected IEntityIterator<?> saveResource(Resource resource) {
		//TODO add multiple save
		//FIXME path expression save

		resource.accept(this);
		return
//		return Matcher.isAssignableAsIsFrom(
//				QueriesEntityDescriptorEnum.PathExpression, resource.wGetAdaptee(false)) ?
//						IteratorFactory.constantComposeIterator(resource.wGetParent(), getResultIterator()) :
//							IteratorFactory.composeIterator(
									IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
										if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
											writeModel(selfEntity, arguments[0]);
											bm.setResult(selfEntity);
										}
									}, getResultIterator()).withSourceEntity(resource);
//									);
	}

	public static void writeModel(IEntity model, IEntity resource) {
		Object[] pkpp = (Object[]) resource.wGetValue();
		IPersistenceKit pk = (IPersistenceKit) pkpp[0];
		IPersistenceProvider pp = (IPersistenceProvider) pkpp[1];

		try {
			pk.writeModel(model, pp);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Failed to write the resource with the given persistence: " + pp + ", " + pk.getId(), e);
		}
	}
}
