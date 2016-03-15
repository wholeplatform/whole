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
package org.whole.lang.firstorderlogic.reflect;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class StatementGroupEnum extends EnumType<StatementGroupEnum.StatementGroup> {
	public static final int LITERAL_ord = 0;
	public static final int UNARY_ord = 1; // !, forall exist
	public static final int COIMPLICATION_ord = 2; // <-->
	public static final int AND_ord = 3; // &&
	public static final int OR_ord = 4; // || xor
	public static final int IMPLICATION_ord = 5; // ->

	public static final StatementGroupEnum instance = new StatementGroupEnum();

	public static final StatementGroup LITERAL = instance.valueOf(LITERAL_ord);
	public static final StatementGroup UNARY = instance.valueOf(UNARY_ord);
	public static final StatementGroup COIMPLICATION = instance.valueOf(COIMPLICATION_ord);
	public static final StatementGroup AND = instance.valueOf(AND_ord);
	public static final StatementGroup OR = instance.valueOf(OR_ord);
	public static final StatementGroup IMPLICATION = instance.valueOf(IMPLICATION_ord);

	private StatementGroupEnum() {
		enumValue(LITERAL_ord, "LITERAL");
		enumValue(UNARY_ord, "UNARY");
		enumValue(COIMPLICATION_ord, "COIMPLICATION");
		enumValue(AND_ord, "AND");
		enumValue(OR_ord, "OR");
		enumValue(IMPLICATION_ord, "IMPLICATION");
	}

	public StatementGroup valueOf(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case FirstOrderLogicEntityDescriptorEnum.Not_ord:
		case FirstOrderLogicEntityDescriptorEnum.ForAll_ord:
		case FirstOrderLogicEntityDescriptorEnum.Exist_ord:
		case FirstOrderLogicEntityDescriptorEnum.ExistUnique_ord:
			return UNARY;
		case FirstOrderLogicEntityDescriptorEnum.And_ord:
			return AND;
		case FirstOrderLogicEntityDescriptorEnum.Or_ord:
		case FirstOrderLogicEntityDescriptorEnum.Xor_ord:
			return OR;
		case FirstOrderLogicEntityDescriptorEnum.EqualityPredicateApplication_ord:
		case FirstOrderLogicEntityDescriptorEnum.Coimplication_ord:
			return COIMPLICATION;
		case FirstOrderLogicEntityDescriptorEnum.Implication_ord:
			return IMPLICATION;
		default:
			return LITERAL;
		}
	}
	
	public static boolean hasPrecedence(IEntity e1, IEntity e2) {
		return instance.valueOf(e1).hasPrecedence(instance.valueOf(e2));
	}

	protected void enumValue(int ordinal, String name) {
		if (valueOf(name) == null)
			putEnumValue(new StatementGroup(ordinal, name));
	}

	public static class StatementGroup extends EnumValueImpl {
		public StatementGroup() {
			super();
		}

		public StatementGroup(int ordinal, String name) {
			super(ordinal, name);
		}

		public boolean hasPrecedence(StatementGroup op) {
			return getOrdinal() < op.getOrdinal();
		}
	}
}
