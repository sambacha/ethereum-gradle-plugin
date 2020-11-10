/*
 * Copyright (c) 2020 41North.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.north.fortyone.gradle.solidity

/**
 * Output components that solc compiler admits.
 */
@Suppress("unused")
enum class OutputComponent {
  AST,
  AST_JSON,
  AST_COMPACT_JSON,
  ASM,
  ASM_JSON,
  OPCODES,
  BIN,
  BIN_RUNTIME,
  CLONE_BIN,
  ABI,
  HASHES,
  USERDOC,
  DEVDOC,
  METADATA;

  override fun toString(): String = name.replace("_", "-").toLowerCase()
}
