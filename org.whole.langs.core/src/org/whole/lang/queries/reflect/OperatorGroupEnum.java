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
package org.whole.lang.queries.reflect;

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
		case QueriesEntityDescriptorEnum.BooleanLiteral_ord:
		case QueriesEntityDescriptorEnum.ByteLiteral_ord:
		case QueriesEntityDescriptorEnum.CharLiteral_ord:
		case QueriesEntityDescriptorEnum.DoubleLiteral_ord:
		case QueriesEntityDescriptorEnum.FloatLiteral_ord:
		case QueriesEntityDescriptorEnum.IntLiteral_ord:
		case QueriesEntityDescriptorEnum.LongLiteral_ord:
		case QueriesEntityDescriptorEnum.ShortLiteral_ord:
		case QueriesEntityDescriptorEnum.StringLiteral_ord:
		case QueriesEntityDescriptorEnum.VoidLiteral_ord:
		case QueriesEntityDescriptorEnum.VariableRefStep_ord:
			return LITERAL;
		case QueriesEntityDescriptorEnum.Filter_ord:
			return ASSIGNMENT;
		case QueriesEntityDescriptorEnum.Addition_ord:
		case QueriesEntityDescriptorEnum.Subtraction_ord:
		case QueriesEntityDescriptorEnum.AdditionStep_ord:
		case QueriesEntityDescriptorEnum.SubtractionStep_ord:
			return ADDITIVE;
		case QueriesEntityDescriptorEnum.Multiplication_ord:
		case QueriesEntityDescriptorEnum.Division_ord:
		case QueriesEntityDescriptorEnum.Remainder_ord:
		case QueriesEntityDescriptorEnum.MultiplicationStep_ord:
		case QueriesEntityDescriptorEnum.DivisionStep_ord:
		case QueriesEntityDescriptorEnum.RemainderStep_ord:
			return MULTIPLICATIVE;
		case QueriesEntityDescriptorEnum.And_ord:
			return LOGICAL_AND;
		case QueriesEntityDescriptorEnum.Or_ord:
			return LOGICAL_OR;
		case QueriesEntityDescriptorEnum.Not_ord:
			return UNARY;
		case QueriesEntityDescriptorEnum.Equals_ord:
		case QueriesEntityDescriptorEnum.NotEquals_ord:
		case QueriesEntityDescriptorEnum.EqualsStep_ord:
		case QueriesEntityDescriptorEnum.NotEqualsStep_ord:
			return EQUALITY;
		case QueriesEntityDescriptorEnum.LessThan_ord:
		case QueriesEntityDescriptorEnum.LessOrEquals_ord:
		case QueriesEntityDescriptorEnum.GreaterThan_ord:
		case QueriesEntityDescriptorEnum.GreaterOrEquals_ord:
		case QueriesEntityDescriptorEnum.LessThanStep_ord:
		case QueriesEntityDescriptorEnum.LessOrEqualsStep_ord:
		case QueriesEntityDescriptorEnum.GreaterThanStep_ord:
		case QueriesEntityDescriptorEnum.GreaterOrEqualsStep_ord:
			return RELATIONAL;
		default:
			return LITERAL;
		}
	}
	
	public static boolean hasPrecedence(IEntity e1, IEntity e2) {
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
