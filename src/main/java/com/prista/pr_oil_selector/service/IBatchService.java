package com.prista.pr_oil_selector.service;

import com.prista.pr_oil_selector.utility.exception.GlobalException;

public interface IBatchService {

    void createDatabaseAndContents(int sheetValue) throws GlobalException;
}
