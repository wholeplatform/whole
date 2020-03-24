/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.io.FileNotFoundException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.ResourceRegistry;
import org.whole.lang.reusables.model.IReusablesEntity;
import org.whole.lang.reusables.model.Registry;
import org.whole.lang.reusables.model.Resource;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractReusablesSemanticsVisitor extends ReusablesIdentityDefaultVisitor {
	protected IEntity evaluate(IReusablesEntity entity) {
		setResult(null);
    	entity.accept(this);
    	IEntity result = getResult();
    	if (result == null)
    		throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(entity).withBindings(getBindings());
    	return result;
	}
	protected final boolean booleanValue(IReusablesEntity exp) {
		return evaluate(exp).wBooleanValue();
	}
	protected final int intValue(IReusablesEntity exp) {
		return evaluate(exp).wIntValue();
	}
	protected final String stringValue(IReusablesEntity exp) {
		return evaluate(exp).wStringValue();
	}

	
	protected IExecutable existsResource(Resource resource) {
		resource.accept(this);
		if (Matcher.match(ReusablesEntityDescriptorEnum.Model, resource)) {
			return executableFactory().createSome(executableFactory().createConstantCompose(resource.wGetParent(), getExecutableResult()));
		} else if (Matcher.match(ReusablesEntityDescriptorEnum.Registry, resource)) {
			Registry registryEntity = (Registry) resource;
			final IResourceRegistry<IResource> registry = getResourceRegistry(registryEntity);
			final String uri = stringValue(registryEntity.getUri());

			IRunnable runnable;
			if (ResourceUtils.hasFragmentPart(uri) && registry instanceof CompoundResourceRegistry) {
				final CompoundResourceRegistry<IResource> compoundRegistry = (CompoundResourceRegistry<IResource>) registry;

				runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					bm.setResult(BindingManagerFactory.instance.createValue(compoundRegistry.getFunctionModel(uri, false, bm) != null));
				};
			} else {
				final String resourceUri = ResourceUtils.stripFragmentPart(uri);

				runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					bm.setResult(BindingManagerFactory.instance.createValue(registry.containsResource(resourceUri, false, bm)));
				};
			}
			return executableFactory().createSingleValuedRunnable(runnable).withSourceEntity(resource);
		} else
			return executableFactory().createCompose(
					executableFactory().createSingleValuedRunnable((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity))
							bm.setResult(existsResourceOnProvider(selfEntity));
					}).withSourceEntity(resource), getExecutableResult());
	}

	public static IEntity existsResourceOnProvider(IEntity resource) {
		Object[] pkpp = (Object[]) resource.wGetValue();
		IPersistenceProvider pp = (IPersistenceProvider) pkpp[1];

		return BindingManagerFactory.instance.createValue(pp.exists());
	}

	protected IExecutable deleteResource(Resource resource) {
		resource.accept(this);
		if (Matcher.match(ReusablesEntityDescriptorEnum.Model, resource)) {
			return executableFactory().createConstantCompose(resource.wGetParent(), executableFactory().createDelete(getExecutableResult()));
		} else if (Matcher.match(ReusablesEntityDescriptorEnum.Registry, resource)) {
			Registry registryEntity = (Registry) resource;
			final IResourceRegistry<IResource> registry = getResourceRegistry(registryEntity);
			final String uri = stringValue(registryEntity.getUri());

			//TODO add delete function
			final String resourceUri = ResourceUtils.stripFragmentPart(uri);
			IRunnable runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
				bm.setResult(BindingManagerFactory.instance.createValue(registry.removeResource(resourceUri)));
			};
			return executableFactory().createSingleValuedRunnable(runnable).withSourceEntity(resource);
		} else
			return executableFactory().createCompose(
					executableFactory().createSingleValuedRunnable((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity))
							bm.setResult(deleteResourceFromProvider(selfEntity));
					}).withSourceEntity(resource), getExecutableResult());
	}

	public static IEntity deleteResourceFromProvider(IEntity resource) {
		Object[] pkpp = (Object[]) resource.wGetValue();
		IPersistenceProvider pp = (IPersistenceProvider) pkpp[1];

		try {
			return BindingManagerFactory.instance.createValue(pp.delete());
		} catch (Exception e) {
			return BindingManagerFactory.instance.createValue(false);
		}
	}

	protected IExecutable readResource(Resource resource) {
		resource.accept(this);
		if (Matcher.match(ReusablesEntityDescriptorEnum.Model, resource)) {
			return executableFactory().createConstantCompose(resource.wGetParent(), getExecutableResult());
		} else if (Matcher.match(ReusablesEntityDescriptorEnum.Registry, resource)) {
			Registry registryEntity = (Registry) resource;
			final IResourceRegistry<IResource> registry = getResourceRegistry(registryEntity);
			final String uri = stringValue(registryEntity.getUri());

			IRunnable runnable;
			if (ResourceUtils.hasFragmentPart(uri) && registry instanceof CompoundResourceRegistry) {
				final CompoundResourceRegistry<IResource> compoundRegistry = (CompoundResourceRegistry<IResource>) registry;

				runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					bm.setResult(compoundRegistry.getFunctionModel(uri, true, bm));
				};
			} else {
				final String resourceUri = ResourceUtils.stripFragmentPart(uri);

				runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					bm.setResult(registry.getResourceModel(resourceUri, true, bm));
				};
			}			
			return executableFactory().createSingleValuedRunnable(runnable).withSourceEntity(resource);
		} else
			return executableFactory().createCompose(
					executableFactory().createSingleValuedRunnable((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity))
							bm.setResult(readModel(selfEntity));
					}).withSourceEntity(resource), getExecutableResult());
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

	protected IExecutable saveResource(Resource resource) {
		//TODO add multiple save
		//FIXME path expression save

		if (Matcher.match(ReusablesEntityDescriptorEnum.Registry, resource)) {
			Registry registryEntity = (Registry) resource;
			final IResourceRegistry<IResource> registry = getResourceRegistry(registryEntity);
			final String uri = stringValue(registryEntity.getUri());

			IRunnable runnable;
			if (ResourceUtils.hasFragmentPart(uri) && registry instanceof CompoundResourceRegistry) {
				final CompoundResourceRegistry<IResource> compoundRegistry = (CompoundResourceRegistry<IResource>) registry;

				runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					compoundRegistry.putFunctionModel(uri, selfEntity);
					bm.setResult(selfEntity);
				};
			} else {
				runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					BehaviorUtils.evaluate(selfEntity, 0, bm);
					bm.setResult(selfEntity);
				};
			}
			return executableFactory().createSingleValuedRunnable(runnable).withSourceEntity(resource);
		} else {
			resource.accept(this);
			IExecutable resourceExecutable = getExecutableResult();

			IRunnable runnable = (IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
				if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
					writeModel(selfEntity, arguments[0]);
					bm.setResult(selfEntity);
				}
			};
			return executableFactory().createSingleValuedRunnable(runnable, resourceExecutable).withSourceEntity(resource);
		}
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

	protected IResourceRegistry<IResource> getResourceRegistry(Registry registryEntity) {
		registryEntity.getRegistryUri().accept(this);
		String registryId = getResult().wStringValue();
		if (!ResourceRegistry.hasRegistry(registryId))
			throw new WholeIllegalArgumentException("Undefined registry "+registryId).withSourceEntity(registryEntity).withBindings(getBindings());

		final IResourceRegistry<IResource> registry = ResourceRegistry.getRegistry(registryId);
		return registry;
	}
	
}
