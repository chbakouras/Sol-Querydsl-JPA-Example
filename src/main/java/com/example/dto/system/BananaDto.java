package com.example.dto.system;

import com.example.dto.AbstractDto;
import com.example.dto.Reference;

/**
 * @author Chrisostomos Bakouras.
 */
public class BananaDto extends AbstractDto {

    private Double juicy;

    private Reference minion;

    public Double getJuicy() {
        return juicy;
    }

    public void setJuicy(Double juicy) {
        this.juicy = juicy;
    }

    public Reference getMinion() {
        return minion;
    }

    public void setMinion(Reference minion) {
        this.minion = minion;
    }
}
