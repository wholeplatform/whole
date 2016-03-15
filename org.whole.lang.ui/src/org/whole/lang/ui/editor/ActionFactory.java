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
package org.whole.lang.ui.editor;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.DefaultCopyTransformer;
import org.whole.lang.util.DefaultWrapInTransformer;
import org.whole.lang.util.DefaultWrapWithinTransformer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ActionFactory implements IActionFactory {
	private static class SingletonHolder {
		private static final IActionFactory instance = new ActionFactory();
	}
	public static IActionFactory instance() {
		return SingletonHolder.instance;
	}

	protected final IEntityTransformer fresh = new IEntityTransformer() {
		public void transform(IEntity oldEntity, IEntity newEntity) {
		}
	};
	protected final IEntityTransformer fragment = new IEntityTransformer() {
		public void transform(IEntity oldEntity, IEntity newEntity) {
			if (EntityUtils.isFragment(oldEntity))
				oldEntity = oldEntity.wGetRoot();
			newEntity.wSet(newEntity.wGetRoot(), EntityUtils.clone(oldEntity));
		}
	};
	protected final IEntityTransformer copy = DefaultCopyTransformer.instance;
	protected final IEntityTransformer wrapIn0 = DefaultWrapInTransformer.instance;
	protected final IEntityTransformer wrapIn(FeatureDescriptor featureDescriptor) {
		return new DefaultWrapInTransformer(featureDescriptor);
	}
	protected final IEntityTransformer wrapIn(int index) {
		return new DefaultWrapInTransformer(index);
	}
	protected final IEntityTransformer wrapWithin(FeatureDescriptor featureDescriptor) {
		return new DefaultWrapWithinTransformer(featureDescriptor);
	}

	public Object[][] wrapActions() { return new Object[0][0]; }
	public Object[][] textActions() { return new Object[0][0]; }
}
