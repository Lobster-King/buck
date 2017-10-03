/*
 * Copyright 2017-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.toolchain.impl;

import com.facebook.buck.android.toolchain.AndroidToolchain;
import com.facebook.buck.toolchain.BaseToolchainProvider;
import com.facebook.buck.toolchain.Toolchain;
import java.util.HashMap;
import java.util.Map;

public class TestToolchainProvider extends BaseToolchainProvider {
  private final Map<String, Toolchain> toolchains = new HashMap<>();

  @Override
  public Toolchain getByName(String toolchainName) {
    return toolchains.get(toolchainName);
  }

  @Override
  public boolean isToolchainPresent(String toolchainName) {
    return toolchains.containsKey(toolchainName);
  }

  public void addToolchain(String name, Toolchain toolchain) {
    toolchains.put(name, toolchain);
  }

  public void addAndroidToolchain(AndroidToolchain androidToolchain) {
    toolchains.put(AndroidToolchain.DEFAULT_NAME, androidToolchain);
  }
}
