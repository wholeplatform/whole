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
package scheme.old;

import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

class SchemeBuiltins {

    private static class BuiltinValue extends SchemeValueImpl {
	public BuiltinValue() {
	    name = "?";
	}

	public BuiltinValue(String n) {
	    name = n;
	}

	public String getName() {
	    return name;
	}

	public String toString() {
	    return "(builtin " + getName() + ")";
	}
	
	protected void checkArgs(List args, int n) throws SchemeException {
	    if (args.size() != n)
		throw new SchemeException("wrong number of arguments for " + toString() + ": "
					  + Integer.toString(args.size()) + " instead of "
					  + Integer.toString(n));
	}

	private final String name;
    }
    
    private static class ConsBuiltin extends BuiltinValue {
	public ConsBuiltin() {
	    super("cons");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 2);
	    final SchemeValue a = (SchemeValue) args.get(0);
	    final SchemeValue b = (SchemeValue) args.get(1);
	    return SchemePairValueImpl.valueOf(a, b);
	}
    }

    private static class ListBuiltin extends BuiltinValue {
	public ListBuiltin() {
	    super("list");
	}

	public SchemeValue apply(List args) {
	    final ListIterator i = args.listIterator(args.size());
	    SchemeValue res = null;
	    while (i.hasPrevious()) {
		final SchemeValue value = (SchemeValue) i.previous();
		res = SchemePairValueImpl.valueOf(value, res);
	    }
	    return res;
	}
    }

    private static class CarBuiltin extends BuiltinValue {
	public CarBuiltin() {
	    super("car");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 1);
	    return ((SchemeValue) args.get(0)).asPair().car();
	}
    }


    private static class CdrBuiltin extends BuiltinValue {
	public CdrBuiltin() {
	    super("cdr");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 1);
	    return ((SchemeValue) args.get(0)).asPair().cdr();
	}
    }


    private static class NullPBuiltin extends BuiltinValue {
	public NullPBuiltin() {
	    super("null?");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 1);
	    return SchemeBoolValueImpl.valueOf(args.get(0) == null);
	}
    }

    private static class BoolPBuiltin extends BuiltinValue {
	public BoolPBuiltin() {
	    super("bool?");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 1);
	    return SchemeBoolValueImpl.valueOf(((SchemeValue) args.get(0)).isBool());
	}
    }


    private static class IntPBuiltin extends BuiltinValue {
	public IntPBuiltin() {
	    super("int?");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 1);
	    return SchemeBoolValueImpl.valueOf(((SchemeValue) args.get(0)).isInt());
	}
    }

    private static class StringPBuiltin extends BuiltinValue {
	public StringPBuiltin() {
	    super("string?");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 1);
	    return SchemeBoolValueImpl.valueOf(((SchemeValue) args.get(0)).isString());
	}
    }

    private static class PairPBuiltin extends BuiltinValue {
	public PairPBuiltin() {
	    super("pair?");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 1);
	    return SchemeBoolValueImpl.valueOf(((SchemeValue) args.get(0)).isPair());
	}
    }

    private static class EqvPBuiltin extends BuiltinValue {
	public EqvPBuiltin() {
	    super("eqv?");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 2);
	    final SchemeValue v1 = (SchemeValue) args.get(0);
	    final SchemeValue v2 = (SchemeValue) args.get(1);
	    return SchemeBoolValueImpl.valueOf((v1 == v2)
					       || (v1.isBool() && v2.isBool() && v1.asBool() == v2.asBool())
					       || (v1.isInt() && v2.isInt() && v1.asInt() == v2.asInt()));
	}
    }

    private static class StringEqPBuiltin extends BuiltinValue {
	public StringEqPBuiltin() {
	    super("string=?");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    checkArgs(args, 2);
	    final SchemeValue v1 = (SchemeValue) args.get(0);
	    final SchemeValue v2 = (SchemeValue) args.get(1);
	    return SchemeBoolValueImpl.valueOf(v1.isString() && v2.isString() && v1.asString().equals(v2.asString()));
	}
    }

    private static class PlusBuiltin extends BuiltinValue {
	public PlusBuiltin() {
	    super("+");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    int res = 0;
	    final Iterator i = args.iterator();
	    while (i.hasNext())
		res += ((SchemeValue) i.next()).asInt();
	    return SchemeIntValueImpl.valueOf(res);
	}
    }

    private static class TimesBuiltin extends BuiltinValue {
	public TimesBuiltin() {
	    super("*");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    int res = 1;
	    final Iterator i = args.iterator();
	    while (i.hasNext())
		res *= ((SchemeValue) i.next()).asInt();
	    return SchemeIntValueImpl.valueOf(res);
	}
    }

    private static class MinusBuiltin extends BuiltinValue {
	public MinusBuiltin() {
	    super("-");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    if (args.size() < 1)
		throw new SchemeException(toString() + " needs at least one argument");
	    else if (args.size() == 1)
		return SchemeIntValueImpl.valueOf(-((SchemeValue) args.get(0)).asInt());
	    else {
		final Iterator i = args.iterator();
		int res = ((SchemeValue) i.next()).asInt();
		while (i.hasNext())
		    res -= ((SchemeValue) i.next()).asInt();
		return SchemeIntValueImpl.valueOf(res);
	    }
	}
    }

    private static class DivideBuiltin extends BuiltinValue {
	public DivideBuiltin() {
	    super("/");
	}

	public SchemeValue apply(List args) throws SchemeException {
	    if (args.size() < 1)
		throw new SchemeException(toString() + " needs at least one argument");
	    else if (args.size() == 1)
		return SchemeIntValueImpl.valueOf(1 / ((SchemeValue) args.get(0)).asInt());
	    else {
		final Iterator i = args.iterator();
		int res = ((SchemeValue) i.next()).asInt();
		while (i.hasNext())
		    res /= ((SchemeValue) i.next()).asInt();
		return SchemeIntValueImpl.valueOf(res);
	    }
	}
    }

    private static class RelBuiltin extends BuiltinValue {
	public static final int EQ = 0;
	public static final int LT = 1;
	public static final int LE = 2;
	public static final int GE = 3;
	public static final int GT = 4;

	public RelBuiltin(int c) {
	    super((c == EQ) ? "="
		  : (c == LT) ? "<"
		  : (c == LE) ? "<="
		  : (c == GE) ? ">="
		  : (c == GT) ? ">"
		  : "???");
	    cmp = c;
	}

	private boolean compare(int a, int b) throws SchemeException {
	    switch (cmp) {
	    case EQ: return a == b;
	    case LT: return a < b;
	    case LE: return a <= b;
	    case GE: return a >= b;
	    case GT: return a > b;
	    default:
		throw new SchemeException(toString() + ": internal inconsitency");
	    }
	}

	public SchemeValue apply(List args) throws SchemeException {
	    boolean res = true;
	    boolean first = true;
	    int previous = 0;
	    final Iterator i = args.iterator();
	    while (res && i.hasNext()) {
		final int current = ((SchemeValue) i.next()).asInt();
		res = res && (first || compare(previous, current));
		previous = current;
		first = false;
	    }
	    return SchemeBoolValueImpl.valueOf(res);
	}

	private final int cmp;
    }

    private static void registerBuiltin(SchemeEnvironment env, BuiltinValue builtin) {
	env.add(builtin.getName(), builtin);
    }

    public static void registerBuiltins(SchemeEnvironment env) {
	registerBuiltin(env, new ConsBuiltin());
	registerBuiltin(env, new ListBuiltin());
	registerBuiltin(env, new CarBuiltin());
	registerBuiltin(env, new CdrBuiltin());
	registerBuiltin(env, new NullPBuiltin());
	registerBuiltin(env, new BoolPBuiltin());
	registerBuiltin(env, new IntPBuiltin());
	registerBuiltin(env, new StringPBuiltin());
	registerBuiltin(env, new PairPBuiltin());
	registerBuiltin(env, new EqvPBuiltin());
	registerBuiltin(env, new StringEqPBuiltin());
	registerBuiltin(env, new PlusBuiltin());
	registerBuiltin(env, new TimesBuiltin());
	registerBuiltin(env, new MinusBuiltin());
	registerBuiltin(env, new DivideBuiltin());
	registerBuiltin(env, new RelBuiltin(RelBuiltin.EQ));
	registerBuiltin(env, new RelBuiltin(RelBuiltin.LT));
	registerBuiltin(env, new RelBuiltin(RelBuiltin.LE));
	registerBuiltin(env, new RelBuiltin(RelBuiltin.GE));
	registerBuiltin(env, new RelBuiltin(RelBuiltin.GT));
    }
}
