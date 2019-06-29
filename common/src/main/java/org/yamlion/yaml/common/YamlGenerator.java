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

import org.yamlion.yaml.common.exceptions.FieldNotMatchingException;

import java.lang.reflect.Field;

public class YamlGenerator {

    public static YamlTreeNode generateObjectMap(Class<?> clazz) throws FieldNotMatchingException {

        YamlTreeNode rootNode = new YamlTreeNode(DataType.OBJECT, clazz.getName());

        for (Field field : clazz.getDeclaredFields()) {
            String name = field.getName();
            System.out.println(name + " " + field.getType().getName());

            if (isYamlPrimitiveType(field.getType())) {
                rootNode.addChildNode(name, new YamlTreeNode(DataType.PRIMITIVE, field.getType().getName()));
            } else if (field.getType().getTypeName().equals(Constants.PrimitiveTypes.LIST)) {
                rootNode.addChildNode(name, new YamlTreeNode(DataType.LIST, extractListTypeClassName(field)));
            } else {
                rootNode.addChildNode(name, generateObjectMap(field.getType()));
            }
        }
        return rootNode;
    }

    public static boolean isYamlPrimitiveType(Class<?> classType) {
        return Constants.PrimitiveTypes.ALL_PRIMITIVES.parallelStream().
                anyMatch(primitiveType -> primitiveType.equals(classType.getName()));
    }

    private static String extractListTypeClassName(Field field) throws FieldNotMatchingException {
        if (!field.getType().getName().equals(Constants.PrimitiveTypes.LIST)) {
            throw new FieldNotMatchingException("Field does not match to java.util.List");
        }
        String fullQualifiedName = field.getGenericType().getTypeName();
        String[] nameSplits = fullQualifiedName.split("<");
        return nameSplits[1].substring(0, nameSplits[1].length() - 1);
    }
}
