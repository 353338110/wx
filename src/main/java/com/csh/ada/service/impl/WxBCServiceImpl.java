package com.csh.ada.service.impl;

import com.csh.ada.dao.AdaBCMapper;
import com.csh.ada.pojo.AdaBC;
import com.csh.ada.pojo.AdaBCExample;
import com.csh.ada.pojo.AdaResult;
import com.csh.ada.service.IBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微信后台配置service
 */
@Service
public class WxBCServiceImpl implements IBCService {

    @Autowired
    private AdaBCMapper adaBCMapper;


    @Override
    public AdaResult adaCreate(String adaId, int adaCode, String adaToken,String adaName,String adaIp,String adaPort) {
        AdaBC adaBC = new AdaBC();
        adaBC.setAdaid(adaId);
        adaBC.setAdacode(adaCode);
        adaBC.setAdatoken(adaToken);
        adaBC.setAdaport(adaPort);
        adaBC.setAdaip(adaIp);
        if (null!=adaName){
            adaBC.setAdaname(adaName);
        }
        //adaBC.setCreatetime(new Date());
        //adaBC.setUpdatetime(new Date());
        int insert = adaBCMapper.insertSelective(adaBC);
        if (insert>0){
            return new AdaResult();
        }else {
            return new AdaResult(0,"增加失败,请重试");
        }

    }

    @Override
    public AdaResult adaDelete(String adaId) {
        int insert = adaBCMapper.deleteByPrimaryKey(adaId);
        if (insert>0){
            return new AdaResult();
        }else {
            return new AdaResult(0,"删除失败,请重试");
        }
    }

    @Override
    public AdaResult<List<AdaBC>> adaQuery() {
        AdaBCExample adaBCExample = new AdaBCExample();
        AdaBCExample.Criteria criteria  = adaBCExample.createCriteria();
        criteria.andAdaidIsNotNull();
        List<AdaBC> adaBCList = adaBCMapper.selectByExample(adaBCExample);
        return new AdaResult<List<AdaBC>>(adaBCList);
    }

    @Override
    public AdaResult<AdaBC> adaSelect(String adaId) {
        AdaBC adaBC = adaBCMapper.selectByPrimaryKey(adaId);
        if (null!=adaBC && null != adaBC.getAdaid() && !"".equals(adaBC.getAdaid())){
            return new AdaResult<AdaBC>(adaBC);
        }else {
            return new AdaResult(0,"查询不到这条记录，请重试");
        }
    }

    @Override
    public AdaResult<AdaBC> adaChangeUid(String adaId, String adaUid) {
        AdaResult<AdaBC> adaResult = adaSelect(adaId);
        if (adaResult.getState()==200){
            adaResult.getData().setAdauid(adaUid);
            //adaResult.getData().setUpdatetime(new Date());
            int result = adaBCMapper.updateByPrimaryKeySelective(adaResult.getData());
            if (result>0){
                return new AdaResult(adaResult.getData());
            }else {
                return new AdaResult(0,"更新uid失败，请重试");
            }
        }else {
            return new AdaResult(0,"查询不到该adaId:"+adaId);
        }

    }
}
