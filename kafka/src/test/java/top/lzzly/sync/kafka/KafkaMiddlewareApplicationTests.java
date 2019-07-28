package top.lzzly.sync.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaMiddlewareApplicationTests {

	@Test
	public void contextLoads() {
		JSONObject result = null;
            try {
				String message = "";
                result = JSON.parseObject(message);
            } catch (Exception e) {
                continue;
            }
	}

}
