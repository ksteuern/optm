/*
 * (C) Copyright 2014 Kai Steuernagel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package net.optm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksteuern
 * 
 */
public class Component {

    private Component parent;

    private List<Component> children = new ArrayList<Component>();

    protected String name;

    protected String imageFileName;

    public Component() {
    }

    public Component(final String name, final String imageFileName) {
        super();
        this.name = name;
        this.imageFileName = imageFileName;
    }

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
        e.setParent(this);
        return children.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(final String imageFileName) {
        this.imageFileName = imageFileName;
    }

}
