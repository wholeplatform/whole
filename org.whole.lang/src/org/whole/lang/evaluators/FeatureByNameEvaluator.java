/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.evaluators;

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class FeatureByNameEvaluator extends AbstractPureConditionalSupplierEvaluator {
	protected String featureName;
	protected FeatureDescriptor featureDescriptor;

	public FeatureByNameEvaluator(String fdUri) {
		this.featureName = fdUri;
	}
	public FeatureByNameEvaluator(FeatureDescriptor featureDescriptor) {
		this.featureDescriptor = featureDescriptor;
	}

	protected FeatureDescriptor getFeatureDescriptor() {
		if (featureDescriptor == null) {
			if (!ResourceUtils.hasFragmentPart(featureName))
				return selfEntity.wGetLanguageKit().getFeatureDescriptorEnum().valueOf(featureName);
			
	    	featureDescriptor = CommonsDataTypePersistenceParser.getFeatureDescriptor(featureName, true, getBindings());
		}
		return featureDescriptor;
	}

	public boolean hasNext() {
		if (!super.hasNext())
			return false;
        FeatureDescriptor fd = getFeatureDescriptor();
		return fd != null && selfEntity.wContains(fd);
    }

    public IEntity get() {
    	return selfEntity.wGet(getFeatureDescriptor());
    }

    @Override
    public void set(IEntity value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	selfEntity.wSet(getFeatureDescriptor(), value);
    }
    @Override
    public void add(IEntity value) {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	selfEntity.wSet(getFeatureDescriptor(), value);
    }
    @Override
    public void remove() {
    	if (lastEntity == null)
    		throw new IllegalStateException();
    	
    	selfEntity.wRemove(getFeatureDescriptor());
    	lastEntity = null;
    }

    @Override
	public void toString(StringBuilder sb) {
		sb.append(featureDescriptor != null ? featureDescriptor.toString() : featureName);
    }
}
