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
package org.whole.lang.commons.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.ContentLightDataEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderOptionalPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.editparts.VariableDataEntityPart;

/**
 * @author Riccardo Solmi
 */
public class CommonsPartFactoryVisitor implements IEditPartFactory {
	public EditPart createEditPart(EditPart context, Object modelEntity) {
		IEntity entity = (IEntity) modelEntity;

		switch (entity.wGetEntityDescriptor().getOrdinal()) {
		case CommonsEntityDescriptorEnum.RootFragment_ord:
			return new RootFragmentPart();
//		case CommonsEntityDescriptorEnum.SameStageFragment_ord:
//			return new SameStageFragmentVerbosePart();
//		case CommonsEntityDescriptorEnum.StageDownFragment_ord:
//			return new StageDownFragmentVerbosePart();
//		case CommonsEntityDescriptorEnum.StageUpFragment_ord:
//			return new StageUpFragmentVerbosePart();
		case CommonsEntityDescriptorEnum.SameStageFragment_ord:
			return new SameStageFragmentPart();
		case CommonsEntityDescriptorEnum.StageDownFragment_ord:
			return new StageDownFragmentPart();
		case CommonsEntityDescriptorEnum.StageUpFragment_ord:
			return new StageUpFragmentPart();
		case CommonsEntityDescriptorEnum.TemplateFragment_ord:
			return new TemplateFragmentPart();
		case CommonsEntityDescriptorEnum.BaseFragment_ord:
			return new BaseFragmentPart();
		case CommonsEntityDescriptorEnum.Phase_ord:
			return new VariableDataEntityPart();
		case CommonsEntityDescriptorEnum.Variable_ord:
			return new VariablePart();
		case CommonsEntityDescriptorEnum.InlineVariable_ord:
			return new InlineVariablePart();
		case CommonsEntityDescriptorEnum.VarName_ord:
			return new VariableDataEntityPart();
		case CommonsEntityDescriptorEnum.VarType_ord:
			return new VarTypePart();
		case CommonsEntityDescriptorEnum.Quantifier_ord:
			return new ContentLightDataEntityPart();
		case CommonsEntityDescriptorEnum.Resolver_ord:
		default:
			if (context != null) {
				IEntity parentEntity = ((IEntity) context.getModel()).wGetAdaptee(false);

				int index = parentEntity.wIndexOf(entity);
				if (index >= 0 && parentEntity.wGetFeatureDescriptor(index).isOptional())
					return new PlaceHolderOptionalPart();
			}
			return new PlaceHolderPart();
		}
	}
}
