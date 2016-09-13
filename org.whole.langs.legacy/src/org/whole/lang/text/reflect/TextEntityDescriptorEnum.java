package org.whole.lang.text.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class TextEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Document_ord = 0;
	public static final int Indent_ord = 1;
	public static final int RowSeparator_ord = 2;
	public static final int TextSeparator_ord = 3;
	public static final int Row_ord = 4;
	public static final int Text_ord = 5;
	public static final int IText_ord = 6;
	public static final int IRow_ord = 7;
	public static final TextEntityDescriptorEnum instance = new TextEntityDescriptorEnum();
	public static final EntityDescriptor<Document> Document = (EntityDescriptor<Document>) instance
			.valueOf(Document_ord);
	public static final EntityDescriptor<Indent> Indent = (EntityDescriptor<Indent>) instance
			.valueOf(Indent_ord);
	public static final EntityDescriptor<RowSeparator> RowSeparator = (EntityDescriptor<RowSeparator>) instance
			.valueOf(RowSeparator_ord);
	public static final EntityDescriptor<TextSeparator> TextSeparator = (EntityDescriptor<TextSeparator>) instance
			.valueOf(TextSeparator_ord);
	public static final EntityDescriptor<Row> Row = (EntityDescriptor<Row>) instance
			.valueOf(Row_ord);
	public static final EntityDescriptor<Text> Text = (EntityDescriptor<Text>) instance
			.valueOf(Text_ord);
	public static final EntityDescriptor<IText> IText = (EntityDescriptor<IText>) instance
			.valueOf(IText_ord);
	public static final EntityDescriptor<IRow> IRow = (EntityDescriptor<IRow>) instance
			.valueOf(IRow_ord);

	private TextEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putCompositeEntity(
		Document_ord, "Document", Document.class, false, IRow_ord, true, false);
		putDataEntity(Indent_ord, "Indent", Indent.class, false, int.class);
		putDataEntity(RowSeparator_ord, "RowSeparator", RowSeparator.class,
				false, String.class);
		putDataEntity(TextSeparator_ord, "TextSeparator", TextSeparator.class,
				false, String.class);
		putCompositeEntity(
		Row_ord, "Row", Row.class, false, IText_ord, true, false);
		putDataEntity(Text_ord, "Text", Text.class, false, String.class);
		putSimpleEntity(IText_ord, "IText", IText.class, true, Text_ord,
				TextSeparator_ord, Row_ord);
		putSimpleEntity(IRow_ord, "IRow", IRow.class, true, RowSeparator_ord,
				TextSeparator_ord, Document_ord, Indent_ord, Row_ord);
	}
}
