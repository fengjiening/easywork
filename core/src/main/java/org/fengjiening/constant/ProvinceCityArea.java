package org.fengjiening.constant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@Component("pca")
@Slf4j
public class ProvinceCityArea {

    @Value("classpath:static/pca.json")
    private Resource jsonData;



    public Resource getResource(){
        return jsonData;
    }
    class Area{
        String id;
        String text;
        String pid;

        public Area(String id,String text,String pid){
            this.id = id;
            this.text = text;
            this.pid = pid;
        }

        public String getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public String getPid() {
            return pid;
        }
    }
}
