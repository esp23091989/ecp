package com.ibis.ibisecp2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danila on 29.06.16.
 */
public class SvedMuResponse extends ErrorResponse {
    @SerializedName("SVED_MU")
    @Expose
    private SvedMu svedMu;

    /**
     * @return The sVEDMU
     */
    public SvedMu getSvedMu() {
        return svedMu;
    }

    /**
     * @param sVEDMU The SVED_MU
     */
    public void setSvedMu(SvedMu svedMu) {
        this.svedMu = svedMu;
    }
}
