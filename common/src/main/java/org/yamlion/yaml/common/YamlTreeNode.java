/*
 *
 * Copyright (c) 2019 Irunika Weeraratne
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions: The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 *
 */

package org.yamlion.yaml.common;

import java.util.HashMap;
import java.util.Map;

public class YamlTreeNode {

    private final DataType dataType;
    private final String instanceType;
    private final Map<String, YamlTreeNode> childNodes = new HashMap<>();

    public YamlTreeNode(DataType dataType, String instanceType) {
        this.dataType = dataType;
        this.instanceType = instanceType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void addChildNode(String key, YamlTreeNode childTreeNode) {
        childNodes.put(key, childTreeNode);
    }

    public YamlTreeNode getChildNode(String key) {
        return childNodes.get(key);
    }
}
