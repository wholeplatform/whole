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
package org.whole.lang.iterators;

import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class CloneReplacingIterator extends AbstractSingleValuedRunnableIterator<IEntity> {
		private final Set<String> shallowUriSet;

		CloneReplacingIterator(Set<String> shallowUriSet, IEntityIterator<?>... argsIterators) {
			super(argsIterators);
			this.shallowUriSet = shallowUriSet;
		}

		protected void run(IEntity selfEntity, IBindingManager bm) {
			IEntity oldSelfEntity = bm.wGet(IBindingManager.SELF);
			bm.setResult(deepClone(selfEntity, bm));
			if (bm.wGet(IBindingManager.SELF) != oldSelfEntity)
				if (oldSelfEntity != null)
					bm.wDef(IBindingManager.SELF, oldSelfEntity);
//				else
//					bm.wUnset(IBindingManager.SELF);
		}

		protected IEntity deepClone(IEntity selfEntity, IBindingManager bm) {
			//TODO add scope with entityCloneMap

			EntityDescriptor<?> ed = selfEntity.wGetEntityDescriptor();
			boolean isComposite = ed.getEntityKind().isComposite();

			IEntity entityClone = ((InternalIEntity) selfEntity).wShallowClone();
			((InternalIEntity) entityClone).wShallowClean();

			for (int index=0, size=selfEntity.wSize(); index<size; index++) {
				IEntity childPrototype = selfEntity.wGet(index);

				if (keepCloning(childPrototype)) {
					IEntity childClone = deepClone(childPrototype, bm);
					if (isComposite)
						entityClone.wAdd(childClone);
					else
						entityClone.wSet(index, childClone);							
				} else {
					FeatureDescriptor childFeatureDescriptor = entityClone.wGetFeatureDescriptor(index);
					bm.wDef(IBindingManager.SELF, childPrototype);
					argsIterators[0].reset(childPrototype);

					if (isComposite) {
						for (IEntity childClone : argsIterators[0])
							if (!BindingManagerFactory.instance.isVoid(childClone))
								entityClone.wAdd(EntityUtils.convertCloneIfReparenting(childClone, childFeatureDescriptor));
					} else {
						IEntity lastChildClone = null;
						for (IEntity childClone : argsIterators[0])
							if (!BindingManagerFactory.instance.isVoid(childClone))
								lastChildClone = childClone;
						entityClone.wSet(index, lastChildClone != null ?
								EntityUtils.convertCloneIfReparenting(lastChildClone, childFeatureDescriptor) :
								CommonsEntityFactory.instance.createResolver());
					}							
				}
			}
			//TODO clone references
			//TODO clone aspects

			return entityClone;
		}

		protected boolean keepCloning(IEntity childPrototype) {
			if (shallowUriSet == null)
				return false;
			else {
				String childUri = childPrototype.wGetEntityDescriptor().getURI();
				return !shallowUriSet.contains(childUri);
			}
		}

		public void toString(StringBuilder sb) {
			sb.append("clone");
			super.toString(sb);
		}
	}
