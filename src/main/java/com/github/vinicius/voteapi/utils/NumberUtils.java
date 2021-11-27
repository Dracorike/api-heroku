package com.github.vinicius.voteapi.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

  public static double round(double value, int precision) {
    return new BigDecimal(value).setScale(precision, RoundingMode.HALF_UP).doubleValue();
  }

}
