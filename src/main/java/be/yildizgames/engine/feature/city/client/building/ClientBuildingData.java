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
import be.yildizgames.common.geometry.Point3D;
import be.yildizgames.engine.feature.city.Instance;
import be.yildizgames.engine.feature.city.Level;
import be.yildizgames.engine.feature.city.building.BuildingData;
import be.yildizgames.engine.feature.city.building.BuildingType;
import be.yildizgames.engine.feature.city.building.staff.Staff;
import be.yildizgames.engine.feature.city.client.ClientBuildingMaterialization;
import be.yildizgames.engine.feature.resource.ResourceValue;
import be.yildizgames.engine.feature.resource.bonus.BonusResources;

import java.time.Duration;

/**
 * Expose Building data and visual materialization.
 *
 * @author Grégory Van den Borre
 */
public class ClientBuildingData<T, U> implements BuildingData {

    /**
     * Common data for the building data.
     */
    private final BuildingData data;

    /**
     * Visual 3D materialisation to be used in the game.
     */
    private final ClientBuildingMaterialization<T> materialization;

    /**
     * Visual 2D materialization to be used in the GUI.
     */
    private final ClientBuildingGuiMaterialization<U> guiMaterialization;

    protected ClientBuildingData(BuildingData data, ClientBuildingMaterialization<T> materialization, ClientBuildingGuiMaterialization<U> guiMaterialization) {
        this.data = data;
        this.materialization = materialization;
        this.guiMaterialization = guiMaterialization;
    }

    /**
     * Generate the visual 3D materialization.
     *
     * @param world    World to build the materialization.
     * @param position Position the the materialization will be located.
     */
    public final void generateModel(final T world, final Point3D position) {
        this.materialization.generate(world, position);
    }

    public final TranslationKey getDescriptionKey() {
        return this.guiMaterialization.getDescriptionKey();
    }

    public final TranslationKey getNameKey() {
        return this.guiMaterialization.getNameKey();
    }

    @Override
    public final Level getMaxLevel() {
        return this.data.getMaxLevel();
    }

    @Override
    public final ResourceValue getPrice(final Level level) {
        return this.data.getPrice(level);
    }

    @Override
    public final BuildingType getType() {
        return this.data.getType();
    }

    @Override
    public final Duration getTimeToBuild(final Level level) {
        return this.data.getTimeToBuild(level);
    }

    @Override
    public final Staff getMaxPopulation(final Level level) {
        return this.data.getMaxPopulation(level);
    }

    @Override
    public final boolean hasRatioBonus() {
        return this.data.hasRatioBonus();
    }

    @Override
    public final ResourceValue getPrice() {
        return this.data.getPrice(Level.ONE);
    }

    @Override
    public final Duration getTimeToBuild() {
        return this.data.getTimeToBuild(Level.ONE);
    }

    public final U getAnimatedIcon() {
        return this.guiMaterialization.getIcon();
    }

    public final U getConstructionButton() {
        return this.guiMaterialization.getButton();
    }

    public final U getConstructionButtonOver() {
        return this.guiMaterialization.getButtonHl();
    }

    @Override
    public final BonusResources getStaffBonus(final Staff staffAllocated) {
        return this.data.getStaffBonus(staffAllocated);
    }

    @Override
    public final BonusResources getLevelBonus(final Level level) {
        return this.data.getLevelBonus(level);
    }

    @Override
    public final boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public final boolean isBuilder() {
        return this.data.isBuilder();
    }

    @Override
    public final boolean isBuildable() {
        return this.data.isBuildable();
    }

    public final Level getRequiredLevel() {
        return Level.ZERO;
    }

    public final Instance getMaxInstances() {
        return Instance.UNIQUE;
    }

    ClientBuildingMaterialization<T> getMaterialization() {
        return materialization;
    }

    ClientBuildingGuiMaterialization<U> getGuiMaterialization() {
        return guiMaterialization;
    }
}
