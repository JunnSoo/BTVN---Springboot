package com.springbootapi.btvnbuoi34.respone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRespone{
    private int code;
    private String message;
    private Object data;
}
