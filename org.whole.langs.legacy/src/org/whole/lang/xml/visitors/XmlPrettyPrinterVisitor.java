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
package org.whole.lang.xml.visitors;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.xml.model.Attribute;
import org.whole.lang.xml.model.Attributes;
import org.whole.lang.xml.model.CDataSect;
import org.whole.lang.xml.model.CDataSectData;
import org.whole.lang.xml.model.CharData;
import org.whole.lang.xml.model.Comment;
import org.whole.lang.xml.model.CommentText;
import org.whole.lang.xml.model.Content;
import org.whole.lang.xml.model.DocTypeDecl;
import org.whole.lang.xml.model.Document;
import org.whole.lang.xml.model.Element;
import org.whole.lang.xml.model.Encoding;
import org.whole.lang.xml.model.IContent;
import org.whole.lang.xml.model.Instruction;
import org.whole.lang.xml.model.Misc;
import org.whole.lang.xml.model.Name;
import org.whole.lang.xml.model.NameSpace;
import org.whole.lang.xml.model.PI;
import org.whole.lang.xml.model.Prolog;
import org.whole.lang.xml.model.PubidLiteral;
import org.whole.lang.xml.model.PublicId;
import org.whole.lang.xml.model.QualifiedName;
import org.whole.lang.xml.model.Standalone;
import org.whole.lang.xml.model.SystemId;
import org.whole.lang.xml.model.SystemLiteral;
import org.whole.lang.xml.model.Value;
import org.whole.lang.xml.model.Version;
import org.whole.lang.xml.model.XMLDecl;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class XmlPrettyPrinterVisitor extends XmlIdentityVisitor {
	protected final IPrettyPrintWriter out;

	public XmlPrettyPrinterVisitor(PrettyPrinterOperation operation) {
    	out = operation.getPrettyPrintWriter();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		if (!EntityUtils.isResolver(entity))
			stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	public void visit(Document entity) {
        entity.getProlog().accept(this);
        entity.getElement().accept(this);
        out.println();
    }

    public void visit(Prolog entity) {
        entity.getXmlDecl().accept(this);
        entity.getDocTypeDecl().accept(this);
        entity.getMisc().accept(this);
    }

    public void visit(XMLDecl entity) {
        out.printRaw("<?xml");
        entity.getVersion().accept(this);
        entity.getEncoding().accept(this);
        entity.getStandalone().accept(this);
        out.printlnRaw("?>");
    }

    public void visit(Version entity) {
        out.printRaw(" version=\"");
        out.printRaw(entity.wStringValue());
        out.printRaw("\"");
    }

    public void visit(Encoding entity) {
        out.printRaw(" encoding=\"");
        out.printRaw(entity.wStringValue());
        out.printRaw("\"");
    }

    @Override
    public void visit(Standalone entity) {
    	out.printRaw(" standalone=\"" + (entity.wBooleanValue() ? "yes" : "no") + "\"");
     }

    public void visit(DocTypeDecl entity) {
    	if (EntityUtils.isResolver(entity.getName()))
    		return;

        out.printRaw("<!DOCTYPE ");
        entity.getName().accept(this);
        out.printRaw(" ");
        entity.getExternalId().accept(this);
        out.printlnRaw(">");
    }

    public void visit(SystemLiteral entity) {
        out.printRaw(entity.wStringValue());
    }

    public void visit(SystemId entity) {
        out.printRaw("SYSTEM \"");
        entity.getSystemLiteral().accept(this);
        out.printRaw("\"");
    }

    public void visit(PubidLiteral entity) {
        out.printRaw(entity.wStringValue());
    }

    public void visit(PublicId entity) {
        out.printRaw("PUBLIC \"");
        entity.getPubidLiteral().accept(this);
        out.printRaw("\" \"");
        entity.getSystemLiteral().accept(this);
        out.printRaw("\"");
    }

    public void visit(Misc entity) {
		for (int i = 0; i < entity.size(); i++) {
			entity.get(i).accept(this);
			out.println();
		}
    }

    public void visit(Comment entity) {
        out.printRaw("<!--");
        entity.getText().accept(this);
        out.printRaw("-->");
    }

    public void visit(CommentText entity) {
        out.printRaw(StringUtils.toXMLCommentText(entity.getValue()));
    }

    public void visit(Instruction entity) {
        out.printRaw(entity.wStringValue());
    }

    public void visit(PI entity) {
        out.printRaw("<?");
        entity.getName().accept(this);
        out.printRaw(" ");
        entity.getInstruction().accept(this);
        out.printRaw("?>");
    }

    public void visit(Attributes entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(this);
    }

    public void visit(Content entity) {
    	IEntity prevChild = null;
		for (int i = 0; i < entity.size(); i++) {
			IContent child = entity.get(i);
			if (prevChild != null
					&& !Matcher.match(XmlEntityDescriptorEnum.CharData, prevChild)
					&& !Matcher.match(XmlEntityDescriptorEnum.CharData, child)) {
		        out.println();
			}
			child.accept(this);
			prevChild = child;
		}
    }

    public void visit(Element entity) {
        out.printRaw("<");
        entity.getTag().accept(this);
        entity.getAttributes().accept(this);
        
        IContent content = entity.getContent();
        int contentSize = content.wSize();

        final int NO_CONTENT = 0;
        final int INLINE_CONTENT = 1;
        final int NESTED_CONTENT = 2;
        int contentCase = NESTED_CONTENT;

        if (Matcher.match(XmlEntityDescriptorEnum.Content, content)) {
            if (EntityUtils.isResolver(content))
                contentCase = NO_CONTENT;
            else {
                switch (contentSize) {
                case 0:
                    contentCase = NO_CONTENT;
                    break;
                case 1:
                	IEntity contentChild = content.wGet(0);
                    if (EntityUtils.isResolver(contentChild))
                        contentCase = NO_CONTENT;
                    else if (!Matcher.match(XmlEntityDescriptorEnum.Element, contentChild))
                        contentCase = INLINE_CONTENT;
                    break;
                }
            }
        } else {
            contentCase = INLINE_CONTENT;
        }

        switch (contentCase) {
        case NO_CONTENT:
            out.printRaw("/>");
        	break;
        case INLINE_CONTENT:
            out.printRaw(">");

            out.setInlined(true);
            content.accept(this);
            out.setInlined(false);

            out.printRaw("</");
            entity.getTag().accept(this);
            out.printRaw(">");
        	break;
        case NESTED_CONTENT:
        	out.printRaw(">");
            
            out.setRelativeIndentation(+1);

            if (!Matcher.matchImpl(XmlEntityDescriptorEnum.CharData, content.wGet(0))) {
            	out.println();
            }

            content.accept(this);
            out.setRelativeIndentation(-1);

            if (!Matcher.matchImpl(XmlEntityDescriptorEnum.CharData, content.wGet(contentSize-1))) {
            	out.println();
            }
            out.printRaw("</");
            entity.getTag().accept(this);
            out.printRaw(">");
        	break;
        }
    }

    public void visit(CharData entity) {
        out.printRaw(StringUtils.toXMLCharData(entity.wStringValue()));
    }

    public void visit(CDataSectData entity) {
        out.printRaw(StringUtils.toXMLCData(entity.wStringValue()));
    }

    public void visit(CDataSect entity) {
        out.printRaw("<![CDATA[");
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(this);
        out.printRaw("]]>");
    }

    public void visit(Value entity) {
        out.printRaw(StringUtils.toXMLString(entity.wStringValue()));
    }

    public void visit(Attribute entity) {
        out.printRaw(" ");
        entity.getName().accept(this);
        out.printRaw("=\"");
        entity.getValue().accept(this);
        out.printRaw("\"");
    }

    public void visit(Name entity) {
        out.printRaw(entity.wStringValue());
    }

    public void visit(NameSpace entity) {
        out.printRaw(entity.wStringValue());
    }

    public void visit(QualifiedName entity) {
    	if (Matcher.matchImpl(XmlEntityDescriptorEnum.NameSpace, entity.getNameSpace())) {
    		String prefix = entity.getNameSpace().wStringValue();
    		if (prefix.length() > 0) {
    			out.printRaw(prefix);
    	        out.printRaw(":");   			
    		}
    	}
        entity.getName().accept(this);
    }
}
