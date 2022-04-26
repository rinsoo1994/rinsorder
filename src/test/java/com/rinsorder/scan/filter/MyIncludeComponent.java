package com.rinsorder.scan.filter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

//?_? TYPE 이면 클래스 레벨에 붙는다?
// 어쨌든 의미는 이게 붙은건 컴포넌트 스캔에 추가할거야~ 라는 의미로 보면 됨
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
