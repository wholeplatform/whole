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
package org.whole.lang.editors.visitors;

import org.whole.lang.editors.model.GenericPartName;
import org.whole.lang.editors.model.GenericPartNameEnum;
import org.whole.lang.editors.model.RowElement;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class Helpers {
	public static String toEditPartName(GenericPartName genericPartName) {
		switch (genericPartName.getValue().getOrdinal()) {
		case GenericPartNameEnum.CompositeColumn_ord:
			return "MathCompositeColumnPart";
		case GenericPartNameEnum.CompositeRow_ord:
			return "MathCompositeRowPart";
		default:
			return genericPartName.getValue().getName();//TODO
		}
	}

	public static String toElementName(RowElement element) {
		switch (element.wGetEntityDescriptor().getOrdinal()) {
		case EditorsEntityDescriptorEnum.ChildPlace_ord:
			return "addChildPlace";
		case EditorsEntityDescriptorEnum.Indent_ord:
			return "addIndent";
		case EditorsEntityDescriptorEnum.FoldingToggle_ord:
			return "addFoldingToggle";
		case EditorsEntityDescriptorEnum.DelimiterToken_ord:
			return "addDelimiter";
		case EditorsEntityDescriptorEnum.IdentifierToken_ord:
			return "addIdentifier";
		case EditorsEntityDescriptorEnum.KeywordToken_ord:
			return "addKeyword";
		case EditorsEntityDescriptorEnum.LiteralToken_ord:
			return "addLiteral";
		case EditorsEntityDescriptorEnum.OperatorToken_ord:
			return "addOperator";
		case EditorsEntityDescriptorEnum.ParenthesisToken_ord:
			return "addParenthesis";	
		default:
			throw new IllegalArgumentException();
		}
	}
}
