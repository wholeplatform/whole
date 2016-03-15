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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.visitors.GenericTemplateInterpreterVisitor;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class InterpreterOperation extends AbstractOperation {
	public static final String ID = "interpreter";
	
	private Reader reader;
	private Writer writer;
    private PrintWriter printWriter;

	public static IBindingScope interpret(IEntity program) {
		return interpret(program, BindingManagerFactory.instance.createArguments());
	}
	public static IBindingScope interpret(IEntity program, IBindingManager args) {
		return interpret(program, args, false);
	}
	public static IBindingScope interpret(IEntity program, IBindingManager args, boolean resultsInArgs) {
		InterpreterOperation op = new InterpreterOperation(args, resultsInArgs);
	    op.stagedVisit(program, 0);
	    return op.getResultsScope();
	}
	public static IBindingScope interpret(IEntity program, IBindingManager args, int relativeStage) {
		InterpreterOperation op = new InterpreterOperation(args, null);
	    op.stagedVisit(program, relativeStage);
	    return op.getResultsScope();
	}

	public static IBindingScope interpret(IEntity program, IBindingManager args, InputStream in, OutputStream out) {
		return interpret(program, args, new InputStreamReader(in), new OutputStreamWriter(out));
	}
	public static IBindingScope interpret(IEntity program, IBindingManager args, Reader in, Writer out) {
	    final Set<String> newIONames = new HashSet<String>();

	    if (!args.wIsSet("reader"))
	    	newIONames.add("reader");
	    if (!args.wIsSet("writer"))
	    	newIONames.add("writer");
	    if (!args.wIsSet("printWriter"))
	    	newIONames.add("printWriter");

		final InterpreterOperation op = new InterpreterOperation(args, null);

		if (in != null)
			args.wDefValue("reader", op.reader = in);
		else if (!args.wIsSet("reader")) {
			args.wDefValue("reader", (Object) null);
			args.wGet("reader").wAddRequestEventHandler(new IdentityRequestEventHandler() {
				public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
					return op.getReader();
				}
			});
		} else
			op.reader = (Reader) args.wGetValue("reader");

		if (out != null) {
			args.wDefValue("writer", op.writer = out);
			if (out instanceof PrintWriter)
				args.wDefValue("printWriter", op.printWriter = (PrintWriter) out);
		} else {
			 if (args.wIsSet("printWriter"))
				 op.writer = op.printWriter = (PrintWriter) args.wGetValue("printWriter");
			 if (args.wIsSet("writer"))
				 op.writer = (Writer) args.wGetValue("writer");
			 else {
				 args.wDefValue("writer", (Object) null);
				 args.wGet("writer").wAddRequestEventHandler(new IdentityRequestEventHandler() {
					 public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
						 return op.getWriter();
					 }
				 });
			 }
		}
		if (!args.wIsSet("printWriter")) {
			args.wDefValue("printWriter", (Object) null);
			args.wGet("printWriter").wAddRequestEventHandler(new IdentityRequestEventHandler() {
				public Object notifyRequested(IEntity source, FeatureDescriptor feature, Object value) {
					return op.getPrintWriter();
				}
			});
		}

	    op.stagedVisit(program);

	    for (String name : newIONames)
	    	args.wUnset(name);

	    op.flushPrintWriter();
	    return op.getResultsScope();
	}

	protected InterpreterOperation(IBindingManager args, boolean resultsInArgs) {
		super(ID, args, resultsInArgs);
	}
	protected InterpreterOperation(IBindingManager args, IBindingScope resultsScope) {
		super(ID, args, null);
	}

	protected IVisitor createDefaultVisitor(IEntity entity, int normalizedStage) {
		if (normalizedStage > 0)
			return new GenericTemplateInterpreterVisitor();
		else
			return super.createDefaultVisitor(entity, normalizedStage);
	}

	public Reader getReader() {
		if (reader == null)
			reader = new InputStreamReader(System.in);
		return reader;
	}
	public Writer getWriter() {
		if (writer == null)
			writer = new OutputStreamWriter(System.out);
		return writer;
	}
	public PrintWriter getPrintWriter() {
		if (printWriter == null)
			printWriter = new PrintWriter(getWriter());
		return printWriter;
	}
	public void flushPrintWriter() {
		if (printWriter != null)
			printWriter.flush();
	}
}
