package com.pentaho.maven.transform.xml.insert;

import com.pentaho.maven.transform.xml.condition.ParentPathCondition;
import org.jdom2.Element;
import org.jdom2.filter.ElementFilter;

import java.util.Optional;

/**
 * Created by Vasilina_Terehova on 12/9/2016.
 */
public class ToParentPathInserter implements BaseInsertOperation {

    private String[] parentNodes;

    public ToParentPathInserter(String[] parentNodes) {
        this.parentNodes = parentNodes;
    }

    @Override
    public void insert(Element rootNode, Element node) {
        Element parent = ParentPathCondition.getParent(rootNode, parentNodes);
        parent.addContent(node);
    }
}
