package cd.dface.websocket;

import lombok.Data;

/**
 * Created by akun on 2017/7/7.
 */
@Data
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
