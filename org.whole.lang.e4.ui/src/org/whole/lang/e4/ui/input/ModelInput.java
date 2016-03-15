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
package org.whole.lang.e4.ui.input;

import java.io.File;
import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.input.IModelInput;

/**
 * @author Enrico Persiani
 */
public class ModelInput implements IModelInput {
	protected final IPersistenceProvider persistenceProvider;
	protected final String basePersistenceKitId;
	protected String overridePersistenceKitId;
	protected Boolean readable;

	public ModelInput(IEclipseContext context, String location, String basePersistenceKitId) {
		this(context, createPersistenceProvider(location), basePersistenceKitId);
		
	}
	public ModelInput(IEclipseContext context, IPersistenceProvider persistenceProvider, String basePersistenceKitId) {
		this.persistenceProvider = persistenceProvider;
		this.basePersistenceKitId = basePersistenceKitId;
		this.overridePersistenceKitId = null;
		this.readable = null;
		E4Utils.defineResourceBindings(this.persistenceProvider.getBindings(), this);
		this.persistenceProvider.getBindings().wDefValue("eclipseContext", context);
	}

	@Override
	public String getName() {
		return getPersistenceProvider() instanceof IFilePersistenceProvider ?
				((IFilePersistenceProvider) persistenceProvider).getStore().getName() :
					((FilePersistenceProvider) persistenceProvider).getStore().getName();
	}
	@Override
	public String getLocation() {
		return getPersistenceProvider() instanceof IFilePersistenceProvider ?
				((IFilePersistenceProvider) persistenceProvider).getStore().getFullPath().toPortableString() :
					((FilePersistenceProvider) persistenceProvider).getStore().toURI().toASCIIString();
	}
	public static IPersistenceProvider createPersistenceProvider(String location) {
		try {
			File file = new File(new URI(location));
			return new FilePersistenceProvider(file);
		} catch (Exception e) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(Path.fromPortableString(location));
			return new IFilePersistenceProvider(file);
		}
	}

	@Override
	public IPersistenceProvider getPersistenceProvider() {
		return persistenceProvider;
	}

	@Override
	public IPersistenceKit getPersistenceKit() {
		return ReflectionFactory.getPersistenceKit(overridePersistenceKitId != null ?
				overridePersistenceKitId : basePersistenceKitId);
	}

	@Override
	public IPersistenceKit getBasePersistenceKit() {
		return ReflectionFactory.getPersistenceKit(basePersistenceKitId);
	}

	@Override
	public String getOverridePersistenceKitId() {
		return this.overridePersistenceKitId;
	}
	@Override
	public void setOverridePersistenceKitId(String overridePersistenceKitId) {
		this.overridePersistenceKitId = overridePersistenceKitId;
		this.readable = null;
	}

	@Override
	public IEntity readModel() throws Exception {
		try {
			IEntity readModel = getPersistenceKit().readModel(getPersistenceProvider());
			this.readable = true;
			return readModel;
		} catch (Exception e) {
			this.readable = false;
			throw e;
		}
	}

	@Override
	public boolean isReadable() {
		if (this.readable != null)
			return this.readable;

		try {
			getPersistenceKit().readModel(getPersistenceProvider());
			return this.readable = true;
		} catch (Exception e) {
			return this.readable = false;
		}
	}
}
