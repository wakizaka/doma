/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.internal.apt.entity;

import java.util.List;
import java.util.Set;

import org.seasar.doma.jdbc.entity.AbstractEntityMeta;
import org.seasar.doma.jdbc.entity.GeneratedIdPropertyMeta;
import org.seasar.doma.jdbc.entity.EntityPropertyMeta;
import org.seasar.doma.jdbc.entity.VersionPropertyMeta;

/**
 * @author taedium
 * 
 */
public class Emp_ extends AbstractEntityMeta<Emp> {

    public Emp_() {
        super(null, null, null);
    }

    @Override
    public Emp getEntity() {
        return null;
    }

    @Override
    public Object getPropertyWrappers() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public EntityPropertyMeta<?> getPropertyMeta(String propertyName) {
        return null;
    }

    @Override
    public List<EntityPropertyMeta<?>> getPropertyMetas() {
        return null;
    }

    @Override
    public GeneratedIdPropertyMeta<?> getGeneratedIdProperty() {
        return null;
    }

    @Override
    public VersionPropertyMeta<?> getVersionProperty() {
        return null;
    }

    @Override
    public void preDelete() {
    }

    @Override
    public void preInsert() {
    }

    @Override
    public void preUpdate() {
    }

    @Override
    public Set<String> getModifiedProperties() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refreshEntity() {
        // TODO Auto-generated method stub

    }

}
