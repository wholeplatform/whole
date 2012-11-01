package org.whole.lang.text.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TextGenericBuilderAdapter extends GenericIdentityBuilder {
	private ITextBuilder specificBuilder;

	public TextGenericBuilderAdapter(ITextBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public TextGenericBuilderAdapter(ITextBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TextEntityDescriptorEnum.Document_ord:
			specificBuilder.Document();
			break;
		case TextEntityDescriptorEnum.Row_ord:
			specificBuilder.Row();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TextEntityDescriptorEnum.Document_ord:
			specificBuilder.Document_();
			break;
		case TextEntityDescriptorEnum.Row_ord:
			specificBuilder.Row_();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case TextEntityDescriptorEnum.Document_ord:
			specificBuilder.Document_(initialCapacity);
			break;
		case TextEntityDescriptorEnum.Row_ord:
			specificBuilder.Row_(initialCapacity);
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TextEntityDescriptorEnum.Document_ord:
			specificBuilder._Document();
			break;
		case TextEntityDescriptorEnum.Row_ord:
			specificBuilder._Row();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case TextEntityDescriptorEnum.Indent_ord:
			specificBuilder.Indent(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case TextEntityDescriptorEnum.RowSeparator_ord:
			specificBuilder.RowSeparator(value);
			break;
		case TextEntityDescriptorEnum.TextSeparator_ord:
			specificBuilder.TextSeparator(value);
			break;
		case TextEntityDescriptorEnum.Text_ord:
			specificBuilder.Text(value);
			break;
		}
	}
}
