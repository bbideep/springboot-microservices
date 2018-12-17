package avatarIdCreator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@Controller
public class AvatarCreator {

  @Value("${avatarNameUri:ZOMBIE_AVATAR}")
  private String uri;
  
  @RequestMapping(value = "/")
  public ModelAndView index() {
    return new ModelAndView("welcome");
  }

  @PostMapping("/genid")
  public ModelAndView getAvatarId() {

    int randomId = ThreadLocalRandom.current().nextInt(100, 1000);
    Map<String, Object> map = new HashMap<>();
    map.put("avatar_id", getAvatarName() + "_" + randomId);
    return new ModelAndView("avatar", map);
  }
  
  private String getAvatarName_ONLY_FOR_LOCAL_VALIDATION() {
    String[] names = {"Aang", "Katara", "Sokka", "Zuko", "Iroh", "Appa", "Momo", "Pasang", "Tashi", "Yue" };
    int randomId = ThreadLocalRandom.current().nextInt(0, 10);
    return names[randomId];
  }
  
  private String getAvatarName() {
    String result = null;
    try {
      RestTemplate restTemplate = new RestTemplate();
      result = restTemplate.getForObject(uri, String.class);
      System.out.println("Result is ::: " + result);
    } catch (java.lang.Exception e) {
      //Ignore this bad coding :)
      if (uri.equals("ZOMBIE_AVATAR")) {
         result = uri;
      }
      System.out.println(e);
    }
    return result;
  }

}
