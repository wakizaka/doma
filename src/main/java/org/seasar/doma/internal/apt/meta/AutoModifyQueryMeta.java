/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
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
package org.seasar.doma.internal.apt.meta;

import java.util.List;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

import org.seasar.doma.internal.apt.cttype.EntityCtType;
import org.seasar.doma.internal.apt.mirror.ModifyMirror;
import org.seasar.doma.jdbc.SqlLogType;

/**
 * @author taedium
 * 
 */
public class AutoModifyQueryMeta extends AbstractQueryMeta {

    protected EntityCtType entityCtType;

    protected String entityParameterName;

    protected ModifyMirror modifyMirror;

    public AutoModifyQueryMeta(ExecutableElement method, TypeElement dao) {
        super(method, dao);
    }

    public EntityCtType getEntityCtType() {
        return entityCtType;
    }

    public void setEntityCtType(EntityCtType entityCtType) {
        this.entityCtType = entityCtType;
    }

    public String getEntityParameterName() {
        return entityParameterName;
    }

    public void setEntityParameterName(String entityParameterName) {
        this.entityParameterName = entityParameterName;
    }

    ModifyMirror getModifyMirror() {
        return modifyMirror;
    }

    void setModifyMirror(ModifyMirror modifyMirror) {
        this.modifyMirror = modifyMirror;
    }

    public boolean getSqlFile() {
        return modifyMirror.getSqlFileValue();
    }

    public int getQueryTimeout() {
        return modifyMirror.getQueryTimeoutValue();
    }

    public Boolean getIgnoreVersion() {
        return modifyMirror.getIgnoreVersionValue();
    }

    public Boolean getExcludeNull() {
        return modifyMirror.getExcludeNullValue();
    }

    public Boolean getSuppressOptimisticLockException() {
        return modifyMirror.getSuppressOptimisticLockExceptionValue();
    }

    public Boolean getIncludeUnchanged() {
        return modifyMirror.getIncludeUnchangedValue();
    }

    public List<String> getInclude() {
        return modifyMirror.getIncludeValue();
    }

    public List<String> getExclude() {
        return modifyMirror.getExcludeValue();
    }

    public SqlLogType getSqlLogType() {
        return modifyMirror.getSqlLogValue();
    }

    @Override
    public <R, P> R accept(QueryMetaVisitor<R, P> visitor, P p) {
        return visitor.visitAutoModifyQueryMeta(this, p);
    }

}
