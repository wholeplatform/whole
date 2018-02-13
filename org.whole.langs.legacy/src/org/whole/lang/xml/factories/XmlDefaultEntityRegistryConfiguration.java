package org.whole.lang.xml.factories;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;

import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class XmlDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		XmlEntityFactory ef = XmlEntityFactory.instance(er);

		er.put(ef.createVersion("1.0"));
		er.put(ef.createEncoding("UTF-8"));
		er.put(ef.createXMLDecl(
				ef.createVersion(),
				ef.createEncoding(),
				ef.createStandalone()));
		er.put(ef.createProlog(
				ef.createXMLDecl(),
				createResolver(XmlEntityDescriptorEnum.DocTypeDecl),
				createResolver(XmlEntityDescriptorEnum.Misc)));
		er.put(ef.createElement(
				ef.createName("tag"),
				createResolver(XmlEntityDescriptorEnum.Attributes),
				createResolver(XmlEntityDescriptorEnum.IContent)));		
		er.put(ef.createDocument(
				ef.createProlog(),
				ef.createElement()));
	}
}