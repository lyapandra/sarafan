package letscode.sarafan.controller;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a on 7/30/2018.
 */

@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    private List<Map<String,String>> messages = new ArrayList<Map<String,String>>(){{
        add(new HashMap<String,String>() {
            {
                put("id","1");
                put("text","message#1");
            }
        });
        add(new HashMap<String,String>() {{put("id","2");put("text","message#2");}});
        add(new HashMap<String,String>() {{put("id","3");put("text","message#3");}});
    }};

    @GetMapping
    public List<Map<String,String>>  list(){
        return messages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id) throws NotFound {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFound::new);
    }

}
