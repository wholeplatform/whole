package org.whole.lang.xml.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class XmlAdaptersEntityRegistry extends AbstractEntityRegistry {
	public XmlAdaptersEntityRegistry() {
		super(XmlEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DocumentAdapter());
		put(new PrologAdapter());
		put(new XMLDeclAdapter());
		put(new VersionAdapter());
		put(new EncodingAdapter());
		put(new StandaloneAdapter());
		put(new DocTypeDeclAdapter());
		put(new SystemIdAdapter());
		put(new SystemLiteralAdapter());
		put(new PublicIdAdapter());
		put(new PubidLiteralAdapter());
		put(new MiscAdapter());
		put(new PIAdapter());
		put(new InstructionAdapter());
		put(new CommentAdapter());
		put(new CommentTextAdapter());
		put(new ElementAdapter());
		put(new AttributesAdapter());
		put(new AttributeAdapter());
		put(new NameAdapter());
		put(new QualifiedNameAdapter());
		put(new NameSpaceAdapter());
		put(new ValueAdapter());
		put(new ContentAdapter());
		put(new CharDataAdapter());
		put(new CDataSectAdapter());
		put(new CDataSectDataAdapter());
		put(new INameAdapter());
		put(new IContentAdapter());
		put(new IExternalIdAdapter());
		put(new IMiscAdapter());
	}
}
