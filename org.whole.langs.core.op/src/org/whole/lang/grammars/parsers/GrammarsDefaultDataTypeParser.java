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
package org.whole.lang.grammars.parsers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.grammars.model.CompiledPattern;
import org.whole.lang.grammars.model.Format;
import org.whole.lang.grammars.model.Pattern;
import org.whole.lang.grammars.model.RegExp;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;

/**
 * @author Enrico Persiani
 */
public class GrammarsDefaultDataTypeParser extends DefaultDataTypePersistenceParser {
	protected GrammarBasedDataTypeParser grammarBasedDataTypeParser;

	protected GrammarsDefaultDataTypeParser(GrammarBasedDataTypeParser dataTypeParser) {
		this.grammarBasedDataTypeParser = dataTypeParser;
	}

	private IBindingManager bindingManager;
	protected IBindingManager getBindings() {
		if (bindingManager == null)
			bindingManager = BindingManagerFactory.instance.createBindingManager();
		return bindingManager;
	}
	protected String format(EntityDescriptor<?> ed, Object value) {
		Format format = grammarBasedDataTypeParser.getDataTerminal(ed).getFormat();
		if (EntityUtils.isFragment(format)) {
			IBindingManager bindings = getBindings();
			bindings.wEnterScope();
			bindings.wDefValue("self", value);
			IEntity entity = BehaviorUtils.evaluate(format, 0, bindings);
			bindings.wExitScope();
			return entity.wStringValue();
		} else {
			Formatter formatter = new Formatter(grammarBasedDataTypeParser.getLocale());
			return formatter.format(format.getValue(), value).toString();
		}
	}
	protected String matches(EntityDescriptor<?> ed, String value) {
		Pattern pattern = grammarBasedDataTypeParser.getDataTerminal(ed).getPattern();
		java.util.regex.Pattern compiledPattern = 
			Matcher.matchImpl(GrammarsEntityDescriptorEnum.CompiledPattern, pattern) ?
					((CompiledPattern) pattern).getValue() :
						java.util.regex.Pattern.compile(((RegExp) pattern).getValue());

		if (!compiledPattern.matcher(value).matches())
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);

