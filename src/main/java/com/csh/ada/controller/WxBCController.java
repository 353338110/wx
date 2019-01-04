package com.csh.ada.controller;

import com.csh.ada.pojo.AdaBC;
import com.csh.ada.pojo.AdaResult;
import com.csh.ada.pojo.EasyUIResult;
import com.csh.ada.service.IBCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bc")
public class WxBCController {

    @Autowired
    private IBCService iBCService;

    @RequestMapping("/create")
    @ResponseBody
    public AdaResult adaCreate(@RequestParam String adaId, @RequestParam int adaCode, String adaName,
                               @RequestParam String adaIp, @RequestParam String adaPort) {
        if (null != adaId && !"".equals(adaId)) {
            if (adaCode != 0) {
                if (null != adaIp && !"".equals(adaIp)) {
                    if (null != adaPort && !"".equals(adaPort)) {
                        log.info("添加" + adaId + "公众号");
                        return iBCService.adaCreate(adaId, adaCode, adaName, adaIp, adaPort);
                    } else {
                        return new AdaResult(0, "服务器端口不能为空");
                    }
                } else {
                    return new AdaResult(0, "服务器地址不能为空");
                }
            } else {
                return new AdaResult(0, "微信公众号code不能为空");
            }
        } else {
            return new AdaResult(0, "微信公众号id不能为空");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AdaResult adaDelete(@RequestParam String adaId) {
        if (null != adaId && !"".equals(adaId)) {
            log.info("删除" + adaId + "公众号");
            return iBCService.adaDelete(adaId);
        } else {
            return new AdaResult(0, "adaId不能为空");
        }

    }

    @RequestMapping("/query")
    @ResponseBody
    public EasyUIResult adaQuery() {
        log.info("查询所有的公众号");
        AdaResult<List<AdaBC>> listAdaResult = iBCService.adaQuery();
        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(listAdaResult.getData().size());
        easyUIResult.setRows(listAdaResult.getData());
        return easyUIResult;
    }

    @RequestMapping("/select")
    @ResponseBody
    public AdaResult adaSelect(@RequestParam String adaId) {
        if (null != adaId && !"".equals(adaId)) {
            log.info("选择" + adaId + "公众号");
            return iBCService.adaSelect(adaId);
        } else {
            return new AdaResult(0, "adaId不能为空");
        }
    }
}
