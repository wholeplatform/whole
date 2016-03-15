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
package org.whole.lang.environment.visitors;

import org.whole.lang.environment.model.Binding;
import org.whole.lang.environment.model.Bindings;
import org.whole.lang.environment.model.BooleanData;
import org.whole.lang.environment.model.ByteData;
import org.whole.lang.environment.model.CharData;
import org.whole.lang.environment.model.ContainmentTuple;
import org.whole.lang.environment.model.DateData;
import org.whole.lang.environment.model.DoubleData;
import org.whole.lang.environment.model.FloatData;
import org.whole.lang.environment.model.Id;
import org.whole.lang.environment.model.IntData;
import org.whole.lang.environment.model.LongData;
import org.whole.lang.environment.model.Name;
import org.whole.lang.environment.model.ObjectData;
import org.whole.lang.environment.model.ShortData;
import org.whole.lang.environment.model.StringData;
import org.whole.lang.environment.model.Tuple;
import org.whole.lang.environment.model.Value;
import org.whole.lang.environment.model.Void;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class EnvironmentPrettyPrinterVisitor extends EnvironmentIdentityDefaultVisitor {
	protected final IPrettyPrintWriter out;

	public EnvironmentPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

    @Override
	public void visit(BooleanData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(ByteData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(CharData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(DoubleData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(FloatData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(IntData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(LongData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(ShortData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(StringData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(DateData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(ObjectData entity) {
    	out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

    @Override
	public void visit(Tuple entity) {
    	out.printRaw("(");
		for (int i=0, size=entity.size(); i<size; i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
		out.printRaw(")");
	}

    @Override
	public void visit(ContainmentTuple entity) {
    	out.printRaw("(");
		for (int i=0, size=entity.size(); i<size; i++) {
			if (i>0)
				out.printRaw(", ");
			entity.get(i).accept(this);
		}
		out.printRaw(")");
	}

    @Override
	public void visit(Void entity) {
    	out.printRaw("void");
	}

    @Override
    public void visit(Bindings entity) {
		out.printlnRaw("Bindings {");
		out.setRelativeIndentation(+1);

		for (int i=0, size=entity.size(); i<size; i++) {
			if (i>0)
				out.printlnRaw(", ");
			entity.get(i).accept(this);
		}

		out.setRelativeIndentation(-1);
		out.printlnRaw("}");
    }

    @Override
    public void visit(Binding entity) {
    	entity.getName().accept(this);
    	out.printRaw(" = ");
    	entity.getValue().accept(this);
    }

    @Override
    public void visit(Id entity) {
    	out.printRaw(entity.getValue());
    }

    @Override
    public void visit(Name entity) {
    	out.printRaw(entity.getValue());
    }

    @Override
    public void visit(Value entity) {
    	stagedVisit(entity.getValue());
    }
}
