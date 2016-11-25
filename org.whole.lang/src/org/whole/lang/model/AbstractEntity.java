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
package org.whole.lang.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.whole.lang.builders.FeaturesList;
import org.whole.lang.commands.ICommand;
import org.whole.lang.commands.NullCommand;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.model.Fragment;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IRequestEventHandler;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractEntity implements InternalIEntity, Serializable, Cloneable {
	transient protected boolean requestNotificationDisabled = false;
    transient private IRequestEventHandler requestEventHandler = IdentityRequestEventHandler.instance;
    transient private IChangeEventHandler changeEventHandler = IdentityChangeEventHandler.instance;
    transient private ICommand bindingCommand = NullCommand.instance; 

	private IFragmentModel model = NullFragmentModel.instance;
	private IEntity parent = NullEntity.instance;
    private Map<IEntity, Integer> inverseAdjacents = null;
    private Map<FeatureDescriptor, IEntity> aspectualFeatures = Collections.emptyMap();

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    	in.defaultReadObject();
    	requestEventHandler = IdentityRequestEventHandler.instance;
    	changeEventHandler = IdentityChangeEventHandler.instance;
    	bindingCommand = NullCommand.instance;
    }

    private Serializable pid;
    public Serializable wGetPid() {
    	return pid;
    }
    public void wSetPid(Serializable pid) {
    	this.pid = pid;
    }

    public boolean wIsAdapter() {
    	return false;
    }
    @SuppressWarnings("unchecked")
	public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed) {
    	final EntityDescriptor<?> thisEd = wGetEntityDescriptor();
    	if (ed.isLanguageSupertypeOf(thisEd))
    		return (E) this;
    	else if (ed.isPlatformSupertypeOf(thisEd))
    		return CommonsEntityAdapterFactory.create(ed, this);
    	else
    		throw new IllegalArgumentException(wGetEntityDescriptor().getName()+" is not adaptable to: "+ed.getName());
    }
    public IEntity wGetAdaptee(boolean force) {
    	return this;
    }

    @SuppressWarnings("unchecked")
    public <E extends IEntity> E wResolveWith(EntityDescriptor<E> ed) {
    	if (ed.equals(wGetEntityDescriptor()))
    		return (E) this;
    	throw new IllegalArgumentException("The entity is not a resolver");
    }

    public /*final*/ ICommand wGetBindingCommand() {
    	return bindingCommand;
    }
    public /*final*/ void wSetBindingCommand(ICommand command) {
    	bindingCommand = command;
    }
	public ICommand wGetLastCommand() {
	    ICommand cmd = NullCommand.instance;
	    int maxTime = Integer.MIN_VALUE;
	    for (int i=0, size=wSize(); i<size; i++) {
	        ICommand featureCmd = ((InternalIEntity) wGet(i)).wGetBindingCommand();
	        if (maxTime < featureCmd.getExecutionTime()) {
	            cmd = featureCmd;
	            maxTime = featureCmd.getExecutionTime();
	        }
	    }
	    return cmd;
	}
	public ICommand wSetLastCommand(ICommand command) {
		return null;//for back compatibility wGetLastCommand();
	}

    public IFragmentModel wGetModel() {
    	if (model == NullFragmentModel.instance)
    		wSetModel(wGetEntityDescriptor().getLanguageKit().createFragmentModel());
    	return model;
    }
    protected final IFragmentModel wGetActualModel() {
    	return model;
    }    

    /*
     * Invariants:
     * - The same CompoundModel for all the containment tree
     * - Same FragmentModel implies same language over the connection path of entities
     * - An entity is the root of a FragmentModel iff is a fragment entity or the child of a fragment entity
     * 
     * @see org.whole.lang.model.InternalIEntity#wSetModel(org.whole.lang.model.IFragmentModel)
     */
    public final void wSetModel(IFragmentModel fragmentModel) {
        if (this.model == PrototypeFragmentModel.instance || fragmentModel == NullFragmentModel.instance)
            return;

        boolean isFragment = this instanceof Fragment;
        if (fragmentModel == PrototypeFragmentModel.instance)
        	this.model = fragmentModel;
    	else if (wGetLanguageKit().equals(fragmentModel.getLanguageKit()) && !isFragment) {
        	if (this.model != NullFragmentModel.instance) {
        		IHistoryManager hm = this.model.getCompoundModel().getHistoryManager();
        		if (!hm.equals(fragmentModel.getCompoundModel().getHistoryManager()))
        			hm.clearHistory();
        	}
        	this.model = fragmentModel;
        } else {
        	if (this.model == NullFragmentModel.instance || this.model == fragmentModel)
        		this.model = wGetEntityDescriptor().getLanguageKit().createFragmentModel();//TODO copy history

        	this.model.setCompoundModel(fragmentModel.getCompoundModel());
        	this.model.setFragment(isFragment ? (Fragment) this : fragmentModel.getFragment());
        }

		wSetChildrenModel(this.model);
    }

    protected void wSetChildrenModel(IFragmentModel model) {
    	EntityDescriptor<?> ed = wGetEntityDescriptor();
    	for (int i=0, size=wSize(); i<size; i++) {
    		InternalIEntity child = (InternalIEntity) wGet(i);
			if (ed.getEntityFeatureDescriptor(i).isReference()) {
		    	if (!EntityUtils.hasParent(child))
		    		child.wSetModel(wGetActualModel());
			} else
				child.wSetModel(model);
    	}
    }

    public ILanguageKit wGetLanguageKit() {
		return wGetEntityDescriptor().getLanguageKit();
    }
    public IEditorKit wGetEditorKit() {
    	ILanguageKit languageKit = wGetEntityDescriptor().getLanguageKit();

    	IFragmentModel model = wGetActualModel();
    	if (model != NullFragmentModel.instance) {
    		IEditorKit editorKit = model.getEditorKit();
    		if (editorKit.canApply(languageKit))
    			return editorKit;
    	}
		return languageKit.getDefaultEditorKit(); 
    	
//		return model != NullFragmentModel.instance ? model.getEditorKit() : languageKit.getDefaultEditorKit(); 
    }
    public int wGetEntityOrd() {
    	return wGetEntityDescriptor().getOrdinal();
    }
    public EntityKinds wGetEntityKind() {
    	return EntityKinds.SIMPLE;
    }

    public abstract EntityDescriptor<?> wGetEntityDescriptor();

	public IEntity wGetRoot() {
		IEntity fragment = wGetModel().getFragment();
		return fragment != null ? fragment.wGetRoot() : NullEntity.instance;
	}

	public IEntity wGetParent() {
		return parent;
	}
	public void wSetParent(IEntity parent) {
		if (this.parent == parent)
			return;

		if (!EntityUtils.isNull(this.parent))
			throw new IllegalArgumentException("The entity is already parented: "+this);

		this.parent = parent;
	}
	public void wRemoveParent(IEntity parent) {
		if (this.parent == parent)
			this.parent = NullEntity.instance;
	}

	public void wAddInverseAdjacent(IEntity inverseAdjacent) {
		if (inverseAdjacents == null)
			inverseAdjacents = new HashMap<IEntity, Integer>();
		Integer counter = inverseAdjacents.get(inverseAdjacent);
		if (counter == null)
			inverseAdjacents.put(inverseAdjacent, new Integer(1));
		else
			inverseAdjacents.put(inverseAdjacent, new Integer(counter.intValue() + 1));
	}
	public void wRemoveInverseAdjacent(IEntity inverseAdjacent) {
		if (inverseAdjacents == null)
			return; //FIXME workaround for prototype initialization (composite of references)
		Integer counter = inverseAdjacents.get(inverseAdjacent);
		if (counter == null)
			return;
		int count = counter.intValue();
		if (count == 1)
			inverseAdjacents.remove(inverseAdjacent);
		else
			inverseAdjacents.put(inverseAdjacent, new Integer(count - 1));
	}


    public int wAdjacentSize() {
    	return 0;
    }
    public int wInverseAdjacentSize() {
    	return inverseAdjacents != null ? inverseAdjacents.size() : 0;
    }
    public Iterable<IEntity> wInverseAdjacents() {
    	return inverseAdjacents != null ? inverseAdjacents.keySet() : Collections.<IEntity>emptyList();
    }

