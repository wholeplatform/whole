package org.whole.lang.text.builders;

import org.whole.lang.builders.IBuilder;

/** 
 * @generator Whole
 */
public interface ITextBuilder extends IBuilder {
	public void visit();

	public void Document();

	public void Document_();

	public void Document_(int initialCapacity);

	public void _Document();

	public void Indent();

	public void Indent(int value);

	public void RowSeparator();

	public void RowSeparator(String value);

	public void TextSeparator();

	public void TextSeparator(String value);

	public void Row();

	public void Row_();

	public void Row_(int initialCapacity);

	public void _Row();

	public void Text();

	public void Text(String value);
}
