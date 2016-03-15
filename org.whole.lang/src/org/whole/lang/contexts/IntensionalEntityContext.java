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
package org.whole.lang.contexts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.whole.lang.commands.BooleanChangeCommand;
import org.whole.lang.commands.ByteChangeCommand;
import org.whole.lang.commands.CharChangeCommand;
import org.whole.lang.commands.DoubleChangeCommand;
import org.whole.lang.commands.FloatChangeCommand;
import org.whole.lang.commands.ICommand;
import org.whole.lang.commands.IntChangeCommand;
import org.whole.lang.commands.LongChangeCommand;
import org.whole.lang.commands.ShortChangeCommand;
import org.whole.lang.commands.StringChangeCommand;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class IntensionalEntityContext extends AbstractEntityContext {
    public IntensionalEntityContext(IEntity root) {
        super(root);
    }

    protected IEntity entityContext(IEntity root) {
        return new IntensionalEntityContext(root);
    }

    public boolean wIsEmpty() {
    	int size = wSize();
        return size == 0 || (size == 1 && EntityUtils.isResolver(wGet(0)));
    }
	public int wSize() {
		int size = entity.wSize();
		ICommand cmd = wGetLastCommand();
		while (contextTime < cmd.getExecutionTime()) {
	    	switch (cmd.getKind()) {
	    	case ADD:
	    		size--;
	    		break;
    		case REMOVE:
    			size++;
    			break;
	    	}
	    	cmd = cmd.getPrevCommand();
		}
	    return size;
	}
	public int wIndexOf(IEntity value) {
		ICommand cmd = ((InternalIEntity) value).wGetBindingCommand();
		if (contextTime < cmd.getExecutionTime())
			return -1;
		return cmd.getSourceIndex();
	}
	protected IEntity wGetIEntity(int index) {
		if (contextTime >= wGetLastCommand().getExecutionTime())
			return entity.wGet(index);
		else {
			List<IEntity> children = wIndexedFeatures(entity, contextTime);
			return children.get(index);
		}
	}
	


	public boolean wContains(FeatureDescriptor feature) {
		return entity.wContains(feature);
	}
	public boolean wRemove(FeatureDescriptor feature) {
		return entity.wRemove(feature);
	}
	public IEntity wGet(FeatureDescriptor feature) {
	    return entityContext(wGetVersion(getEntityInScope(feature).wGet(feature), contextTime));
	}
	public void wSet(FeatureDescriptor feature, IEntityContext value) {
	    getEntityInScope(feature).wSet(feature, (IEntity) ((IntensionalEntityContext) value).entity);
	}

	protected IEntity getEntityInScope(FeatureDescriptor feature) {
	    IEntity e = entity;
	    do {
	        if (e.wContains(feature))
	            return e;
	        e = e.wGetParent();
	    } while (!EntityUtils.isNull(e));
	    throw new IllegalArgumentException("Feature is not in scope");
	}

	protected final ICommand wGetValueVersion(int contextTime) {
		return wGetLastCommand().getCommand(contextTime);
	}
	public boolean wBooleanValue() {
		return ((BooleanChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public byte wByteValue() {
		return ((ByteChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public char wCharValue() {
		return ((CharChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public double wDoubleValue() {
		return ((DoubleChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public float wFloatValue() {
		return ((FloatChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public int wIntValue() {
		return ((IntChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public long wLongValue() {
		return ((LongChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public short wShortValue() {
		return ((ShortChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public String wStringValue() {
		return ((StringChangeCommand) wGetValueVersion(contextTime)).newValue;
	}
	public Object wGetValue() {
		return wGetValueVersion(contextTime).getNewObject();
	}
	public void wSetValue(boolean value) {
		entity.wSetValue(value);
	}
	public void wSetValue(byte value) {
		entity.wSetValue(value);
	}
	public void wSetValue(char value) {
		entity.wSetValue(value);
	}
	public void wSetValue(double value) {
		entity.wSetValue(value);
	}
	public void wSetValue(float value) {
		entity.wSetValue(value);
	}
	public void wSetValue(int value) {
		entity.wSetValue(value);
	}
	public void wSetValue(long value) {
		entity.wSetValue(value);
	}
	public void wSetValue(short value) {
		entity.wSetValue(value);
	}
	public void wSetValue(String value) {
		entity.wSetValue(value);
	}
	public void wSetValue(Object value) {
		entity.wSetValue(value);
	}

	private Map<IEntity, List<IEntity>> childrenCache = new WeakHashMap<IEntity, List<IEntity>>();
	
	protected final IEntity wGetVersion(IEntity e, int contextTime) {
		ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
		if (cmd.getKind().isComposite()) {
			List<IEntity> children = wIndexedFeatures(cmd.getSource(), contextTime);
			return children.get(cmd.getSourceIndex());
		} else
			return cmd.getCommand(contextTime).getNewEntity();
	}
	protected final IEntity wGetPrevVersion(IEntity e) {
		ICommand cmd = ((InternalIEntity) e).wGetBindingCommand();
		if (cmd.getKind().isComposite()) {
			IEntity source = cmd.getSource();
			List<IEntity> children = wIndexedFeatures(source, ((InternalIEntity) source).wGetLastCommand().getPrevCommand().getExecutionTime());
			return children.get(cmd.getSourceIndex());
		} else
			return cmd.getPrevCommand().getNewEntity();
	}
	@Deprecated
	public final List<IEntity> wIndexedFeatures(IEntity e, int contextTime) {
		List<IEntity> result = childrenCache.get(e);
		if (result != null && this.contextTime == contextTime)
			return result;
		result = new ArrayList<IEntity>(e.wFeatures());
		ICommand cmd = ((InternalIEntity) e).wGetLastCommand();
		while (contextTime < cmd.getExecutionTime()) {
	    	switch (cmd.getKind()) {
	    	case ADD:
    			result.remove(cmd.getSourceIndex());
	    		break;
    		case REMOVE:
	    		result.add(cmd.getSourceIndex(), cmd.getOldEntity());
    			break;
    		case CHANGE:
    			result.set(cmd.getSourceIndex(), cmd.getOldEntity());
    			break;
	    	}
	    	cmd = cmd.getPrevCommand();			
		}
		if (this.contextTime == contextTime)
			childrenCache.put(e, result);
		return result;
	}
}
