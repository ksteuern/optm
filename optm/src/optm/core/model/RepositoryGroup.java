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
package optm.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ksteuern
 * 
 */
public class RepositoryGroup<T extends RepositoryItem> extends RepositoryItem {

    private List<T> children = new ArrayList<T>();

    public RepositoryGroup(final String name) {
        super(name);
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(final List<T> children) {
        this.children = children;
    }

    public boolean add(final T e) {
        e.setParent(this);
        return children.add(e);
    }

    public boolean remove(final T e) {
        e.setParent(null);
        return children.remove(e);
    }

    public boolean addAll(final Collection<? extends T> c) {
        return children.addAll(c);
    }

}
