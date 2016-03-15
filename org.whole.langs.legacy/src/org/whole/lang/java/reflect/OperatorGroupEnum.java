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
package org.whole.lang.java.reflect;

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.java.model.InfixExpression;
import org.whole.lang.java.model.InfixOperatorEnum;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.WholeMessages;

/**
 * @author Giovanni De Facci
 */
public class OperatorGroupEnum extends EnumType<OperatorGroupEnum.OperatorGroup> {
	public static final int LITERAL_ord = 0;
	/**
	 * 	++	post-increment
	 * 	--	post-decrement		
	 */
	public static final int POSTFIX_ord = 1; 
	/**
	 * 	++	pre-increment
	 * 	--	pre-decrement
	 * 	+	unary plus
	 * 	-	unary minus
	 * 	!	logical NOT
	 * 	~	bitwise NOT
	 */
	public static final int PREFIX_ord = 2; 
	public static final int CREATION_CAST_ord = 3; // new (type)
	public static final int MULTIPLICATIVE_ord = 4; // * / %
	public static final int ADDITIVE_ord = 5; // + -
	/**
	 *	<< >>	shift
	 *	>>>	
	 */
	public static final int SHIFT_ord = 6; // + -
	public static final int RELATIONAL_ord = 7; // < > <= >= instanceof
	public static final int EQUALITY_ord = 8; // == !=
	public static final int BITWISE_AND_ord = 9; // &
	public static final int BITWISE_XOR_ord = 10; // ^
	public static final int BITWISE_OR_ord = 11; // |
	public static final int LOGICAL_AND_ord = 12; // &&
	public static final int LOGICAL_OR_ord = 13; // ||
	public static final int CONDITIONAL_ord = 14; // ?:

	/**
	 *   =   +=   -=
	 *  *=   /=   %=
	 *  &=   ^=   |=
	 * <<=  >>= >>>=
	 */
	public static final int ASSIGNMENT_ord = 15; 

	public static final OperatorGroupEnum instance = new OperatorGroupEnum();

	public static final OperatorGroup LITERAL = instance.valueOf(LITERAL_ord);
	public static final OperatorGroup POSTFIX = instance.valueOf(POSTFIX_ord);
	public static final OperatorGroup PREFIX = instance.valueOf(PREFIX_ord);
	public static final OperatorGroup CREATION_CAST = instance.valueOf(CREATION_CAST_ord);
	public static final OperatorGroup MULTIPLICATIVE = instance.valueOf(MULTIPLICATIVE_ord);
	public static final OperatorGroup ADDITIVE = instance.valueOf(ADDITIVE_ord);
	public static final OperatorGroup SHIFT = instance.valueOf(SHIFT_ord);
	public static final OperatorGroup RELATIONAL = instance.valueOf(RELATIONAL_ord);
	public static final OperatorGroup EQUALITY = instance.valueOf(EQUALITY_ord);
	public static final OperatorGroup BITWISE_AND = instance.valueOf(BITWISE_AND_ord);
	public static final OperatorGroup BITWISE_XOR = instance.valueOf(BITWISE_XOR_ord);
	public static final OperatorGroup BITWISE_OR = instance.valueOf(BITWISE_OR_ord);
	/**
	 * FIXME: consider using "CONDITIONAL_" prefix instead of "LOGICAL_" prefix to keep consistent with org.whole.lang.java.model.InfixOperatorEnum
	 */
	public static final OperatorGroup LOGICAL_AND = instance.valueOf(LOGICAL_AND_ord);
	/**
	 * FIXME: consider using "CONDITIONAL_" prefix instead of "LOGICAL_" prefix to keep consistent with org.whole.lang.java.model.InfixOperatorEnum
	 */
	public static final OperatorGroup LOGICAL_OR = instance.valueOf(LOGICAL_OR_ord);
	public static final OperatorGroup CONDITIONAL = instance.valueOf(CONDITIONAL_ord);
	public static final OperatorGroup ASSIGNMENT = instance.valueOf(ASSIGNMENT_ord);

