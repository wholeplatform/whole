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
package org.whole.lang.ui.notations;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @author Riccardo Solmi
 */
public class NotationImages {
	public static ImageDescriptor createIconDescriptor(String imageFilePath) {
		return ImageDescriptor.createFromURL(Platform.getBundle("org.whole.lang.ui.notations").getEntry(imageFilePath));
	}
	public static Image createIcon(String imageFilePath) {
		return createIconDescriptor(imageFilePath).createImage();
	}
	public static ImageDescriptor createImageDescriptor(String imageFilePath) {
		return ImageDescriptor.createFromFile(NotationImages.class, imageFilePath);
	}
	public static Image createImage(String imageFilePath) {
		return new Image(null, NotationImages.class.getResourceAsStream(imageFilePath));
	}

    public static final Image ON_ALARM16 = createIcon("icons/images/onalarm.gif");
    public static final Image ON_CALL16 = createIcon("icons/images/oncall.gif");
    public static final Image ON_MESSAGE16 = createIcon("icons/images/onmessage.gif");

    public static final Image MESSAGE16 = createIcon("icons/images/message.gif");
    public static final Image THROW16 = createIcon("icons/images/throw.gif");
    public static final Image COMPENSATE16 = createIcon("icons/images/compensate.gif");
    public static final Image WAIT16 = createIcon("icons/images/wait.gif");
    public static final Image EXIT16 = createIcon("icons/images/exit.gif");

	public static final Image PARALLEL16 = createIcon("icons/images/parallel.gif");
    public static final Image SEQUENCE16 = createIcon("icons/images/sequence.gif");

    public static final Image LOOP16 = createIcon("icons/images/while.gif");

    public static final Image PICK16 = createIcon("icons/images/pick.gif");
    public static final Image SWITCH16 = createIcon("icons/images/switch.gif");
    public static final Image CASE16 = createIcon("icons/images/case.gif");
    public static final Image OTHERWISE16 = createIcon("icons/images/otherwise.gif");

    public static final Image SCOPE16 = createIcon("icons/images/scope.gif");
    public static final Image COMPENSATION_HANDLER16 = createIcon("icons/images/compensationhandler.gif");
    public static final Image CATCH16 = createIcon("icons/images/catch.gif");
    public static final Image CATCH_ALL16 = createIcon("icons/images/catchall.gif");

    public static final Image EMPTY16 = createIcon("icons/images/empty.gif");
    public static final Image ASSIGN16 = createIcon("icons/images/assign.gif");
    public static final Image CALL16 = createIcon("icons/images/call.gif");
    public static final Image INVOKE16 = createIcon("icons/images/invoke.gif");
    public static final Image RECEIVE16 = createIcon("icons/images/receive.gif");
    public static final Image REPLY16 = createIcon("icons/images/reply.gif");

    public static final Image OPERATION16 = createIcon("icons/images/operation.gif");
    public static final Image VALIDATE16 = createIcon("icons/images/validate.gif");
    public static final Image NORMALIZE16 = createIcon("icons/images/normalize.gif");
    public static final Image PRETTY_PRINT16 = createIcon("icons/images/pretty_print.gif");
    public static final Image INTERPRET16 = createIcon("icons/images/interpret.gif");
    public static final Image GENERATE_ARTIFACTS16 = createIcon("icons/images/generate_artifacts.gif");
    public static final Image GENERATE_JAVA16 = createIcon("icons/images/generate_java.gif");

    public static final Image WORKSPACE16 = createIcon("icons/images/workspace.gif");    
    public static final Image PROJECT16 = createIcon("icons/images/project.gif");    
    public static final Image FOLDER16 = createIcon("icons/images/folder.gif");    
    public static final Image PACKAGE_FOLDER16 = createIcon("icons/images/package_folder.gif");    
    public static final Image PACKAGE16 = createIcon("icons/images/package.gif");    
    public static final Image FILE16 = createIcon("icons/images/file.gif");    
    public static final Image JAVA_FILE16 = createIcon("icons/images/java_file.gif");    

    public static final Image PACKAGE_OBJ = createIcon("icons/images/package_obj.gif");    
    public static final Image CLASS_OBJ = createIcon("icons/images/class_obj.gif");    
    public static final Image ABSTRACT_CLASS_OBJ = createIcon("icons/images/abstract_class_obj.gif");    
    public static final Image INTERFACE_OBJ = createIcon("icons/images/interface_obj.gif");    
    public static final Image ENUM_OBJ = createIcon("icons/images/enum_obj.gif");    

    public static final Image XML_DOCTYPE16 = createIcon("icons/images/xml_doctype.gif");
    public static final Image XML_ELEMENT16 = createIcon("icons/images/xml_element.gif");
    public static final Image XML_ATTRIBUTE16 = createIcon("icons/images/xml_attribute.gif");
    public static final Image XML_CDATASECT16 = createIcon("icons/images/xml_cdatasection.gif");
    public static final Image XML_COMMENT16 = createIcon("icons/images/xml_comment.gif");
    public static final Image XML_PI16 = createIcon("icons/images/xml_pi.gif");
    public static final Image XML_TEXT16 = createIcon("icons/images/xml_text.gif");
    public static final Image XML_TAG16 = createIcon("icons/images/xml_tag.gif");

    public static final Image CREATE_MODEL16 = createIcon("icons/images/create_model.gif");    
    public static final Image CREATE_OBJECT16 = createIcon("icons/images/create_object.gif");    
    public static final Image CALL_QUERY16 = createIcon("icons/images/call_query.gif");    
    public static final Image CALL_JAVA16 = createIcon("icons/images/call_java.gif");    
    public static final Image INPUT_TASK16 = createIcon("icons/images/input_task.gif");    

    public static final Image FONT16 = createIcon("icons/images/font.gif");
    public static final Image IMAGE16 = createIcon("icons/images/image.gif");
    public static final Image MODEL16 = createIcon("icons/images/model.gif");
}
