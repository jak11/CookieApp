package com.cookie.app;

import com.cookie.app.service.ActiveCookieByFrequency;
import com.cookie.app.service.ActiveCookieService;
import com.cookie.app.utils.Dataloader;

public class CookieApplication {

  public static void main(String[] args) throws Exception {
    if(args.length < 2){
      throw new IllegalArgumentException("Filename and Date is mandatory arguments");
    }
    Dataloader.loadCookieFrequencyByDate(args[0]); //Generate the data out of file
    ActiveCookieService activeCookieService = new ActiveCookieByFrequency();
    System.out.println("Active cookies for date " + args[1] + " --> " + activeCookieService.getActiveCookie(args[1]));
  }
}
