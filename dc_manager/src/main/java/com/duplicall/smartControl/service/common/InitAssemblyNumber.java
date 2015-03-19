package com.duplicall.smartControl.service.common;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.service.card.impl.SmartCardImpl;

@Service
public class InitAssemblyNumber implements ApplicationListener<ContextRefreshedEvent> {
    
    /**
     * 初始化，得到smartControl各個板卡的基本類型及相關配置數據
     * Description
     * 
     * @param arg0
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        try {
            new SmartCardImpl().initManagerCard();
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
        
    }
}
