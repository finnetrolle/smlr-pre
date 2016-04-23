package r.finnetrolle.smlr.controller

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import r.finnetrolle.smlr.SmlrApplication

/**
 * This class is developed by maxsyachin on 23.04.16
 * for smlr in version r.finnetrolle.smlr.controller
 * under MIT license
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(SmlrApplication::class))
@WebAppConfiguration
class RedirectControllerTest {

    @Autowired lateinit var wac: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()
    }

    private val BAD_PATH = "/12345a"
    private val PATH = "/aAbBcCdD"
    private val LOCATION = "http://www.ya.ru"
    private val REDIRECT_CODE = 302
    private val LOCATION_PARAM_NAME = "Location"
    private val BAD_STATUS = 404

    @Test
    fun successQueryMakesRedirect() {
        mockMvc.perform(get(PATH))
                .andExpect(status().`is`(REDIRECT_CODE))
                .andExpect(header().string(LOCATION_PARAM_NAME, LOCATION))
    }

    @Test
    fun inexistingKeyProcides404() {
        mockMvc.perform(get(BAD_PATH))
                .andExpect(status().`is`(BAD_STATUS))
    }
}