package cn.dface;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by akun on 2017/7/11.
 */
@AllArgsConstructor
@Data
public class Msg {

    private String title;
    private String content;
    private String etraInfo;
}
