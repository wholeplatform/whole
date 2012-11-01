/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.search;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class WholeResourceMatcher extends AbstractWholeResourceVisitor {
	private IEntity pattern;
	private WholeSearchResult result;
	private IProgressMonitor monitor;

	public WholeResourceMatcher(IEntity pattern, IWholeSearchScope scope,
			WholeSearchResult result, IProgressMonitor monitor) {
		super(scope);
		this.pattern = pattern;
		this.result = result;
		this.monitor = monitor;
	}

	public boolean visit(IFile file, IPersistenceKit persistenceKit) {
		try {
			// TODO add work percentage support
			IEntity model = persistenceKit.readModel(new IFilePersistenceProvider(file));
			Collection<IEntity> matches = Matcher.findAll(pattern, model, false);
			if(!matches.isEmpty()) {
				result.addMatches(file, persistenceKit, matches);
			}
		} catch (Exception e) {
			// safely ignore a wrong persistenceKit
		}
		return !monitor.isCanceled();
	}
}
