package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.Sluch;
import com.ibis.ibisecp2.model.UslList;

import java.util.HashMap;
import java.util.List;

/**
 * Created by danila on 08.08.16.
 */
public interface ServiceRenderedView {

    void showService(List<Sluch> headerList, HashMap<Sluch, List<UslList>> childLis);

    void showParamMu(String lpuName, String sMo, String enp);

    void showError();

}
