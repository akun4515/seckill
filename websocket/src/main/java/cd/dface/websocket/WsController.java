package cd.dface.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by akun on 2017/7/7.
 */
@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message)throws Exception{
        Thread.sleep(3000);
        return new WiselyResponse("Welcome,"+message.getName()+"!");
    }

}
