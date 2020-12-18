package com.robert.vesta.sample.embed;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.intf.IdService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class EmbedSample {
    public static void main(String[] args) throws  Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/vesta-service-sample.xml");
       final IdService idService = (IdService) ac.getBean("idService");

       /* long id = idService.genId();
        Id ido = idService.expId(id);
*/
       final Set<Long> set=new HashSet();

       Thread t=new Thread(){
            @Override
            public void run() {
                long id = idService.genId();
                set.add(id);
            }
        };

        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        Thread t3=new Thread(t);

        t.start();
        t1.start();
        t2.start();
        t3.start();

        t.join();
        t1.join();
        t2.join();
        t3.join();

        System.out.println(set.size());


    }
}
