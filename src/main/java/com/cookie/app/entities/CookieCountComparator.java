package com.cookie.app.entities;

import java.util.Comparator;

public class CookieCountComparator implements Comparator<CookieCounter> {
  @Override
  public int compare(CookieCounter o1, CookieCounter o2) {
    if(o1 == null && o2 == null){
      return 0;
    }
    if(o1 == null){
      return -1;
    }
    if(o2 == null){
      return 1;
    }

    if(o1.getCounter().equals(o2.getCounter())){
      return 0;
    }

    return o1.getCounter().get() > o2.getCounter().get()? -1:1;
  }
}
