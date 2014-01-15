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
public class RepositoryGroup extends RepositoryItem {

    private List<RepositoryItem> children = new ArrayList<RepositoryItem>();

    public RepositoryGroup() {
        super(null, null);
    }

    public RepositoryGroup(final String name, final String imageFileName) {
        super(name, imageFileName);
    }

    public List<RepositoryItem> getChildren() {
        return children;
    }

    public void setChildren(final List<RepositoryItem> children) {
        this.children = children;
    }

    public boolean add(final RepositoryItem e) {
        e.setParent(this);
        return children.add(e);
    }

}
