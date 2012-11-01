package org.whole.lang.grammars.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class GrammarsIdentitySwitchVisitor extends AbstractVisitor
		implements IGrammarsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case GrammarsEntityDescriptorEnum.Grammar_ord:
			visit((Grammar) entity);
			break;
		case GrammarsEntityDescriptorEnum.Productions_ord:
			visit((Productions) entity);
			break;
		case GrammarsEntityDescriptorEnum.Production_ord:
			visit((Production) entity);
			break;
		case GrammarsEntityDescriptorEnum.And_ord:
			visit((And) entity);
			break;
		case GrammarsEntityDescriptorEnum.Or_ord:
			visit((Or) entity);
			break;
		case GrammarsEntityDescriptorEnum.Not_ord:
			visit((Not) entity);
			break;
		case GrammarsEntityDescriptorEnum.Empty_ord:
			visit((Empty) entity);
			break;
		case GrammarsEntityDescriptorEnum.Space_ord:
			visit((Space) entity);
			break;
		case GrammarsEntityDescriptorEnum.Indent_ord:
			visit((Indent) entity);
			break;
		case GrammarsEntityDescriptorEnum.NewLine_ord:
			visit((NewLine) entity);
			break;
		case GrammarsEntityDescriptorEnum.LiteralTerminal_ord:
			visit((LiteralTerminal) entity);
			break;
		case GrammarsEntityDescriptorEnum.DataTerminal_ord:
			visit((DataTerminal) entity);
			break;
		case GrammarsEntityDescriptorEnum.NonTerminal_ord:
			visit((NonTerminal) entity);
			break;
		case GrammarsEntityDescriptorEnum.Optional_ord:
			visit((Optional) entity);
			break;
		case GrammarsEntityDescriptorEnum.Repeat_ord:
			visit((Repeat) entity);
			break;
		case GrammarsEntityDescriptorEnum.Concatenate_ord:
			visit((Concatenate) entity);
			break;
		case GrammarsEntityDescriptorEnum.Choose_ord:
			visit((Choose) entity);
			break;
		case GrammarsEntityDescriptorEnum.When_ord:
			visit((When) entity);
			break;
		case GrammarsEntityDescriptorEnum.As_ord:
			visit((As) entity);
			break;
		case GrammarsEntityDescriptorEnum.Split_ord:
			visit((Split) entity);
			break;
		case GrammarsEntityDescriptorEnum.BySize_ord:
			visit((BySize) entity);
			break;
		case GrammarsEntityDescriptorEnum.ByLines_ord:
			visit((ByLines) entity);
			break;
		case GrammarsEntityDescriptorEnum.ByDelimiter_ord:
			visit((ByDelimiter) entity);
			break;
		case GrammarsEntityDescriptorEnum.LanguageDescriptor_ord:
			visit((LanguageDescriptor) entity);
			break;
		case GrammarsEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case GrammarsEntityDescriptorEnum.URI_ord:
			visit((URI) entity);
			break;
		case GrammarsEntityDescriptorEnum.Namespace_ord:
			visit((Namespace) entity);
			break;
		case GrammarsEntityDescriptorEnum.Version_ord:
			visit((Version) entity);
			break;
		case GrammarsEntityDescriptorEnum.Unbounded_ord:
			visit((Unbounded) entity);
			break;
		case GrammarsEntityDescriptorEnum.Size_ord:
			visit((Size) entity);
			break;
		case GrammarsEntityDescriptorEnum.Literal_ord:
			visit((Literal) entity);
			break;
		case GrammarsEntityDescriptorEnum.RegExp_ord:
			visit((RegExp) entity);
			break;
		case GrammarsEntityDescriptorEnum.CompiledPattern_ord:
			visit((CompiledPattern) entity);
			break;
		case GrammarsEntityDescriptorEnum.Format_ord:
			visit((Format) entity);
			break;
		case GrammarsEntityDescriptorEnum.Category_ord:
			visit((Category) entity);
			break;
		case GrammarsEntityDescriptorEnum.DataType_ord:
			visit((DataType) entity);
			break;
		case GrammarsEntityDescriptorEnum.CustomDataType_ord:
			visit((CustomDataType) entity);
			break;
		}
	}
}
