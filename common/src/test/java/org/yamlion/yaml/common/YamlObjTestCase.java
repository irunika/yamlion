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

import org.testng.Assert;
import org.testng.annotations.Test;
import org.yamlion.yaml.common.exceptions.FieldNotMatchingException;
import org.yamlion.yaml.common.testobjects.TestObj;

public class YamlObjTestCase {

    @Test
    public void testYamlObj() throws FieldNotMatchingException {
        YamlTreeNode yamlTreeNode = YamlGenerator.generateObjectMap(TestObj.class);

        // Test level 1
        evaluateString(yamlTreeNode.getChildNode("str1"));
        evaluateInt(yamlTreeNode.getChildNode("int1"));
        evaluateFloat(yamlTreeNode.getChildNode("float1"));
        evaluateBoolean(yamlTreeNode.getChildNode("boolean1"));
        evaluateDate(yamlTreeNode.getChildNode("date1"));
        evaluateList("org.yamlion.yaml.common.testobjects.ListInnerObject",
                yamlTreeNode.getChildNode("innerObjectList"));
    }

    private void evaluateString(YamlTreeNode yamlTreeNode) {
        Assert.assertEquals(yamlTreeNode.getDataType(), DataType.PRIMITIVE);
        Assert.assertEquals(yamlTreeNode.getInstanceType(), Constants.PrimitiveTypes.STRING);
    }

    private void evaluateInt(YamlTreeNode yamlTreeNode) {
        Assert.assertEquals(yamlTreeNode.getDataType(), DataType.PRIMITIVE);
        Assert.assertEquals(yamlTreeNode.getInstanceType(), Constants.PrimitiveTypes.INT);
    }

    private void evaluateFloat(YamlTreeNode yamlTreeNode) {
        Assert.assertEquals(yamlTreeNode.getDataType(), DataType.PRIMITIVE);
        Assert.assertEquals(yamlTreeNode.getInstanceType(), Constants.PrimitiveTypes.FLOAT);
    }

    private void evaluateBoolean(YamlTreeNode yamlTreeNode) {
        Assert.assertEquals(yamlTreeNode.getDataType(), DataType.PRIMITIVE);
        Assert.assertEquals(yamlTreeNode.getInstanceType(), Constants.PrimitiveTypes.BOOLEAN);
    }

    private void evaluateDate(YamlTreeNode yamlTreeNode) {
        Assert.assertEquals(yamlTreeNode.getDataType(), DataType.PRIMITIVE);
        Assert.assertEquals(yamlTreeNode.getInstanceType(), Constants.PrimitiveTypes.DATE);
    }

    private void evaluateList(String instanceTypeName, YamlTreeNode yamlTreeNode) {
        Assert.assertEquals(yamlTreeNode.getDataType(), DataType.LIST);
        Assert.assertEquals(yamlTreeNode.getInstanceType(), instanceTypeName);
    }
}
