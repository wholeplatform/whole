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
package org.whole.lang.sql.reflect;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.BinaryExpression;
import org.whole.lang.sql.model.BinaryOperator;
import org.whole.lang.sql.model.BinaryOperatorEnum;
import org.whole.lang.sql.model.BooleanBinaryExpression;
import org.whole.lang.sql.model.BooleanOperator;
import org.whole.lang.sql.model.BooleanOperatorEnum;

/**
 * @author Riccardo Solmi
 */
public class OperatorGroupEnum extends EnumType<OperatorGroupEnum.OperatorGroup> {
	private static final long serialVersionUID = 1;

	public static final int LITERAL_ord = 0;
	public static final int POSTFIX_ord = 1; // [] .
	public static final int MULTIPLICATIVE_ord = 4; // * / %
	public static final int ADDITIVE_ord = 5; // + -
	public static final int RELATIONAL_ord = 6; // < > <= >=
	public static final int EQUALITY_ord = 7; // == !=
	public static final int LOGICAL_AND_ord = 8; // &&
	public static final int LOGICAL_OR_ord = 9; // ||

	public static final OperatorGroupEnum instance = new OperatorGroupEnum();

	public static final OperatorGroup LITERAL = instance.valueOf(LITERAL_ord);
	public static final OperatorGroup POSTFIX = instance.valueOf(POSTFIX_ord);
	public static final OperatorGroup MULTIPLICATIVE = instance.valueOf(MULTIPLICATIVE_ord);
	public static final OperatorGroup ADDITIVE = instance.valueOf(ADDITIVE_ord);
	public static final OperatorGroup RELATIONAL = instance.valueOf(RELATIONAL_ord);
	public static final OperatorGroup EQUALITY = instance.valueOf(EQUALITY_ord);
	public static final OperatorGroup LOGICAL_AND = instance.valueOf(LOGICAL_AND_ord);
	public static final OperatorGroup LOGICAL_OR = instance.valueOf(LOGICAL_OR_ord);

	private OperatorGroupEnum() {
		enumValue(LITERAL_ord, "LITERAL");
		enumValue(POSTFIX_ord, "POSTFIX");
		enumValue(MULTIPLICATIVE_ord, "MULTIPLICATIVE");
		enumValue(ADDITIVE_ord, "ADDITIVE");
		enumValue(RELATIONAL_ord, "RELATIONAL");
		enumValue(EQUALITY_ord, "EQUALITY");
		enumValue(LOGICAL_AND_ord, "LOGICAL_AND");
		enumValue(LOGICAL_OR_ord, "LOGICAL_OR");
	}

	public OperatorGroup valueOf(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case SQLEntityDescriptorEnum.BinaryExpression_ord:
			return valueOf(((BinaryExpression) entity).getOperator());
		case SQLEntityDescriptorEnum.BinaryOperator_ord:
			switch (((BinaryOperator) entity).getValue().getOrdinal()) {
			case BinaryOperatorEnum.div_ord:
			case BinaryOperatorEnum.mul_ord:
				return MULTIPLICATIVE;
			case BinaryOperatorEnum.concat_ord:
			case BinaryOperatorEnum.sub_ord:
			case BinaryOperatorEnum.sum_ord:
			default:
				return ADDITIVE;				
			}
		case SQLEntityDescriptorEnum.BooleanBinaryExpression_ord:
			return valueOf(((BooleanBinaryExpression) entity).getOperator());
		case SQLEntityDescriptorEnum.BooleanOperator_ord:
			switch (((BooleanOperator) entity).getValue().getOrdinal()) {
			case BooleanOperatorEnum.and_ord:
				return LOGICAL_AND;
			case BooleanOperatorEnum.or_ord:
			case BooleanOperatorEnum.like_ord:
				return LOGICAL_OR;
			case BooleanOperatorEnum.eq_ord:
			case BooleanOperatorEnum.ne_ord:
				return EQUALITY;
			case BooleanOperatorEnum.ge_ord:
			case BooleanOperatorEnum.gt_ord:
			case BooleanOperatorEnum.le_ord:
			case BooleanOperatorEnum.lt_ord:
			default:
				return RELATIONAL;
			}

		case SQLEntityDescriptorEnum.ArrayExpr_ord:
			return POSTFIX;
		case SQLEntityDescriptorEnum.ArrayValue_ord:
		case SQLEntityDescriptorEnum.BooleanValue_ord:
		case SQLEntityDescriptorEnum.TinyIntValue_ord:
		case SQLEntityDescriptorEnum.SmallIntValue_ord:
		case SQLEntityDescriptorEnum.IntValue_ord:
		case SQLEntityDescriptorEnum.BigIntValue_ord:
		case SQLEntityDescriptorEnum.DoubleValue_ord:
		case SQLEntityDescriptorEnum.RealValue_ord:
		case SQLEntityDescriptorEnum.DecimalValue_ord:
		case SQLEntityDescriptorEnum.StringValue_ord:
		case SQLEntityDescriptorEnum.BinaryValue_ord:
		case SQLEntityDescriptorEnum.DateValue_ord:
		case SQLEntityDescriptorEnum.TimeValue_ord:
		case SQLEntityDescriptorEnum.TimestampValue_ord:
		case SQLEntityDescriptorEnum.RawValue_ord:
		default:
			return LITERAL;
		}
	}

	public static boolean hasUnknownOperator(IEntity entity) {
		return entity.wGetEntityDescriptor().has(SQLFeatureDescriptorEnum.operator) &&
				!SQLLanguageKit.URI.equals(entity.wGet(SQLFeatureDescriptorEnum.operator).wGetLanguageKit().getURI());
	}
	public static boolean hasPrecedence(IEntity e1, IEntity e2) {
		if (!SQLLanguageKit.URI.equals(e2.wGetLanguageKit().getURI()))
			return !e2.wGetEntityKind().isData();
		if (hasUnknownOperator(e2))
			return true;
		else if (hasUnknownOperator(e1))
			return false;
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
