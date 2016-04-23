package r.finnetrolle.smlr.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

/**
 * This class is developed by maxsyachin on 23.04.16
 * for smlr in version r.finnetrolle.smlr.controller
 * under MIT license
 */

@Controller
@RequestMapping("/{key}")
class RedirectController {

    @RequestMapping()
    fun redirect(@PathVariable("key") key: String, httpServletResponse: HttpServletResponse) {
        if (key.equals("aAbBcCdD")) {
            httpServletResponse.setHeader("Location", "http://www.ya.ru")
            httpServletResponse.status=302
        } else {
            httpServletResponse.status=404
        }
    }

}