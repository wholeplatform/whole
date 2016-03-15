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
package org.whole.lang.operations;

import java.util.Map;
import java.util.TreeMap;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractByLanguageOperation extends AbstractOperation {
    private Map<String, IVisitorFactory> visitorMap = new TreeMap<String, IVisitorFactory>();

    protected AbstractByLanguageOperation(String name, IBindingManager args, boolean resultsInArgs) {
		super(name, args, resultsInArgs);
	}

    public void addVisitorFactory(String languageUri, IVisitorFactory visitorFactory) {
    	visitorMap.put(languageUri, visitorFactory);
    }
	public boolean hasVisitor(String languageUri) {
		return visitorMap.containsKey(languageUri);
	}
	public IVisitor getVisitor(String languageUri, int stage) {
		IVisitorFactory visitorFactory = visitorMap.get(languageUri);
		if (visitorFactory == null)
			throw new IllegalArgumentException("The language "+languageUri+" does not support the operation "+getOperationId()+".");

		return visitorFactory.create(this, stage);
	}

	@Override
	public IVisitor setVisitor(IEntity entity, int absoluteStage, IVisitor visitor) {
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(entity);
		String languageUri = languageKit.getURI();
		IVisitor oldVisitor = hasVisitor(languageUri) ? getVisitor(entity, absoluteStage) : null;

		int normalizedStage = absoluteStage <= 0 ? 0 : 1;

		String uri = ReflectionFactory.getLanguageKit(entity).getURI();
		IVisitor[] stagedVisitors = stagedVisitorsMap.get(uri);
		if (stagedVisitors == null)
			stagedVisitorsMap.put(uri, stagedVisitors = new IVisitor[2]);
		stagedVisitors[normalizedStage] = visitor;

		return oldVisitor;
	}

	@Override
	protected IVisitor initVisitor(IEntity entity, int normalizedStage) {
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(entity);
		String languageUri = languageKit.getURI();
		IVisitor visitor = null;

		if (hasVisitor(languageUri))
			visitor = getVisitor(languageUri, normalizedStage);

		if (visitor == null)
			visitor = getDefaultVisitor(entity, normalizedStage);

		return visitor;
	}

}
