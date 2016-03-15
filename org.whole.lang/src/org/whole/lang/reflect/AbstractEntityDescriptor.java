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

import java.util.BitSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractEntityDescriptor<E extends IEntity> extends EnumValueImpl implements EntityDescriptor<E> {
	private Class<E> entityType;
	private boolean isAbstract;
	private boolean isRelationship;

    protected AbstractEntityDescriptor() {} //Reserved to standard serialization
	protected AbstractEntityDescriptor(int ordinal, String name, String implName, Class<E> type, boolean isAbstract, boolean isRelationship) {
        super(ordinal, name, implName);
        this.entityType = type;
        this.isAbstract = isAbstract;
        this.isRelationship = isRelationship;
    }
	protected AbstractEntityDescriptor(int ordinal, String name, String implName, Class<E> type, EnumSet<EntityModifiers> modifiers) {
        this(ordinal, name, implName, type,
        		modifiers != null && modifiers.contains(EntityModifiers.ABSTRACT),
        		modifiers != null && modifiers.contains(EntityModifiers.RELATIONSHIP));
    }

    public ILanguageKit getLanguageKit() {
    	return getEntityDescriptorEnum().getLanguageKit();
    }

    public String getURI() {
		return CommonsDataTypePersistenceParser.unparseEntityDescriptor(this);
	}

    public EntityDescriptorEnum getEntityDescriptorEnum() {
		return getEnumType(EntityDescriptorEnum.class);
	}
	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return getLanguageKit().getFeatureDescriptorEnum();
	}

    public Class<E> getEntityType() {
    	return entityType;
    }
    public CompositeKinds getCompositeKind() {
    	return CompositeKinds.NOT_A_COMPOSITE;
    }
    public DataKinds getDataKind() {
    	return DataKinds.NOT_A_DATA;
    }
    public Class<?> getDataType() {
    	return null;
    }
    public EnumType<? extends EnumValue> getDataEnumType() {
    	return null;
    }
    public EntityDescriptor<E> withDataEnumType(EnumType<?> enumType) {
    	throw new IllegalStateException("withDataEnumType is defined only for enum data entities");
    }

	public boolean isAbstract() {
		return isAbstract;
	}
	public boolean isRelationship() {
		return isRelationship;
	}
	public boolean isToManyRelationship() {
		return false;
	}

    public List<FeatureDescriptor> getEntityFeatureDescriptors() {
    	return Collections.<FeatureDescriptor>emptyList();
    }
    public FeatureDescriptor getEntityFeatureDescriptor(FeatureDescriptor fd) {
    	return getEntityFeatureDescriptor(indexOf(fd));
    }
    public FeatureDescriptor getEntityFeatureDescriptor(int index) {
		throw new IllegalArgumentException("No such feature");
    }


    public boolean has(FeatureDescriptor fd) {
    	return indexOf(fd) != -1;
    }
    public int indexOf(FeatureDescriptor fd) {
    	return -1;
    }

    public FeatureDescriptor getDirectFeatureDescriptor(FeatureDescriptor oppositeFd) {
    	for (FeatureDescriptor efd : getEntityFeatureDescriptors()) {
    		FeatureDescriptor fd = efd.getOppositeFeatureDescriptor();
    		if (fd != null && fd.equals(oppositeFd))
    			return efd;
    	}
		return null;
    }
    public EntityDescriptor<?> getEntityDescriptor(int index) {
		return getEntityFeatureDescriptor(index).getEntityDescriptor();
    }
    public EntityDescriptor<?> getEntityDescriptor(FeatureDescriptor fd) {
    	return getEntityDescriptor(indexOf(fd));
    }

	public boolean isSubtypeOfAny() {
		HashSet<EntityDescriptor<?>> supertypes = new HashSet<EntityDescriptor<?>>();
		return declaredSupertypesUpto(null, supertypes) && EntityDescriptorEnum.isAllTypes(supertypes);
	}
	public boolean isSupertypeOfAny() {
		HashSet<EntityDescriptor<?>> subtypes = new HashSet<EntityDescriptor<?>>();
		return declaredSubtypesUpto(null, subtypes) && EntityDescriptorEnum.isAllTypes(subtypes);
	}
    public boolean isLanguageSubtypeOf(EntityDescriptor<?> ed) {
    	return getLanguageKit().equals(ed.getLanguageKit()) ?
    			languageSupertypes().get(ed.getOrdinal()) : false;
    }
    public boolean isLanguageSupertypeOf(EntityDescriptor<?> ed) {
    	return equals(ed);
    }
    public boolean isPlatformSupertypeOf(EntityDescriptor<?> ed) {
    	return declaredSubtypesUpto(ed, new HashSet<EntityDescriptor<?>>()) || ed.declaredSupertypesUpto(this, new HashSet<EntityDescriptor<?>>());
    }
    public boolean isExtendedLanguageSupertypeOf(EntityDescriptor<?> ed) {
		return getLanguageKit().equals(ed.getLanguageKit()) ?
				isLanguageSupertypeOf(ed) : isPlatformSupertypeOf(ed);
    }

    public void setLanguageSubtypes(boolean enable, int... edOrdinals) {
    	throw new UnsupportedOperationException();
    }

    private BitSet languageSupertypes;
    protected BitSet languageSupertypes() {
    	if (languageSupertypes == null) {
    		languageSupertypes = new BitSet();
    		languageSupertypes.set(getOrdinal());

    		EntityDescriptorEnum edEnum = getEntityDescriptorEnum();
    		for (EntityDescriptor<?> superEd : edEnum)
    			if (superEd.isLanguageSupertypeOf(this))
    				languageSupertypes.set(superEd.getOrdinal());
    	}
    	return languageSupertypes;
    }
    private BitSet languageSubtypes;
    protected BitSet languageSubtypes() {
    	if (languageSubtypes == null) {
    		languageSubtypes = new BitSet();
    		languageSubtypes.set(getOrdinal());
    	}
    	return languageSubtypes;
    }

    public Iterable<EntityDescriptor<?>> languageSupertypesIterable() {
    	return new Iterable<EntityDescriptor<?>>() {
    		public Iterator<EntityDescriptor<?>> iterator() {
    			return new Iterator<EntityDescriptor<?>>() {
	        		private int fromIndex;
	
	    			public boolean hasNext() {
	    				return fromIndex >= 0 && languageSupertypes().nextSetBit(fromIndex) >= 0;
	    			}
	    			public EntityDescriptor<?> next() {
	    				if (fromIndex < 0)
	    					throw new NoSuchElementException();
	
	    				fromIndex = languageSupertypes().nextSetBit(fromIndex);
	    				return getEntityDescriptorEnum().valueOf(fromIndex++);
	    			}
	
	    			public void remove() {
	    				throw new UnsupportedOperationException();
	    			}
	        	};
    		}
    	};
    }
    public Iterable<EntityDescriptor<?>> languageSubtypesIterable() {
    	return new Iterable<EntityDescriptor<?>>() {
    		public Iterator<EntityDescriptor<?>> iterator() {
    			return new Iterator<EntityDescriptor<?>>() {
	        		private int fromIndex;
	
	    			public boolean hasNext() {
	    				return fromIndex >= 0 && languageSubtypes().nextSetBit(fromIndex) >= 0;
	    			}
	    			public EntityDescriptor<?> next() {
	    				if (fromIndex < 0)
	    					throw new NoSuchElementException();
	
	    				fromIndex = languageSubtypes().nextSetBit(fromIndex);
	    				return getEntityDescriptorEnum().valueOf(fromIndex++);
	    			}
	
	    			public void remove() {
	    				throw new UnsupportedOperationException();
	    			}
	        	};
    		}
    	};
    }

    public /*final*/ Set<EntityDescriptor<?>> getLanguageConcreteSubtypes() {
        return getLanguageConcreteSubtypes(new HashSet<EntityDescriptor<?>>());
    }
    public Set<EntityDescriptor<?>> getLanguageConcreteSubtypes(Set<EntityDescriptor<?>> set) {
        set.add(this);
        return set;
    }

    public boolean declaredSupertypesUpto(EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> supertypes) {
		if (optTargetEd != null && isLanguageSubtypeOf(optTargetEd))
			return true;

		EntityDescriptorEnum edEnum = getEntityDescriptorEnum();
	   	for (int i=languageSupertypes().nextSetBit(0); i>=0; i=languageSupertypes().nextSetBit(i+1))
			if (edEnum.declaredForeignSupertypesUpto(edEnum.valueOf(i), optTargetEd, supertypes))
				return true;

		return false;
    }
    public boolean declaredSubtypesUpto(EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> subtypes) {
		return (optTargetEd != null && isLanguageSupertypeOf(optTargetEd)) ||
				getEntityDescriptorEnum().declaredForeignSubtypesUpto(this, optTargetEd, subtypes);
    }

    public boolean isPolymorphic() {
    	return false;
    }

	public EntityDescriptor<E> withFeature(FeatureDescriptor fd, int edOrdinal) {
		return withFeature(fd, edOrdinal, null, false, false, false, false, false);
	}
    public EntityDescriptor<E> withFeature(FeatureDescriptor fd, int edOrdinal,
    		boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared) {
		return withFeature(fd, edOrdinal, null, isOptional, isId, isReference, isDerived, isShared);
    }
    public EntityDescriptor<E> withFeature(FeatureDescriptor fd, int edOrdinal,
    		FeatureDescriptor oppositeFd,
    		boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared) {
    	throw new UnsupportedOperationException();
    }

	public String toString() {
		return (getLanguageKit() != null ? getLanguageKit().getURI()+"#" : "")+getName();
	}
}
