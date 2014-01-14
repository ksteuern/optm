package net.optm.model;

import java.util.List;

/**
 * @author ksteuern
 *
 */
public class Component {

    private Component parent;

    private List<Component> children;

    public Component getParent() {
        return parent;
    }

    public void setParent(final Component parent) {
        this.parent = parent;
    }

    public List<Component> getChildren() {
        return children;
    }

    public void setChildren(final List<Component> children) {
        this.children = children;
    }

    public boolean add(final Component e) {
        return children.add(e);
    }

}
