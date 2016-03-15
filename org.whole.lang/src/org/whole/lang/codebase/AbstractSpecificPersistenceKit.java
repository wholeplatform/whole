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
package org.whole.lang.codebase;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractSpecificPersistenceKit extends AbstractPersistenceKit {
	private String languageURI;
	
	public AbstractSpecificPersistenceKit(String name, String fileExtension, String languageURI) {
		super(name, fileExtension);
		this.languageURI = languageURI;
	}

	public boolean isGeneric() {
		return false;
	}
	public boolean canApply(ILanguageKit languageKit) {
		return languageKit.getURI().equals(languageURI);
	}
	public boolean canApply(IEntity model) {
		try {
			GenericTraversalFactory.instance.topDown(new GenericIdentityVisitor() {
				public void visit(IEntity entity) {
					if ((EntityUtils.isResolver(entity) && isResolverAllowed(entity)) || canApply(entity.wGetLanguageKit()))
						return;
					throw new VisitException();
				}
			}, false).visit(model);
			return true;
		} catch (VisitException e) {
			return false;
		}
	}
	protected boolean isResolverAllowed(IEntity entity) {
		IEntity parent = entity.wGetParent();
		return !EntityUtils.isNull(parent) &&
				parent.wGetEntityDescriptor().getEntityFeatureDescriptor(parent.wIndexOf(entity)).isOptional();
	}

	public boolean isLossless() {
		return true;
	}
	public boolean isLossless(IEntity model) {
		return isLossless() && canApply(model);
	}
}
