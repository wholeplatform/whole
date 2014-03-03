package org.whole.lang.html.visitors;

import nu.validator.htmlparser.sax.HtmlSerializer;

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.xml.util.SaxHandlerBuilderOperation;

public class HtmlPrettyPrinterVisitor extends GenericIdentityVisitor {
	protected final IPrettyPrintWriter out;

	public HtmlPrettyPrinterVisitor(PrettyPrinterOperation operation) {
    	out = operation.getPrettyPrintWriter();
	}

	public void visit(IEntity entity) {
		IEntity xhtmlDocument = BehaviorUtils.apply("whole:org.whole.lang.html:HTML5Semantics#toXHtml", entity);
		HtmlSerializer serializer = new HtmlSerializer(out.asWriter());
		SaxHandlerBuilderOperation sbop = new SaxHandlerBuilderOperation(serializer, serializer, "http://www.w3.org/1999/xhtml");
		new ModelTemplate(xhtmlDocument).apply(sbop);		
	};
}
