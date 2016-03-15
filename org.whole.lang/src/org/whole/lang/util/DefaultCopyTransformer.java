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
package org.whole.lang.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;


/**
 * @author Riccardo Solmi
 */
public class DefaultCopyTransformer implements IEntityTransformer {
	public static final DefaultCopyTransformer instance = new DefaultCopyTransformer();

	public void transform(IEntity oldEntity, IEntity newEntity) {
//        if (newEntity.wGetEntityDescriptor().equals(oldEntity.wGetEntityDescriptor()))
//        	return;

		EntityKinds oldKind = oldEntity.wGetEntityKind();
		EntityKinds newKind = newEntity.wGetEntityKind();

        if ((oldKind.isSimple() && newKind.isSimple()) ||
        		(EntityUtils.isVariable(oldEntity) && EntityUtils.isVariable(newEntity))) { //TODO workaround

        	List<FeatureDescriptor> oldFeatures = oldEntity.wGetEntityDescriptor().getEntityFeatureDescriptors();
        	Set<FeatureDescriptor> commonFeatures = new HashSet<FeatureDescriptor>();
        	for (FeatureDescriptor fd : newEntity.wGetEntityDescriptor().getEntityFeatureDescriptors())
        		if (oldFeatures.contains(fd.getFeatureDescriptor()))
        			commonFeatures.add(fd);

            for (FeatureDescriptor fd : commonFeatures) {
            	IEntity oldChild = oldEntity.wGet(fd.getFeatureDescriptor());
            	if (fd.getEntityDescriptor().isPlatformSupertypeOf(oldChild.wGetEntityDescriptor()))
                    newEntity.wSet(fd, EntityUtils.clone(oldChild));
            }
		} else if (oldKind.isComposite() && newKind.isComposite()) {
			EntityDescriptor<?> newComponentDescriptor = newEntity.wGetEntityDescriptor(0);
			for (int i=0, size=oldEntity.wSize(); i<size; i++) {
				IEntity oldChild = oldEntity.wGet(i);
                if (newComponentDescriptor.isPlatformSupertypeOf(oldChild.wGetEntityDescriptor()))
                    newEntity.wSet(i, EntityUtils.clone(oldChild));
			}
		} else if (EntityUtils.isFragment(oldEntity) && EntityUtils.isFragment(newEntity)) { //TODO workaround
			newEntity.wSet(0, EntityUtils.clone(oldEntity.wGet(0)));
		}
	}
}
