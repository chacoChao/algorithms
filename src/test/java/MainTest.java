import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MainTest {
    @Test
    public void Run() {
        System.out.println("hello world 1");
    }

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Model {
        String MemberSerialNo;

        public static String getMemberSerialNo(String t) {
            return t;
        }
    }

    @Test
    public void testList() {
        List<String> list = new LinkedList<>();
        list.add("2121313");
        List<String> thirdIds = list.stream().map(Model::getMemberSerialNo).collect(Collectors.toCollection(LinkedList::new));
        Assert.notNull(thirdIds, "");
    }
}


