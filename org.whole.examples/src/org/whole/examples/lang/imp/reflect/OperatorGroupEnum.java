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
package org.whole.examples.lang.imp.reflect;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class OperatorGroupEnum extends EnumType<OperatorGroupEnum.OperatorGroup> {
	private static final long serialVersionUID = 1;

	public static final int LITERAL_ord = 0;
	public static final int POSTFIX_ord = 1; // [] .
	public static final int UNARY_ord = 2; // !
	public static final int CREATION_CAST_ord = 3; // new clone (type)
	public static final int MULTIPLICATIVE_ord = 4; // * / %
	public static final int ADDITIVE_ord = 5; // + -
	public static final int RELATIONAL_ord = 6; // < > <= >= instanceof
	public static final int EQUALITY_ord = 7; // == !=
	public static final int LOGICAL_AND_ord = 8; // &&
	public static final int LOGICAL_OR_ord = 9; // ||
	public static final int CONDITIONAL_ord = 10; // ?:
	public static final int ASSIGNMENT_ord = 11; // =

	public static final OperatorGroupEnum instance = new OperatorGroupEnum();

	public static final OperatorGroup LITERAL = instance.valueOf(LITERAL_ord);
	public static final OperatorGroup POSTFIX = instance.valueOf(POSTFIX_ord);
	public static final OperatorGroup UNARY = instance.valueOf(UNARY_ord);
	public static final OperatorGroup CREATION_CAST = instance.valueOf(CREATION_CAST_ord);
	public static final OperatorGroup MULTIPLICATIVE = instance.valueOf(MULTIPLICATIVE_ord);
	public static final OperatorGroup ADDITIVE = instance.valueOf(ADDITIVE_ord);
	public static final OperatorGroup RELATIONAL = instance.valueOf(RELATIONAL_ord);
	public static final OperatorGroup EQUALITY = instance.valueOf(EQUALITY_ord);
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
		enumValue(RELATIONAL_ord, "RELATIONAL");
		enumValue(EQUALITY_ord, "EQUALITY");
		enumValue(LOGICAL_AND_ord, "LOGICAL_AND");
		enumValue(LOGICAL_OR_ord, "LOGICAL_OR");
		enumValue(CONDITIONAL_ord, "CONDITIONAL");
		enumValue(ASSIGNMENT_ord, "ASSIGNMENT");
	}

	public OperatorGroup valueOf(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case ImpEntityDescriptorEnum.BooleanLiteral_ord:
		case ImpEntityDescriptorEnum.IntLiteral_ord:
		case ImpEntityDescriptorEnum.StringLiteral_ord:
		case ImpEntityDescriptorEnum.ArrayLiteral_ord:
		case ImpEntityDescriptorEnum.RangeLiteral_ord:
		case ImpEntityDescriptorEnum.NameExpression_ord:
			return LITERAL;
		case ImpEntityDescriptorEnum.ArrayAccess_ord:
		case ImpEntityDescriptorEnum.SizeExpression_ord:
			return POSTFIX;
		case ImpEntityDescriptorEnum.AssignmentExpression_ord:
		case ImpEntityDescriptorEnum.LoadExpression_ord:
		case ImpEntityDescriptorEnum.RunExpression_ord:
			return ASSIGNMENT;
		case ImpEntityDescriptorEnum.Addition_ord:
		case ImpEntityDescriptorEnum.Subtraction_ord:
			return ADDITIVE;
		case ImpEntityDescriptorEnum.Multiplication_ord:
		case ImpEntityDescriptorEnum.Division_ord:
		case ImpEntityDescriptorEnum.Remainder_ord:
			return MULTIPLICATIVE;
		case ImpEntityDescriptorEnum.And_ord:
			return LOGICAL_AND;
		case ImpEntityDescriptorEnum.Or_ord:
			return LOGICAL_OR;
		case ImpEntityDescriptorEnum.Not_ord:
			return UNARY;
		case ImpEntityDescriptorEnum.Equals_ord:
		case ImpEntityDescriptorEnum.NotEquals_ord:
			return EQUALITY;
		case ImpEntityDescriptorEnum.LessThan_ord:
		case ImpEntityDescriptorEnum.LessOrEquals_ord:
		case ImpEntityDescriptorEnum.GreaterThan_ord:
		case ImpEntityDescriptorEnum.GreaterOrEquals_ord:
			return RELATIONAL;
		default:
			return LITERAL;
		}
	}
	
	public static boolean hasPrecedence(IEntity e1, IEntity e2) {
		return instance.valueOf(e1).hasPrecedence(instance.valueOf(e2));
	}

	protected void enumValue(int ordinal, String name) {
		if (valueOf(name) == null)
			putEnumValue(new OperatorGroup(ordinal, name));
	}

	public static class OperatorGroup extends EnumValueImpl {
		private static final long serialVersionUID = 1;

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
