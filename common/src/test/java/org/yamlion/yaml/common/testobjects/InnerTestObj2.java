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

package org.yamlion.yaml.common.testobjects;

import java.util.Date;
import java.util.List;

public class InnerTestObj2 {

    private String str3;
    private int int3;
    private float float3;
    private boolean boolean3;
    private List<String> stringArray3;
    private Date date3;

    public InnerTestObj2() {
    }

    public String getStr3() {
        return str3;
    }

    public void setStr1(String str3) {
        this.str3 = str3;
    }

    public int getInt3() {
        return int3;
    }

    public void setInt3(int int3) {
        this.int3 = int3;
    }

    public float getFloat3() {
        return float3;
    }

    public void setFloat3(float float3) {
        this.float3 = float3;
    }

    public boolean isBoolean3() {
        return boolean3;
    }

    public void setBoolean3(boolean boolean3) {
        this.boolean3 = boolean3;
    }

    public List<String> getStringArray3() {
        return stringArray3;
    }

    public void setStringArray3(List<String> stringArray3) {
        this.stringArray3 = stringArray3;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }
}