//    public List<FeatureDescriptor> wGetAdjacentFeatureDescriptors() {
//    	List<FeatureDescriptor> fd = wGetEntityDescriptor().getEntityFeatureDescriptors();
//    	return fd.subList(fd.size()-wAdjacentSize(), fd.size());
//    }
    public Set<FeatureDescriptor> wGetAspectualFeatureDescriptors() {
    	return aspectualFeatures.keySet();
    }

	public void wAddRequestEventHandler(IRequestEventHandler eventHandler) {
    	this.requestEventHandler = this.requestEventHandler.addRequestEventHandler(eventHandler);
    }
	public void wRemoveRequestEventHandler(IRequestEventHandler eventHandler) {
    	this.requestEventHandler = this.requestEventHandler.removeRequestEventHandler(eventHandler);
    }
	protected final IRequestEventHandler wGetEntityRequestEventHandler() {
	    return requestEventHandler;
	}
	protected final IRequestEventHandler wGetCompoundRequestEventHandler() {
		return wGetActualModel().getCompoundModel().getRequestEventHandler();
	}

	public void wAddChangeEventHandler(IChangeEventHandler eventHandler) {
    	this.changeEventHandler = this.changeEventHandler.addChangeEventHandler(eventHandler);
    }
	public void wRemoveChangeEventHandler(IChangeEventHandler eventHandler) {
    	this.changeEventHandler = this.changeEventHandler.removeChangeEventHandler(eventHandler);
    }
	protected final IChangeEventHandler wGetEntityChangeEventHandler() {
	    return changeEventHandler;
	}
	protected final IChangeEventHandler wGetCompoundChangeEventHandler() {
	    return wGetActualModel().getCompoundModel().getChangeEventHandler();
	}

    @SuppressWarnings("unchecked")
	public IEntity wShallowClone() {
		try {
			AbstractEntity entity = (AbstractEntity) super.clone();
			entity.pid = null;
			entity.model = NullFragmentModel.instance;
			entity.parent = NullEntity.instance;
			entity.inverseAdjacents = null;
			if (!entity.aspectualFeatures.equals(Collections.EMPTY_MAP))
				entity.aspectualFeatures = (Map<FeatureDescriptor, IEntity>) ((HashMap<FeatureDescriptor, IEntity>) entity.aspectualFeatures).clone();
			entity.bindingCommand = NullCommand.instance;
			entity.requestEventHandler = entity.requestEventHandler.cloneRequestEventHandler(IdentityRequestEventHandler.instance);
			entity.changeEventHandler = entity.changeEventHandler.cloneChangeEventHandler(IdentityChangeEventHandler.instance);
			return entity;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}
    
    public Set<IEntity> wGetSharingSet() {
        if (wGetEntityChangeEventHandler().hasSharingEventHandler())
            return wGetEntityChangeEventHandler().getSharingEventHandler(this).sharingSet();
        return Collections.singleton((IEntity) this);
    }
    
    public int wHashCode() {
    	return hashCode();
    }
    public boolean wEquals(IEntity entity) {
    	return equals(entity.wGetAdaptee(false));
    }

	public String toString() {
		try {
			return PrettyPrinterOperation.toPrettyPrintString(this, 16384);
		} catch (RuntimeException e) {
			return toDebugString();
		}
	}
	public String toDebugString() {
		StringBuffer result = new StringBuffer();
		result.append(StringUtils.transientId(this));
		result.append('(');
		toString(result);
		result.append(')');
		return result.toString();	
	}
	protected void toString(StringBuffer buffer) {
	}

	public void wAccept(GenericMatcher matcher, IEntity other) {
    	matcher.match(this, other);
    }

    
	public FeatureDescriptor wGetFeatureDescriptor(IEntity child) {
		return wGetEntityDescriptor().getEntityFeatureDescriptor(wIndexOf(child));
	}
	public EntityDescriptor<?> wGetEntityDescriptor(IEntity child) {
		return wGetEntityDescriptor().getEntityDescriptor(wIndexOf(child));
	}

	public List<IEntity> wFeatures() {
		if (wIsEmpty())
			return Collections.<IEntity>emptyList();
		
		return new FeaturesList(this); //TODO unmodifiable?
	}


	public boolean wContains(IEntity entity) {
		for (int i=0, size=wSize(); i<size; i++)
			if (wGet(i).wEquals(entity))
				return true; // i could be different from wIndexOf(child)
		return false;
	}

	public int wIndexOf(IEntity entity) {
		boolean requestNotificationState = requestNotificationDisabled;
		requestNotificationDisabled = true;
		try {
			IEntity adaptee = entity.wGetAdaptee(false);
			int result = -1;
			for (int i=0, size=wSize()+wAdjacentSize(); i<size; i++) {
				IEntity child = wGet(i).wGetAdaptee(false);
				if (child.equals(adaptee))
					return i; // object identity
				else if (result == -1 && child.wEquals(adaptee))
					result = i; // business identity
			}
			return result;
		} finally {
			requestNotificationDisabled = requestNotificationState;
		}
	}

	public boolean wAdd(IEntity child) {
		throw new UnsupportedOperationException(WholeMessages.no_composite);
	}
	public boolean wRemove(IEntity child) {
		return wRemove(wIndexOf(child));
	}

	public IEntity wGet(IEntity child) {
		int index = wIndexOf(child);
		return index != -1 ? wGet(index) : null; //TODO NullEntity.instance ?
	}

	public boolean wSet(IEntity oldChild, IEntity newChild) {
		ICommand cmd = ((InternalIEntity) oldChild).wGetBindingCommand();
		
		while (cmd != NullCommand.instance && cmd.getSource() != this)
			cmd = cmd.getPrevCommand();

		if (cmd == NullCommand.instance) {
			int index = wIndexOf(oldChild);
			if (index >= 0) {
			    wSet(index, newChild);
			    return true;
			}
			return false;
		}
		wSet(cmd.getSourceFeatureDescriptor(), newChild);
		return true;
	}
	public boolean wIsSet(IEntity child) {
		return wIsSet(wIndexOf(child));
	}
	public void wUnset(IEntity child) {
		wUnset(wIndexOf(child));
	}
	
	
	public boolean wIsEmpty() {
	    return wSize() == 0;
	}
	public int wSize() {
		return 0;
	}

	public /*final*/ boolean wContains(int index) {
		return index >= 0 && index < wSize() + wAdjacentSize();
	}
	public /*final*/ FeatureDescriptor wGetFeatureDescriptor(int index) {
		return wGetEntityDescriptor().getEntityFeatureDescriptor(index);
	}
	public /*final*/ EntityDescriptor<?> wGetEntityDescriptor(int index) {
		return wGetEntityDescriptor().getEntityDescriptor(index);
	}
	public boolean wAdd(int index, IEntity child) {
		throw new UnsupportedOperationException();
	}
	public boolean wRemove(int index) {
		if (!wContains(index))
			return false;
		wSet(index, CommonsEntityFactory.instance.createResolver());
		return true;
	}
	public IEntity wGet(int index) {
		throw new IndexOutOfBoundsException();
	}
	public void/*boolean*/ wSet(int index, IEntity child) {
		throw new IndexOutOfBoundsException();
	}
    public boolean wIsSet(int index) {
        return wContains(index) && !EntityUtils.isDefault(this, index, wGet(index));
    }
    public void wUnset(int index) {
    	if (wContains(index))
    		EntityUtils.setDefault(this, index);
    }

    public /*final*/ boolean wContains(FeatureDescriptor fd) {
    	//TODO add support for aspectual features
        return wGetEntityDescriptor().has(fd);
    }
	public /*final*/ EntityDescriptor<?> wGetEntityDescriptor(FeatureDescriptor fd) {
		return wGetEntityDescriptor().getEntityDescriptor(fd);
	}
	public /*final*/ int wIndexOf(FeatureDescriptor fd) {
		return wGetEntityDescriptor().indexOf(fd);
	}
	public boolean wRemove(FeatureDescriptor fd) {
		return wRemove(wIndexOf(fd));
	}
    public /*final*/ IEntity wGet(FeatureDescriptor fd) {
    	int index = wIndexOf(fd);
    	if (index >= 0)
    		return wGet(index);
    	else {
        	IEntity adjacent = aspectualFeatures.get(fd);
        	if (adjacent != null)
        		return notifyRequested(fd, adjacent);
        	else
        		throw new IllegalArgumentException();
    	}
    }
    public /*final*/ void wSet(FeatureDescriptor fd, IEntity value) {
    	int index = wIndexOf(fd);
    	if (index >= 0)
    		wSet(index, value);
    	else {
    		if (aspectualFeatures.equals(Collections.EMPTY_MAP))
    			aspectualFeatures = new HashMap<FeatureDescriptor, IEntity>();

    		//TODO ? put efd if monomorph to avoid wContains ambiguity
    		notifyChanged(fd, aspectualFeatures.put(fd, value), value, false);
    	}
    }
    public boolean wIsSet(FeatureDescriptor fd) {
    	return wIsSet(wIndexOf(fd));
    }
    public void wUnset(FeatureDescriptor fd) {
    	wUnset(wIndexOf(fd));
    }

	public boolean wContainsValue(Object otherValue) {
		return false;
	}

    public boolean wBooleanValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public byte wByteValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public char wCharValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public double wDoubleValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public float wFloatValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public int wIntValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public long wLongValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public short wShortValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public String wStringValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public Date wDateValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public EnumValue wEnumValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public Object wGetValue() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(boolean value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(byte value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(char value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(double value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(float value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(int value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(long value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(short value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(Date value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(EnumValue value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
	public void wSetValue(Object value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
	}
    public boolean wIsSet() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
    }
    public void wUnset() {
		throw new WholeIllegalArgumentException(WholeMessages.no_data);
    }

    @SuppressWarnings("unchecked")
	protected final <E extends IEntity> E notifyRequested(int index, E value) {
    	if (requestNotificationDisabled)
    		return value;

        FeatureDescriptor fd = CommonsFeatureDescriptorEnum.composite_element;
        IEntity value0 = value.wGetAdaptee(false);
        IEntity result = wGetEntityRequestEventHandler().notifyRequested(this, fd, index, value0);
    	result = wGetCompoundRequestEventHandler().notifyRequested(this, fd, index, result);
    	return result == value0 ? value : (E) result;
    }
    @SuppressWarnings("unchecked")
	protected final <E extends IEntity> E notifyRequested(FeatureDescriptor fd, E value) {
    	if (requestNotificationDisabled)
    		return value;

        IEntity value0 = value.wGetAdaptee(false);
    	IEntity result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value0);
    	result = wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    	return result == value0 ? value : (E) result;
    }
    protected final boolean notifyRequested(boolean value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	boolean result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final byte notifyRequested(byte value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	byte result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final char notifyRequested(char value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	char result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final double notifyRequested(double value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	double result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final float notifyRequested(float value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	float result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final int notifyRequested(int value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	int result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final long notifyRequested(long value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	long result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final short notifyRequested(short value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	short result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final String notifyRequested(String value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        String result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final Date notifyRequested(Date value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	Date result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    protected final java.sql.Date notifyRequested(java.sql.Date value) {
    	return (java.sql.Date) notifyRequested((Object) value);
    }
    protected final java.sql.Time notifyRequested(java.sql.Time value) {
    	return (java.sql.Time) notifyRequested((Object) value);
    }
    protected final java.sql.Timestamp notifyRequested(java.sql.Timestamp value) {
    	return (java.sql.Timestamp) notifyRequested((Object) value);
    }
    protected final <E extends EnumValue> E notifyRequested(E value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	E result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }
    @SuppressWarnings("unchecked")
	protected final <E> E notifyRequested(E value) {
    	if (requestNotificationDisabled)
    		return value;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	Object result = wGetEntityRequestEventHandler().notifyRequested(this, fd, value);
    	return (E) wGetCompoundRequestEventHandler().notifyRequested(this, fd, result);
    }


    public IEntity wGetOwner() {
    	if (wGetEntityDescriptor().isRelationship()) {
    		IEntity owner = wGetParent();
    		if (EntityUtils.isNull(owner) && wInverseAdjacentSize() == 1)
    			owner = wInverseAdjacents().iterator().next();
    		if (!EntityUtils.isNull(owner) && owner.wGetFeatureDescriptor(this).isToMany())
    			return owner;
    	}
    	return NullEntity.instance;
    }

    protected final void notifyAdded(int index, IEntity newValue, boolean isContainment) {
    	IEntity owner = wGetOwner();
    	if (!EntityUtils.isNull(owner) && EntityUtils.isNotResolver(owner)) {
            EntityDescriptor<?> ownerEd = owner.wGetEntityDescriptor();
            FeatureDescriptor ownerFd = owner.wGetFeatureDescriptor(this);

//was      	isContainment = !ownerEd.getEntityFeatureDescriptor(ownerFd).isReference();

            FeatureDescriptor oppositeFd;
            EntityDescriptor<?> oppositeEd;

            if (ownerEd.has(ownerFd)) {
            	oppositeEd = ownerFd.getEntityDescriptor();//ownerEd.getEntityDescriptor(ownerFd);
            	oppositeFd = ownerFd.getOppositeFeatureDescriptor();//ownerEd.getOppositeFeatureDescriptor(ownerFd);
            } else {
            	oppositeEd = newValue.wGetEntityDescriptor();
            	oppositeFd = oppositeEd.getDirectFeatureDescriptor(ownerFd);
            	if (oppositeFd != null)
            		ownerEd = oppositeEd.getEntityDescriptor(oppositeFd);
            }

            final EntityDescriptor<?> featureEd = ownerEd.getEntityDescriptor(ownerFd);
            final boolean isToMany = featureEd.isToManyRelationship();
            final boolean isToManyImpl = isToMany && Matcher.matchImpl(featureEd, this);
	        if (oppositeFd != null && isToManyImpl)
        		newValue.wAdd(oppositeFd, owner, true);
    	}

 		final InternalIEntity internalNewValue = (InternalIEntity) newValue;

     	if (isContainment) {
     		internalNewValue.wSetModel(wGetActualModel());
     		internalNewValue.wSetParent(this);
     	} else {
        	if (!EntityUtils.hasParent(newValue))
        		internalNewValue.wSetModel(wGetActualModel());
     		internalNewValue.wAddInverseAdjacent(this);
     	}

        FeatureDescriptor fd = CommonsFeatureDescriptorEnum.composite_element;
        IEntity newValue0 = newValue.wGetAdaptee(false);
    	wGetEntityChangeEventHandler().notifyAdded(this, fd, index, newValue0);
    	wGetCompoundChangeEventHandler().notifyAdded(this, fd, index, newValue0);
    }

    protected final void notifyRemoved(int index, IEntity oldValue, boolean isContainment) {
 		final InternalIEntity internalOldValue = (InternalIEntity) oldValue;

 		if (isContainment)
 			internalOldValue.wRemoveParent(this);
        else
     		internalOldValue.wRemoveInverseAdjacent(this);        	

        FeatureDescriptor fd = CommonsFeatureDescriptorEnum.composite_element;
        IEntity oldValue0 = oldValue.wGetAdaptee(false);
        wGetEntityChangeEventHandler().notifyRemoved(this, fd, index, oldValue0);
    	wGetCompoundChangeEventHandler().notifyRemoved(this, fd, index, oldValue0);
    }

    protected final void notifyChanged(int index, IEntity oldValue, IEntity newValue, boolean isContainment) {
    	final IEntity oldValue0 = oldValue.wGetAdaptee(false);
        final IEntity newValue0 = newValue.wGetAdaptee(false);

        if (newValue0 == oldValue0)
    		return;

 		final InternalIEntity internalOldValue = (InternalIEntity) oldValue;
 		final InternalIEntity internalNewValue = (InternalIEntity) newValue;

     	if (isContainment) {
     		internalOldValue.wRemoveParent(this);
     		internalNewValue.wSetModel(wGetActualModel());
     		internalNewValue.wSetParent(this);
     	} else {
     		internalOldValue.wRemoveInverseAdjacent(this);
        	if (!EntityUtils.hasParent(newValue))
        		internalNewValue.wSetModel(wGetActualModel());
     		internalNewValue.wAddInverseAdjacent(this);
     	}

        FeatureDescriptor fd = wGetFeatureDescriptor(index);
    	wGetEntityChangeEventHandler().notifyChanged(this, fd, index, oldValue0, newValue0);
//    	wGetFragmentChangeEventHandler().notifyChanged(this, fd, index, oldValue0, newValue0);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, index, oldValue0, newValue0);
    }
    protected final void notifyChanged(IEntity oldValue, IEntity newValue, boolean isContainment) {
    	notifyChanged(CommonsFeatureDescriptorEnum.composite_element, oldValue, newValue, isContainment);
    }
    protected final void notifyChanged(FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
        notifyChanged(fd, oldValue, newValue, true);
    }
    protected final void notifyChanged(FeatureDescriptor fd, IEntity oldValue, IEntity newValue, boolean isContainment) {
        if (oldValue == null)
        	oldValue = NullEntity.instance;

    	final IEntity oldValue0 = oldValue.wGetAdaptee(false);
        final IEntity newValue0 = newValue.wGetAdaptee(false);

        if (newValue0 == oldValue0)
        	return;

 		final InternalIEntity internalOldValue = (InternalIEntity) oldValue;
 		final InternalIEntity internalNewValue = (InternalIEntity) newValue;

        EntityDescriptor<?> thisEd = wGetEntityDescriptor();
        FeatureDescriptor oppositeFd;

        if (thisEd.has(fd))
        	oppositeFd = thisEd.getEntityFeatureDescriptor(fd).getOppositeFeatureDescriptor();//getOppositeFeatureDescriptor(fd);
        else {
        	EntityDescriptor<?> oppositeEd = newValue.wGetEntityDescriptor();
        	oppositeFd = oppositeEd.getDirectFeatureDescriptor(fd);
        	if (oppositeFd != null)
        		thisEd = oppositeEd.getEntityDescriptor(oppositeFd);
        }

        if (oppositeFd != null) {
            final EntityDescriptor<?> featureEd = thisEd.getEntityDescriptor(fd);
            final boolean isToMany = featureEd.isToManyRelationship();
            final boolean wasToManyImpl = isToMany && Matcher.matchImpl(featureEd, oldValue);
            final boolean isToManyImpl = isToMany && Matcher.matchImpl(featureEd, newValue);
            
            if (wasToManyImpl)
        		for (int i=0, size=oldValue.wSize(); i<size; i++)
                    oldValue.wGet(i).wRemove(oppositeFd, this);
            else
            	oldValue.wRemove(oppositeFd, this);

            if (isToManyImpl)
        		for (int i=0, size=newValue.wSize(); i<size; i++)
                    newValue.wGet(i).wAdd(oppositeFd, this, true);
            else
            	newValue.wAdd(oppositeFd, this, true);
        }

     	if (isContainment) {
     		internalOldValue.wRemoveParent(this);
     		internalNewValue.wSetModel(wGetActualModel());
     		internalNewValue.wSetParent(this);
     	} else {
     		internalOldValue.wRemoveInverseAdjacent(this);
        	if (!EntityUtils.hasParent(newValue))
        		internalNewValue.wSetModel(wGetActualModel());
     		internalNewValue.wAddInverseAdjacent(this);
     	}

    	wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue0, newValue0);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue0, newValue0);
    }

	public boolean wAdd(FeatureDescriptor fd, IEntity value, boolean forceUnique) {
		if (EntityUtils.isResolver(this))
			return false;//TODO move into AbstractEntityResolver

		EntityDescriptor<?> asEd = wGetEntityDescriptor();//TODO workaround for aspectual features
        if (asEd.has(fd)) {
			final EntityDescriptor<?> featureEd = asEd.getEntityDescriptor(fd);
			if (featureEd.isToManyRelationship()) {
				final IEntity oldValue = wGet(fd);
				if (EntityUtils.isResolver(oldValue))
					return oldValue.wAdd(value);
				else if (Matcher.matchImpl(featureEd, oldValue)) {
					int valueIndex;
					if (forceUnique && (valueIndex = oldValue.wIndexOf(value)) >=0 && value.equals(oldValue.wGet(valueIndex)))
						return false;
					else
						return oldValue.wAdd(value);
				}
			}
		}
		wSet(fd, value);
		return true;

	}
	public boolean wRemove(FeatureDescriptor fd, IEntity value) {
		if (EntityUtils.isResolver(this))
			return false;//TODO move into AbstractEntityResolver

		EntityDescriptor<?> asEd = wGetEntityDescriptor();//TODO workaround for aspectual features
		if (asEd.has(fd)) {
			final EntityDescriptor<?> featureEd = asEd.getEntityDescriptor(fd);
			if (featureEd.isToManyRelationship()) {
				final IEntity oldValue = wGet(fd);
				if (Matcher.matchImpl(featureEd, oldValue))
					return oldValue.wRemove(value);
			}
		}
		return wRemove(fd);
	}

    protected final void notifyChanged(boolean oldValue, boolean newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(byte oldValue, byte newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(char oldValue, char newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(double oldValue, double newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(float oldValue, float newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(int oldValue, int newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(long oldValue, long newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(short oldValue, short newValue) {
    	if (newValue == oldValue)
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
        wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(String oldValue, String newValue) {
    	if (newValue != null && newValue.equals(oldValue))
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(Date oldValue, Date newValue) {
    	if (newValue != null && newValue.equals(oldValue))
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(java.sql.Date oldValue, java.sql.Date newValue) {
    	notifyChanged((Object) oldValue, (Object) newValue);
    }
    protected final void notifyChanged(java.sql.Time oldValue, java.sql.Time newValue) {
    	notifyChanged((Object) oldValue, (Object) newValue);
    }
    protected final void notifyChanged(java.sql.Timestamp oldValue, java.sql.Timestamp newValue) {
    	notifyChanged((Object) oldValue, (Object) newValue);
    }
    protected final void notifyChanged(EnumValue oldValue, EnumValue newValue) {
    	if (newValue != null && newValue.equals(oldValue))
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
    protected final void notifyChanged(Object oldValue, Object newValue) {
    	if (newValue == oldValue || (newValue != null && oldValue != null && newValue.equals(oldValue)))
    	    return;

    	FeatureDescriptor fd = CommonsFeatureDescriptorEnum.data_value;
    	wGetEntityChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    	wGetCompoundChangeEventHandler().notifyChanged(this, fd, oldValue, newValue);
    }
}
