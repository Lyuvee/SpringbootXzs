package com.mindskip.xzs.event;

import com.mindskip.xzs.domain.Credential;
import org.springframework.context.ApplicationEvent;

/**
 * @author 武汉思维跳跃科技有限公司
 */
public class OnRegistrationCompleteEvent1 extends ApplicationEvent {


    private final Credential credential;


    public OnRegistrationCompleteEvent1(final Credential credential) {
        super(credential);
        this.credential = credential;
    }

    public Credential getCredential() {
        return credential;
    }

}