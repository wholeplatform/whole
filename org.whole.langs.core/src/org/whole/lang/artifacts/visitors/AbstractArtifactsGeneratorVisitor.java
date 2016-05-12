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
package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.model.Attribute;
import org.whole.lang.artifacts.model.Author;
import org.whole.lang.artifacts.model.Copyright;
import org.whole.lang.artifacts.model.Extension;
import org.whole.lang.artifacts.model.License;
import org.whole.lang.artifacts.model.Name;
import org.whole.lang.artifacts.model.NameWithExtension;
import org.whole.lang.artifacts.model.PersistenceKitId;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.PrettyPrintPersistenceKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractArtifactsGeneratorVisitor extends ArtifactsTraverseAllVisitor {
	public final IBindingManager env() {
		return ((ArtifactsGeneratorOperation) getOperation()).getArtifactsEnvironment();
	}

	@Override
	public void visit(Name entity) {
		env().wDef("name", entity);
	}
	@Override
	public void visit(Extension entity) {
		env().wDef("extension", entity);
	}
	@Override
	public void visit(NameWithExtension entity) {
		super.visit(entity);
		env().wSetValue("name", env().wStringValue("name")+"."+env().wStringValue("extension"));
	}

	@Override
	public void visit(Copyright entity) {
		env().wDef("copyright", entity);
	}
	@Override
	public void visit(License entity) {
		env().wDef("license", entity);
	}
	@Override
	public void visit(Author entity) {
		env().wDef("author", entity);
	}

	@Override
	public void visit(Attribute entity) {
		env().wDefValue(entity.getValue().getName(), true);
	}

	@Override
	public void visit(PersistenceKitId entity) {
		env().wDefValue("persistenceKitId", entity.wStringValue());
	}

	protected void writeContents(IEntity model) {
		IPersistenceProvider pp = (IPersistenceProvider) env().wGetValue("persistenceProvider");
		boolean contentsWritten = false;
		if (env().wIsSet("persistenceKitId")) {
			IPersistenceKit pk = ReflectionFactory.getPersistenceKit(env().wStringValue("persistenceKitId"));
			if (pk.canApply(model))
				try {
					pk.writeModel(model, pp);
					contentsWritten = true;
				} catch (Exception inner) {
					throw new IllegalStateException(inner);
				}
		}
		try {
			if (!contentsWritten)
				PrettyPrintPersistenceKit.instance().writeModel(model, pp);
		} catch (RuntimeException runtime) {
			throw runtime;
		} catch (Exception outer) {
			throw new IllegalStateException(outer);
		}
	}
}
