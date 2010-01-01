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
package org.seasar.doma.internal.jdbc.query;

import static org.seasar.doma.internal.util.AssertionUtil.*;

import java.util.ArrayList;
import java.util.List;

import org.seasar.doma.internal.jdbc.entity.EntityPropertyType;
import org.seasar.doma.internal.jdbc.entity.EntityType;
import org.seasar.doma.internal.jdbc.entity.VersionPropertyType;
import org.seasar.doma.internal.jdbc.sql.PreparedSql;
import org.seasar.doma.internal.message.Message;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcException;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;

/**
 * @author taedium
 * 
 */
public abstract class AutoBatchModifyQuery<E> implements BatchModifyQuery {

    protected static final String[] EMPTY_STRINGS = new String[] {};

    protected List<EntityPropertyType<E, ?>> targetPropertyTypes;

    protected List<EntityPropertyType<E, ?>> idPropertyTypes;

    protected String[] includedPropertyNames = EMPTY_STRINGS;

    protected String[] excludedPropertyNames = EMPTY_STRINGS;

    protected final EntityType<E> entityType;

    protected Config config;

    protected String callerClassName;

    protected String callerMethodName;

    protected VersionPropertyType<E, ?> versionPropertyType;

    protected boolean optimisticLockCheckRequired;

    protected boolean autoGeneratedKeysSupported;

    protected boolean executable;

    protected SqlExecutionSkipCause executionSkipCause = SqlExecutionSkipCause.BATCH_TARGET_NONEXISTENT;

    protected List<PreparedSql> sqls;

    protected List<E> entities;

    protected E currentEntity;

    protected int queryTimeout;

    protected int batchSize;

    public AutoBatchModifyQuery(EntityType<E> entityType) {
        assertNotNull(entityType);
        this.entityType = entityType;
    }

    protected void prepareIdAndVersionPropertyTypes() {
        idPropertyTypes = entityType.getIdPropertyTypes();
        versionPropertyType = entityType.getVersionPropertyType();
    }

    protected void validateIdExistent() {
        if (idPropertyTypes.isEmpty()) {
            throw new JdbcException(Message.DOMA2022, entityType
                    .getName());
        }
    }

    protected void prepareOptions() {
        if (queryTimeout <= 0) {
            queryTimeout = config.getQueryTimeout();
        }
        if (batchSize <= 0) {
            batchSize = config.getBatchSize();
        }
    }

    protected boolean isTargetPropertyName(String name) {
        if (includedPropertyNames.length > 0) {
            for (String includedName : includedPropertyNames) {
                if (includedName.equals(name)) {
                    for (String excludedName : excludedPropertyNames) {
                        if (excludedName.equals(name)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        if (excludedPropertyNames.length > 0) {
            for (String excludedName : excludedPropertyNames) {
                if (excludedName.equals(name)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public void complete() {
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public void setEntities(List<E> entities) {
        assertNotNull(entities);
        this.entities = entities;
        this.sqls = new ArrayList<PreparedSql>(entities.size());
    }

    public void setCallerClassName(String callerClassName) {
        this.callerClassName = callerClassName;
    }

    public void setCallerMethodName(String callerMethodName) {
        this.callerMethodName = callerMethodName;
    }

    public void setQueryTimeout(int queryTimeout) {
        this.queryTimeout = queryTimeout;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public void setIncludedPropertyNames(String... includedPropertyNames) {
        this.includedPropertyNames = includedPropertyNames;
    }

    public void setExcludedPropertyNames(String... excludedPropertyNames) {
        this.excludedPropertyNames = excludedPropertyNames;
    }

    @Override
    public PreparedSql getSql() {
        return sqls.get(0);
    }

    @Override
    public String getClassName() {
        return callerClassName;
    }

    @Override
    public String getMethodName() {
        return callerMethodName;
    }

    @Override
    public List<PreparedSql> getSqls() {
        return sqls;
    }

    @Override
    public Config getConfig() {
        return config;
    }

    @Override
    public boolean isOptimisticLockCheckRequired() {
        return optimisticLockCheckRequired;
    }

    @Override
    public boolean isAutoGeneratedKeysSupported() {
        return autoGeneratedKeysSupported;
    }

    @Override
    public boolean isExecutable() {
        return executable;
    }

    @Override
    public SqlExecutionSkipCause getSqlExecutionSkipCause() {
        return executionSkipCause;
    }

    public int getQueryTimeout() {
        return queryTimeout;
    }

    @Override
    public int getBatchSize() {
        return batchSize;
    }

    @Override
    public String toString() {
        return sqls.toString();
    }

}
