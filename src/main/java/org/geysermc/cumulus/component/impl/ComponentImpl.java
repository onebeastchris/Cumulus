/*
 * Copyright (c) 2020-2022 GeyserMC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Cumulus
 */
package org.geysermc.cumulus.component.impl;

import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.geysermc.cumulus.component.Component;
import org.geysermc.cumulus.component.util.ComponentType;

public abstract class ComponentImpl implements Component {
  private final ComponentType type;
  private final String text;

  ComponentImpl(@NonNull ComponentType type, @NonNull String text) {
    this.type = Objects.requireNonNull(type, "type");
    this.text = Objects.requireNonNull(text, "text");
  }

  public @NonNull ComponentType type() {
    return type;
  }

  public @NonNull String text() {
    return text;
  }

  // the JVM doesn't allow interface methods to become default methods

  public org.geysermc.cumulus.util.ComponentType getType() {
    return org.geysermc.cumulus.util.ComponentType.values()[type().ordinal()];
  }

  public @NonNull String getText() {
    return text();
  }
}
