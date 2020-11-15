package com.ronnie.sys.sysshortcutmenu.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import com.ronnie.sys.sysshortcutmenu.service.SysShortcutMenuService;
import com.ronnie.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/sysShortcutMenu/")
public class SysShortcutMenuController extends CommonController<SysShortcutMenuVo, SysShortcutMenu, String> {
    @Autowired
    private SysShortcutMenuService sysShortcutMenuService;
}
