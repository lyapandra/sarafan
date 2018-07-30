package letscode.sarafan.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Map<String,String>> messages = new ArrayList<Map<String,String>>(){{
        add(new HashMap<String,String>() {{put("id","1");put("text","message#1");}});
        add(new HashMap<String,String>() {{put("id","2");put("text","message#2");}});
        add(new HashMap<String,String>() {{put("id","3");put("text","message#3");}});
    }};

    /*@GetMapping
    public String list(){
        return "index";
    }*/

    @GetMapping
    public List<Map<String,String>>  list(){
        return messages;
    }


}
