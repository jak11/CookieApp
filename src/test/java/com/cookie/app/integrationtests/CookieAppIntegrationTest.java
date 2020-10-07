package com.cookie.app.integrationtests;

import java.util.ArrayList;
import java.util.Arrays;

import com.cookie.app.service.ActiveCookieByFrequency;
import com.cookie.app.service.ActiveCookieService;
import com.cookie.app.utils.Dataloader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CookieAppIntegrationTest {
  @Test
  public void compare_cookie_counts() throws Exception {
    Dataloader.loadCookieFrequencyByDate("src/test/resources/test.csv"); //Generate the data out of file
    ActiveCookieService activeCookieService = new ActiveCookieByFrequency();
    Assertions.assertEquals(Arrays.asList("AtY0laUfhglK3lC7", "SAZuXPGUrfbcn5UA"),activeCookieService.getActiveCookie("2018-12-09"));
    Assertions.assertEquals(new ArrayList<>(),activeCookieService.getActiveCookie("2018-12-08"));
    Assertions.assertEquals(Arrays.asList("cookie1"),activeCookieService.getActiveCookie("2018-12-11"));
    Assertions.assertEquals(Arrays.asList("cookie2"),activeCookieService.getActiveCookie("2018-12-15"));
  }
}
