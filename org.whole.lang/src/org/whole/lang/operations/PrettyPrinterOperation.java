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
package org.whole.lang.operations;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.visitors.EntityKindIdentityVisitor;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class PrettyPrinterOperation extends AbstractOperation {
	public static final String ID = "prettyPrint";
	private final PrintWriter printWriter;

	public static String toPrettyPrintString(IEntity program) {
		return toPrettyPrintString(program, 256);
	}
	public static String toPrettyPrintString(IEntity program, int initialBufferSize) {
		StringWriter writer = new StringWriter(initialBufferSize);
		prettyPrint(program, writer);
		return writer.toString();
	}
	public static void prettyPrint(IEntity program) {
		prettyPrint(program, System.out);
	}
	public static void prettyPrint(IEntity program, OutputStream os) {
		prettyPrint(program, new PrintWriter(os));
	}
	public static void prettyPrint(IEntity program, OutputStream os, String encoding) throws IOException {
		prettyPrint(program, new OutputStreamWriter(os, encoding));
	}
	public static void prettyPrint(IEntity program, Writer w) {
		prettyPrint(program, new PrintWriter(w));
	}
	public static void prettyPrint(IEntity program, PrintWriter printWriter) {
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDefValue("printWriter", printWriter);
		prettyPrint(program, args);
	}
	public static void prettyPrint(IEntity program, IBindingManager args) {
	    PrettyPrinterOperation op = new PrettyPrinterOperation(args);
		op.stagedVisit(program);
		op.printWriter.flush();
	}

    protected PrettyPrinterOperation(IBindingManager args) {
    	super(ID, args, null);

    	if (!args.wIsSet("printWriter"))
    		throw new IllegalArgumentException("printWriter is not defined");

    	printWriter = (PrintWriter) args.wGetValue("printWriter");
    }
    
    private IPrettyPrintWriter prettyPrintWriter;
	public IPrettyPrintWriter getPrettyPrintWriter() {
		if (prettyPrintWriter == null)
			prettyPrintWriter = new PrettyPrintWriter(printWriter);
		return prettyPrintWriter;
	}


    @Override
    protected IVisitor createDefaultVisitor(IEntity entity, int normalizedStage) {
		return new EntityKindIdentityVisitor() {
			public void visitSimpleEntity(IEntity entity) {
				if (entity.wIsAdapter())
					entity = entity.wGetAdaptee(false);
				getPrettyPrintWriter().printlnRaw(entity.wGetEntityDescriptor().getName() + " {");
				getPrettyPrintWriter().setRelativeIndentation(+1);
//				EnumSet<FeatureModifiers>[] featuresModifiers = entity.wGetEntityDescriptor().getFeatureModifiersArray();
				for (int i = 0; i < entity.wSize(); i++) {
					getPrettyPrintWriter().ensureNewLine();
					getPrettyPrintWriter().printRaw(entity.wGetFeatureDescriptor(i).getName() + ": ");
//					if (i>=featuresModifiers.length || !featuresModifiers[i].contains(FeatureModifiers.REFERENCE))
						stagedVisit(entity.wGet(i));
//					else
//						getPrettyPrintWriter().printlnRaw("(REFERENCE)");
				}
				getPrettyPrintWriter().setRelativeIndentation(-1);
				getPrettyPrintWriter().ensureNewLine();
				getPrettyPrintWriter().printlnRaw("}");
			}

			public void visitCompositeEntity(IEntity entity) {
			    getPrettyPrintWriter().printRaw(entity.wGetEntityDescriptor().getName() + " [");
				if (entity.wGetEntityDescriptor().getEntityFeatureDescriptor(0).isReference()) {
					getPrettyPrintWriter().printRaw("REFERENCES");
				} else if (entity.wSize() > 0) {
					getPrettyPrintWriter().println();
					getPrettyPrintWriter().setRelativeIndentation(+1);
					for (int i = 0; i < entity.wSize(); i++)
						stagedVisit(entity.wGet(i));
					getPrettyPrintWriter().setRelativeIndentation(-1);
				}
				getPrettyPrintWriter().ensureNewLine();
				getPrettyPrintWriter().printlnRaw("]");
			}

			public void visitDataEntity(IEntity entity) {
				getPrettyPrintWriter().printRaw(entity.wGetEntityDescriptor().getName());
				String value = DataTypeUtils.getAsPresentationString(entity);
				getPrettyPrintWriter().printRaw("(");
				if (getPrettyPrintWriter().isMultiline(value)) {
					getPrettyPrintWriter().println();
					getPrettyPrintWriter().setRelativeIndentation(+1);
					getPrettyPrintWriter().print(value);
					getPrettyPrintWriter().setRelativeIndentation(-1);					
					getPrettyPrintWriter().ensureNewLine();
				} else
					getPrettyPrintWriter().printRaw(value);
				getPrettyPrintWriter().printlnRaw(")");
			}
		};
	}
}
