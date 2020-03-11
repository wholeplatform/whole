/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.swift.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class NameValueEnum extends EnumType<NameValueEnum.Value> {
    public static final int _class_ord = 0;
    public static final int convenience_ord = 1;
    public static final int dynamic_ord = 2;
    public static final int _final_ord = 3;
    public static final int infix_ord = 4;
    public static final int lazy_ord = 5;
    public static final int optional_ord = 6;
    public static final int override_ord = 7;
    public static final int postfix_ord = 8;
    public static final int prefix_ord = 9;
    public static final int required_ord = 10;
    public static final int _static_ord = 11;
    public static final int unowned_ord = 12;
    public static final int weak_ord = 13;
    public static final int _private_ord = 14;
    public static final int fileprivate_ord = 15;
    public static final int internal_ord = 16;
    public static final int _public_ord = 17;
    public static final int open_ord = 18;
    public static final int mutating_ord = 19;
    public static final int nonmutating_ord = 20;
    public static final int indirect_ord = 21;
    public static final int __consuming_ord = 22;
    public static final NameValueEnum instance = new NameValueEnum();
    public static final Value _class = instance.valueOf(_class_ord);
    public static final Value convenience = instance.valueOf(convenience_ord);
    public static final Value dynamic = instance.valueOf(dynamic_ord);
    public static final Value _final = instance.valueOf(_final_ord);
    public static final Value infix = instance.valueOf(infix_ord);
    public static final Value lazy = instance.valueOf(lazy_ord);
    public static final Value optional = instance.valueOf(optional_ord);
    public static final Value override = instance.valueOf(override_ord);
    public static final Value postfix = instance.valueOf(postfix_ord);
    public static final Value prefix = instance.valueOf(prefix_ord);
    public static final Value required = instance.valueOf(required_ord);
    public static final Value _static = instance.valueOf(_static_ord);
    public static final Value unowned = instance.valueOf(unowned_ord);
    public static final Value weak = instance.valueOf(weak_ord);
    public static final Value _private = instance.valueOf(_private_ord);
    public static final Value fileprivate = instance.valueOf(fileprivate_ord);
    public static final Value internal = instance.valueOf(internal_ord);
    public static final Value _public = instance.valueOf(_public_ord);
    public static final Value open = instance.valueOf(open_ord);
    public static final Value mutating = instance.valueOf(mutating_ord);
    public static final Value nonmutating = instance.valueOf(nonmutating_ord);
    public static final Value indirect = instance.valueOf(indirect_ord);
    public static final Value __consuming = instance.valueOf(__consuming_ord);

    private NameValueEnum() {
        enumValue(_class_ord, "class", "_class");
        enumValue(convenience_ord, "convenience");
        enumValue(dynamic_ord, "dynamic");
        enumValue(_final_ord, "final", "_final");
        enumValue(infix_ord, "infix");
        enumValue(lazy_ord, "lazy");
        enumValue(optional_ord, "optional");
        enumValue(override_ord, "override");
        enumValue(postfix_ord, "postfix");
        enumValue(prefix_ord, "prefix");
        enumValue(required_ord, "required");
        enumValue(_static_ord, "static", "_static");
        enumValue(unowned_ord, "unowned");
        enumValue(weak_ord, "weak");
        enumValue(_private_ord, "private", "_private");
        enumValue(fileprivate_ord, "fileprivate");
        enumValue(internal_ord, "internal");
        enumValue(_public_ord, "public", "_public");
        enumValue(open_ord, "open");
        enumValue(mutating_ord, "mutating");
        enumValue(nonmutating_ord, "nonmutating");
        enumValue(indirect_ord, "indirect");
        enumValue(__consuming_ord, "__consuming");
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
    }
}
