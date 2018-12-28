package com.csh.ada.service;

import com.csh.ada.pojo.AdaBC;
import com.csh.ada.pojo.AdaResult;

import java.util.List;

public interface IBCService {
    AdaResult adaCreate(String adaId,int adaCode,String adaToken,String adaName,String adaIp,String adaPort);
    AdaResult adaDelete(String adaId);
    AdaResult<List<AdaBC>> adaQuery();
    AdaResult<AdaBC> adaSelect(String adaId);
    AdaResult<AdaBC> adaChangeUid(String adaId,String adaUid);
}
