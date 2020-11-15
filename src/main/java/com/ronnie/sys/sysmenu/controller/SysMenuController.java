package com.ronnie.sys.sysmenu.controller;

import com.ronnie.annotation.Decrypt;
import com.ronnie.annotation.Encrypt;
import com.ronnie.common.controller.CommonController;
import com.ronnie.common.pojo.Result;
import com.ronnie.sys.sysmenu.pojo.SysMenu;
import com.ronnie.sys.sysmenu.service.SysMenuService;
import com.ronnie.sys.sysmenu.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/sys/sysMenu/")
public class SysMenuController extends CommonController<SysMenuVo, SysMenu, String> {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("menu")
    public ModelAndView menu(){
        return new ModelAndView("sys/menu/menu");
    }

    /**
     * 分层级
     */
    @PostMapping("listByTier")
    @Decrypt
    @Encrypt
    public Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo) {
        return sysMenuService.listByTier(entityVo);
    }
}
