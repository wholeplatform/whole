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
package org.whole.lang.events;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;

/**
 * @author Riccardo Solmi
 */
public class DefaultValueFactory {
	public static void bindResolverValueLazy(IEntity entity, final FeatureDescriptor fd, final IEntity defaultValue) {
		entity.wAddRequestEventHandler(new IdentityRequestEventHandler() {
			@Override
			@SuppressWarnings("unchecked")
			public <V extends IEntity> V notifyRequested(IEntity source, FeatureDescriptor feature, V value) {
				if (fd.equals(feature) && EntityUtils.isResolver(value))
					source.wSet(fd, value = EntityUtils.clone((V) defaultValue));
				return value;
			}
		});
	}
	public static void bindDefaultValueLazy(IEntity entity, final FeatureDescriptor fd, final IEntity defaultValue) {
		entity.wAddRequestEventHandler(new AbstractDerivationRule<IEntity>(fd) {
			protected IEntity deriveRequested(IEntity source, IEntity value) {
				return EntityUtils.clone(defaultValue);
			}
		});
	}

	public static void setCounterDefault(IEntity entity) {
		final String defaultPrefix = entity.wStringValue();

		entity.wAddRequestEventHandler(new IdentityRequestEventHandler() {
			int counter = 0;
			public String notifyRequested(IEntity source, FeatureDescriptor feature, String value) {
				if (value.equals(defaultPrefix))
					source.wSetValue(value = defaultPrefix + counter++);
				
				source.wRemoveRequestEventHandler(this);
				return value;
			}
		});
	}

	public static void setUniqueDefault(IEntity entity) {
		final String defaultPrefix = entity.wStringValue();

		entity.wAddRequestEventHandler(new IdentityRequestEventHandler() {
			int max = 0;
			void updateMax(int value) {
				if (value > max)
					max = value;
			}
			public String notifyRequested(final IEntity source, FeatureDescriptor feature, String value) {
				if (value.equals(defaultPrefix)) {
					final EntityDescriptor<?> sourceDescriptor = source.wGetEntityDescriptor();
					final EntityDescriptor<?> parentDescriptor = source.wGetParent().wGetEntityDescriptor();

					GenericTraversalFactory.instance.topDown(new AbstractVisitor() {
						public void visit(IEntity entity) {
							if (entity == source)
								return;
							
							if (sourceDescriptor.equals(entity.wGetEntityDescriptor())
								&& parentDescriptor.equals(entity.wGetParent().wGetEntityDescriptor())) {
								
								String strValue = entity.wStringValue();
								if (strValue.startsWith(defaultPrefix)) {
									try {
										int value = Integer.parseInt(strValue.substring(defaultPrefix.length()));
										updateMax(value);
									} catch (NumberFormatException e) {
									} catch (IndexOutOfBoundsException e) {
									}
								}
							}
						}
					}, false).visit(EntityUtils.getCompoundRoot(source));

					source.wSetValue(value = defaultPrefix + ++max);
					source.wRemoveRequestEventHandler(this);
				}
				return value;
			}
		});
	}
}
