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
package org.whole.lang.commons.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 * @author Riccardo Solmi
 */
public class QuantifierEnum extends EnumType<QuantifierEnum.Value> {
	public static final int OPTIONAL_ord = 0;
	public static final int MANDATORY_ord = 1;
	public static final int ZERO_OR_MORE_GREEDY_ord = 2;
	public static final int ONE_OR_MORE_GREEDY_ord = 3;
	public static final int ZERO_OR_MORE_RELUCTANT_ord = 4;
	public static final int ONE_OR_MORE_RELUCTANT_ord = 5;
	public static final int ZERO_OR_MORE_POSSESSIVE_ord = 6;
	public static final int ONE_OR_MORE_POSSESSIVE_ord = 7;
	public static final QuantifierEnum instance = new QuantifierEnum();
	public static final Value OPTIONAL = instance.valueOf(OPTIONAL_ord);
	public static final Value MANDATORY = instance.valueOf(MANDATORY_ord);
	public static final Value ZERO_OR_MORE_GREEDY = instance.valueOf(ZERO_OR_MORE_GREEDY_ord);
	public static final Value ONE_OR_MORE_GREEDY = instance.valueOf(ONE_OR_MORE_GREEDY_ord);
	public static final Value ZERO_OR_MORE_RELUCTANT = instance.valueOf(ZERO_OR_MORE_RELUCTANT_ord);
	public static final Value ONE_OR_MORE_RELUCTANT = instance.valueOf(ONE_OR_MORE_RELUCTANT_ord);
	public static final Value ZERO_OR_MORE_POSSESSIVE = instance.valueOf(ZERO_OR_MORE_POSSESSIVE_ord);
	public static final Value ONE_OR_MORE_POSSESSIVE = instance.valueOf(ONE_OR_MORE_POSSESSIVE_ord);

	private QuantifierEnum() {
		enumValue(OPTIONAL_ord, "OPTIONAL");
		enumValue(MANDATORY_ord, "MANDATORY");
		enumValue(ZERO_OR_MORE_GREEDY_ord, "ZERO_OR_MORE_GREEDY");
		enumValue(ONE_OR_MORE_GREEDY_ord, "ONE_OR_MORE_GREEDY");
		enumValue(ZERO_OR_MORE_RELUCTANT_ord, "ZERO_OR_MORE_RELUCTANT");
		enumValue(ONE_OR_MORE_RELUCTANT_ord, "ONE_OR_MORE_RELUCTANT");
		enumValue(ZERO_OR_MORE_POSSESSIVE_ord, "ZERO_OR_MORE_POSSESSIVE");
		enumValue(ONE_OR_MORE_POSSESSIVE_ord, "ONE_OR_MORE_POSSESSIVE");
	}

	private static final long serialVersionUID = 1;

	protected void enumValue(int ordinal, String name) {
		if (valueOf(name) == null)
			putEnumValue(new Value(ordinal, name));
	}

	protected void enumValue(int ordinal, String name, String implName) {
		if (valueOf(name) == null)
			putEnumValue(new Value(ordinal, name, implName));
	}

	public static class Value extends EnumValueImpl {
		private static final long serialVersionUID = 1;

		public Value() {
			super();
		}

		public Value(int ordinal, String name) {
			super(ordinal, name);
		}

		public Value(int ordinal, String name, String implName) {
			super(ordinal, name, implName);
		}
		
		public final boolean isOptional() {
			switch (getOrdinal()) {
			case OPTIONAL_ord:
			case ZERO_OR_MORE_RELUCTANT_ord:
			case ZERO_OR_MORE_GREEDY_ord:
			case ZERO_OR_MORE_POSSESSIVE_ord:
				return true;
			default:
				return false;
			}
		}
		public final Value toOptional() {
			switch (getOrdinal()) {
			case MANDATORY_ord:
				return OPTIONAL;
			case ONE_OR_MORE_RELUCTANT_ord:
				return ZERO_OR_MORE_RELUCTANT;
			case ONE_OR_MORE_GREEDY_ord:
				return ZERO_OR_MORE_GREEDY;
			case ONE_OR_MORE_POSSESSIVE_ord:
				return ZERO_OR_MORE_POSSESSIVE;
			default:
				return this;
			}
		}
		public final boolean isMandatory() {
			switch (getOrdinal()) {
			case MANDATORY_ord:
			case ONE_OR_MORE_RELUCTANT_ord:
			case ONE_OR_MORE_GREEDY_ord:
			case ONE_OR_MORE_POSSESSIVE_ord:
				return true;
			default:
				return false;
			}
		}
		public final Value toMandatory() {
			switch (getOrdinal()) {
			case OPTIONAL_ord:
				return MANDATORY;
			case ZERO_OR_MORE_RELUCTANT_ord:
				return ONE_OR_MORE_RELUCTANT;
			case ZERO_OR_MORE_GREEDY_ord:
				return ONE_OR_MORE_GREEDY;
			case ZERO_OR_MORE_POSSESSIVE_ord:
				return ONE_OR_MORE_POSSESSIVE;
			default:
				return this;
			}
		}
		public final boolean isZeroOrMore() {
			switch (getOrdinal()) {
			case ZERO_OR_MORE_RELUCTANT_ord:
			case ZERO_OR_MORE_GREEDY_ord:
			case ZERO_OR_MORE_POSSESSIVE_ord:
				return true;
			default:
				return false;
			}
		}
		public final boolean isOneOrMore() {
			switch (getOrdinal()) {
			case ONE_OR_MORE_RELUCTANT_ord:
			case ONE_OR_MORE_GREEDY_ord:
			case ONE_OR_MORE_POSSESSIVE_ord:
				return true;
			default:
				return false;
			}
		}
		public final boolean isComposite() {
			switch (getOrdinal()) {
			case ZERO_OR_MORE_RELUCTANT_ord:
			case ZERO_OR_MORE_GREEDY_ord:
			case ZERO_OR_MORE_POSSESSIVE_ord:
			case ONE_OR_MORE_RELUCTANT_ord:
			case ONE_OR_MORE_GREEDY_ord:
			case ONE_OR_MORE_POSSESSIVE_ord:
				return true;
			default:
				return false;
			}
		}
		public final boolean isReluctant() {
			switch (getOrdinal()) {
			case ZERO_OR_MORE_RELUCTANT_ord:
			case ONE_OR_MORE_RELUCTANT_ord:
				return true;
			default:
				return false;
			}
		}
		public final boolean isGreedy() {
			switch (getOrdinal()) {
			case ZERO_OR_MORE_GREEDY_ord:
			case ONE_OR_MORE_GREEDY_ord:
				return true;
			default:
				return false;
			}
		}
		public final boolean isPossessive() {
			switch (getOrdinal()) {
			case ZERO_OR_MORE_POSSESSIVE_ord:
			case ONE_OR_MORE_POSSESSIVE_ord:
				return true;
			default:
				return false;
			}
		}
	}
}
