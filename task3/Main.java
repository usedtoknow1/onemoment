import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {



        String testsPath = args[0];
        String valuesPath = args[1];
        String reportPath = args[2];



        ObjectMapper mapper = new ObjectMapper();
        JsonNode valuesNode = mapper.readTree(new File(valuesPath)).get("values");
        Map<Integer, String> map = new HashMap<>();
        for (JsonNode n : valuesNode) {
            map.put(n.get("id").asInt(), n.get("value").asText());
        }
        JsonNode testsNode = mapper.readTree(new File(testsPath)).get("tests");
        fillValues(testsNode, map);
        ObjectNode report = mapper.createObjectNode();
        report.set("tests", testsNode);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportPath), report);
    }

    static void fillValues(JsonNode node, Map<Integer, String> map) {
        if (node.isArray()) {
            for (JsonNode n : node) fillValues(n, map);
        } else if (node.isObject()) {
            ObjectNode obj = (ObjectNode) node;
            if (obj.has("id")) obj.put("value", map.get(obj.get("id").asInt()));
            if (obj.has("values")) fillValues(obj.get("values"), map);
        }
    }
}