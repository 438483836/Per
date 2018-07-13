package com.wl.service;

import com.wl.entity.DeskInformation;

/**
 * Created by Vincent on 2018-06-25.
 */
public interface DeskInformationService {

    public DeskInformation getByBarcode(String barcode);

    public int save(DeskInformation deskInformation);

}
