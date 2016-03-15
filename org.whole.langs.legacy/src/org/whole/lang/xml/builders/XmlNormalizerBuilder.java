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

import static org.whole.lang.xml.reflect.XmlEntityDescriptorEnum.*;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.GenericEventTrackingBuilder;
import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.contexts.IdentityEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xml.util.XmlUtils;

/**
 * An Xml Builder that performs several normalization steps in streaming:
 * 
 * 1. Introduces implied Content events
 * 2. Removes nested Content events (ie Content_(); Content_();)
 * 3. packs sequences of CDataSect and CharData
 * 4. optionally merges CDataSect and CharData in a single CharData
 * 
 * @author Enrico Persiani
 */
public class XmlNormalizerBuilder extends XmlSpecificBuilderAdapter {
	protected IBuilderOperation op;

	public XmlNormalizerBuilder(IBuilderOperation op, IBindingManager bm) {
		super(new GenericIdentityBuilder(), new IdentityEntityContext());
		this.op = op;
		wSetBuilderStrategy(new GenericXmlNormalizerBuilder(getTargetBuilder(), 
				bm.wIsSet("mergeCDataSect") ? bm.wBooleanValue("mergeCDataSect") : false));
	}

	protected IBuilder targetBuilder;
	protected IBuilder getTargetBuilder() {
		if (targetBuilder == null)
			targetBuilder = ModelBuilderOperation.ID.equals(op.wGetOperationId()) ?
					op.wGetBuilder(XmlLanguageKit.URI, false) : //FIXME workaround, should use a generic builder
						op.wGetBuilder();
		return targetBuilder;
	}

	protected class GenericXmlNormalizerBuilder extends GenericEventTrackingBuilder {
		protected boolean mergeCDataSect;
		protected boolean hasCharData;
		protected StringBuilder charData;
		protected StringBuilder cdataSectData;

		public GenericXmlNormalizerBuilder(IBuilder builder, boolean mergeCDataSect) {
			super(builder);
			this.mergeCDataSect = mergeCDataSect;
			this.hasCharData = false;
			this.charData = new StringBuilder();
			this.cdataSectData = new StringBuilder();
		}

		protected void appendCharData(String s) {
			appendCharData(s, false);
		}
		protected void appendCharData(String s, boolean force) {
			if (force || !XmlUtils.isIgnorableWhitespace(s)) {
				charData.append(s);
				hasCharData = true;
			}
		}
		protected void appendCDataSectData(String s) {
			cdataSectData.append(s);
		}
		protected void generateCharData() {
			if (hasCharData) {
				super.wEntity(CharData, charData.toString());
				charData.setLength(0);
				hasCharData = false;
			}
		}
		protected void generateCDataSect() {
			if (mergeCDataSect)
				appendCharData(cdataSectData.toString(), true);
			else {
				generateCharData();
				super.wEntity_(CDataSect, 1);
				super.wEntity(CDataSectData, cdataSectData.toString());
				super._wEntity(CDataSect);
			}
			cdataSectData.setLength(0);
		}

		@Override
		public void wEntity(EntityDescriptor<?> ed, String value) {
			if (CharData.equals(ed)) {
				if (!Content.equals(wGetEntityDescriptor())) {
					//NOTE: no parent Content means single CharData
					super.wEntity_(Content, 1);
					if (!XmlUtils.isIgnorableWhitespace(value))
						super.wEntity(ed, value);
					super._wEntity(Content);
				} else
					appendCharData(value);
			} else if (CDataSectData.equals(ed))
				appendCDataSectData(value);
			else
				super.wEntity(ed, value);
		}

		@Override
		public void wEntity_(EntityDescriptor<?> ed) {
			if (IContent.isLanguageSupertypeOf(ed))
				generateCharData();

			switch (ed.getOrdinal()) {
			case Element_ord:
			case PI_ord:
			case Comment_ord:
				EntityDescriptor<?> context = wGetEntityDescriptor();
				// NOTE: wGetEntityDescriptor() == null when we reach UNKNOWN state
				if (context != null && !Content.equals(context) && !Document.equals(context) && !Misc.equals(context))
					builderStrategy.wEntity_(Content, 1);
				break;
			case Content_ord:
				if (Content.equals(wGetEntityDescriptor())) {
					pushUnknownState();
					return; // skip repeated Content
				}
				break;
			case CDataSect_ord:
				if (!Content.equals(wGetEntityDescriptor()))
					builderStrategy.wEntity_(Content, 1);
				appendCDataSectData("");
				return;
			}
			super.wEntity_(ed);
		}

		@Override
		public void wEntity_(EntityDescriptor<?> ed, int initialCapacity) {
			wEntity_(ed);
		}

		@Override
		public void _wEntity(EntityDescriptor<?> ed) {
			switch (ed.getOrdinal()) {
			case CDataSect_ord:
				generateCDataSect();
				if (!Content.equals(wGetEntityDescriptor())) {
					generateCharData();
					builderStrategy._wEntity(Content);
				}
				return;

			case Element_ord:
			case PI_ord:
			case Comment_ord:
				super._wEntity(ed);
				EntityDescriptor<?> context = wGetEntityDescriptor();
				// NOTE: wGetEntityDescriptor() == null when we reach UNKNOWN state
				if (context != null && !Content.equals(context) && !Document.equals(context) && !Misc.equals(context))
					builderStrategy._wEntity(Content);
				return;

			case Content_ord:
				generateCharData();
				if (!Content.equals(wGetEntityDescriptor())) {
					// skip repeated Content
					// NOTE: wGetEntityDescriptor() == null when we reach UNKNOWN state
					popState();
					return;
				}
			}
			super._wEntity(ed);
		}
	}
}
