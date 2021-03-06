package com.pentaho.maven.transform.xml.condition;

import org.jdom2.Element;
import org.jdom2.filter.ElementFilter;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vasilina_Terehova on 12/9/2016.
 */
public class ElementWithAttributeCondition implements BaseConditionCheck, BaseConditionFinder {
    private String attributeName;

    public ElementWithAttributeCondition(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public boolean isValid(Element rootNode, Element element) {
        return find(rootNode, element) == null;
    }

    @Override
    public Element find(Element rootNode, Element element) {
        List<Element> children = rootNode.getContent(new ElementFilter(element.getName()));
        if (children.size() == 0) {
            return null;
        }
        for (Element child : children) {
            if (child.getAttribute(attributeName).getValue().equals(element.getAttributeValue(attributeName))) {
                return child;
            }
        }
        return null;
    }
}
