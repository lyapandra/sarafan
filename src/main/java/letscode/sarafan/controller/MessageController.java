package letscode.sarafan.controller;

import letscode.sarafan.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

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

    private  int counter = 4;

    /*@GetMapping("index")
    public String index(){
        return "index";
    }*/

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
    public Map<String,String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    /*
    * fetch(
  '/message',
  {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ text: 'Fourth message (4)', id: 10 })
  }
).then(result => result.json().then(console.log))*/
    @PostMapping
    public Map<String,String> create(@RequestBody Map<String,String> message){
        message.put("id", String.valueOf(counter++));
        messages.add(message);
        return message;
    }

    /*
    fetch(
  '/message/4',
    {
        method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ text: 'Fourth message', id: 10 })
    }
).then(result => result.json().then(console.log));
*/
    @PutMapping("{id}")
    public Map<String ,String> update(@PathVariable String id, @RequestBody Map<String,String> message){
        Map<String,String> messageFromDb = getMessage(id);
        messageFromDb.putAll(message);
        messageFromDb.put("id", id);

        return messageFromDb;
    }

/*
* fetch('/message/4', { method: 'DELETE' }).then(result => console.log(result))*/
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
//    messages.remove(id);
        Map<String, String> message = getMessage(id);
        messages.remove(message);
    }
}
