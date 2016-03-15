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
package org.whole.lang.xml.builders;

import java.io.PrintWriter;
import java.util.Stack;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrintWriter;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class XmlPrettyPrinterBuilder extends GenericIdentityBuilder implements IXmlBuilder {
	private IPrettyPrintWriter prettyPrintWriter;

	private Stack<Integer> childrenCountStack;
	private Stack<String> eventStack;
	private Stack<String> tagNameStack;
	private StringBuilder tagNameBuilder;
	private boolean tagNameBuilderEnable;

	public XmlPrettyPrinterBuilder(PrintWriter out) {
		this(new PrettyPrintWriter(out));
	}
	public XmlPrettyPrinterBuilder(IPrettyPrintWriter out) {
		prettyPrintWriter = out;
		childrenCountStack = new Stack<Integer>();
		childrenCountStack.push(-1);
		eventStack = new Stack<String>();
		tagNameStack = new Stack<String>();
		tagNameBuilder = new StringBuilder();
		tagNameBuilderEnable = false;
	}

	protected IPrettyPrintWriter prettyPrintWriter() {
		return prettyPrintWriter;
	}

	private void  incrementChildrenCount() {
		int count = childrenCountStack.pop();
		childrenCountStack.push(count+1);
	}
	private void  pushChildrenCount(int count) {
		childrenCountStack.push(count);
	}
	private int popChildrenCount() {
		return childrenCountStack.pop();
	}
	private int peekChildrenCount() {
		return childrenCountStack.peek();
	}

	private void schedulePrintAfterEvent(String event, String data) {
		eventStack.push(data);
		eventStack.push(event);
	}
	private void printAfterEvent(String event) {
		if (!eventStack.isEmpty() && event.equals(eventStack.peek())) {
			eventStack.pop();
			print(eventStack.pop());
		}
	}

	private void scheduleTagNameBuilder() {
		tagNameBuilderEnable = true;
	}
	private void appendTagNameBuilder(String data) {
		if (tagNameBuilderEnable)
			tagNameBuilder.append(data);
	}
	private void completeTagName(String data) {
		if (tagNameBuilderEnable) {
			tagNameBuilder.append(data);
			tagNameStack.push(tagNameBuilder.toString());
			tagNameBuilder.setLength(0);
			tagNameBuilderEnable = false;
		}
	}
	private String popTagName() {
		return tagNameStack.pop();
	}

	private boolean lastPrintedCharData = false;
	public void print(String data) {
		prettyPrintWriter().printRaw(data);
		lastPrintedCharData = false;
	}
	private void printCharData(String data) {
		prettyPrintWriter().printRaw(data);
		lastPrintedCharData = true;
	}

	public void Document_() {
	}
	public void _Document() {
		prettyPrintWriter().println();
	}
	public void Document() {
	}
	public void Prolog_() {
	}
	public void _Prolog() {
	}
	public void Prolog() {
	}

	public void XMLDecl_() {
		print("<?xml");
	}

	public void _XMLDecl() {
		print("?>");
		prettyPrintWriter().println();
	}

	public void XMLDecl() {
	}

	public void Version(String value) {
		print(" version=\"");
		print(value);
		print("\"");
	}

	public void Version() {
	}

	public void Encoding(String value) {
		print(" encoding=\"");
		print(value);
		print("\"");
	}

	public void Encoding() {
	}

	public void DocTypeDecl_() {
		print("<!DOCTYPE ");
		schedulePrintAfterEvent("Name", " ");
	}

	public void _DocTypeDecl() {
		print(">");
		prettyPrintWriter().println();
	}

	public void DocTypeDecl() {
	}

	public void SystemId_() {
		print("SYSTEM \"");
	}

	public void _SystemId() {
		print("\"");
	}

	public void SystemId() {
	}

	public void SystemLiteral() {
	}

	public void SystemLiteral(String value) {
		print(value);
	}

	public void PublicId_() {
		print("PUBLIC \"");
		schedulePrintAfterEvent("PubidLiteral", "\" \"");
	}

	public void _PublicId() {
		print("\"");
	}

	public void PublicId() {
	}

	public void PubidLiteral(String value) {
		print(value);
		printAfterEvent("PubidLiteral");
	}
	
	public void PubidLiteral() {
		PubidLiteral("");
	}

	public void Misc_() {
	}
	public void Misc_(int initialCapacity) {
	}
	public void _Misc() {
	}
	public void Misc() {
	}

	public void Comment_() {
		if (peekChildrenCount() == 0) {
			print(">");
			prettyPrintWriter().println();
		} else if (!lastPrintedCharData)
			prettyPrintWriter().println();

		incrementChildrenCount();
		print("<!--");
	}

	public void _Comment() {
		print("-->");
	}

	public void Comment() {
	}

	public void CommentText() {
	}

	public void CommentText(String value) {
		print(StringUtils.toXMLCommentText(value));
	}

	public void Instruction(String value) {
		print(value);
	}

	public void Instruction() {
	}

	public void PI_() {
		if (peekChildrenCount() == 0) {
			print(">");
			prettyPrintWriter().println();
		} if (!lastPrintedCharData)
			prettyPrintWriter().println();

		incrementChildrenCount();
		print("<?");
		schedulePrintAfterEvent("Name", " ");
	}

	public void _PI() {
		print("?>");
		prettyPrintWriter().println();
	}

	public void PI() {
	}

	public void Attributes_() {
	}
	public void Attributes_(int initialCapacity) {
	}
	public void _Attributes() {
	}
	public void Attributes() {
	}
	public void Content_(int initialCapacity) {
	}
	public void Content_() {
	}
	public void _Content() {
	}
	public void Content() {
	}

	public void Element_() {
		if (peekChildrenCount() == 0) {
			print(">");
			prettyPrintWriter().println();
		} else if (peekChildrenCount() > 0 && !lastPrintedCharData)
			prettyPrintWriter().println();

		incrementChildrenCount();
		pushChildrenCount(0);
		scheduleTagNameBuilder();

		print("<");
		prettyPrintWriter().setRelativeIndentation(+1);
	}

	public void _Element() {
		prettyPrintWriter().setRelativeIndentation(-1);
		int childrenAdded = popChildrenCount();
		String tagName = popTagName();

		if (childrenAdded == 0)
			print("/>");
		else {
			if (!lastPrintedCharData)
				prettyPrintWriter().println();

			print("</");
			print(tagName);
			print(">");
		}
	}

	public void Element() {
	}

	public void CharData(String value) {
		if (peekChildrenCount() == 0)
			print(">");

		printCharData(StringUtils.toXMLCharData(value));
		incrementChildrenCount();
	}
	public void CharData() {
	}

	public void CDataSectData(String value) {
		print(StringUtils.toXMLCData(value));
	}
	public void CDataSectData() {
	}

	public void CDataSect_() {
		if (peekChildrenCount() == 0) {
			print(">");
			prettyPrintWriter().println();
		} else if (!lastPrintedCharData)
			prettyPrintWriter().println();

		incrementChildrenCount();
		print("<![CDATA[");
	}

	public void CDataSect_(int initialCapacity) {
		CDataSect_();
	}

	public void _CDataSect() {
		print("]]>");
		prettyPrintWriter().println();
	}
	public void CDataSect() {
	}

	public void Value(String value) {
		print(StringUtils.toXMLString(value));
	}

	public void Value() {
	}

	public void Attribute_() {
		print(" ");
		schedulePrintAfterEvent("Name", "=\"");
	}

	public void _Attribute() {
		print("\"");
	}

	public void Attribute() {
	}

	public void Name(String value) {
		completeTagName(value);
		print(value);
		printAfterEvent("Name");
	}
	public void Name() {
		Name("");
	}

	public void NameSpace(String value) {
		if (value.length() > 0) {
			appendTagNameBuilder(value);
			appendTagNameBuilder(":");
			print(value);
			print(":");   			
		}
	}
	public void NameSpace() {
	}

	public void QualifiedName_() {
	}

	public void _QualifiedName() {
	}

	public void QualifiedName() {
	}

	public void Standalone(boolean value) {
		print(" standalone=\"" + (value ? "yes" : "no") + "\"");
	}
	public void Standalone() {
	}

	public void attributes() {
	}

	public void content() {
	}

	public void docTypeDecl() {
	}

	public void element() {
	}

	public void encoding() {
	}

	public void externalId() {
	}

	public void instruction() {
	}

	public void misc() {
	}

	public void name() {
	}

	public void nameSpace() {
	}

	public void prolog() {
	}

	public void pubidLiteral() {
	}

	public void standalone() {
	}

	public void systemLiteral() {
	}

	public void tag() {
	}

	public void text() {
	}

	public void value() {
	}

	public void version() {
	}

	public void visit() {
	}

	public void xmlDecl() {
	}
}
