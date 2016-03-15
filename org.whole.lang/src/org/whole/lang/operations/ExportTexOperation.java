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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;



/**
 * @author Riccardo Solmi
 */
public class ExportTexOperation extends AbstractOperation {
	public static final String ID ="toTeX";

	private String indentationString = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	protected int indentation = 0;
	protected int indentationSize = 2;
	public final StringBuffer out = new StringBuffer(16384);

	public static String export(IEntity entity, boolean withProlog) {
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		ExportTexOperation op = new ExportTexOperation(args);
		if (withProlog)
			op.printProlog();

		op.printBeginEnvironment();
		op.stagedVisit(entity);
		op.printEndEnvironment();

		return op.out.toString();
	}

	protected ExportTexOperation(IBindingManager args) {
		super(ID, args, false);
	}

	public final void indent() {
		indentation++;
	}
	public final void unindent() {
		indentation--;
	}
	public final void setIndentation(int indentation) {
		this.indentation = indentation;
	}
	public final void printIndentation() {
		if (indentation > 0) {
			if (indentation * indentationSize < indentationString.length())
				print(indentationString.substring(0, indentation * indentationSize));
			else
				print(indentationString);
		}
	}

	public final void print(String text) {
		out.append(text);
	}
	public final void println() {
		out.append('\n');
	}

	public void printProlog() {
		out.append("\\usepackage{color}\n");
		println();
		out.append("%Whole2TeX style definitions\n");
		out.append("\\newenvironment{whole}[0]{\n");
		out.append("\\parindent=0em\n");
		out.append("\\setbox0=\\vbox\\bgroup\n");
		out.append("\\begin{minipage}{1\\linewidth}\n");
		out.append("\\ttfamily\n");
		out.append("}{\n");
		out.append("\\end{minipage}\n");
		out.append("\\egroup\\fboxsep=1em\\fbox{\\box0}\n");
		out.append("}\n");
		println();
		out.append("\\newenvironment{wholeTemplate}{\n");
		out.append("\\parindent=0em\n");
		out.append("\\ttfamily\\wstylef\n");
		out.append("\\begin{tabular}{|l|}\n");
		out.append("	\\hline\n");
		out.append("}{\n");
		out.append("	\\hline\n");
		out.append("\\end{tabular}\n");
		out.append("}\n");
		println();
		out.append("\\newcommand{\\wstyler}{{\\color[rgb]{.000,.000,.000}$\\triangle$}} %Resolver\n");
		out.append("\\newcommand{\\wstyleb}{\\color[rgb]{1.00,1.00,1.00}} %Background\n");
		out.append("\\newcommand{\\wstylef}{\\color[rgb]{.000,.000,.000}} %Foreground\n");
		out.append("\\newcommand{\\wstylek}{\\color[rgb]{.498,.000,.333}} %Keywords\n");
		out.append("\\newcommand{\\wstylei}{\\color[rgb]{.000,.000,.000}} %Identifiers\n");
		out.append("\\newcommand{\\wstylep}{\\color[rgb]{.000,.000,.000}} %Parenthesis\n");
		out.append("\\newcommand{\\wstyled}{\\color[rgb]{.000,.000,.000}} %Delimiters\n");
		out.append("\\newcommand{\\wstylel}{\\color[rgb]{.600,.000,.000}} %Literals\n");
	}
	
	public void printBeginEnvironment() {
		println();
		out.append("\\begin{whole}\n");
	}
	
	public void printEndEnvironment() {
		println();
		out.append("\\end{whole}\n");
	}
}
