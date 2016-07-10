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
package org.whole.lang.reflect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Set;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class SimpleEntityDescriptor<E extends IEntity> extends AbstractEntityDescriptor<E> {
	private static final long serialVersionUID = 1L;

	private List<FeatureDescriptor> entityFeatureDescriptors;
	private int adjacentFeatureSize;
    private int[] featuresIndexes; // derived (feature ordinal -> index)

    protected SimpleEntityDescriptor() {} //Reserved to standard serialization
	protected SimpleEntityDescriptor(int ordinal, String name, String implName, Class<E> type, boolean isAbstract) {
    	super(ordinal, name, implName, type, isAbstract, false);
    	
    	entityFeatureDescriptors = new ArrayList<FeatureDescriptor>(5);
	}

    public final EntityKinds getEntityKind() {
    	return EntityKinds.SIMPLE;
    }

	public int featureSize() {
		return getEntityFeatureDescriptors().size();
	}
	public int childFeatureSize() {
		return featureSize()-adjacentFeatureSize();
	}
	public int adjacentFeatureSize() {
		return adjacentFeatureSize;
	}

    public List<FeatureDescriptor> getEntityFeatureDescriptors() {
    	return entityFeatureDescriptors;
    }

    public FeatureDescriptor getEntityFeatureDescriptor(int index) {
		try {
			return entityFeatureDescriptors.get(index);
		} catch (IndexOutOfBoundsException e) {
    		throw new IllegalArgumentException("No such feature");
		}
    }

    private int[] featuresIndexes() {
    	if (featuresIndexes == null) {
            int maxOrdinal = 0;
            int size=featureSize();
            for (int i=0; i<size; i++)
            	maxOrdinal = Math.max(maxOrdinal, getEntityFeatureDescriptor(i).getOrdinal());
            this.featuresIndexes = new int[maxOrdinal+1];
            Arrays.fill(featuresIndexes, -1);
            for (int i=0; i<size; i++)
            	featuresIndexes[getEntityFeatureDescriptor(i).getOrdinal()] = i;
    	}
    	return featuresIndexes;
    }

    public int indexOf(FeatureDescriptor fd) {
    	if (fd.getLanguageKit().equals(getLanguageKit()) && fd.getOrdinal() >= 0 && fd.getOrdinal() < featuresIndexes().length)
    		return featuresIndexes()[fd.getOrdinal()];
    	else
    		return -1;
    }

    public EntityDescriptor<?> getEntityDescriptor(int index) {
    	return getEntityFeatureDescriptor(index).getEntityDescriptor();
    }

    public EntityDescriptor<E> withFeature(FeatureDescriptor fd,
    		int edOrdinal, FeatureDescriptor oppositeFd,
    		boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared) {

    	entityFeatureDescriptors.add(new EntityFeatureDescriptorImpl(
				this, fd, oppositeFd, edOrdinal,
				isOptional, isId, isReference, isDerived, isShared));
    	
    	if (isReference)
    		adjacentFeatureSize++;

		//reset derived fields
		featuresIndexes = null;
		
		return this;
    }

    public boolean isLanguageSupertypeOf(EntityDescriptor<?> ed) {
    	return getLanguageKit().equals(ed.getLanguageKit()) ?
            languageSubtypes().get(ed.getOrdinal()) : false;
    }

	public void setLanguageSubtypes(boolean enable, int... edOrdinals) {
    	BitSet languageSubtypes = languageSubtypes();
        for (int i=0; i<edOrdinals.length; i++)
            languageSubtypes.set(edOrdinals[i], enable);
	}

    public Set<EntityDescriptor<?>> getLanguageConcreteSubtypes(Set<EntityDescriptor<?>> set) {
    	for (int i=languageSubtypes().nextSetBit(0); i>=0; i=languageSubtypes().nextSetBit(i+1)) {
			EntityDescriptor<?> ed = getEntityDescriptorEnum().valueOf(i);
			if (!ed.isAbstract())
				set.add(ed);
		}
        return set;
    }

	public boolean declaredSubtypesUpto(EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> subtypes) {
		if (optTargetEd != null && isLanguageSupertypeOf(optTargetEd))
			return true;

		EntityDescriptorEnum edEnum = getEntityDescriptorEnum();
    	for (int i=languageSubtypes().nextSetBit(0); i>=0; i=languageSubtypes().nextSetBit(i+1))
			if (edEnum.declaredForeignSubtypesUpto(edEnum.valueOf(i), optTargetEd, subtypes))
				return true;

    	return false;
	}

    public boolean isPolymorphic() {
    	return languageSubtypes().nextSetBit(languageSubtypes().nextSetBit(0)+1) != -1;
    }

}
