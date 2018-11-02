/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.engine.feature.city.client.building;

import be.yildizgames.common.client.translation.TranslationKey;

/**
 * Materialization for a building in the GUI.
 * Immutable class.
 *
 * @author Grégory Van den Borre
 */
//@specfield nameKey:Key:Translation key for the name.
//@specfield descriptionKey:Translation key for the description.
//@specfield icon:Material:2D representation of the element.
//@specfield constructionButton:ButtonMaterial:GuiButton to display to build the item.
public class ClientBuildingGuiMaterialization<T> {

    /**
     * Translation key for the GUI element name.
     */
    private final TranslationKey nameKey;
    /**
     * Translation key for the GUI element description.
     */
    private final TranslationKey descriptionKey;
    /**
     * Material to use to display the 2D GUI representation.
     */
    private final T icon;

    private final T button;

    private final T buttonHl;

    protected ClientBuildingGuiMaterialization(TranslationKey nameKey, TranslationKey descriptionKey, T icon, T button, T buttonHl) {
        super();
        this.nameKey = nameKey;
        this.descriptionKey = descriptionKey;
        this.icon = icon;
        this.button = button;
        this.buttonHl = buttonHl;
    }

    public final TranslationKey getNameKey() {
        return nameKey;
    }

    public final TranslationKey getDescriptionKey() {
        return descriptionKey;
    }

    public final T getIcon() {
        return icon;
    }

    public final T getButton() {
        return button;
    }

    public final T getButtonHl() {
        return buttonHl;
    }
}
