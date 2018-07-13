package com.wl.DAO;

import com.wl.entity.DeskInformation;

/**
 * Created by Vincent on 2018-06-25.
 */
public interface DeskInformationDAO {

    public DeskInformation getByBarcode(String barcode);

    public int save(DeskInformation deskInformation);
}
