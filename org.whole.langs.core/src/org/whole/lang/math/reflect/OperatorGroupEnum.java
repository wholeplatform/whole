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
package org.whole.lang.math.reflect;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class OperatorGroupEnum extends EnumType<OperatorGroupEnum.OperatorGroup> {
	public static final int LITERAL_ord = 0;
	public static final int POSTFIX_ord = 1; // [] .
	public static final int UNARY_ord = 2; // !
	public static final int CREATION_CAST_ord = 3; // new clone (type)
	public static final int MULTIPLICATIVE_ord = 4; // * / %
	public static final int ADDITIVE_ord = 5; // + -
	public static final int SUBSET_ord = 6;
	public static final int RELATIONAL_ord = 7; // < > <= >= instanceof
	public static final int EQUALITY_ord = 8; // == !=
	public static final int BITWISE_XOR_ord = 9; // ^
	public static final int LOGICAL_AND_ord = 10; // &&
	public static final int LOGICAL_OR_ord = 11; // ||
	public static final int CONDITIONAL_ord = 12; // ?:
	public static final int ASSIGNMENT_ord = 13; // =

	public static final OperatorGroupEnum instance = new OperatorGroupEnum();

	public static final OperatorGroup LITERAL = instance.valueOf(LITERAL_ord);
	public static final OperatorGroup POSTFIX = instance.valueOf(POSTFIX_ord);
	public static final OperatorGroup UNARY = instance.valueOf(UNARY_ord);
	public static final OperatorGroup CREATION_CAST = instance.valueOf(CREATION_CAST_ord);
	public static final OperatorGroup MULTIPLICATIVE = instance.valueOf(MULTIPLICATIVE_ord);
	public static final OperatorGroup ADDITIVE = instance.valueOf(ADDITIVE_ord);
	public static final OperatorGroup SUBSET = instance.valueOf(SUBSET_ord);
	public static final OperatorGroup RELATIONAL = instance.valueOf(RELATIONAL_ord);
	public static final OperatorGroup EQUALITY = instance.valueOf(EQUALITY_ord);
	public static final OperatorGroup BITWISE_XOR = instance.valueOf(BITWISE_XOR_ord);
	public static final OperatorGroup LOGICAL_AND = instance.valueOf(LOGICAL_AND_ord);
	public static final OperatorGroup LOGICAL_OR = instance.valueOf(LOGICAL_OR_ord);
	public static final OperatorGroup CONDITIONAL = instance.valueOf(CONDITIONAL_ord);
	public static final OperatorGroup ASSIGNMENT = instance.valueOf(ASSIGNMENT_ord);

	private OperatorGroupEnum() {
		enumValue(LITERAL_ord, "LITERAL");
		enumValue(POSTFIX_ord, "POSTFIX");
		enumValue(UNARY_ord, "UNARY");
		enumValue(CREATION_CAST_ord, "CREATION_CAST");
		enumValue(MULTIPLICATIVE_ord, "MULTIPLICATIVE");
		enumValue(ADDITIVE_ord, "ADDITIVE");
		enumValue(SUBSET_ord, "SUBSET");
		enumValue(RELATIONAL_ord, "RELATIONAL");
		enumValue(EQUALITY_ord, "EQUALITY");
		enumValue(BITWISE_XOR_ord, "BITWISE_XOR");
		enumValue(LOGICAL_AND_ord, "LOGICAL_AND");
		enumValue(LOGICAL_OR_ord, "LOGICAL_OR");
		enumValue(CONDITIONAL_ord, "CONDITIONAL");
		enumValue(ASSIGNMENT_ord, "ASSIGNMENT");
	}

	public OperatorGroup valueOf(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case MathEntityDescriptorEnum.Boolean_ord:
		case MathEntityDescriptorEnum.ByteInteger_ord:
		case MathEntityDescriptorEnum.ShortInteger_ord:
		case MathEntityDescriptorEnum.Integer_ord:
		case MathEntityDescriptorEnum.LongInteger_ord:
		case MathEntityDescriptorEnum.BigInteger_ord:
		case MathEntityDescriptorEnum.Float_ord:
		case MathEntityDescriptorEnum.Double_ord:
		case MathEntityDescriptorEnum.BigDecimal_ord:
			return LITERAL;
		case MathEntityDescriptorEnum.Addition_ord:
		case MathEntityDescriptorEnum.Subtraction_ord:
		case MathEntityDescriptorEnum.Union_ord:
			return ADDITIVE;
		case MathEntityDescriptorEnum.ProperSubset_ord:
		case MathEntityDescriptorEnum.Subset_ord:
			return SUBSET;
		case MathEntityDescriptorEnum.Multiplication_ord:
		case MathEntityDescriptorEnum.Division_ord:
		case MathEntityDescriptorEnum.Remainder_ord:
			return MULTIPLICATIVE;
		case MathEntityDescriptorEnum.ExclusiveOr_ord:
			return BITWISE_XOR;
		case MathEntityDescriptorEnum.And_ord:
			return LOGICAL_AND;
		case MathEntityDescriptorEnum.Or_ord:
			return LOGICAL_OR;
		case MathEntityDescriptorEnum.Not_ord:
			return UNARY;
		case MathEntityDescriptorEnum.Equals_ord:
		case MathEntityDescriptorEnum.NotEquals_ord:
			return EQUALITY;
		case MathEntityDescriptorEnum.LessThan_ord:
		case MathEntityDescriptorEnum.LessOrEqual_ord:
		case MathEntityDescriptorEnum.GreaterThan_ord:
		case MathEntityDescriptorEnum.GreaterOrEqual_ord:
			return RELATIONAL;
		default:
			return LITERAL;
		}
	}

	public static boolean hasPrecedence(IEntity e1, IEntity e2) {
		if (!MathLanguageKit.URI.equals(e2.wGetLanguageKit().getURI()))
			return !e2.wGetEntityKind().isData();
		else
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
