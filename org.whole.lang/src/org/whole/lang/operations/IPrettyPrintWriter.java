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

import java.io.Writer;

/**
 * @author Riccardo Solmi
 */
public interface IPrettyPrintWriter extends Appendable {
	public Writer asWriter();

	public boolean isInlined();
	public boolean setInlined(boolean inlined);

	public void addLinePrefix(String prefix);
	public void removeLinePrefix(String prefix);

	public int getIndentSize();
	public int setIndentSize(int indentSize);
	public void setRelativeIndentation(int delta);

	public void print(boolean b);
	public void print(byte b);
	public void print(char c);
	public void print(double d);
	public void print(float f);
	public void print(int i);
	public void print(long l);
	public void print(short s);
	public void print(String s);
	public void print(Object o);

	public void ensureNewLine();

	public void println();
	public void println(String s);

	public void printRaw(String s);
	public void printlnRaw(String s);

	public boolean isMultiline(CharSequence s);
}
