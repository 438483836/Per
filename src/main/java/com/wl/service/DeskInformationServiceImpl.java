package com.wl.service;

import com.wl.DAO.DeskInformationDAO;
import com.wl.entity.DeskInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vincent on 2018-06-25.
 */
@Service("deskInformationService")
@Transactional
public class DeskInformationServiceImpl implements DeskInformationService{

    @Autowired
    private DeskInformationDAO deskInformationDAO;

    public DeskInformation getByBarcode(String barcode) {
        return deskInformationDAO.getByBarcode(barcode);
    }
}