		return value;
	}

	public static String cleanupIntegral(String value) {
		value = value.trim();
		return value.charAt(0) == '+' ? value.substring(1) : value;
	}
	public static String cleanupDecimal(String value) {
		return cleanupIntegral(value).replaceFirst(",", ".");
	}

	@Override
	public boolean parseBoolean(EntityDescriptor<?> ed, String value) {
		return super.parseBoolean(ed, matches(ed, value));
	}
	@Override
	public char parseChar(EntityDescriptor<?> ed, String value) {
		return super.parseChar(ed, matches(ed, value));
	}

	@Override
	public byte parseByte(EntityDescriptor<?> ed, String value) {
		return super.parseByte(ed, cleanupIntegral(matches(ed, value)));
	}
	@Override
	public int parseInt(EntityDescriptor<?> ed, String value) {
		return super.parseInt(ed, cleanupIntegral(matches(ed, value)));
	}
	@Override
	public long parseLong(EntityDescriptor<?> ed, String value) {
		return super.parseLong(ed, cleanupIntegral(matches(ed, value)));
	}
	@Override
	public short parseShort(EntityDescriptor<?> ed, String value) {
		return super.parseShort(ed, cleanupIntegral(matches(ed, value)));
	}

	@Override
	public float parseFloat(EntityDescriptor<?> ed, String value) {
		return super.parseFloat(ed, cleanupDecimal(matches(ed, value)));
	}
	@Override
	public double parseDouble(EntityDescriptor<?> ed, String value) {
		return super.parseDouble(ed, cleanupDecimal(matches(ed, value)));
	}

	@Override
	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		return GrammarsUtils.parse(value, grammarBasedDataTypeParser.getGrammarURI(), ed).wEnumValue();
	}
	@Override
	public String parseString(EntityDescriptor<?> ed, String value) {
		return super.parseString(ed, matches(ed, value));
	}
	@Override
	public Date parseDate(EntityDescriptor<?> ed, String value) {
		return super.parseDate(ed, matches(ed, value));
	}
	@Override
	public Object parseObject(EntityDescriptor<?> ed, String value) {
		value = matches(ed, value);
		if (BigDecimal.class.equals(ed.getDataType()))
			return new BigDecimal(cleanupDecimal(value));
		else if (BigInteger.class.equals(ed.getDataType()))
			return new BigInteger(cleanupIntegral(value));
		else
			return super.parseObject(ed, value);
	}

	@Override
	public String unparseBoolean(EntityDescriptor<?> ed, boolean value) {
		return format(ed, value);
	}
	@Override
	public String unparseChar(EntityDescriptor<?> ed, char value) {
		return format(ed, value);
	}
	
	@Override
	public String unparseByte(EntityDescriptor<?> ed, byte value) {
		return format(ed, value);
	}
	@Override
	public String unparseShort(EntityDescriptor<?> ed, short value) {
		return format(ed, value);
	}
	@Override
	public String unparseInt(EntityDescriptor<?> ed, int value) {
		return format(ed, value);
	}
	@Override
	public String unparseLong(EntityDescriptor<?> ed, long value) {
		return format(ed, value);
	}

	@Override
	public String unparseFloat(EntityDescriptor<?> ed, float value) {
		return format(ed, value);
	}
	@Override
	public String unparseDouble(EntityDescriptor<?> ed, double value) {
		return format(ed, value);
	}

	@Override
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		final StringBuilder sb = new StringBuilder();
		GenericTraversalFactory.instance.topDown(new AbstractVisitor() {
			public void visit(IEntity entity) {
				String text = null;
				switch (entity.wGetEntityDescriptor().getOrdinal()) {
				case GrammarsEntityDescriptorEnum.Literal_ord:
					text = entity.wStringValue();
					break;
				case GrammarsEntityDescriptorEnum.Space_ord:
					text = grammarBasedDataTypeParser.getSpace();
					break;
				case GrammarsEntityDescriptorEnum.Indent_ord:
					text = grammarBasedDataTypeParser.getIndent();
					break;
				case GrammarsEntityDescriptorEnum.NewLine_ord:
					text = grammarBasedDataTypeParser.getNewLine();
					break;
				}

				if (text != null) {
					if (sb.length() > 0)
						sb.append(grammarBasedDataTypeParser.getDelimiter());
					sb.append(text);
				}
			}
		}, false).visit(grammarBasedDataTypeParser.getEnumRule(value));
		
//		IEntityIterator<Literal> iterator = IteratorFactory.<Literal>descendantOrSelfMatcherIterator(
//				grammarBasedDataTypeParser.getEnumRule(value)).usePattern(GrammarsEntityDescriptorEnum.Literal);
//		if (iterator.hasNext())
//			sb.append(iterator.next().getValue());
//		while (iterator.hasNext()) {
//			sb.append(grammarBasedDataTypeParser.getDelimiter());
//			sb.append(iterator.next().getValue());
//		}
		return sb.toString();
	}
	@Override
	public String unparseString(EntityDescriptor<?> ed, String value) {
		return format(ed, value);
	}
	@Override
	public String unparseDate(EntityDescriptor<?> ed, Date value) {
		if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.Format, grammarBasedDataTypeParser.getDataTerminal(ed).getFormat())) {
				//WAS EntityUtils.isImpl(grammarBasedDataTypeParser.getDataTerminal(ed).getFormat())) {
			Calendar calendar = Calendar.getInstance(grammarBasedDataTypeParser.getLocale());
			calendar.setTime(value);
			calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
			return format(ed, calendar);
		} else
			return format(ed, value);
	}
	@Override
	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		return format(ed, value);
	}
}
