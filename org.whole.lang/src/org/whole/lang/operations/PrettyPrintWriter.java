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
import java.io.PrintWriter;
import java.io.Writer;

import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class PrettyPrintWriter implements IPrettyPrintWriter {
	private final PrintWriter printWriter;
	protected boolean isStartOfLine = true;

	public PrettyPrintWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}

	protected boolean inlined = false;
	public boolean isInlined() {
		return inlined;
	}
	public boolean setInlined(boolean inlined) {
		boolean result = this.inlined;
		this.inlined = inlined;
		return result;
	}

	protected String prefixString = "";
	protected String indentationString = "                                        ";
	protected int indentation = 0;
	protected int indentSize = 4;

	public void addLinePrefix(String prefix) {
		prefixString = indentationString()+prefix;
		indentation = 0;
	}
	public void removeLinePrefix(String prefix) {
		prefixString = prefixString.substring(0, prefixString.lastIndexOf(prefix));
		indentation = 0;
	}

	public int getIndentSize() {
		return indentSize;
	}
	public int setIndentSize(int indentSize) {
		int result = this.indentSize;
		this.indentSize = indentSize;
		return result;
	}
	public void setRelativeIndentation(int delta) {
		indentation += delta;
	}

	protected String indentationString() {
		if (indentation > 0) {
			if (indentation * indentSize < indentationString.length())
				return prefixString + indentationString.substring(0, indentation * indentSize);
			else
				return prefixString + indentationString;
		} else
			//FIXME workaround
			return prefixString.substring(0, Math.max(0, prefixString.length() - -indentation * indentSize));
	}
	protected void ensureLinePrefix() {
		if (isStartOfLine) {
			isStartOfLine = false;

			printWriter.print(StringUtils.stripTrailing(prefixString));
		}
	}
	protected void ensureIndentation() {
		if (isStartOfLine) {
			isStartOfLine = false;

			printWriter.print(indentationString());
		}
	}

	public void print(boolean b) {
		ensureIndentation();
		printWriter.print(b);
	}
	public void print(byte b) {
		ensureIndentation();
		printWriter.print(b);
	}
	public void print(char c) {
		if (StringUtils.isNewLineChar(c))
			println();
		else {
			ensureIndentation();
			printWriter.print(c);
		}
	}
	public void print(double d) {
		ensureIndentation();
		printWriter.print(d);
	}
	public void print(float f) {
		ensureIndentation();
		printWriter.print(f);
	}
	public void print(int i) {
		ensureIndentation();
		printWriter.print(i);
	}
	public void print(long l) {
		ensureIndentation();
		printWriter.print(l);
	}
	public void print(short s) {
		ensureIndentation();
		printWriter.print(s);
	}
	public void print(String s) {
		if (isMultiline(s)) {
			String[] split = StringUtils.EOL_PATTERN.split(s, -1);
			int lastIndex = split.length-1;
			if (split[lastIndex].length() == 0)
				for (int i=0; i<lastIndex; i++)
					printlnRaw(split[i]);
			else
				for (int i=0; i<=lastIndex; i++) {
					printRaw(split[i]);
					if (i<lastIndex)
						println();
				}
		} else
			printRaw(s);
	}
	public void print(Object o) {
		print(String.valueOf(o));
	}

	public void ensureNewLine() {
		if (!isStartOfLine)
			println();
	}

	public void println() {
		ensureLinePrefix();
	    if (!isInlined()) {
	    	printWriter.println();
	    	isStartOfLine = true;
	    }
	}
	public void println(String s) {
		print(s);
		println();
	}

	public void printRaw(String s) {
		ensureIndentation();
		printWriter.print(s);
	}
	public void printlnRaw(String s) {
		printRaw(s);
		println();
	}

	public boolean isMultiline(CharSequence s) {
		return StringUtils.EOL_PATTERN.matcher(s).find();
	}

	public Appendable append(CharSequence csq) throws IOException {
		if (isMultiline(csq)) {
			String[] split = StringUtils.EOL_PATTERN.split(csq, -1);
			int lastIndex = split.length-1;
			if (split[lastIndex].length() == 0)
				for (int i=0; i<lastIndex; i++) {
					ensureIndentation();
					printWriter.append(split[i]);
					println();
				}
			else
				for (int i=0; i<=lastIndex; i++) {
					ensureIndentation();
					printWriter.append(split[i]);
					if (i<lastIndex)
						println();
				}
		} else {
			ensureIndentation();
			printWriter.append(csq);
		}

		return this;
	}
	public Appendable append(char c) throws IOException {
		if (StringUtils.isNewLineChar(c))
			println();
		else {
			ensureIndentation();
			printWriter.append(c);
		}
		return this;
	}
	public Appendable append(CharSequence csq, int start, int end) throws IOException {
		return append(csq.subSequence(start, end));
	}

	public Writer asWriter() { //TODO ? add boolean raw
		return new WriterAdapter(); // raw ? printWriter : new WriterAdapter();
	}

	public class WriterAdapter extends Writer {
		@Override
	    public void write(char[] cbuf, int off, int len) throws IOException {
	         PrettyPrintWriter.this.append(String.valueOf(cbuf), off, off+len);
	    }
		@Override
	    public void write(int c) throws IOException {
			PrettyPrintWriter.this.append((char) c);
	    }
		@Override
	    public void write(String str) throws IOException {
			PrettyPrintWriter.this.append(str);
	    }
	    public void write(String str, int off, int len) throws IOException {
	    	PrettyPrintWriter.this.append(str, off, off+len);
	    }

		@Override
		public Writer append(char c) throws IOException {
			PrettyPrintWriter.this.append(c);
			return this;
		}
		@Override
		public Writer append(CharSequence csq) throws IOException {
			PrettyPrintWriter.this.append(csq);
			return this;
		}
		@Override
		public Writer append(CharSequence csq, int start, int end) throws IOException {
			PrettyPrintWriter.this.append(csq, start, end);
			return this;
		}

	    @Override
	    public void flush() throws IOException {
	    	PrettyPrintWriter.this.printWriter.flush();
	    }

	    @Override
	    public void close() throws IOException {
	    	PrettyPrintWriter.this.printWriter.close();
	    }
	}
}