	private OperatorGroupEnum() {
		enumValue(LITERAL_ord, "LITERAL");
		enumValue(POSTFIX_ord, "POSTFIX");
		enumValue(PREFIX_ord, "UNARY");
		enumValue(CREATION_CAST_ord, "CREATION_CAST");
		enumValue(MULTIPLICATIVE_ord, "MULTIPLICATIVE");
		enumValue(ADDITIVE_ord, "ADDITIVE");
		enumValue(SHIFT_ord, "SHIFT");
		enumValue(RELATIONAL_ord, "RELATIONAL");
		enumValue(EQUALITY_ord, "EQUALITY");
		enumValue(BITWISE_AND_ord, "BITWISE_AND");
		enumValue(BITWISE_XOR_ord, "BITWISE_XOR");
		enumValue(BITWISE_OR_ord , "BITWISE_OR" );
		enumValue(LOGICAL_AND_ord, "LOGICAL_AND");
		enumValue(LOGICAL_OR_ord, "LOGICAL_OR");
		enumValue(CONDITIONAL_ord, "CONDITIONAL");
		enumValue(ASSIGNMENT_ord, "ASSIGNMENT");
	}

	public OperatorGroup valueOf(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case JavaEntityDescriptorEnum.PostfixExpression_ord:
			return POSTFIX;
		case JavaEntityDescriptorEnum.PrefixExpression_ord:
			return PREFIX;
		case JavaEntityDescriptorEnum.InfixExpression_ord:
			switch (((InfixExpression) entity).getOperator().getValue().getOrdinal()) {
			case InfixOperatorEnum .times_ord:
			case InfixOperatorEnum .divide_ord:
			case InfixOperatorEnum .remainder_ord: 
				return MULTIPLICATIVE;
			case InfixOperatorEnum .plus_ord:
			case InfixOperatorEnum .minus_ord: 
				return ADDITIVE;
			case InfixOperatorEnum .left_shift_ord:
			case InfixOperatorEnum .right_shift_signed_ord:
			case InfixOperatorEnum .right_shift_unsigned_ord:
				return SHIFT;
			case InfixOperatorEnum .less_ord:
			case InfixOperatorEnum .less_equals_ord:
			case InfixOperatorEnum .greater_ord:
			case InfixOperatorEnum .greater_equals_ord:
				return RELATIONAL;
			case InfixOperatorEnum .equals_ord:
			case InfixOperatorEnum .not_equals_ord:
				return EQUALITY;
			case InfixOperatorEnum .and_ord:
				return BITWISE_AND;
			case InfixOperatorEnum .xor_ord:
				return BITWISE_XOR;
			case InfixOperatorEnum .or_ord:
				return BITWISE_OR;
			case InfixOperatorEnum .conditional_and_ord:
				return LOGICAL_AND;
			case InfixOperatorEnum .conditional_or_ord:
				return LOGICAL_OR;
			default:
				throw new WholeIllegalArgumentException(WholeMessages.no_data);
			}
		case JavaEntityDescriptorEnum.Assignment_ord:
			return ASSIGNMENT;
		default:
			return LITERAL;
		}
	}

	public static boolean hasUnknownOperator(IEntity entity) {
		return entity.wGetEntityDescriptor().has(JavaFeatureDescriptorEnum.operator) &&
				!JavaLanguageKit.URI.equals(entity.wGet(JavaFeatureDescriptorEnum.operator).wGetLanguageKit().getURI());
	}
	public static boolean hasPrecedence(IEntity e1, IEntity e2) {
		if (!JavaLanguageKit.URI.equals(e2.wGetLanguageKit().getURI()))
			return !e2.wGetEntityKind().isData();
		else if (hasUnknownOperator(e2))
			return true;
		else if (hasUnknownOperator(e1))
			return false;
		return instance.valueOf(e1).hasPrecedence(instance.valueOf(e2));
	}

	private static final long serialVersionUID = 1;

	protected void enumValue(int ordinal, String name) {
		if (valueOf(name) == null)
			putEnumValue(new OperatorGroup(ordinal, name));
	}

	public static class OperatorGroup extends EnumValueImpl {
		private static final long serialVersionUID = 1L;

		public OperatorGroup() {
			super();
		}

		public OperatorGroup(int ordinal, String name) {
			super(ordinal, name);
		}

		public boolean hasPrecedence(OperatorGroup op) {
			return getOrdinal() < op.getOrdinal();
		}
	}
}
