/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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
import be.yildizgames.engine.feature.city.CityId;
import be.yildizgames.engine.feature.city.Level;
import be.yildizgames.engine.feature.city.building.BaseBuilding;
import be.yildizgames.engine.feature.city.building.Building;
import be.yildizgames.engine.feature.city.building.BuildingPosition;
import be.yildizgames.engine.feature.city.building.BuildingType;
import be.yildizgames.engine.feature.city.building.staff.Staff;
import be.yildizgames.engine.feature.resource.ResourceValue;
import be.yildizgames.engine.feature.resource.bonus.BonusResources;

import java.time.Duration;

/**
 * Client implementation for a building, contains the building itself, but also its visual representation.
 * <p>
 * Mutable class.
 *
 * @author Grégory Van den Borre
 */
public final class ClientBuilding<T, U> implements Building {

    /**
     * Wrapped base building.
     */
    private final BaseBuilding building;

    /**
     * Client data for this building.
     */
    private final ClientBuildingData<T, U> data;

    /**
     * Instantiate a new ClientBuilding.
     *
     * @param id       Id of the city containing this building.
     * @param data     Associated building type data.
     * @param position Position of the building in the city.
     * @param level    Current building level.
     * @param staff    Current staff allocated.
     * @throws NullPointerException     If any parameter is null.
     * @throws IllegalArgumentException If any parameter is not in the bounded values(@see BaseBuilding) for rules.
     */
    public ClientBuilding(CityId id, ClientBuildingData<T, U> data, BuildingPosition position, Level level, Staff staff) {
        super();
        this.building = new BaseBuilding(id, data, position, level, staff);
        this.data = data;
    }

    @Override
    public Level getLevel() {
        return this.building.getLevel();
    }

    @Override
    public void setLevel(final Level buildingLevel) {
        this.building.setLevel(buildingLevel);
    }

    /**
     * Create the visual materialization of this building.
     *
     * @param world    World used to create the materialization.
     * @param position Position of this building.
     */
    public void materialize(final T world, final Point3D position) {
        this.data.getMaterialization().generate(world, position);
    }

    @Override
    public boolean isMaxLevel() {
        return this.building.isMaxLevel();
    }

    @Override
    public Staff getMaxPopulation(final Level level) {
        return this.building.getMaxPopulation(level);
    }

    @Override
    public CityId getCity() {
        return this.building.getCity();
    }

    @Override
    public Staff getStaff() {
        return this.building.getStaff();
    }

    @Override
    public void setStaff(Staff staff) {
        this.building.setStaff(staff);
    }

    @Override
    public BuildingPosition getBuildingPosition() {
        return this.building.getBuildingPosition();
    }

    @Override
    public void setOldStaff() {
        this.building.setOldStaff();
    }

    @Override
    public BuildingType getType() {
        return this.building.getType();
    }

    @Override
    public BonusResources getLevelBonus() {
        return this.building.getLevelBonus();
    }

    @Override
    public BonusResources getStaffBonus() {
        return this.building.getStaffBonus();
    }

    /**
     * @return This building description translation key.
     */
    public TranslationKey getDescriptionKey() {
        return this.data.getDescriptionKey();
    }

    /**
     * @return This building name translation key.
     */
    public TranslationKey getNameKey() {
        return this.data.getNameKey();
    }

    @Override
    public Duration getTimeToBuild(final Level level) {
        return this.building.getTimeToBuild(level);
    }

    @Override
    public boolean exists() {
        return this.building.exists();
    }

    @Override
    public boolean isEmpty() {
        return this.building.isEmpty();
    }

    @Override
    public boolean isBuilder() {
        return this.building.isBuilder();
    }

    /**
     * @return The material to use as icon for this building.
     */
    public U getIcon() {
        return data.getGuiMaterialization().getIcon();
    }

    @Override
    public Duration getNextLevelTimeToBuild() {
        return this.building.getNextLevelTimeToBuild();
    }

    @Override
    public ResourceValue getNextLevelPrice() {
        return this.building.getNextLevelPrice();
    }

    /**
     * @return The translation key for the building next level description.
     */
    public String getNextLevelKey() {
        return this.data.getType().name + ".level." + (this.building.getLevel().add(1));
    }

    @Override
    public Staff getOldStaff() {
        return this.building.getOldStaff();
    }

    public U getBuildingButton() {
        return this.data.getConstructionButton();
    }

    public U getBuildingButtonOver() {
        return this.data.getConstructionButtonOver();
    }
}
