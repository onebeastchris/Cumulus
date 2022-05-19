/*
 * Copyright (c) 2020-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Cumulus
 */

package org.geysermc.cumulus;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.geysermc.cumulus.impl.ModalFormImpl;
import org.geysermc.cumulus.response.ModalFormResponse;
import org.geysermc.cumulus.util.FormBuilder;

/**
 * Represents a ModalForm which can be shown to the client. A ModalForm is the most basic form type.
 * It has a title, description and two buttons. For more information and for code examples look at
 * <a href='https://github.com/GeyserMC/Cumulus/wiki'>the wiki</a>.
 *
 * @since 1.0
 */
public interface ModalForm extends Form {
  /**
   * Returns a new ModalForm builder. A more friendly way of creating a form.
   */
  @NonNull
  static Builder builder() {
    return new ModalFormImpl.Builder();
  }

  /**
   * Create a SimpleForm with predefined information.
   *
   * @param title   the title of the form
   * @param content the description of the form
   * @param button1 the first button of the form
   * @param button2 the second button of the form
   * @return the created ModalForm instance
   */
  @NonNull
  static ModalForm of(
      @NonNull String title,
      @NonNull String content,
      @NonNull String button1,
      @NonNull String button2) {
    return new ModalFormImpl(title, content, button1, button2);
  }

  @Override
  @NonNull
  ModalFormResponse parseResponse(@Nullable String response);

  /**
   * An easy way to create a ModalForm. For more information and code examples look at <a
   * href='https://github.com/GeyserMC/Cumulus/wiki'>the wiki</a>.
   */
  interface Builder extends FormBuilder<Builder, ModalForm> {
    /**
     * Set the description of the form.
     *
     * @param content the description of the form
     * @return the form builder
     */
    @NonNull
    Builder content(@NonNull String content);

    /**
     * Set the text of the first button.
     *
     * @param button1 the text of the first button
     * @return the form builder
     */
    @NonNull
    Builder button1(@NonNull String button1);

    /**
     * Set the text of the first button.
     *
     * @param button1   the text of the first button
     * @param shouldAdd if the button should be added
     * @return the form builder
     * @deprecated be aware, this method will behave differently in 1.1
     */
    @Deprecated
    @NonNull
    default Builder optionalButton1(@NonNull String button1, boolean shouldAdd) {
      if (shouldAdd) {
        return button1(button1);
      }
      return this;
    }

    /**
     * Set the text of the second button.
     *
     * @param button2 the text of the second button
     * @return the form builder
     */
    @NonNull
    Builder button2(@NonNull String button2);

    /**
     * Set the text of the second button, but only when shouldAdd is true.
     *
     * @param button2   the text of the second button
     * @param shouldAdd if the button should be added
     * @return the form builder
     * @deprecated be aware, this method will behave differently in 1.1
     */
    @Deprecated
    @NonNull
    default Builder optionalButton2(@NonNull String button2, boolean shouldAdd) {
      if (shouldAdd) {
        return button2(button2);
      }
      return this;
    }
  }
}