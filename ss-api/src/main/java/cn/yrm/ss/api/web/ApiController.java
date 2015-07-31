package cn.yrm.ss.api.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import cn.yrm.ss.api.code.EnumMsgCode;
import cn.yrm.ss.api.code.EnumServiceList;
//import cn.yrm.ss.node.domain.BsNode;
//import cn.yrm.ss.node.service.BsNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yrm.ss.api.facade.StationApiFacade;
import cn.yrm.ss.api.facade.UserApiFacade;
import cn.yrm.ss.api.req.ClientRequest;
import cn.yrm.ss.api.rsp.ClientResponse;

import static cn.yrm.ss.api.code.EnumMsgCode.ECOM0001;

@Controller
public class ApiController {

    @Autowired
    private UserApiFacade userApiFacade;
    @Autowired
    private StationApiFacade stationApiFacade;
    //@Autowired
    //private BsNodeService bsNodeService;
    @Autowired
    private MessageSource messageSource;

    /**
     * 登录
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws java.lang.reflect.InvocationTargetException
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    @RequestMapping(value = "/api/{version}")
    @ResponseBody
    public Object execute(HttpServletRequest request, @PathVariable String version, @Valid ClientRequest clientRequest) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

        ClientResponse clientRsp = new ClientResponse();
        if ("v1".equals(version)) {
            String function = clientRequest.getFunction().toLowerCase();
            String[] keys = function.split("\\.");
            Method method = null;
            switch (EnumServiceList.toEnumValue(keys[0])) {
            case USER_SERVICE:
                method = UserApiFacade.class.getMethod(function.replace(".", ""),
                        new Class[] { ClientRequest.class });
                clientRsp = (ClientResponse) method.invoke(userApiFacade, clientRequest);
                break;
            case STATION_SERVICE:
                method = StationApiFacade.class.getMethod(function.replace(".", ""),
                        new Class[] { ClientRequest.class });
                clientRsp = (ClientResponse) method.invoke(stationApiFacade, clientRequest);
                break;
            }
        } else {
            clientRsp.setResult(false);
            clientRsp.setErrorCode(ECOM0001.stringValue());
            clientRsp
                    .setReason(messageSource.getMessage(ECOM0001.stringValue(), null, Locale.getDefault()));
        }
        return clientRsp;
    }
}
