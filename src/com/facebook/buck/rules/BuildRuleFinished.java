/*
 * Copyright 2012-present Facebook, Inc.
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

package com.facebook.buck.rules;

import com.google.common.base.Objects;

public class BuildRuleFinished extends BuildEvent {

  private final BuildRule buildRule;
  private final BuildRuleStatus status;
  private final CacheResult cacheResult;

  public BuildRuleFinished(BuildRule buildRule,
      BuildRuleStatus status,
      CacheResult cacheResult) {
    this.buildRule = buildRule;
    this.status = status;
    this.cacheResult = cacheResult;
  }

  public BuildRule getBuildRule() {
    return buildRule;
  }

  public CacheResult getCacheResult() {
    return cacheResult;
  }

  public BuildRuleStatus getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return String.format("BuildRuleFinished(%s): %s %s", buildRule, status, cacheResult);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof BuildRuleFinished)) {
      return false;
    }

    BuildRuleFinished finished = (BuildRuleFinished)o;
    return Objects.equal(getBuildRule(), finished.getBuildRule()) &&
        Objects.equal(getStatus(), finished.getStatus()) &&
        Objects.equal(getCacheResult(), finished.getCacheResult());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(buildRule, status, cacheResult);
  }
}
