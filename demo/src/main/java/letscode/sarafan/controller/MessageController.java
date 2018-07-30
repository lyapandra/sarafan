package letscode.sarafan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by a on 7/30/2018.
 */

@RestController
@RequestMapping("message")
public class MessageController {
    @GetMapping
    public String list(){
        return "index";
    }
}
