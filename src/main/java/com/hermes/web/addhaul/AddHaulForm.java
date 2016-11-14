package com.hermes.web.addhaul;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ivan on 14.11.16.
 */
public class AddHaulForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date finishDate;

    @NotNull
    private UUID startPlaceId;

    @NotNull
    private UUID finishPlaceId;

    @NotNull
    private UUID assignedDriverId;

    @NotNull
    private UUID assignedVehicleId;

    @NotNull
    private List<UUID> cargoIdList;

    public AddHaulForm() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public UUID getStartPlaceId() {
        return startPlaceId;
    }

    public void setStartPlaceId(UUID startPlaceId) {
        this.startPlaceId = startPlaceId;
    }

    public UUID getFinishPlaceId() {
        return finishPlaceId;
    }

    public void setFinishPlaceId(UUID finishPlaceId) {
        this.finishPlaceId = finishPlaceId;
    }

    public UUID getAssignedDriverId() {
        return assignedDriverId;
    }

    public void setAssignedDriverId(UUID assignedDriverId) {
        this.assignedDriverId = assignedDriverId;
    }


    public UUID getAssignedVehicleId() {
        return assignedVehicleId;
    }

    public void setAssignedVehicleId(UUID assignedVehicleId) {
        this.assignedVehicleId = assignedVehicleId;
    }

    public List<UUID> getCargoIdList() {
        return cargoIdList;
    }

    public void setCargoIdList(List<UUID> cargoIdList) {
        this.cargoIdList = cargoIdList;
    }
}
