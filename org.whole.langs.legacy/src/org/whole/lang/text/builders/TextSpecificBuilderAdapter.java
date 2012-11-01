package org.whole.lang.text.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TextSpecificBuilderAdapter extends GenericBuilderContext implements
		ITextBuilder {
	public TextSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public TextSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void visit() {
	}

	public void Document() {
		wEntity(TextEntityDescriptorEnum.Document);
	}

	public void Document_() {
		wEntity_(TextEntityDescriptorEnum.Document);
	}

	public void Document_(int initialCapacity) {
		wEntity_(TextEntityDescriptorEnum.Document, initialCapacity);
	}

	public void _Document() {
		_wEntity(TextEntityDescriptorEnum.Document);
	}

	public void Indent() {
		wEntity(TextEntityDescriptorEnum.Indent);
	}

	public void Indent(int value) {
		wEntity(TextEntityDescriptorEnum.Indent, value);
	}

	public void RowSeparator() {
		wEntity(TextEntityDescriptorEnum.RowSeparator);
	}

	public void RowSeparator(String value) {
		wEntity(TextEntityDescriptorEnum.RowSeparator, value);
	}

	public void TextSeparator() {
		wEntity(TextEntityDescriptorEnum.TextSeparator);
	}

	public void TextSeparator(String value) {
		wEntity(TextEntityDescriptorEnum.TextSeparator, value);
	}

	public void Row() {
		wEntity(TextEntityDescriptorEnum.Row);
	}

	public void Row_() {
		wEntity_(TextEntityDescriptorEnum.Row);
	}

	public void Row_(int initialCapacity) {
		wEntity_(TextEntityDescriptorEnum.Row, initialCapacity);
	}

	public void _Row() {
		_wEntity(TextEntityDescriptorEnum.Row);
	}

	public void Text() {
		wEntity(TextEntityDescriptorEnum.Text);
	}

	public void Text(String value) {
		wEntity(TextEntityDescriptorEnum.Text, value);
	}
}
