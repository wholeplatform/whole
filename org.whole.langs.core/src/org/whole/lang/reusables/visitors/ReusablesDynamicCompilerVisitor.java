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

import java.io.File;
import java.net.MalformedURLException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.URLPersistenceProvider;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.reusables.model.Classpath;
import org.whole.lang.reusables.model.Contents;
import org.whole.lang.reusables.model.Delete;
import org.whole.lang.reusables.model.Exists;
import org.whole.lang.reusables.model.FileSystem;
import org.whole.lang.reusables.model.Folder;
import org.whole.lang.reusables.model.IReusablesEntity;
import org.whole.lang.reusables.model.Load;
import org.whole.lang.reusables.model.PathName;
import org.whole.lang.reusables.model.PathSegments;
import org.whole.lang.reusables.model.PathWithExtension;
import org.whole.lang.reusables.model.PersistenceId;
import org.whole.lang.reusables.model.Save;
import org.whole.lang.reusables.model.URI;
import org.whole.lang.reusables.model.URL;
import org.whole.lang.reusables.model.Workspace;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class ReusablesDynamicCompilerVisitor extends AbstractReusablesSemanticsVisitor {
	public void setResult(IEntity result, IEntity sourceEntity) {
		setResultIterator(IteratorFactory.instance.constantIterator(result, false).withSourceEntity(sourceEntity));
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		setResult(null);
		stagedVisit(entity.wGetAdaptee(false), 0);
		return false;
	}
	
	@Override
	public void visit(IReusablesEntity entity) {
		stagedDefaultVisit(entity, 0);
	}

	@Override
	public void visit(Exists entity) {
		setResultIterator(existsResource(entity.getResource()));
	}

	@Override
	public void visit(Delete entity) {
		setResultIterator(deleteResource(entity.getResource()));
	}

	@Override
	public void visit(Load entity) {
		setResultIterator(readResource(entity.getResource()));
	}

	@Override
	public void visit(Save entity) {
		setResultIterator(saveResource(entity.getResource()));
	}

	protected abstract static class ResourcePersistenceRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
				IPersistenceProvider pp = getPersistenceProvider(selfEntity.wStringValue(), bm);
				IPersistenceKit pk = getPersistenceKit(arguments[0]);

				//TODO replace Object[] with IResource impl
				bm.setResult(BindingManagerFactory.instance.createValue(new Object[] {pk, pp}));
			}
		}

		protected abstract IPersistenceProvider getPersistenceProvider(String path, IBindingManager bm);
		protected IPersistenceKit getPersistenceKit(IEntity persistence) {
			return persistence != null ?
					EntityUtils.safeGetValue(persistence, ReflectionFactory.getDefaultPersistenceKit(), IPersistenceKit.class) :
					ReflectionFactory.getDefaultPersistenceKit();
		}
	}

	@Override
	public void visit(Classpath entity) {
		entity.getPersistence().accept(this);
		IEntityIterator<?> persistenceIterator = getResultIterator();
		
		entity.getContent().accept(this);
		IEntityIterator<?> contentIterator = getResultIterator();

		setResultIterator(IteratorFactory.instance.composeIterator(
					IteratorFactory.instance.singleValuedRunnableIterator(new ResourcePersistenceRunnable() {
						protected IPersistenceProvider getPersistenceProvider(String path, IBindingManager bm) {
							return new ClasspathPersistenceProvider(path, bm);
						}
					}, new int[] { 0 }, persistenceIterator).withSourceEntity(entity), contentIterator));
	}

	@Override
	public void visit(FileSystem entity) {
		entity.getPersistence().accept(this);
		IEntityIterator<?> persistenceIterator = getResultIterator();
		
		entity.getContent().accept(this);
		IEntityIterator<?> contentIterator = getResultIterator();

		setResultIterator(IteratorFactory.instance.composeIterator(
				IteratorFactory.instance.singleValuedRunnableIterator(new ResourcePersistenceRunnable() {
					protected IPersistenceProvider getPersistenceProvider(String path, IBindingManager bm) {
						return new FilePersistenceProvider(new File(path), bm);
					}
				}, new int[] { 0 }, persistenceIterator).withSourceEntity(entity), contentIterator));
	}

	@Override
	public void visit(Workspace entity) {
		throw new UnsupportedOperationException(WholeMessages.no_workspace);
	}

	@Override
	public void visit(URL entity) {
		entity.getPersistence().accept(this);
		IEntityIterator<?> persistenceIterator = getResultIterator();
		
		entity.getContent().accept(this);
		IEntityIterator<?> contentIterator = getResultIterator();

		setResultIterator(IteratorFactory.instance.composeIterator(
				IteratorFactory.instance.singleValuedRunnableIterator(new ResourcePersistenceRunnable() {
					protected IPersistenceProvider getPersistenceProvider(String path, IBindingManager bm) {
						try { 
							return new URLPersistenceProvider(new java.net.URL(path), bm);
						} catch (MalformedURLException e) {
							throw new WholeIllegalArgumentException(e).withSourceEntity(entity).withBindings(bm);
						}
					}
				}, new int[] { 0 }, persistenceIterator).withSourceEntity(entity), contentIterator));
	}

	@Override
	public void visit(Contents entity) {
	   	int size = entity.wSize();
    	if (size == 1)
    		entity.get(0).accept(this);
    	else {
			IEntityIterator<? extends IEntity>[] contentIterators = new IEntityIterator<?>[size];

	    	for (int i=0; i<size; i++) {
				entity.get(i).accept(this);
				contentIterators[i] = getResultIterator();
			}

	    	setResultIterator(IteratorFactory.instance.sequenceIterator(contentIterators).withSourceEntity(entity));
    	}
	}

	@Override
	public void visit(Folder entity) {
		entity.getPath().accept(this);
		IEntityIterator<?> pathIterator = getResultIterator();

//TODO		entity.getPersistence();

		entity.getContent().accept(this);
		IEntityIterator<?> contentIterator = getResultIterator();

		setResultIterator(IteratorFactory.instance.composeIterator(
				IteratorFactory.instance.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
						bm.setResult(BindingManagerFactory.instance.createValue(
								appendSegment(
										arguments[0].wStringValue(),
										selfEntity.wStringValue())));
					}
				}, pathIterator).withSourceEntity(entity), contentIterator));
	}

	@Override
	public void visit(org.whole.lang.reusables.model.File entity) {
		entity.getPath().accept(this);
		IEntityIterator<?> pathIterator = getResultIterator();

//TODO		entity.getPersistence();

		setResultIterator(IteratorFactory.instance.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
						bm.setResult(BindingManagerFactory.instance.createValue(
								arguments[0].wStringValue()));
					}
				}, pathIterator).withSourceEntity(entity));
	}

	@Override
	public void visit(PathSegments entity) {
	   	int size = entity.wSize();
    	if (size == 1)
    		entity.get(0).accept(this);
    	else {
			IEntityIterator<? extends IEntity>[] segmentIterators = new IEntityIterator<?>[size];

	    	for (int i=0; i<size; i++) {
				entity.get(i).accept(this);
				segmentIterators[i] = getResultIterator();
			}

			setResultIterator(IteratorFactory.instance.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
				if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
					StringBuilder sb = new StringBuilder();
					
					for (IEntity pathSegment : arguments)
						appendSegment(sb, pathSegment.wStringValue());

					bm.setResult(BindingManagerFactory.instance.createValue(sb.toString()));
				}
			}, segmentIterators).withSourceEntity(entity));
    	}
	}

	@Override
	public void visit(PathWithExtension entity) {
		entity.getPath().accept(this);
		IEntityIterator<?> pathIterator = getResultIterator();

		entity.getExtension().accept(this);
		IEntityIterator<?> extensionIterator = getResultIterator();

		setResultIterator(IteratorFactory.instance.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
			if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
				bm.setResult(BindingManagerFactory.instance.createValue(
						arguments[0].wStringValue() + '.' + arguments[1].wStringValue()));
			}
		}, pathIterator, extensionIterator).withSourceEntity(entity));
	}

	@Override
	public void visit(PathName entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.getValue()), entity);
	}

	@Override
	public void visit(PersistenceId entity) {
		String persistenceKitId = entity.getValue();

		setResultIterator(IteratorFactory.instance.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					if (!ReflectionFactory.hasPersistenceKit(persistenceKitId))
						throw new WholeIllegalArgumentException("The Persistence is not deployed: "+persistenceKitId)
						.withSourceEntity(entity).withBindings(bm);

					bm.setResult(BindingManagerFactory.instance.createValue(
							ReflectionFactory.getPersistenceKit(persistenceKitId)));
				}).withSourceEntity(entity));
	}

	@Override
	public void visit(URI entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.getValue()), entity);
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
}
