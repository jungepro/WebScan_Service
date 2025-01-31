package com.pearadmin.api.common;

import com.pearadmin.common.constant.ControllerConstant;
import com.pearadmin.common.tools.server.CpuInfo;
import com.pearadmin.common.tools.server.SystemUtil;
import com.pearadmin.common.web.base.BaseController;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Describe: 服务器控制器
 *
 */
@RestController
@Api(tags = {"服务监控"})
@RequestMapping(ControllerConstant.API_SYSTEM_PREFIX + "monitor")
public class MonitorController extends BaseController {

    @GetMapping("main")
    public ModelAndView main(Model model) {
        CpuInfo cpu = SystemUtil.getCpu();
        model.addAttribute("cpu", cpu);
        return jumpPage("system/monitor/main");
    }
}
