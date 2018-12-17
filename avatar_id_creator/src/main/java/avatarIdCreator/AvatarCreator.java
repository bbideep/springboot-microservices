package avatarIdCreator;

//import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@Controller
public class AvatarCreator {

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

  private String getAvatarName() {
    String[] names = {"Aang", "Katara", "Sokka", "Zuko", "Iroh", "Appa", "Momo", "Pasang", "Tashi", "Yue" };
    int randomId = ThreadLocalRandom.current().nextInt(0, 10);
    return names[randomId];
  }
}
