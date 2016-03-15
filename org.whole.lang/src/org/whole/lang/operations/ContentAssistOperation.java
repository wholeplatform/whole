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
package org.whole.lang.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class ContentAssistOperation extends AbstractVisitorOperation {
	public static final String ID = "contentAssist";

	public static IEntity[] getContentAssist(IEntity entity, IBindingManager args) {
		ContentAssistOperation op = new ContentAssistOperation(args);
		op.setSelectedEntity(entity);
		if (!CommonsEntityDescriptorEnum.RootFragment.equals(entity.wGetEntityDescriptor())) {
			op.stagedVisit(entity);
			if (op.result == null || op.result.length == 0)
				op.visit(entity);
		}
		
		return op.getResult();
	}

	protected ContentAssistOperation(IBindingManager args) {
		super(ID, args, null);
	}

	private IEntity selectedEntity;
	public IEntity getSelectedEntity() {
		return selectedEntity;
	}
	public void setSelectedEntity(IEntity selectedEntity) {
		this.selectedEntity = selectedEntity;
	}

	private IEntity[] result;
	public IEntity[] getResult() {
		return result != null ? result : new IEntity[0];
	}
	public void setResult(IEntity[] result) {
		this.result = result;
	}
	public void setResult(IEntity values, EntityDescriptor<?> resultDescriptor) {
		int size = values.wSize();
		if (size == 0)
			return;
		
		IEntity[] result = new IEntity[size];
		for (int i=0; i<size; i++)
			result[i] = DataTypeUtils.convertCloneIfParented(values.wGet(i), resultDescriptor);

		Arrays.sort(result, new Comparator<IEntity>() {
			public int compare(IEntity e1, IEntity e2) {
				return DataTypeUtils.compareIgnoreCase(e1, e2);
			}
		});

		setResult(result);
	}
	public void setResult(Set<String> values, EntityDescriptor<?> resultDescriptor) {
		if (values.isEmpty())
			return;
		
		IEntity[] result = new IEntity[values.size()];
		int index = 0;

		for (String name : values)
			result[index++] = GenericEntityFactory.instance.create(resultDescriptor, name);

		Arrays.sort(result, new Comparator<IEntity>() {
			public int compare(IEntity e1, IEntity e2) {
				return DataTypeUtils.compareIgnoreCase(e1, e2);
			}
		});

		setResult(result);
	}

	@Override
    public void visit(IEntity entity) {
    	final EntityDescriptor<?> ed = entity.wGetEntityDescriptor();

    	switch (ed.getDataKind()) {
    	case NOT_A_DATA:
    		return;
    	case ENUM_VALUE:
    		final List<EnumValue> enumValues = new ArrayList<EnumValue>(ed.getDataEnumType().values());
    		final IDataTypeParser unparser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);

    		Collections.sort(enumValues, new Comparator<EnumValue>() {
    			public int compare(EnumValue arg0, EnumValue arg1) {
    				String arg0String = unparser.unparseEnumValue(ed, arg0);
    				String arg1String = unparser.unparseEnumValue(ed, arg1);
    				if (arg0String.length()==0 || arg1String.length()==0 ||
    						!Character.isLetterOrDigit(arg0String.charAt(0)) ||
    						!Character.isLetterOrDigit(arg1String.charAt(0)))
    					return arg0.compareTo(arg1);
    				else
    					return arg0String.compareTo(arg1String);
    			}
    		});

    		int size = enumValues.size();
			IEntity[] values = new IEntity[size];
    		for (int i=0; i<size; i++)
    			values[i] = GenericEntityFactory.instance.create(ed, enumValues.get(i));
    		setResult(values);
    		break;
    	case BOOLEAN:
	    	setResult(new IEntity[] {
	    			GenericEntityFactory.instance.create(ed, true),
	    			GenericEntityFactory.instance.create(ed, false)
	    	});
	    }
    }
}
