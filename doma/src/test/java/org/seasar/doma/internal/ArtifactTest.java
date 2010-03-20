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
package org.seasar.doma.internal;

import junit.framework.TestCase;

/**
 * @author taedium
 * 
 */
public class ArtifactTest extends TestCase {

    public void testGetName() throws Exception {
        assertEquals("Doma", Artifact.getName());
    }

    public void testGetVersion() throws Exception {
        assertNotNull(Artifact.getVersion());
    }

    public void testValidateVersion() throws Exception {
        Artifact.validateVersion(Artifact.getVersion());
    }

    public void testValidateVersion_conflicted() throws Exception {
        try {
            Artifact.validateVersion("hoge");
            fail();
        } catch (VersionConflictException expected) {
            System.out.println(expected.getMessage());
        }
    }
}
