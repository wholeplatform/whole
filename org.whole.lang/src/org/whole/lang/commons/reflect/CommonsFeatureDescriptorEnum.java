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
package org.whole.lang.commons.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class CommonsFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int rootEntity_ord = 0;
	public static final int phase_ord = 1;
	public static final int varType_ord = 2;
	public static final int varName_ord = 3;
	public static final int quantifier_ord = 4;
    public static final int composite_element_ord = 5;
	public static final int data_value_ord = 6;
	
	public static final CommonsFeatureDescriptorEnum instance = new CommonsFeatureDescriptorEnum();
	public static final FeatureDescriptor rootEntity = instance.valueOf(rootEntity_ord);
	public static final FeatureDescriptor phase = instance.valueOf(phase_ord);
	public static final FeatureDescriptor varType = instance.valueOf(varType_ord);
	public static final FeatureDescriptor varName = instance.valueOf(varName_ord);
	public static final FeatureDescriptor quantifier = instance.valueOf(quantifier_ord);
	public static final FeatureDescriptor composite_element = instance.valueOf(composite_element_ord);
	public static final FeatureDescriptor data_value = instance.valueOf(data_value_ord);

	private CommonsFeatureDescriptorEnum() {
		putFeatureDescriptor(rootEntity_ord, "rootEntity");
		putFeatureDescriptor(phase_ord, "phase");
		putFeatureDescriptor(varType_ord, "varType");
		putFeatureDescriptor(varName_ord, "varName");
		putFeatureDescriptor(quantifier_ord, "quantifier");
		putFeatureDescriptor(composite_element_ord, "composite_element");
		putFeatureDescriptor(data_value_ord, "value");
	}

	private static final long serialVersionUID = 1;
}
