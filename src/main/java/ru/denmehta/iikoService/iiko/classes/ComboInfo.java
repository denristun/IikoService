package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;

public class ComboInfo {

    @NotNull
    private String comboId;

    @NotNull
    private String  comboSourceId;

    @NotNull
    private String comboGroupId;

    public void setComboId(String comboId) {
        this.comboId = comboId;
    }

    public void setComboSourceId(String comboSourceId) {
        this.comboSourceId = comboSourceId;
    }

    public void setComboGroupId(String comboGroupId) {
        this.comboGroupId = comboGroupId;
    }
}
