package test.json;

import cn.sciuridae.controller.bean.JsonData;
import cn.sciuridae.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.time.LocalDateTime;

public class test {

    @Test
    public void jsontest() {
        JsonData jsonData = new JsonData();
        jsonData.setCode(0);
        jsonData.setMsg("aaa");
        jsonData.setData(LocalDateTime.now());
        System.out.println(jsonData);
        try {
            String s = JsonUtils.objectToJsonString(jsonData);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
