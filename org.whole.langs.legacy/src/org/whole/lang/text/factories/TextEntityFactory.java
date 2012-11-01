package org.whole.lang.text.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.text.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TextEntityFactory extends GenericEntityFactory {
	public static final TextEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static TextEntityFactory instance(IEntityRegistryProvider provider) {
		return new TextEntityFactory(provider);
	}

	protected TextEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Document createDocument() {
		return create(TextEntityDescriptorEnum.Document);
	}

	public Document createDocument(IRow... entities) {
		return create(TextEntityDescriptorEnum.Document, (IEntity[]) entities);
	}

	public Document createDocument(int initialSize) {
		return clone(TextEntityDescriptorEnum.Document, initialSize);
	}

	public Indent createIndent() {
		return create(TextEntityDescriptorEnum.Indent);
	}

	public Indent createIndent(int value) {
		return create(TextEntityDescriptorEnum.Indent, value);
	}

	public RowSeparator createRowSeparator() {
		return create(TextEntityDescriptorEnum.RowSeparator);
	}

	public RowSeparator createRowSeparator(String value) {
		return create(TextEntityDescriptorEnum.RowSeparator, value);
	}

	public TextSeparator createTextSeparator() {
		return create(TextEntityDescriptorEnum.TextSeparator);
	}

	public TextSeparator createTextSeparator(String value) {
		return create(TextEntityDescriptorEnum.TextSeparator, value);
	}

	public Row createRow() {
		return create(TextEntityDescriptorEnum.Row);
	}

	public Row createRow(IText... entities) {
		return create(TextEntityDescriptorEnum.Row, (IEntity[]) entities);
	}

	public Row createRow(int initialSize) {
		return clone(TextEntityDescriptorEnum.Row, initialSize);
	}

	public Text createText() {
		return create(TextEntityDescriptorEnum.Text);
	}

	public Text createText(String value) {
		return create(TextEntityDescriptorEnum.Text, value);
	}
}
