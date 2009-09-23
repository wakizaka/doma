package org.seasar.doma.internal.apt.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.domain.IntegerWrapper;
import org.seasar.doma.internal.apt.entity.Emp;

@Dao(config = MyConfig.class)
public interface CustomDomainSqlValidationDao {

    @Select
    Emp select(IntegerWrapper id);
}
