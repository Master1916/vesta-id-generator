package com.robert.sample.client;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.intf.IdService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ClientSample {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/vesta-client-sample.xml");
        IdService idService = (IdService) ac.getBean("idService");

        Set<Long> set=new HashSet();

        for(int i=0;i<1000;i++){
            long id = idService.genId();
            set.add(id);
        }
        System.out.println(set.size());

      // long id = idService.genId();
      //  Id ido = idService.expId(id);

      //  System.out.println(id + ":" + ido);
    }
}
