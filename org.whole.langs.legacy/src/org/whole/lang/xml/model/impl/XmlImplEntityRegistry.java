package org.whole.lang.xml.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class XmlImplEntityRegistry extends AbstractEntityRegistry {
	public XmlImplEntityRegistry() {
		super(XmlEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DocumentImpl());
		put(new PrologImpl());
		put(new XMLDeclImpl());
		put(new VersionImpl());
		put(new EncodingImpl());
		put(new StandaloneImpl());
		put(new DocTypeDeclImpl());
		put(new SystemIdImpl());
		put(new SystemLiteralImpl());
		put(new PublicIdImpl());
		put(new PubidLiteralImpl());
		put(new MiscImpl());
		put(new PIImpl());
		put(new InstructionImpl());
		put(new CommentImpl());
		put(new CommentTextImpl());
		put(new ElementImpl());
		put(new AttributesImpl());
		put(new AttributeImpl());
		put(new NameImpl());
		put(new QualifiedNameImpl());
		put(new NameSpaceImpl());
		put(new ValueImpl());
		put(new ContentImpl());
		put(new CharDataImpl());
		put(new CDataSectImpl());
		put(new CDataSectDataImpl());
	}
}
