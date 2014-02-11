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

import javax.lang.model.element.ExecutableElement;

import org.seasar.doma.MapKeyNamingType;
import org.seasar.doma.internal.apt.mirror.ProcedureMirror;

/**
 * @author taedium
 * 
 */
public class AutoProcedureQueryMeta extends AutoModuleQueryMeta {

    protected ProcedureMirror procedureMirror;

    public AutoProcedureQueryMeta(ExecutableElement method) {
        super(method);
    }

    ProcedureMirror getProcedureMirror() {
        return procedureMirror;
    }

    void setProcedureMirror(ProcedureMirror procedureMirror) {
        this.procedureMirror = procedureMirror;
    }

    public String getCatalogName() {
        return procedureMirror.getCatalogValue();
    }

    public String getSchemaName() {
        return procedureMirror.getSchemaValue();
    }

    public String getProcedureName() {
        return procedureMirror.getNameValue();
    }

    public boolean isQuoteRequired() {
        return procedureMirror.getQuoteValue();
    }

    public int getQueryTimeout() {
        return procedureMirror.getQueryTimeoutValue();
    }

    @Override
    public MapKeyNamingType getMapKeyNamingType() {
        return procedureMirror.getMapKeyNamingValue();
    }

    @Override
    public <R, P> R accept(QueryMetaVisitor<R, P> visitor, P p) {
        return visitor.visitAutoProcedureQueryMeta(this, p);
    }

}