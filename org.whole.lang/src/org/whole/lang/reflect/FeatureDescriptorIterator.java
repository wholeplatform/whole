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

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class FeatureDescriptorIterator implements ListIterator<IEntity> {
    protected IEntity entity;
    private List<FeatureDescriptor> features;
    private int index;
    
    public FeatureDescriptorIterator(IEntity entity, List<FeatureDescriptor> features) {
        this.entity = entity;
        this.features = features;
        index = 0;
    }
    
    protected boolean skip(FeatureDescriptor fd) {
        return false;
    }

    public boolean hasNext() {
        return index < features.size();
    }
    public IEntity next() {
        try {
            return entity.wGet(features.get(index)); // was AsObject       
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        } finally {
            index = nextIndex();
        }      
    }
    public int nextIndex() {
        int nextIndex = index;
        do {
            nextIndex++;
        } while (nextIndex < features.size() && skip(features.get(nextIndex)));
        return nextIndex;
    }

    public boolean hasPrevious() {
        return previousIndex() > 0;
    }
    public IEntity previous() {
//        try {
//            return entity.getFeatureAsObject((FeatureDescriptor) features.get(index = previousIndex()));            
//        } catch (IndexOutOfBoundsException e) {
//            throw new NoSuchElementException();
//        }      
        if (index == 0)
            throw new NoSuchElementException();
        return entity.wGet(features.get(index = previousIndex())); // was AsObject
    }
    public int previousIndex() {
        int prevIndex = index;
        do {
            prevIndex--;
        } while (prevIndex > 0 && skip(features.get(prevIndex)));
        return prevIndex;
    }

    public void set(IEntity value) {
        entity.wSet(features.get(index), value); //was no (IEntity)     
    }
    public void add(IEntity value) {
//        entity.wAdd((FeatureDescriptor) features.get(index), value);        
    }
    public void remove() {
        //if (entity.isComposite())
        // removeChild?
        entity.wRemove(features.get(index));
    }
}
