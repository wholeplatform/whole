/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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

import static org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.codebase.URLPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.queries.iterators.QueriesIteratorFactory;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.ResourceRegistry;
import org.whole.lang.reusables.factories.ReusablesEntityFactory;
import org.whole.lang.reusables.model.Adapt;
import org.whole.lang.reusables.model.IReusablesEntity;
import org.whole.lang.reusables.model.Include;
import org.whole.lang.reusables.model.Locator;
import org.whole.lang.reusables.model.ReferenceStep;
import org.whole.lang.reusables.model.Registry;
import org.whole.lang.reusables.model.Resource;
import org.whole.lang.reusables.model.Reusable;
import org.whole.lang.reusables.model.Reuse;
import org.whole.lang.reusables.model.Synch;
import org.whole.lang.reusables.operations.EvaluateCloneOperation;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Enrico Persiani
 */
public class ReusablesInterpreterVisitor extends ReusablesIdentityDefaultVisitor {
    protected EvaluateCloneOperation evaluateCloneOperation;
    protected EvaluateCloneOperation getEvaluateCloneOperation() {
		if (evaluateCloneOperation == null) {
			evaluateCloneOperation = new EvaluateCloneOperation(getOperation(), entity -> Matcher.matchAnyImpl(entity,
					ReusablesEntityDescriptorEnum.Adapt, ReusablesEntityDescriptorEnum.Resource,
					ReusablesEntityDescriptorEnum.Include, ReusablesEntityDescriptorEnum.Reuse,
					ReusablesEntityDescriptorEnum.Synch));
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
		case Locator_ord:
		case Source_ord:
			setResultIterator(BehaviorUtils.lazyEvaluate(entity.wGetAdaptee(false), 0, getBindings()));
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

		String varName = "expanded";
		IEntityIterator<?> blockIterator = IteratorFactory.blockIterator(
				IteratorFactory.filterIterator(expandIterator, GenericMatcherFactory.instance.asVariableMatcher(varName)),
						QueriesIteratorFactory.callIterator(varName), IteratorFactory.variableIterator(varName));

		setResultIterator(QueriesIteratorFactory.scopeIterator(blockIterator, null, Collections.singleton(varName)));
	}

	@Override
	public void visit(ReferenceStep entity) {
		if (isEvaluateCloneOperation())
			return;

		entity.getSource().accept(this);

		IEntityIterator<?> contentIterator = Matcher.isAssignableAsIsFrom(
				QueriesEntityDescriptorEnum.PathExpression, entity.getSource().wGetAdaptee(false)) ?
						IteratorFactory.constantComposeIterator(entity, getResultIterator()) : getResultIterator();

		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
				(selfEntity, bm, arguments) -> evaluateAndClone(selfEntity, bm)
		);
		setResultIterator(IteratorFactory.composeIterator(evaluateIterator, contentIterator));
	}

	@Override
	public void visit(Include entity) {
		entity.getSource().accept(this);

		IEntityIterator<?> contentIterator = Matcher.isAssignableAsIsFrom(
				QueriesEntityDescriptorEnum.PathExpression, entity.getSource().wGetAdaptee(false)) ?
						IteratorFactory.constantComposeIterator(entity, getResultIterator()) : getResultIterator();

		IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(
				(selfEntity, bm, arguments) -> evaluateAndClone(selfEntity, bm)
		);
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
					entity.getSource().accept(this);
					contentIterator = Matcher.isAssignableAsIsFrom(
							QueriesEntityDescriptorEnum.PathExpression, entity.getSource().wGetAdaptee(false)) ?
									IteratorFactory.constantComposeIterator(entity, getResultIterator()) : getResultIterator();
	
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
	public void visit(Synch entity) {
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
		entity.getLocator().accept(this);
		String locator = getResult().wStringValue();
		IResourceRegistry<IResource> registry = ResourceRegistry.getRegistry(locator);

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
	public void visit(Resource entity) {
		entity.getPersistence().accept(this);
		IEntity persistence = getResult();

		String persistenceKitId = persistence != null && !BindingManagerFactory.instance.isVoid(persistence) &&
				ReflectionFactory.hasPersistenceKit(persistence.wStringValue()) ?
				persistence.wStringValue() : "org.whole.lang.xml.codebase.XmlBuilderPersistenceKit";

		IPersistenceKit persistenceKit = ReflectionFactory.getPersistenceKit(persistenceKitId);

		Locator locator = entity.getLocator();
		locator.accept(this);

		if (getBindings().hasResultIterator()) {
			IEntityIterator<?> locatorIterator = IteratorFactory.constantComposeIterator(entity, getResultIterator());

			IEntityIterator<?> evaluateIterator = IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
				public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
					try {
						bm.setResult(persistenceKit.readModel(new StringPersistenceProvider(selfEntity.wStringValue())));
					} catch (Exception e) {
						throw new IllegalArgumentException("Failed to load the resource with the given persistence: " + persistenceKitId, e);
					}
				}
			});

			setResultIterator(IteratorFactory.composeIterator(evaluateIterator, locatorIterator));

		} else {
			String location = getResult().wStringValue();

			IPersistenceProvider provider;
			switch (locator.wGetEntityDescriptor().getOrdinal()) {
			case ReusablesEntityDescriptorEnum.ClassPathURI_ord:
				provider = new ClasspathPersistenceProvider(location, getBindings());
				break;
			case ReusablesEntityDescriptorEnum.FileSystemPath_ord:
				provider = new FilePersistenceProvider(new File(location), getBindings());
				break;
			case ReusablesEntityDescriptorEnum.URI_ord:
				try {
					provider = new URLPersistenceProvider(new URL(location), getBindings());
				} catch (MalformedURLException e) {
					throw new IllegalArgumentException(e);
				}
				break;
			case ReusablesEntityDescriptorEnum.WorkspacePath_ord:
			default:
				//TODO provider = new IFilePersistenceProvider(new File(locatorString), getBindings());
				throw new UnsupportedOperationException();
			}

			try {
				setResult(persistenceKit.readModel(provider));
			} catch (Exception e) {
				throw new IllegalArgumentException("Failed to load the resource with the given persistence: " + 
						location + ", " + persistenceKitId, e);
			}
		}
	}
}
