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
package org.seasar.doma;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.seasar.doma.domain.Wrapper;
import org.seasar.doma.jdbc.entity.BuiltinEntityListener;
import org.seasar.doma.jdbc.entity.EntityListener;

/**
 * テーブルもしくは結果セットを示します。
 * <p>
 * このアノテーションは、トップレベルのインタフェースに指定できます。 注釈されたインタフェースは {@link MappedSuperclass} および
 * {@link Entity} が注釈されたインタフェースのみを拡張できます。
 * <p>
 * インタフェースのメンバメソッドは、 {@link Delegate} で注釈されていない限り、次の制約を満たす必要があります。
 * <ul>
 * <li>パラメータは受け取らない。
 * <li>戻り値の型は {@link Wrapper} の実装クラスである。
 * </ul>
 * 
 * <h5>例:</h5>
 * 
 * <pre>
 * &#064;Entity
 * public interface Employee {
 * 
 *     &#064;Id
 *     &#064;Column(name = &quot;ID&quot;)
 *     IntegerDomain id();
 * 
 *     &#064;Column(name = &quot;EMPLOYEE_NAME&quot;)
 *     StringDomain employeeName();
 * 
 *     &#064;Version
 *     &#064;Column(name = &quot;VERSION&quot;)
 *     IntegerDomain version();
 * }
 * </pre>
 * 
 * <p>
 * {@link Delegate} が注釈されていないメソッドの 戻り値の型がすべて {@link SerializableWrapper}
 * のサブタイプであれば、注釈されたインタフェースの実装は直列化可能です。
 * <p>
 * 注釈されたインタフェースの実装はスレッドセーフであることを要求されません。
 * <p>
 * 
 * @author taedium
 * @see MappedSuperclass
 * @see Table
 * @see Column
 * @see Delegate
 * @see Id
 * @see Transient
 * @see Version
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

    /**
     * リスナーです。
     * <p>
     * 指定しない場合、デフォルトのリスナーが設定されます。 リスナーは、クラスごとに1つだけインスタンス化されます。
     */
    Class<? extends EntityListener<?>> listener() default BuiltinEntityListener.class;

}
